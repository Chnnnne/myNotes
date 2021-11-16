package algorithm.数据结构.线段树;


class NumArray {

    int nums[];
    int tree[];
    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[4*nums.length];
        build_tree(0, 0, nums.length-1);
    }
    
    public void build_tree(int node,int start,int end) {
    	if(start == end) {
    		tree[node] = nums[start];
    		return;
    	}
    	
    	int mid=(start+end)/2;
    	int left_node = 2 * node + 1;
    	int right_node = 2 * node + 2;
    	
    	build_tree(left_node, start, mid);
    	build_tree(right_node, mid+1, end);
    	tree[node] = tree[left_node]+tree[right_node];
    }
    
    public void update(int index, int val) {
    	update_tree(0, 0, nums.length-1, index, val);
    }
    void update_tree(int node,int start,int end,int idx ,int val){
    	if(start==end) {
    		nums[idx] = val;
    		tree[node]= val;
    		return;
    	}
    	
		int mid = (start + end)/2;
		int left_node = 2 * node + 1;
		int right_node = 2 * node + 2;
		
		if(idx >= start && idx<= mid) {
			update_tree(left_node, start, mid, idx, val);
		}else {
			update_tree(right_node, mid+1, end, idx, val);
		}
		tree[node]=tree[left_node]+tree[right_node];
    }
    
    public int sumRange(int left, int right) {
    	return query_tree(0, 0, nums.length-1, left, right);
    }
    public int query_tree(int node,int start,int end,int L,int R) {
    	if( R < start || L > end) return 0;
    	if( L <= start && end <= R) return tree[node];
    	if(start == end) return tree[node];
    	
    	int mid = (start + end)/2;
    	int left_node = 2 * node + 1;
    	int right_node = 2 * node + 2;
    	
    	int sum_left = query_tree(left_node, start, mid, L, R);
    	int sum_right = query_tree(right_node, mid+1, end, L, R);
    	return sum_left+sum_right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
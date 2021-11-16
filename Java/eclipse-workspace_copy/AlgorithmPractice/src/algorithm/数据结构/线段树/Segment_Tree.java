package algorithm.数据结构.线段树;

public class Segment_Tree {

	public static final int MAX_LEN = 1000;//
	
	
	static int arr[] = {1,3,5,7,9,11};
	static int size = 6;
	static int tree[] = new int[MAX_LEN];
	
	public static void main(String[] args) {
		build_tree(0, 0, size-1);
		System.out.println("这棵线段树是：");
		for(int i = 0; i < 15; i++) {
			System.out.println("tree["+i+"] = "+tree[i]);
		}
		
		update_tree(0, 0, size-1, 4, 6);
		System.out.println("\n更新之后的线段树：");
		for(int i = 0; i < 15; i++) {
			System.out.println("tree["+i+"] = "+tree[i]);
		}
		
		int ans = query_tree(0, 0, size-1, 2, 5);
		System.out.println(ans);
	}//main	
	
	
	/*
	 * node是当前待建树的根节点，要建立arr的范围是start—end
	 * build_tree 所完成的工作是 完成对node节点的内容填充。
	 */
	static void build_tree(int node,int start,int end) {
		if(start == end) {
			tree[node] = arr[start];
			return;
		}
		
		int mid = (start + end)/2;	//将left_node
		int left_node = 2 * node + 1;//node节点左右孩子的下标
		int right_node = 2 * node + 2;
		
		build_tree(left_node, start, mid);
		build_tree(right_node, mid+1, end);
		tree[node]=tree[left_node]+tree[right_node];
	}
	
	/*
	 * 对于树 node start end 求解区间LR的和
	 */
	static int query_tree(int node,int start,int end,int L,int R) {
		if(R < start || L > end) return 0;
		if(L <= start && R >= end) return tree[node];
		if(start == end) return tree[node];
		
		int mid = (start + end)/2;
		int left_node = 2 * node + 1;
		int right_node = 2 * node + 2;
		
		int sum_left = query_tree(left_node, start, mid, L, R);
		int sum_right = query_tree(right_node, mid+1, end, L, R);
		return sum_left+sum_right;
	}
	
	
	/*
	 * update_tree完成的工作是：对node树，arr[idx]=val
	 */
	static void update_tree(int node, int start, int end, int idx, int val) {
		if(start==end) {
			arr[idx] = val;
			tree[node] = val;
			return;
		}
		
		int mid = (start + end)/2;
		int left_node = 2 * node + 1;
		int right_node = 2 * node + 2;
		
		if(idx >= start && idx <= mid) {
			update_tree(left_node, start, mid, idx, val);
		}else {
			update_tree(right_node, mid+1, end, idx, val);
		}
		tree[node]=tree[left_node]+tree[right_node];
	}
	
	
}

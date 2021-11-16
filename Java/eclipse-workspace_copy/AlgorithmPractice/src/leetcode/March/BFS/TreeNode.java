package leetcode.March.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static void main(String[] args) {
		

	}//main
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	while(!queue.isEmpty()) {
    		TreeNode t;
    		ArrayList<Integer> temp = new ArrayList<Integer>();
//    		temp.clear();
    		int size = queue.size();
    		for(int i=0;i<size;i++) {//出栈当前层每一个
    			t=queue.poll();
    			temp.add(t.val);
    			if(t.left!=null) queue.offer(t.left);
    			if(t.right!=null) queue.offer(t.right);
    		}
    		ans.add(temp);
    	}
    	return ans;
    }
}


package leetcode.March.DFS;

import java.util.ArrayList;
import java.util.List;

public class P0078_子集 {
	static boolean choose[];
	static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		List<List<Integer>> subsets = new P0078_子集().subsets(new int[] {1,2,3});
		for (List<Integer> list : subsets) {
			for(Integer one :list) {
				System.out.print(one+" ");
			}
			System.out.println();
		}

	}//main
	
    public List<List<Integer>> subsets(int[] nums) {
    	ans = new ArrayList<List<Integer>>();
    	choose=new boolean[nums.length];
    	dfs(0,nums);
    	return ans;
    }
    //解空间choose数组(X,X,X,X)
    //choose[i]=true 代表选上第i个数
    //dfs函数 访问新状态的index cur 新增参量
    public static void dfs(int cur, int[] nums) {
    	//非法情况
    	//目标情况
    	if(cur>=choose.length) {
    		ArrayList<Integer> arrayList = new ArrayList<Integer>();
    		for (int i = 0; i < choose.length; i++) {
				if(choose[i])
					arrayList.add(nums[i]);
			}
    		ans.add(arrayList);
    		return;
    	}
    	//合法情况
    	choose[cur]=true;
    	dfs(cur+1,nums);
    	choose[cur]=false;
    	dfs(cur+1,nums);
    }
}

package leetcode.March.并查集;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;


public class P1202_交换字符串中的元素 {
	public static void main(String[] args) {
//		System.out.println(new P1202_交换字符串中的元素().smallestStringWithSwaps("dcab", {{0,3},{1,2{{));

	}//main
	
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    	if(pairs.size()==0) return s;
    	DisjointSet djs = new DisjointSet(s.length());
    	for (List<Integer> list : pairs) {
			int x=list.get(0);
			int y=list.get(1);
			djs.Union(x, y);
		}
    	
    	//得到树之后，建立一个 (根index,字符优先队列) 的HashMap
    	//然后for index, find root ,get(root).append(poll)
    	HashMap<Integer, PriorityQueue<Character>> hm = new HashMap<Integer,PriorityQueue<Character>>();
    	char[] charArray = s.toCharArray();
    	int m = s.length();
    	for(int i=0;i<m;i++) {
    		int root_i = djs.find_root(i);
    		if(hm.containsKey(root_i)) {
    			hm.get(root_i).offer(charArray[i]);
    		}
    		else {
    			PriorityQueue<Character> pq = new PriorityQueue<Character>();
    			pq.offer(charArray[i]);
				hm.put(root_i, pq);
			}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<m;i++) {
    		sb.append(hm.get(djs.find_root(i)).poll());
    	}
    	
    	
    	
    	return sb.toString();
    }
}

class DisjointSet{
    int[] parent;
    int[] rank;
    int n;
    public DisjointSet(int n) {
    	this.n=n;
    	parent=new int[n];
    	rank=new int[n];
    	Arrays.fill(parent, -1);
	}
    
    public boolean Union(int x,int y) {
    	int root_x=find_root(x);
    	int root_y=find_root(y);
    	//同根，说明在一个树中不用合并了
    	if(root_x==root_y) return false;
    	//不同根，说明不在一个树上，不在一个集合里，需要合并
    	if(rank[root_x]>rank[root_y]) {
    		parent[root_y]=root_x;
    	}else if (rank[root_y]>rank[root_x]) {
			parent[root_x]=root_y;
		}else {
			parent[root_x]=root_y;
			rank[root_y]++;
		}
    	
    	return true;
    }

	public int find_root(int x) {
		int temp=x;
		while(parent[temp]!=-1) {
			temp=parent[temp];
		}
		return temp;
	}
}

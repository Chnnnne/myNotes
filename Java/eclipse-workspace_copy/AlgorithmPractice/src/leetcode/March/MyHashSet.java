package leetcode.March;

import java.util.Arrays;

class MyHashSet {

	int []hashlist;
	
	//哈希函数
	private int H(int value) {
		int address=value;
		return address%10000;
	}
	//冲突处理函数
	private int Hi(int address,int i) {
		int newAddress=(address+i)%10000;
		return newAddress;
	}
    /** Initialize your data structure here. */
    public MyHashSet() {
    	hashlist=new int[10000];
    	Arrays.fill(hashlist,-1);
    }
    
    public void add(int key) {
    	int i=1;
    	int newAddr=H(key);
    	while(hashlist[newAddr]!=-1) {
    		newAddr=Hi(newAddr, i++);
    	}
    	hashlist[newAddr]=key;
    }
    
    public void remove(int key) {
    	int i=1;
    	int newAddr=H(key);
    	while(hashlist[newAddr]!=key) {
    		newAddr=Hi(newAddr, i++);
    	}
    	hashlist[newAddr]=-1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	int i=1;
    	int newAddr=H(key);
    	while(hashlist[newAddr]!=-1) {
    		if(hashlist[newAddr]==key)
    			return true;
    		newAddr=Hi(newAddr, i++);
    	}
    	return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

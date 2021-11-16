package leetcode.March;

import java.util.ArrayList;
import java.util.List;

public class P0054_螺旋矩阵 {
	public static void main(String[] args) {
		

	}//main
	
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	int row=matrix.length;
    	int col=matrix[0].length;
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	int updown=row-1;
    	int leftright=col;
    	boolean flag=true;
    	int nowI=0;
    	int nowJ=0;
    	while(true) {
    		//右，下，左，上   左右的时候终止
    		//右
    		for(int i=1;i<=leftright;i++) {
    			al.add(matrix[nowI][nowJ++]);
    		}
    		nowJ--;
    		nowI++;
    		leftright--;
    		if(updown<=0) break;
    		//下
    		for(int i=1;i<=updown;i++) {
    			al.add(matrix[nowI++][nowJ]);
    		}
    		nowI--;
    		nowJ--;
    		updown--;
    		if(leftright<=0) break;
    		
    		//左
    		for(int i=1;i<=leftright;i++) {
    			al.add(matrix[nowI][nowJ--]);
    		}
    		nowJ++;
    		nowI--;
    		leftright--;
    		if(updown<=0) break;
    		//上
    		for(int i=1;i<=updown;i++) {
    			al.add(matrix[nowI--][nowJ]);
    		}
    		nowI++;
    		nowJ++;
    		updown--;
    		if(leftright<=0) break;
    	}
    	
    	return al;
    }
}

package leetcode.March;

import java.util.ArrayList;

public class P0059_螺旋矩阵二 {
	public static void main(String[] args) {
		

	}//main
	
	
    public int[][] generateMatrix(int n) {
    	int matrix[][]=new int[n][n];
    	int row=n;
    	int col=n;
    	int updown=row-1;
    	int leftright=col;
    	int nowI=0;
    	int nowJ=0;
    	int num=1;
    	while(true) {
    		//右
    		for(int i=1;i<=leftright;i++) {
    			matrix[nowI][nowJ++]=num++;
    		}
    		nowJ--;
    		nowI++;
    		leftright--;
    		if(updown<=0) break;
    		
    		//下
    		for(int i=1;i<=updown;i++) {
    			matrix[nowI++][nowJ]=num++;
    		}
    		nowI--;
    		nowJ--;
    		updown--;
    		if(leftright<=0) break;
    		
    		//左
    		for(int i=1;i<=leftright;i++) {
    			matrix[nowI][nowJ--]=num++;
    		}
    		nowJ++;
    		nowI--;
    		leftright--;
    		if(updown<=0) break;
    		//上
    		for(int i=1;i<=updown;i++) {
    			matrix[nowI--][nowJ]=num++;
    		}
    		nowI++;
    		nowJ++;
    		updown--;
    		if(leftright<=0) break;
    	}
    	
    	
    	return matrix;
    }
}

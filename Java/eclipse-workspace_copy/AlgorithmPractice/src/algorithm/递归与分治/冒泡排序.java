package algorithm.递归与分治;

import java.util.Arrays;

/*
 * 每次循环是对未有序序列通过两两比较(两两交换)的方式，把最大的元素对换到最末端
 * 也即每次循环上浮一个
 * 共需(n-1)次循环
 */
public class 冒泡排序 {
	public static void main(String[] args) {
		//所有index从1开始
		int arr[]=new int[] {0,1,9,2,8,3,7,4,6,5};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

	}//main
	public static void bubbleSort(int []arr) {
		int len=arr.length-1;
		for (int i = 1; i <= len-1; i++) {
			for(int j=1;j<=len-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}//method
}//class

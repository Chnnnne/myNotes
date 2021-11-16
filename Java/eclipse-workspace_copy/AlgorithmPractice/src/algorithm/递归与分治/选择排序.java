package algorithm.递归与分治;

import java.util.Arrays;

/*
 * 每次循环，从未排序的序列中不断比较得到最小元素，
 * 然后放在第一个位置上（已排序序列的末尾）,直到无序序列为空
 * 共需要n-1次循环
 */
public class 选择排序 {
	public static void main(String[] args) {
		int arr[]= {7,6,4,9,2,3,8,1,5};
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}//main
	public static void selectSort(int []arr) {
		int len=arr.length;
		for (int i = 0; i < len-1; i++) {
			int minIndex=i;
			for(int j=i+1;j<len;j++) {
				if (arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
			
		}
	}
}

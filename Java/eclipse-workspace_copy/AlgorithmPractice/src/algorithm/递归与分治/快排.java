package algorithm.递归与分治;

import java.util.Arrays;

/*
快速排序   T(n)=O(nlogn)        
核心思想：不断地寻找枢轴，让左右有序 
*/ 
public class 快排 {
	public static void main(String[] args) {
		int a[]= {1,9,2,8,3,7,4,6,5};
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, 8);
		System.out.println(Arrays.toString(a));

	}//main
	
	public static void quickSort(int arr[],int low,int high) {
		if(high>low) {
			int pivotkeyIndex=Partition(arr, low, high);
			quickSort(arr, low, pivotkeyIndex-1);
			quickSort(arr, pivotkeyIndex+1,high );
		}
		
	}
	public static int Partition(int arr[],int low,int high) {
		int pivotkey=arr[low];
		while(high>low) {
			while(high>low&&arr[high]>=pivotkey) high--;
			arr[low]=arr[high];
			while(high>low&&arr[low]<=pivotkey) low++;
			arr[high]=arr[low];
		}
		arr[low]=pivotkey;
		return low;
	}
	
}

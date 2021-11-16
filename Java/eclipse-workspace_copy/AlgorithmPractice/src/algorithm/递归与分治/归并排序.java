package algorithm.递归与分治;

import java.util.Arrays;

/**
归并排序   T(n)=O(nlogn)        
核心思想：不断地合并两个已经有序的子序列成一个新的有序的序列，直到整体有序 
*/ 
public class 归并排序 {
	public static void main(String[] args) {
		int arr[] ={1,9,2,8,3,7,4,6,5};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, 8);
		System.out.println(Arrays.toString(arr));
	}//main
	
/*
 * 将两个有序序列合并成一个有序序列	 
 */
	public static void mergeArray(int arr[],int first,int mid,int last) {
		int temp[]=new int[1000];
		int i=first,m=mid;	//i索引前一个序列
		int j=mid+1,n=last;	//j索引后一个序列
		int k=0;			//k索引temp数组
		while(i<=m&&j<=n) {
			if(arr[i]>=arr[j])
				temp[k++]=arr[j++];
			else
				temp[k++]=arr[i++];
		}
		while(i<=m) {
			temp[k++]=arr[i++];
		}
		while(j<=n) {
			temp[k++]=arr[j++];
		}
		for (int w = 0; w < k; w++) {
			arr[first+w]=temp[w];
		}
		
	}
	/*
	 * 对一个数组进行归并排序
	 */
	public static void mergeSort(int arr[],int first,int last) {
		if(last>first) {
			int mid=(first+last)/2;//和为偶数，mid为中间;  和为奇数,mid为中间前一个
			mergeSort(arr, first, mid);
			mergeSort(arr, mid+1, last);
			mergeArray(arr, first, mid, last);
		}
	}
	
}

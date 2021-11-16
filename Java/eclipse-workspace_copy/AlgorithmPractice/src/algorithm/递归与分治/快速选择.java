package algorithm.递归与分治;

import java.util.Arrays;

public class 快速选择 {
	public static void main(String[] args) {
		int arr[]= {1,9,2,8,3,7,4,6,5};
		System.out.println("第3大的元素是"+quickSelect(arr, 0, 8, 3));
		System.out.println("快选之后的数组是: "+Arrays.toString(arr));

	}//main
	
	//在arr[l...r]中，找出并返回第k大的元素
	public static int quickSelect(int arr[],int l,int r,int k) {
		if(l==r&&k==1) return arr[l];
		int pivotkeyIndex=Partition(arr, l, r);
		int num=pivotkeyIndex-l+1;//包括枢轴在内的前段共有num个元素
		if(num==k) return arr[k];
		if(num>k) return quickSelect(arr, l, pivotkeyIndex-1, k);
		return quickSelect(arr, pivotkeyIndex+1, r, k-num);
	}
	
	public static int Partition(int []arr,int l,int r) {
		int pivotkey=arr[l];
		while(l<r) {
			while(l<r&&arr[r]>=pivotkey) r--;
			arr[l]=arr[r];
			while(l<r&&arr[l]<=pivotkey) l++;
			arr[r]=arr[l];
		}
		arr[l]=pivotkey;
		return l;
	}
	
}

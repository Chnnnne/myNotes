package leetcode.February;


public class P0004_寻找两个有序数组中的中位数 {
	public static void main(String[] args) {
		System.out.println(new P0004_寻找两个有序数组中的中位数().
				findMedianSortedArrays(new int[] {},new int[] {1}));

	}//main
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len=nums1.length+nums2.length;
		int temp[]=new int[len];
		int i1=0,i2=0,i=0;
		while(i1<nums1.length&&i2<nums2.length) {
			if(nums1[i1]<nums2[i2])
				temp[i++]=nums1[i1++];
			else
				temp[i++]=nums2[i2++];
		}
		while(i1<nums1.length) {
			temp[i++]=nums1[i1++];
		}
		while(i2<nums2.length) {
			temp[i++]=nums2[i2++];
		}
		
		return ((len)&1)==1? temp[len/2]: (double)(temp[len/2]+temp[len/2-1])/2;
    }
}

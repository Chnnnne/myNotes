/**
线性选择    O(n)     快速找出无序序列中 第k大的元素
快速选择的总体思路与快速排序一致，选择一个元素作为基准来对元素进行分区，
将小于和大于基准的元素分在基准左边和右边的两个区域。
不同的是，快速选择并不递归访问双边，而是只递归进入一边的元素中继续寻找。
这降低了平均时间复杂度，从O(n log n)至O(n)，不过最坏情况仍然是O(n2)。
*/ 
#include<stdio.h>

void Swap(int &a,int &b)
{
	int temp;
	temp=a;
	a=b;
	b=temp;
}


int Partition(int *a,int low,int high) 
{
	int pivotkey=a[low];  //pivotkey是枢轴的值，并非枢轴的索引值    注意只能这样写，不能乱选枢轴 
	
//	int pivotkey=a[high];
//	Swap(a[high],a[low]);//			若用这个，会进入死循环，假如剩最后两个1，2 选二作为枢纽，
// 2,1这样快排的话，成1,2，num=2，进入死循环 
	
	while(low<high)
	{
		while(low<high&&a[high]>=pivotkey) --high;
		a[low]=a[high];
		
		while(low<high&&a[low]<=pivotkey) ++low;
		a[high]=a[low];
	}

	a[low]=pivotkey;
	return low; ;  //此时返回枢轴的索引值 
}
 


//返回a数组上第k小的数 
int Select(int *a,int p,int r,int k)
{  		  
	if(p==r) 
	return a[p];	
	
  	int pivotkeyIndex=Partition(a,p,r);  
  	int num=pivotkeyIndex-p+1;       //统计前段元素的个数（包括枢轴） 
  	
  	if(num==k)
  	return a[p+num-1];
  	
    if (k<=num)          
	return  Select(a,p,pivotkeyIndex,k);
	
    else                  
	return  Select(a,pivotkeyIndex+1,r,k-num); 
}



int main()
{
	int a[]={9,8,7,6,5,4,3,2,1};
	printf("%d",Select(a,0,8,5));
	return 0;
}

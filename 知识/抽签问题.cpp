#include<stdio.h>
#define MAX_N 100

// 从n个数，抽出4个（可重复） 判断是否可以满足和为m 
/*
 形式化等价于： 	已知一个数组k ,是否存在一个4维向量（x1，x2，x3，x4）
 					使得  k[x1]+k[x2]+k[x3]+k[x4]=m  (x1 x2 可重复)
*/ 




int main()
{
	bool binary_search(int x,int *k,int n);//函数声明 
	int n,m,k[MAX_N];
	bool flag=false;
	scanf("%d%d",&n,&m);
	
	
	for(int i=0;i<n;i++)
	scanf("%d",&k[i]);//依次输入这n个数 
	
//			法1： T(n)=O(n^4)
//	for(int i=0;i<n;i++)
//		for(int j=0;j<n;j++)
//			for(int t=0;t<n;t++)
//				for(int r=0;r<n;r++)
//				{
//					if(k[i]+k[j]+k[t]+k[r]==m)
//					{
//						flag=true;
//					}
//				}
	
	
//			法2：	T(n)=O(n^3*logn)    //二分 logn , 排序 O(nlogn) 
// sort(k,k+n); 
//	for(int i=0;i<n;i++)
//		for(int j=0;j<n;j++)
//			for(int t=0;t<n;t++)
//			{
//				if(binary_search(m-k[i]-k[j]-k[t],k,n))   // 
//				flag=true;
//			}


//			法3：	T(n)=O(n^2*logn)
// sort(k,k+n); 
//	int kk[MAX_N*MAX_N];
//	int w=0;
//	for(int i=0;i<n;i++)
//		for(int j=0;j<n;j++)
//		{
//			kk[w++]=k[i]+k[j];
//		} 
//	
//	for(int i=0;i<n;i++)
//		for(int j=0;j<n;j++)
//		{
//			if(binary_search(m-k[i]-k[j],kk,n*n))
//			flag=true;
//		}




//			法4：	T(n)=O(n^2)
//哈希法？   思考： 二分查找法是在数组中以二分地方式寻找数组是否存在一个数
//					而数字-下标记录法（我自己起的名字） 是借助哈希表（需要额外自己建立的）和
//					哈希函数（这里是数字直接对应下标，也即哈希函数是f(x)=x，）直接找到了该数是否存在 

//	bool sum_2[MAX_N*2];
//	memset(sum_2,0,sizeof(sum_2))
//	for(int i=0;i<n;i++)
//		for(int j=0;j<n;j++)
//		{
//			sum_2[k[i]+k[j]]=true;
//		} 
//	
//	for(int i=0;i<n;i++)
//		for(int j=0;j<n;j++)
//		{
//			if(sum_2[m-k[i]-k[j]])
//			flag=true;
//		}


	
	printf("%d",flag);
	return 0;
}


//二分法 在k数组（长度为n）中查找x， (注意前提是数组有序)
bool binary_search(int x,int *k,int n)
{
	int front=0,back=n-1;
	int mid=(front+back)/2;
	while(back>front)
	{
		if(k[mid]==x)
			return true;
		if(k[mid]>x)
			back=mid-1;
		else
			front=mid+1;
		
		mid=(front+back)/2;
		
	}
	return false;  //找到时会在while中return ，出while则没找到 
	
}	

#include<stdio.h>

int L,M,N;
int n[50003];

bool check(int x)
{
    int ans=0,t=0;//ans为拿走的石头数量，t为上一块石头的位置
    for(int i=1;i<=N;i++)
    {
        while(n[i]-t<x&&i<=N)//如果两块石头的间距小于最小距离，就把这块石头移走，更新后面一块石头的位置
        ans++,i++;

        t=n[i];//更新前一块石头的位置
     } 
     return ans<=M;
}

bool judge(int mid)
{
	int count=0;
	for(int i=1;i<=N;i++)
	{	
		if(n[i]-n[i-1]<mid&&count>=M)
		return false;
		
		else if(n[i]-n[i-1]<mid)
		{
			count++;
			n[i]=n[i-1];
		}
		
	}
	if(n[N+1]-n[N]>=mid)
	return true;
	
	if(count>=M)
	return false;
	
}


int main()
{

	scanf("%d%d%d",&L,&N,&M);
	for(int i=1;i<=N;i++)
	{
		scanf("%d",&n[i]);
	}
	n[N+1]=L;
	int l=1,r=L;
	
	while(l<=r)
	{
		int mid=(r+l)>>1;
		if(check(mid))
		l=mid+1;
		else
		r=mid-1;
	}
	
	printf("%d",r);
	
	return 0;
}
















//int Index;
//int n[50003];
//int dis[50003];//dis[i]表示第i块石头距离前面第i-1块石头的距离 
//void Swap(int &a,int &b)
//{
//	int temp;
//	temp=a;
//	a=b;
//	b=temp;
//}
//
//
//int Partition(int *a,int low,int high) 
//{
//	int pivotkey=a[low];  //pivotkey是枢轴的值，并非枢轴的索引值    注意只能这样写，不能乱选枢轴 
//	
////	int pivotkey=a[high];
////	Swap(a[high],a[low]);//			若用这个，会进入死循环，假如剩最后两个1，2 选二作为枢纽， 2,1这样快排的话，成1,2，num=2，进入死循环 
//	
//	while(low<high)
//	{
//		while(low<high&&a[high]>=pivotkey) --high;
//		a[low]=a[high];
//		
//		while(low<high&&a[low]<=pivotkey) ++low;
//		a[high]=a[low];
//	}
//
//	a[low]=pivotkey;
//	return low; ;  //此时返回枢轴的索引值 
//}
// 
//
//
////返回a数组上第k小的数 
//int Select(int *a,int p,int r,int k)
//{  		  
//	if(p==r) 
//	{
//		Index=p;
//		return a[p];
//	}
//		
//	
//  	int pivotkeyIndex=Partition(a,p,r);  
//  	int num=pivotkeyIndex-p+1;       //统计前段元素的个数（包括枢轴） 
//  	
//    if (k<=num)          
//	return  Select(a,p,pivotkeyIndex,k);
//	
//    else                  
//	return  Select(a,pivotkeyIndex+1,r,k-num); 
//}
//
//
//int main()
//{
//	int L,M,N;
//	scanf("%d%d%d",&L,&N,&M);
//	for(int i=1;i<=N;i++)
//	{
//		scanf("%d",&n[i]);
//		dis[i]=n[i]-n[i-1]; 
//	}
//	n[N+1]=L;
//	dis[N+1]=L-n[N];
//	for(int i=1;i<=M;i++)
//	{
//		int num=Select(dis,1,N+1,1);
//		if(Index!=N+1)
//		{
//		dis[Index+1]+=dis[Index];
//		dis[Index]=2000000000; 
//		}
//		else
//		{
//			dis[N+1]+=dis[N];
//			dis[N]=2000000000;
//		 } 
//
//	}
//	printf("%d",Select(dis,1,N+1,1));
//	
//	
//}

#include<stdio.h>

int L,M,N;
int n[50003];

bool check(int x)
{
    int ans=0,t=0;//ansΪ���ߵ�ʯͷ������tΪ��һ��ʯͷ��λ��
    for(int i=1;i<=N;i++)
    {
        while(n[i]-t<x&&i<=N)//�������ʯͷ�ļ��С����С���룬�Ͱ����ʯͷ���ߣ����º���һ��ʯͷ��λ��
        ans++,i++;

        t=n[i];//����ǰһ��ʯͷ��λ��
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
//int dis[50003];//dis[i]��ʾ��i��ʯͷ����ǰ���i-1��ʯͷ�ľ��� 
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
//	int pivotkey=a[low];  //pivotkey�������ֵ���������������ֵ    ע��ֻ������д��������ѡ���� 
//	
////	int pivotkey=a[high];
////	Swap(a[high],a[low]);//			����������������ѭ��������ʣ�������1��2 ѡ����Ϊ��Ŧ�� 2,1�������ŵĻ�����1,2��num=2��������ѭ�� 
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
//	return low; ;  //��ʱ�������������ֵ 
//}
// 
//
//
////����a�����ϵ�kС���� 
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
//  	int num=pivotkeyIndex-p+1;       //ͳ��ǰ��Ԫ�صĸ������������ᣩ 
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

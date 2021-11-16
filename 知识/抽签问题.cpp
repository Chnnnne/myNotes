#include<stdio.h>
#define MAX_N 100

// ��n���������4�������ظ��� �ж��Ƿ���������Ϊm 
/*
 ��ʽ���ȼ��ڣ� 	��֪һ������k ,�Ƿ����һ��4ά������x1��x2��x3��x4��
 					ʹ��  k[x1]+k[x2]+k[x3]+k[x4]=m  (x1 x2 ���ظ�)
*/ 




int main()
{
	bool binary_search(int x,int *k,int n);//�������� 
	int n,m,k[MAX_N];
	bool flag=false;
	scanf("%d%d",&n,&m);
	
	
	for(int i=0;i<n;i++)
	scanf("%d",&k[i]);//����������n���� 
	
//			��1�� T(n)=O(n^4)
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
	
	
//			��2��	T(n)=O(n^3*logn)    //���� logn , ���� O(nlogn) 
// sort(k,k+n); 
//	for(int i=0;i<n;i++)
//		for(int j=0;j<n;j++)
//			for(int t=0;t<n;t++)
//			{
//				if(binary_search(m-k[i]-k[j]-k[t],k,n))   // 
//				flag=true;
//			}


//			��3��	T(n)=O(n^2*logn)
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




//			��4��	T(n)=O(n^2)
//��ϣ����   ˼���� ���ֲ��ҷ������������Զ��ֵط�ʽѰ�������Ƿ����һ����
//					������-�±��¼�������Լ�������֣� �ǽ�����ϣ����Ҫ�����Լ������ģ���
//					��ϣ����������������ֱ�Ӷ�Ӧ�±꣬Ҳ����ϣ������f(x)=x����ֱ���ҵ��˸����Ƿ���� 

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


//���ַ� ��k���飨����Ϊn���в���x�� (ע��ǰ������������)
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
	return false;  //�ҵ�ʱ����while��return ����while��û�ҵ� 
	
}	

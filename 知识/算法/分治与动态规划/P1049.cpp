#include<stdio.h>
int fac[32][20003]; 	//fac[i][j]ֵ�������� ǰi����Ʒ���ز�����j������ֵ 


int max(int x,int y)
{
	if(x>y) return x;
	return y;
}



int main()
{
	int V,n;
	scanf("%d%d",&V,&n);
	int v[32]; 		//v[i]����������Ǽ۸� 
	for(int i=1;i<=n;i++)
	{
		scanf("%d",&v[i]);
	}
	
	
//	for(int j=0;j<=V;j++)
//	fac[0][j]=0; 
 
	for(int i=1;i<=n;i++)
		for(int j=0;j<=V;j++)
		{
			if(v[i]>j)
			fac[i][j]=fac[i-1][j];
			else
			fac[i][j]=max(fac[i-1][j],fac[i-1][j-v[i]]+v[i]);
		}
	
	printf("%d",V-fac[n][V]);



	return 0;
}





















//int main()
//{
//	int w[32],s[32];  //s[i]Ϊ  �ӵ�i�����ӿ�ʼ��ʣ�����������Сֵ 
//	int n,Tweight;
//	scanf("%d%d",&Tweight,&n);
//	for(int i=0;i<n;i++)
//	{
//		scanf("%d",&w[i]);
//	}
//	
//	s[n]=Tweight;
//	for(int i=n-1;i>=0;i--)
//	{
//		if(w[i]<=s[i+1])
//		s[i]=s[i+1]-w[i];
//		else
//		s[i]=s[i+1];
//	}
//		
//	printf("%d",s[0]);
//}

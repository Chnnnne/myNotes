#include<stdio.h>
int fac[32][20003]; 	//fac[i][j]值的意义是 前i个物品总重不超过j的最大价值 


int max(int x,int y)
{
	if(x>y) return x;
	return y;
}



int main()
{
	int V,n;
	scanf("%d%d",&V,&n);
	int v[32]; 		//v[i]既是体积又是价格 
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
//	int w[32],s[32];  //s[i]为  从第i个箱子开始，剩余的容量的最小值 
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

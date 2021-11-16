#include<stdio.h>

int max(int x,int y)
{
	if(x>y)
	return x;
	return y;
 } 

int fac[26][30002]; // 	fac[i][j] 的值表示 从第i个物品开始，选出价值总和不能超过j的 价*度总和最大值 
int main()
{
	int N,m;
	scanf("%d%d",&N,&m); // N总钱数 	m物品个数 
	int v[30],w[30];// v钱数      w重要度
	for(int i=0;i<m;i++)
	{
		scanf("%d%d",&v[i],&w[i]);
	 } 
	
	
//	for(int j=0;j<=N;j++)
//	fac[m][j]=0;		默认为0，可省略 

	for(int i=m-1;i>=0;i--)
		for(int j=0;j<=N;j++)
		{
			if(v[i]>j)
			fac[i][j]=fac[i+1][j];
			else
			fac[i][j]=max(fac[i+1][j],fac[i+1][j-v[i]]+v[i]*w[i]); 
		 } 
	 
	 printf("%d\n",fac[0][N]);
	
	
	
	return 0;
}

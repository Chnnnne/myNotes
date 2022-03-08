#include<stdio.h>

int max(int x,int y)
{
	if(x>y)	return x;
	return y;
}



int main()
{
	int N;
	scanf("%d",&N);
	int tri[110][110];
	for(int i=0;i<N;i++) 
		for(int j=0;j<=i;j++)
		{
			scanf("%d",&tri[i][j]);	
		}
		
			
	int fac[110][110];//  fac[i][j]中的值是 第从第i行第j列往下走 的最大值
	for(int j=0;j<N;j++)
		fac[N-1][j]=tri[N-1][j];
	
	for(int i=N-2;i>=0;i--)
		for(int j=0;j<=i;j++)
		{
			fac[i][j]=max(fac[i+1][j],fac[i+1][j+1])+tri[i][j];
		}
	
	printf("%d",fac[0][0]);
	return 0;
}

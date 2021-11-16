#include<stdio.h>
#include<stdlib.h>

const int maxn=100;

struct mat{
	int m[maxn][maxn];
	int x,y;   //x行 y列 
};

mat N_mat_mul(mat a,mat b)
{
	if(a.y!=b.x)
	{
		printf("不符合矩阵乘法的规则！\n");
		exit(0);
	}
	
	mat res;
	res.x=a.x;
	res.y=b.y;
	
	for(int i=0;i<res.x;i++)
		for(int j=0;j<res.y;j++)
		{
			int sum=0;
			for(int k=0;k<a.y;k++)
			sum+=a.m[i][k]*b.m[k][j];
			
			res.m[i][j]=sum;
		}
	return res;
}



int main()
{
	mat a,b;
	a.x=a.y=b.x=b.y=3;
	for(int i=0;i<3;i++)
		a.m[i][i]=b.m[i][i]=1; 
	
	mat c=N_mat_mul(a,b);
	for(int i=0;i<3;i++)
		for(int j=0;j<3;j++)
		{
			if(j+1==3)
			printf("%d\n",c.m[i][j]);
			else
			printf("%d ",c.m[i][j]); 
		}
	
	return 0;
 } 

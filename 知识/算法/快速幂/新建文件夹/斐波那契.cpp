#include<bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
const int maxn=5;	
const int MOD=998244353;
#define mod(x) ((x)%MOD) 

	
struct mat{
	int row,col;
	ull m[maxn+2][maxn+2];
};

mat unit;
void init_unit(int n)
{
	unit.col=n;
	unit.row=n;
	for(int i=1;i<=n;i++)
		unit.m[i][i]=1;
}

mat operator *(mat &a,mat &b)
{
	if(a.col!=b.row)
	{
		cout<<"错误：不满足矩阵乘法规则";
		exit(0);
	}
	
	mat res;
	res.row=a.row;
	res.col=b.col;
	ull temp=0;
	
	for(int i=1;i<=res.row;i++)
		for(int j=1;j<=res.col;j++)
		{
			temp=0;
			for(int k=1;k<=a.col;k++)
				temp+=mod((ull)a.m[i][k]*b.m[k][j]);
			res.m[i][j]=temp;
		}
		
	return res;
}


mat pow_mat(mat a,ull b)
{
	init_unit(a.col);		//矩阵快速幂的幺元 
	mat res=unit;
	while(b)
	{
		if(b&1) 
			res=res*a;
		a=a*a;
		b>>=1;
	}
	return res;	
}

int main()
{
	ull k;
	scanf("%llu",&k);
	if(k==0)
	puts("0");
	else if(k==1||k==2)
	puts("1");
	else
	{	
		mat a,b;//a为初始矩阵，b为构造方阵
		a.row=1;a.col=3;
		b.row=3;b.col=3; 
		b.m[1][1]=1,b.m[1][2]=1,b.m[1][3]=0;
		b.m[2][1]=1,b.m[2][2]=0,b.m[2][3]=1;
		b.m[3][1]=0,b.m[3][2]=0,b.m[3][3]=0;
		
		a.m[1][1]=1,a.m[1][2]=1,a.m[1][3]=0;
		
		b=pow_mat(b,k-2);
		a=a*b; 
		printf("%llu",mod(a.m[1][1]));
	}	
	
	return 0;
}

#include<stdio.h>
using namespace std;
typedef unsigned long long ull;
const int maxn=4;
const long long MOD=1000000007;
#define mod(x) ((x)%MOD) 

ull n=3;// 辅助矩阵为3*3的， 2*2的貌似也可以 
	

struct mat{
	ull m[maxn][maxn];
};

mat unit;
void init_unit()
{
	for(int i=0;i<maxn;i++)
		unit.m[i][i]=1;
	return;
}

// 矩阵a和矩阵b相乘   （二者都是n*n的） 
mat mat_mul(mat a,mat b)
{
	mat ret;
	ull x;
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++){
			x=0;
			for(int k=0;k<n;k++)
				x+=mod(a.m[i][k]*b.m[k][j]); //注意！ 参与运算的两个整数是int型 相乘之后可能溢出，因此先通过强制类型转化 提高类型 
			ret.m[i][j]=mod(x);
		}
		return ret;	
}


mat pow_mat(mat a,ull b)
{
	mat ret=unit;
	while(b)
	{
		if(b&1) 
			ret=mat_mul(ret,a);
		a=mat_mul(a,a);
		b>>=1;
	}
	return ret;
	
}

int main()
{
	init_unit();
	int T;
	scanf("%d",&T);

	while(T--)
	{
		
	ull n;
	scanf("%llu",&n);

		if(n==2)printf("3\n"); continue;
		if(n==3)printf("4\n"); continue;
		if(n==4)printf("6\n"); continue;
	
		mat a,b;
		b.m[0][0]=1,b.m[0][1]=1,b.m[0][2]=0;
		b.m[1][0]=0,b.m[1][1]=0,b.m[1][2]=1;
		b.m[2][0]=1,b.m[2][1]=0,b.m[2][2]=0;
		
		a.m[0][0]=6,a.m[0][1]=4,a.m[0][2]=3;
		
		b=pow_mat(b,n-4);
		
		a=mat_mul(a,b);
		
		printf("%llu\n",a.m[0][0]%MOD);


		
		
	}

	
	return 0;
}

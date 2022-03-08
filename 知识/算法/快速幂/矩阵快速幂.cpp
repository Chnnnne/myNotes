#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn=110;
const int MOD=1e9+7;
#define mod(x) ((x)%MOD) 

int n;//n*n的矩阵	

struct mat{
	int m[maxn][maxn]; //根据情况设置maxn 和 矩阵元素的数据类型 
};

mat unit;
void init_unit()
{
	for(int i=0;i<maxn;i++)
		unit.m[i][i]=1;
}

// 矩阵a和矩阵b相乘   （二者都是n*n的,用于幂运算）  
mat mat_mul(mat a,mat b)
{
	mat ret;
	ll x;
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++){
			x=0;
			for(int k=0;k<n;k++)
				x+=mod((ll)a.m[i][k]*b.m[k][j]); //注意细节！ 参与运算的两个整数是int型 相乘之后可能溢出，因此先通过强制类型转化 提高类型 
			ret.m[i][j]=x;
		}
		return ret;	
}



mat pow_mat(mat a,ll b)
{
	init_unit();		//矩阵快速幂的幺元 
	mat res=unit;
	while(b)
	{
		if(b&1) 
			res=mat_mul(ret,a);
		a=mat_mul(a,a);
		b>>=1;
	}
	return res;	
}

int main()
{

	ll x;   			//n*n的矩阵， 求x次幂 
	scanf("%lld%lld",&n,&x);
	
	//矩阵输入 
	mat a;
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			scanf("%d",&a.m[i][j]);
			
	//计算 
	a=pow_mat(a,x);	//矩阵a的x次幂 
	
	
	//打印矩阵	
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
		{
			if(j+1==n)
			printf("%d\n",a.m[i][j]);
			else
			printf("%d ",a.m[i][j]); 
		}
		
	return 0;
}

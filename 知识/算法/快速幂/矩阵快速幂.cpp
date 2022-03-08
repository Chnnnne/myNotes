#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn=110;
const int MOD=1e9+7;
#define mod(x) ((x)%MOD) 

int n;//n*n�ľ���	

struct mat{
	int m[maxn][maxn]; //�����������maxn �� ����Ԫ�ص��������� 
};

mat unit;
void init_unit()
{
	for(int i=0;i<maxn;i++)
		unit.m[i][i]=1;
}

// ����a�;���b���   �����߶���n*n��,���������㣩  
mat mat_mul(mat a,mat b)
{
	mat ret;
	ll x;
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++){
			x=0;
			for(int k=0;k<n;k++)
				x+=mod((ll)a.m[i][k]*b.m[k][j]); //ע��ϸ�ڣ� �������������������int�� ���֮���������������ͨ��ǿ������ת�� ������� 
			ret.m[i][j]=x;
		}
		return ret;	
}



mat pow_mat(mat a,ll b)
{
	init_unit();		//��������ݵ���Ԫ 
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

	ll x;   			//n*n�ľ��� ��x���� 
	scanf("%lld%lld",&n,&x);
	
	//�������� 
	mat a;
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			scanf("%d",&a.m[i][j]);
			
	//���� 
	a=pow_mat(a,x);	//����a��x���� 
	
	
	//��ӡ����	
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

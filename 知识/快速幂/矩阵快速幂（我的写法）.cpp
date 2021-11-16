//�� һ�������n���� 
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
const int maxn=5;
const int MOD=1e9+7;
#define mod(x) ((x)%MOD) 

struct mat{
	int row,col;
	int m[maxn+1][maxn+1]; //�����������maxn �� ����Ԫ�ص��������� 
	
	mat(int row,int col)
	{
		this->row=row;
		this->col=col;
		for(int i=0;i<=maxn;i++)
			for(int j=0;j<=maxn;j++)
			{
				m[i][j]=0;
			}
	 } 
};


void init_unit(mat &mm)
{
	for(int i=1;i<=mm.row;i++)
		mm.m[i][i]=1;
}


mat operator *(mat &a,mat &b)
{
	if(a.col!=b.row)
	{
		cout<<"���󣺲��������˷�����";
		exit(0);
	}
	
	mat res(a.row,b.col);
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
	mat res(a.row,a.row);
	init_unit(res);
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
	ull n,x;   			//n*n�ķ��� ��x���� 
	cin>>n>>x;
	
	//�������� 
	mat a(n,n);
	for(int i=1;i<=n;i++)
		for(int j=1;j<=n;j++)
			scanf("%d",&a.m[i][j]);
			
	//���� 
	mat result=pow_mat(a,x);	//����a��x���� 
	
	
	//��ӡ����	
	for(int i=1;i<=result.row;i++)
	{
		for(int j=1;j<=result.col;j++)
		{
			printf("%d ",result.m[i][j]); 
		}
		putchar(10);
	}
		

	return 0;
}
/*
1 2 1
0 1 0
1 0 0
*/

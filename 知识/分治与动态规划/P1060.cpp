#include<stdio.h>

int max(int x,int y)
{
	if(x>y)
	return x;
	return y;
 } 

int fac[26][30002]; // 	fac[i][j] ��ֵ��ʾ �ӵ�i����Ʒ��ʼ��ѡ����ֵ�ܺͲ��ܳ���j�� ��*���ܺ����ֵ 
int main()
{
	int N,m;
	scanf("%d%d",&N,&m); // N��Ǯ�� 	m��Ʒ���� 
	int v[30],w[30];// vǮ��      w��Ҫ��
	for(int i=0;i<m;i++)
	{
		scanf("%d%d",&v[i],&w[i]);
	 } 
	
	
//	for(int j=0;j<=N;j++)
//	fac[m][j]=0;		Ĭ��Ϊ0����ʡ�� 

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

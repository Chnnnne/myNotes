#include<iostream>
#include<cstdio>
#define ll long long
using namespace std;
const int maxn = 1e5;
int n,F; //n���ָ�����F ��С�ֶεĳ���

// a����������У�  b���鸨��  �� sum����Ϊb����ǰ׺�� 
double a[maxn+5],b[maxn+5],sum[maxn+5];
 


// b����Ϊa�����ȥƽ����mid������ֻҪĳһ�κͷǸ���˵��ƽ��������mid 
// ����ת���ɴ�b������ȡһ���֣�>=F��  �ʹ���0  ��Ҳ����b�����ҳ����Ĳ��ֺͣ� 
bool ok(double mid){
	for(int i=1;i<=n;i++) 	b[i]=a[i]-mid;
	
	//��ʼ�� b�����ǰ׺�� sum 
	for(int i=1;i<=n;i++)	sum[i] = sum[i-1] + b[i];
	
	double min_val = 1e10,ans=-1e10;
	for(int i=F;i<=n;i++)		//��ʼ�����Ĳ��ֺ� 
	{
		min_val = min(sum[i-F], min_val); // ��һ��ѭ���� ��sum[i]�̶��� ��Ҫʹǰ�����С�������������� 
		ans = max(ans, sum[i]-min_val);
	}
	return ans>=0;
}


void solve(){
	double l=-1,r=2000,eps=1e-4; // 2��ƽ���� ,epsһ��Ҫ����Ŀ��ȷ�ȴ󣬱���1e-3,����ȡ1e-5 
	while(r-l>eps){
		double mid = (l+r)/2;
		if(ok(mid)) l=mid;
		else r=mid;
	}
	cout<<int(r*1000)<<endl; // ����ʵ����ȡ�Ͻ�(����ȷ��С����Ŀ��ȷ�ȵ�ʱ��L���Ե�ʱ��RҲ�ض�����,ȡ���ȡR) 
}


int main(){
	scanf("%d%d",&n,&F);
		
	for(int i=1;i<=n;i++)
	scanf("%lf",&a[i]);
	solve();
	
	return 0;
} 










//			ԭ����  n^2
/*
#include<stdio.h>
int a[100000];

int main()
{
	int n,L;
	scanf("%d%d",&n,&L);
	
	for(int i=1;i<=n;i++)
	scanf("%d",&a[i]);	
	
	double  aver=0;
    for(int i=1; i<=n;  i++) //����±�
        {   int sum=0;
            for(int j=i+L-1; j<=n;  j++)  //�յ��±�
            {      
					if(j==i+L-1)
					{
						for(int k=i;k<=j;k++)
						sum+=a[k];
					}
					else
					sum+=a[j];      //��㲻�䣬�յ��ۼ�һ��Ԫ��
                   if ( double(sum)/(j-i+1)>aver) 
					aver=double(sum)/(j-i+1);     
			}	
		}
	printf("%d",int(aver*1000));	
	return 0;
}
*/ 

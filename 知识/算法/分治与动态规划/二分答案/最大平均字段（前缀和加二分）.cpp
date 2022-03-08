#include<iostream>
#include<cstdio>
#define ll long long
using namespace std;
const int maxn = 1e5;
int n,F; //n数字个数，F 最小字段的长度

// a数组接受序列，  b数组辅助  ， sum数组为b数组前缀和 
double a[maxn+5],b[maxn+5],sum[maxn+5];
 


// b数组为a数组减去平均数mid，所以只要某一段和非负即说明平均数大于mid 
// 问题转化成从b数组中取一部分（>=F）  和大于0  （也即从b数组找出最大的部分和） 
bool ok(double mid){
	for(int i=1;i<=n;i++) 	b[i]=a[i]-mid;
	
	//初始化 b数组的前缀和 sum 
	for(int i=1;i<=n;i++)	sum[i] = sum[i-1] + b[i];
	
	double min_val = 1e10,ans=-1e10;
	for(int i=F;i<=n;i++)		//开始求最大的部分和 
	{
		min_val = min(sum[i-F], min_val); // 在一次循环中 ，sum[i]固定， 故要使前面的最小，这样相减才最大 
		ans = max(ans, sum[i]-min_val);
	}
	return ans>=0;
}


void solve(){
	double l=-1,r=2000,eps=1e-4; // 2分平均数 ,eps一定要比题目精确度大，本题1e-3,可以取1e-5 
	while(r-l>eps){
		double mid = (l+r)/2;
		if(ok(mid)) l=mid;
		else r=mid;
	}
	cout<<int(r*1000)<<endl; // 二分实数，取上界(当精确度小于题目精确度的时候L可以的时候R也必定可以,取大故取R) 
}


int main(){
	scanf("%d%d",&n,&F);
		
	for(int i=1;i<=n;i++)
	scanf("%lf",&a[i]);
	solve();
	
	return 0;
} 










//			原方法  n^2
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
    for(int i=1; i<=n;  i++) //起点下标
        {   int sum=0;
            for(int j=i+L-1; j<=n;  j++)  //终点下标
            {      
					if(j==i+L-1)
					{
						for(int k=i;k<=j;k++)
						sum+=a[k];
					}
					else
					sum+=a[j];      //起点不变，终点累加一个元素
                   if ( double(sum)/(j-i+1)>aver) 
					aver=double(sum)/(j-i+1);     
			}	
		}
	printf("%d",int(aver*1000));	
	return 0;
}
*/ 

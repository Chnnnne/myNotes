#include <iostream>
#include<cstdio>
using namespace std;
int a[1003][1003];
int dp[1003][1003];

int main()
{
    int r;
    cin>>r;
    for(int i=1;i<=r;i++)
        for(int j=1;j<=i;j++)
    {
        scanf("%d",&a[i][j]);
    }

//    for(int i=1;i<=r;i++)
//        dp[r][i]=a[r][i];

    for(int i=r;i>=1;i--)
        for(int j=i;j>=1;j--)
    {
        dp[i][j]=max(dp[i+1][j],dp[i+1][j+1])+a[i][j];

    }

    cout<<dp[1][1];

    return 0;
}

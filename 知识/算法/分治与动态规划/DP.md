# DP思想

待学习： 知乎收藏文章 balaba（关于DP的深层理解）

待完善：背包问题的j的起始值问题   、 回家找自己关于DP步骤的笔记



**动态规划的基本要素：**

**1.最优子结构性质**
当问题的最优解包含了其子问题的最优解时，称为该问题具有最优子结构性质。
**2.重叠子问题性质**
在用递归算法自顶向下解此问题时，每次<u>产生的子问题并不总是新问题</u>。有些子问题被反复计算多次。 动态规划正是利用<u>子问题的重叠性质</u>，对每一个子问题只解一次，而后保留起来，下次再用只需查看结果。





**动态规划算法与分治法：**

相同点：
(1) 原问题需要具有最优子结构性质；
(2) 解决思路都是将原问题分解成若干个规模较小的子问题，然后从这些子问题的解得到原问题的解。

不同点：
(1) 分治法要求子问题之间**相互独立**，子问题的分解中**不能包含公共子问题**；
(2) 动态规划是应对**子问题之间有重复**的解决方案；

(3) 分治法一般采用**递归**来求解；
(4) 动态规划一般采用**迭代法通过自底而上**（for循环）求解，或者通过具有**记忆功能的递归自顶而下求解**(函数)。

子问题重叠不是使用动态规划的必要条件，但是问题存在子问题重叠的特性更能够充分彰显动态规划的优势。





通常按四步骤设计动态规划算法：

（1）找出最优解的性质，并刻画其结构特征；    

（2）递归定义求最优值的公式；

（3）以自底向上方式计算最优值；

（4）根据计算最优值时得到的信息，构造最优解。



定义一些数组变量，和其意义
写递归方程
写循环计算这些变量
从变量中得出答案





---

# DP题





## 一、最大子段和



### 1、最大子段和

> **给定由N个整数（可能有负整数）组成的序列a1,a2,…,an ,求该序列形如$a_i+a_{i+1}+…+a_j$的子段和的最大值。**
>
> **（当所有整数均为负整数时，定义其最大子段和为0）**

<a href="#法3：动态规划法	T(n)=O(n)">Ctrl+点击直接跳转到动态规划方法</a>



- **法1：暴力枚举**		T(n)=O($n^3$)

```c++
int  MaxSum(int *a,  int n)   //设数据存放在a[1]~a[n]
{    int  sum=0;
     for( i=1 i<=n;  i++) //起点下标
         for( j=i; j<=n;  j++) //终点下标
             {   int T=0;
                 for( k=i; k<=j;  k++)  T+=a[k];
                if (T>sum)  sum=T；    
             }
     return sum;
}
```

暴力枚举改进版		T(n)=O($n^2$)

```c++
 MaxSum(int *a,  int n)  //设数据存放在a[1]~a[n]
{    int  sum=0;
    for( i=1; i<=n;  i++) //起点下标
        {   int T=0;
            for( j=i; j<=n;  j++)  //终点下标
            {      T+=a[j];      //起点不变，终点累加一个元素
                   if ( T>sum)  sum=T;         }
   return sum;
}
```









- **法2：分治法		T(n)=O($nlogn$)**    区间每次减半 logn  每个函数执行 n 

```c++
int  MaxSubSum(int *a, int L, int R)//求a[L]~a[R]最大字段和
{    int  sum=0;
     if (L==R)  sum=(a[L]>0)?a[L]:0;
     else 
	 {     
         int C=(L+R)/2; 
         int Lsum= MaxSubSum(a, L, C );
         int Rsum= MaxSubSum(a, C+1, R );
         
         int s1=0,   Lefts=0;
         for( i=C;  i>=L;  --i ) 
         {   
             lefts+=a[i]; 
             if(lefts>s1)  s1=lefts;  
         }
         int s2=0,   rights=0;
         for( j=C+1;  j<=R;  ++j )
         {   
             rights +=a[j];
             if(rights >s2)  s2= rights;    
         }
         sum=s1+s2;       
         sum=max(sum,Lsum,Rsum); 
     }//else
     return sum;
}

```









- ##### **法3：动态规划法	T(n)=O(n)**



**dp[i]的含义是 以index是 i 结尾的序列的最大子段和** 

**递推公式**
$$
dp[i]=
\begin{cases}
dp[i-1]+a[i]&\text{	dp[i-1]>0}\\
a[i]&\text{	dp[i-1]<0}
\end{cases}
$$
**临界：dp[1]=a[1]**

**构造最优解： MAX { dp[1] , dp[2], dp[3,]……., dp[n]  }**



从以上的递推关系可以看出，只需要dp[i]前一个dp[i-1]，因此 dp空间 要一个就够了

```C++
#include <iostream>
#include <algorithm>
using namespace std;

int a[10003];
int dp[10003];

int main()
{
    ios::sync_with_stdio(0);
    int n;
    cin>>n;
    for(int i=1;i<=n;i++)
        cin>>a[i];
    
    for(int i=1;i<=n;i++)
        if(dp[i-1]>0)
        dp[i]=dp[i-1]+a[i]; 
        else
        dp[i]=a[i];
    
    int max=*max_element(dp+1,dp+n+1);
    if(max<0)
        cout<<0;
    else
        cout<<max;
    return 0;
}

```

优化空间

```c++
//dp[n]->b 
int MaxSubArray(int a[],int n)
{
    int i,b = a[1],sum = 0;   //b存 以上一个字符结尾的最大子段和 
    for(i = 2;i<=n;i++)		//以i结尾的最大子段和 依次枚举
    {
        if(b>0)         //若以该字符的前一个字符结尾的最大子段和大于0，则加之
            b += a[i];        
        else    		//防止被前面的拖累，所以 以自己开始为最大子段和
            b = a[i];
        
        if(b > sum)    	//构造最优解
            sum = b;
    }
    return sum;
} 
```



- **法4：二分法（+前缀和）T(n)=O($nlog_2n$)**

```C++
#include<iostream>
#include<cstdio>
#define ll long long
using namespace std;
const int maxn = 1e5;
int n; //n数字个数

// a数组接受序列，   ， sum数组为b数组前缀和 
int a[maxn+5],sum[maxn+5];



//判断是否存在子段和大于mid   是的话返回true 
bool ok(double mid){
	double min_val = 1e10,ans=-1e10;
	for(int i=1;i<=n;i++)		//开始求最大的部分和 
	{
		min_val = min(double(sum[i]),min_val); // 在一次循环中 ，sum[i]固定， 故要使前面的最小，这样相减才最小 
		ans = max(ans, sum[i]-min_val);
	}
	return ans>=mid;
}



void solve(){
	double l=-1,r=2147483647,eps=1e-2; // 2分平均数 ,eps一定要比题目精确度大，本题1e-3,可以取1e-5 
	while(r-l>eps)
	{
		double mid = (l+r)/2;
		if(ok(mid)) l=mid;
		else r=mid;
	}
	cout<<int(r)<<endl; // 二分实数，取上界(当精确度小于题目精确度的时候L可以的时候R也必定可以,取大故取R) 
}
int main(){
	scanf("%d",&n);
		
	for(int i=1;i<=n;i++)
	{
			scanf("%d",&a[i]);
			sum[i]=sum[i-1]+a[i];
	}

	solve();
	
	return 0;
} 
```





### 2、最大 M个子段和问题 (推广到多段) 

> **给定 由N个整数（可能有负整数）组成的序列    $$ a_1,a_2,\cdots,a_n $$  ,  以及一个正整数 M ，求该序列形如  $a_i+a_{i+1}+\cdots+a_j$   的 M 个不相交子段，使得这m个子段总和 达到最大值。**  (M<=N)





 **dp[i] [j]  含义是：i个子段 前 j 项构成的最大和 （第i个子段以第j项结尾），**
前 j 项所构成 i 个子段的最大和 且第i子段以第j项结尾

**递推公式：**
$$
dp[i][j]=max
\begin{cases}
dp[i][j-1]+a[j]& \text{把第j项融合到第i子段中，子段数没变}\\
max(\ dp[i-1][t]+a[j]\ ) \ \ 其中\ \ i-1\leq t\leq j-1&\text{第j项单独作为一段}
\end{cases}
$$


临界：	

dp[0] [x]=0   dp[x] [0]=0

**构造最优解: max(dp[M] [t] )   	其中  M$\leq$t $\leq$N**



源代码：$T(n)=O(n^3)$

```c++
#include <iostream>
#include <algorithm>
using namespace std;
const int N_INF=-2100000000;

long long dp[5000][5000];
int a[5000];

int main()
{
    int N,M;
    cin>>N>>M;
    for(int i=1;i<=N;i++)
    {
        cin>>a[i];
    }
    for(int i=1;i<=M;i++)
        dp[i][1]=a[1];
    for(int i=1;i<=N;i++)
        dp[0][i]=0;
    
    for(int i=1;i<=M;i++)
        for(int j=i;j<=N;j++)
    {
        dp[i][j]=N_INF;
        for(int t=i-1;t<=j-1;t++)
        {
            dp[i][j]=max(dp[i][j],dp[i-1][t]);
        }
        dp[i][j]=max(dp[i][j],dp[i][j-1])+a[j];
    }

    cout<<*max_element(dp[M]+M,dp[M]+N+1);



    return 0;
}

```





**优化空间时间：**

  找个例子说明一下 

| a[1] | a[2] | a[3] | a[4] | a[5] | a[6] |
| ---- | ---- | ---- | ---- | ---- | ---- |
| -2   | 11   | -4   | 13   | -5   | 6    |



**借助矩阵可以直观的看到计算过程。**

| i   \     j | 0    | 1               | 2               | 3              | 4          | 5    | 6    | 7    |
| ----------- | ---- | --------------- | --------------- | -------------- | ---------- | ---- | ---- | ---- |
| 0           | 0    | 0               | 0               | 0              | 0          | 0    | 0    | 0    |
| 1           | 0    | *<u>**-2**</u>* | *<u>**11**</u>* | *<u>**7**</u>* | 20         | 15   | 21   | 19   |
| 2           | 0    | 0               | 9               | ***<u>7</u>*** | **==24==** | 19   | 26   | 24   |
| 3           | 0    | 0               | 0               | 5              | 22         | 19   | 30   | 28   |
| 4           | 0    | 0               | 0               | 0              | 18         | 17   | 28   | 28   |
| 5           | 0    | 0               | 0               | 0              | 0          | 13   | 24   | 26   |
| 6           | 0    | 0               | 0               | 0              | 0          | 0    | 19   | 22   |

例如求dp[2] [4] 只需要前一行上的 -2 11 7  以及 左边的7取最大的再加上a[2]即可

因此可以：

- 只需要两行的dp数据



在求前一行的最大值时，不要每向右移动一个位置(j)，就重新求，可以设置个变量来每次比较

因此可以：

- 对于每一行的数据，刚开始时设置个变量tempmax，每向右移动就和它比较
- ==关于这一点的一点心得： 这个过程一般是 有两个内层的循环，最后一层的循环如果是累加或比较的话。这时上面的那一个通过移动一次累加一次，就可以达到去掉最内层循环的目的==



表格中有些数据是多余的，如果求dp[m] [n],则以m n所在的格子做一条左上的45°线，线的右边都需要求

因此可以：

- 以j 为x轴 ，i为y轴  y=x+b ， M = N+b ， b=M-N， y= x+ M-N。 y>=x+M-N, i>=j+M-N也即

  j<=N-M+i  (不太好想，想不出来也没关系)





==我的优化思路：想要优化时，可以借助矩阵来观察**一般情况的求法**也即求这个框的值需要什么子框来得到它（递推式也可以得到这样的关系但这更直观），这样就可看出（或递推式推出）需要的dp数组的最小空间（这题是需要两行）。**然后想边界的情况该怎么样弄 **==    然后通过for循环填递推时 对dp数组的处理是取模运算。

另外一点就是：借助矩阵的话，要把矩阵的行列对应什么要想明白，不要不知道这个矩阵是个什么东西 （深入理解）

```c++
#include <cstdio>
#include <string.h>
#include <algorithm>
using namespace std;
#define INF 0x7fffffff

const int MAX_N=1000000;
int a[MAX_N+10];
long long dp[2][MAX_N+10];

int main()
{
    int m,n;
    while(~scanf("%d%d",&m,&n))
    {
        for(int i=1;i<=n;i++)
            scanf("%d",&a[i]);
        memset(dp,0,sizeof(dp));

        for(int i=1;i<=m;i++)
        {
            long long temp=-INF;
            dp[i%2][i-1]=-INF;      //此题最关键的一步！ 目的是对在 矩阵对角线（也即 i=j时）的dp元素 
            //特殊处理 （因为i=j时 ，若dp[i][j-1]=0 且dp[i-1][j]<0时，就会出现错误，因此要排除dp[i][i-1]的干扰） 
            for(int j=i;j<=n-m+i;j++)
            {
                temp=max(temp,dp[(i-1)%2][j-1]);
                dp[i%2][j]=max(dp[i%2][j-1],temp)+a[j];
            }

        }

        long long res=*max_element(dp[m%2]+m,dp[m%2]+n+1);
        printf("%lld\n",res);

    }
    return 0;
}

```









### 3、最大子矩阵和问题（推广到二维）  

> **最大子矩阵和问题。给定m行n列的整数矩阵A，求矩阵A的一个子矩阵，使其元素之和最大。**





**输入格式:**

第一行输入矩阵行数m和列数n（1≤m≤100，1≤n≤100），再依次输入m×n个整数。

**输出格式:**

输出第一行为最大子矩阵各元素之和，第二行为子矩阵在整个矩阵中行序号范围与列序号范围。

**输入样例1:**

> 5 6
> 60 3 -65 -92 32 -70
> -41 14 -38 54 2 29
> 69 88 54 -77 -46 -49
> 97 -32 44 29 60 64
> 49 -48 -96 59 -52 25

**输出样例1:**

输出第一行321表示子矩阵各元素之和，输出第二行2 4 1 6表示子矩阵的行序号从2到4，列序号从1到6

> 321
> 2 4 1 6







**源代码：**

```c++
#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

int a[103][103];

int b[103];//辅助maxsum函数  以i结尾的最大字段和
int start[103];//辅助b 记录  以i结尾的最大字段和的开头是什么节点
int row1,row2;//记录行数
int co1,co2;//记录列数
int co1old,co2old;

int maxsum(int *k,int n)
{
    for(int i=1;i<=n;i++)
    {
        if(b[i-1]>0)
        {
            b[i]=b[i-1]+k[i];
            start[i]=start[i-1];
        }

        else
        {
            b[i]=k[i];
            start[i]=i;
        }

    }
    
    int maxsub=0;
    for(int i=1;i<=n;i++)
    {
        if(b[i]>maxsub)
        {
            maxsub=b[i];
            co1=start[i];
            co2=i;
        }
    }
    return maxsub;
}




int main()
{
    ios::sync_with_stdio(0);
    int m,n;
    cin>>n;
    cin>>m; //n行 m列
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <=m; j++)
            cin>>a[i][j];

     int all_max=0;

//对行范围进行枚举， 枚举之后（在最内层循环中）只需要关注 行范围压缩后（降维）的数组（temp_sum）（temp_sum就可以按照前面对一维的方法处理了） ,然后求其最大字段和 再与all_max相比较即可

     for(int i=1;i<=n;i++) //第i行开始
     {
         int temp_sum[m+3];
         memset(temp_sum,0,sizeof(temp_sum));
         for(int j=i;j<=n;j++)  //第j行结束
         {
             for(int k=1;k<=m;k++)//得到从第i行和第j行之间每一列的和 而组成的的一个压缩后的数组 temps_sum
            {
             temp_sum[k]+=a[j][k];
            }


            int max=maxsum(temp_sum,m);
            if(max>all_max)
            {
                all_max=max;            //注意此处！产生了bug！ 由于当max>all_max时才需要更新 row和 col 然而 计算maxsum函数时
                row1=i;                 //必定改变了col ，这就产生了bug ，因此假如max不大于al_max 要还原被maxsum函数改变了的 co1 col2
                row2=j;                 //或者在maxsum中加入判断条件
                //列数在函数中更新
                co1old=co1;
                co2old=co2;
            }
            else
            {
                co1=co1old;
            }   co2=co2old;


         }
     }

     cout<<all_max<<'\n'<<row1<<" "<<row2<<" "<<co1<<" "<<co2;

    return 0;
}

```

**以上可以优化**：  

- MAXsum函数可以优化 （空间 和 时间）
- 在Maxsum函数中 用全局变量 temp_co1 /  temp_co2   
  当 Maxsum函数返回值>all_max时，有赋值 co1=temp_co1/        co2=temp_co2  
  若返回值 不大于al_max时，别赋值了。 这样的话 co1 co2 就是最后的答案。







## 二、最长公共子序列LCS

> **给定2个序列 X={x1,x2,…,xm}和 Y={y1,y2,…,yn}，找出 X 和 Y 的最长公共子序列。** 





- **一般题解**

**dp[i] [j]的含义是： str1 1~i 和 str2 1~j的最长公共子序列长度**

**递推公式：**
$$
dp[i][j]=
\begin{cases}
dp[i-1][j-1]+1&\text str1[i]==str2[j]\\
max(dp[i-1][j],dp[i][j-1])&\text 其他情况
\end{cases}
$$
**临界：dp[i] [0]=0 ,dp[0] [j]=0**

**构造最优解：不用构造，dp[m] [n]就是**

```c++
#include <iostream>
#include <string>
#include <algorithm>
#include <string.h>
using namespace std;

int dp[10003][10003];

int main()
{
    string str1,str2;
    getline(cin,str1); int len1=str1.length();  //也可以用字符数组，然后strlen获取长度
    getline(cin,str2); int len2=str2.length();
    str1='\0'+str1;//下标从1开始
    str2='\0'+str2;

    for(int i=1;i<=len1;i++)
        for(int j=1;j<=len2;j++)
    {
        if(str1[i]==str2[j])
            dp[i][j]=dp[i-1][j-1]+1;
        else
            dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
    }
    cout<<dp[len1][len2];
    return 0;
}
```

java版

注意事项：当使用索引1-n时 ，格外注意！： n=str.length()-1      且str 的首位要额外添加一个     而且注意数组的末尾是dp[str1.length()-1] [str2.length()-1]

```java
public class 最长公共子序列LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();	str1="0"+str1; 
		String str2 = sc.next();	str2="0"+str2;
		int [][] dp=new int [str1.length()+2][str2.length()+2];
		
		for(int i=1 ; i<=str1.length()-1;i++ )
			for(int j=1 ; j<=str2.length()-1 ; j++) {
				if(str1.charAt(i)==str2.charAt(j))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		System.out.println(dp[str1.length()-1][str2.length()-1]);
		
	}//main
}
```





- **算法的改进**

通过递推式或者矩阵可以得出，只需要两行两列dp数组即可

```c++
#include <iostream>
#include <string>
#include <algorithm>
#include <string.h>
using namespace std;

int dp[2][10003];//dp[i][j]的含义是： str1 1~i 和 str2 1~j的最长公共子序列长度

int main()
{
    string str1,str2;
    getline(cin,str1); int len1=str1.length();  //也可以用字符数组，然后strlen获取长度
    getline(cin,str2); int len2=str2.length();
    str1='\0'+str1;//下标从1开始
    str2='\0'+str2;

    for(int i=1;i<=len1;i++)
        for(int j=1;j<=len2;j++)
    {
        if(str1[i]==str2[j])
            dp[i%2][j]=dp[(i-1)%2][j-1]+1;
        else
            dp[i%2][j]=max(dp[(i-1)%2][j],dp[i%2][j-1]);
    }
    cout<<dp[len1%2][len2];
    return 0;
}
```





- **并输出最长公共子序列的元素**

  （还不太会）

  

  <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200328200912829.png" alt="image-20200328200912829" style="zoom: 50%;" />

  <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200328200926987.png" alt="image-20200328200926987" style="zoom:50%;" />

  <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200328200930319.png" alt="image-20200328200930319" style="zoom:50%;" />

  

  

  

  **<u>以下代码有误，需要修改</u>**

```C++
#include <iostream>
#include <string>
#include <algorithm>
#include <string.h>
using namespace std;

string str1,str2;
int dp[2][10003];//dp[i][j]的含义是： str1 1~i 和 str2 1~j的最长公共子序列长度
int flag[10003][10003];
void LCS(int i,int j);
int main()
{

    getline(cin,str1); int len1=str1.length();  //也可以用字符数组，然后strlen获取长度
    getline(cin,str2); int len2=str2.length();
    str1='\0'+str1;//下标从1开始
    str2='\0'+str2;

    for(int i=1;i<=len1;i++)
        for(int j=1;j<=len2;j++)
    {
        if(str1[i]==str2[j])
        {
            dp[i%2][j]=dp[(i-1)%2][j-1]+1;
            flag[i][j]=1;
        }

        else
        {
         if(dp[(i-1)%2][j]>dp[i%2][j-1])
         {
             dp[i%2][j]=dp[(i-1)%2][j];
             flag[i][j]=2;
         }
         else
         {
             dp[i%2][j]=dp[i%2][j-1];
             flag[i][j]=3;
         }

        }

    }
    cout<<dp[len1%2][len2]<<endl;

    LCS(len1,len2);

    return 0;
}



void LCS(int i,int j)
{
    if(i==0||j==0)
        return;
    if(flag[i][j]==1)
    {
        LCS(i-1,j-1);
        cout<< str1[i-1];
    }
    else if(flag[i][j]==2)
    {
        LCS(i-1,j);
    }
    else{
        LCS(i,j-1);
    }

}
```









## 三、最长上升子序列

> 对于序列(1, 7, 3, 5, 9, 4, 8)， 有它的一些上升子序列，如(1, 7), (3, 4, 8)等等。这些子序列中最长的长度是4，比如子序列(1, 3, 5, 8)。
>
>   你的任务，就是对于给定的序列长度为n，求出最长上升子序列的长度。（注意上升不包括不变）



**dp[i]的含义是 以第i个数结尾的最大上升子序列**

**递推公式： dp[i]=max{ dp[t] }  +1          (其中$1\leq t\leq i-1$且满足a[t]<a[i])**

**临界：dp[1]=1**,             初始化：dp[i]=1



**构造最优解： max{  dp[i] }  （其中$1\leq i\leq n$）**    

```c++
#include <iostream>
#include <algorithm>
using namespace std;

int a[10003];
int dp[10003]; //dp[i]代表以i结尾的子序列的最大长度
int main()
{
    ios::sync_with_stdio(0);
    int n;
    cin>>n;
    for(int i=1;i<=n;i++)
    {
        cin>>a[i];
    }
	
//    for(int i=1;i<=n;i++)
//        dp[i]=1; //初始化一下
    
    dp[1]=1;
    for(int i=2;i<=n;i++)
    {
        int max=0;
        for(int k=1;k<=i-1;k++)
        {
            if(dp[k]>max&&a[i]>a[k])
                max=dp[k];
        }
        dp[i]=max+1;
    }
    cout<<*max_element(dp+1,dp+n+1);


    return 0;
}
```



### 拓展：导弹拦截问题

某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。某天，雷达捕捉到敌国的导弹来袭。由于该系统还在试用阶段，所以只有一套系统，因此有可能不能拦截所有的导弹。

输入导弹依次飞来的高度（雷达给出的高度数据是不大于30000的正整数，导弹数不超过1000），计算这套系统最多能拦截多少导弹？

**扩展思考：如果要拦截所有导弹最少要配备多少套这种导弹拦截系统。**



两个问题：①、最长非递增子序列的长度。②、原序列最少能够分成几个最长非递增子序列。

我们可以发现最多能够拦截的导弹就是最长不上升子序列的个数，要拦截所有的导弹就是最长上升子序列，因为要把序列分成若干段不上升的，那么段与段之间一定存在上升，所以我们找到最长上升子序列就可以拦截到所有的导弹。dp[i]dp[i]*d**p*[*i*] 用来表示以 ii*i* 结尾的最长不上升/上升子序列的长度。

```C++
#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
const int maxn=3e4+10;
int a[maxn],dp[maxn],dp1[maxn];//以i结尾的最长不上升子序列的长度 

int main(){
	//char b='a'; 
	int n=0;
	/*while(b!='\n'){
		scanf("%d",&a[n++]);
		b=getchar();
	}*/
	while(~scanf("%d",&a[n])) n++;
	//for(int i=0;i<n;i++) cout<<a[i]<<" ";
	int mmax1=-1,mmax2=-1;
	for(int i=0;i<n;i++){//当前数 
		dp[i]=1; dp1[i]=1;
		for(int j=0;j<i;j++){
			if(a[i]<=a[j]) dp[i]=max(dp[i],dp[j]+1);
			else dp1[i]=max(dp1[i],dp1[j]+1);
		}
		mmax1=max(mmax1,dp[i]);
		mmax2=max(mmax2,dp1[i]);
	}
	printf("%d\n%d\n",mmax1,mmax2);
	return 0;
} 
```







## 四、多重部分和问题

> **有n种不同大小的数字 $a_1,a_2,\cdots,a_n$ 每种各$m_i$个。问是否可以组合成K**







- 解法一

**dp[i] [j]的含义是从前i个物品选 是否可以组合成j**

**递推公式：**
$$
dp[i][j]=
\begin{cases}
true&\text{,存在一个dp[i-1][j-k*a[i]]为true，（其中0<=k<=mi且k*a[i]<=j）}\\
false&\text{,else}

\end{cases}
$$
**构造最优解：**dp[n] [K]就是





```C++
int n =3;
int a[4]={0,3,5,8};
int m[4]={0,3,2,2};
int K=17;
```

**源码：**

```c++
#include <iostream>
#include <algorithm>
using namespace std;

bool dp[50][50];

int main()
{
    for(int i=0;i<50;i++)
        dp[i][0]=true;
    for(int i=1;i<=n;i++)
        for(int j=1;j<=K;j++)
        {
            for(int t=0;t<=m[i]&&t*a[i]<=j;t++)
            {
                if(dp[i-1][j-t*a[i]]==true)
                {
                    dp[i][j]=true;
                    break;
                }
            }
        }


    cout<<dp[n][K];

    return 0;
}

```



- **解法二（优化）**

**dp[i] [j]的含义是用前i种数组成j时， 第i种数最多剩余多少个**

**递推关系：**

dp[i] [j]= 

**m[i]** 							(当dp[i-1] [j]>=0)  		也即若从前i-1种物品选时已能满足要求，则dp[i] [j]还剩余m[i]个
**-1**    							(当dp[i] [j-a[i]]<=0) 		j<a[i]时（前越界），又或者前i种数组合不了j-a[i]或已无剩余a[i]   

**dp[i] [j-a[i]]-1**		(其他情况)						前i种数能组合成j-a[i]且有剩余



**源码：**

```C++
#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

bool dp[50];

int main()
{
    memset(dp,-1,sizeof(dp));

    for(int i=1;i<=n;i++)
    {
        dp[0]=m[i];
        for(int j=1;j<=K;j++)
        {
            if(dp[j]>=0)
                dp[j]=m[i];
            else if(j<a[i]||dp[j-a[i]]<=0)
                dp[j]=-1;
            else
                dp[j]=dp[j-a[i]]-1;
        }
    }
    cout<<dp[K];

    return 0;
}

```



## 五、背包问题





（背包九讲）





> 0—1背包也即 物品要么选要么不选，不能选一半什么的；而一般的背包问题，物品可以选一部分

问题可以形式化描述：

用一个n元向量表示：

（X1，X2，X3 ..... Xn）  对于01背包问题 Xi 可以取0或1 



### 1、 01背包

> 背包能承受的总重量是W，共有n件物品 w[1]~w[n]   价值分别为 v[1]~v[n],求能装物品的最大价值



<a href="#法4：动态规划  （正向）(我为人人法)">Ctrl+点击直接跳转到一般的动态规划方法</a>



> 初始条件：
>
> int n=4,W=5;
> int w[5]={0,2,1,3,2};
> int v[5]={0,3,2,4,2};





##### **法1：递归法**

```c++
#include<stdio.h>
#include<string.h>
#include<algorithm>
using namespace std;


//从i开始 重量小于j的 最大价值 
int f(int i,int j)
{
	int res;
	if(i==n+1)
		res=0;
	else if(w[i]>j)
		res=f(i+1,j);
	else
		res=max(f(i+1,j),f(i+1,j-w[i])+v[i]);
	return res;
 } 
```





##### **法2：记忆化搜索**

```c++
int d[10][10];
int f2(int i,int j)
{
	if(d[i][j]>=0)
	{
		return d[i][j];
	}
	int res;
	if(i==n+1)
	res=0;
	else if(w[i]>j)
	res=f2(i+1,j);
	else
	res=max(f2(i+1,j),f2(i+1,j-w[i])+v[i]);
	return d[i][j]=res;
}
```





##### **法3：动态规划法（逆向）** 



**dp[i] [j]含义是 从第i个开始，重量不大于j的最大价值** 

```C++
int dp[10][10];

void solve1()
{
	memset(dp,0,sizeof(dp));
	for(int i=n;i>=1;i--)
		for(int j=0;j<=W;j++)
		{
			if(w[i]>j)
			dp[i][j]=dp[i+1][j];
			else
			dp[i][j]=max(dp[i+1][j],dp[i+1][j-w[i]]+v[i]);
		}
	
} 
```







##### 法4：动态规划  （正向）(我为人人法)   



**dp[i] [j]含义是： 前i个，重量不大于j的最大价值** 

**递推公式：**
$$
dp[i][j]=
\begin{cases}
dp[i-1][j]&\text{w[i]>j}\\
max(\ dp[i-1][j],dp[i-1][j-w[i]]+v[i]\ \ )&\text{else} 
\end{cases}
$$
**构造最优解： dp[n] [W]就是**



**<u>T(n)=O(nW)</u>**

```c++
int dp[100][100];
void solve2()
{
	memset(dp,0,sizeof(dp));
	for(int i=1;i<=n;i++)
		for(int j=1;j<=W;j++) 
		{
			if(w[i]>j)
			dp[i][j]=dp[i-1][j];
			else
			dp[i][j]=max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
		}								
}
```

**空间优化1**

```java
int dp[2][100];
void solve2_pro()
{
    memset(dp,0,sizeof(dp));
    for(int i=1;i<=n;i++)
        for(int j=1;j<=w;j++) //此处可否换成 j=w[i]呢
        {
            if(w[i]>j)
                dp[i%2][j]=dp[(i-1)%2][j];
            else
                dp[i%2][j]=max(dp[(i-1)%2][j],dp[(i-1)%2][j-w[i]]+v[i]);
        }											↑ 此处
}
```

另外： x%2   $\iff$  x&1

**空间优化2：**

用一维dp数组

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200525213351041.png" alt="image-20200525213351041" style="zoom:50%;" />

下标初始值改变,且：

```C++
for(int i=1;i<=n;i++)  
    for(int j=W;j>=w[i];j--)
        dp[j]=max(dp[j],dp[j-w[i]]+v[i]);
```

注意方向也改变了  因为由上图可知， 若j从小到大求，那么后面的dp[j] 要用到前面的dp[j-2]时，可能已经被覆盖了 因此

因此空间优化时：要深深理解上面的矩阵图（完全背包也有个图 ，可以对比理解下）







##### **法5：动态规划  （正向）**(人人为我法)







##### **法6：DFS**

```C++
#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

const int MAXN=100;

int Weight;             //背包承重量
int StfNum;             //物品的数量
int StfWei[MAXN+1];     //每个物品的重量
int StfPri[MAXN+1];     //每个物品的价值

int Prize;
int MaxPrize;

bool choose[MAXN+1];
bool Maxchoose[MAXN+1];


void dfs(int cur)
{
    //目标状态
    if(cur>StfNum)
    {
        if(Prize>MaxPrize)
        {
            MaxPrize=Prize;
            for(int i=1;i<=StfNum;i++)
                Maxchoose[i]=choose[i];
        }
        return;
    }
    
    
    if(StfWei[cur]>Weight)
    {
        choose[cur]=false;
        dfs(cur+1);
        return;
    }

    //子情况 可以选  但不选
    choose[cur]=false;
    dfs(cur+1);

    //子情况 可以选 所以也选
    choose[cur]=true;
    Weight-=StfWei[cur];
    Prize+=StfPri[cur];
    dfs(cur+1);
    choose[cur]=false;
    Weight+=StfWei[cur];
    Prize-=StfPri[cur];
}



int main()
{
    ios::sync_with_stdio(0);

    cin>>Weight>>StfNum;
    for(int i=1;i<=StfNum;i++)
        cin>>StfWei[i];
    for(int i=1;i<=StfNum;i++)
        cin>>StfPri[i];

    dfs(1);

    cout<<MaxPrize<<endl;
    for(int i=1;i<=StfNum;i++)
            cout<<Maxchoose[i];
    return 0;
}

```







### 2、 01背包（大数据量）

> 有n个重量和价值分别为 wi、vi的物品。背包承重不超过W，求背包能装的最大价值
>
> 限制：
>
> i$\leq$ n $\leq$ 100
> i$\leq$ wi $\leq$ $10^7$
> i$\leq$ vi $\leq$ 100
> i$\leq$ W $\leq$ $10^9$				与之前的01背包相比 W 和wi 扩大了数量级



**dp[i] [j]代表的含义是 前i个物品，价值为j 的最小重量**

**构造最优解：dp[n] [j]<=W下 j的最大值**

**递推关系**
$$
dp[i][j]=
\begin{cases}
dp[i-1][j]&\text{j>v[i]}\\
min(dp[i-1][j],dp[i-1][j-v[i]]+w[i])

\end{cases}
$$






错了很多次！ 错误的原因是下标的不注意越界！

```c++
#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;
const int INF=21000;

int n=4,W=5;
int w[5]={0,2,1,3,2};
int v[5]={0,3,2,4,2};
const int MAX_V=5;
const int MAX_n=5;

int dp[MAX_n+1][MAX_n*MAX_V+1];

int main()
{
    cout<<"初始化之前"<<endl;
     for(int i=0;i<MAX_n+1;i++)
    {
        for(int j=0;j<MAX_n*MAX_V+1;j++)
            cout<<" "<<dp[i][j];
        cout<<endl;
    }

    //我自己的思路：因为有的价值是在前i个物品中无论如何都凑不到的
    //比如前i个物品价值最小为3，那么dp[i][1/2]都是不存在的，假如给这些框赋值为0的话
    //不合符题意（也即前i个物品价值为1/2的最小重量为0 这怎么可能的嘛？）
    //所以先把整个dp空间填充成INF 防止某些不合法的框影响
    //然后根据题意填充dp[x][0]=0;
    fill(dp[0],dp[0]+(MAX_n+1)*((MAX_n)*(MAX_V)+1),INF);
    for(int i=0;i<MAX_n+1;i++)
    dp[i][0]=0;

    cout<<"初始化之后"<<endl;
    for(int i=0;i<MAX_n+1;i++)
    {
        for(int j=0;j<MAX_n*MAX_V+1;j++)
            cout<<" "<<dp[i][j];
        cout<<endl;
    }


    //填充
    for(int i=1;i<=n;i++)
        for(int j=0;j<=MAX_n*MAX_V;j++)
    {
        if(j<v[i])
            dp[i][j]=dp[(i-1)][j];
        else
            dp[i][j]=min(    dp[(i-1)][j]   ,   dp[(i-1)][j-v[i]]+w[i]);
    }



    cout<<"填充之后"<<endl;
    for(int i=0;i<MAX_n+1;i++)
    {
        for(int j=0;j<MAX_n*MAX_V+1;j++)
            cout<<" "<<dp[i][j];
        cout<<endl;
    }



//构造最优解：
    int rec=0;
    for(int j=1;j<=MAX_n*MAX_V;j++)      //错误就出在这里了！ 以前的写法是 j<=MAX_n*MAX_V+1
    {								     //显然这样做 最后一个数 由于 在dp填充过程中 未填												充到，因此为0 所以答案一定会是最后一个数。
        if(dp[n][j]<=W)
            rec=j;
    }
    cout<<"答案是："<<rec;

    return 0;
}
```

过程：

![image-20200402093607387](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200402093607387.png)









### 3、完全背包

> **有n种质量和价值分别为w[i] v[i]的物品。注意每种物品的数量无限个。背包的装载量是W,求背包能装的价格最大是多少**



**dp[i] [j]的含义是 从前i个商品中 选出总质量不超过j的最大价值**

递推公式：

**dp[i] [j]=max{  dp[i-1] [ j-k* w[i] ]+ k*v[i]  }             	其中 0$\leq$k, 且 k *w[i]$\leq$ j**

构造最优解：dp[n] [W]就是

已知条件：

```c++
int n=3;
int w[4]={0,3,4,2};
int v[4]={0,4,5,3};
int W=7;
```

- 一般解法

```c++
int dp[2][100];
void solve1()
{//三重循环 T(n)=O(n^3)不好

    for(int i=1;i<=n;i++)
        for(int j=1;j<=W;j++)
    {
        for(int k=0;k*w[i]<=j;k++)
            dp[i%2][j]=max(dp[i%2][j],dp[(i-1)%2][j-k*w[i]]+k*v[i]);
    }
    cout<<dp[n%2][W];//10

}
```







- **优化解法**



首先**借助矩阵可以直观的看到计算过程。**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200330163607218.png" alt="image-20200330163607218" style="zoom:50%;" />该图当i 或j 等于0时 对应的行列都是全0

从上图二维矩阵看出要想得到目标框需要取 上面的一些 框（框值加上相应物品个数价值）中的最大值

注意其中蓝线对应框的间隔 是w[i]（图中的w[i]是2）   依次对应着 拿0、1、2、3个i物品







思考：怎样能减少蓝线的个数呢？、 能否利用一些已知的框值去代替这些蓝线呢？ 



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200330164430469.png" alt="image-20200330164430469" style="zoom:50%;" />

观察上图可得 

利用该框上面的一个框和左边的一个框即可！！

也即**递推式变为**：

**dp[i] [j]=max{ dp[i] [ j - w[i] ]+v[i]   ,dp[i-1] [j]    }**  

<u>可能有点疑惑上面那个加v[i]该怎样理解</u>

```c++
int dp[2][100];
void solve2()
{
    for(int i=1;i<=n;i++)
        for(int j=1;j<=W;j++)
   		 {
            if(j<w[i])
                dp[i%2][j]=dp[(i-1)%2][j];
            else
            dp[i%2][j]=max(dp[(i-1)%2][j],dp[i%2][j-w[i]]+v[i]);
   		 }						   ↑此处
    cout<<dp[n%2][W];//10

}
```

~~二维的此代码和01背包 只有一个参数不同 其他完全相同~~

<a href="#法4：动态规划  （正向）(我为人人法)">Ctrl+点击直接跳转到01背包</a>



**空间优化** （时间小优化）

```C++
for(int i=1;i<n;i++)
    for(int j=w[i];j<=W;j++)
        dp[j]=max(dp[j],dp[j-w[i]]+v[i]);
```









## 六、石子合并

> 有N堆石子**排成一排**(n<=100),现要将石子有次序地合并成一堆，规定每次只能选相邻的两堆合并成一堆，并将新的一堆的石子数，记为该次合并的得分，编一程序，给出堆数n及每堆石子数(<=200)；
>
> 选择一种合并石子的方案，使得做n-1次合并，得分的总和最少







**dp[i] [j]的含义是从第i到第j堆石子合并的最优值（最小值）**

**递推公式：**
$$
dp[i][j]=
\begin{cases}
0&\text{,  i==j}\\
dp[i][k]+dp[k+1][j]+SUM(i~j)\ \ \ \ 其中i\leq k\leq j \ \ \ \ &\text{,  i != j}
\end{cases}
$$


重点理解为什么k可以等于i 和 j 因为 等于i时，相当于先把后面的合并随后再与第一个合并

```C++
#include<bits/stdc++.h>
using namespace std;
#define INF 2100000000

const int maxn=210;
int n,a[maxn];
int  dp[maxn][maxn];//dp[i][j]表示从第i堆到第j堆合并最小合
int  sum[maxn];



int getD(int i,int j)
{
    return sum[j]-sum[i-1];
}


int main()
{
	ios::sync_with_stdio(0);
	cin>>n;

    for(int i=1;i<=n;i++)
    {
        cin>>a[i];
        sum[i]=sum[i-1]+a[i];
    }


//    for(int i=0;i<=n;i++)
//    dp[i][i]=0;
//虽然dp空间恰好初始化默认为0，但是要知道为什么为0
//做到这一部分时，自己绕了很久， 第一开始自以为是dp[i][i]=a[i]
//好像想了想这样是对的，因为区间长度为1，值就是本身啊
//但仔细想想这是不对的，应该是dp[i][i]=0；


    for(int len=2;len<=n;len++)//区间长度
    {
        for(int i=1;i<=n-len+1;i++)//区间起点
        {
            int j=i+len-1;//区间终点
            dp[i][j]=INF;
            for(int k=i;k<=j;k++)
//用k来表示分割区间  也即k相当于是在i——j区间内，最后相加的一对，
//所以k可以为i 也可以为j，与此同时也与上文dp[i][i]只能等于零相对应

            {
					dp[i][j]=min(dp[i][j],dp[i][k]+dp[k+1][j]);
            }
            dp[i][j]+=getD(i,j);
        }
    }
		cout<<dp[1][n]<<endl;

	return 0;
}

```







## 七、放苹果

> M个苹果放到N个盘子里，有多少种放法？

> 问题等价于： 数字m 的划分数 （单次划分的个数不超过N）





**dp[i] [j]的含义是i个苹果放在j个盘子中的放法**

**递推公式：**
$$
dp[i][j]=
\begin{cases}
dp[i][i]&\text{i<j   ，也即盘子数大于苹果数}\\
dp[i][j-1]+dp[i-j][j]&\text{i $\geq$ j，也即苹果数大于等于盘子数}
\end{cases}
$$
在i$\geq$ j时，的两种情况是：想象成下面二种情况之和：
①至少有一个盘子不放东西 dp[i] [j-1]
②所有盘子都不空，那么相当于每个盘子先拿走一个，剩下来的情况dp[i-j] [j]



注意： i-j可能等于0,也即i=j的情况，因此初始化时莫忘了dp[0] [j]=1;  或者在递推公式中，分成三项 分别为> < 和=

```c++
#include <iostream>
#include <algorithm>
using namespace std;

int dp[22][22];//dp[i][j]的含义是i个苹果放在j个盘子中

int main()
{
    ios::sync_with_stdio(0);
    int t;
    cin>>t;
    while(t--)
    {
        int M,N;
        cin>>M>>N;//M个苹果，N个盘子

        for(int i=0;i<22;i++)
            dp[1][i]=1,dp[0][i]=1,dp[i][1]=1;

        for(int i=2;i<=M;i++)
            for(int j=2;j<=N;j++)
        {
            if(j>i)
                dp[i][j]=dp[i][i];
            else
                dp[i][j]=dp[i][j-1]+dp[i-j][j];
        }
        cout<<dp[M][N]<<endl;
    }

    return 0;
}
```









## 八、整数划分

> 求一个整数的划分数



### 1.DFS



**输入样例:**

在这里给出一组输入。例如：

```in
6
```

**输出样例:**

在这里给出相应的输出。例如：

```out
6=1+1+1+1+1+1
6=1+1+1+1+2
6=1+1+1+3
6=1+1+2+2
6=1+1+4
6=1+2+3
6=1+5
6=2+2+2
6=2+4
6=3+3
6=6
```



解题代码：

```C++
#include<bits/stdc++.h>
using namespace std;

const int MAX_N=53;

int flag[MAX_N+1];
int N;

void Prin()
{
    cout<<N<<"=";
    for(int i=1;i<=MAX_N;i++)
    {
        if(flag[i+1]!=0)
        {
            cout<<flag[i]<<"+";
        }
        else
        {
            cout<<flag[i]<<endl;
            return;
        }
    }


}


//第i个参量，剩余num
void dfs(int cur,int num)
{
    for(int i=flag[cur-1];i<=num;i++)
    {
        if(num-i==0)
        {
            flag[cur]=i;
            Prin();
            flag[cur]=0;
            return;
        }
        flag[cur]=i;
        dfs(cur+1,num-i);
        flag[cur]=0;
    }
}




int main()
{

    ios::sync_with_stdio(0);
    cin.tie(0);
    flag[0]=1;
    cin>>N;
    dfs(1,N);


    return 0;
}

```









### 2.动态规划（一般）



先回顾一下放苹果问题:

（1）放苹果问题 

**dp[i] [j]  的含义是     i个苹果放在j个盘子中的方法数**
$$
dp[i][j]=
\begin{cases}
dp[i][i]&\text{j>i   ，也即盘子数大于苹果数}\\
dp[i][j-1]+dp[i-j][j]&\text{i $\geq$ j，也即苹果数大于等于盘子数}
\end{cases}
$$




再来看整数划分问题

（2）.整数划分问题：

第一种理解方式：**dp[i] [j] 的含义是     数字i，最大加数不大于j的划分数**           可见递归式相同
$$
dp[i][j]=
\begin{cases}
dp[i][i]&\text{i<j, 也即当最大加数大于数字本身时}\\
dp[i][j-1]+dp[i-j][j]&\text{i>=j,也即当最大加数小于数字本身时}
\end{cases}
$$
第二种理解方式：**dp[i] [j]的含义是     数字i，单次划分个数不超过j 的划分数**  和放苹果完全一样了！





### 3.动态规划（完全背包）

这个跟完全背包相比有什么相同呢

数字n的划分 $\iff$ 物品重量等于n的 方案数  ，其中物品 i 的重量为 i 

dp[i] [j]: 前i个物品 总重等于 j 的方案数

与完全背包不同的只是递推公式 （完全背包是 max 这里是求和） 矩阵完全相同

dp[i] [j] 	=	dp[i-1] [j]+dp[i-1] [j-w[i]]+.....	=	$\sum_{k=0}^{}$ dp[i-1] [j-k*w[i]]  (k>=0)  =            dp [ j ]+dp [ j - i ]

参考https://blog.csdn.net/Mr_Kingk/article/details/105690290



## 九、矩阵连乘



## 十、合并果子







## 十一、三角形下走

**输入样例:**

在这里给出一组输入。例如：

```in
5 
7 
3 8 
8 1 0 
2 7 4 4
4 5 2 6 5 
```

**输出样例:**

```out
30
```

求从顶端到底端三角形往下走的最大路径

形式化：定义dp[i] [j] :代表三角形下走到a[i] [j]时的最大路径，   则解为 Max ( dp[n] [j] )   $1 \leq j \leq n$

递推方程：
$$
dp[i][j]=max
\begin{cases}
dp[i-1][j-1]\\
dp[i-1][j]  
\end{cases}
  +a[i][j]
$$


临界条件是：dp[1] [1]=a[1] [1]

```java
public class PTA4_1数字三角形 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[][]=new int [n+2][n+2];
		int dp[][]=new int [n+2][n+2];
		for (int i = 1; i <= n; i++) {
			for(int j=1 ; j<=i ; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		dp[1][1]=a[1][1];
		for(int i=2 ; i<=n ; i++)
			for(int j=1 ; j<=i; j++)
			{
				dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j])+a[i][j];
			}
		
		int max=0;
		for(int i=1;i<=n;i++){
			if(dp[n][i]>max) max=dp[n][i];
		}
		System.out.println(max);

	}//main
}
```

优化

```java
public class PTA4_1数字三角形 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int [n+2];
		int dp[][]=new int [2][n+2];
		a[1]=sc.nextInt();
		dp[1][1]=a[1];
		for(int i=2 ; i<=n ; i++)
			for(int j=1 ; j<=i; j++)
			{
				a[j]=sc.nextInt();
				dp[i%2][j]=Math.max(dp[(i-1)%2][j-1], dp[(i-1)%2][j])+a[j];
			}
		
		int max=0;
		for(int i=1;i<=n;i++){
			if(dp[n%2][i]>max) max=dp[n%2][i];
		}
		System.out.println(max);

	}//main
}
```





## 十二、寻找最长回文子串

[LeetCode0005. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)

题意：给你一个字符串 `s`，找到 `s` 中最长的回文子串。



**分析：**

- Boolean dp[i] [j]的含义是：字符串从i到j组成的子串是否是回文。 (约束： j>=i  当不满足时为false)



- 状态转移方程：

$$
dp[i][j]=
\begin{cases}
true & ,dp[i+1][j-1]\&\&str[i]==str[j] \\
false & ,else
\end{cases}
$$

观察得：以上方程只对子串length>=3时有效



- 边界条件：

$$
\begin{cases}
dp[i][i]=true\\
dp[i][i+1]=(str[i]==str[i+1])
\end{cases}
 \\ 针对lenth=1和length=2的情况
$$





- 构造最优解：dp[i] [j]为true中 j-i+1 的最大值  



- **注意事项**：

此题有特殊之处，根据状态转移方程观察出，**是从长度较短的字符串向长度较长的字符串进行转移的（<u>而且一定是先for循环len，再for循环i）</u>。**不能向以前那样单纯的i++ ，j++。




**DP解法**



```java
package leetcode;

public class P0005_最长回文子串 {
	public static void main(String[] args) {
		System.out.println(new P0005_最长回文子串().longestPalindrome("ac"));

	}//main
	
    public String longestPalindrome(String s) {
    	int N = s.length();
    	boolean dp[][]=new boolean[N][N];//dp[i][j]的含义是：index from i to j 代表的子串是否回文
    	for(int len = 1; len <= N;len++) {
    		for(int i = 0;i+len-1 < N;i++) {
    			if(len==1) dp[i][i]=true;
    			else if(len==2) dp[i][i+1]=(s.charAt(i)==s.charAt(i+1));
    			else {
    				dp[i][i+len-1]=(dp[i+1][i+len-2]&&s.charAt(i)==s.charAt(i+len-1));
    			}
    		}
    	}
    	//  此处出现错误！不能这样，应该先len后i
//    	for(int i = 0; i < N; i++) {
//    		for(int len =1; len <= N-i;len++ ) {
//    			if(len==1) dp[i][i]=true;
//    			else if(len==2) dp[i][i+1]=(s.charAt(i)==s.charAt(i+1));
//    			else {
//    				dp[i][i+len-1]=(dp[i+1][i+len-2]&&s.charAt(i)==s.charAt(i+len-1));
//    			}
//    		}
//    	}
    	int Maxlen=0;
    	int Maxi=0,Maxj=0;
    	for(int i=0;i<N;i++) {
    		for(int j=i;j<N;j++) {
    			if(dp[i][j]&&j-i+1>Maxlen) {
    				Maxlen=j-i+1;
    				Maxi=i;
    				Maxj=j;
    			}
    		}
    	}
    	//返回字符串中最长的回文子串
    	return s.substring(Maxi, Maxj+1);//注意substring 是[from,to) 后闭！！
    }
}
```





## 十三、比特位计数

题目链接

> 题意:给定一个数n ，求0-n  每个数二进制表示1的个数

分奇数和偶数：

- 偶数的二进制1个数超级简单，因为偶数是相当于被某个更小的数乘2，乘2怎么来的？在二进制运算中，就是左移一位，也就是在低位多加1个0，那样就说明`dp[i] = dp[i / 2]`
- 奇数稍微难想到一点，奇数由不大于该数的偶数+1得到，偶数+1在二进制位上会发生什么？会在低位多加1个1，那样就说明`dp[i] = dp[i-1] + 1`，当然也可以写成`dp[i] = dp[i / 2] + 1`

```java
    public int[] countBits(int num) {
        int dp[]=new int[num+1];
    	for(int i = 1 ; i <= num; i++) {
    		dp[i]=(i&1)==0? dp[i/2]:dp[i-1]+1;
    	}
    	return dp;
    }
```









# 其它

**怎样找一个问题的子问题**

如01背包 

总问题是 求 书包W  、物品n时 的最大 prize

怎样求这个问题？ 直接想不好想，可不可以由其他量问题 构造出来？或者直接出来

 

量问题或至直接问题规模太大，想办法缩小到可以解决的规模

所以要缩小规模 也即找子问题





想状态：				

dp[i] [j] 含义是 从前i个物品中 背包总承重不超过j的最大价值

构造最优解：也即dp[n] [W];  （最优解怎样构造依照状态决定）



怎样==找子问题：找递推式==

问题是  从前i个物品中 背包总承重不超过j的最大价值 怎样寻找子问题 （缩小规模）

可不可以转化成从i-1个物品中选呢？ 可以，这时i可以选或者不选







**<u>大问题可以分解（分类）为子问题</u>**

**<u>子问题（经某些运算）得到大问题</u>**





从现在开始找子问题时，要将大问题分类分解为子问题，要从子问题推**得**大问题

也即找递推式时，依据分解的情况 列举子问题的种类，然后由每个子问题推大问题

[j]: 



[str2.length()-1]: 
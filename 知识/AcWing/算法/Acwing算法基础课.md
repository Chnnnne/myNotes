Acwing 

:large_blue_diamond: :large_orange_diamond:

---

# 基础算法

## 排序

### 快排

O(nlogn)

思路：找一个枢轴，然后让数组根据枢轴排成左右两半，递归该过程

```C++
#include<bits/stdc++.h>
using namespace std;

const int N = 100010;
int n, a[N];

void quick_sort(int q[], int l, int r)
{
    if (l >= r) return;

    int i = l - 1, j = r + 1, x = q[l + r >> 1];//选定枢轴
    while (i < j)
    {
        do i ++ ; while (q[i] < x);//细节:不能等于！！！！！！ 
        do j -- ; while (q[j] > x);
        if (i < j) swap(q[i], q[j]);
    }
    quick_sort(q, l, j), quick_sort(q, j + 1, r);//注意是j 而不是i
}
void quick_sort(int q[], int l, int r)
{
    if(l >= r) return;
    int i = l - 1, j = r + 1, x = q[l + r >> 1];
    while(i < j)
    {
        do i++; while(q[i] < x);
        do j--; while(q[j] > x);
        if(i < j) swap(q[i], q[j]);
    }
    quick_sort(q, l, j)
}
int main(){
    cin >> n;
    for(int i =0; i < n; i++ ){
        cin >> a[i];
    }
    quick_sort(a, 0, n - 1);
    for(int i = 0; i < n; i++){
        cout<< a[i] << " ";
    }
    return 0;
}
```



### 快选

不明白为什么退出while后 ， i不等于j 不明白为什么q[j]不等于x

先死记硬背了，那个注意

```C++
#include<iostream>
using namespace std;
const int N = 100010;
int n,k,a[N];

int  quick_sort(int q[], int l, int r, int k){
    if( l >= r) return q[l];
    int i = l - 1, j = r + 1,x = q[l + r >> 1];
    while(i < j){
        do i++; while(q[i] < x);
        do j--; while(q[j] > x);
        if(i < j) swap(q[i],q[j]);
    }
    if(k <= j - l + 1) return quick_sort(q,l,j,k);//注意！！！！！
    else return quick_sort(q,j+1,r,k-(j-l+1));//注意！！！

}

int main()
{
    cin>>n>>k;
    for(int i =0 ; i < n;i++){
        cin >> a[i];
    }
    cout<< quick_sort(a,0,n-1,k);
    return 0;
}
//我的错误的↓
#include<bits/stdc++.h>
using namespace std;
const int N = 100010;
int n, k, a[N];

int quick_select(int q[], int l, int r, int k){
    if(l >= r) return q[l];
    int i = l - 1, j = r + 1, x = q[l + r >> 1];
    printf(" x=%d ",x);
    while(i < j)
    {
        do i++; while(q[i] < x);
        do j--; while(q[j] > x);
        if(i < j) swap(q[i], q[j]);
    }
    printf(" q[j]=%d q[i] = %d\n", q[j], q[i]);
    if(j - l + 1 == k) return q[j];
    if(j - l + 1 >= k) return quick_select(q, l, j , k); 
    return quick_select(q, j + 1, r, k - (j - l + 1));
}
int main(){
    scanf("%d%d", &n, &k);
    for(int i = 0; i < n; i++){
        scanf("%d",&a[i]);
    }
    int ans = quick_select(a, 0, n - 1, k);
    printf("%d", ans);
    
    return 0;
}
```

### 归并排序

思路：不断地合并两个有序的序列成一个新的有序序列

nlogn

```C++
#include<bits/stdc++.h>
using namespace std;

const int N = 100010;

int n, a[N], tmp[N];

void merge_sort(int q[],int l, int r){
    if( l >= r) return;
    int mid = l + r >> 1;
    merge_sort(q, l, mid);
    merge_sort(q, mid + 1, r);
    int k = 0, i = l, j = mid + 1;
    while(i <= mid && j <= r){
        if(q[i] <= q[j]) tmp[k++] = q[i++];
        else tmp[k++] = q[j++];
    }
    while(i <= mid){
        tmp[k++] = q[i++];
    }
    while(j <= r){
        tmp[k++] = q[j++];
    }
    for(i = 0; i < k;i++){
        q[l + i] = tmp[i];
    }
}

int main(){
    cin >> n;
    for(int i = 0; i < n; i++)
        cin >> a[i];
    merge_sort(a,0,n-1);
    for(int i = 0; i < n; i++)
        cout << a[i] <<" ";
    
    return 0;
}
```







## 二分

用二分的方法搜索一个解空间，得到满足某个性质的区间端点

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210311174751659.png" alt="image-20210311174751659" style="zoom: 50%;" />

需要注意的是，我们需要根据题意写Check，也即根据题意规定性质，什么是性质呢？就是根据题意自定的条件，比如我们定性质是 **区间自变量x小于X** 那么区间就是左绿右红，在绿区间中的x都满足小于X，Check的工作是检查mid自变量是否满足性质，再利用二分的模板就可以找到 绿区间的端点，也即小于X的最大值。 注意每次二分后的新区间都应该包含答案（区间端点）。

从图上来看，**二分模板就是求满足性质的区间的端点**。求得的端点不一定就是问题的答案，但是我们利用二分求得满足某性质的边界了（最大值、最小值）！！！！，这点很重要。比如问题是求一个有序数组中，x的出现位置最小和最大index。虽然利用二分无法直接求出，但是我们可以利用二分找到满足数组中，**满足性质(区间自变量x大于等于X）**的区间的边界的index（对应上图为左红右绿，左端点），这样就可以找到初次出现的位置。同理，我们可以利用二分模板找到满足 数组中，小于等于X的边界(对应上图为左绿右红，右端点)。

- 另外要注意的是，我们要清楚二分的是什么，比如二分的是位置index，那么就要注意不是value

- 单调性可以二分，但二分不一定非得具有单调性

- 二分的本质是边界，**只要找到某种性质，使得整个区间一份为二（一半区间所有的自变量点都满足，一半区间的自变量点都不满足）**，那么就可以把这个边界点二分出来。

- 问题：怎样根据问题确定性质呢？

- 性质精确地用**自然语言描述**： 性质就是 **自变量x满足什么条件**  check（x）。这个自变量x就是指数轴上的点。因此性质可以确定一个区间

- 二分的题一般都是求满足题意的最小值，或者最大值，通常这种题都比较容易判断一个数是否满足题意。

- 二分某种性质的端点，是一定可以二分出来的，只不过这个点不一定是题的答案。

- **二分答案要求满足条件的答案单调 ，否则你就不能确定下一次查找答案所在的区间**

- 此外：求满足某种性质的区间的端点target时，比如左红右绿，当target在初始解区间 [ l , r ] 之外时，比如target<a[l] 那么最终退出循环时， l=r=解区间左端点，也即target移出区间外了 就变成区间端点了。当target>a[r]时， l=r=解区间右端点。也即当答案区间在初始区间之外（初始区间所有值都不满足性质）根据模板类型，它最终会以一个区间端点值退出。

  







### 一、模板

#### 1、**整数二分模板**

写法：首先确定l、r区间，然后再根据性质决定是左绿右红还是左红右绿，之后写模板：
int l; int r; while(l < r)  {int mid = (l + r + 1左绿右红加1左红右绿不加1) if(check(mid)) l = mid else r = mid - 1} 

**左绿右红则** 

1. l = mid      
2. 加一 mid = (l + r + 1) >> 1

```C++
bool check(int x) { ... } // 检查x是否满足某种性质

int main()
{
    int l = 1, r = n;
    while (l < r)
    {
        int mid = (l + r + 1) >> 1; //注意溢出
        if (check(mid)) l = mid;
        else r = mid - 1;
    }
    //get r or l
    return 0;
}

int l = 0, r = n;
while(l < r)
{
	int mid = (l + r + 1) >> 1;
    if(check(mid)) l = mid;
    else r = mid - 1;
}
```



**左红右绿**

1. r = mid
2. 不加一

```C++
//右绿  r=mid
bool check(int x) {/* ... */} // 检查x是否满足某种性质

// 区间[l, r]被划分成[l, mid]和[mid + 1, r]时使用：
int bsearch(int l, int r)
{
    while (l < r)
    {
        int mid = (l + r) >> 1;     
        if (check(mid)) r = mid;    // check()判断mid是否满足性质
        else l = mid + 1;
    }
    return l;
}
```





#### 2、**浮点数二分**

```java
bool check(double x) {/* ... */} // 检查x是否满足某种性质

double bsearch_3(double l, double r)
{
    const double eps = 1e-6;   // eps 表示精度，取决于题目对精度的要求,
    while (r - l > eps)
    {
        double mid = (l + r) / 2;
        if (check(mid)) r = mid;
        else l = mid;
    }
    return l;
}
```

- eps 表示精度，取决于题目对精度的要求,一般的规律是：比如要求是五位小数，那么eps取到1e-7，六位就是1e-8，也即大两位
- 因为l，r是答案所在的边界，因此要特别注意下答案不能在它之外。如果在其之外，那么二分出来的结果是答案设定的区间的边界，可能不正确
- 注意模板区别，r l mid 都是double，不用加一减一直接赋值mid，而且是/2 不是>>1  



#### **小总结**

- 二分的一大难点在于，怎样根据题目要求，确定要二分什么变量，确定什么性质。比如问题是求一个浮点数n的三次方根，那么我们可以二分性质小于等于 $\sqrt[3]{n}$，从而得到边界端点，也就是答案。

- 步骤：
  - 判断能否二分：最大化最小值，最小化最大值，或题目明显有单调性的答案区间（一段满足，另一段不满足）且答案容易判断满不满足
  - 分离答案， 也即我要二分什么，一般根据题目的最后一句可以知道
  - 定答案区间，定性质
  - 根据答案定二分模板
  - 写出二分模板，求端点
  - 再运算出答案

  

问题->抽象->性质->二分模板->端点->答案

一道题如果满足1.答案区间单调（存在端点一分为二）且2.答案是否满足题意容易判断，那么我们就可以用二分了



### 二、题目

#### [数的范围](https://www.acwing.com/problem/content/791/)

> 题意：求一个有序数组中，某数出现的第一个位置和最后一个位置。没有则返回-1 -1

整数二分

```C++
#include<bits/stdc++.h>
using namespace std;
const int N = 100010;
int a[N], n, q;


//元素k出现的起始位置
int query1(int k)
{
    //等价于找到>=k的区间左端点,左红 右绿
    //套用二分模板：二分的变量是数组index，性质是a[自变量x] >= k
    int l = 0, r = n - 1;
    while(l < r)
    {
        int mid = l + r >> 1;
        if(a[mid] >= k) r = mid;
        else l = mid + 1;
    }
    if(a[l] != k) return -1;
    else return l;
    
}
//元素k出现的最后的位置
int query2(int k)
{
    //等价于找到<=k的区间右端点，左绿 有
    //套用二分模板：二分的变量是数组index，性质是a[自变量x] <= k
    int l = 0, r = n - 1;
    while(l < r)
    {
        int mid = l + r + 1>> 1;
        if(a[mid] <= k) l = mid;
        else r = mid - 1;
    }
    if(a[l] != k) return -1;
    else return l;
}

int main(){
    scanf("%d%d", &n, &q);
    for(int i = 0; i < n; i++)
        scanf("%d",&a[i]);
    while(q--){
        int k;
        scanf("%d", &k);
        int ans1 = query1(k);
        int ans2 = query2(k);
        printf("%d %d\n", ans1, ans2);
    }
    return 0;
}
```



```java
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		int a[]=new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();
		}
		for (int i = 0; i < q; i++) {
			int x=sc.nextInt();
			
			//下面开始求x出现的第一个位置
			//二分求满足大于等于x性质的左边界
			int l=0,r=n-1;
			while(l<r) {
				int mid=(l+r)>>1;
				if(check1(mid,x,a)) r=mid;//求的是index，比的是值
				else l=mid+1;
			}
			if(a[l]!=x) System.out.println("-1 -1");
			else {
				System.out.print(l+" ");
				
				//下面开始求x出现的最后一个位置
				//二分求满足小于等于x性质的右边界
				l=0; r=n-1;
				while(l<r) {
					int mid=(l+r+1)>>1;
					if(check2(mid, x,a)) l=mid;
					else r=mid-1;
				}
				System.out.println(l);
			}
			
		}

	}//main

	private static boolean check2(int mid, int x, int[] a) {
		if(a[mid]<=x)
			return true;
		return false;
	}

	private static boolean check1(int mid, int x, int[] a) {
		if(a[mid]>=x)
			return true;
		return false;
	}
}
```





#### [数的三次方根](https://www.acwing.com/problem/content/792/)

浮点数二分

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		
		double l=-10000,r=10000;
		double eps=1e-8;
		while(r-l>eps) {
			double mid=(l+r)/2;
			if(check(mid,n)) l=mid;
			else r=mid;
		}
		System.out.printf("%.6f",r);

	}//main

	private static boolean check(double mid, double n) {
		if(mid*mid*mid<=n)
		return true;
		return false;
	}
}
```





#### [砍树](https://www.luogu.com.cn/problem/P1873)

> N表示树木的数量，a[i]表示树i的高度，M表示需要的木材总长度
>
> 求砍树的最大高度

整数二分，使用Reader加速 才过

分析：这道题是求**伐木机的最大高度h**，使得砍的时候砍掉的树长度之和>=M，分析可得伐木机的高度是具有单调性的，也即在一个区间内所有的高度都可满足题意，而另一个区间都不满足，我们要求的就是满足题意的那个区间(左区间的右端点)。再分析：当给定一个伐木机高度，判断是否能满足题意时，我们的做法是遍历，因此总的时间复杂度是O(nlogn)。

综上所述：这道题可以用二分模板了！因为它满足区间单调性，以及答案好判断性，因此我们可以用二分。

代码实现：二分的变量是伐木机的高度，答案区间是[0 , maxTree],左绿右红，性质是区间内自变量x**满足**可以砍伐掉长度之和>=M，因此check函数也就定下来了。

```java
public class 洛谷P1873_砍树 
{
	public static void main(String[] args) throws IOException {
		int N=Reader.nextInt();//树木的个数
		int M=Reader.nextInt();//需要的木材长度
		int a[]=new int[N];
		long sum=0;
		for (int i = 0; i < N; i++) {
			a[i]=Reader.nextInt();
		}
		int l=0,r=1000000000;
		while(l<r) {
			int mid=(l+r+1)>>1;
			if(check(mid,a,M)) l=mid;
			else r=mid-1;
		}
		System.out.println(l);

	}//main
	//判断砍mid高度 是否满足高度大于等于M
	private static boolean check(int mid, int[] a, int m) {
		long sum=0;
		int len=a.length;
		for(int i=0;i<len;i++) 
			if(a[i]>mid)	sum+=a[i]-mid;
		if(sum>=m)
			return true;
		return false;
	}
}
```



#### [剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

> 求有序数组中缺失的那一项 ，题意没理解清楚
>
> ```
> [0,1,2,3,4,5,6,7,9] 少一个8
> ```

整数二分

注意：没有用左绿 右红的模板 ，因为！！ 假如用左绿右红的模板，那么性质是mid=nums[mid]，那么问题的解就是绿色的边界再+1。但是当数组长度为1时也即[1]，那么根本不存在绿色的区域了！！这样二分出来的结果是设定答案区间的左边界0,不符合题意了。

因此用左红右绿的模板：二分的变量是下标，l = 0 r = nums.length,  性质是 区间内所有的自变量x都满足下标不等于数组的值。那么就可以顺利写出check函数了。

```java
class Solution {
public int missingNumber(int[] nums) {
    	int l=0,r=nums.length;
    	while(l<r) {
    		int mid=(l+r)>>1;
    		if(check(mid,nums)) r=mid;
    		else l=mid+1;
    	}
    	return l;
    }

	private boolean check(int mid, int[] nums) {
		if(nums[mid]!=mid)
			return true;
		return false;
	}
}
```



#### [540. 有序数组中的单一元素](https://leetcode-cn.com/problems/single-element-in-a-sorted-array/)

> 题意：在一个有序数组nums中，除了一个数之外，其他元素均出现两次(nums长度为奇数)，求出这个只出现一次的数

整数二分

用的左绿右红的模板，注意因为左绿右红，且出现单一的元素可能在第一个位置上 index0，所以l要等于-1。二分的区间变量是数组index，记为x。性质是，**所有小于等于x位置的元素都非单一元素**。则二分出来的区间端点的下一个就是答案。

```java
    public int singleNonDuplicate(int[] nums) {
    	
    	int l=-1,r=nums.length;
    	while(l<r) {
    		int mid=(l+r+1)>>1;
    		if(check(mid,nums)) l=mid;
    		else r=mid+1;
    	}
    	
    	return nums[l+1];
    }

    //判断nums[mid]是否处于单一元素的左边
	private boolean check(int mid, int[] nums) {
		if(mid%2==0) {
			if(mid==nums.length)
				return false;
			if(nums[mid]==nums[mid+1])
				return true;
			else
				return false;
		}
		else {
			if(nums[mid]==nums[mid-1])
				return true;
			else
				return false;
		}
	}
```







#### [POJ1064分割出来的绳子的最大值](https://vjudge.net/problem/POJ-1064)

> 题意：给定数组代表每条绳子的长度，然后现在要求把这些绳子切割成等长的K端，求最大值。

浮点数二分

分析：因为答案(每条等长绳子的长度x)1、具有单调、区间的性质，也即一半区间满足要求，一半不满足要求。2、且容易判断能否把给定的绳子切割成k段等长的x。因此可以二分！

代码实现：二分的变量是每条绳子的长度，答案区间是[0,min(给定的绳子长度)]，二分模板是左绿右红，性质是左区间自变量x 满足 能把给定的绳子切成k端等长的长度为x的绳子

一直WA，不知道哪里错了

```java
package AcWing.二分;

import java.io.IOException;

public class POJ1064_分割绳子 {
	public static void main(String[] args) throws IOException 
    {
		int N = Reader.nextInt();
		int K = Reader.nextInt();
		double L[]=new double[N];
		for (int i = 0; i < N; i++) {
			L[i] = Reader.nextDouble();
		}
		double l=0,r=100000;
		double eps=1e-5;
		while(r-l>eps) {
			double mid=(l+r)/2;
			if(check(mid,K,L)) l=mid;
			else r=mid;
		}
		System.out.printf("%.2lf",Math.floor(l*100)/100);
	}//main
	//可以得到K条长度为mid的绳子
	private static boolean check(double mid, int k, double[] len) {
		int length = len.length;
		int count=0;
		for(int i=0;i<length;i++)
			count+=(int)(len[i]/mid);
		return count>=k;
	}
}
```

**Math.floor(l*100)/100  这一步是保留两位小数，但是不四舍五入！！！！！！！**









#### 最大化平均值（挑书中的题)

> 题意：n个物品，每个物品的重量和价值分别是w[i]和v[i]，从中选出K个，使得单位重量的价值最大。
>
> n=3  k=2   w[]={2,5,2}  v[]={2,3,1}  
>
> 最大单位价值是0.75

分离答案： K个物品的单位价值  x

性质：可以选择出来K个物品，使得这K个物品的单位价值大于等于x

这样二分出来的端点就是单位重量的最大值了

性质怎么快速判断呢？
$$
性质是：\sum^{k个} vi/\sum^{k个} wi \geq x
$$
变形
$$
\sum^{k个}vi -\sum^{k个}wi*x\geq 0 \\也即(v1+v2+...+vi)-(w1+w2+...+wi)*x\geq 0
$$
因此再变形得
$$
\sum^{k个}(vi-wi*x) \geq0
$$
因此我们只需判断vi-wi*x的最大的k个之和是否满足大于等于0即可

```java
public class 最大平均值 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int []w=new int[n];
		int []v=new int[n];
		for (int i = 0; i < n; i++) {
			w[i]=sc.nextInt();
			v[i]=sc.nextInt();
		}
		
		double l=0,r=999999999;
		double eps=1e-5;
		while(r-l>eps) {
			double mid=(l+r)/2;
			if(check(mid,k,w,v)) l=mid;
			else r=mid;
		}
		System.out.println(l);
	}//main

	//判断 是否 可以选择出来K个物品
	//使得这K个物品的单位价值大于等于mid
	private static boolean check(double mid, int k, int[] w, int[] v) {
		int n=w.length;
		Double y[]=new Double[n];
		for (int i = 0; i < n; i++) {
			y[i]=v[i]-mid*w[i];
		}
		
		Arrays.sort(y, (d1,d2)->(int)Math.signum(d2-d1));;
		double Maxsum=0;
		for (int i = 0; i < k; i++) {
			Maxsum+=y[i];
		}
		return Maxsum>=0;
	}
}
```





## 高精度











---

## 前缀和&差分

- 前缀和数组  、差分数组，**下标从1开始，一般原数组也是从1开始**，这样对应起来方便
- 前缀和的作用是快速求区间（或矩阵）和，差分的作用是给区间（或矩阵）加一定的值



前缀和的作用:	一维前缀和先花费On的时间求出前缀和数组，之后就可以用O1的时间求出区间和。二维前缀和先花费O$n^2$的时间求前缀和，然后O1的时间求出子矩阵和

差分的作用:	先花费On的时间求出原数组的差分数组(原数组是差分数组的前缀和数组)，之后就可以用O1的时间完成给某区域内全部值加上一个数，再用On的时间还原出原数组。 或者利用insert函数完成初始化





### 一、前缀和

**一维前缀和**

两个概念：原数组a、前缀和数组presum

1、怎样求前缀和？			for(int i=1;i<=n;i++)	presum[i] =presum[i-1]+a[i]

2、怎样求区域和？			求[l,r]区域的和  就是presum[r]-presum[l-1]

```java
public class Main {
	public static void main(String[] args) throws IOException {
		int n = Reader.nextInt();//n个数
		int m = Reader.nextInt();//m个询问
		int a[]=new int[n+1];
		int presum[]=new int[n+1];
        //求前缀和
		for (int i = 1; i <= n; i++) {
			a[i] = Reader.nextInt();
			presum[i]=presum[i-1]+a[i];
		}
		while(m--!=0) {
			int l = Reader.nextInt();
			int r = Reader.nextInt();
			System.out.println(presum[r]-presum[l-1]);
		}
	}//main
}
```

可以优化到不需要a数组





**二维前缀和**

​																		要画图！！！注意index从1开始

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210312221655371.png" alt="image-20210312221655371" style="zoom:50%;" />



1、怎样求前缀和？

```java
presum[i][j] = presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1] + a[i][j];
```

2、怎样求子矩阵和？			求矩阵(x1,y1)   (x2,y2)之间的和

```java
area = presum[x2][y2] - presum[x2][y1-1] - presum[x1-1][y2] + presum[x1-1][y1-1];
//简记为presum[x2][y2]- 【x2不变】【y1-1】 - 【x1-1】【y2不变】+【x1-1】【y1-1】
```



```java
public class Main {
    public static void main(String[] args) throws IOException {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int q = Reader.nextInt();
        int a[][]=new int[n+1][m+1];
        int presum[][]=new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j]=Reader.nextInt();
            }
        }

        //求矩阵前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                presum[i][j]=presum[i-1][j]+presum[i][j-1]+a[i][j]-presum[i-1][j-1];
            }
        }

        //求子矩阵和
        while(q--!=0) {
            int x1 = Reader.nextInt();
            int y1 = Reader.nextInt();
            int x2 = Reader.nextInt();
            int y2 = Reader.nextInt();
            System.out.println(
            presum[x2][y2]-presum[x2][y1-1]-presum[x1-1][y2]+presum[x1-1][y1-1]     
                    );

        }

    }//main
}
```



### 二、差分

原数组是差分数组的前缀和数组

差分的作用:	先花费On的时间求出原数组的差分数组，之后就可以用O1的时间完成给某区域内全部值加上一个数，再用On的时间还原出原数组。也即**当很多次需要给某个区间(矩阵)加一个值的时候，我们可以用差分。**朴素的做法是O(mn)m次操作 长度为n的数组，而差分是O(2n + m)

分析：要让a数组 [l,r]区间内，每个数都加一个c。暴力的复杂度是O(n)，我们可以利用差分来优化这个问题。构造a数组的差分：b数组。然后让b[l]+c，**b[l]+c的效果是，从a[l]到a[n]都加了个c**。因为从 a[l] 到 a[n] 在求 b 数组前缀和时，都会加到b[l]。因此我们要让[l,r]区间加上c，就需要让**b[l]+c，b[r+1]-c**。

由原数组a求差分数组b可以通过定义：原a数组是b的前缀和数组，也即b[i] = a[i] - a[i - 1]. 可以换一种思路：原数组a，我们可以认为全部0，其初值先忽略，因此差分数组b也全部为0。比如给定数组 a[1...5]= 1,9,5,4,3 我们可以认为是在a数组为0的情况下执行了5次插入操作，也即5次让一个长度为1的区间增加值。



**一维差分**

两个概念：原数组a、差分数组b

1、怎样根据原数组求差分数组b？				差分数组可以用原数组两项之差来求。（其实！差分都不用考虑构造！因为可以让a数组全部为0，b数组全部为0，然后再在b上加上c'）

> 构造b[n]差分数组看起来很难，其实根本就不用刻意去构造它。
> 如果将a数组中[l,r]部分的数据全部加上c看作一次插入操作，那么构造的过程可以看作是将a进行了n次插入操作。第一次在[1,1]的范围插入了a[1],第二次在[2,2]范围插入a[2]，第二次在[3,3]范围插入a[3]……，以此类推，进行n次插入后，那么数组a就正好是数组b的前缀和了。

2、怎样给原数组区间a[l,r] 加上一定的值？		b[l]+=c  、b[r+1]-=c

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210313091038251.png" alt="image-20210313091038251" style="zoom: 50%;" />

```java
public class Main {
    //insert函数！
	static void insert(int l,int r,int c,int b[]) {
		b[l]+=c;
		b[r+1]-=c;
	}
    
	public static void main(String[] args) throws IOException {
		int N = Reader.nextInt();//数组元素数
		int M = Reader.nextInt();//操作数
		int a[]=new int[N+10];//原数组
		int b[]=new int[N+10];//差分数组
		
		for(int i = 1; i <= N; i++) a[i]=Reader.nextInt();
		
		for(int i = 1; i <= N; i++)	insert(i,i,a[i],b);
		
		while(M--!=0) {
			int l=Reader.nextInt();
			int r=Reader.nextInt();
			int c=Reader.nextInt();
			insert(l, r, c, b);
		}
		for(int i = 1; i <= N; i++) a[i]=a[i-1]+b[i];
		for(int i = 1; i <= N; i++) System.out.print(a[i]+" ");;

	}//main

}
```





**二维差分**

原矩阵a[ ] [ ], 差分矩阵 b[ ] [ ]      （a矩阵是b矩阵的前缀和矩阵）

1、怎样求原矩阵a的差分矩阵b？   
不用考虑如何构造的，只知道如何更新的就行了，也即插入了一个1乘1的矩阵。也即进行了n*n次的插入操作

2、怎样给a的子矩阵(x1, y1, x2, y2)加上一定的值？ 
b[x1] [y1] += c的效果是(x1, y1) 以下所有a数组元素都加上了c  。因此应该是

```java
b[x1][y1] += c;
b[x1][y2+1] -= c;
b[x2+1][y1] -= c;
b[x2+1][y2+1] += c;
```

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210313093058268.png" alt="image-20210313093058268" style="zoom:50%;" />

3、由差分数组再还原成原数组 ： 根据定义原a数组是b数组的前缀和数组

```java
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Reader {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = new StringTokenizer("");

	static String next() throws IOException {// 读取下一个字符串
		while (!tokenizer.hasMoreTokens()) {// 返回是否还有分隔符
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();// 返回从当前位置到下一个分隔符的字符串
	}

	static String nextLine() throws IOException {// 读取下一行字符串
		return reader.readLine();
	}

	static int nextInt() throws IOException {// 读取下一个int型数值
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {// 读取下一个long型数值
		return Long.parseLong(next());
	}

	static double nextDouble() throws IOException {// 读取下一个double型数值
		return Double.parseDouble(next());
	}
}
public class Main {
    //给原数组a (x1,y1,x2,y2)区间加上c
	static void insert(int x1,int y1,int x2,int y2,int c,int b[][]) {
		b[x1][y1]+=c;
		b[x1][y2+1]-=c;
		b[x2+1][y1]-=c;
		b[x2+1][y2+1]+=c;
	}
    
	public static void main(String[] args) throws IOException {
	    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = Reader.nextInt(); //原数组行数
		int m = Reader.nextInt(); //原数组列数
		int q = Reader.nextInt(); //q次子矩阵加值操作
		int a[][]=new int[n+5][m+5];
		int b[][]=new int[n+5][m+5];
		//求差分数组
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				insert(i, j, i, j, Reader.nextInt(), b);
			}
		}
		//给区间加上值
		while(q--!=0) {
			int x1 = Reader.nextInt();
			int y1 = Reader.nextInt();
			int x2 = Reader.nextInt();
			int y2 = Reader.nextInt();
			int c = Reader.nextInt();
			insert(x1, y1, x2, y2, c, b);
		}
		
		//还原操作：求原矩阵a, 也即b矩阵的前缀和矩阵
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				b[i][j]=b[i][j-1]+b[i-1][j]+b[i][j]-b[i-1][j-1];
			}
		}
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				out.print(b[i][j]+" ");
			}
			out.println();
			out.flush();
		}
		out.close();
		
		
		
	}//main

	
}
```





## 双指针

参考leetcode刷题笔记本！！！！！

核心思想：暴力的话双指针是On^2  ，而双指针是O2n。 也即左右指针从左端移动到右端



滑动窗口



记住l  r 有单调性，也即r每次往右移动一步，枚举，然后动态变化l  ，l不可能往左走，这样就没单调性了。











## 离散化

特指整数的离散化

值域比较大 但个数比较少，比如值域是0-10^9 ，而个数是10^5个，有些题 我们要以这些大的值为下标来做，我们不能开一个10^9大小的数组 会爆栈。形象点说： 我们需要以1、2、50、600、10000000(一千万)为下标，来解决某些问题，这显然我们不能直接开那么大的数组，很浪费空间，我们可不可以用一个离散化的a[5]的数组来代替上面的呢？也即大下标x 映射f到 小下标t，也即f(x) = t 然后 我们涉及对数组操作时，我们凡是用到原下标x时，先用f函数转换成t，来对离散化数组a[5]来操作

可以用一个函数：

```C++
 int find(x){
    //x是待离散化的值(大值)， 返回值是离散化的值(小值) 
    //中间需要一个数组来存储 小值到大值的映射 
 }  
```



两个注意点：

①、a[]中可能有重复的元素   **去重**
②、如何快速算出离散化后的值   **用二分**



映射 就是 把数组的值映射成下标，也即排序去重之后，下标就是它映射的值

也即把所有用到的下标 存到一个数组里(有序不重的排放)，我们需要获得它的下标



[区间和](https://www.acwing.com/problem/content/804/)

```C++
#include<vector>
#include<cstdio>
#include<iostream>
#include<algorithm>
using namespace std;
typedef pair<int,int> PII;
const int N = 300010;
int n, m;
int a[N], presum[N];
vector<int> alls;
vector<PII> query,add;

//把x映射到1-n
//也即把
int find(int x){
    // return lower_bound(alls.begin(),alls.end(),x) - alls.begin() + 1;
    int l = 0, r = alls.size() - 1;
    while(l < r){
        int mid = l + r >> 1;
        if(alls[mid] >= x) r = mid;
        else l = mid + 1;
    }
    return l + 1;
}

int main(){
    cin >> n >> m;
    //先把所有用到的下标，存到all里
    for(int i = 0; i < n; i++){
        int x, c;
        cin >> x >> c;
        add.push_back({x,c});
        alls.push_back(x);
    }
    for(int i = 0; i < m; i++){
        int l, r;
        cin >> l >> r;
        query.push_back({l, r});
        alls.push_back(l),alls.push_back(r);
    }
    //对all 进行排序去重处理
    sort(alls.begin(),alls.end());
    alls.erase(unique(alls.begin(), alls.end()), alls.end() );
    //至此↑ 离散化的预备工作已经完成了(把原值映射到了[1,all.size] )，下面我们再用到原下标时，先转换成离散化后的下标
    //处理每一个添加
    for(auto item : add){
        a[find(item.first)] += item.second;
    }
    for(int i = 1; i <= alls.size(); i++) presum[i] = presum[i - 1] + a[i];
	//处理每一个
    for(auto item : query){
        cout<< presum[find(item.second)] - presum[find(item.first) - 1]<<endl;
    }
}
```

```C++
//双指针 ， 一个遍历每一个元素，一个维护不重复的数组
vector<int>::iterator my_unique(vector<int> &a){
    int j = 0;
    for(int i = 0; i < a.size(); i++){
        if(!i || a[i] != a[i - 1])//两个性质 
            a[j++] = a[i];
    }
    return a.begin() + j;
}
```



## 区间合并







# 数据结构

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210713201016624.png" alt="image-20210713201016624" style="zoom:50%;" />



# 搜索和图论

见数据结构.md



# 数学知识

### 零、其他

---

a|b（“|”是整除符号），读作“a整除b” 也即a是b的约数

---

两个数的最大公约数

```C++
int gcd(int a, int b){//简记b baba    三b两a
    return b ? gcd(b, a % b) : a;
}
```

两个数的最小公倍数

```C++
int lcm(int a, int b){
    return a / gcd(a, b) * b;
}
```

---

质数定理：1~n中 有n/lnn个质数

---

**约数和因数**

**约数**只能对在整数范围内而言，而**因数**就不限于整数的范围。
例如：6×8＝48。既可以说6和8都是48的因数，也可以说6和8都是48的约数。
又如：0.9×8＝7.2。虽然可以说0.9和8都是7.2的因数，却不能说0.9和8是7.2的约数

---

**算数基本定理：** 左右的唯一确定性

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210602174914220.png" alt="image-20210602174914220" style="zoom: 67%;" />

---





### 一、质数

小总结：



>  质数（素数）和合数的概念是针对 **大于1的自然数，也即（2,3,4,5...） 。所有小于等于1的既不是合数也不是质数**

**质数的概念**：一个数是质数，当且仅当这个数是大于1的自然数，且仅包含1和自身两个约数





#### 1、质数的判定

试除法 O($\sqrt{n}$)

思路：先判断是否小于2,然后从2枚举到n/i，判断是否能除尽

```C++
//因为1既不是素数也不是合数，因此1不是素数 直接返回false
bool is_prime(int x)
{
    if (x <= 1) return false;
    for (int i = 2; i <= x / i; i ++ )
        if (x % i == 0) return false;
    return true;
}
```







#### 2、分解质因数

> **分解质因数就是把一个数分解成<u>标准分解式</u>的一个过程**
>
> $n = p_1^{k1}*p_2^{k2}*\cdots*p_m^{km}$,     其中p1,p2..pm都是素数，k是指数。
> 式子左右两边都是是唯一的,也即一个数n可以唯一确定一个标准分解式,一个标准分解式可以唯一确定一个n。

原理：**算数基本定理**

采用试除法

思路：从小到大n/i尝试n的所有因数，若能除尽则筛尽它。最后特判一下是否存在大于$\sqrt{n}$的质因数

时间复杂度：$[logn  ,\sqrt{n}]$ 

```C++
//求数n 的标准分解式 
void divide(int n)
{
    for(int i = 2; i <= n / i; i++)
    {//枚举从i到sqrt i 之间所有的质因数
        if(n % i == 0)
        {//i是因子的话，就求以i为底数的指数s的值
            int s = 0;
            while(n % i == 0)
            { //对质因数 筛到底
                n /= i;
                s ++;
            }
            printf("底数:%d 指数:%d\n", i, s);
        }
    }
    //特殊情况 存在一个大于sqrtx 的质因数
    if(n > 1) printf("底数:%d 指数:%d\n", n , 1);
}
```

细节分析：

  我们在这里枚举的是从[2, n]的所有数，注意不是质因数！那这里是不是有问题呢？ 其实没有！因为当枚举到i时，一定一定是把[2,i-1]的所有质因子给除干净了，也即枚举到i时，n一定不含[2, i - 1]之间的质因子了，因此以这些质因子为底的一些合数i都不可能整除n,也即合数都被跳过了。那么此时若有n % i == 0，也即i是新的因子时，这个i一定是质数。

一个小小的结论：数n的质因子要么全小于$\sqrt{n}$，要么最多只有一个数大于$\sqrt{n}$





#### 3、筛质数

**筛掉所有非素数，并得到一个素数表prime[] ，cnt**

思路：把每一个合数都筛掉，枚举到的数只要没被筛掉就是素数



##### 一、最朴素做法

O($nlnn$)

```C++
//N表的长度，可能求的素数的最大值
//n为所需要的素数的数据范围
int primes[N], cnt = 0;
bool st[N];//存储一个数是否被筛掉,也即true为合数， false为素数

void get_primes(int n)
{
    for(int i = 2; i <= n; i++)
    {
        if(!st[i])//没被筛掉，所以它是质数
            primes[cnt ++] = i;    
        //把每个数的倍数都筛掉
        for(int j = i + i; j <= n; j += i)
            st[j] = true;//筛掉
    }
}
```



##### 二、埃氏筛法

O($nloglogn$) 约O(n)

```C++
int primes[N], cnt = 0;
bool st[N];//存储一个数是否被筛掉

void get_primes(int n)
{
    for(int i = 2; i <= n; i++)
    {
        if(!st[i])
        { //没被筛掉，所以它是质数
            primes[cnt ++] = i;    
        	//把质数的倍数都筛掉就行了，因为合数的倍数已经被质数的倍数筛掉过了
        	for(int j = i + i; j <= n; j += i)
            	st[j] = true;//筛掉
        }
    }
}
```



##### 三、线性筛(欧拉筛)

O(n)

核心思路：**每一个合数只会被它的最小质因子给筛掉**

代码写法简记：枚举每一个数(从2到n)，是质数的话(没被筛掉的)就加入到素数表。然后枚举所有质数primes[j]，筛掉i和primes[j]的乘积，当碰到i的最小质因子时停止。

```C++
int primes[N], cnt;     // primes[]存储所有素数
bool st[N];         // st[x]存储x是否被筛掉

void get_primes(int n)
{
    for (int i = 2; i <= n; i ++ )
    {
        if (!st[i]) primes[cnt ++] = i;
        for (int j = 0; primes[j] <= n / i; j ++)
        {
            st[primes[j] * i] = true;//筛掉
            if (i % primes[j] == 0) break;//当枚举到i的最小质因子时就退出
        }
    }
}
```



带注释版：

```C++
int primes[N], cnt;     // primes[]存储所有素数
bool st[N];         // st[x]存储x是否被筛掉

void get_primes(int n)
{
    for (int i = 2; i <= n; i ++ )
    {
        if (!st[i]) primes[cnt ++ ] = i;//是质数的话则直接加入到表里
        
        
        //下面并不是像以前那样了筛掉所有i的倍数
        //而是筛掉所有 以i的倍数且是以当前已知的最小质因子筛掉的数
        
       	//for循环：枚举当前所有质数primes[j]，并筛掉以primes[j]为最小质因子的合数
        for (int j = 0; primes[j] <= n / i; j ++ ) 
        {
            st[primes[j] * i] = true;
//当没有枚举到i的最小质因子时，primes[j] * i 的最小质因子一定是primes[j]
//当质数枚举到i的最小质因子时就要退出了，因为更大的质数的话primes[j] * j就不是被最小质因子筛掉的了
            if (i % primes[j] == 0) break;
        }
    }
}
```



### 二、约数

约数/倍数的概念。 约数就是一个数的约数

小总结：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210603150110133.png" alt="image-20210603150110133" style="zoom: 50%;" />





#### 1、试除法求一个数的所有约数

思路：一个数的**约数**是成双成对出现的，我们可以枚举较小的那一个，也即小于等于$\sqrt{n}$的数。也即得到一个约数就得到了两个约数，注意特判是否是相等的

时间复杂度：O($\sqrt{n}$)，sort时间复杂度可以忽略，因为约数数组长度不超过1600

```C++
vector<int> get_divisors(int x)
{
    vector<int> res;
    for (int i = 1; i <= x / i; i ++ )//从1开始，前面关于质数的是从2开始
        if (x % i == 0)
        {
            res.push_back(i);
            if (i != x / i) res.push_back(x / i);
        }
    sort(res.begin(), res.end());//排序时间复杂度很小，可以忽略
    return res;
}
```



#### 2、一个数的约数的个数

由算数基本定理，一个合数x可以唯一地分解成一个质数相乘的式子，也即

$x = p_1^{α_1} * p_2^{α_2}*\cdots * p_k^{α_k}$

,其中p是底数 a是指数，特别注意！ **x唯一确定右边，右边也唯一确定左边**

那么x的任何一个约数d的形式：

$d=p_1^{β_1} * p_2^{β_2}*\cdots *p_k^{β_k}$ ,这里的每个$β_i$取值为$[0,α_i]$

所以，**x的约数的个数是**$(α_1+1)*(α_2+1)*\cdots*(α_k+1)$





一个小知识点：int范围内的数的约数个数最多的那个数的约数大概在1536个

扩展：从1到n所有数的约数的个数，1是n，2是n/2 ...  和是一个调和级数











#### 3、一个数的所有约数的和

接着上面的思路:一个数x的所有约数 $d$ 之和，可以写成$\sum d_i$也即$\sum p_1^{β_1} * p_2^{β_2}*\cdots *p_k^{β_k}$,一共是$(α_1+1)*(α_2+1)*\cdots*(α_k+1)$项(乘积子项)的和，而它正好是$(p_1^0 + p_1^1 +\cdots+p_1^{α_1})×(p_2^0 + p_2^1 +\cdots+p_2^{α_2})×\dots×(p_k^0 + p_k^1 +\cdots+p_k^{α_k})$的展开，因此该式就是求一个数所有约数的和的公式



```C++
#include<bits/stdc++.h>
using namespace std;
typedef long long LL;
const int mod = 1e9 + 7;
unordered_map<int, int> primes;
//分解质因数
void divide(int n)
{
    for(int i = 2; i <= n / i; i++)
    {
        while(n % i == 0)
        {
            n /= i;
            primes[i] ++;
        }
    }
    if(n > 1) primes[n]++;
}
int main()
{
    int n;
    cin >> n;
    while(n--)
    {
        int a;
        cin>> a;
        divide(a);
    }

    LL res = 1;
    for(auto it: primes)
    {
        LL sum = 0;
        LL t = 1;
        for(int i = 0; i <= it.second; i++)
        {
            sum = (sum + t) % mod;
            t = t * it.first % mod;
        }
        res = res * sum % mod;
    }
    cout<<res;
    return 0;
}
```





#### 4、欧几里得算法（辗转相除法）

**求最大公约数**

```C++
int gcd(int a, int b){
    return b ? gcd(b, a % b) : a;
}
```

简记为：b baba

**证明：**

几个基本定理：

1. 若  $d|a， d|b$,       则     $d|(ax\pm by)$
2. 很重要的公式： gcd(a, b) = gcd(b, a % b)
   证明过程：
   先做一步转换：       a % b = a - a / b * b = a - c * b，因此上式等价于证明gcd(a , b) = gcd(b, a - c * b)
   证明等式两端最大公约数相等的一个通用的证明方法：
   对于左边的任意一个公约数d ，一定有d|a, d|b,那么易得d|b ,d|a- c * b,因此左边的每一个公约数一定都是右边的公约数
   对于右边的任意一个公约数d，一定有d|b, d|a - c * b，那么易得d| a - c * b + c * b ,因此d|a , d|b所有右边的每一个公约数一定都是左边的公约数
   综上两边的公约数完全相同，也即左右边的公约数的集合是相同的。那么他们的最大公约数也一定相同！



---

# 动态规划

闫氏dp法只是一个分析方法，学好dp的方法：先整理各种模型（选择问题：背包模型）（序列问题：最长上升模型）（状态压缩、状态积、数性dp、区间、单调队列优化、斜率优化）每一个问题都要整理，考试中不是凭空想的，而是类似的，是以经验为基础的。



### 一、**闫氏DP分析法**

从集合的角度来分析问题，核心思想：有限集中的**最值**或者**个数**或者**存不存在**

**解释：**  当我们用最朴素的方法解决这类问题时，（yxc集合中元素的数量非常多指数级别）由于集合的数量非常多(DFS)，时间复杂度太高，因此用DP来优化它。

DP的两个阶段：  

1. **状态表示**  (化零为整：每次处理问题时，不是一个元素一个元素的处理，而是每次枚举一堆东西、子集、一类东西。把一些元素化成一个子集，然后用状态表示) 。 我的：变量表示的含义
2. **状态计算**(化整为零：)    我的：状态转移方程





### 二、例子

#### 1.选择问题

状态表示 一般**第一维**是考虑前i个物品， **第二维**一般是限制（比如 体积、重量、只能选几个）。每一个维度对应一个条件



01背包



---

# 关于时间复杂度

https://www.acwing.com/blog/content/32/


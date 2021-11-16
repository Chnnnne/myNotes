**Acwing算法提高课**

:laughing:

:basketball:

:heart:



# 高级数据结构

## 一、树状数组

> 背景:我们需要对一个数组a[]，快速地完成两个操作：
>
> 1. 单点修改：add(x,c)  ,也即a[c] +=c
> 2. 前缀和查询（区间查询）sum(x) ，也即求index[1,x]的和
>
> 朴素方法是 空间On 查询On 修改O1
> 前缀和是 空间O2n 查询O1修改 On
> 差分是 空间O2n 查询On 修改 O1
>
> 下面引入**树状数组**（一种数据结构和定义在上面的一组操作），借助它可以把对原数组单点修改、区间查询（前缀和查询）的动作降为Ologn



---

树状数组是一个数组结构(就是一个tr[]数组 和 三个函数操作lowbit(x) add(x,c) sum(x))  ，一个原数组a的树状数组tr，可以完成对原数组logn级别的 **单点修改、区间查询**的工作

---

树状数组的题的难点在于 你怎么看出来这道题能用树状数组，代码好写点

线段树的题的难点是在于 你很容易就看出来了这道题能用线段树，但是代码不好写

---

扩展：对a数组 区间修改,单点查询，对应于 对b差分数组 单点修改(两端)，区间查询（也即前缀和查询），因此可以用树状数组维护b数组，但是对b数组的修改若是不改b数组的话（建议也改了），只能体现在树状数组上，而树状数组只能完成单改，求前缀和的工作，因此你可以通过sum操作完成对a数组的单点查询工作。

---

一般经验：树状数组的题假如有m个和查询的话，时间复杂度一般都是Omlogn

---

树状数组:只能解决区间求和问题，像区间求最值问题解决不了，只有利用两个前缀和的信息就能得到区间的信息的问题才能用树状数组，比如求和是可以的。因此树状数组是一个短小精悍的数据结构，能解决的问题有限，但很精悍。



### 模板：

注意：原数组下标和tr数组下标从1开始



#### 1、单点修改，区间查询（前缀和查询）

[题目链接](https://www.luogu.com.cn/problem/P3374)

```C++
#include<bits/stdc++.h>
using namespace std;
const int N = 500010;
typedef long long LL;
int n, m;
LL a[N], tr[N];

int lowbit(int x){
    return x & -x;
}
void add(int x, int c){//从下修改到上
    for(int i = x; i <= n; i += lowbit(i)) 
    	tr[i] += c;
}
LL sum(int x){
    LL res= 0;
    for(int i = x; i; i -= lowbit(i))
        res += tr[i];
    return res;
}

int main(){
    scanf("%d%d",&n,&m);
    for(int i = 1; i <= n; i++){
        scanf("%lld",&a[i]);
        add(i,a[i]);
    }
    while(m--){
        int k,x,y;
        scanf("%d%d%d",&k,&x,&y);
        if(k == 1) add(x,y);
        else printf("%lld\n",sum(y) - sum(x - 1));
    }

} 
```





#### 2、区间修改、单点查询

[题目链接](https://www.luogu.com.cn/problem/P3368)

```C++
//对原数组a区间修改，单点查询
//等价于对a的差分数组b进行单点修改（两个端点），区间查询(前缀和查询)
//因此用树状数组tr维护b数组 ，对b进行单点修改，前缀和查询
#include<bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N = 500010;

int n, m, a[N], b[N];
LL tr[N];
//对原数组[l,r]区间内进行加c操作
//等价于对差分数组进行两个点的操作
// void insert(int l,int r,int c) {
// 		b[l]+=c;
// 		b[r+1]-=c;
// }

int lowbit(int x){
    return x & -x;
}
void add(int x, int c){
    b[x] += c;
    for(int i = x; i <= n; i += lowbit(i)){
        tr[i] += c;
    }
}
LL sum(int x){
    LL res = 0;
    for(int i = x; i; i -= lowbit(i)){
        res += tr[i];
    }
    return res;
}

int main(){
    scanf("%d%d",&n,&m);
    //构造原数组的差分数组b，构造b数组的树状数组tr
    for(int i = 1; i <= n; i++){
        scanf("%d",&a[i]);
        add(i,a[i]);//构造b数组的树状数组  ,也构造了b数组
        add(i+1,-a[i]);
    }
    while (m--)
    {
        int k,x,y,c;
        scanf("%d",&k);
        if(k == 1){//对a进行区间修改，对b进行单点修改（两次）
            scanf("%d%d%d",&x,&y,&c);
            add(x, c);
            add(y + 1, -c);
        }else{//对a单点查询,对b前缀和查询
            scanf("%d",&x);
            printf("%lld\n",sum(x));
        }
    }
    return 0;
}
```





#### 3、区间修改、区间查询

~~思考：俩操作都是logn级别，结合前两个可得，用tr1维护原数组，用来完成区间查，用tr2维护差分数组，用来完成区间修改。~~

①、区间修改：先得到原数组的差分数组b，然后可完成区间修改的操作

②、区间查询(前缀和查询)：也即$a_1+a_2+\dots+a_x$ ,它等于 $\sum^x_{i=1}ai = \sum^x_{i=1}\sum_{j=1}^ibi$ ,根据下图，该式子又可化成

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210513201329380.png" alt="image-20210513201329380" style="zoom:33%;" />

$presum\_a[x] = (b_1+b_2+\dots+b_x)×(x+1)-(b_1+2*b_2+\dots+i*b_i+\dots+x*b_x) $



[Acwing题目链接](https://www.acwing.com/problem/content/244/)

```C++
//思路：由分析得到公式后
//两个树状数组数组分别维护b 和 b[i]*i
//利用公式结合树状数组操作可以完成区查区改的操作，注意初始化、区查区改都涉及两个数组
#include<bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N = 100010;
int n, m;
int a[N],b[N];//a原数组 b差分数组
LL tr1[N],tr2[N];//tr1维护b[i]的前缀 和 tr2维护b[i] * i的前缀和

int lowbit(int x){
    return x & -x;
}
void add(LL tr[], int x, LL c){
    for(int i = x; i <= n; i += lowbit(i)){
        tr[i] += c;
    }
}
LL sum(LL tr[], int x){
    LL res = 0;
    for(int i = x; i; i -= lowbit(i)){
        res += tr[i];
    }
    return res;
}
LL prefix_sum(int x){
    return sum(tr1, x) * (x + 1) - sum(tr2, x);
}
int main(){
    scanf("%d%d",&n, &m);
    for(int i = 1; i <= n; i++){
        scanf("%d",&a[i]);
    }
    for(int i = 1; i <= n; i++){
        int bi = a[i] - a[i - 1];
        add(tr1, i, bi);
        add(tr2, i, (LL)bi * i);
    }
    while(m--){
        char op[2];
        int l, r, d;
        scanf("%s%d%d", op, &l, &r);
        if(op[0]== 'Q'){
            printf("%lld\n",prefix_sum(r) - prefix_sum(l - 1));
        }else{
            scanf("%d", &d);
            //b[l] += d  tr1 和 tr2都要变
            add(tr1, l, d),add(tr2, l, l * d);
            //b[r + 1] -= d  tr1 和 tr2都要变
            add(tr1, r + 1, -d), add(tr2, r + 1, (r + 1) * -d);
        }
    }


    return 0;
}
```







### 原理

**参考自己的那几张演草纸笔记**

引入树状数组tr，tr【i】代表以i结尾长度为lowbit (i)的区间和，也即 sum【i-lowbit i +1，i】
那么：单点修改的工作就变成了对tr数组的修改：方法：逐级修改父节点的tr值
前缀和查询sum（x） 也即sum【1，x】，方式是对x分解成一系列tr

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210604165630914.png" alt="image-20210604165630914" style="zoom: 50%;" />

---

对a数组 区间修改单点查询，对应于 对b数组 单点修改，区间查询（也即前缀和查询），因此可以用树状数组维护b数组，但是对b数组的修改若是不改b数组的话（建议也改了），只能体现在树状数组上，而树状数组只能完成单改，求前缀和的工作，因此你可以通过ask操作求b数组的每一个值。



### 建立树状数组(初始化)

给一个现有原数组，怎么建立初始化它的树状数组呢？

方法1：我们把原数组看成一个全零的数组，然后执行n次单点修改。时间复杂度$O(nlog_2n)$. 百分之90的方式都可以这样建立，因为不影响整个题的复杂度

```C++
for(int i = 1; i <= n; i++) add(i , a[i]);
```





方法2： 由定义出发tr[x] = sum of a[x - lowbit(x) + 1 , x] ，那么我们维护a[]的前缀和数组然后直接求就行了，时间复杂度是$O(n)$ （堆也有一个$O(n)$的建造方式）

```C++
for(int i = 1; i <= n; i++){
    scanf("%d",a + i);
    presum[i] = presum[i - 1] + a[i];
}
for(int i = 1; i <= n; i++){
    tr[i] = presum[x] - presum[x - lowbit(x)];
}
```



### 例题



#### 一、[楼兰图腾](https://www.acwing.com/problem/content/description/243/)

> 题意：依次给定n个点(x,y)   xy都是从1到n ，问有多少个V 和A 形的数组对？
>
> 思路：从集合的角度看，答案集合一定由 n - 2 个集合组成，第k个集合是以第k为最低点的集合，这样划分集合不重不漏，那么问题就转化为依次求每个点作为最低点时的VA个数：
>
> 以求大V为例，方法是：求得左边比a[i]大的数的个数，再求得右边比a[i]大的数的个数，然后相乘就得到了以a[i]为最低点的V的个数。用一个数组GL[i]]存放 在1~i-1中比a[i]大的数，用一个数组GR存放在i+1 ~ n比a[i]大的数，然后for循环相乘求和，而求GL GR的时间复杂度是O（n^2）的，很慢的。因此我们的思路是：
>
> 1.从左向右依次遍历每个数a[i]，使用树状数组统计在i位置之前所有比a[i]大的数的个数、以及比a[i]小的数的个数。**（区间查询）**
> 统计完成后，将a[i]加入到树状数组。**（单点修改）**
>
> 2.从右向左依次遍历每个数a[i]，使用树状数组统计在i位置之后所有比a[i]大的数的个数、以及比a[i]小的数的个数。
> 统计完成后，将a[i]加入到树状数组。
>
> 树状数组维护的原数组是 b[]，b[i] = 1 代表 i值出现了一次



```C++
#include<bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N = 200010;
int n;
int a[N],tr[N];//树状数组tr维护一个  原数组：个数数组(记录每一个值当前状态下出现的次数)
LL resA = 0, resV = 0;
int GreatL[N],GreatR[N];
int LowL[N],LowR[N];

int lowbit(int x){
    return x & -x;
}

void add(int x,int c){
    for(int i = x; i <= n;i += lowbit(i)){
        tr[i] += c;
    }
}
int sum(int x){
    int res = 0;
    for(int i = x; i; i -= lowbit(i)){
        res += tr[i];
    } 
    return res;
}

int main(){
    scanf("%d", &n);
    for(int i = 1; i <= n; i++){
        scanf("%d",&a[i]);
    }

    for(int i = 1; i <= n; i++){
        int val = a[i];
        GreatL[i] = sum(n) - sum(val); //求[val+1,n]值的个数
        LowL[i] = sum(val - 1);//求[1,val-1]值的个数
        add(val,1);
    }
    memset(tr,0,sizeof tr);
    for(int i = n; i >= 1; i--){
        int val = a[i];
        GreatR[i] = sum(n) - sum(val);//求[val+1,n]值的个数
        LowR[i] = sum(val - 1);//求[1,val-1]值的个数
        add(val,1);
    };
    for(int i = 1; i <= n; i++){
        resV += (LL)GreatL[i] * GreatR[i];
        resA += (LL)LowL[i] * LowR[i];
    }
    printf("%lld %lld",resV,resA);

    return 0;
}
```



#### 二、[谜一样的奶牛](https://www.acwing.com/problem/content/245/)

> **题意：**有n头奶牛，每个奶牛都有一个身高，牛的身高各不相同且从1到n排列 
>
> 输入奶牛个数，和每头奶牛前面别它矮的牛的个数，问每头奶牛的身高是多少？

**分析：**第一头牛a[1]一定是0，因为前面没有比它矮的奶牛了。我们不妨从后往前看，对第n头奶牛来说，a[n] = x;那么它前面有x头牛比它矮，因此它是序列中 第 x+1小的数字，那么我们可以得到它的身高了，同理对第n-1头奶牛来说，a[n-1] = y,我们找剩余的序列中 第 y + 1小的数

因此：我们有两个操作：
①、查找当前（剩余）序列中第k小的数。
②、删除序列中的某个数。

1≤n≤10^5,我们如果用朴素的办法,vector erase应该是On，所以可能会超时

```C++
#include<bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N = 100010;
int n;
int a[N];
int res[N];
vector<int> ve;
int main(){
    scanf("%d", &n);
    a[1] = 0;
    ve.push_back(1);
    for(int i = 2; i <= n; i++){
        scanf("%d",&a[i]);
        ve.push_back(i);
    }
    for(int i = n; i >= 1; i--){
        int y = a[i];//找到剩余序列中第y+1小的数
        res[i] = ve[y];
        ve.erase(ve.begin() + y);
    }
    for(int i = 1; i <= n; i++){
        printf("%d\n",res[i]);
    }
    return 0;
}
```

2、升级版：使用java里的priority_queue

```java
```

3、使用树状数组

```C++
//对于完成两个操作：查询剩余第k小的数, 删除某个数这两个操作
//我们可以建立一个   个数数组cnt[]
//用树状数组，维护个数数组的前缀和，可以用二分完成寻找第k小的数(O log^2 n)
//（二分说明：定义性质：check(x):x满足sum(x)>=k,利用二分可以求的这个性质的边界）

#include<bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N = 100010;

int n;
int h[N];
int ans[N];
int tr[N];//维护一个个数数组cnt[N]  cnt[i] = 1/0; 1代表i还存在 0已经使用了 
int lowbit(int x){
    return x & -x;
}
void add(int x, int c){
    for(int i = x; i <= n; i+= lowbit(i)){
        tr[i] += c;
    }
}
int sum(int x){
    int res = 0;
    for(int i = x; i; i -= lowbit(i)){
        res += tr[i];
    }
    return res;
}

int main(){
    scanf("%d",&n);
    h[1] = 0;
    for(int i = 2; i <= n; i++){
        scanf("%d", &h[i]);
    }
    for(int i = 1; i <= n; i++){
        tr[i] = lowbit(i);
    }
    for(int i = n; i; i--){
        int y = h[i];//找序列中第 y + 1小的数
        //找一个数k,满足sum(k) = y + 1
        int l = 1, r = n;
        while(l < r){
            int mid = (l + r)>>1;
            if(sum(mid) >= y + 1) r = mid;
            else l = mid + 1;
        }
        ans[i] = l;
        add(l, -1);
    }
    for(int i = 1; i <= n; i++){
        printf("%d\n",ans[i]);
    }

    return 0;
}
```







## 二、线段树



两个基本操作：**pushup** 由子节点信息算父节点信息sum = lsum + rsum	、   **pushdown** 把父节点的修改信息下传到子节点（递归）（又称为懒标记、延迟标记）

**一个线段树的基本操作：**

①、pushup(u)  由子节点算父节点信息     **由两个子节点的信息算父节点的信息**

②、build()   将一段空间初始化成线段树

③、modify()   1单点修改（简单）  2区间修改（比较难、要使用pushdown操作）

④、query  查询某一段的信息

⑤、pushdown



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210516154619054.png" alt="image-20210516154619054" style="zoom: 33%;" />

**原理：饱满二叉树(每个节点的度都是0/2)**，   一维结点数组

节点序号从1开始
$$
编号是x \begin{cases}
父节点 \lfloor x/2 \rfloor &x>>1 \\
左儿子 2x  & x << 1  \\
右儿子 2x + 1 & x << 1\ |\  1
\end{cases}
$$


线段树一般 开 **4n**空间

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210516180226580.png" alt="image-20210516180226580" style="zoom:50%;" />





**基本操作：**

1、build

需要完成：左右区间的确定，属性的确定。从上到下完成区间的确定，从下到上，完成属性的确定

```C++
build(int u, int L, int R){
	tr[u].l = L; tr[i].r = R;
    if(L == R) return;
    int mid = L + R >> 1;
    build(u << 1, L, mid); build(u << 1 | 1, mid + 1, R);
    pushup(u);
}
```



2、查询query

线段树时间复杂度一般是4logn，比树状数组慢



3、modify

①、单点修改

不涉及懒标记，比较简单，直接从上到下递归，从根递归到叶子结点，然后向上pushup。只需要修改一个点，不需要懒标记



②、区间修改

要加上懒标记，否则时间复杂度会退化

---

当遇到区间修改时，心里就咯噔一下，因为可能要用pushdown懒标记了，但是只涉及整体加减时，可以用差分，但是当设计整体加 整体修改时，就只能用懒标记了。



---

### 模板题

#### 一、[最大和](https://www.acwing.com/problem/content/1277/)

线段树记录哪些值？   线段树的每一个结点都是一个结构体，我们需要存区间左端点和区间右端点 和**一个其他值**：最大值 ，注意左右儿子的节点号可以直接算出来，不用存

怎么判断结点里存哪些信息呢？ 原则：问的是什么？ 问的是某区间内的某种属性，比如问的是区间的和，区间的最大值，最大公约数

，除此之外还要有辅助信息，为什么存储辅助信息？ 当前区间的属性，它能不能由两个子区间算出来，如果能就万事大吉，如果不能就想一想需不需要存一些其他的属性。

线段树难在更新信息。

当我们需要求一个区间最大值时，我们只需要把两个子区间最大值取一个max就行了



> 题意： 区间查询最大值，单点修改

```C++
//原理理解时：应该结合节点数组，和节点数组所代表的树来理解

//线段树 节点数组维护原数组 借助这个数据结构可以快速的完成区间查询(和，最大值等等等)，单点修改的操作
//原理： 节点数组实际是一个完全二叉树，每个节点维护一个区间的属性，父节点维护的区间时两个子节点的区间合并
//节点的编号，只是编号，与原数组没啥关系。节点的区间指的才是原数组的下标
//函数参数里的 u 指的均是 节点的编号,一般调用时 都是从1进入
#include<bits/stdc++.h>
using namespace std;
const int N = 200010;
int m, p;
int last, len = 0;
struct Node{
    int l, r;
    int v;
}tr[4 * N];//树状数组维护一个原数组(初始长度为0，
//可以认为长度为N，数值全为0)的最大值，可以动态地对原数组进行区间最大值查询、单点修改
//树状数组中结点存的是区间最大值

//用子节点的值，更新u节点
void pushup(int u){
    tr[u].v = max(tr[u << 1].v, tr[u << 1 | 1].v);
}
//建立线段树 从u节点  [l,r]开始
//对u节点 确定范围为 [l,r]
void build(int u, int l, int r){
    tr[u] = {l, r};
    if(l == r) return;
    int mid = l + r >> 1;
    build(u << 1, l, mid);
    build(u << 1 | 1, mid + 1, r);
    pushup(u);
}

//对节点u  查询[l,r]的最大值
//结合图形来分析
//在u节点上 查找[l, r]的属性值
int query(int u, int l, int r){
    if(l <= tr[u].l && r >= tr[u].r) return tr[u].v;
    int mid = tr[u].l + tr[u].r >> 1;
    int v = 0;
    if(l <= mid) v = query(u << 1, l , r);
    if(r > mid) v = max(v, query(u << 1 | 1, l, r) ); 
    return v;
}

//对节点u 修改原数组 a[x]的值为 v
//对于u节点，修改原数组x的值为v
void modify(int u, int x, int v){
    if(tr[u].l == x && tr[u].r == x) tr[u].v = v;
    else{
        int mid = tr[u].l + tr[u].r >> 1;
        if(x <= mid) modify(u << 1, x, v);
        else modify(u << 1 | 1, x, v);
        pushup(u);
    }  
}

int main(){
    scanf("%d%d",&m, &p);
    build(1, 1, m);
    char op[2];
    int x;
    while(m--){
        scanf("%s%d", op, &x);
        if(*op == 'Q'){
            last = query(1, len - x + 1, len);
            printf("%d\n",last);
        }else{
            modify(1, len + 1, (x + last) % p);
            len++;
        }
    }

    return 0;
}
```

query 推荐写法

```c++
#include<bits/stdc++.h>
using namespace std;
const int N = 200010;
int m, p;
int last, len = 0;
struct Node{
    int l, r;
    int v;
}tr[4 * N];//树状数组维护一个原数组(初始长度为0，
//可以认为长度为N，数值全为0)的最大值，可以动态地对原数组进行区间最大值查询、单点修改
//树状数组中结点存的是区间最大值

//用子节点的值，更新u节点
void pushup(int u){
    tr[u].v = max(tr[u << 1].v, tr[u << 1 | 1].v);
}
//建立线段树 从u节点  [l,r]开始
void build(int u, int l, int r){
    tr[u] = {l, r};
    if(l == r) return;
    int mid = l + r >> 1;
    build(u << 1, l, mid);
    build(u << 1 | 1, mid + 1, r);
    pushup(u);
}

//对节点u  查询[l,r]的最大值
//结合图形来分析
int query(int u, int l, int r){
    if(l <= tr[u].l && r >= tr[u].r) return tr[u].v;
    int mid = tr[u].l + tr[u].r >> 1;
    // int v = 0;
    if(r <= mid) return query(u << 1, l, r);
    if(l > mid) return query(u << 1 | 1, l , r);
    return max( query(u << 1, l, r), query(u << 1 | 1, l , r) );
    // if(l <= mid) v = query(u << 1, l , r);
    // if(r > mid) v = max(v, query(u << 1 | 1, l, r) ); 
    // return v;
}

//对节点u 修改原数组 a[x]的值为 v
void modify(int u, int x, int v){
    if(tr[u].l == x && tr[u].r == x) tr[u].v = v;
    else{
        int mid = tr[u].l + tr[u].r >> 1;
        if(x <= mid) modify(u << 1, x, v);
        else modify(u << 1 | 1, x, v);
        pushup(u);
    }  
}

int main(){
    scanf("%d%d",&m, &p);
    build(1, 1, m);
    char op[2];
    int x;
    while(m--){
        scanf("%s%d", op, &x);
        if(*op == 'Q'){
            last = query(1, len - x + 1, len);
            printf("%d\n",last);
        }else{
            modify(1, len + 1, (x + last) % p);
            len++;
        }
    }




    return 0;
}
```





#### 二、[你能回答这些问题吗](https://www.acwing.com/problem/content/246/)

> 题意：动态单点修改（不需要懒标记 只需要pushup不需要pushdown），区间查询最大连续子段和

想一下节点里存什么信息？首先 int l,r 必须有，它们存区间左右端点  、tmax最大连续子段和、 这些就够了吗？还需要其他信息吗？ 怎么想呢？ ：当前区间（父节点）能不能用子区间（子节点） 得到呢？ 

针对于这道题我们发现，父节点区间最大连续子段和 不能直接通过两个子节点来确定，因为它可能跨越两个子节点区间，因此我们需要存储**额外的信息**：lmax 最大前缀和  rmax最大后缀和  而算前缀和还需要 区间和sum。也即结点内的所有信息都是从子节点中得到的。也即节点内加一个信息，我们就需要考虑这个信息能否通过子节点算出来（新加的信息怎么得到），也即这是个链型的关系 一环依赖一环。（套路：先维护答案，然后当前信息能否算出答案，不能的话要加一些额外的信息，加完之后，额外的信息能否被算出来，不够的话 要再加，。。。。直到所有的信息具有完备性为止）

```C++
/*
题意：给定一个长度为n的数组(N = 5e5)， m个操作(M = 1e5):区间查询最大连续子段和，单点修改
分析：mlogn级别不会超时，因此线段树可行
代码：
*/

#include<bits/stdc++.h>
using namespace std;
const int N = 5e5 + 10 ;
int n, m;
int w[N];
struct Node{
    int l, r;
    int tmax, lmax, rmax, sum;
}tr[N * 4];
void pushup(Node &u,Node &l, Node & r){
    u.sum = l.sum + r.sum;
    u.lmax = max(l.lmax, l.sum + r.lmax);
    u.rmax = max(r.rmax, r.sum + l.rmax);
    u.tmax = max( max(l.tmax, r.tmax), l.rmax + r.lmax );
}

void pushup(int u){
    pushup(tr[u], tr[u << 1], tr[u << 1 | 1]);
}
void build(int u, int l, int r){
    if(l == r) tr[u] = {l, l, w[l], w[l], w[l], w[l]};//当区间长度为1时 前缀后缀区间最大连续都是原数
    else{
        tr[u] = {l, r};
        int mid = l + r >> 1;
        build(u << 1, l, mid);build(u << 1 | 1, mid + 1, r);
        pushup(u);
    }
}
void modify(int u, int x, int v){
    if(tr[u].l == x && tr[u].r == x){
        tr[u] = {x, x, v, v, v, v};
    }else{
        int mid = tr[u].l + tr[u].r >> 1;
        if(x <= mid) modify(u << 1, x, v);
        else modify(u << 1 | 1, x, v);
        pushup(u);
    }
}
Node query(int u, int l ,int r){
    if(l <= tr[u].l && r >= tr[u].r) return tr[u];
    int mid = tr[u].r + tr[u].l >> 1;
    if(r <= mid) return query(u << 1, l, r);
    if(l >= mid + 1) return query(u << 1 | 1, l, r);
    
    auto left = query(u << 1, l, r);//不理解这里
    auto right = query(u << 1 | 1, l, r);
    Node res;
    pushup(res, left, right);
    return res;
} 
int main(){
    scanf("%d%d",&n, &m);
    for(int i = 1; i <= n; i ++){
        scanf("%d",&w[i]);
    }
    build(1, 1, N);
    int k, x, y;
    while(m--){
        scanf("%d%d%d", &k, &x, &y);
        if(k == 1){//query
            if(x > y) swap(x, y);
            printf("%d\n",query(1, x, y).tmax);
        }else{//modify
            modify(1, x, y);
        }
    }

    return 0;
}
```







### 其他题

省赛选拔重做

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210518204316433.png" alt="image-20210518204316433" style="zoom:50%;" />

```C++
/*
朴素的做法是dp，然后每次都查询 前面满足条件(abs{a[i] - a[t]}<k)的最大的dp[t]
这样做的复杂度是O n^2的 会超时

线段树做法：
我们发现朴素做法每次外层循环是增加了一项 (这个数组是以a[i]为下标，子序列长度为值)，然后区间查询最大值
这是个单点修改，区间查询的过程！！  (树状数组是维护前缀和 区间和)，而线段树可以做到维护最大值
*/
#include<bits/stdc++.h>
using namespace std;
const int N = 300010;
int a[N], dp[N];//dp[i]:  以i结尾的子序列最大长度
int n, k;
int b[N];
struct Node{
    int l, r;
    int v;
}tr[N * 4];

void pushup(int u){
    tr[u].v = max( tr[u << 1].v, tr[u << 1 | 1].v);
}
void build(int u, int l, int r){
    tr[u] = {l, r};
    if(l == r) return;
    int mid = l + r >> 1;
    build(u << 1, l ,mid);
    build(u << 1 | 1, mid + 1, r);
}
void modify(int u, int x, int v){
    if(tr[u].l == x && tr[u].r == x) tr[u].v = v;
    else{
        int mid = tr[u].l + tr[u].r >> 1;
        if(x <= mid) modify(u << 1, x, v);
        else modify(u << 1 | 1, x, v);
        pushup(u);
    }
}
int query(int u, int l, int r){
    if(l <= tr[u].l && r >= tr[u].r) return tr[u].v;
    int mid = tr[u].l + tr[u].r >> 1;
    if(r <= mid) return query(u << 1, l, r);
    if(l > mid) return query(u << 1 | 1, l, r);
    return max(query(u << 1, l, r), query(u << 1 | 1, l, r));
}
int main(){
    scanf("%d%d", &n, &k);
    for(int i = 1; i <= n; i++){
        scanf("%d", &a[i]);
    }
    for(int i = 1; i <= n; i++){
        dp[i] = 1;
    }
    build(1, 1, N);
    modify(1, a[1], dp[1]);
    for(int i = 2; i <= n; i++){
        int max = query(1, a[i] - k, a[i] + k);
        dp[i] = max + 1;
        modify(1, a[i], dp[i]);
    }

    // for(int i = 2; i <= n; i++){
    //     int max = -1;
    //     for(int j = 1; j < i; j++){
    //         if(dp[j] > max && abs(a[j] - a[i]) <= k) max = dp[j];
    //     }
    //     dp[i] = max + 1;
    // }

    printf("%d",*max_element(dp + 1, dp + 1 + n));

    return 0;
}
```





## 三、树

### 1、二叉排序树

二叉排序树BST、二叉搜索树 二叉查找树BST

**定义一**

一棵空树，或者是具有下列性质的二叉树：

（1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值；

（2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值；

（3）左、右子树也分别为二叉排序树；

（4）没有键值相等的结点。

**查找**

步骤：若根结点的关键字值等于查找的关键字，成功。

否则，若小于根结点的关键字值，递归查左子树。

若大于根结点的关键字值，递归查右子树。

若子树为空，查找不成功。

**插入删除**

与次优二叉树相对，二叉排序树是一种动态树表。其特点是：树的结构通常不是一次生成的，而是在查找过程中，当树中不存在关键字等于给定值的结点时再进行插入。新插入的结点一定是一个新添加的叶子结点，并且是查找不成功时查找路径上访问的最后一个结点的左孩子或右孩子结点。





### 2、AVL树

![image-20210920201257070](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210920201257070.png)

AVL树是最先发明的**自平衡二叉查找树**。在AVL树中任何节点的两个子树的高度最大差别为1，所以它也被称为高度平衡树。增加和删除可能需要通过一次或多次树旋转来重新平衡这个树。是上面二叉树的优化版。

**特点**

AVL树本质上还是一棵二叉搜索树，它的特点是：

1.本身首先是一棵二叉搜索树。

2.带有平衡条件：每个结点的左右子树的高度之差的绝对值（平衡因子）最多为1。

也就是说，AVL树，本质上是带了平衡功能的二叉查找树（二叉排序树，二叉搜索树）。



### 3、Treap


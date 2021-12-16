## 一句话的知识

- C++中 全局整形数组初始值是0， char数组是'\0'也即ASCII码为0; 因此全局数组的初始**值**都是 **0** ，只不过int和char 对0的处理分别是 0 和'\0' ；  另外可知bool数组 初始值都是0也即false

- 判断一个a浮点数(double)是否等于一个b整数(int)时，要这样，fabs（a-b）<=1e-6



- typedef用法：  如 int a[100]; 把 a换成想要的类型名，再在最前面加上typedef即可

- 当递推时，且项数很大时！ 用矩阵快速幂



- **偶数位数回文数**（除11）必定不是质数。



- 三个逗号：
  1,000,000,000
  十亿  百万 千



- **中位数**有这样的性质 ：所有数与中位数的绝对差之和最小。（在数学中，若是偶数，应该求中间两偶数平均值）



- 迭代器写法：

  string::iterator
  vector<S>::iterator

  

- 那道题的题目叫 Radar Installation ，细心的朋友可能发现了， Installation 通常是安装向导程序的文件名（大部分是 install.exe ，但是也有 installation.exe 、 setup.exe 等等），所以个人推测是因为文件名的原因，生成的 .exe 程序被系统认为是安装向导程序，所以出现了小盾牌的标志,但是毕竟它不是，可能找不到某些前导程序或者其它的资源，导致的程序出错。但是 0x40F930 到底代表这什么错误，目前还没有查出来，而且不同的错误可能会导致相同的异常，所以，如果你的程序也出现了这样的异常，建议先检查一下文件名是不是存在“setup”、“install”、“installer”、“installation”等字样。



- 当bfs有涉及到对des.step值改变的操作时，注意上面那个的值不会改变，下面的那个才是对的！！注意！！

  ```c++
  cout<<bfs()<<"Step:"<<(des.step-1);
  cout<<endl<<(des.step-1);
  ```



- ans=(a+b)/2;

  a、b双偶或双奇 则 ans为整数，且到a、b距离相等

  a、b一偶一奇 则 ans为ab中间那个小数的左边那个整数





---

## 类型数据范围

- 整型

| 类型               | 字节、B、byte | max值                                                     | 输出 |
| ------------------ | ------------- | --------------------------------------------------------- | ---- |
| short              | 2             | 32767                                                     |      |
| int                | 4             | 2,147,483,648                   21亿（10位数  ≈2*10^9  ） | d    |
| long               | 4             | 2,147,483,648                   21亿（10位数  ≈2*10^9  ） |      |
| long long          | 8             | 9223372036854775807	  （19位数  ≈9*10^18）             | lld  |
| unsigned long long | 8             | 1.8* 10^19                                                |      |

​     **（n位二进制满值为2^n-1）**                                  				
​                                         				

-  浮点型

| 类型        | 字节 | 输入 | 输出   |
| ----------- | ---- | ---- | ------ |
| float       | 4    | %f   | **%f** |
| double      | 8    | %lf  | **%f** |
| long double | 16   |      |        |

​			float有效数字位为6 – 7位 double有效数字位为15 – 16位



## 几个数据类型

[主要参考](http://blog.sina.com.cn/s/blog_9dcc0fb90101gdvo.html)

[参考](http://www.360doc.com/content/18/1208/12/32862269_800182367.shtml)

```C
  
#ifndef __int8_t_defined  
# define __int8_t_defined  
typedef signed char             int8_t;   
typedef short int               int16_t;  
typedef int                     int32_t;  
# if __WORDSIZE == 64  
typedef long int                int64_t;  
# else  
__extension__  
typedef long long int           int64_t;  
# endif  
#endif  
  
  
typedef unsigned char           uint8_t;  
typedef unsigned short int      uint16_t;  
#ifndef __uint32_t_defined  
typedef unsigned int            uint32_t;  
# define __uint32_t_defined  
#endif  
#if __WORDSIZE == 64  
typedef unsigned long int       uint64_t;  
#else  
__extension__  
typedef unsigned long long int  uint64_t;  
#endif  
```







## 自动类型转换（小心溢出）

**int  21亿 ≈2*10^9  ）**

**long long 9*10^18**

自动类型转换的规则，

1、对于**赋值运算**来说，左大，那么把右变大。左小，那么把右边截取再赋值给左边。

2、对于**加减乘除运算**来说，运算符的两个操作数假如类型不一样的话，会先转成大的那一个再运算

```C++
int main(){
    int a = 0x7ffffff0;
    long long b = 16;
    long long c = a + b; 
    printf("%lld",c);
    return 0;
}
//2147483647
//分析：
//因为a:int   b:longlong  相加前 a会先转为longlong再与b相加，因此最后c顺利接受结果
//但是如果把b改成int   那么a+b就是简单的int相加，结果会爆int 这样c接收到的就是一个错的负值 ，特别注意！
```







## 运算符优先级

最前面是一些特殊的，先自增自减，  然后是**加减乘除算术运算符**、然后是**移位运算符**、然后是**关系运算符**、然后是**位运算**、然后是**逻辑运算**、然后是**赋值运算**

---

## 斐波那契数列公式

![image-20200323101311915](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200323101311915.png)

int ferbo(int n){

​    return (sqrt(5)/5)*(pow((1+sqrt(5))/2,n)-pow((1-sqrt(5))/2,n));

}





---

## 进制

| 进制     | 英文    | 前缀 | 后缀 | 输入输入格式 |
| -------- | ------- | ---- | ---- | ------------ |
| 二进制   | Binary  | 0b   | B    | 无           |
| 八进制   | Octal   | 0    | O    | %o           |
| 十进制   | Decimal | 默认 | D    | %d           |
| 十六进制 | Hex     | 0x   | H    | %x           |











---

## 位运算

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200323101906253.png" alt="image-20200323101906253" style="zoom: 200%;" />

- **与运算**（全1才1）

①、 清零                 			（让选择数所有位都是0）

②、 截取某些指定位数      （让选择数的特定位为1）

- **或运算**（1个1就1）

 

- **异或**（模2加法）

①、 使特定位翻转          （让选择数的特定位为1， 也即0原值1翻转）

②、交换两个值

a=a^b;

b=a^b;

a=a^b;

 

- **求反**

 

- **左移<<**

低位补0.高位丢弃       如 17<<2;

①、    Num<<2    等价于   Num*($2^n$);

 

- **右移>>**

低位丢弃，高位补零

①、    Num>>n    等价于  Num/($2^n$)

 









<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200323102035277.png" alt="image-20200323102035277" style="zoom:200%;" />





- **一个例子**



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200323102041714.png" alt="image-20200323102041714" style="zoom:200%;" />







---

## 模运算与其他运算符结合

- **( a + b ) % c = ( ( a % c ) + ( b % c ) ) % c**



- **( a * b ) % c = ( ( a % c ) * ( b % c ) ) % c**



- **( a – b ) % c = ( ( a % c ) – ( b % c ) ) % c**



（3 * n）% (3 * k)=3 *（n % k）

---

## 子串和子序列



> 一个字符串 ss 被称作另一个字符串 SS 的子串，表示 ss 在 SS 中出现了。

> 一个字符串 ss 被称作另一个字符串 SS 的子序列，说明从序列 SS 通过去除某些元素但不破坏余下元素的相对位置（在前或在后）可得到序列 ss 。

**比如，“中出”是“我们中出了一个叛徒”的子串也叫子段（同时也是子序列）。而“XQ”是“LXTQL”的子序列，而不是子串。**



## 迭代与递归

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200508211205741.png" alt="image-20200508211205741" style="zoom: 50%;" />

迭代：从已知推未知 
递归：从未知回溯到已知，再推未知

[CSDN](https://blog.csdn.net/swliao/article/details/5337896?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4)

[CSDN](https://blog.csdn.net/gaoyu1253401563/article/details/82384958)



## C/C++版本更迭历程

有关GCC、gcc、g++详细请点击[文章链接](https://blog.csdn.net/albertsh/article/details/89192242?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task)





## memset/fill/memcpy



1. memset头文件是 string.h 

   **memset（数组开始初始化的地址，ASCII码值，大小）**

   主要用于对字符数组初始化，因此 第二个参数 一般是 个字符

   因此它的原理是**对数组每一字节赋予 ASCII码值。**

    所以当想对整形数组初始化时，比如1， 那么整形数组中的每个元素（四个字节）都将会01010101H所以失败了，因此用memest只能把整形数组设置成全0或全-1



2. fill头文件是 algorithm

   **fill(vec.begin(), vec.end(), val);**

二者的主要区别是 前者对字节依次赋值，而后者是对单元



3. memcpy

int len = 5;

float a[len] = {1.0 ,1.1, 1.2, 1.3, 1.4};

float b[len];

memset(b, 0, len*sizeof(float));

memcpy(b, a, len * sizeof(float));



4. ​	char a[]="ABCDEFG";
   ​	char b[20];
   ​	char *c=strcpy(b,a);
   ​	std::cout<<c<<"   "<<b;





## C语言获取数组长度

length=sizeof(a)/sizeof(a[0]); //数组占内存总空间，除以单个元素占内存空间大小

但是，通过传递数组名参数到子函数中，以获得数组长度是不可行的。

因此，获得数组长度，只能在数组定义所在的代码区中，采用以上方法，才可以达到效果

## 对拍程序



#### 一、rand 与 srand

两篇写的不错的博客  

[博客1（简短版）](https://blog.csdn.net/u013745804/article/details/82379266)				[博客2(详细版)](https://blog.csdn.net/candyliuxj/article/details/4396666?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-3&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-3)





**总结：**



- 产生随机数的一般f方式：

```C+
srand(time(0));
for(int i = 0; i < 10; i++)
{
    cout << rand() << endl;
}
```

- 产生0~1之间的浮点数`rand_num = rand()/RAND_MAX;`



- 

    函数名:   srand  
    功   能:   初始化随机数发生器  
    用   法:   void srand(unsigned  int  seed); 
    所在头文件： stdlib.h  
    函数说明：
                 srand()用来设置rand()产生随机数时的随机数种子。

                 参数seed必须是个整数，通常可以利用time(0)的返回值或NULL来当做seed。
          
                 如果每次seed都设相同值，rand()所产生的随机数值每次就会一样。




- 用户未设定随机数种子时(也即不调用srand时)，系统默认的随机数种子为1。

   rand()产生的是伪随机数字，每次执行时是相同的;若要不同,用函数srand()初始化它。

- 两次程序执行的时间间隔要大于1s





#### 二、对拍

参考文章	[CSDN博客](https://blog.csdn.net/wlx65003/article/details/51149196)     感谢原作者！！　　



**原理：**

**rand.exe 	→	in.txt	→	my.exe和std.exe	→	比较	→	my.out和std.out**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200411103658004.png" alt="image-20200411103658004" style="zoom: 70%;" />

​						**data.in   my.out	std.out是自动生成的** 			

​					文件夹里只要有 **批文件处理.bat   rand.exe   my.exe   std.exe** 即可，也即这些要**自己准备**





**说明：**以上操作由批处理文件.bat完成	，rand.exe为自己写的随机数输入数据生成器，写法如下所示；my.exe是自己写的有问题的代码生成的exe。 std.exe是从别人那copy过来的AC后的源码生成的exe或者是暴力搜索的exe

<u>最终若比较出不一致，则bat程序框会显示出in和out中出现不一样地方 以及其上下文 ，in.txt 内容是使my.exe/std.exe 出现不一致输出的输入数据，而my.out和std.out是该输入数据对应的输出结果。</u>

1. 当程序输入是多组数据时，这时比对的结果只能告诉你该n组有错误，而不知道是组中什么位置，这时在程序框中找到出现不一样输出的内容，需要用notepad++打开 in out文件，然后Ctrl f 对比寻找

2. 当程序输入是一组数据时，就方便了。



**批文件处理.bat**			

```c++
@echo off  
:loop  
    rand.exe %random% > data.in
    std.exe < data.in > std.out
    my.exe < data.in > my.out
    fc my.out std.out 
if not errorlevel 1 goto loop  
pause
goto loop
```

- 首先@echo off 是关掉输入显示，不然你的所有命令都会显示出来的，防止刷屏。
- ：loop是定位标记点，和c语言里的goto很像。
- 中间是主体程序。
- if not errorlevel 1 goto loop ，errorlevel 是上一个命令的返回值，fc在文件不同时返回1，相同时返回0，这一行的意思就是，如果fc返回的不是1，就跳到:loop，使劲循环。
- pause，暂停，一旦fc返回1，就会执行到这一行，停住程序，给你时间看数据。
- goto loop，看完数据，按下任意键结束暂停，继续循环。
- time(NULL) 是一秒才更新一次的，也就是说我们的随机数据一秒才换一次，太慢了！
  有没有什么变的更快的随机数种子？有！windows自带了一个随机数发生器：%random%，它的值就是一个随机整数，可以在命令行里调用。
  那接下来就好办了，我们把这个数传给rand.exe用来当随机数种子就行了。
- 小知识：`argc` 是参数个数，`*argv[]` 是参数表，从1开始



**随机数生成程序  rand.cpp**

```C++
#include<bits/stdc++.h>
using namespace std;
#define random(a,b) ((a)+rand()%((b)-(a)+1))//random(a,b)生成[a,b]的随机整数

stringstream ss;

int main( int argc, char *argv[] )
{ 
    int seed=time(NULL);
    if(argc > 1)//如果有参数
    {
        ss.clear();
        ss<<argv[1];
        ss>>seed;//把参数转换成整数赋值给seed
    }
    srand(seed);
    //以上为随机数初始化，请勿修改
    
    
    //以下写你自己的数据生成代码 
	int t=rand()%1000+1;
    printf("%d\n",t); 		
    return 0;
}
```

**注意一下！！**： 把随机数生成程序想象成自己的手动输入，也即 要注意有**'\n'** 否则就乱套了

- time(NULL) 是一秒才更新一次的，也就是说我们的随机数据一秒才换一次，太慢了！ 
  有没有什么变的更快的随机数种子？有！windows自带了一个随机数发生器：%random%，它的值就是一个随机整数，可以在命令行里调用。 
  因此我们把这个数传给rand.exe用来当随机数种子就行了。
  　　　







**总结：**

对拍程序就是把自己ＷＡ的代码与 标程代码（网上copy别人的或者用暴搜写的 绝对绝对正确的程序要不然你还比啥？）　比较的过程。  

步骤：
S1:把自己的代码生成的 exe  改名成 **my.exe**放到专属文件夹里
S2;把标程代码生成的 exe改名成**std.exe**放到专属文件夹里
S3:撰写特定的随机数生成程序（功能是产生输入数据）并把生成的exe程序 改名成**rand.exe**放到专属文件夹里
S4:准备批处理文件(这个一般是固定的，不用单独写)   
S5:准备工作完成！
S6：运行批处理文件、比对

~~:smile: 本蒟蒻目前通过这个方法 完成了 POJ1521哈夫曼编码的错误追踪 嘿嘿~~





## While里输入

#### **一、基本知识：**

​	**scanf("%d%d",&a,&b)**

1. 如果a和b都被成功读入，那么上面表达式的结果为2；

2. 如果a和b只有一个读入，那么上面表达式的结果为1；

3. 如果a和b都没有读入，    那么上面表达式的结果为0；  （比如 Ctrl D  或者）

4. 如果遇到错误或者文件结尾或Crrl+Z，那么上面表达式的结果为EOF，对应的有符号数时-1；



根据以上原则，可知

1. scanf 遇到 Ctrl+D 	、	 scanf  %d 遇到字母   返回 0，
2. Ctrl+Z   《==》   EOF    
   因此 Ctrl+Z+Enter 能结束while(  scanf("%d",&a)！=  EOF )
           Ctrl+D  能结束 while(scanf("%d",&a))
3. **scanf("%d",&n) != EOF   等价于    ~scanf("%d",&n)**
4. 这种写法的漏洞在于：一但输入的值为字母、符号之类的，scanf赋值不成功把读到的内容又返回到stdin的缓冲区（假设这个值为t），其取反得到的值使while又进入到下一次循环，scanf又从stdin缓冲区里读到了原先吐回的t，如此成了死循环……



#### 二、实战操作

- 常见的两种是while(scanf("%d".&n))          while(scanf("%d",&n)!=EOF)

- 输入多组样例，  以-1 -1 代表结束

```C++
while(scanf("%d%d",&r,&n) && (r!=-1||n!=-1))
{       
}    
```

```C++
while(cin>>m>>n&&(m!=-1&&n!=-1))
{    
}   
```



- 输入多个数据，但没有给定有几个数据

```C++
while(scanf("%d",&a[++n])!=EOF);
while(~scanf("%d",&a[++n]));
```





## INF

一般在程序的开头设置一个无穷大的值时会这样： 

```C++
#define INF 0x7fffffff   //恰好是32位int的最大值 2,147,483,647‬
```





但是这样操作有一个缺点：不能满足，无穷大加无穷大依然是无穷大（因为INF+INF会溢出成为负数）
于是我们如下这样定义

```C++
#define INF 0x3f3f3f3f	//值是1,061,109,567		0x3f3f3f3f + 0x3f3f3f3f = 2122219134
```

满足了一些题有可能出现无穷大相加的情形

0x3f3f3f3f还能给我们带来一个意想不到的额外好处：
对于memset函数，一般只有赋值为-1和0的时候才使用它，但是0x3f3f3f3f的每个字节都是0x3f，所以要把一段内存全部置为无穷大，我们只需要memset(a,0x3f,sizeof(a))







## eps

epsilon

[精度问题](https://blog.csdn.net/major_zhang/article/details/65449685)

int sgn(double a)
{return a < -eps ? -1 : a < eps ? 0 : 1;}

























https://blog.csdn.net/lxt_Lucia/article/details/79572829?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param)

## 重定向

参考[CSDN](https://blog.csdn.net/Jacky_chenjp/article/details/70237418?ops_request_misc=&request_id=&biz_id=102&utm_term=freopen&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-70237418)



所谓重定向输出，就是可以把原本只是输出在控制台的字符，输出到你指定的路径文件中。(输入类似，就是从指定的文件中读取，而不是读取在控制台中的输入。)重定向函数可以在任何时候开启、关闭。

```C++
#include <stdio.h>
int main() 
{ 
	int a,b; 
	freopen("D:\\in.txt","r",stdin); //输入重定向，输入数据将从D盘根目录下的in.txt文件中读取 
	freopen("D:\\out.txt","w",stdout); //输出重定向，输出数据将保存在D盘根目录下的out.txt文件中 
	while(scanf("%d %d",&a,&b)!=EOF) 
	printf("%d\n",a+b); 
	fclose(stdin);//关闭重定向输入 
	fclose(stdout);//关闭重定向输出 
	return 0; 
} 
```







因此刷题时，懒得把样例复制粘贴了,就在main函数开头这样

```C++
freopen("C:\Users\95266\Desktop\CodeOutput\\in.txt","r",stdin);
```

结尾这样

```C++
fclose(stdin);//关闭重定向输入 
```







## 内存划分

https://blog.csdn.net/jirryzhang/article/details/79518408?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param





[局部变量作为返回值](https://www.cnblogs.com/xuhj001/p/3436175.html)





## 初始化

注意！！！

对于结构体变量而言，

- 全局变量 ： 	结构体里的数据都有初始值0
- 非全局变量：  结构体里的数据都是任意的，一定要注意初始化！！

## 一个警告

https://blog.csdn.net/ixidof/article/details/7913626
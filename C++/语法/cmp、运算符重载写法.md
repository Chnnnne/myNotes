# 一、sort中cmp的写法





## 1、sort默认由小到大排序

```c++
return a<b;
```

这样理解： a>b则降序 a<b则升序         也就是**<u>a和b是什么关系，排序后的数组中任意两个元素就是什么关系</u>**
 也即a和b怎么排列是true，排序后的数组中任意两个元素就是怎么排列

## 2、sort由大到小排序

``` c++
bool cmp(int a,int b)
{
    return a>b;
}
bool cmp(int a,int b)
{
    if(a<b)
    return true;
}
```

## 3、结构体排序

```c++
bool cmp(Node a,Node b) //l越小顺序越靠前，当l相等，r小的靠前
{
    if(a.l==b.l) return a.r<b.r;
    return a.l<b.l;
}




bool cmp(Stu a,Stu b)
{
	if(a.chi!=b.chi)// 先按语文成绩排再是数学再是英语
	return a.chi>b.chi;
	if(a.math!=b.math)
	return a.math>b.math;
	return a.eng>b.eng;
}
```



## 4、总结

观察cmp函数的样子： bool cmp(node a，node b) 或 bool cmp(int a,int b)
可以这样理解：sort函数既然是一个排序函数（把一个无序的数组排成一个按照指定法则排序的数组），因此必定需要排序的法则cmp，否则不知道怎么排（排序也即比较，比较的含义也即**两个数比较**） ==（任意两个数之间能比较了，那么全部的数就可以比较了，那么数组就可以排序了）==

 bool cmp(node a，node b)   其中a是左边的参数，b是右边的参数， 

==写cmp函数的**核心**：a排在b的前边  怎样是对或是错呢？  这个怎样就是cmp算法的内容==
在函数体中用a、b的属性判断

例子：

1、
<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200509125913159.png" alt="image-20200509125913159" style="zoom: 67%;" />
效果：大的排在前边，也即按照数值大小降序排列
分析：**a在b的前面** 当a大于b时是对的（逻辑表达式的结果是bool值）



2、
<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200509130309798.png" alt="image-20200509130309798" style="zoom:67%;" />
效果：time小的排在前边，若相等，flag域为1的排在前边
分析：**a在b的前边**，当time不相等，a的time小就是对的。若time相等，a.flag=1是对的，否则是错的



**究极总结：
1.涉及简单排序时 ，直接 return a>b 降序  ；return a<b升序**
**2.涉及复杂排序，需要有特定条件时，按我的上述分析方法**

# 二、运算符重载写法



运算符函数重载一般有两种形式：重载为**类的成员函数**和重载为**类的非成员函数**。 非成员函数通常是友元。

点击进入  ：  [ 理论理解](https://blog.csdn.net/zgl_dm/article/details/1767201?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-21&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-21)      写的很棒 认真理解

点击进入  ：  [一些实例](https://www.cnblogs.com/yangguang-it/p/6486660.html)				[一些实例](https://blog.csdn.net/liitdar/article/details/80654324?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2)



某些情况下，当我们编写一个类的时候,，并不需要为该类重载“=”运算符，因为编译系统为每个类提供了默认的赋值运算符“=”，使用这个默认的赋值运算符操作类对象时，该运算符会把这个类的所有数据成员都进行一次赋值操作。

### 一、类的成员函数

**例子：**

```c++
#include <iostream>
#include <algorithm>
using namespace std;

struct Student{
    int Mscore=0;
    int Escore=0;
    bool gratulated=false;

 bool operator <(const Student & a) const
 {
     if(this->Mscore!=a.Mscore)           //先按Mscore排序
        return this->Mscore<a.Mscore;
     return this->Escore<a.Escore;
 }

    
   bool operator ==(const Student & a)const
   {
       if(this->Mscore==a->Mscore&&this->Escore==a->Escore)
           return true;
       return false;
   }
    
  Student operator +(const Student &a)const
 {
     Student temp;
     temp.Escore=this->Escore+a.Escore;
     temp.Mscore=this->Mscore+a.Mscore;
     return temp;
 }

    
 //前++
 Student & operator ++()    //注意不加两个const 因为函数改变了成员值，且没有参数
 {
     this->Mscore++;        //this是指向本对象的指针
     this->Escore++;
     return *this;
 }

 //后++
 Student operator ++(int)
 {
     Student temp=*this;
     this->Escore++;
     this->Mscore++;
     return temp;
 }




} stu[100];


int main()
{
    stu[0].Mscore=10,   stu[0].Escore=1;
    stu[1].Mscore=12,   stu[1].Escore=1;
    stu[2].Mscore=11,   stu[2].Escore=3;
    stu[3].Mscore=11,   stu[3].Escore=4;

    //比较
    cout<<(stu[0]<stu[1])<<" "<<(stu[2]<stu[3])<<endl<<endl;

    //后缀
    cout<<stu[0].Mscore<<" "<<stu[0].Escore<<endl;
    Student temp1=stu[0]++;
    cout<<temp1.Mscore<<" "<<temp1.Escore<<endl<<endl;

    //前缀
    cout<<stu[1].Mscore<<" "<<stu[1].Escore<<endl;
    Student temp2=++stu[1];
    cout<<temp2.Mscore<<" "<<temp2.Escore<<endl<<endl;

    //相加
    cout<<stu[0].Mscore<<" "<<stu[0].Escore<<endl;
    cout<<stu[1].Mscore<<" "<<stu[1].Escore<<endl;
    Student xx=stu[0]+stu[1];
    cout<<xx.Mscore<<" "<<xx.Escore<<endl;



    return 0;
}

```



**注意：**

对于'>' '<' '+' 要有两const 一&   ,对于++ 不加const和 & （也不必太在意）



**理解:**
结构体本来无法比较， 现在定义了 一个属于结构体的< 比较符。  然后 就可以用小于号比较了， 
使用方式是：
 结构体对象1   运算符   结构体对象2
由于<比较的结果是 bool类型， 且比较时 因为成员函数用*this*指针隐式地访问了类的一个对象，它充当了运算符函数最左边的操作数。  









### **二、类的非成员函数**（全局函数）

与前者区别，操作数都需要显示指定

一般是友元函数，下图不太对()，但不必太在意细节

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200320135500177.png" alt="image-20200320135500177" style="zoom: 67%;" />

```C++
struct node{
    int x,y;
    int time;
    int luxian[2][1005];


}now,nex;

bool operator <( node x, node y)  //这里不能加 &  或者 函数后的 const  为啥？？
{
    if(y.time<x.time)
        return true;
    return false;
}

```







### 三、例子（**矩阵乘法**）

非成员函数

```c++
#include <iostream>
const int MAXN=100;
using namespace std;

struct Mat{
    int row,col;
    int m[MAXN][MAXN];
};

Mat operator*(const Mat& a,const Mat& b)
{
    Mat res;
    res.row=a.row;
    res.col=b.col;
    for(int i=0;i<a.row;i++)
        for(int j=0;j<b.col;j++)
    {
        for(int k=0;k<a.col;k++)
        res.m[i][j]+=a.m[i][k]*b.m[k][j];
    }
    return res;
}


void PrinMat(Mat a)
{
    for(int i=0;i<a.row;i++)
    {
        for(int j=0;j<a.col;j++)
            cout<<a.m[i][j]<<" ";
        cout<<endl;
    }


}
int main()
{
    Mat a,b,c;
    a.row=3;a.col=2;
    a.m[0][0]=1;a.m[0][1]=1;
    a.m[1][0]=1;a.m[1][1]=1;
    a.m[2][0]=1;a.m[2][1]=2;
    PrinMat(a);
    
    b.row=2;b.col=3;
    b.m[0][0]=1;b.m[0][1]=1;b.m[0][2]=1;
    b.m[1][0]=1;b.m[1][1]=1;b.m[1][2]=1;
    PrinMat(b);
    
    c=a*b;
    PrinMat(c);
    return 0;
}

```

### 四、总结

重载有两种形式： 成员函数和全局函数，
对有前者，有一个隐藏的左操作数也就是this对象，		如   bool operater <(const & student a)
对于后者,	两个操作数都要指定										如   bool operater<（const & student a,const & student a）

两者的基本格式都是 
返回值类型    operater  符号( const & 类型 对象。。。)        
 对于 < > + - * ==这些容易写，对于++ -- 参考上面的复制一下



如果一个重载操作符是类成员，那么只有当与它一起使用的左操作数是该类的对象时，该操作符才会被调用；而如果该操作符的左操作数确定为其他的类型，则操作符必须被重载为全局函数；
	C++要求'='、'[]'、'()'、'->'操作符必须被定义为类的成员操作符，把这些操作符通过全局函数进行重载时会出现编译错误




# 三、模板的写法

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200320115040988.png" alt="image-20200320115040988" style="zoom:67%;" />

更多请自己查阅



# 四、构造函数

```C++
struct Point{   //二维平面点
    double x,y;
    Point(double x=0, double y=0 ):x(x),y(y) { }
};
```



```C++
struct Point{   //二维平面点
    double x,y;
    Point(double x=0, double y=0 )
    {
        this->x=x;
		this->y=y;
    }
};
```




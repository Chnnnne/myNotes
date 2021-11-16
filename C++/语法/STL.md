# 一、容器

1、顺序容器：是一种各元素之间有顺序关系的线性表，是一种线性结构的可序群集。顺序性容器中的每个元素均有固定的位置，除非用删除或插入的操作改变这个位置。顺序容器的元素排列次序与元素值无关，而是由==元素添加到容器里的次序决定==。顺序容器包括：**vector**(向量)、**list**（列表）、**deque**（双端队列）。(<u>误解：并不是只要顺序容器就可以下标访问，如list 就不可，顺序容器只是说明按照添加进容器的顺序排列</u>)



  2、关联容器：关联式容器是非线性的树结构，更准确的说是二叉树结构。各元素之间没有严格的物理上的顺序关系，也就是说元素在容器中并==没有保存元素置入容器时的逻辑顺序==。但是关联式容器提供了另一种根据元素特点排序的功能，这样迭代器就能根据元素的特点“顺序地”获取元素。==元素是有序的集合==，默认在插入的时候按升序排列。关联容器包括：**map**（集合）、**set**（映射）、**multimap**（多重集合）、**multiset**（多重映射）。



  3、容器适配器：本质上，适配器是使一种不同的行为类似于另一事物的行为的一种机制。容器适配器让一种已存在的容器类型采用另一种不同的抽象类型的工作方式实现。适配器是容器的接口，它本身不能直接保存元素，它保存元素的机制是调用另一种顺序容器去实现，即可以把适配器看作“它保存一个容器，这个容器再保存所有元素”。STL 中包含三种适配器：栈**stack** 、队列**queue** 和优先级队列**priority_queue** 。



---

**顺序容器的一些<u>共同点和区别</u>**

vector、list、deque是有序容器

1 如果你需要高效的随即存取，而不在乎插入和删除的效率，使用vector（尾端的插入也可）
2 如果你需要大量的插入和删除，而不关心随即存取，则应使用list
3 如果你需要随即存取，而且关心两端数据的插入和删除，则应使用deque

|      | vector                                       | list                                                         | deque(double end queue)                                  |
| ---- | -------------------------------------------- | ------------------------------------------------------------ | -------------------------------------------------------- |
| 特点 | 快速的随机存取，快速的在最后插入删除元素     | 可以快速的在任意位置添加删除元素，只能快速的访问最开始和最后面的元素 | 在开始和最后添加删除元素一样快，并且提供了随机访问的方法 |
| 适用 | **需要高效的随机存取**，不在于插入删除的效率 | **需要大量的插入和删除操作**，不关心随机存取                 | **需要随机存取，也需要高效的在两端进行插入删除操作**     |

 

![image-20200318093030653](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200318093030653.png)



![image-20200318093039933](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200318093039933.png)
![image-20200318093045160](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200318093045160.png)

![image-20200318093052757](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200318093052757.png)

***earse(it1,it2);		//删除[it1,it2) 这个区间对应迭代器位置的元素  注意是右边开！***

---



## (1)vector

内部数据结构：数组。
随机访问每个元素，所需要的时间为常量。(<u>下标直接访问</u>)
在<u>**末尾**</u>增加或删除元素所需时间与元素数目无关，（尽量也不要添）

在**中间或开头**增加或删除元素所需时间随元素数目呈线性变化。

```c++
 //1.定义和初始化

    vector<int> vec1;    //默认初始化，vec1为空
    vector<int> vec2(vec1);  //使用vec1初始化vec2
    vector<int> vec3(vec1.begin(),vec1.end());//使用vec1初始化vec2
    vector<int> vec4(10);    //10个值为0的元素
    vector<int> vec5(10,4);  //10个值为4的元素
 //2.常用操作方法
	vec1.size();         //元素个数
    vec1.empty();    //判断是否为空
    vec1[3]    					    //下表获取元素
    vec1.front();
	vec1.back();  

    //注意无pop push_front
    vec1.push_back(100);            //添加元素
	vec1.pop_back();            	//删除末尾元素
    vec1.insert(vec1.end(),5,3);    //从vec1.back位置插入个值为的元素
	vec1.erase(vec1.begin(),vec1.end());//删除之间的元素，其他元素前移

   	cout<<(vec1==vec2)?true:false;  //判断是否相等==、！=、>=、<=...

	sort(v.begin(),v.end(),less<int>());//从小到大
	sort(v.begin(),v.end(),greater<int>());//从大到小排序

    vector<int>::iterator iter = vec1.begin();    //获取迭代器首地址
    vector<int>::const_iterator c_iter = vec1.begin();   //获取const类型迭代器
	vec1.clear();                 //清空元素

    //3.遍历

    //下标法

    int length = vec1.size();
    for(int i=0;i<length;i++)
       cout<<vec1[i];
    //迭代器法
    vector<int>::const_iterator iterator = vec1.begin();
    for(;iterator != vec1.end();iterator++)
    {
       cout<<*iterator;
    }
```

## (2)deque
内部数据结构：数组。（<u>下标直接访问</u>）

**deque与vector类似，但是对首元素提供插入和删除的双向支持**	(<u>比vector多了个**push、pop_front**)</u>

随机访问每个元素，所需要的时间为常量。
在开头和末尾增加元素所需时间与元素数目无关，在中间增加或删除元素所需时间随元素数目呈线性变化。



## (3)list

内部数据结构：双向环状链表。<span id="表1">
不能随机访问一个元素。(<u>不可下标直接访问</u>)
可双向遍历。
在开头、末尾和中间任何地方增加或删除元素所需时间都为常量。
增加任何元素都不会使迭代器失效。删除元素时，除了指向当前被删除元素的迭代器外，其它迭代器都不会失效。

```c++
 //1.定义和初始化
    list<int> lst1;          //创建空list
    list<int> lst2(3);       //创建含有三个元素的list
    list<int> lst3(3,2); //创建含有三个2元素的list
    list<int> lst4(lst2);    //使用lst2初始化lst4
    list<int> lst5(lst2.begin(),lst2.end());  //同lst4
 //2.常用操作方法
    lst1.push_back(10);        
    lst1.pop_back();    
	lst1.pop_front();
    lst1.push_front(10);

    lst1.begin();                      //返回首值的迭代器
    lst1.end();                            //返回尾值的迭代器

    lst1.clear();                      //清空值
     lst1.empty();          //判断为空
    lst1.erase(lst1.begin(),lst1.end());                        //删除元素

    lst1.front();                      //返回第一个元素的引用
    lst1.back();                       //返回最后一个元素的引用

    lst1.insert(lst1.begin(),3,2);         //从指定位置插入个
    lst1.remove(2);                        //相同的元素全部删除
    lst1.reverse();                        //反转
    lst1.size();                      		//含有元素个数
    lst1.sort();                      	 //排序
    lst1.unique();                         //删除相邻重复元素
    //3.遍历
    //迭代器法
    for(list<int>::const_iterator iter = lst1.begin();iter != lst1.end();iter++)
    {
       cout<<*iter;
    }
```



## (4)slist

内部数据结构：单向链表。
不可双向遍历，只能从前到后地遍历。
其它的特性同list相似。

## (5)stack

适配器，它可以将任意类型的序列容器转换为一个堆栈，一般使用deque作为支持的序列容器。
元素只能后进先出（LIFO）。
不能遍历整个stack。

```C++
//  stack和queue的语法类似
    
// 可见 stack无front back，而只有 top，并且无push_back/pop_back 而是push pop

   stack<int> S;
    S.push(1);S.push(2);
    S.pop();
   cout<<S.top();
```





## (6)queue

适配器，它可以将任意类型的序列容器转换为一个队列，一般使用deque作为支持的序列容器。
元素只能先进先出（FIFO）。
不能遍历整个queue。

```C++
//    //queue有 back front，  另外有push和pop
//    cout<<endl;
//    queue<int> Q;
//    Q.push(1);Q.push(2);
//    cout<<Q.back()<<" "<<Q.front();
//    Q.pop();
//    cout<<Q.back()<<" "<<Q.front();

    后续的改变不会改变进队的元素的值！！！注意↓相当于队列中有了副本。引用类型
int a=1;
int b=2;
int c=3;
queue<int> Q;
Q.push(a);
Q.push(b);
Q.push(c);
		
a=100;
b=90;
c=80;	
 for(int i=0;i<3;i++)
{
	cout<<Q.front()<<" ";
	Q.pop(); 
}
```





## (7)priority_queue

适配器，它可以将任意类型的序列容器转换为一个优先级队列，一般使用vector作为底层存储方式。
只能访问第一个元素，不能遍历整个priority_queue。
第一个元素始终是优先级最高的一个元素。



1、堆是一颗完全二叉树

2、堆一般有两种样子，小根堆和大根堆，分别对应“堆顶最大”“堆顶最小”，

- 对于大根堆而言，任何一个非根节点，它的优先级都小于堆顶

- 对于小根堆而言，任何一个非根节点，它的优先级都大于堆顶

<img src="https://i.loli.net/2018/07/13/5b48bcc426d83.png" alt="小根堆" style="zoom: 33%;" />

​													如上图所示为小根堆

``` c++
priority_queue<int> q;								//这是一个大根堆q
priority_queue<int,vector<int>,greater<int> >q;		//这是一个小根堆q
//注意某些编译器在定义一个小根堆的时候greater<int>和后面的>要隔一个空格，不然会被编译器识别成位运算符号>>

和set 有点类似，都可在插入后排序，但是set不允许重复，且 set只能通过 find 或迭代器
```

```C++
//    priority_queue<int> Q;
//    priority_queue<int,vector<int>,greater<int> > Q;
    Q.push(1);
    Q.push(10);
    Q.push(5);
    Q.push(7);
    while(!Q.empty())
    {
        cout<<Q.top()<<" ";
        Q.pop();
    }
//前者结果分别是 10 7 5 1
//前者结果分别是 1 5 7 10
```







## (8)set

键和值相等。   (键key相当于自变量，值value相当于因变量)				key——>value
键唯一。	
元素默认按**升序排列。**
~~如果迭代器所指向的元素被删除，则该迭代器失效。其它任何增加、删除元素的操作都不会使迭代器失效。~~

```c++
 set<int> a;
 vector<int> ivec;
 set<int> iset(ivec.begin(), ivec.end());


 s.insert(item)		//插入元素O(logn)
 s.inset(it1,it2)	//将it1到it2之间的元素插入到s中
 s.size()			//获取元素的个数O(1)
 s.empty()			//判断是否为空O(1)
 s.clear()			//清空s O(n)
 
 //如果只需简单地判断某个元素是否存在，使用 count 即可
 s.find(item)		//在s中查找item并返回其iterator(迭代器)，找不到的话返回s.end()	O(logn)
 s.count(item):		//返回s中item的数量，因为集合中的元素不能重复，因此只能返回0或1 O(logn)
 

 s.erase(it):		//删除s中it指向位置的元素
 s.erase(item):		//删除s中值为item的元素
 s.earse(it1,it2);	//删除[it1,it2) 这个区间对应位置的元素  注意是右边开！

//lower_bound(key_value) ，返回第一个大于等于key_value的定位器
//upper_bound(key_value)，返回一个大于等于key_value的定位器
//m.equal_range(k)	返回一个迭代器的 pair 对象。它的 first 成员等价于 m.lower_bound(k)。而 						second 成员则等价于 m.upper_bound(k)
 s.lower_bound(2)  
 s.lower_bound(3) 
```





- **当set存结构体时，要重载<运算符**，	重载的写法请参考 另一个.md文件

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200319115430942.png" alt="image-20200319115430942" style="zoom: 80%;" />



- 交集并集

```c++
    set<int> S1;
    S1.insert(1);S1.insert(2);S1.insert(3);

    set<int> S2;
    S2.insert(2);S2.insert(3);S2.insert(4);


    set<int> S3;
    set<int> S4;
    //并集
    set_union(S1.begin(),S1.end(),S2.begin(),S2.end(),inserter(S3, S3.begin()));
    for(auto it:S3)
    cout<<it;
    cout<<endl;
    
    //交集
    set_intersection(S1.begin(),S1.end(),S2.begin(),S2.end(),inserter(S4, S4.begin()));
    for(auto it:S4)
    cout<<it;
```





## (9)multiset

键可以不唯一。
其它特点与set相同。



## (10)hash_set

与set相比较，它里面的元素不一定是经过排序的，而是按照所用的hash函数分派的，它能提供更快的搜索速度（当然跟hash函数有关）。
其它特点与set相同。



## (11)hash_multiset

键可以不唯一。
其它特点与hash_set相同。



## (12)map

**key——>value**
第一个可以称为关键字(key)，每个关键字只能在map中出现一次；
第二个可称为该关键字的值(value)；

键唯一。 （只能多对一，不能一对多）
**元素默认按键的升序排列。**
~~如果迭代器所指向的元素被删除，则该迭代器失效。其它任何增加、删除元素的操作都不会使迭代器失效~~。
**理解：**
在set和map中，都有这样的一个模式，叫做 **key——value**模式

```c++
//1.定义和初始化
    map<int,string> map1;                  //空map
//2.常用操作方法

 	//添加元素
    map1[3] = "Saniya";                   
    map1.insert(pair<int,string>(1,"Siqinsini"));
//用insert函数插入数据，在数据的 插入上涉及到集合的唯一性这个概念，即当map中有这个关键字时，insert操作是不能在插入数据的，但是用数组方式就不同了，它可以覆盖以前该关键字对 应的值，

	//删除元素
    map1.erase(iter_map);                  //删除迭代器数据
    map1.erase(3);                         //根据key删除key-value对

	//在map中查找key并返回其iterator,找不到的话返回mp.end() O(logn)
	mp.find(key)
	iter = mapStudent.find("123");
	if(iter != mapStudent.end())
        cout<<"Find, the value is"<<iter->second<<endl;
	else
   		cout<<"Do not Find"<<endl;

    //在map中找key的数量，由于每个key都是唯一的，只会返回0或1    
  	mp.count(key)

    map1[3];                  //根据key取得value,若不存在会添加

	map<int,string>::iterator iter_map		//迭代器写法
        
    int key = iter_map->first;             //取得eky
    string value = iter_map->second;       //取得value


    map1.size();                       //元素个数
    map1.empty();                       //判断空
    map1.clear();                      //清空所有元素



    //3.遍历
    for(map<int,string>::iterator iter = map1.begin();iter!=map1.end();iter++)
    {
      int key = iter->first;
       string value = iter->second;
    }

	for(auto tmp:m){
	cout<<tmp.first<<" "<<tmp.second<<endl;
	}
```



## (13)multimap

键可以不唯一。
其它特点与map相同。

## (14)hash_map

与map相比较，它里面的元素不一定是按键值排序的，而是按照所用的hash函数分派的，它能提供更快的搜索速度（当然也跟hash函数有关）。
其它特点与map相同。

## (15)hash_multimap

键可以不唯一。
其它特点与hash_map相同。





## 补充：string

> string的length()和size()方法只是同义词而已。size()方法与其他的STL容器一致，
>
> 比如vector, map等等。而length()与大多数人对于字符串的直觉感受一致。人们谈论一个单词，一个句子，一个段落的长度，而不是大小或者尺寸，因此length()方法是为了增强可读性。

1. 初始化/赋值：

   ```C++
   string str="ABCDE";
   不能这样： string s; s[0]='A'; s[1]='B';
   但可以： 修改已被初始化之后的串
   ```

2. 输入

   ```c++
   string str;
   getline(cin,str);    //1获取一行数据 （可以读入空白符）
   cin>>str			//2获取一块数据 （空白符作为分隔符）
   ```

3. 排序

   ```C++
   string str="165432ACBDacbd";
   sort(str.begin(),str.end());
   cout<<str;//123456ABCDabcd
   ```

4. 访问/遍历

   ```C++
   string就是一个字符串（由一个一个的字符char组成的串）
   //1直接下标访问
   string str="123";
   cout<<str; //123
   str[0]='9',str[1]='9',str[2]='9';
   cout<<str; //999
   
   string s="5418340";
   for(int i=0;i<s.length();i++) cout<<s[i];
   
   //2迭代器
   for(string::iterator it=s.begin();it!=s.end();it++) 
       cout<<*it;
   //3简化迭代器
   for(auto it=s.begin();it!=s.end();it++) 
       cout<<*it;
   //4C++ 11新特性for循环
   for(auto x:s) 
       cout<<x;删除
   ```

5. 删除

   ```C++
   string s="5418340";
   s.erase(s.begin());//删除第一个
   s.erase(--s.end());//删除最后一个
   ```

6. 截取

   ```C++
   string s="5418340";
   s=s.substr(1,3);//取418,取索引为1，往后截断3个
   s=s.substr(1,-1);//索引为1，截断到最后
   ```

7.查找

```C++

  size_type find( str,  index );
  size_type find( char *str,  index );
  size_type find( char *str,  index,  length );
  size_type find( char ch,  index );
找到了返回所在位置的下标 （从0开始）
没有找到则返回string::npos 
 

```









## 补充：stringstream

头文件：#include <sstream>

功能是转化

```C++
//分离
string str; 
getline(cin,str);
stringstream ss;
ss<<str;
while(ss>>str)
   cout<<str<<" + ";
```



```C++
 //字符串转数字
 string s="1234";
 int i;
 stringstream ss;
 ss<<s;
 ss>>i;
 cout<<i;	//1234
//也可以
string s="1234";
int i=stoi(s);
```



```C++
//数字转字符串
int a=1234;
string out;
stringstream ss;
ss<<a;
ss>>out;
cout<<out<<endl;
```



# 二、算法

## 1、sort函数 

sort(first, last, compare)  

first：排序起始位置（指针或 iterator）  因此string vector等可以调用（用.begin .end）

last：排序终止位置的下一个位置（指针或 iterator） 

compare：⽐较方式 



---



- sort 排序的范围是 [first, second)，时间为 O(nlogn) 

- 调⽤用 sort 时前两个参数必须有，最后⼀一个参数可有可⽆无，没 有时按升序排序
- **cmp写法**请参考 另一个md文件



## 2、binary_search

- 这个序列中的元素必须被排成【注意！前提是**升序序列**】~~或者至少相对于所查找元素是有序的。~~
- 如果找到第三个参数，这个算法会返回布尔值 true，否则返回 false。
- 指定范围的迭代器必须是正向迭代器而且元素必须可以使用 < 运算符来比较。

```c++
int a[]={1,2,3,4,5,6,7,8,9};
bool flag=binary_search(a,a+9,10);
```

小结：发现只要涉及有序的容器 都需要**重载运算符<**（默认的除外）



binary_search() 能告诉我们元素是否在这个序列中，但当它在序列中时，却不能告诉我们它的位置。 当然，如果必须知道它的位置，可以使用前面介绍的查找算法或 lower_bound()、 upper_bound() 或 equal_range(}。



## 3、lower_bound / upper_bound

- 元素是升序排列的，所以查找机制使用小于运算符来查找元素。搜索降序序列需要使用小于运算符来比较元素【注意！前提是【**升序序列**】

- **lower_bound返回指向区间中>=value的第一个元素的迭代器, upper_bound返回区间中>value的第一个元素的迭代器。**

  ```c++
  //区间中有指定元素
  int a[8] = {0, 1, 2, 2, 3, 4, 5, 6};
  lower_bound(a, a + 8, 2) 返回的是 (a+2) 指向第一个2
  upper_bound(a, a + 8, 2) 返回的是 (a+4) 指向3 
      
  //区间中没有指定元素，lower_bound和upper_bound的返回值是一样的
  int a[8] = {0, 1, 3, 4, 5, 6, 7, 8};
  lower_bound(a, a + 8, 2) 返回的是 (a+2) 指向3
  upper_bound(a, a + 8, 2) 返回的是 (a+2) 指向3
  
      
  int a[]={1,2,3,4,5,6,7,8,9};
  cout<<lower_bound(a,a+9,3)-a+1; //求指定元素在第几个
  
  int a[]={1,2,3,4,5,6,7,8,9};
  cout<<lower_bound(a,a+9,10000)-a+1;//output:10   
  //没找到时返回最后一个元素的下一个位置的迭代器
  ```

这俩函数也可以对降序序列排列，只是要加点东西

请参考：[CSDN博客写的很清晰](https://blog.csdn.net/qq_40160605/article/details/80150252)

   

## 4、min_element / max_element

iterator min_element(iterator begin, iterator end);

iterator max_element(iterator begin, iterator end);



## 5、unique（）

- 详细请点击[文章链接](https://www.cnblogs.com/wangkundentisy/p/9033782.html)

- ```
  iterator unique(iterator it_1,iterator it_2);
  ```

- 其中这两个参数表示对容器中[it_1，it_2)范围的元素进行去重(注：区间是前闭后开，即不包含it_2所指的元素),返回值是一个迭代器，它指向的是去重后容器中不重复序列的**最后一个元素的下一个元素**

- **一定不要忘记的是，unique函数在使用前需要对容器中的元素进行==排序==**

- unique函数通常和erase函数一起使用，来达到删除重复元素的目的。(注：此处的删除是真正的删除，即从容器中去除重复的元素，容器的长度也发生了变换；**而单纯的使用unique函数的话，容器的长度并没有发生变化，只是元素的位置发生了变化)**



例子：

```c++
int a[]={1,2,2,2,3,4,5,6,6,7,8,9};
//注意要额外用一个变量存，否则第二次循环 unique会对破坏数组
int *new_end=unique(a,a+12);

for(int *p=a;p!=new_end;p++)
    cout<<*p<<" ";
//1 2 3 4 5 6 7 8 9

```
```c++
 	vector<int> a ={1,3,3,4,5,6,6,7};
    vector<int>::iterator it_1 = a.begin();
    vector<int>::iterator it_2 = a.end();
    vector<int>::iterator new_end;
 
    new_end = unique(it_1,it_2); //注意unique的返回值
    a.erase(new_end,it_2);
    cout<<"删除重复元素后的 a : ";
    for(int i = 0 ; i < a.size(); i++)
        cout<<a[i];
  
```





排序后，去重操作

![image-20210317163724560](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210317163724560.png)



## 6、全排列next_permutation  / pre 

- 详细请点击 [文章链接](https://blog.csdn.net/AC_Gibson/article/details/45308645?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task)

- prev_permutation 与 next_permutation 类似，唯⼀一的不不同 时 prev 每次将范围内的元素重新排列列为下⼀一个按字典顺序排 列列的更更⼩小排列列







# 三、自己的实验和总结

- 顺序和关联的主要区别是 前者按插入顺序排列，后者自动按每种特性排列
- 顺序容器的 共有 **.begin() .end()  .front()  .back()  .push_front()  .push_back  .pop_front()  .pop_back**		（注意vector中push和pop无front）
- 对于所有容器都有 erase insert 顺序容器的参数只能是迭代器，而 set和map还可以是key值
- string是length()不是size
- 适配器没有迭代器
- 适配器的有 push、pop              **stack** 有top   size              **queue** 有front back size    priority_queue 有 top 无front
- 几个关键概念 编程中常用的关键字  
  - **iter-迭代器    item-实体    **
  - **key——>value       键——>值** 

```c++
int main()
{
    ios::sync_with_stdio(0);

 
    
//    vector<string> V;
//    V.push_back("AAA");
//    V.push_back("BBB");
//    //没有 push_front、pop_front();相反 list和deque有 因为vector是单端的只能在后面
//    V.pop_back();
//    cout<<V.front();
//    cout<<V.back()<<endl;

    
//    deque<int> D;
//    D.push_back(1);
//    D.push_back(2);
//    D.push_back(3);
//    D.push_front(0);
//    for(deque<int>::iterator it=D.begin();it!=D.end();it++)
//        cout<<*it<<" ";
//    D.pop_front();
//    D.pop_back();
//    for(deque<int>::iterator it=D.begin();it!=D.end();it++)
//        cout<<*it<<" ";

    
    
//  stack和queue的语法类似
    
//    //可见 stack无front back，而只有 top，并且无push_back/pop_back 而是push pop
//    cout<<endl;
//    stack<int> S;
//    S.push(1);S.push(2);
//    S.pop();
//    cout<<S.top();

    
//    //queue有 back front，  另外有push和pop
//    cout<<endl;
//    queue<int> Q;
//    Q.push(1);Q.push(2);
//    cout<<Q.back()<<" "<<Q.front();
//    Q.pop();
//    cout<<Q.back()<<" "<<Q.front();

    后续的改变不会改变进队的元素的值！！！注意↓
int a=1;
int b=2;
int c=3;
queue<int> Q;
Q.push(a);
Q.push(b);
Q.push(c);
		
a=100;
b=90;
c=80;	
 for(int i=0;i<3;i++)
{
	cout<<Q.front()<<" ";
	Q.pop(); 
}
    
//    string str;
//    getline(cin,str);
//
//    sort(str.begin(),str.end());
//    cout<<str;
//    do{
//        cout<<str<<endl;
//    }while(next_permutation(str.begin(),str.end()));

    
    

	return 0;
}

```





# 四、一些其他的知识



## 1、关于程序运行时间 



-  一般情况下⽤用 cin/cout 进⾏行行数据读写要⽐比 scanf/ printf 慢得多，所以在输⼊入输出⽂文件较⼤大的情况下⽤用 cin/ cout 可能会超时 

- cin/cout 效率低的原因之⼀一是它要与 stdio 保持同步， 以免在⼆二者混⽤用的时候出现问题 

- 因此我们可以通过关闭与 stdio 的同步来提⾼高 cin/cout 的速度，**不不过这时我们不不能再两者混⽤用了了，不不然会出错** 。

`关闭同步代码：ios::sync_with_stdio(false);`    或者把false换成0



## 2、关于提高map/set的速度

- map/set 因为要维持内部元素排列列有序所以在时间上会多⼀一 些开销  
- 如果我们不不需要维持排列列有序的话可以使⽤用 C++ 11 提供的 unordered_map/unordered_set  这两种容器分别在 #include <unordered_map> 和 #include <unordered_set> ⾥
- **unordered_map 和 unordered_set 的查询操作的平均 时间复杂度为 O(1)，最坏时间复杂度为 O(n)，可以⼤大 提⾼查询效率** ，不过如果⽐赛不提供 C++ 11 的环境的话这两种容器就无法 使用了

**（也即如果不需要顺序访问map、set的话 而只是单单只涉及查询，那么就用unorder的）**



## 3、关于提高vector速度

- 对 vector 进⾏大量 push_back 操作会产生很大的时间 开销，因为每次 push_back 都需要请求新内存空间，并且 在当前 vector ⻓度大于 capacity（容量量）值时会对整 个 vector 重新分配内存 

- 因此在使⽤用 vector 之前可以通过 .reserve(n) 将 vector 的 capacity 设定为一个足够大的数 n，这样可 以大提高 push_back 的效率 reserve 不会影响 vector 中的元素



## 4、 auto的使用  （C++11）

```c++
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

int main()
{
    map <char,int> m;
    m['a']=1;
    m['b']=2;
    m['c']=3;

    for(auto item:m)
        cout<<item.first<<" "<<item.second<<" ";//注意 区别 一个是. 一个是->

    for(auto it=m.begin();it!=m.end();it++ )
        cout<<it->first<<" "<<it->second<<" ";

    for(map<char,int>::iterator it=m.begin();it!=m.end();it++)
        cout<<it->first<<" "<<it->second<<" ";
    return 0;
}

```


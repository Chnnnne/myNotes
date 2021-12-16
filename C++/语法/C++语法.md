

# STL新总结



[有时间看一看](https://blog.csdn.net/u010183728/article/details/81913729?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-2.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-2.control)



## 零、小总结

对于set map priority_queue 都需要定义排序规则







### 有关排序

**\>      降序**

**<	 升序    默认**

less 默认  大的优先级高（默认升序）、greater 小的优先级高  

一句话==大降小升(默认)==



1、**对于数组**

我们只能使用**sort**来排序， 对于自定义或基本类型，我们都可以使用默认的排序规则（基本类型是升序，自定义类型按照小于号重载）,我们也可以重新制定排序规则，重写cmp（对于自定义如果没有重载< ，那么直接用cmp。若重载<号，则用cmp覆盖）



> 补充：sort函数使用方法是 sort(start,end)  注意是**[Start,end)  前开后闭**，
> 因此**sort(  起始地址   ,起始地址+length）**
>
> 区分memset(a, 0, sizeof a)

**2、对于容器**

**2.1不能自排序的容器** 如 vector 、string

我们可以用**sort(begin(),end())**的方式来排序基本数据类型 或 自定义数据类型，也可以重写cmp根据规则



**2.2能自排序的容器** 如set/map/priority_queue

我们不能用**sort**了，因为会破坏它自带的**自排序**功能

1. 对于基本数据类型，我们可以初始化时 用set<int,greater < int >  > priority_queue<int,vector< int>, greater< int> > pq，这样的形式来指定排序规则，也可以重载()
2. 对于自定义类型，我们需要重写<  或者 写一个结构体comp，然后里面重载（）   当同时有< 和comp时comp优先



set map 默认都是升序排列，  priorityqueue注意是大的在前



例子：

```C++
#include<cstdio>
#include<algorithm>
#include<iostream>
#include<queue>
#include<map>
#include<set>
#include<vector>
using namespace std;

struct Student{
    string name;
    int id;
    double score;
    Student(string name = "wangchen", int id = 1, double score = 99.9) :name(name),id(id),score(score){}
}s[4];
bool operator < (const Student &x,const Student &y){
    //score(big) first then the name(small)
    if(x.score != y.score){
        return x.score > y.score;  //大 降 
    }else{	
        return x.name < y.name;		//小  升 
    }
}


//基本数据类型数组排序
bool cmp1(int x, int y){
    return x > y;//大降
}
void test1(){
    int a[]={1,2,3,10,9,8,7};
    for(auto item: a){
        cout<< item<<" ";
    }
    cout<<endl;

    sort(a, a + 7);
    for(auto item: a){
        cout<< item <<" ";
    }
    cout<<endl;
    sort(a, a + 7, cmp1);
    for(auto item: a){
        cout<< item<<" ";
    }
    cout<<endl;
}

//自定义数据类型数组排序
bool cmp2(Student &x,Student &y){
    return x.id < y.id; //按照id
}
void test2(){
    s[0] = Student();
    s[1] = Student("aaaa",2,99.9);
    s[2] = Student("lihua",3,70.7);
    s[3] = Student("jiba",4,60.6);
    for(int i = 0 ; i < 4; i++){
        cout<<s[i].name<<" "<<s[i].id<<" "<<s[i].score<<endl;
    }
    cout<<endl;
    sort(s,s+4);//默认 <
    for(int i = 0 ; i < 4; i++){
        cout<<s[i].id<<" "<<s[i].name<<" "<<s[i].score<<endl;
    }

    //还可以重新指定
    cout<<endl;
    sort(s,s+4,cmp2);
    for(int i = 0 ; i < 4; i++){
        cout<<s[i].id<<" "<<s[i].name<<" "<<s[i].score<<endl;
    }
}

//非自排序容器排序
void test3(){
    vector<Student> ve;
    sort(ve.begin(),ve.end(),cmp2);
}



//自排序容器 基本数据类型
struct comp1{
    bool operator ()(int a, int b){
        return a > b;
    }
};
void test4(){
    // priority_queue<int,vector<int>, greater<int> > pq;//小的在前  
    // priority_queue<int,vector<int> , comp1> pq;//大降 小的在前
    // priority_queue<int> pq;//小升 默认， 大的在前
    pq.push(1);
    pq.push(10);
    pq.push(2);
    pq.push(9);
    while(!pq.empty()){
        int t = pq.top();
        cout<<t<<" ";
        pq.pop();
    }


    cout<<endl;
    set<int,greater<int> > se;//降
    // set<int > se;//默认 小升
    se.insert(1);
    se.insert(4);
    se.insert(2);
    se.insert(3);
    for(auto it:se){
        cout<<it<<" ";
    }

}


//自排序容器，   自定义数据类型
struct comp2{
    bool operator ()(const Student &s1,const Student &s2){
        return s1.score < s2.score;
    }
};
void test5(){
    // priority_queue<Student> pq;
    priority_queue<Student,vector<Student> , comp2> pq;
    pq.push(Student());
    pq.push(Student("lihua",2,90));
    pq.push(Student("xiaoming",3,30));
    pq.push(Student("lihua",4,60));
    while(!pq.empty()){
        auto it = pq.top();
        cout<<it.name<<" " << it.id<<" "<<it.score<<endl;
        pq.pop();
    }
}

//pair
//默认地排序规则是  小 升  ，第一个
typedef pair<int,int> PII;
bool cmp3(PII p1,PII p2){
    return p1.first > p2.first;
}
void test6(){
    //Construct
    pair <int,int> p1 = {1,3};
    pair <int,int> p2(2,4);
    pair <int ,int> p3 = pair<int,int>(3,8);//推荐
    pair <int ,int> p4 = make_pair(4,16);
    PII p5 = PII(5,20);//推荐
    PII p6 = {6,31};
    PII ps1[]={{1,2},{4,9},{3,8},{2,7}};
    for(int i = 0;i < 4; i++){
        cout<<ps1[i].first<<" "<<ps1[i].second<<endl;
    }
    cout<<endl;

    //sort
    sort(ps1,ps1+4);//默认都是升序
    for(int i = 0;i < 4; i++){
        cout<<ps1[i].first<<" "<<ps1[i].second<<endl;
    }
    cout<<endl;
    sort(ps1,ps1+4,cmp3);
    for(int i = 0;i < 4; i++){
        cout<<ps1[i].first<<" "<<ps1[i].second<<endl;
    }

    cout<<endl<<endl;
    //set and priority_queue
    // priority_queue<PII> pq; //依次按照第一个和第二个 大的在前 （因为小升,大的优先级高)
    priority_queue<PII,vector<PII> , greater<PII> > pq;//一次按照第一个和第二个 小的在前
    pq.push({1,9});
    pq.push({2,8});
    pq.push({2,7});
    pq.push({4,6});
    while(!pq.empty()){
        cout<<pq.top().first<<" "<<pq.top().second<<endl;
        pq.pop();
    }
}

int main(){
    test6();





    return 0;
}
```









## 一、vector

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210422164944551.png" alt="image-20210422164944551" style="zoom:33%;" />

[resize/reserve]([C++ STL 教程 | 菜鸟教程 (runoob.com)](https://www.runoob.com/cplusplus/cpp-stl-tutorial.html))

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210422172109912.png" alt="image-20210422172109912" style="zoom:50%;" />

```C++
#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;


int main(){
    vector<int> v1;
    // cout<<v1.capacity();
    v1.push_back(1);
    v1.push_back(10);
    v1.push_back(2);
    v1.push_back(9);
    v1.push_back(3);
    v1.push_back(8);
    // cout<<v1.capacity();

 /*    for(int i = 0; i <v1.size() ;i++){
        cout<<v1[i]<<" ";
    }
    cout<<endl;
    for(vector<int>::iterator iter=v1.begin() ; iter != v1.end() ;iter++){
        cout<<*iter<<" ";
    }
    cout<<endl;
    for(int i = 0; i < v1.size(); i++){
        cout<<*(v1.begin()+i)<<" ";
    }
    cout<<endl;
    for(int item:v1){
        cout<<item<<" ";
    }
    cout<<endl;
    for(auto item:v1){
        cout<<item<<" ";
    } */



    /*
    auto iter = find(v1.begin(),v1.end(),3);//在algorithm头文件中中
    if(iter!=v1.end()){
        cout<<"找到了";
    }else{
        cout<<"没找到"
    } 
    */

 /*    v1.insert(v1.begin()+2,2,999);//iter,num,val
    for(int item:v1){
        cout<<item<<" ";
    }
    v1.erase(v1.begin()+2,v1.begin()+4);
    for(int item:v1){
        cout<<item<<" ";
    } */

    return 0;
}
```





## 二、set

①set    ②multiset   ③ unorderedset

**对于unorderedset还不会存储自定义数据类型**

[有关于排序](https://blog.csdn.net/love20165104027/article/details/81510406?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EOPENSEARCH%7Edefault-2.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EOPENSEARCH%7Edefault-2.control) 或者 [这个](https://blog.csdn.net/Willing_hope/article/details/108455331)

```C++
#include<iostream>
#include<set>
using namespace std;
/*
问题1：怎样改变set 存基本类型的顺序？ 比如我想让大的在前面
已解决：使用greater<int>
问题2：怎样二次排序，比如我不想按照指定的规则排序了，想再重新排序
使用sort？？
思路错误： set本来就是自排序，你不能把它变成其他排序
*/
int main(){
    // set<int> set1;			省略了less<int>   升序排列
    set<int, greater<int> > set1;	//降序排列
    set1.insert(1);
    set1.insert(10);
    set1.insert(2);
    set1.insert(2);
    set1.insert(8);
    set1.insert(8);

    //travel
    for(auto item:set1){
        cout<<item<<" ";
    }
    for(auto iter = set1.begin();iter != set1.end() ;iter++){
        cout<<*iter<<" ";
    }
    for(set<int>::iterator iter = set1.begin() ; iter != set1.end(); iter++){
        cout<<*iter<<" ";
    }
    cout<<endl;

    //查找
    if(set1.find(100)!=set1.end()){
        cout<<"找到了"<<endl;
    }else{
        cout<<"没找到"<<endl;
    }

    cout<<set1.count(100)<<endl;

    int n = 9;
    if(set1.upper_bound(n)==set1.end()){
        cout<<"没有更大的了"<<endl;
    }else{
        cout<<"更大的是:"<<*set1.upper_bound(n)<<endl;
    }
    
    
    //删除
    set1.erase(set1.begin());
    for(int i:set1){
        cout<<i<<" ";
    }
    set1.erase(10);
    for(int i:set1){
        cout<<i<<" ";
    }

    // auto it = set1.equal_range(4);
    // cout<<<it.first<<" "<<it.second;
    return 0;
}
```



```C++
#include<iostream>
#include<set>

using namespace std;

int main(){
    // set<string,greater<string> > set1;
    set<string> set1;
    set1.insert("wangchen");
    set1.insert("aaa");
    set1.insert("bbb");
    set1.insert("ccc");
    for(auto item: set1){
        cout<<item<<" ";
    }


    return 0;
}
```



### 关于end

http://www.cplusplus.com/reference/set/set/end/

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211109101439825.png" alt="image-20211109101439825" style="zoom:50%;" />

### 集合的交并补

set_union(a.begin(),a.end(),b.begin(),b.end(), inserter(res, res.end()));//(名，名.end())
set_intersection(a.begin(),a.end(),b.begin(),b.end(),inserter(res, res.end()));
set_difference(a.begin(),a.end(),b.begin(),b.end(),inserter(res, res.end()));

[参考](https://blog.csdn.net/qq_39685968/article/details/104558639) 

```C++
int main()
{
    set<int> a,b;
    int n,m;
    cin>>n>>m;
    while(n--){int x;cin>>x;a.insert(x);}
    while(m--){  int x; cin>>x;b.insert(x);}
    //并集
    set<int> res;
    set_union(a.begin(),a.end(),b.begin(),b.end(), inserter(res, res.end()));
    cout<<"union:\n";
    for(auto item: res)
        cout<<item << " ";
    cout<<endl;
    res.clear();
    
    //交集
    set_intersection(a.begin(),a.end(),b.begin(),b.end(),inserter(res, res.end()));
    cout<<"intersection:\n";
    for(auto item: res)
        cout<<item << " ";
    cout<<endl;
    res.clear();

    //差集
    set_difference(a.begin(),a.end(),b.begin(),b.end(),inserter(res, res.end()));
    cout<<"difference:\n";
    for(auto item: res)
        cout<<item << " ";
    cout<<endl;
    res.clear();
    return 0;
}

```



[还可以这样](https://blog.csdn.net/qq_41076797/article/details/110246876)    还是用上面的吧

```C++
#include<iostream>
#include<set>
#include<vector>
#include<algorithm>
using namespace std;
 
int main()
{
    set<int> a,b;
    vector<int> c;
    int n,m;
    cin>>n>>m;
    while(n--)
    {
        int x;
        cin>>x;
        a.insert(x);
    }
    while(m--)
    {
        int x;
        cin>>x;
        b.insert(x);
    }
    //并集
    set_union(a.begin(),a.end(),b.begin(),b.end(),back_inserter(c));
    for(int t:c)cout<<t<<" ";
    cout<<endl;
    c.clear();
    //交集
    set_intersection(a.begin(),a.end(),b.begin(),b.end(),back_inserter(c));
    for(int t:c)cout<<t<<" ";
    cout<<endl;
    c.clear();
    //差集
    set_difference(a.begin(),a.end(),b.begin(),b.end(),back_inserter(c));
    for(int t:c)cout<<t<<" ";
    cout<<endl;
    c.clear();
    return 0;
}
```





## 三、String

### 3.1c_str()

`const char *c_str(); `

1.c_str是一个内容为字符串指向字符数组的临时指针； 
2.c_str返回的是一个可读不可改的常指针；

```C++
//错误写法
char* c; 
string s="1234"; 
c = s.c_str(); 
```



c最后指向的内容是垃圾，因为s对象被析构，其内容被处理，同时，编译器也将报错——将一个const char *赋与一个char* 。

```C++
//正确写法
char c[20]; 
string s="1234"; 
strcpy(c,s.c_str()); 
cout<<c;
```





### 3.2其他

```C++
#include<iostream>
#include<string>
#include<cstring>
using namespace std;

int main()
{
    //读取
    string str,str1,str2,str3,str4,str5;
    cin>>str1>>str2;
    getchar();//吸收回车
    getline(cin,str3);//会读取回车
    cout<<str1<<str2<<endl;
    cout<<str3<<endl; 


	//截取
    str4 = "abcdefghijklmn";
    str5 = str4.substr(4,4);
    char c[30];
    strcpy(c,str5.c_str());
    cout<<c<<endl; 


    //遍历
    str = "wangchen";
    for(int i = 0; i < str.size() ; i++)
    {
        cout<<str[i];
    }
    for(auto iter = str.begin();iter != str.end(); iter++){
        cout<< *iter;
    }
    for(int i = 0 ; i < str.size(); i++){
        cout<<*(str.begin()+i);
    } 

    for(char c:str){
        cout<<c;
    }
    

/*     str = "wangchen";
    str.insert(4,"xiao");
    cout<<str<<endl;
    str.erase(str.begin());
    cout<<str<<endl;
    str.erase(0,3);//从0开始的三个字符
    cout<<str<<endl;
    str.erase(3);//从3开始的所有字符
    cout<<str<<endl;
    str.erase();//从0开始的所有
    cout<<str<<endl; */

 /*    str = "wangchen";
    cout<<str.find("chen")<<endl;
    cout<<(-1==str.find("pi"))<<endl;
    cout<<(-1==string::npos) <<endl; */

/*     //把文章中所有的xiaohua 替换成wangchen
    getline(cin,str);
    int now = 0;
    while(true){
        int pos = str.find("xiaohua",now);
        if(pos==string::npos) break;

        str.replace(pos,7,"wangchen");//从pos开始的位置，连续7个字符被替换成wangchen
        now = pos+1;

    }
    cout<<str; */
    
    
    return 0;
}
```







## 四、map

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210425212241245.png" alt="image-20210425212241245" style="zoom: 50%;" />

①map    ②multimap   ③ unorderedmap

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210423152506333.png" alt="image-20210423152506333" style="zoom:33%;" />

C++ set 和 unordered_set 对应java TreeSet 和 HashSet





<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210423202626731.png" alt="image-20210423202626731" style="zoom:33%;" />

也即 

```C++
//当key不存在时
map<string,int> mp;
mp[key];
//等价于
mp[key] = 0;
```



```C++
//加入键值对
    mp["wangchen"] = 99;
    mp["lihua"] = 78;
    mp["xiaoming"] = 63;
    mp.insert({"销户",35});
    mp.insert(make_pair("肉鸡",39));
    mp.insert(pair<string,int>("jacklove",30));
//覆盖
    mp.insert({"销户",999999});//不能覆盖
    mp["销户"]=777777;//覆盖成功
```

```C++
//迭代器刪除
iter = mapStudent.find("123");
mapStudent.erase(iter);
 
//用关键字刪除
int n = mapStudent.erase("123"); //如果刪除了會返回1，否則返回0
 
//用迭代器范围刪除 : 把整个map清空
mapStudent.erase(mapStudent.begin(), mapStudent.end());
//等同于mapStudent.clear()

    cout<<mp.count("销户")<<endl;
```







## 五、queue & priority queue &stack

### 1、queue

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210422172545515.png" alt="image-20210422172545515" style="zoom: 33%;" />

```C++
int main(){
    queue<int> qu;
    qu.push(1);
    qu.push(2);
    qu.push(3);
    qu.push(4);
    qu.push(5);

    while(!qu.empty()){
        cout<<qu.front()<<endl;
        qu.pop();
    }

    /*
   	不能这样遍历！！！ 
    for(auto item: qu){
        cout<<item<<endl;
    } */


    return 0;
}
```







### 2、priorityqueue

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210422173528705.png" alt="image-20210422173528705" style="zoom:33%;" />

| 名字           | 进队 | 出队 | 展示        |
| -------------- | ---- | ---- | ----------- |
| queue          | push | pop  | front、back |
| priority_queue | push | pop  | top         |
| stack          | push | pop  | top         |

```c++
//   重载写法   优先级高        sort-cmp
//   >          小              降序  
//   <          大（默认）      升序  

#include<iostream>
#include<queue>
using namespace std;
struct Point{
    int x,y;
    Point(int x = 0, int y = 0): x(x),y(y){}
};
bool operator < (const Point &a, const Point &b){//先按x小，再按y小
    if(a.x!=b.x)
        return a.x>b.x;
    else
        return a.y>b.y;
}

//法2
struct comp{
    bool operator() (const int &a, const int &b){
        return a > b;
    }
};

int main(){
    //基本类型：
    //大的在前:
    // priority_queue<int> pq;   //可省略less<int>

    //小的在前 ：
    //法1:
    // priority_queue<int,vector<int>,greater<int> > pq; 
    //法2:
    priority_queue<int , vector<int> , comp> pq;
    pq.push(3);
    pq.push(1);
    pq.push(2);
    while(!pq.empty()){
        cout<<pq.top()<<" ";
        pq.pop();
    }
    cout<<endl;


    //自定义类型
    /* priority_queue<Point> pq;
    pq.push(Point(1,1000));
    pq.push(Point(10,999));
    pq.push(Point(2,998));
    pq.push(Point(8,997));
    pq.push(Point(2,996));
    while(!pq.empty()){
        int x = pq.top().x;
        int y = pq.top().y;
        cout<<x<<" "<<y<<endl;
        pq.pop();
    } */


    return 0;
}
```











### 3、stack

```C++
#include<iostream>
#include<stack>
using namespace std;
struct point{
    int x,y;
    point(int x = -1, int y = -1):x(x), y(y){}
};

int main(){
    /* stack<int> s;
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    while(!s.empty()){
        cout<<s.top()<<endl;
        s.pop();
    } */
    stack<point> s1;
    s1.push(point(1,3));
    s1.push(point(2,4));
    s1.push(point(3,6));
    s1.push(point());
    cout<<s1.top().x;
    return 0;
}
```





### 小总结

| 名字           | 进队 | 出队 | 展示        |
| -------------- | ---- | ---- | ----------- |
| queue          | push | pop  | front、back |
| priority_queue | push | pop  | top         |
| stack          | push | pop  | top         |













## 七、Pair

两个pairs互相比较时， 第一个元素正具有较高的优先级.





# 其他新总结



## 一、strcut

注意点：

1. 函数内的重载 ，要在函数后加const，参数也要const &。外部的重载，不用加const。而都要有参数的& 和const
   原因在"笔记"-"关于const"里
2. 建议使用默认参数的形式，注意的是 在定义时使用默认参数时，不能Point p1(),而是Point p1

```C++
#include<bits/stdc++.h>
using namespace std;

struct Point{
    int x,y;
    Point(int x=0,int y=0):x(x),y(y){}
};
bool operator <(const Point &a,const Point &b){
    return a.x > b.x;
}
bool operator ==(const Point &a,const Point &b){
    return a.x == b.x && a.y == b.y; 
}
Point operator +(const Point &a, const Point &b)
{
    Point res(0,0);
    res.x=a.x+b.x;
    res.y=a.y+b.y;
    return res;
}

int main(){
    Point p;//			对于使用构造函数的默认参数时，不能加括号
    Point p0 = Point();		//推荐
    Point p1 = Point(5,5); //推荐
    Point p2(1,1);
    Point p3(15,4);
    Point p4 = p1+p3;
    p4.print();
    return 0;
}
```

```C++
    // Point operator +(const Point &a)const
    // {
    //     Point res;
    //     res.x=a.x+this->x;
    //     res.y=a.y+this->y;
    //     return res;
    // }
```









## 二、const 、define、typedef

const 用于定义符号常量

**define定义宏操作**

**typedef  简化类型书写** 

后两者书写格式：    把  **什么**  定义成 **什么**

typedef pair<int, int> PII;

```C++
#define Pai 3.14;

typedef pair<int, int> PII;
```





## 三、algorithm

### 1.sort









### 2.lower_bound & upper_bound

lower_bound( )和upper_bound( )都是利用二分查找的方法在一个排好序的数组中进行查找的。也可以用于vector

**在从小到大的排序数组中，**

lower_bound( begin,end,num)：从数组的begin位置到end-1位置二分查找第一个**大于或等于**num的数字，找到返回该数字的地址，不存在则返回end。通过返回的地址减去起始地址begin,得到找到数字在数组中的下标。

upper_bound( begin,end,num)：从数组的begin位置到end-1位置二分查找第一个**大于**num的数字，找到返回该数字的地址，不存在则返回end。通过返回的地址减去起始地址begin,得到找到数字在数组中的下标。

**~~在从大到小的排序数组中，重载lower_bound()和upper_bound()~~**

~~lower_bound( begin,end,num,greater<type>() ):从数组的begin位置到end-1位置二分查找第一个**小于或等于**num的数字，找到返回该数字的地址，不存在则返回end。通过返回的地址减去起始地址begin,得到找到数字在数组中的下标。~~

~~upper_bound( begin,end,num,greater<type>() ):从数组的begin位置到end-1位置二分查找第一个**小于**num的数字，找到返回该数字的地址，不存在则返回end。通过返回的地址减去起始地址begin,得到找到数字在数组中的下标。~~

[参考](https://blog.csdn.net/qq_40160605/article/details/80150252)

```C++
#include<bits/stdc++.h>
using namespace std;
const int maxn=100000+10;
const int INF=2*int(1e9)+10;
#define LL long long
int cmd(int a,int b){
	return a>b;
}
int main(){
	int num[6]={1,2,4,7,15,34}; 
	sort(num,num+6);                           //按从小到大排序 
	int pos1=lower_bound(num,num+6,7)-num;    //返回数组中第一个大于或等于被查数的值 
	int pos2=upper_bound(num,num+6,7)-num;    //返回数组中第一个大于被查数的值
	cout<<pos1<<" "<<num[pos1]<<endl;
	cout<<pos2<<" "<<num[pos2]<<endl;
    //不常用
	sort(num,num+6,cmd);                      //按从大到小排序
	int pos3=lower_bound(num,num+6,7,greater<int>())-num;  //返回数组中第一个小于或等于被查数的值 
	int pos4=upper_bound(num,num+6,7,greater<int>())-num;  //返回数组中第一个小于被查数的值 
	cout<<pos3<<" "<<num[pos3]<<endl;
	cout<<pos4<<" "<<num[pos4]<<endl;
	return 0;	
} 
```









### 3.next_permutation

**next_permutation 将 [first，last) 范围内的元素重新 排列为下⼀个按字典顺序排列的更大排列**，如果可以找到下⼀个排序则返回 true，如果找不到了的话返 回 false 并将序列调整为字典序最的序



prev_permutation 与 next_permutation 类似，唯⼀的不同 时 prev 每次将范围内的元素重新排列为下⼀个按字典顺序排 列的更⼩排



### 4.unique

返回值是去重之后的不重数组的下一个位置的指针

 ==一般使用前需要对容器进行排序==

```C++
#include<bits/stdc++.h>
using namespace std;
int main(){
    int a[] = {1,1,2,2,3,3,4,4,5,5};//共10个数
    int *pos = unique(a,a+10);
    cout<<pos - a<<" <-下标     值->   "<<*pos<<endl;//5 <-下标     值->   3
    for(int i=0;i<10;i++){
        cout<<a[i]<<" ";
    }
    return 0;
}//1 2 3 4 5 3<-pos指向 4 4 5 5
```



**另：如果要对结构体进行这一操作，需要重载运算符"=="**







### 5.fill & memset

```C++
//memset
char str[50];
 
   strcpy(str,"This is string.h library function");
   puts(str);
 
   memset(str,'$',7);
```





```C++
//fill
int v[10];
fill(v,v+10,-1);

int v[10][10];
fill(v[0],v[0]+10*10,-1);

int a[3][4];
fill(a[0],a[0]+3*4,7);//起点+size 就是最后一个元素的下一个位置

vector<int> v{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
fill(v.begin(), v.end(), -1);

char a[10][10];
const char c='.';
fill(a[0],a[0]+10*10,c);
```





## 四、加速

1、

```C++ 
ios::sync_with_stdio(false);
```





2、

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210423200345674.png" alt="image-20210423200345674" style="zoom:50%;" />

如果一个vector使用默认的capacity，那么在push_back操作的时候，会根据添加元素的数量，动态的自动分配空间，2^n递增；如果声明vector的时候，显式的使用capacity(size_type n)来指定vector的容量，那么在push_back的过程中（元素数量不超过n），vector不会自动分配空间。
————————————————
版权声明：本文为CSDN博主「emmmzhang」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/hl_zzl/article/details/84944494

---

## 五、Class

https://www.runoob.com/cplusplus/cpp-class-access-modifiers.html

### 1、

public:

protected:

private: 不写，默认



### 2、继承总结：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210711195636763.png" alt="image-20210711195636763" style="zoom:50%;" />

- 默认private

- private 成员只能被本类成员（类内）和友元访问，不能被派生类访问；**在子类中均不可访问**
- **派生类可以访问基类中所有的非私有成员**。因此基类成员如果不想被派生类的成员函数访问，则应在基类中声明为 private。

---

# C++以前总结

## 一、sort中cmp的写法





### 1、sort默认由小到大排序

```c++
return a<b;
```

这样理解： a>b则降序 a<b则升序         也就是**<u>a和b是什么关系，排序后的数组中任意两个元素就是什么关系</u>**
 也即a和b怎么排列是true，排序后的数组中任意两个元素就是怎么排列

### 2、sort由大到小排序

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

### 3、结构体排序

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



### 4、总结

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

## 二、运算符重载写法











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




## 三、模板的写法

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200320115040988.png" alt="image-20200320115040988" style="zoom:67%;" />

更多请自己查阅



## 四、构造函数

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



## 五、运算符优先级

分为优先级15级：

1、圆括号【（）】、下标运算符【[]】、分量运算符的指向结构体成员运算符【->】、结构体成员运算符【.】；

2、逻辑非运算符【!】、按位取反运算符【~】、自增自减运算符【++】【 --】、负号运算符【-】、类型转换运算符【(类型)】、指针运算符和取地址运算符【*】【&】、长度运算符【sizeof】；

3、乘法运算符【*】、除法运算符【/】、取余运算符【%】；

4、加法运算符【+】、减法运算符【-】；

5、左移动运算符【<<】、右移动运算符【>>】；

6、关系运算符【< 】【>】【<=】【 >= 】；

7、等于运算符【==】、不等于运算符【!=】；

8、按位与运算符【&】；

9、按位异或运算符【^】；

10、按位或运算符【|】；

11、逻辑与运算符【&&】；

12、逻辑或运算符【||】；

**13、条件运算符【?:】；**

14**、赋值运算符【=】【/=】【*=】【%=】【+=】【-=】【<<=】【>>=】【&=】【^=】【|=】；**

15、逗号运算符【,】。

==注意：**赋值运算符**优先级很低， **条件运算符**也很低，**位运算**也是==，注意加括号





## 六、Class 与 Struct

[参考](https://blog.csdn.net/weixin_39640298/article/details/84349171)



首先我们看一下**在C中**的结构体            （没啥用，我都不用C，而用C++）

1. 结构体就是不同类型数据的集合，并不涉及算法和操作。
2. 没有函数
3. 使用时加上Struct







我们重点看**在C++中**的Struct 和 Class

1、struct默认防控属性是public的，而class默认的防控属性是private的，例如：

```C++
//在C++中
struct A
{
	int iNum;
}
class B
{
	int iNum;
}
A a;
a.iNum = 2;		//没有问题，默认防控属性为public
B b;
b.iNum = 2;		//编译出错，默认防控属性为private
```

2、继承关系中默认防控属性的区别

在继承关系，struct默认是public的，而class是private

```C++
struct A
{
	int   iAnum；
}
struct B : A
{
	int   iBnum;
}

A a；
a.iAnum = 1;	//在struct情况下是正确的，在class情况下是错误的

```



3、{}赋初值

```C++
struct A
{
	char 	c1；
	int		i2;
	double	db3;
};

A a = {'p', 7, 451.154}; //定义时赋初值，在struct时没问题，在class时出错  
```

在struct中加入一个构造函数（或虚函数），你会发现struct也不能用{}赋值了



**个人建议：当你觉得你要做的更像是一种数据结构集合的话，那么用struct。如果你要做的更像是一种对象的话，那么用class**。







# 笔记

## 一、数组

```C++
//初始化
double balance[10];

double balance[5] = {1000.0, 2.0, 3.4, 7.0, 50.0};
char a1[] = {'C', '+', '+'};          // 初始化，没有 null，这是错误的
char a2[] = {'C', '+', '+', '\0'};    // 初始化，明确有 null
char a3[] = "C++";                    // null 终止符自动添加
const char a4[6] = "runoob";          // 报错，没有 null 的位置
```



## 二、关于Const

```C++
const char * p
char * const p
```

1. p 是一个指向**常量字符**的指针，不变的是 char 的值，即该<u>字符的值在定义时初始化后就不能再改变</u>。
2. p 是一个指向字符的**常量指针**，不变的是 p 的值，即该<u>指针不能再指向别的</u>

Bjarne 在他的《The C++ Programming Language》里面给出过一个助记的方法——“以 ***** 分界，把一个声明**从右向左**读”。
注意语法，* 读作 pointer to (指向...的指针)，const (常量) 是形容词，char (变量类型) 和 p (变量名) 当然都是名词。 

1) const char * p 读作：p is a pointer to a const char，译：p 是一个指针(变量)，它指向一个常量字符(const char)。
2) char * const p 读作：p is a const pointer to a char，译：p 是一个常量指针(const p)，它指向一个字符(变量)。

从两处蓝色标记也能看出前面提到的“const 修饰离开最近的对象”的说法。

另外请再注意下面的情况。
先看 const int a 和 int const a，这里没有分界符 *，虽然 const 的位置不同，但意思不变，它 const 修饰的是 int，常量整数。
再看 const char * p 和 char const * p，首先以 * 分界，虽然 const 的位置改变了，但它都是在修饰 char，常量字符。

[以上参考](https://blog.csdn.net/wangbenqiang/article/details/67635038)

例子：

```C++
#include<iostream>
using namespace std;
int main(){
    int a1=3;   ///non-const data
    const int a2=a1;    ///const data
 
    int * a3 = &a1;   ///non-const data,non-const pointer
    const int * a4 = &a1;   ///const data,non-const pointer
    int * const a5 = &a1;   ///non-const data,const pointer
    int const * const a6 = &a1;   ///const data,const pointer
    const int * const a7 = &a1;   ///const data,const pointer
 
    return 0;
}
```

[又一个例子](https://blog.csdn.net/baidu_35679960/article/details/83504018)







**const修饰函数参数**

传递过来的参数在函数内不可以改变，与上面修饰变量时的性质一样。



**const修饰成员函数**

(1)const修饰的成员函数不能修改任何的成员变量(**mutable修饰的变量除外**)

(2)const成员函数不能调用非onst成员函数，因为非const成员函数可以会修改成员变量

[参考](https://www.cnblogs.com/anhuixuyin218/articles/6550542.html)





## 三、Lambda

[参考](https://blog.csdn.net/feikudai8460/article/details/109624363?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link)

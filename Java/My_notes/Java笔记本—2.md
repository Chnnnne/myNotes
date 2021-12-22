# JAVA笔记本—2

Author: WangChen :smiley:

[菜鸟教程](https://www.runoob.com/java/java-stringbuffer.html)这里讲得很好

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210117144213014.png" alt="image-20210117144213014" style="zoom: 50%;" />

栈底，栈顶←

←队头 队尾←



/      除号 、网址、注释
\       文件路径  、转义字符

## 一、数据结构容器





### 1.String

**介绍：**



1、构造方法

```java
public String() 
public String(char[] cs)
public String(byte[] bs)
//byte bytes[]={97,98,99};
//String str=new String(bytes) 会新建一个 "abc"
```

2、常用方法

**比较**

```java
public boolean euqals(Object obj)
public boolean equalsIgnoreCase(String obj)

public int compareTo(String str)//两字符串完全相同返回0; 当前字符串小于参数字符串返回负数;大于返回正数
public int compareToignoreCases(String str)
    
//而用==号 对于引用数据类型判断的是两侧是否指向同一个对象!!!
```

**基本功能**

```java
//获取长度
public int length() 
//将参数字符串连接到本字符串的末尾
public String concat(String str)
//获取某一个char
public char charAt(int index) //注意不能像C++那样 数组下标访问  注意是从0开始
//找参数字符串第一次出现的位置
public int indexOf(String str)//可把参数类型String 改成int 查找某个字符 ,而且可以lastIndexOf 找最大的下标，也即从后往前找
public int indexOf(String str,int fromIndex)

//截取得到子串
public String substring(int beginIndex)//从beginIndex到结尾
public String substring(int beginIndex,int endIndex)//注意是[beginIndex,endIndex)!!!!!
//判空
public boolean isEmpty()
```

**转化（String -> others）**

```java
//将此字符串转换为新的字符数组
public char[] toCharArray ()   //String->CharArray->String  这个应该很有用！！！
//使用平台的默认字符集将该 String编码转换为新的字节数组
public byte[] getBytes ()
    
还可以用各个包装类的静态方法
如：Boolean.parseBoolean(String str)  
    Integer.parseInt(String str) 
    经过一些实验对于任何非"true"字符串，parseBoolean总是false，
    对于非数字字符串，parseInteger会报错
```

**转化（others->String）**

```java
1、	数组 加 构造方法
2、	一般方法是 直接+""就行了
3、	还可以调用String的静态方法 valueof()
 				String str=String.valueOf(100)
```

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200614104426822.png" alt="image-20200614104426822" style="zoom:50%;" />

**替换**

```java
//替换
public String replace (CharSequence target, CharSequence replacement) 
//例子：
String str = "itcast itheima";     
String replace = str.replace("it", "IT");
System.out.println(replace); // ITcast ITheima 
```

**拆分**

```java
//将此字符串按照给定的regex（规则）拆分为字符串数组
public String[] split(String regex)

```

关于split 的转义字符 以下参考 [CSDN](https://blog.csdn.net/Rex_WUST/article/details/100178494?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase) 

在Java中，不管是String.split()，还是正则表达式，有一些特殊字符需要转义，
这些字符是
**(   [   {   /   ^   -   $   ¦   }   ]   )   ?       |  \*   +   .** 
转义方法为字符前面加上"\\"，这样在split、replaceAll时就不会报错了；
不过要注意，String.contains()方法不需要转义。

```java
所以正常的写法是这样的：
1、如果用“.”作为分隔的话，必须是如下写法：String.split("\\."),这样才能正确的分隔开，不能用String.split(".");
2、如果用“|”作为分隔的话，必须是如下写法：String.split("\\|"),这样才能正确的分隔开，不能用String.split("|");
“.”和“|”都是转义字符，必须得加"\\";
3、如果在一个字符串中有多个分隔符，可以用“|”作为连字符，比如：“a=1 and b =2 or c=3”,把三个都分隔出来，可以用String.split("and|or");
split分隔符总结
1.字符"|","*","+"都得加上转义字符，前面加上"\\"。
2.而如果是"\"，那么就得写成"\\\\"。
3.如果一个字符串中有多个分隔符，可以用"|"作为连字符。
```



**大小写**

```java
public String toLowerCase()
public String toUpperCase()
```

**去掉首尾空白符**

```java
public String trim()
```





#### **补充：字符串池** 

1. 程序当中直接写上的双引号字符串，就在字符串常量池中
2.  用+ 得到的

new出来的不在





### 2.StringBuilder与StringBuffer

[菜鸟教程参考](https://www.runoob.com/java/java-stringbuffer.html)

当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。

和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。

StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。

1. 由于 **StringBuilder** 相较于 StringBuffer 有**速度**优势，所以多数情况下建议使用 StringBuilder 类。

2. 然而在应用程序要求**线程安全**的情况下，则必须使用 **StringBuffer** 类。





可变字符序列
StringBuilder是个字符串的缓冲区，即它是一个容器，容器中可以装很多字符串。并且能够对其中的字符串进 行各种操作。

构造方法：

```java
public StringBuilder()
public StringBuilder(String str)   // String -> StringBuilder
```

常用方法：

```java
public StringBuilder append(...)
```

例如：

```java
StringBuilder builder= new StringBuilder();
StringBuilder bulider2=builder.append("Hello");
builder.append(100).append(false);
builder.append(true);
```

**用toString方法把StringBuilder转化成String**             //StringBuilder -> String

```java
//在StringBuilder对象尾部添加"0000"字符串
s.append("0000");
//在StringBuilder对象的0号索引位置之前添加"1111"字符串
s.insert(0,"1111");
//修改StringBuilder对象5号索引位置的字符为'A'字符
s.setCharAt(5, 'A');
//将StringBuilder对象转换为字符串
String s3=s.toString();
```









### 2.ArrayList

**介绍：**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210117144213014.png" alt="image-20210117144213014" style="zoom:50%;" />

1、定义

```Java
ArrayList<String> list=new ArrayList<String>(); // 也可省略后一个<>里的String
```

2、成员方法

```java
//public boolean add(E e)
list.add("AAA");
arraylist.add（int index，E element）//如果 index 没有传入实际参数，元素将追加至数组的最末尾。

//public E remove(int index)  返回被删除的元素  (下标从0开始) 
list.remove(0);

//public E get(int index) 返回指定元素
list.get(int index)
 
//public int size()
list.size();
```

**注意：**

1. **ArrayList对象不能存储基本类型，只能存储引用类型的数据**。类似 < int >  不能写，但是存储基本数据类型对应的 包装类型是可以的。所以，想要存储基本类型数据， <> 中的数据类型，必须转换后包装类后才能编写
2. 可以直接sout 变量名 回输出这种形式的[AAA,BBB,CCC]      toString方法已经重写
3. **不必重写equals方法和hashcode**，因为可以重复



---

### 3.集合

心得：当容器元素唯一、不重复时，需要重写 存储元素类的equals方法和hashcode方法,当有序时要定义排序规则



> - **TreeSet 是有序（自排序）的去重集合，TreeMap 是 key 有序（自排序）的哈希表，它们也是基于红黑树实现的。**  需要重写euqals、 hashcode    、 comparable 或comparator   
> -  **PriorityQueue是有序（自排序）的队列 ，优先队列**
>
> 理解：这些按照指定规则排序的容器有很多，可以重复的就是优先队列，不可重复的就是TreeSet 。键值对的就是TreeMap



#### 1、单列集合java.util.Collection

Collection：单列集合类的根接口，用于存储一系列符合某种规则的元素，它有两个重要的子接口，分别是 java.util.List 和 java.util.Set 。
其中，
 List 的特点是元素有序、元素可重复。 
Set 的特点是元素无 序，而且不可重复。
 List 接口的主要实现类有 java.util.ArrayList 和 java.util.LinkedList ， 
Set 接口 的主要实现类有 java.util.HashSet 和 java.util.TreeSet 。

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200614111048037.png" alt="image-20200614111048037" style="zoom:60%;" />

下面方法可 用于操作所有的单列集合。方法如下：

```java
public boolean add(E e) ：  把给定的对象添加到当前集合中 
public void clear() :清空集合中所有的元素
public boolean remove(E e) : 把给定的对象在当前集合中删除
public boolean contains(E e) : 判断当前集合中是否包含给定的对象
public boolean isEmpty() : 判断当前集合是否为空
public int size() : 返回集合中元素的个数
public Object[] toArray() : 把集合中的元素，存储到数组中。
    //Collection -> Array 调用toArray
    //Array -> Collection 只能遍历
```

---

##### 1.1 List接口

**List接口特点：**

1. 它是一个元素存取有序的集合。例如，存元素的顺序是11、22、33。那么集合中，元素的存储就是按照11、 22、33的顺序完成的）。
2. 它是一个带有索引的集合，通过索引就可以精确的操作集合中的元素（与数组的索引是一个道理）。
3. 集合中可以有重复的元素，通过元素的equals方法，来比较是否为重复的元素

> 1. ArrayList是最常用的List实现类，内部是通过数组实现的，它允许对元素进行快速随机访问。数组的缺点是每个元素之间不能有间隔，当数组大小不满足时需要增加存储能力，就要将已经有数组的数据复制到新的存储空间中。当从ArrayList的中间位置插入或者删除元素时，需要对数组进行复制、移动、代价比较高。因此，**<u>它适合随机查找和遍历，不适合插入和删除</u>。**
> 2. Vector与ArrayList一样，也是通过数组实现的，不同的是**<u>它支持线程的同步</u>**，即某一时刻只有一个线程能够写Vector，避免多线程同时写而引起的不一致性，但实现同步需要很高的花费，因此，<u>访问它比访问ArrayList慢</u>。
> 3. LinkedList是用链表结构存储数据的，<u>**很适合数据的动态插入和删除，随机访问和遍历速度比较慢**</u>。另外，他还提供了List接口中没有定义的方法，<u>专门用于操作表头和表尾元素，可以当作**堆栈、队列和双向队列使用**。</u>

**公有方法：**

```java
public E get(int index) :返回集合中指定位置的元素。 
public E set(int index, E element) :用指定元素替换集合中指定位置的元素,返回值的更新前的元素。 
```

---

###### 1.1.1ArraryList

不多说了，在前边

###### 1.1.2LInkedList

LinkedList集合也可以作为堆栈，

特有方法：

```java
public void addFirst(E e) :将指定元素插入此列表的开头。
public void addLast(E e) :将指定元素添加到此列表的结尾。 
public E removeFirst() :移除并返回此列表的第一个元素。 
public E removeLast() :移除并返回此列表的后一个元素。 
public E getFirst() :返回此列表的第一个元素。 
public E getLast() :返回此列表的后一个元素。 
    
public E pop() :从此列表所表示的堆栈处弹出一个元素。
public void push(E e) :将元素推入此列表所表示的堆栈。 
    peek
    
public boolean isEmpty() ：如果列表不包含元素，则返回true
poll/offer/
```

---







##### 1.2Set接口

###### 1.2.1HashSet

它所存储的元素是**不可重复的，并且元素都是无序的**

**给HashSet中存放自定义类型元素时，==需要重写对象中的hashCode和equals方法==**，建立自己的比较方式，才能保证HashSet集合中的对象唯一 

###### 1.2.2LinedHashset

 元素不可重复，但是有序,也即**插入顺序**

###### 1.2.3 TreeSet

**自排序**，类要重写HashCode Equals 防止重复，类重写Comparable   或者构造函数指定comparator

###### 1.2.4集合的交并补

[参考](https://blog.csdn.net/qq_25806863/article/details/70312046?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control)

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210215170114213.png" alt="image-20210215170114213" style="zoom:50%;" />



```java
Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");

        set2.add("c");
        set2.add("d");
        set2.add("e");

        //交集
        set1.retainAll(set2);

        System.out.println("交集是 "+set1);
```



##### 1.3Queue

<img src="https://images2017.cnblogs.com/blog/1182892/201711/1182892-20171122100317930-842768608.png" alt="img" style="zoom: 67%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210306085946119.png" alt="image-20210306085946119" style="zoom: 33%;" />

Queue接口的一些方法

```java
//尾部进队
boolean add(E e);   //@throws IllegalStateException if the element cannot be added at thistime due to capacity restrictions
boolean offer(E e);//@return {@code true} if the element was added to this queue, else{@code false}


//头部出队
E remove();// @return the head of this queue 
//@throws NoSuchElementException if this queue is empty
E poll();//@return the head of this queue, or {@code null} if this queue is empty


//查看队头元素
E element();//@return the head of this queue  @throws NoSuchElementException if this queue is empty
E peek();//@return the head of this queue, or {@code null} if this queue is empty
```

offer、poll、peek面对满队、空队、空队的情况下不会抛出异常。

| 基础版  | 增强版    | 满队       | 空队     |
| ------- | --------- | ---------- | -------- |
| add     | **offer** | 返回 false |          |
| remove  | **poll**  |            | 返回null |
| element | **peek**  |            | 返回null |

> **offer，add 区别：**
> 一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
> 这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。
>
> **poll，remove 区别：**
> remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
>
> **peek，element区别：**
> element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。



目前看来java提供了很多实现了阻塞接口的Queue，还有一些没实现的

>  ==就我而言==
>
>  1. **想要用一般队列和栈就用LinkedList  方法分别是push pop peek   和  offer poll peek  **
>  2. **优先队列就用PriorityQueue，**注意要实现Comparable接口并重写对象里的CompareTo，或者再new的时候指定Comparator
>  3. **栈Stack代码写的不好，因此不用Stack**   

[更多请参考](https://blog.csdn.net/weixin_30443895/article/details/97976432?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control)

**优先队列**

实现方式1 ：继承comparable  

```java
package lanqiao.practice;
class Studentt implements Comparable<Studentt>{
	private int id;
	private String name;
	@Override
	public int compareTo(Studentt o) {//id降序   前者减后者就是升序     后者减前者就是降序
		return o.id-this.id;
	}
}

public class demo02_queue {
	public static void main(String[] args) {
		PriorityQueue<Studentt> pq = new PriorityQueue<Studentt> ();
		Studentt s2 = new Studentt(2, "lisi");
		Studentt s1 = new Studentt(1, "wangchen");
		Studentt s4 = new Studentt(4, "xiaohong");
		Studentt s3 = new Studentt(3, "zhangsan");
		pq.offer(s1);
		pq.offer(s2);
		pq.offer(s3);
		pq.offer(s4);//无论怎样更改入队顺序，最终结果不变
		System.out.println(pq.size());
		while(pq.peek()!=null) {
			System.out.println(pq.poll());
		}
	}//main
}
Studentt [id=4, name=xiaohong]
Studentt [id=3, name=zhangsan]
Studentt [id=2, name=lisi]
Studentt [id=1, name=wangchen]
```



实验方式二： 创建

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210411095506865.png" alt="image-20210411095506865" style="zoom: 50%;" />

```java
PriorityQueue<distance> heap = new PriorityQueue<distance>((o1,o2)->o1.dis-o2.dis);
```











#### 2、双列集合java.util.Map 

key键 -value值

Map有多个子类，这里我们主要讲解常用的HashMap集合、LinkedHashMap集合。

* **HashMap<K,V>**：存储数据采用的哈希表结构，元素的存取顺序不能保证一致。由于要保证键的唯一、不重复，==需要重写键KEY的hashCode()方法、equals()方法。==
* **LinkedHashMap<K,V>**：HashMap下有个子类LinkedHashMap，存储数据采用的哈希表结构+链表结构。通过链表结构==可以保证元素的存取顺序一致==；通过哈希表结构可以保证的键的唯一、不重复，==需要重写键的hashCode()方法、equals()方法。==
* **TreeMap<K,V>**: 按照Key排序

> LinkedHashMap 保存了记录的插入顺序，在用 Iterator 遍历时，先取到的记录肯定是先插入的；遍历比 HashMap 慢；
>
> TreeMap 实现 SortMap 接口，能够把它保存的记录根据键排序（默认按键值升序排序，也可以指定排序的比较器）实现排序方法
>
> 一般情况下，使用最多的是 HashMap。
> HashMap：在 Map 中插入、删除和定位元素时；
> TreeMap：在需要按自然顺序或自定义顺序遍历键的情况下；
>  LinkedHashMap：在需要输出的顺序和输入的顺序相同的情况下。

Map接口中定义了很多**方法**，常用的如下：

* `public V put(K key, V value)`:  把指定的键与指定的值添加到Map集合中。

* `public V remove(Object key)`: 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。

* `public V get(Object key)` 根据指定的键，在Map集合中获取对应的值。

* `getOrDefault(Object key, V defaultValue)`
   map中有该key就返回key对应的value，没有该key,就返回defaultValue

  ```java
  比如：在统计单词出现的次数时，可以这样
  map.put( str[i] , map.getOrDefault(str[i],0) + 1 );//单词出现过就 直接获得value+1，没出现则是0+1
  ```

* `boolean containsKey(Object key)  ` 判断集合中是否包含指定的键。

* `public Set<K> keySet()`: 获取Map集合中所有的键，存储到Set集合中。

* `public Set<Map.Entry<K,V>> entrySet()`: 获取到Map集合中所有的键值对对象的集合(Set集合)。

* `public Set<V> values()`获取值集合

> tips:
>
> 使用put方法时
>
> 1. 若指定的键(key)在集合中没有，则没有这个键对应的值，返回null，并把指定的键值添加到集合中； 
> 2. 若指定的键(key)在集合中存在，则返回值为集合中键对应的值（该值为替换前的值），并把指定键所对应的值，替换成指定的新值。 



**Map集合遍历键找值方式**

代码演示：

~~~java
public class MapDemo01 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("胡歌", "霍建华");
        map.put("郭德纲", "于谦");
        map.put("薛之谦", "大张伟");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            System.out.println(key+"的CP是："+value);
        }  
    }
}
~~~

**Map集合遍历键值对方式**

~~~java
public class MapDemo02 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("胡歌", "霍建华");
        map.put("郭德纲", "于谦");
        map.put("薛之谦", "大张伟");

        // 获取 所有的 entry对象  entrySet
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();  
            System.out.println(key+"的CP是:"+value);
        }
    }
}
~~~





**练习：**每位学生（姓名，年龄）都有自己的家庭住址。那么，既然有对应关系，则将学生对象和家庭住址存储到map集合中。学生作为键, 家庭住址作为值。

> 注意，学生姓名相同并且年龄相同视为同一名学生。

编写学生类：

~~~java
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
~~~

编写测试类：

~~~java 
public class HashMapTest {
    public static void main(String[] args) {
        //1,创建Hashmap集合对象。
        Map<Student,String>map = new HashMap<Student,String>();
        //2,添加元素。
        map.put(newStudent("lisi",28), "上海");
        map.put(newStudent("wangwu",22), "北京");
        map.put(newStudent("zhaoliu",24), "成都");
        map.put(newStudent("zhouqi",25), "广州");
        map.put(newStudent("wangwu",22), "南京");
        
        //3,取出元素。键找值方式
        Set<Student>keySet = map.keySet();
        for(Student key: keySet){
            Stringvalue = map.get(key);
            System.out.println(key.toString()+"....."+value);
        }
    }
}
~~~

==注意！！==

* **当给HashMap中存放自定义对象时，如果自定义对象作为key存在，这时要保证对象唯一，必须复写对象的hashCode和equals方法(如果忘记，请回顾HashSet存放自定义对象)。**
* **如果要保证map中存放的key和取出的顺序一致，可以使用`java.util.LinkedHashMap`集合来存放。**







**LinkedHashMap例子**

我们知道HashMap保证成对元素唯一，并且查询速度很快，可是成对元素存放进去是没有顺序的，那么我们要保证有序，还要速度快怎么办呢？

在HashMap下面有一个子类LinkedHashMap，它是链表和哈希表组合的一个数据存储结构。

```java
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("邓超", "孙俪");
        map.put("李晨", "范冰冰");
        map.put("刘德华", "朱丽倩");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}
邓超  孙俪
李晨  范冰冰
刘德华  朱丽倩
```







又一个例子：

**需求：**

计算一个字符串中每个字符出现次数。

**分析：**

1.  获取一个字符串对象
2.  创建一个Map集合，键代表字符，值代表次数。
3.  遍历字符串得到每个字符。
4.  判断Map中是否有该键。
5.  如果没有，第一次出现，存储次数为1；如果有，则说明已经出现过，获取到对应的值进行++，再次存储。     
6.  打印最终结果

**代码：**

~~~java
public class MapTest {
public static void main(String[] args) {
        //友情提示
        System.out.println("请录入一个字符串:");
        String line = new Scanner(System.in).nextLine();
        // 定义 每个字符出现次数的方法
        findChar(line);
    }
    private static void findChar(String line) {
        //1:创建一个集合 存储  字符 以及其出现的次数
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //2:遍历字符串
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            //判断 该字符 是否在键集中
            if (!map.containsKey(c)) {//说明这个字符没有出现过
                //那就是第一次
                map.put(c, 1);
            } else {
                //先获取之前的次数
                Integer count = map.get(c);
                //count++;
                //再次存入  更新
                map.put(c, ++count);
            }
        }
        System.out.println(map);
    }
}
~~~










​		 [对key 和 value排序](https://blog.csdn.net/xHibiki/article/details/82938480?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control)，一般不这样，直接用pair class了

```java
	HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
	hashMap.put("wangchen",98);
	hashMap.put( "xia",96);
	hashMap.put( "ta",85);
	hashMap.put( "hu",77);
	Set<String> keySet = hashMap.keySet();
	for (String string : keySet) {
		System.out.println(string + " : " + hashMap.get(string));
	}	
	//对key定义排序规则,也即按照名字的首字母排序
	//map.keyset-> array或者ArrayList 再排序
	System.out.println("\n名字升序：");
	Object[] array = keySet.toArray();
	Arrays.sort(array);
	for (Object object : array) {
		System.out.println(object + " : " + hashMap.get(object));
	}
	
	//对value定义排序规则,也即按照成绩高低升序
	System.out.println("\n成绩升序");
	Set<Entry<String,Integer>> entrySet = hashMap.entrySet();
	ArrayList<Entry<String, Integer>> al = new ArrayList<>(entrySet);
	Collections.sort(al,(o1,o2)->o1.getValue()-o2.getValue());
	for (Entry<String, Integer> entry : al) {
		System.out.println(entry.getKey()+" : "+entry.getValue());
	}
```
###          4.问题

```java
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		al.add(1);
		al.add(2);
		al.add(3);
		arrayList.add(al);
		System.out.println(arrayList);
		al.clear();
		System.out.println(arrayList);
//add 之后操作al仍对arrayList有效
引用指向！！！！！
```



## 二、一些常用API

---

### Arrays类

**介绍**：用来操作**数组**的各种方法，比如排序和搜索等。其所有方法均为静态方法，调用起来 非常简单。 

==注意Arrays对数组，Collections对集合==

一、

`public static String toString(int[] a) `

返回指定数组内容的字符串表示形式

```java
int[] arr  =  {2,34,35,4,657,8,69,9};   // 打印数组,输出地址值  
System.out.println(arr); // [I@2ac1fdc4     
String s = Arrays.toString(arr);      
System.out.println(s); // [2, 34, 35, 4, 657, 8, 69, 9] 
```



二、

`public static void sort(int[] a) `

对指定的 int 型数组按数字升序进行排序

```java
int[] arr  =  {24, 7, 5, 48, 4, 46, 35, 11, 6, 2};   
System.out.println("排序前:"+ Arrays.toString(arr)); 
// 排序前:[24, 7, 5, 48, 4, 46, 35, 11, 6,  2]   
// 升序排序   
Arrays.sort(arr);   
System.out.println("排序后:"+ Arrays.toString(arr));
// 排序后:[2, 4, 5, 6, 7, 11, 24, 35, 46,  48] 
```

---

>  ==注意==
>
>  想要使用lambda对其排序的话，不能是基本类型 int double 而是Integer Double这些，而如果只使用默认排序的话，可以是int double
>
>  Arrays.sort(arr, (o1,o2)->{return o2-o1;});//注意只能是 包装类数组！！！
>
>  ==超级大陷阱： 注意sort函数中的参数 fromindex 是inclusive 。toindex是exclusive ，也即 是不包含的！==



此外，对于类中double属性排序， 可以这样：

```java 
Arrays.sort(arr,1,N+1,(o1,o2)->(int)Math.signum(o2.pp-o1.pp));
```





对二维数组排序

原理解释：二维数组可以看成     由一维数组作为对象组成的一维数组，也即二维数组是由一个==一维数组由数组对象组成==，那么对于==对象数组==排序，就简单了。

此外，我们可知，排序前后，一维数组对象内部的顺序是不会变的

```java
    	for (int i = 0; i < envelopes.length; i++) {
			System.out.println(Arrays.toString(envelopes[i]));
		}
    	Arrays.sort(envelopes,(o1,o2)->o1[0]-o2[0]);
    	System.out.println("排序后");
    	for (int i = 0; i < envelopes.length; i++) {
			System.out.println(Arrays.toString(envelopes[i]));
		}
```





### Collections类

`java.utils.Collections`是集合工具类，用来对**集合** （List）进行操作。部分方法如下：

```java
public static <T> boolean addAll(Collection<T> c, T... elements)  :往集合中添加一些元素。
public static void shuffle(List<?> list) 打乱顺序`:打乱集合顺序。
public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。  
public static <T> void sort(List<T> list，Comparator<? super T> ):将集合中元素按照指定规则排序。
```

```java
Collections.addAll(list,1,2,3,4,5,100,300,100000);
```



直接使用第一个sort函数排序的 ，需要容器中的元素类实现了==Comparable==接口（Integer和String已经实现过了）

==忽略我以前的关于cmp、compare函数的所有分析，而看现在的：根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数==

简便思想：**==前 - 后是升序==** ！！！！！

后 - 前 是降序



最新实验

```java
public class Student implements Comparable<Student>{
	private String name;
	private Integer age;

	@Override
	public int compareTo(Student o) {
		if(this.age==o.age)//先年龄升序再名字升序
			return this.name.charAt(0)-o.name.charAt(0);//名字首字母升序
		else {
			return this.age-o.age;//年龄升序
		}
	}

	public static void main(String args[]) {
		ArrayList<Student> al = new ArrayList<Student>();
		Collections.addAll(al, new Student("cchen",20),new Student("achen",20),new Student("bchen",21));
		System.out.println(al);
		
		Collections.sort(al);//默认排序
		System.out.println(al);
		
		Collections.sort(al, (o1,o2)->{return o2.age-o1.age;});//年龄降序
		System.out.println(al);
		
	}
	
}
```

```java
[Student [name=cchen, age=20], Student [name=achen, age=20], Student [name=bchen, age=21]]
[Student [name=achen, age=20], Student [name=cchen, age=20], Student [name=bchen, age=21]]
[Student [name=bchen, age=21], Student [name=achen, age=20], Student [name=cchen, age=20]]
```





```java
class String implements java.io.Serializable, Comparable<String> {}
```

String类实现了这个接口，并完成了比较规则的定义，但是这样就把这种规则写死了，那比如我想要字符串按照第一个字符降序排列，那么这样就要修改String的源代码，这是不可能的了，那么这个时候我们可以使用

`public static <T> void sort(List<T> list，Comparator<? super T> )`方法灵活的完成，这个里面就涉及到了==**Comparator**==这个接口，位于位于java.util包下，排序是comparator能实现的功能之一

参数Comparator<? super T> 告诉我们 要想使用Collections.sort()，可以采取三种方法：
1.实现接口的类，然后创建对象 
2.匿名内部类 
3.Lambda

1.匿名内部类

```java
public class CollectionsDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("cba");
        list.add("aba");
        list.add("sba");
        list.add("nba");
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0) - o1.charAt(0);
            }
        });
        System.out.println(list);
    }
}
```

又比如

```java
class cmp implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;//降序 为什么
    }
}

public class Compareator_test {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>();
        Collections.addAll(al,1,10,2,9,3,8);
        System.out.println(al);
        
        Collections.sort(al);//默认  升序
        System.out.println(al);
        
        Collections.sort(al, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });//匿名内部类   降序
        System.out.println(al);
        
        System.out.println("-------------------");
        Collections.shuffle(al);
        Collections.shuffle(al);
        System.out.println(al);
        
        Collections.sort(al,new cmp());
        System.out.println(al);
    }
}
//结果：
[1, 10, 2, 9, 3, 8]
[1, 2, 3, 8, 9, 10]
[10, 9, 8, 3, 2, 1]
-------------------
[3, 9, 2, 10, 8, 1]
[10, 9, 8, 3, 2, 1]
```







### Math类

**介绍：**其所有方法均为**静态方法**，并且不会创建对象，调用起来非常简单。 

```java
常量：Math.E             Math.PI

double abs(double a) ：返回 double 值的绝对值。 
    
double ceil(double a) ：//返回大于等于( >= )给定参数的的最小整数//坐标轴右侧
double floor(double a) ：//返回小于等于（<=）给定参数的最大整数 。//坐标轴左侧
long round(double a) ：//返回接近参数的 long。(相当于四舍五入方法) 
double rint(double d)//返回最接近参数的整数值,若存在两个这样的数，则返回其中的偶数值
Math.rint(101.500)=102.0;

double min(double arg1, double arg2)//参数和返回值类型可以是int float long等
    
double exp(double d)//返回自然数底数e的参数次方   return e^d

double log(double d)//返回参数的以自然数底数的对数值  return ln(d)
double log10(double a)
    
double pow(double base, double exponent)//返回第一个参数的第二个参数次方
//注意开一个数的n次方根  ，用pow(base,分数)的形式
    
double sqrt(double d)//返回参数的算术平方根
double cbrt(double d)//计算立方根
    
//nextUp(a) 返回比a大一点点的浮点数
System.out.println(Math.nextUp(1.2));//输出1.2000000000000002
//nextDown(a) 返回比a小一点点的浮点数
System.out.println(Math.nextDown(1.2));//输出1.1999999999999997  
```





**也即：角度没啥用，就是单纯为了展示一下，弧度才是参与运算得到弦值(比值)的。**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210211163316212.png" alt="image-20210211163316212" style="zoom:67%;" />





<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210122125028008.png" alt="image-20210122125028008" style="zoom:40%;" />

```java
//角度180° = 弧度 π
double sin(double θ)//参数是弧度，返回值是正弦值
double cos(double θ)
double tan(double θ)
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);
        System.out.format("%.1f 度的正弦值为 %.4f%n", degrees, Math.sin(radians));
    
double asin(double d)//参数是弦值，返回值是弧度
double acos(double d)
double atan(double d)

double atan2(double y, double x)//由坐标(x,y)返回所得角 弧度θ，该方法通过计算 y/x 的反正切值来计算相角 theta，范围为从 -pi 到 pi。
    //也即给定(x,y)
    //return夹角的弧度
```

> 几个概念要清楚：
>
> 1. 角度degrees      
> 2. 弧度radians 
> 3. 正弦值、余弦值、正切值  （比值）
> 4. 反正弦值、反余弦值、反正切值  （也即弧度，也即正弦对应的弧度）
> 5. <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210122130538144.png" alt="image-20210122130538144" style="zoom:50%;" />

```java
double toDegrees(double d)
double toRadians(double d)
```







### Object类

object类是所有类的超类，它所具有的to string 、equals方法，其他类也一定有！，我们可以重写他们

#### 1、toString 方法

```java
 public String toString()          
```

**返回该对象的字符串表示**
默认的是返回该字符串内容就是对象的类型+@+内存地址值。但没多大用，因此我们要覆盖重写它 

直接alt+shift+s 可以选择了

```java
public class Person {       
    private String name;     
    private int age;       
    @Override     
    public String toString() {         return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';     
    }   
}
```

> 小贴士： 在我们直接使用输出语句输出对象名的时候,其实通过该对象调用了其toString()方法。



#### 2、equals方法

```java
public boolean equals(Object obj)
```

**判断参数对象是否与此对象“相等”。**

若不覆盖重写，则进行默认的 **==** 运算符的对象地址比较，**只要不是同一个对象，结果 必然为false。** 

> 简述String类中的equals方法与Object类中的equals方法的不同点。
>
> 答：String类中的equals方法是用来判断两个对象的内容是否相同，而Object 类中的equals方法是用来判断两个对象是否是同一个对象，所谓同一个对象指的是内存中的同一块存储空间。       **其实**，**String类的euqals已经重写了了Object的equals了**



调用成员方法equals并指定参数为另一个对象，则可以判断这两个对象是否是相同的。这里的“相同”有默认和自定义两种方式。

> 1.默认：如果没有覆盖重写equals方法，那么Object类中默认进行`==`运算符的对象地址比较，只要不是同一个对象，结果必然为false。
>
> 2.自定义：如果希望进行对象的内容比较，即所有或指定的部分成员变量相同就判定两个对象相同，则可以覆盖重写equals方法。例如：
>
> @Override
>     public boolean equals(Object o) {
>         // 如果对象地址一样，则认为相同
>         if (this == o)
>             return true;
>         // 如果参数为空，或者类型信息不一样，则认为不同
>         if (o == null || getClass() != o.getClass())
>             return false;
>         // 转换为当前类型
>         Person person = (Person) o;
>         // 要求基本类型相等，并且将引用类型交给java.util.Objects类的equals静态方法取用结果
>         return age == person.age && Objects.equals(name, person.name);
>     }
> }
>
> **可以自动生成**

#### 3、hashcode&equals

> https://blog.csdn.net/fenglibing/article/details/8905007
>
> https://blog.csdn.net/weixin_38405253/article/details/91922340

通过前面这个例子，大概可以知道，先通过hashcode来比较，如果hashcode相等，那么就用equals方法来比较两个对象是否相等。

用个例子说明：上面说的hash表中的8个位置，就好比8个桶，每个桶里能装很多的对象，对象A通过hash函数算法得到将它放到1号桶中，当然肯定有别的对象也会放到1号桶中，如果对象B也通过算法分到了1号桶，那么它如何识别桶中其他对象是否和它一样呢，这时候就需要equals方法来进行筛选了。

1、如果两个对象equals相等，那么这两个对象的HashCode一定也相同

2、如果两个对象的HashCode相同，不代表两个对象就相同，只能说明这两个对象在散列存储结构中，存放于同一个位置









#### Objects类

在JDK7添加了一个Objects工具类，它提供了一些方法来操作对象，它由一些静态的实用方法组成，这些方法是 **null-save**（空指针安全的）或**null-tolerant**（容忍空指针的），用于计算对象的hashcode、返回对象的字符串表 示形式、比较两个对象。
在比较两个对象的时候，Object的equals方法容易抛出空指针异常，而Objects类中的equals方法就优化了这个问 题











### System类

#### 1、currentTimeMillis方法

```java
public static long currentTimeMillis()
```

**返回以毫秒为单位的当前时间。** 获取当前系统时间与1970年01月01日00:00点之间的毫秒差值



#### 2、arraycopy方法 

```java
public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
```

**将数组中指定的数据拷贝到另一个数组中。**
数组的拷贝动作是系统级的，性能很高

```java
import java.util.Arrays;   
public class Demo11SystemArrayCopy {     
    public static void main(String[] args) {         
        int[] src = new int[]{1,2,3,4,5};         
        int[] dest = new int[]{6,7,8,9,10};         
        System.arraycopy( src, 0, dest, 0, 3);         
        /*代码运行后：两个数组中的元素发生了变化          
        src数组元素[1,2,3,4,5]          
        dest数组元素[1,2,3,9,10]         */     
    } 
}
```

| 参数序号 | 参数名称 | 参数类型 | 参数含义             |
| -------- | -------- | -------- | -------------------- |
| 1        | src      | Object   | 源数组               |
| 2        | srcPos   | int      | 源数组索引起始位置   |
| 3        | dest     | Object   | 目标数组             |
| 4        | destPos  | int      | 目标数组索引起始位置 |
| 5        | length   | int      | 复制元素个数         |









### Scanner类

```java
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();		整数
Srting s =sc.next();			字符串
int num = new Scanner(System.in).nextInt();    	匿名对象
```





#### 1、next

next() 方法遇见第一个有效字符（非空格，非换行符）时，开始扫描，也即忽略无用字符，，当遇见第一个分隔符或结束符(空格或换行符)时，结束扫描，获取扫描到的内容，即获得第一个扫描到的不含空格、换行符的单个字符串，与此同时会把遇到的空格、换行符、回车符留在缓冲区中。



#### 2、nextLine

如果nextLine前有一个next，则nextLine()自动读取了被next()去掉的Enter作为他的结束符，所以nextLIne就读了个空。经过验证，我发现其他的next的方法，如double nextDouble() ， float nextFloat() ， int nextInt() 等与nextLine()连用时都存在这个问题，解决的办法是：在每一个 next()、nextDouble() 、 nextFloat()、nextInt() 等语句之后**加一个nextLine()语句，将被next()去掉的Enter结束符过滤掉**。





#### 3、hasNext

[参考](https://blog.csdn.net/gao_zhennan/article/details/80562548)

使用无参的hasNext（），当执行到hasNext（）时，它会先扫描缓冲区中是否有字符，有则返回true，继续扫描。直到扫描为空，这时并不返回false,而是将方法阻塞，等待你输入内容然后继续扫描。这样的话，它就像吃了炫迈口香糖根本停不下来。



当使用带有参数的hasNext重载方法，当扫描到的字符与参数值匹配时返回true

```java
import java.util.*;
public class ScannerKeyBoardTest
{
    public static void main(String[] args)
    {
        System.out.println("请输入若干单词，以空格作为分隔");
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNext("#"))  //匹配#返回true,然后取非运算。即以#为结束符号
        {
            System.out.println("键盘输入的内容是："

                + sc.next());
        }
        System.out.println("会执行的");
    }
}
```

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210215162833387.png" alt="image-20210215162833387" style="zoom:50%;" />



#### 4输入输出加速（OJ常用）

默写：

- 一个reader (BufferedReader inputStreamReader)一个tokenizer(StringTokenizer)
- 一个 next() while(!tokenizer.hasmoretokens) tokenizer = newstring(reader.readline) return tokenizer.nexttoken
- 一个nextLine() return reader.nextline()
- 一个nextInt() return integer.parseint(next()) 一个nextDouble 一个nextLong

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
//可见，主要是使用了BufferedReader，主要使用其方法readline
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
```







### 日期相关类

#### 1 Date类

` java.util.Date`类 表示特定的瞬间，精确到毫秒。
毫秒:千分之一秒 1000毫秒=1秒

毫秒值->日期	    	构造
Date->毫秒值       	gettime

- `public Date()`： 获取当前系统的日期和时间
- `public Date(long date)`：传递毫秒值,把毫秒值转换为Date日期

> tips: 由于我们处于东八区，所以我们的基准时间为1970年1月1日8时0分0秒。



```java
        Date date = new Date();
        System.out.println(date);//Sat Nov 28 10:21:09 CST 2020
        System.out.println(date.getTime());//1606530178632

        Date date1=new Date(0L);
        System.out.println(date1);//Thu Jan 01 08:00:00 CST 1970

        System.out.println(System.currentTimeMillis());//1606530069211
        Date date2 = new Date(1606530069211L);
        System.out.println(date2);//Sat Nov 28 10:21:09 CST 2020
```

常用方法

Date类中的多数方法已经过时，常用的方法有：

* `public long getTime()` 把日期对象转换成对应的时间毫秒值。





#### 2 DateFormat类

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201128102735462.png" alt="image-20201128102735462" style="zoom:50%;" />

`java.text.DateFormat` 是日期/时间格式化子类的抽象类，我们通过这个类可以帮我们完成日期和文本之间的转换,也就是可以在Date对象与String对象之间进行来回转换。

* **格式化**：按照指定的格式，从Date对象转换为String对象。
* **解析**：按照指定的格式，从String对象转换为Date对象。

###### **构造方法**

由于DateFormat为抽象类，不能直接使用，所以需要常用的子类`java.text.SimpleDateFormat`。这个类需要一个模式（格式）来指定格式化或解析的标准。构造方法为：

* `public SimpleDateFormat(String pattern)`：用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。

参数pattern是一个字符串，代表日期时间的自定义格式。

###### **格式规则**

常用的格式规则为：

| 标识字母（区分大小写） | 含义 |
| ---------------------- | ---- |
| y                      | 年   |
| **M**                  | 月   |
| d                      | 日   |
| **H**                  | 时   |
| m                      | 分   |
| s                      | 秒   |



###### 常用方法

DateFormat类的常用方法有：

- `public String format(Date date)`：将Date对象格式化为字符串。
- `public Date parse(String source)`：将字符串解析为Date对象。





```java
    @Test
    public  void test1(){
        //发现 ：当yyyy个数是4、3、1个时 是2020 ，两个时是20， M d H m s 是一个两个都可以
        SimpleDateFormat sdf = new SimpleDateFormat("王晨元年     yyyy-MM-dd     HH点mm分ss秒");
        Date currentDate = new Date();
        String format = sdf.format(currentDate);
        System.out.println(format);
    }

    @Test
    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = sdf.format(new Date());
        System.out.println(format);

        String str="2020-11-28 10-49-50";
        Date parsedate = sdf.parse(str);
        System.out.println(parsedate);
    }
```



###### 实质：

​       SimpleDateFormat对象指定了一个**转换格式**

利用这个格式可以完成        
**String   	->SimpleDateFormat对象的parse方法  	->  	Date**
**Date 		->SimpleDateFormat对象的format方法	->     String**

> 两段论：
>
> 1. 先创建SimpleDateFormat对象,在构造方法中传递参数，  制定一个**转换格式**
>
> 2. 利用这个转换格式，调用方法完成Date和String之间的转换

#### 3 Calendar类

[CSDN1](https://blog.csdn.net/yx0628/article/details/79317440?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-5.control&dist_request_id=1331974.7619.16185546434625787&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-5.control)



#####  概念

`java.util.Calendar`是日历类，在Date后出现，替换掉了许多Date的方法。该类将所有可能用到的时间信息封装为**静态成员变量，方便获取**。**日历类就是方便获取各个时间属性的**。

##### 获取方式

Calendar为抽象类，由于语言敏感性，Calendar类在**创建对象时并非直接创建，而是通过静态方法创建**，返回子类对象，如下：

Calendar静态方法

* `public static Calendar getInstance()`：使用默认时区和语言环境获得一个日历

例如：

```java
import java.util.Calendar;
public class Demo06CalendarInit {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
    }    
}
```

##### 常用方法

根据Calendar类的API文档，常用方法有：

- `public int get(int field)`：返回给定日历字段的值。
- `public void set(int field, int value)`：将给定的日历字段设置为给定值。
- `cal.set(year, month, date, hourOfDay, minute, second);`  比如 cal.set(2018, 1, 15, 23, 59, 59);
- set(int year ,int month,int date) 
- set(int year ,int month,int date,int hour,int minute) 
- set(int year ,int month,int date,int hour,int minute,int second) 
- `public abstract void add(int field, int amount)`：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
- `public Date getTime()`：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。

Calendar类中提供很多成员常量，代表给定的日历字段：

| 常量                  | 描述                           |
| :-------------------- | :----------------------------- |
| Calendar.YEAR         | 年份                           |
| Calendar.MONTH        | 月份                           |
| Calendar.DATE         | 日期                           |
| Calendar.DAY_OF_MONTH | 日期，和上面的字段意义完全相同 |
| Calendar.HOUR         | 12小时制的小时                 |
| Calendar.HOUR_OF_DAY  | 24小时制的小时                 |
| Calendar.MINUTE       | 分钟                           |
| Calendar.SECOND       | 秒                             |
| Calendar.DAY_OF_WEEK  | 星期几                         |

YEAR	年	MINUTE	分	
DAY_OF_WEEK_IN_MONTH某月中第几周
MONTH	月	SECOND/MILLISECOND	秒/毫秒	WEEK_OF_MONTH	日历式的第几周
DATE 	日	DAY_OF_MONTH	
和DATE一样

DAY_OF_YEAR	一年的第多少天
HOUR_OF_DAY	时	DAY_OF_WEEK	周几	WEEK_OF_YEAR	一年的第多少周

> ==星期是     周日为1、周一为2、周二为3==
>
> ==月份是  1月为0，二月为1==  
>
> ```java
>     // 或者6个字段分别进行设置，由于月份下标从0开始赋值月份要-1
> 
> /**
>  * Value of the {@link #DAY_OF_WEEK} field indicating
>  * Sunday.
>  */
> public static final int SUNDAY = 1;
> 
> /**
>  * Value of the {@link #DAY_OF_WEEK} field indicating
>  * Monday.
>  */
> public static final int MONDAY = 2;
> 
> /**
>  * Value of the {@link #DAY_OF_WEEK} field indicating
>  * Tuesday.
>  */
> public static final int TUESDAY = 3;
> 
> /**
>  * Value of the {@link #DAY_OF_WEEK} field indicating
>  * Wednesday.
>  */
> public static final int WEDNESDAY = 4;
> 
> /**
>  * Value of the {@link #DAY_OF_WEEK} field indicating
>  * Thursday.
>  */
> public static final int THURSDAY = 5;
> 
> /**
>  * Value of the {@link #DAY_OF_WEEK} field indicating
>  * Friday.
>  */
> public static final int FRIDAY = 6;
> 
> /**
>  * Value of the {@link #DAY_OF_WEEK} field indicating
>  * Saturday.
>  */
> public static final int SATURDAY = 7;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * first month of the year in the Gregorian and Julian calendars.
>  */
> public static final int JANUARY = 0;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * second month of the year in the Gregorian and Julian calendars.
>  */
> public static final int FEBRUARY = 1;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * third month of the year in the Gregorian and Julian calendars.
>  */
> public static final int MARCH = 2;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * fourth month of the year in the Gregorian and Julian calendars.
>  */
> public static final int APRIL = 3;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * fifth month of the year in the Gregorian and Julian calendars.
>  */
> public static final int MAY = 4;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * sixth month of the year in the Gregorian and Julian calendars.
>  */
> public static final int JUNE = 5;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * seventh month of the year in the Gregorian and Julian calendars.
>  */
> public static final int JULY = 6;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * eighth month of the year in the Gregorian and Julian calendars.
>  */
> public static final int AUGUST = 7;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * ninth month of the year in the Gregorian and Julian calendars.
>  */
> public static final int SEPTEMBER = 8;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * tenth month of the year in the Gregorian and Julian calendars.
>  */
> public static final int OCTOBER = 9;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * eleventh month of the year in the Gregorian and Julian calendars.
>  */
> public static final int NOVEMBER = 10;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * twelfth month of the year in the Gregorian and Julian calendars.
>  */
> public static final int DECEMBER = 11;
> 
> /**
>  * Value of the {@link #MONTH} field indicating the
>  * thirteenth month of the year. Although <code>GregorianCalendar</code>
>  * does not use this value, lunar calendars do.
> ```



```java
import java.util.Calendar;

public class CalendarUtil {
    public static void main(String[] args) {
        // 创建Calendar对象
        Calendar cal = Calendar.getInstance();
        // 设置年 
        int year = cal.get(Calendar.YEAR);
        // 设置月
        int month = cal.get(Calendar.MONTH) + 1;
        // 设置日
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        System.out.print(year + "年" + month + "月" + dayOfMonth + "日");
    }    
}
```

```java
import java.util.Calendar;

public class Demo07CalendarMethod {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        System.out.print(year + "年" + month + "月" + dayOfMonth + "日"); // 2020年1月17日
    }
}
```

add方法可以对指定日历字段的值进行加减操作，如果第二个参数为正数则加上偏移量，如果为负数则减去偏移量。代码如：

```java
import java.util.Calendar;

public class Demo08CalendarMethod {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.print(year + "年" + month + "月" + dayOfMonth + "日"); // 2018年1月17日
        // 使用add方法
        cal.add(Calendar.DAY_OF_MONTH, 2); // 加2天
        cal.add(Calendar.YEAR, -3); // 减3年
        System.out.print(year + "年" + month + "月" + dayOfMonth + "日"); // 2015年1月18日; 
    }
}
```

Calendar中的getTime方法并不是获取毫秒时刻，而是拿到对应的Date对象。

```java
import java.util.Calendar;
import java.util.Date;

public class Demo09CalendarMethod {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println(date); // Tue Jan 16 16:03:09 CST 2018
    }
}
```

> 小贴士：
>
> ​     **西方星期的开始为周日，中国为周一。**
>
> ​     **在Calendar类中，月份的表示是以0-11代表1-12月。**
>
> ​     日期是有大小关系的，时间靠后，时间越大。





### BigInteger类



[讲得很好](https://jiming.blog.csdn.net/article/details/87002816?utm_medium=distribute.pc_relevant.none-task-blog-searchFromBaidu-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-searchFromBaidu-2.control)

[进制转换](https://blog.csdn.net/qq_41668547/article/details/87628618)









## 三、迭代器

获取迭代器的方法：
Iterator<类> 	迭代器名     = 	容器名.iterator()



Iterator接口的常用方法如下：

```java
public E next() :返回迭代的下一个元素
public boolean hasNext() :如果仍有元素可以迭代，则返回 true
```



```java
public class IteratorDemo {
	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<String>();	//多态
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");

		Iterator<String> it = coll.iterator();

		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}
}

```

> 当遍历集合时，首先通过调用集合的iterator()方法获得迭代器对象，然后使用hashNext()方法判断集合中是否存在下一个元素，如果存在，则调用next()方法将元素取出，否则说明已到达了集合末尾，停止遍历元素。
>
> Iterator迭代器对象在遍历集合时，内部采用指针的方式来跟踪集合中的元素，在调用Iterator的next()方法之前，迭代器的索引位于第一个元素之前，不指向任何元素，当第一次调用迭代器的next方法后，迭代器的索引会向后移动一位，指向第一个元素并将该元素返回，当再次调用next方法时，迭代器的索引会指向第二个元素并将该元素返回，依此类推，直到hasNext方法返回false，表示到达了集合的末尾，终止对元素的遍历。



## 四、C++与JAVA对比

### **1、JAVA迭代器与C++迭代器**

**C++**

```C++
vector<int>::iterator iter = vec1.begin();
string::iterator it=s.begin();
map<int,string>::iterator iter_map=m.begin();
auto iter=s.begin();
```

**JAVA**

```JAVA
Iterator<String> it = coll.iterator();
```

可见 
C++是 		数据结构<元素类型>::iterator    	
Java是		Iterator<元素类型>



### **2、数据结构定义方法**

**C++**

```C++
list<int> lst1; 
stack<int> S;
set<int> a;
map<int,string> map1;
```

**Java**

```JAVA
ArrayList<String> list = new ArrayList<String>();
//在JDK 7后,右侧泛型的尖括号之内可以留空，但是<>仍然要写。简化格式：
ArrayList<String> list = new ArrayList<>();
Collection<String> col=new ArrayList<String>();
```

可见他们几乎相同；区别是Java需要在堆里new一下



### 3、长度

| 类型         | C++                                                          | JAVA      |
| ------------ | ------------------------------------------------------------ | --------- |
| String       | .length() 或者是 .size()，size适合描述容器，这里为了统一才引进size的 | .length() |
| 数组         | 字符数组是strlen，其他数组可以用sizeof(array) / sizeof(array[0]) | .length   |
| 其他各种容器 | .size()                                                      | .size()   |



### 4、集合与排序

C++对待集合：当集合元素有序时，要指定comp或者重载<   ，遵循**返回值是bool，有大降 小升**的原则

java对待集合：当集合元素有序时，类继承接口后重写compare  或者 创建时从传入lambda表达式匿名内部类，遵循



C++对于sort函数，可以sort数组（自定义排序规则，或使用默认的） 格式是sort(a,a+size a,cmp);

Java对于sort ：集合使用Collections.sort 数组使用Arrays.sort ，有很多重载，可以指定lambda、起始位置，注意基本类型排序规则已定，要使用包装类   ，遵循 **返回值是int    ，前 - 后 是升序**







## 五、可变参数



在JDK1.5之后，如果我们定义一个方法需要接受多个参数，并且多个参数类型一致，我们可以对其简化成如下格 式：

**修饰符 返回值类型 方法名(参数类型... 形参名){  }**                   



 注意对于可变参数，也可以过去一个数组

```java
public class ChangeArgs {
    public static void main(String[] args) {
        // 求 这几个元素和 6  7  2 12 2121
        int sum2 = getSum(6, 7, 2, 12, 2121);
        System.out.println(sum2);
    }

 //注意对于可变参数，也可以过去一个数组
    public static int getSum(int... arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum;
    }
}
```



## 六、Lambda



==lambda的使用处 必须是 **需要函数式接口对象的地方**，== 这个接口可以在方法参数中，可以是方法返回值，也可以创建一个对象时。代码块传递给函数式接口中的抽象方法，从而相当于**形成了一个 接口的实现类对象**

由于它的效果等价于<u>匿名内部类</u>，是一个对象，是一个已经重写了函数式接口中唯一抽象方法的类的对象，因此lambda的语句体中也是要完成重写的操作



面向对象的思想:

​	做一件事情,找一个能解决这个事情的对象,调用对象的方法,完成事情.

函数式编程思想:

​	只要能获取到结果,谁去做的,怎么做的都不重要,重视的是结果,不重视过程



1. **使用Lambda表达式的地方：** 一定是一个 需要 函数式接口对象 的地方，也即 Lambda表达式相当于一个**实现类对象**
2. **写Lambda表达式的方法：** <u>函数式接口中的抽象方法</u>决定了Lambda表达式的写法 （函数参数和返回值）
3. 也即**Lambda表达式** 是 ==方法的实现==





典型的两段式：

1. 函数式接口中的方法**规定了 源参数 和 返回值**， Lambda负责其中的**运算处理过程**
   <u>类似 接口中的方法声明中的参数负责     x和y           lambda负责函数体 f（x）</u> 
2. 类中另外写了一个方法，负责整合 。且方法的某个或某些函数接口参数对象 ，负责 **供给** 或 **消费** 或 **一个映射** 或 **断言判断方法**，其他参数视情况具体而定。





Lambda表达式的**标准格式**为：

```
(参数类型 参数名称) -> { 代码语句 }
```

### 省略规则

在Lambda标准格式的基础上，使用省略写法的规则为：

1. 小括号内参数的**类型**可以省略；
2. 如果小括号内**有且仅有一个参**，则小括号可以省略；
3. 如果大括号内**有且仅有一个语句**，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。





**例1：**

```java
@FunctionalInterface
public interface MyFunction {
    Integer getValue(Integer num);  
    //参数是 一个整数，映射 一个整数，  映射规则自己定（在Lambda表达式中实现）
}
```

```java
public class Demo03_MyFunction {
    public static void main(String[] args) {
        Integer num1=operartion(100,(x)->x*x);
        System.out.println(num1);

        Integer num2=operartion(1000,(x)->++x);
        System.out.println(num2);
    }

    public static Integer operartion(Integer num,MyFunction mf){
        return mf.getValue(num);
    }
}
```

对以上的理解：

编程目标是，实现对整数的处理（得到平方、自增1），





**例2：**

```java
public interface MyFunction {
    public String getValue(String str);
}
```

```java
public class Demo01 {
    public static void main(String[] args) {
        String out=HandleStr("\t \t                 王晨爱睡觉",str->str.trim() );
        System.out.println(out);
    }

    public static String HandleStr(String str,MyFunction mf) {
        return mf.getValue(str);
    }
}
```



Lambda的语法非常简洁，完全没有面向对象复杂的束缚。但是使用时有几个问题需要特别注意：

1. 使用Lambda必须具有接口，且要求**接口中有且仅有一个抽象方法**。
   无论是JDK内置的`Runnable`、`Comparator`接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用Lambda。
2. 使用Lambda必须具有**上下文推断**。
   也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。

> 备注：有且仅有一个抽象方法的接口，称为“**函数式接口**”。



## 七、函数式接口

---

==函数式接口在Java中是指：有且仅有一个抽象方法的接口。== 函数式接口，即适用于函数式编程场景的接口。而Java中的函数式编程体现就是Lambda，所以函数式接口就是可 以适用于Lambda使用的接口。**只有确保接口中有且仅有一个抽象方法，Java中的Lambda才能顺利地进行推导**。 **备注：“语法糖”是指使用更加方便，但是原理不变的代码语法。例如在遍历集合时使用的for-each语法，其实 底层的实现原理仍然是迭代器，这便是“语法糖”**。从应用层面来讲，Java中的Lambda可以被当做是匿名内部 类的“语法糖”，但是二者在原理上是不同的。



1. 接口是什么类型的，Supplier中的get方法就提供什么类型的数据；   
2. 接口是什么类型的，Consumer中的accept方法就消费什么类型的数据；
3. 接口是什么类型的，Prediacate中的test方法就 接收什么类型的数据，然后判断返回一个bool值
4. 接口是什么类型的，Function中的apply方法就 接受什么类型T的数据，返回什么类型R的数据

### 1 Supplier < T >接口

java.util.function.Supplier<T> 接口仅包含一个无参的方法： T get() 。用来获取一个泛型参数指定类型的对 象数据。由于这是一个函数式接口，这也就意味着对应的Lambda表达式需要“对外提供”一个符合泛型类型的对象 数据。

```java
public interface Supplier<T>{
    T get();
}
```

**指定接口是什么泛型，那么接口中的get方法就提供什么类型的数据**

例如：

```java
public ArrayList<Double> makeList(int num,Supplier<Double> sup)
{
    ArrayList<Double> list=new ArrayList<>();
    for(int i=0;i<num;i++)
    list.add(sup.get());
}
```

上述函数的功能是得到一个存取Double的ArrayList集合， 
 **集合元素的添加，用参数sup供给**；  
参数**num**负责集合中的个数；
lambda表达式负责元素的获取规则



小结：消费的方式，供给的方法由Lambda指定，源和目的由接口指定





---

### 2 Consumer< T >接口

java.util.function.Consumer<T> 接口则正好与Supplier接口相反，它不是生产一个数据，而是消费一个数据， 其数据类型由泛型决定。

**2.1 抽象方法accept方法** 

```java
public interface Consumer<T>{
    void accept(T t)
}
```

**接口泛型是什么类型，accept方法就消费什么类型**
参数 Consumer接口负责 消费
其他参数需要有一个提供消费品



**2.2 默认方法：andThen** 

```java
default Consumer<T> andThen(Consumer<? super T> after) {     
    Objects.requireNonNull(after);     
    return (T t) ‐> { accept(t); after.accept(t); }; 
}

```



例子：

```java
public class Demo02_andThen {
    public static void main(String[] args) {
        String str="HeLLo";
        method(str,(s)-> System.out.println(s.toUpperCase()),(s)-> System.out.println(s.toLowerCase()));
        System.out.println("--------------------");
        method1(str,
                (s)-> System.out.println(s.toUpperCase()),
                (s)-> System.out.println(s.toLowerCase()),
                (s)-> System.out.println(s+"World")
        );
    }
    public static void method(String str, Consumer<String> con1,Consumer<String> con2)
    {
        con1.andThen(con2).accept(str);
        /*
        上式等价于先后执行
        con1.accept(str);
        con2.accept(str);
         */
    }

    //andThen可以连接很多
    public static void method1(String str, Consumer<String> con1,Consumer<String> con2,Consumer<String> con3)
    {
        con1.andThen(con2).andThen(con3).accept(str);
        /*
        上式等价于先后执行
        con1.accept(str);
        con2.accept(str);
        con3.accept(str);
         */
    }
}

```

---

### 3  Predicate< T >接口 

**3.1 抽象方法：test** 

Predicate 接口中包含一个抽象方法： **boolean test(T t)**   用于条件判断的场景：

```java
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,100,300,100000);
        System.out.println(list);

        ArrayList<Integer> outlist=getlist(list,(i)->i<5);
        System.out.println(outlist);
    }

    public static ArrayList<Integer> getlist(ArrayList<Integer> list, Predicate<Integer> pre)
    {
        ArrayList<Integer> newlist=new ArrayList<>();
        
        for (Integer integer : list) {
            if(pre.test(integer))
                newlist.add(integer);
        }
        return newlist;
    }

}
```





**3.2 默认方法：and** 
既然是条件判断，就会存在与、或、非三种常见的逻辑关系。其中将两个 Predicate 条件使用“与”逻辑连接起来实 现“并且”的效果时，可以使用default方法 and 。

```java
public class Demo02_and {
    public static void main(String[] args) {
        String str="wangchen";
        boolean b=Judge(str,s->str.length()>5,s->str.startsWith("wang"));
        System.out.println(b);
    }

    public static boolean Judge(String str, Predicate<String> pre1,Predicate<String> pre2)
    {
//      等价写法： 
//      return pre1.test(str)&& pre2.test(str);
        return pre1.and(pre2).test(str);
    }

}
```



**3.3 默认方法：or** 
与 and 的“与”类似，默认方法 or 实现逻辑关系中的“或”。

```java
public class Demo03_or {
    public static void main(String[] args) {
        String str="wangchen";
        boolean b=judge(str,s->s.length()>15,s->s.startsWith("wang"));
        System.out.println(b);

    }

    public static boolean judge(String str, Predicate<String> pre1,Predicate<String> pre2)
    {
//        等价写法
//        return pre1.test(str)||pre2.test(str);
        return pre1.or(pre2).test(str);
    }
}
```



**3.4默认方法：negate** 

```java
public class Demo04_negate {
    public static void main(String[] args) {
        String str="wangchen";

        //是"wangchen"就返回false ，不是就返回true
        boolean b=judge(str,s->s.equals("wangchennn"));
        System.out.println(b);
    }
    public static boolean judge(String str, Predicate<String> pre)
    {
        return pre.negate().test(str);
    }
}
```



**信息筛选例子**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200624125337848.png" alt="image-20200624125337848" style="zoom: 50%;" />

 



---

### 4 Function <T,R> 接口 

java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件， 后者称为后置条件。



**4.1 抽象方法：apply** 
Function 接口中主要的抽象方法为： **R apply(T t)** ，根据类型T的参数获取类型R的结果。
使用的场景例如：将 String 类型转换为 Integer 类型。

```java
public class Demo01 {
    public static void main(String[] args) {
        String str1="12345";
        method(str1,s ->Integer.parseInt(s) );

        String str2="wangchen";
        method(str2,s->s.length());
    }

    public static void method(String str, Function<String,Integer> fun)
    {
        int out=fun.apply(str);
        System.out.println(out);
    }
}
```







**4.2 默认方法：andThen** 
Function 接口中有一个默认的 andThen 方法，用来进行组合操作。

自我理解： 和Consumer中的andThen有些许不同，

Consumer中的andThen是两个accept方法先后执行，  他们只有执行顺序的规定，而没有一些参数的依赖。

但是Function中的andThen是两个apply方法先后执行，不仅仅有执行顺序的规定，而且前者的返回值是后者的源

```java
public class Demo02_andThen {
    public static void main(String[] args) {
        //判断字符串对应的数字是否大于100
        method("91",s->Integer.valueOf(s),i->i>100);
    }

    public static void method(String str, Function<String,Integer> fun1,Function<Integer,Boolean> fun2)
    {
      
        Integer i=fun1.apply(str);
        Boolean b1=fun2.apply(i);
        System.out.println("b1="+b1);
        System.out.println("-------------------");
        Boolean b2 = fun1.andThen(fun2).apply(str);
        System.out.println("b2="+b2);

    }
}
```





### 5  forEach

```java
  / * @since 1.8
     */
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
```







---

## 八、Stream流

每当我们需要对集合中的元素进行操作的时候，总是需要进行循环、循环、再循环。这是理所当然的么？不是。循 环是做事情的方式，而不是目的。另一方面，使用线性循环就意味着只能遍历一次。如果希望再次遍历，只能再使 用另一个循环从头开始。

更加关注做什么而不是怎么做



该部分内容请参考IT黑马文件课程中的PDF

https://blog.csdn.net/weixin_38294999/article/details/89277697

https://blog.csdn.net/y_k_y/article/details/84633001?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&dist_request_id=1331978.10189.16186251830881183&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control



##  九、IO异常的处理

### JDK7前处理

之前的入门练习，我们一直把异常抛出，而实际开发中并不能这样处理，建议使用`try...catch...finally` 代码块，处理异常部分，代码使用演示：     注意定义资源时，不能在try中，因为如果定义了的话，它的作用于就仅限于try语句块了，finally里是无法释放的。

```java  
public class HandleException1 {
    public static void main(String[] args) {
      	// 声明变量
        FileWriter fw = null;
        try {
            fw = new FileWriter("fw.txt");
            fw.write("黑马程序员"); //黑马程序员
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```





### JDK7的处理(扩展知识点了解内容)

还可以使用JDK7优化后的`try-with-resource` 语句，该语句确保了每个资源在语句结束时关闭。所谓的资源（resource）是指在程序完成后，必须关闭的对象。

格式：

```java
try (创建流对象语句，如果多个,使用';'隔开) {
	// 读写数据
} catch (IOException e) {
	e.printStackTrace();
}
```

代码使用演示：

```java
public class HandleException2 {
    public static void main(String[] args) {
      	// 创建流对象
        try ( FileWriter fw = new FileWriter("fw.txt"); ) {
            // 写出数据
            fw.write("黑马程序员"); //黑马程序员
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```





### JDK9的改进(扩展知识点了解内容)

JDK9中`try-with-resource` 的改进，对于**引入对象**的方式，支持的更加简洁。被引入的对象，同样可以自动关闭，无需手动close，我们来了解一下格式。

改进前格式：

```java
// 被final修饰的对象
final Resource resource1 = new Resource("resource1");
// 普通对象
Resource resource2 = new Resource("resource2");
// 引入方式：创建新的变量保存
try (Resource r1 = resource1;
     Resource r2 = resource2) {
     // 使用对象
}
```

改进后格式：

```java
// 被final修饰的对象
final Resource resource1 = new Resource("resource1");
// 普通对象
Resource resource2 = new Resource("resource2");

// 引入方式：直接引入
try (resource1; resource2) {
     // 使用对象
}
```

改进后，代码使用演示：

```java
public class TryDemo {
    public static void main(String[] args) throws IOException {
       	// 创建流对象
        final  FileReader fr  = new FileReader("in.txt");
        FileWriter fw = new FileWriter("out.txt");
       	// 引入到try中
        try (fr; fw) {
          	// 定义变量
            int b;
          	// 读取数据
          	while ((b = fr.read())!=-1) {
            	// 写出数据
            	fw.write(b);
          	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



## 其他





通过以下实验,发现对HashMap<Character,Hashset> map这个容器，通过character来的hashset，是**获得**，而不是**复制**

```java
public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.add("cde");

        HashMap<Character, HashSet<String>> map = new HashMap<>();
        map.put('a',set);
        for(Character c:map.keySet()){
            System.out.println("key:"+c+"          value:"+map.get(c));
        }

        HashSet<String> aset = map.get('a');
        aset.add("this is new");

        for(Character c:map.keySet()){
            System.out.println("key:"+c+"          value:"+map.get(c));
        }
    }
```

> Output：
>
> key:a          value:[abc, cde]
> key:a          value:[abc, this is new, cde]





### 浮点数的比较方法

1、

```java
 if (Math.abs(f1 - f2) <1e-6) {
            System.out.println("f1 and f2 are equal using threshold");
        } else {
            System.out.println("f1 and f2 are not equal using threshold");
        }
```





```java
if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
    return false;
}
return Math.abs(a - b) < 1e-6d;
```





2、

`BigDecimal` 是不可变的，能够精确地表示十进制数字。需要注意的是，创建 `BigDecimal` 对象时，要使用参数为 `String` 的构造方法，不要使用构造参数为 `double` 的，如果非要使用 `double` 创建，一定要用 `valueOf` 静态方法，防止丢失精度。然后调用 `compareTo` 方法比较即可。



```java
    private void compareByBigDecimal() {
        BigDecimal f1 = new BigDecimal("0.0");
        BigDecimal pointOne = new BigDecimal("0.1");
        for (int i = 0; i < 11; i++) {
            f1 = f1.add(pointOne);
        }

        BigDecimal f2 = new BigDecimal("0.1");
        BigDecimal eleven = new BigDecimal("11");
        f2 = f2.multiply(eleven);

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        if (f1.compareTo(f2) == 0) {
            System.out.println("f1 and f2 are equal using BigDecimal");
        } else {
            System.out.println("f1 and f2 are not equal using BigDecimal");
        }
    }
```

运行输出：

```cpp
f1 = 1.1
f2 = 1.1
f1 and f2 are equal using BigDecimal
```



### 手写加速输入类Reader

算法题中Scanner经常超时

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
简记：
	字段：
	BufferedReader reader = new br(new inputstream reader sys);
	StringTokenizer tokenizer = new StringTokenizer("");
	函数：
	String next() 
while!tokenizer.hasmoretokens() 
tokenizer = new Stringtokenizer(reader.readline) 
return token.nexttoken();

	String nextLine() reader.readline
	int nextInt() parseint(next())
	Long nextLong()
	Double nextDouble() 
*/
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

```




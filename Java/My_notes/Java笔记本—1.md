

# JAVA笔记本—1

:smiley:

# 期末

### 1.考点

考试 有第14章的内容

3、8、11章节是重点

1. 第3章除了实名内部类以外 全部掌握

2. 第8章 重点在于 前面设计的基本思路、事件处理机制  布局管理要知道类型就可了  重点是1、3

3. 第11章 基本都要会。  wait 和notify 要知道什么意思，不需要写程序

这三章将占据70%的分数



第四章会一些数组的创建初始化、字符串的创建初始化和一些简单用法、向量哈希表的基本概念如何创建遍历

第五章没啥东西，看一看。for简化的能看得懂

第六章  单体类要会写！！

第七章 文件输入文件输出、读文件写文件 要回，FileInputStream 、FileOUtputStream要会 也即要会7.1节的 7.1.1和7.1.2

第九章、第十章没啥

第十二章要读得懂程序、基本步骤要会

第十三章看看一些类即可

第十四章，要能看得懂，能补全语句



四种题型

- 选择题  30道 20分
- 填空题 20道 一个两分
- 程序阅读  20分，
- 应用题 4题 30分   （多态、多线程、单体程序设计、最简单的Swing设计 文本按钮事件处理、网络也有可能、子类继承父类、匿名内部类）





应用题（程序设计题目）中不用写import语句。





### 2.考点总结

#### 第三章

面向技术三大特性： 继承性 多态性 封装性

多态性：指的是在类定义中出现多个构造方法 或 出现多个同名的成员方法



# 一、基础知识

1,000,000,000

十亿billion   百万million    千thousand

1e8 1亿

1e7 1000万

## 数据类型

**基本数据类型**
	整数型	byte 127      short 32767           int 2^31、21亿、2* 10 ^9                    long 2^63    9*10^18
	浮点型	float double
	字符型	char
	布尔型	boolean

引用数据类型
	字符串、数组、类、接口、Lambda
$$
数据类型
\begin{cases}
	基本数据类型
	\begin{cases}
	整数型&\text{byte short int long} \\浮点型&\text{float double}\\字符型&\text{char}\\布尔型&\text{boolean}
	\end{cases}
	\\
	引用数据类型	 \ \ \ \ \ \ \ \ \ \ \ \ 字符串、数组、类、接口、Lambda
	
\end{cases}
$$



> 注意引用数据类型的指向关系
>
> <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210123215747153.png" alt="image-20210123215747153" style="zoom: 50%;" />

**八进制**:0开头 包括0-7       例如:037,056

**十六进制**:0x(小写或大写均可)开头,包括0-9,以及字母a-f,A_F   如:0x12,0xBF

**二进制**：0b



双进度浮点数		123.1d , 1.1D

单精度浮点		1.1f 1.2F

后缀就是名字的首字母



当小数后面没有任何字母时默认为double类型

在java中 较小的类型可以转换为较大的类型,较大的类型不可以直接转换为较小的类型,会造成数据丢失




## 类的定义

​	**[修饰词列表] 	class	类名字  [extends 父类名] 	[implements 接口名称列表]**

{

}

- 一般的**类的修饰词列表**有<u>public、abstract、final、默认</u> 没有protected 和private 这两个内部类才有的

- 且一个源文件中只能有一个public类



> 1. 用public修饰类可以被所有软件包使用，但注意要导包。  
> 2. ==一个java文件中可以有多个类，但只能有一个（也可以一个都没有）public修饰的类，且该类的类名 和java文件名相同==  也即可以有多个 class 但只能有一个public class







## 编译过程

[以下](https://www.cnblogs.com/chengdabelief/p/6576320.html)

JVM是Java平台无关的基础。**JVM负责运行字节码：JVM把每一条要执行的字节码交给解释器，翻译成对应的机器码，然后由解释器执行**。JVM解释执行字节码文件就是**JVM操作Java解释器进行解释执行字节码文件的过程**。

**Java编译器：**将Java源文件（.java文件）编译成字节码文件（.class文件，是特殊的二进制文件，二进制字节码文件），这种字节码就是JVM的“机器语言”。javac.exe可以简单看成是Java编译器。

**Java解释器：**是JVM的一部分。Java解释器用来解释执行Java编译器编译后的程序。java.exe可以简单看成是Java解释器。



Java[解释器的运行过程解释](https://blog.csdn.net/yangyong0717/article/details/78374236)

[链接](https://zhuanlan.zhihu.com/p/361915411#:~:text=Java%E4%BB%A3%E7%A0%81%E7%BC%96%E8%AF%91%E5%92%8C%E6%89%A7%E8%A1%8C%E7%9A%84%E6%95%B4%E4%B8%AA%E8%BF%87%E7%A8%8B%E5%8C%85%E5%90%AB%E4%BA%86%E4%BB%A5%E4%B8%8B%E4%B8%A4%E4%B8%AA%E9%87%8D%E8%A6%81%E7%9A%84%E6%9C%BA%E5%88%B6%EF%BC%9A%20%E5%88%9B%E5%BB%BA%E5%AE%8C%E6%BA%90%E6%96%87%E4%BB%B6%E4%B9%8B%E5%90%8E%EF%BC%8C%E7%A8%8B%E5%BA%8F%E5%85%88%E8%A6%81%E8%A2%ABJVM%E4%B8%AD%E7%9A%84java%E7%BC%96%E8%AF%91%E5%99%A8%E8%BF%9B%E8%A1%8C%E7%BC%96%E8%AF%91%E4%B8%BA.class%E6%96%87%E4%BB%B6%E3%80%82,.java%E6%96%87%E4%BB%B6%E7%BC%96%E8%AF%91%E6%88%90.class%E6%96%87%E4%BB%B6%E7%9A%84%E8%BF%87%E7%A8%8B%E4%B8%AD%EF%BC%8C%E5%8C%85%E6%8B%AC%E8%AF%8D%E6%B3%95%E5%88%86%E6%9E%90%E3%80%81%E5%A1%AB%E5%85%85%E7%AC%A6%E5%8F%B7%E8%A1%A8%E3%80%81%E6%B3%A8%E8%A7%A3%E5%A4%84%E7%90%86%E3%80%81%E8%AF%AD%E4%B9%89%E5%88%86%E6%9E%90%E4%BB%A5%E5%8F%8A%E7%94%9F%E6%88%90class%E6%96%87%E4%BB%B6%E3%80%82%20%E7%BC%96%E8%AF%91%E5%90%8E%E7%9A%84class%E6%96%87%E4%BB%B6%E7%BB%93%E6%9E%84%E4%B8%AD%E4%B8%BB%E8%A6%81%E5%8C%85%E5%90%AB%E4%BA%86%E5%A6%82%E4%B8%8B%E4%BF%A1%E6%81%AF%EF%BC%9A)

[链接2](https://blog.csdn.net/chenlibao0823/article/details/102983756)

## 命令行

```java
javac test.java
java test
```

当我们在src/model1包下创建java文件时，开头会带一句`package model1`

这时我们需要在src/目录下执行`java model1.test` 才能执行





-  **java执行class文件对package的路径是强依赖的。它在执行的时候会严格以当前用户路径为基础，按照package指定的包路径转化为文件路径去搜索class文件。**



https://blog.csdn.net/ncc1995/article/details/84932759

---

## 父子类同名成员域、方法

父类

```java
public class Fa {
	public int num=1;	
	public Fa(int num) {
		super();
		this.num = num;
	}
	public Fa() {
		super();
	}	
}
```

子类

```java
public class Zi extends Fa{
	public int num=10000;

	public Zi(int num, int num2) {
		super(num);
		num = num2;
	}

	public Zi() {
		supe();
	}

}
```

主函数：

```java
public class demo03 {
	public static void main(String []args)
	{
		System.out.println("NINININII");
		Fa a=new Fa();
		Fa b=new Zi();
		Zi c=new Zi();
		System.out.println(a.num);	//	1
		System.out.println(b.num);	//	1
		System.out.println(c.num);	//	10000
	}
}
```



由此可见

- 父引用使用子对象的同名成员域时，使用的是父类中的同名成员域

- 父引用使用父对象成员域、子引用使用子对象成员域都是用自己的

另外

- 父引用调用子对象覆盖的方法时，调用的是子方法（多态）
- 父引用调用父对象方法，子引用调子对象方法都是调自己的







---

## 父子类型的转换（多态）

#### 1、向上转型（隐式）

如：

- Fa f=new Zi ( );

- Zi z =new Zi ( );

  Fu f=z;

- ((Fu)z)



#### 2、向下转型（显式）

前提：需要它本质上是子类对象

**注意要使用括号！**

如：

- Zi z=new Zi（）；

  Fu f=z；

  Zi tom=（Zi）f；



#### 3、instanceof运算符 

格式： 引用类型的表达式	instanceof	引用类型

例子：

```java
Zi zi=new Zi();
Fu fu=new Fu();
Fu tom=zi;// Fu tom=new Zi()
//1
zi instanceof zi  √
zi instanceof fu  √
//2
fu instanceof zi  ×
fu instanceof fu  √
//3
tom instanceof fu √
tom instanceof zi √
```

故一般这样写

```java
if(a instanceof Zi)
    b=(Zi)a;
```







## 构造函数

注意：

1. 构造方法名必须与类名相同
2. 不含有返回值类型
3. 当没有自己手动显式的定义构造函数时，默认的构造方法会自动生成，不含任何参数和方法体

**[修饰词列表]	类名	（参数列表）**
{

}


**for instance：**

父类

```java
public class Fa {
	public int num;
	public double prize;
	
	public Fa(int num, double prize) {
		super();
		this.num = num;
		this.prize = prize;
	}
	public Fa() {
		super();//调object类的无参构造
	}

	
}
```





子类

```java
public class Zi extends Fa{
	public int nummmm;
	public int prizeeeeee;
	public char flag;
	public Zi(int num, double prize, int nummmm, int prizeeeeee, char flag) {
		super(num, prize);//若父类没有无参构造只有有参构造，此处用super();就是错的
		this.nummmm = nummmm;
		this.prizeeeeee = prizeeeeee;
		this.flag = flag;
	}
	public Zi(int num, double prize) {
		super(num, prize);
	}

	
	
}
```

==注意：==

- 一个类 若手写构造了，那么系统就不会自动生成一个隐式无参的了
- 一个子类若继承一个 有参数的构造（父类中只有一个构造，且这个构造有参）的父类时，那么在子类的构造中必须显式的调用父类中那个有参构造对应的super。若父类没有写构造，或存在手写的无参构造，那么子类的构造中可以不显示声明super

例子

```java
class father {
    int a;
    String str;

    public father(int a, String str) {
        this.a = a;
        this.str = str;
    }

    public father() {
    }				//若把此无参构造注释掉，那么下面的子函数就会报错
}

class zi extends father{
    public zi()
    {
        隐式的构造
        ....一些语句;
    }
    
}
```



---

## 多态性

多态性：指的是在类（一个类、父子类）定义中出现多个构造<u>方法</u> 或 出现多个同名的成员<u>方法</u>

**1.静态多态性**

本质：重载
**同名的方法**（可以是构造方法），**不同的参数列表**



<u>静态多态性指的是在同一个类中同名方法在功能上的重载，这也包括一个类对其父类同名方法在功能上的重载</u>

**2.动态多态性**

本质：覆盖  

（注意：需要父子类对应的成员**方法声明完全相同（方法名 参数个数 参数类型）**，且子类具有更广或相同的访问控制方式）

- 父引用调用子对象 被写覆盖的方法时，调用的是子方法（多态）
- 父引用调用父对象方法，子引用调子对象方法都是调自己的

注意：动态多态性只针对非静态的成员方法

动态多态性指的是在子类和父类的类体中均定义了具有基本相同声明的非静态成员方法





在继承关系中，在调用函数（方法）或者类中的成员变量时，JVM（JAVA虚拟机）会先检测当前的类（也就是子类）是否含有该函数或者成员变量，如果有，就执行子类中的，如果没有才会执行父类中的



---

## 封装性

类的访问控制方式（非内部类）有两种：

**公共模式(public)  	和 	默认模式(不写)** 

public 能被所有包使用							使用前注意import导包

默认模式只能在同一个包内使用    			无需导包（都在一个包内了，还导个屁的包呀）









类的成员的访问控制

大前提：要想访问成员必须首先能访问类

**成员修饰词**
对于public不用多说，能访问类就可访问之
对于protected  还要对类的修饰分情况：类如果是默认则其他包都不行本包行，类如果是public则其他包行



---

## 匿名内部类

new 父类名（父构的参数列表）
{

​	父类所有抽象方法的实现

}；



父类可以是一个**类**（普通类，抽象类）还可以是**接口**
前者的话要求参数列表与该类的某个构造方法匹配。
后者的话，因为接口无构造方法，所以参数列表为空。
注意抽象类和接口要实现全部抽象方法，才能变成一个可用类

匿名内部类中可以定义成员域和成员方法， 
成员域不能有静态属性，若想有则必须也同时有final属性
不能有静态方法



---

## 包

- 任何一个java程序中只能用         **包语句、import语句、类**       三种东西

- **.java文件只是存源代码，位置在哪里都无所谓，但是.class文件要放到指定文件夹才能被其他.java文件通过import导入软件包**，也即**导包，导的是class**

- javac 命令使用的前提条件是 .java文件要在当前目录下



**包声明语句的格式：**

**package 包名;**

如： `package cn.edu.zzu.Organization;`







**编译一个含有包声明语句的java源程序格式**：

**javac  -d  路径名  java文件名**

- .java源代码在当前路径下
- 路径名（事先要存在）指定了一会儿编译后生成的软件包（.class）的**根路径**  （可以用.代表当前路径）
- 编译之后生成的class文件位于**根路径**下的的 **软件包名多级文件夹**中



例子：

假如一个java源程序文件 J_Teacher.java中 有包声明语句 `package cn.edu.zzu.university`

使用 javac -d . J_Teacher.java

则： 在当前路径下的cn/edu.zzu.university 下 会有J_Teacher.class 文件





**导入包语句格式**

import 包名.*

import 包名.类名

import static 包名.类型名.静态成员方法名；



---

## 抽象类与接口

#### 关于abstract关键字

abstract只能用来修饰*类、接口、成员方法*，而**成员域、构造方法不可以**





#### 抽象类

public abstract void print(参数);

- **抽象类不一定含有抽象成员方法，但是含有<u>抽象成员方法的类一定是抽象类</u>**
  （抽象类中可以有普通成员方法也可以有抽象成员方法，也可以只有普通方法，如适配器？）
- **若子类没有完全覆盖重写抽象父类的抽象成员方法，则该子类也仍是抽象类**
- 抽象类有构造方法，但不能用来创建实体对象
- 抽象成员方法 注意方法体为空，直接用写一个**;**







#### 接口

**[修饰词] interface  接口名 [extends 接口名]**   注意如果是public 那么.java文件要同名且只有一个public   

- 首先要知道**Java语言不允许一个类有多个直接父类，但允许一个类实现多个接口**

- **接口一定具有抽象abstract属性**，因此在接口修饰词列表中可以不写abstract

- 接口**无构造方法**

- 接口的**成员域 一定具有 public static final 属性**

- 接口的**成员方法一定具 public abstract属性**



1.接口可以多继承

2.接口的方法声明必须是 public abstract 即便不写默认也是

3.接口里面不能包含方法具体实现

4.类实继承接口必须实现接口里申明的全部方法，除非该类是抽象类

5.类里面可以声明 public static final 修饰的变量

6.接口不能被实例化，但是可以被实现类创建





#### 接口和抽象类的一些区别





- 接口和抽象类的概念不一样。<u>接口是对动作的抽象，抽象类是对根源的抽象。</u>

  抽象类表示的是，这个对象是什么。接口表示的是，这个对象能做什么。比如，男人，女人，这两个类（如果是类的话……），他们的抽象类是人。说明，他们都是人。

  人可以吃东西，狗也可以吃东西，你可以把“吃东西”定义成一个接口，然后让这些类去实现它.

  所以，在高级语言上，一个类只能继承一个类（抽象类）(正如人不可能同时是生物和非生物)，但是可以实现多个接口(吃饭接口、走路接口)。

- 第一点． 接口是抽象类的变体，**接口中所有的方法都是抽象的**。而抽象类是声明方法的存在而不去实现它的类。
- 第二点． **接口可以多继承，抽象类不行**
- 第三点． **接口定义方法，不能实现，而抽象类可以实现部分方法。**
- 第四点． 接口中基本数据类型为static 而抽类象不是的。

- **<u>当你关注一个事物的本质的时候，用抽象类；当你关注一个操作的时候，用接口。</u>**

- **抽象类的功能要远超过接口，但是，定义抽象类的代价高。因为高级语言来说（从实际设计上来说也是）每个类只能继承一个类。在这个类中，你必须继承或编写出其所有子类的所有共性。虽然接口在功能上会弱化许多，但是它只是针对一个动作的描述。而且你可以在一个类中同时实现多个接口。在设计阶段会降低难度的。**





- \1. 抽象类中的方法可以有方法体，就是能实现方法的具体功能，但是接口中的方法不行。
- \2. 抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是 **public static final** 类型的。
- \3. 接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)，而抽象类是可以有静态代码块和静态方法。
- \4. 一个类只能继承一个抽象类，而一个类却可以实现多个接口。

> **注**：JDK 1.8 以后，接口里可以有静态方法和方法体了。
>
> **注**：JDK 1.8 以后，接口允许包含具体实现的方法，该方法称为"默认方法"，默认方法使用 default 关键字修饰。更多内容可参考 [Java 8 默认方法](https://www.runoob.com/java/java8-default-methods.html)。
>
> **注**：JDK 1.9 以后，允许将方法定义为 private，使得某些复用的代码不会把方法暴露出去。更多内容可参考 [Java 9 私有接口方法](https://www.runoob.com/java/java9-private-interface-methods.html)。







#### 接口与类的区别：

- 接口不能用于实例化对象。
- 接口没有构造方法。
- 接口中所有的方法必须是抽象方法，Java 8 之后 接口中可以使用 default 关键字修饰的非抽象方法。
- 接口不能包含成员变量，除了 static 和 final 变量。
- 接口不是被类继承了，而是要被类实现。
- 接口支持多继承。





#### final

**final 的作用随着所修饰的类型而不同**

1、final 修饰类中的属性或者变量

无论属性是基本类型还是引用类型，final 所起的作用都是变量里面存放的"值"不能变。

这个值，对于基本类型来说，变量里面放的就是实实在在的值，如 1，"abc" 等。

而引用类型变量里面放的是个地址，所以用 final 修饰引用类型变量指的是它里面的地址不能变，并不是说这个地址所指向的对象或数组的内容不可以变，这个一定要注意。

例如：类中有一个属性是 **final Person p=new Person("name");** 那么你不能对 p 进行重新赋值，但是可以改变 p 里面属性的值 **p.setName('newName');**

final 修饰属性，声明变量时可以不赋值，而且一旦赋值就不能被修改了。对 final 属性可以在三个地方赋值：声明时、初始化块中、构造方法中，总之一定要赋值。

2、final修饰类中的方法

作用：可以被继承，但继承后不能被重写。

3、final修饰类

作用：类不可以被继承。







## static

static只能用于 成员域 和 成员方法











---



## 包装类

| 基本类型 | 对应的包装类（位于java.lang包中） |
| -------- | --------------------------------- |
| byte     | Byte                              |
| short    | Short                             |
| int      | **Integer**                       |
| long     | Long                              |
| ﬂoat     | Float                             |
| double   | Double                            |
| char     | **Character**                     |
| boolean  | Boolean                           |



**一些静态方法**

| String -> 其他基本类型    |      |
| ------------------------- | ---- |
| Boolean.parseBoolean(str) |      |
| Byte.parseByte(str)       |      |
| Integer.parseInt(str)     |      |
| Short.parseShort(str)     |      |
| Long.parseLong(str)       |      |
| Float.parseFloat(str)     |      |
| Double.parseDouble(str)   |      |

例外：<u>Character 类没有parseChar方法，要先转变成字符数组，然后取出字符</u>（如下例子）





```java
	int i=Integer.parseInt("156");
    double d=Double.parseDouble("4.53");
	boolean b=Boolean.parseBoolean("true");

	String s="c";
	char cc[]=s.toCharArray();
	char c=cc[0];
```

[parse与valueof](https://blog.csdn.net/jingshuigg/article/details/8633429?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=8aeeee03-a091-4280-a17f-043730f5640f&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control)

```java
Integer.valueof()返回的是Integer的对象。 
 Integer.parseInt() 返回的是一个int的值。
 Integer.valueof().intValue();返回的也是一个int的值。  
```

` public static int parseInt(String s, int radix) throws NumberFormatException `

`public static int parseInt(String s) throws NumberFormatException `

`public static Integer valueOf(String s, int radix) throws NumberFormatException `

`public static Integer valueOf(String s) throws NumberFormatException `





## 增强for

增强for循环(也称for each循环)是**JDK1.5**以后出来的一个高级for循环，专门用来**遍历**数组和集合的。它的内部原理其实是个Iterator迭代器，**所以在遍历的过程中，不能对集合中的元素进行==增删==操作。**

格式：

~~~java
for(元素的数据类型  变量 : Collection集合or数组){ 
  	//写操作代码
}
~~~

它用于遍历Collection和数组。通常只进行遍历元素，不要在遍历的过程中对集合元素进行增删操作。

#### 练习1：遍历数组

~~~java
public class NBForDemo1 {
    public static void main(String[] args) {
		int[] arr = {3,5,6,87};
       	//使用增强for遍历数组
		for(int a : arr){//a代表数组中的每个元素
			System.out.println(a);
		}
	}
}
~~~

#### 练习2:遍历集合

~~~java
public class NBFor {
    public static void main(String[] args) {        
    	Collection<String> coll = new ArrayList<String>();
    	coll.add("小河神");
    	coll.add("老河神");
    	coll.add("神婆");
    	//使用增强for遍历
    	for(String s :coll){//接收变量s代表 代表被遍历到的集合元素
    		System.out.println(s);
    	}
	}
}
~~~

> tips: 新for循环必须有被遍历的目标。目标只能是Collection或者是数组。新式for仅仅作为遍历操作出现。





## 单体程序设计

当且仅当要求一个类只能有一个实例对象时，才使用单体程序设计模式

- 构造方法私有 private  （）
- 实例对象私有   private static
- 设置返回对象函数 getObject()

注意实例对象可以先创建（在私有成员域直接new，也可以在getObject方法中用）

```java
public class J_Singleton {

    private static J_Singleton m_object;

    //不允许自行创建这个类的实力对象，因此用private
    private J_Singleton()
    {
    }

    public static J_Singleton mb_getObject()
    {
        if (m_object==null)
            m_object=new J_Singleton();
        return m_object;
    }


    public static void main(String[] args) {
        J_Singleton j_singleton1 = mb_getObject();
        J_Singleton j_singleton2 = mb_getObject();
        System.out.println(j_singleton1==j_singleton2);
    }
}
```

注意单体类不能派生出子类，因为构造方法是私有的



---

## break 标签

```java
	int h = 0;
     label3: 
		for (int k = 0; k < 5; k++) 
        {
           System.out.println("label3 第一层");
           for (int m = 0; m < 5; m++) 
           {
              System.out.println("label3 第二层");
              h++;
              if (m == 2) 
              {
                  break label3;
              }
              System.out.println(h);
           }
       }
```

```java
输出结果是：
    label3 第一层
    label3 第二层
    1
    label3 第二层
    2
	label3 第二层
```

> ==分析方法：这说明当*k=m*时，执行了*break*语句，跳转到了*label3*标签处，但是并没有在进入这个*for*语句块。==   continue 类似



又一个例子：

```java
public void breakLabelTest() {
     outer:
     for (int i = 0; i < 3; i++) {
         for(int j = 0; j < 5; j++){
             if(j==4){
                 break outer;
             }
             System.out.println(j);
         }
         System.out.println("test");
     }
     System.out.println("finish");
 }
0
1
2
3
finish
```





---

## 泛型

- 带泛型的**类**的定义格式

  **[类修饰词列表]	class	类名 <类型参数1......> 	[extends 父类名]  [implements 接口名称列表]**

  **{			类体			}**



- 带泛型的**接口**定义格式

  **[接口修饰词]	interface	接口名<类型参数1......>	[extends 接口名称]**

  **{			接口体			}**



其中：

**类型参数的定义格式：**

1. 类型变量标识符
2. 类型变量标识符 extends 父类型
3. 类型变量标识符 extends 父类型1 &父类型2.......











## JAVA的内存划分

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200505085952284.png" alt="image-20200505085952284" style="zoom: 80%;" />

![image-20200505091011653](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200505091011653.png)

![image-20200505091025396](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200505091025396.png)

![image-20200505091034166](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200505091034166.png)

![image-20200505092002054](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200505092002054.png)



## JVM

### 0、

[参考1：一文搞懂JVM内存结构，好文章](https://blog.csdn.net/rongtaoup/article/details/89142396?spm=1001.2101.3001.6650.14&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-14.highlightwordscore&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-14.highlightwordscore)  其中的局部变量表，操作数栈，Java堆和方法区讲得很好

[参考2【Java千问】你了解Java内存结构么（Java7、8、9内存结构的区别）](https://blog.csdn.net/laomo_bible/article/details/83067810)

[未看](https://www.cnblogs.com/czwbig/p/11127124.html)





[JVM有哪些](https://www.zhihu.com/question/29265430?sort=created)



[未看【JAVA核心】Java GC机制详解](https://blog.csdn.net/laomo_bible/article/details/83112622?spm=1001.2101.3001.6650.12&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBLOGCOLUMN%7Edefault-12.highlightwordscore&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBLOGCOLUMN%7Edefault-12.highlightwordscore)

[未看 通过图文给你讲明白java GC的垃圾回收机制](https://blog.csdn.net/future234/article/details/80677140?spm=1001.2101.3001.6650.10&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-10.opensearchhbase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-10.opensearchhbase)





### 1.前言

Java 虚拟机是中、高级开发人员必须修炼的知识，有着较高的学习门槛，很多人都不情愿去接触它。可能是觉得学习成本较高又或者是感觉没什么实用性，所以干脆懒得“搭理”它了。其实这种想法是错误的。举个最简单的例子，JVM 基本上是每家招聘公司都会问到的问题，它们会这么无聊问这些不切实际的问题吗？很显然不是。由 JVM 引发的故障问题，无论在我们开发过程中还是生产环境下都是非常常见的。比如 OutOfMemoryError(OOM) 内存溢出问题，你应该遇到过 Tomcat 容器中加载项目过多导致的 OOM 问题，导致 Web 项目无法启动。这就是JVM引发的故障问题。那到底JVM哪里发生内存溢出了呢？为什么会内存溢出呢？如何监控？最重要的就是如何解决问题呢？能解决问题的技术才是最实用最好的技术。然而你对JVM的内存结构都不清楚，就妄想解决JVM引发的故障问题，是不切实际的。只有基础打好了，对于JVM故障问题才能“披荆斩棘”。本文通过代码与图示详细讲解了JVM内存区域，相信阅读本文之后，你将对JVM内存的堆、栈、方法区等有一个清晰的认知。

#### 2. 运行时数据区

Java 虚拟机在执行 Java 程序的过程中会把它管理的内存划分为若干个不同的数据区域。每个区域都有各自的作用。

分析 JVM 内存结构，主要就是分析 JVM 运行时数据存储区域。JVM 的运行时数据区主要包括：堆、栈、方法区、程序计数器等。而 JVM 的优化问题主要在**线程共享**的数据区中：堆、方法区。

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220108183755966.png" alt="image-20220108183755966" style="zoom: 67%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220109125521430.png" alt="image-20220109125521430" style="zoom: 50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220109125652483.png" alt="image-20220109125652483" style="zoom:67%;" />



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220109125857893.png" alt="image-20220109125857893" style="zoom:50%;" />

### 2.1 程序计数器

程序计数器（Program Counter Register）是一块较小的内存空间，可以看作是当前线程所执行字节码的行号指示器，指向下一个将要执行的指令代码，由执行引擎来读取下一条指令。更确切的说，一个线程的执行，是通过字节码解释器改变当前线程的计数器的值，来获取下一条需要执行的字节码指令，从而确保线程的正确执行。

为了确保线程切换后（上下文切换）能恢复到正确的执行位置，每个线程都有一个独立的程序计数器，各个线程的计数器互不影响，独立存储。也就是说程序计数器是线程私有的内存。

如果线程执行 Java 方法，这个计数器记录的是正在执行的虚拟机字节码指令的地址；如果执行的是 Native 方法，计数器值为Undefined。

程序计数器不会发生内存溢出（OutOfMemoryError即OOM）问题。

### **2.2 栈**

#### 2.2.1 局部变量表

帧中，由一个局部变量表存储数据。局部变量表中存储了基本数据类型（boolean、byte、char、short、int、float、long、double）的局部变量（包括参数）、和对象的引用（String、数组、对象等），但是不存储对象的内容。局部变量表所需的内存空间在编译期间完成分配，在方法运行期间不会改变局部变量表的大小。

局部变量的容量以变量槽（Variable Slot）为最小单位，每个变量槽最大存储32位的数据类型。对于64位的数据类型（long、double），JVM 会为其分配两个连续的变量槽来存储。以下简称 Slot 。

JVM 通过索引定位的方式使用局部变量表，索引的范围从0开始至局部变量表中最大的 Slot 数量。普通方法与 static 方法在第 0 个槽位的存储有所不同。非 static 方法的第 0 个槽位存储方法所属对象实例的引用。



#### 2.2.2 操作数栈





### 2.3 Java堆

### **2.4 方法区（Method Area）**



## 异常处理

>  背景：一个程序中可能会遇到这样的情况：1、求商时除数为0       2、函数中非法的参数传递     3、想要从文件中读数据，首先要打开该文件，但是打开失败了，这时程序面对这种情况要处理（以前是用if else exit简单处理） 

因此采用异常处理机制可以使简化而且统一





- **异常的层次结构**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200329104213433.png" alt="image-20200329104213433" style="zoom: 67%;" />





- **异常的分类**

**异常**可分为 **受检异常**和**非受检异常**；

受检异常编译时可被检测，而非受检异常不能

非受检异常包括**运行时异常**（比如数组下标越界） 和 **错误**





- **异常是如何产生的**

1. 最常见的就是程序执行中，JVM自动发现的 （比如数组下标越界）

2. 显式的生成（手动）

   ​	其格式为**：**

   ​		**throw	类型变量**

   ​	注意其中类型变量时 java.lang.Throwable 的类型变量	

   ​	例子：

   ```java
   throw new ArithmeticException();
   ```

   ```java
   ArithmeticException e= new ArithmeticException( );
   throw e;
   ```

   

   ​	

   

- 异常该怎样处理

**一个程序需要处理 受检异常 和 运行时异常**

==自我理解==：~~受检异常必须要处理 否则无法编译，因此受检异常要用**try-catch** 或者**throws**处理掉    直接修改源码~~

​					~~但是运行异常是非受检的 是<u>可能出现</u>的，因此只能用**try catch** 或者让jvm自动管理~~

​					==**异常最终结束于 catch语句或者JVM**==



处理的方法 ： **捕捉** 或 **转移** 



1. **捕捉异常格式**

```java
try
{
    可能会产生异常的语句序列
}
catch(Exception1 e1)
{
    捕获之后的处理语句序列
}
catch(Exception1 e2)
{
    捕获之后的处理语句序列
}

..........
..........
finally
{
    无论如何最后都会被执行到的语句序列
    即使catch体中有return 也是还先执行finally
    但是 System.exit（0）除外
}
```

**注意点：try体有多个错误时，遇到第一个时就进入相应的catch体了，try后面的语句不再被执行**

**e1 e2 $\cdots$ en这些Exception类型的变量可能有父子关系， 也即都可匹配，这时的原则是 按照catch语句的先后顺序**



另外 java.lang.Exception 有成员方法 public void printStackTrace会输出错误追踪信息





2. **异常转移**

格式:

```java
public void method() throws Exception
{
    throw new Exception( );
}
```

**注意：运行时异常可以不必通过throws 关键字声明转移异常（因为RuntimeException是可能产生的）**





==异常的转移机制： 通过throws（也可能没有throws） 逐级向上寻找catch 或者 JVM==

==方法1 -> 方法2 -> main方法 ->JVM==







## 文件与数据流



- **原理图**（简言之，**传输需要流，而流是对象**）

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200406075307945.png" alt="image-20200406075307945" style="zoom: 50%;" />



- **输入流总体结构：**

![image-20200331090611006](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200331090611006.png)



- **输出流总体结构**

![image-20200331090614109](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200331090614109.png)





- 文件和标准输入输出要统一平等地看待，  文件结束符EOF== Contrl +Z/D 前者windows 后者Linux
- 
  - System.in 是 java.io.InputStream类型的变量（对象）              对应标准输入
  - System.out是 java.io.OutputStream类型的变量（对象）         对应标准输出
  - System.error是java.io.PrintStream类型的变量（对象）           对应标准错误输出流





### 对文件操作的步骤：

1. **创建输入\输出流或者读写器对象  （上面的那些标准的就不用再创建了，已经创建好了 ）**

2. **读写操作**

3. **close**







### 1、**输入流抽象父类InputStream**

- 成员方法： public abstract int **read ( )** throws IOException

  功能：从输入流读入一个字节，并返回其值，如果到达输入流末尾，则返回-1。

  注意：最好不要读中文

  须知：从标准输入中读取数据不是每输入一个字母就形成流，而是回车之后才形成流

  ==自己eclipse试验的时候 得出 InputStream只能用一次，也即当编译后第一次按下 Ctrl+Z才有效，若想再用一次还需要重新编译（这个重新编译，是彻底的编译，也即有修改源码）==
  
  理解：从输入流中读一个字节 并返回其值（int）  相当于流中每一个东西全部当成字符看待。也即如果文件内容是10， 返回的不是ASCII码为10的控制字符而是 先读取‘1’返回49 再读去0返回48，由此可见 read是逐个处理的！==也即 写操作是  程序中byte->文件中的字符 					读操作是 文件中单个字符->ASCII码==









​	下面的两个方法可以一次读入多个字节到**数组**中

- public int read ( byte[ ] data) throws IOException 

- public int read ( byte[ ] data, int offset, int length) throws IOException





- 成员方法：public void **close**( ) throws IOException

  功能：关闭流对象，并释放资源

注意：<u>子类皆可调用</u>



#### ①、子类FileInputStream

- 构造方法：public **FileInputStream** （String name）throws FIleNotFoundException

  功能：创建了“name”文件对应的输入流对象

  ==**<u>注意：  ！！！（经过尝试txt文件应该在工程名的下一级目录中）</u>**==但书上说的是<u>**该文件与源程序文件在同一个目录下。**</u>

  <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200406091216922.png" alt="image-20200406091216922" style="zoom: 67%;" />

例子参见：P203

==在idea编程时貌似根路径是工程的根路径也即==

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200618092331153.png" alt="image-20200618092331153" style="zoom: 67%;" />







### 2、输出流抽象父类OutputStream

- 成员方法：public void write ( byte [] b) throws IOException

  功能：将byte数组逐个字节写入文件
  
  假如byte数组存的是学生的成绩 分别是78 80 85 92想把他们存进文件中，可不那么容易，因为 byte是逐个字节写，也即 把78 80 85 92 对应的字符写进去，写完也只有四个字符进去而已。要想实现写成绩，要把他们拆分成一些字符，比如78 拆成 ‘7’ 和‘8’。







- 成员方法：public void write ( int b )throws IOException

  功能：将参数b的**低8位**写入到文件中

  注意：是低八位 所以char会刚好，int会截断

  区别：上面那个是写一堆，这个是写一个

- 成员方法： public void flush( ) throws IOExpection

  注意：因为计算机有缓存机制，所以调用write后，计算机不会立马将数据写入文件。

  作用：flush强制立即输出数据



- 成员方法：public void close ( ) throws IOException





#### ①、子类FileOutputStream

- 构造方法：public **FileOutputStream( String name )** throws FileNotFoundException

  作用：创建对象，覆盖文件内容



- 构造方法：public **FileOutputStream (String name,boolean append)** throws FileNotFoundException

  append为true时，流是接在文件已有内容的末尾的，也即追加 

  ​			 为false时，同上面，是覆盖

















## 数组

有.length

**一、动态初始化：**
**1）int [ ] a = new int [100];**
等价于：
int [ ] a;
a=new int [5];

**二、静态初始化：**
**2）int [ ] a = new int [ ] {1,2,3,4,5,6,7,8,9};**
等价于： 
int [ ] a;
a=new int[ ] {1,2,3,4,5};
**3）int [ ] a = {1,2,3,4,5,6,7,8,9};**
无等价形式

a.length  注意返回的是开辟的数组空间，





### 对象数组

[参考](https://blog.csdn.net/lxxiang1/article/details/82320720?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control)

数组一定要先开辟空间，但是因为其是引用数据类型，所以数组里面的每一个对象都是null值，则在使用的时候数组中的每一个对象必须分别进行实例化操作



S1**对象数组的声明**

类名称 对象数组名[] = new 类名称[长度];





在声明对象数组后 ，必须对每个数组成员进行实例化话 才能直接使用，否则报空指针异常！

S2**动态初始化**

```java
Person[] ps = new Person[3];  //此时ps[1]为null
Person p1 = new Person("jerry", 18);
Person p2 = new Person("tom", 20);
Person p3 = new Person("rose", 25); 
ps[0] = p1; // 实例化第一个元素
ps[1] = p2; // 实例化第二个元素
ps[2] =p3; // 实例化第三个元素
System.out.println("\n----------
```





## 图形用户界面设计

组件类的层次结构

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200414172202796.png" alt="image-20200414172202796" style="zoom: 50%;" />

JComponent——大多数Swing组件类父类

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200414172244743.png" alt="image-20200414172244743" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200418140719224.png" alt="image-20200418140719224" style="zoom: 67%;" />





**图形界面下程序设计的思路**

1. 创建窗口对象。
2. 创建（一个或者多个）组件对象，将组件对象加入窗口并且按照特定方式排列。
3. 定义组件对象（包括窗口对象）上的事件处理：即用户在组件上做某种操作，程序做出对应的响应（相应的方法被调用执行）。







**步骤：**

1. 创建**顶层容器对象**（JFrame/JDialog），设置参数
2. 调用顶层容器的**getContentPane**()获取**内容窗格对象**
3. 然后**调用窗格对象的setLayout（）**，指定内容窗格布局的参数(flowlayout)
4. 往内容窗格里**add组件**(JLabel)  （也即只能往内容窗格里加东西）



### 容器和组件

#### **JFrame**

**顶层容器**
构造方法： 
public JFrame() throws HeadlessException
public JFrame(String title) throws HeadlessException
成员方法：
public void **setDefultCloseOperation**(int operation)
public void **setSize**(int width, int height)
public void **setVisible**(boolean b)					//前两个可以放在任何位置，但是setVIsible要放在组件添加完毕后
public Container **getContentPane**()



#### **Container**

成员方法：
public void **setLayout**(LayoutManager mgr)
public void **add**(Component comp)

#### **FlowLayout**

构造方法：
public FlowLayout()
public FlowLayout(int align)



#### **JLabel**（标签）

单纯的一个标签，用于显示信息

构造方法：
public JLabel(String text)
public JLabel(Icon icon)
public JLabel(String text,Icon icon,int horizontalAlignment)
成员方法：
public void **setText**(String text)
public void **setIcon**(Icon icon)
public void **setHorizontalAlignment**(int alignment)
public void **setHorizontalTextPosition**(int textPosition)
public void **setVerticalAlignment**(int alignment)
public void **setVerticalTextPosition**(int textPosition)
public void **setToolTioText**(String text)



==下面俩组件主要用于编辑显示单行文本==

#### **JTextField**

显示单行文本
构造方法：
public JTextField()
public JTextField(String text)
public JTextField(int columns)
public JTextField(String text, int columns)

#### **JPasswordField**

构造方法：
public JPasswordField()
public JPasswordField(String text)
public JPasswordField(int columns)
public JPasswordField(String text, int columns)

成员方法：
public String **getText()**获取文本框（密码框）中文本
public void **setText(**String t)设置文本框（密码框）中文本。
public void **setEditable**(boolean b)



==以下是对话框==

#### **JDialog**

**顶层容器**  (要是需要在对话框中自己构建一些复杂的文字、图像时，用JDialog否则建议用JOptionPane)
对话框用来设计具有依赖关系的窗口，通常在已有的窗口上再打开一个附属的新窗口使用对话框。
有依赖关系（可以往里面加组件）
构造方法：
public JDialog(Dialog owner,String title,boolean modal)
public JDialog(Frame owner,String title,boolean modal)
有模式的对话框必须响应，它关闭后父窗口才能回到激活状态；无模式的对话框不要求。
成员方法：
public void **setSize**(int width, int height)
public void **setVisible**(boolean b)
public Container **getContentPane**()

#### **JOptionPane：**

提供标准风格的对话框。
静态方法：
消息对话框
public static void **showMessageDialog**(Component parentComponent, Object message) throw HeadlessException
public static void **showMessageDialog**(Component parentComponent, Object message, String title, int messageType) throw HeadlessException
public static void **showMessageDialog**(Component parentComponent, Object message, String title, int messageType, Icon icon) throw HeadlessException

确认对话框
public static int **showConfirmDialog**(Component parentComponent, Object message) throw HeadlessException
public static int **showConfirmDialog**(Component parentComponent, Object message, String title, int optionType) throw HeadlessException
public static int **showConfirmDialog**(Component parentComponent, Object message, String title, int optionType, int messageType) throw HeadlessException
public static int **showConfirmDialog**(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon) throw HeadlessException

文本框输入对话框
public static String **showInputDialog**(Component parentComponent, Object message) throw HeadlessException
public static String **showInputDialog**(Component parentComponent, Object message, Object initialSelectionValue) throw HeadlessException
public static String **showInputDialog**(Component parentComponent, Object message, String title, int messageType) throw HeadlessException

选择输入对话框
public static Object **showInputDialog**(Component parentComponent, Object message, String title, int messageType, Icon icon, Object [] selectionValues, Object initialSelectionValue) throw HeadlessException
**messageType为消息类型：**
        J_OptionPane.ERROR_MESSAG(错误消息)、  
       J_OptionPane.INFORMATION_MESSAG(信息消息)、 
       J_OptionPane.WARNING_MESSAG(警告消息)、
       J_OptionPane.QUESTION_MESSAG(疑问消息) 、
       J_OptionPane.PLAIN_MESSAG(其他消息)。



==以下是按钮组件==

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200418142130435.png" alt="image-20200418142130435" style="zoom: 59%;" />

#### **JButton**

命令式按钮
构造方法：
public JButton()
public JButton(Icon icon)
public JButton(String text)
public JButton(String text, Icon icon)



#### **JCheckBox（复选框）**

复选框， 可多选，可不选   形状是**方**的
构造方法：
public JCheckBox()
public JCheckBox(Icon icon)
public JCheckBox(Icon icon, boolean selected)
public JCheckBox(String text)
public JCheckBox(String text, boolean seclected)
public JCheckBox(String text, Icon icon)
public JCheckBox(String text, Icon icon, boolean seclected)

#### **JRadioButton（单选按钮）**

单选按钮 ，形状是**圆**的， 只有当加入到按钮组之后才是  有且只能选一个；不加入的话，和复选框除了形状以外一样可设置初始选项
构造方法：
public JRadioButton()
public JRadioButton(Icon icon)
public JRadioButton(Icon icon, boolean selected)
public JRadioButton(String text)
public JRadioButton(String text, boolean seclected)
public JRadioButton(String text, Icon icon)
public JRadioButton(String text, Icon icon, boolean seclected)

<u>二者都有的成员方法</u>
public void setSelected(boolean b)
public boolean isSelected()



#### **ButtonGroup**

单选按钮既要加入到内容窗格(对象)中 也要  加入到按钮组（对象）中，不能只加一个按钮组
public ButtonGroup()
public void add(AbstractButton b)向按钮组中加入单选按钮。

```java
JRadioButton [] r= {
				new JRadioButton("左"),
				new JRadioButton("右")
		};
		r[0].setSelected(true);
		r[1].setSelected(false);
		ButtonGroup rg=new ButtonGroup();
		for(int i=0;i<r.length;i++)
		{
			c.add(r[i]);	
			rg.add(r[i]);
		}
```





==以下是可以显示多行信息的组件==

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200418143511319.png" alt="image-20200418143511319" style="zoom: 67%;" />

#### JCombobox（下拉式列表)

组合框（下拉式列表）
构造方法
public JComboBox(Object [] items)
成员方法
public void **setEditable**(boolean flag)
public void **setMaximumRow**Count(int count)
		设置组合框的下拉式列表中显示的最大行数，如果组合框选项超出count，则自动加上滚动条。
public void **setSelectedIndex**(int anIdex)
   	 设置被选中的选项。
public void **setSelectedItem**(Object anObject)
  	  设置被选中的选项，anObject为选项文本。
public int **getSelectedIndex**()
   	 返回被选中的选项的索引。
public object **getSelectedItem**()
  	  返回被选中的选项文本。
public object [] **getSelectedObjects**()
 	   返回所有被选中的选项文本。因为组合框只有一个选项可以被选中，所以效果等同上一个方法。



#### JList（列表框）

列表框：显示一组列表项
构造方法
public JList(Object [] listData)
成员方法：
public void **setSelectionMode**(int selectionMode) 设置列表框的选择模式：Javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION*只能选中一个选项。
Javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION可以选中一个或多个一个选项（通过Ctrl或shift组合键）。
public void **setSelectedIndex**(int anIdex)
设置一个选项被选中。
public void **setSelectedIndices**(int [] indices)
设置多个选项被选中。
public void  **setSelectedInterval**(int anchor, int lead)
设置多个选项被选中，从索引为anchor到lead。
public int **getSelectedIndex**()
返回被选中的选项的索引最小的项的索引值。
public int [] **getSelectedIndices**()
返回所有被选中的选项的索引。
public Object **getSelectedValue**()
返回被选中的选项的索引最小的项的文本。
public Object [] **getSelectedValues**()
返回所有被选中的选项数组。



#### **JTextArea(文本区)**

<u>多行</u>文本框（滚屏要另加）
构造方法
public **JTextArea**(String text, int rows, int columns)
text为初始文本；rows和columns为文本区的行数和列数。

文本区不能滚屏，即文本如果超出文本区大小之后不能显示为了显示所有内容，可以把文本区加入一个**滚动窗格(JScrollPane)**，从而实现给文本区加入滚动条的目的
public **JScrollPane**(Componet view)
view为需要加入滚动条的对象，即文本区对象。
<u>创建滚动条对象，把JTextAera对象放进去，然后再把滚动条对象放到Container对象里</u>  //JTextArea就不需要放了

```Java
JTextArea ta=new JTextArea("1王晨王晨哈么\n 2 \n 3 \n 4 \n 5", 3, 10);
JScrollPane sta=new JScrollPane(ta);
c.add(sta);
```









#### **JSlider**(滑动条)

以图形的方式进行数值选取（用鼠标移动滑动条中的滑动块）也可以表示执行的进度条
构造方法
public **JSlider**(int min, int max, int value)
public **JSlider**(int orientation, int min, int max, int value)
orientation为javax.swing.JSlider.HORIZONTAL，代表水平方向滑动条；为javax.swing.JSlider.VERTICAL代表竖直方向的滑动条。默认为水平方向的。
成员方法
public void **setValue**(int n)设置滑动块位置。
public int **getValue**()返回滑动块当前位置。



#### **JPanel**（面板）
一种容器，可以往里面添加各种组件–面板自身不可见，不含组件时默认大小为宽度高度均为零。面板(JPanel)的大小由它所包含的组件决定。当组件个数增加，面板(JPanel)也会随之而增大
构造方法：
public **JPanel**()

成员方法
public void **setPreferredSize**(Dimension preferredSize)
				public Dimension(int width, int height)Dimension类构造方法，width为宽度，height为高度。成员方法

public **setBackground**(Color bg)





#### 小结

理解：容器（顶级容器：JFrame、JDialog 一般容器：JPanel）里加组件，顶层容器不可加入到其他容器（主窗口）

容器、内容窗格、布局方式，组件这些都是对象，需要手动创建，容器也是一种组件

---





### 布局管理器

用来控制组件在容器中的布局方式

FlowLayout		流布局管理器

GridLayout		网格布局管理器

BorderLayout 	边界布局管理器

BoxLayout		盒式布局管理器

GridBayLayout  网格包布局管理器

CardLayout		卡片布局管理器



另外：

组合布局方式：容器之间的嵌套，也即将一些容器当做组件嵌入其他容器中，  Jpanel类型的组件常常扮演这种中间容器的角色，起到桥梁的作用。

自定义布局方式：类要实现接口 LayoutManager 或 LayoutManager2







---

### 事件处理模型

#### 总结：

理解： 组件按钮等一些东西 被称为事件源， 点了一下，输入了一些东西，产生了事件对象。监视器要对事件对象处理



思路步骤：找到事件源，确定事件源能产生什么事件？ 根据事件确定应该要实现的监视器接口或适配器抽象类，然后**实现之**（事件的处理方式），然后利用之**创建监视器对象**，然后给**事件源add监视器对象**

实现监视器接口或适配器抽象类的方式是  1.定义类 2.匿名内部类  实现里面的方法时要注意：方法的参数是~~Event,  在方法体中 要调用getsource方法 获取到事件源，然后就可以操作事件源了

比如： 我单击了一下button，  它就是事件源，它产生的是ActionEvent类型的事件。我需要实现（定义处理方式）ActionEvent对应的监视器ActionListener（中的抽象方法） 或适配器 来捕获（处理）这个事件，实现了之后，调用button对象的addActionListener方法，把监听器对象传进去



#### **ActionEvent**（动作事件） 

可以产生事件的组件：JButton 	JTextField 	JPasswordField  单击按钮 文本编辑回车
成员方法：
public Object getSource（）
public String getActionCommand（）

**ActionListener**（动作事件监听器接口）
有抽象方法：actionPerformed
public interface ActionListener extends EventListener
{
public void actionPerformed(ActionEvent e)
}







#### **ItemEvent**(项事件)

可以产生事件的组件：JCheckBox、JRadioButton、JComboBox	单击复选框、单选按钮、组合框引起状态改变
成员方法：
public Object getSource（）

**ItemListener**（项事件监视器接口）
有抽象方法：itemStateChanged
public interface ItemListener extends EventListener
{
public void itemStateChanged(ItemEvent e)
}







#### **ListSelectionEvent**（列表选择事件）

可以产生事件的组件：JList    单击列表框
成员方法：
public Object getSource（）

**ListSelectionListener**（列表选择事件监听器接口）
有抽象方法：valueChanged
public interface ListSelectionListener extends EventListener
{
void valueChanged(ListSelectionEvent e)
}







#### **DocumentEvent**(文档事件)

可以产生事件的组件：JTextField、JPasswordField、JTextArea  。
他们有成员方法
public Document getDocument()

**DocumentEvent有成员方法：**
Document getDocument()
int getLength()
String getText(int offset ,int length ) throws BadLocationException

**DocumentListener**（文档事件监听器接口）
有抽象方法：changedUpdate、insertUpdate、removeUpdate
public interface DocumentListener extends EventListener
{
void changedUpdate(DocumentEvent e)
void insertUpdate(DocumentEvent e)
void removeUpdate(DocumentEvent e)
}

**Document的成员方法：**
addDocuemntListener(DocumentListener)







---

### 鼠标事件处理



**MouseEvent**							  MouseListener、														 **MouseAdapter**       **鼠标事件**
**MouseEvent**							  MouseMotionListener、MouseMotionAdapter            **MouseAdapter**     **鼠标移动事件**
**MouseWheelListener**				MouseWheelListener                                                   **MouseAdapter**     **鼠标滚轮事件**





























## 多线程

#### 概念：

**并发**：指两个或多个事件在同一个时间段内发生。						交替执行
**并行**：指两个或多个事件在同一时刻发生（同时发生）。          同时执行     多核CPU



**进程**：是指一个内存中运行的应用程序
**线程**：线程是进程中的一个执行单元，负责当前进程中程序的执行，<u>一个进程中至少有一个线程</u>。



**分时调度**
所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间。
**抢占式调度**
优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个(线程随机性)，Java使用的为抢占式调度。

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200503090639173.png" alt="image-20200503090639173" style="zoom: 50%;" />







#### 小结：

线程是一个对象，需要创建

Thread类或其子类的实例对象 是java的一个线程，需要调用start方法开启。
当new 一个Thread类或其子类的对象时，线程就就进入了新生态。start后，才进入就绪态。一个线程进入到就绪态之后 紧接着就被JVM调度了，JVM可以选择一个就绪态的线程使其进入运行态







#### 类和方法

**Runable**
唯一的成员方法
void run()



**Thread类**
构造方法：
public Thread(Runnable target)
public Thread()

成员方法：
public void run()
public void start()
public final boolean isDaemon()
public final void setDaemon(boolean on)
静态方法：
public static void sleep(long millis) throws InterruptedException

成员方法：
public final ThreadGroup getThreadGroup()	//返回该线程在的线程组
public final String getName()							//返回该线程的名字

静态方法：
public static int activeCount()            //当前线程组的线程个数
public static Thread currentThread() //返回当前线程 

成员方法：
public final int getPriority()
public final void setPriority(int newPriority)



**ThreadGroup**
成员方法：
public final ThreadGroup getParent()	//返回该线程组的父线程组
public final String getName()				//返回该线程组的名称
public int activeCount()							//当前线程组以及以下各线程组的个数
public int enumerate(Thread []list)
public int enumerate(ThreadGroup []list)

成员方法：
public final int getMaxPriority()  //返回该线程组所允许的最大优先级
public final void setMaxPriority(int pri)



#### 多线程共享内存引发问题的原因：

当第一个线程对一个共享的变量的访问是多次的，但是在这些访问过程中，另一个线程访问了变量，并又改变了它，那么第一个线程中所访问的变量就出现了改变从而出错。



#### 同步原理



==JVM为**每个对象**都配备了**一把锁**和**一个等候集**  ，JVM确保在同一时刻最多只有一个线程能运行与该对象相关联的同步方法和同步语句块== (即使同步方、块中无共享内存的行为)
自己的理解： 在JAVA多线程程序中（多个线程start），有内存共享问题出现时，要实现同步处理，实现的方法是对象锁，也即一个对象（实例对象或类对象）可以成为同步方法、语句块的锁，通过这个对象来限制某线程的该对象的同步方法、语句块的执行

一个类的**静态成员域**与和**静态成员方法**			属于		**类对象**
一个类的**非静态成员域**和**非静态成员方法**	属于		**实例对象**              谁调用这个方法，谁就是锁对象



**wait（）**
只能在同步方法、语句块中调用
当在一个线程中执行到与一个**对象**相关联的同步方法或同步语句块，且调用wait方法时，该线程进入该**对象**的等候集（换句话说，在**对象**的等候集中的线程是在执行该**对象**的同步方法或同步语句块时调用了wait方法的线程）

**notify()**
同样只能在同步方法、语句块中调用，而且激活的线程只能是所关联的对象的等候集中的线程



在同步语句块中，要让引用类型的表达式所指向的对象为类对象可以通过类java.lang.Class成员方法
public static Class forName(String className) throws ClassNotFoundException 









同时要注意 有可能产生的死锁问题







#### 同步处理的方法：

1. **同步方法**		Synchronized methods
2. **同步语句块**     Synchronized block
3. ~~lock锁~~



**同步方法的使用说明：**

1. 首先要知道 基本格式是 

   - 静态		public static synchronized void method1 ( para )         属于类对象
   - 非静态     public  synchronized void method2 ( para )                 属于实例对象

   他们的定义是存在于类中的 ，不需要在run方法中定义，~~一般是直接通过类名或者实例对象调用，也~~    可以在run方法中通过对象调用

**同步语句块的使用说明：**

1. 基本格式是： 
   synchronized( 对象 )
   {                        }
2. 注意 它是在run方法才能使用的



#### 理解：

1. 所有**线程对象**，必定是**Thread类或其子类的对象**，（**使用Runable接口的类，并不是线程对象，它只能重写run方法，最后还要交给Thread类对象来start**       也即只有Thread类和子类才有start方法）
2. 要想同步访问一个数据，要怎样做？ 
     先在Thread或其子类中创建**一个成员域**，然后重写Thread或其子类的构造方法，这样就可以给Thread传进**这个成员域对应的对象**。这样只要 new thread（同一个对象）就可访问同一个变量了。
     另外，在实现Runabble接口的类中定义一个成员域，然后把这个类作为target，使用thread的构造方法，传入同一个target
     另外，同时访问一个类的静态成员域也可以
3. 分析问题的时候，从run方法开始想



#### Lock锁

![image-20200617161311342](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200617161311342.png)

![image-20200617161343117](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200617161343117.png)





## 网络编程：

有关TCP/IP UDP TCP     [知乎](https://zhuanlan.zhihu.com/p/24860273)               [百度百科](https://baike.baidu.com/item/TCP/IP%E5%8D%8F%E8%AE%AE/212915)

Client 客户端
Server 服务器
protocol 协议

UDP	User Datagram Protocol			用户数据报协议
TCP	Transmission Control Protocol	传输控制协议

Socket 套接字 
是一个通用的网络编程接口，它描述了一个连结的一个**端点**，提供网络应用程序中所用到的**网络地址和端口号信息**  
（Socket类 表示客户端的一个类）
（SeverSocket 表示服务器的一个类）





ip地址与域名是一对多的关系。一个ip地址可以对应多个域名，但是一个域名只有一个ip地址。ip地址是数字组成的，不方便记忆，所以有了域名，通过域名地址就能找到ip地址。

在Internet上域名与IP地址之间是一对一（或者多对一）的，域名虽然便于人们记忆，但机器之间只能互相认识IP地址，它们之间的转换工作称为域名解析，域名解析需要由专门的域名解析服务器来完成，DNS就是进行域名解析的服务器。域名的最终指向是IP。

 http://zhidao.baidu.com/question/14674128.html 是URL
zhidao.baidu.com就是域名
220.181.18.110 就是IP地址



**InetAddress 类的对象** 负责记录网络地址（IP或域名）和一些信息， 因此可以使用它来记录

静态方法：   （用以获得InetAddress对象）
public static InetAddress getLocalHost() throws UnknownHostException
public static InetAddress getByAddress( byte[ ] addr ) throws UnknownHostException
public static InetAddress getByName(String host) throws UnknownHostException

成员方法 
public String getHostAddress( )
public String getHostName( )







#### 一、URL

（统一资源定位符）Uniform Resource Locator 

##### **1、URL书写格式：  **

协议：//主机 ：端口号 / 文件 #引用

- **协议**： 指的是获取网络资源的网络传输协议 例如HTTP(Hypertext Transfer Protocol超文本传输协议) FTP（File Transfer Protocol 文件传输协议）
- **主机**：主机名=计算机名+域名       
  - 如166.111.4.100 或 www.tsinghua.edu.cn   www是提供服务的机器的名字（计算机名）                     
  - 另外一个例子：   http://blog.sina.com.cn/中，blog是提供博客服务的那台机器的名字，sina.com.cn是域名，blog.sina.com.cn是主机名。
  - url中，www一般表示提供web服务的计算机
  - 域名还分级，从后往前级别依次降低，sina.com.cn中，cn是顶级域名，表示中国，com是二级域名，表示商业机构（commercial），sina是三级域名，一般用自己的名字。
- **文件**：除了普通的文件之外 还可以是路径 
- **引用**： 是指向文件内部的某一节的指针

**例子**：http://www.ncsa.uiuc.edu:8080/demoweb/urlprimer.html#INSTALL
协议为 http 主机是 www.ncsa.uiuc.edu 端口号是8080 文件为 /demoweb/urlprimer.html 引用为INSTALL

默认端口号是80

##### **2、URL类**的对象负责记录 URL

构造方法：
public URL(String spec) throws MalformedURLExceotion  // spec为URL字符串

成员方法：
public String getProtocal( )
public String getHost( ) 
public int getPort( )  			//若URL没有设置则返回 -1
public  String getFile()		 //null
public String getRef() 		//null

##### 3、通过统一资源定位地址获取网络资源

URL 有成员方法： openStream













### 二、InetAddress类

静态方法
public static InetAddress getLocalHost（） 
public static InetAddress getByAddress(byte[ ] addr)
public static InetAddress getByName(String host)

成员方法
public String getHostAddress()
public String getHostName()

 三、









## 数据库程序设计

```java
public static void main(String args[ ])    
{
    try       
    {
        // 加载驱动程序
        Class.ForName(“com.mysql.jdbc.Driver”);
        // 通过数据源与数据库建立起连接
        Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/数据库名","用户名", "密码");
        Statement s=c.createStatement( ); // 创建SQL语句对象
        s.executeUpdate(
                "create table 学生成绩( " +
                "学号 integer CONSTRAINT authIndex PRIMARY KEY, " +
                "姓名 char(20), " +
                "成绩 integer)");  // 创建数据库表: 学生成绩
        s.close( );
        c.close( );

     }
     catch (Exception e)
    {
        System.err.println("异常: " + e.getMessage( ));
    } // try-catch结构结束
} // 方法main结束
                                                  
                                                  
                                                  
                                                  
 public static void main(String args[ ])    
  {
     try        
     {
        // 加载驱动程序
         Class.ForName(“com.mysql.jdbc.Driver”);
         // 通过数据源与数据库建立起连接
          Connection c  = DriverManager.getConnection("jdbc:mysql://localhost:3306/数据库名","用户名", "密码");            
         Statement s=c.createStatement( ); // 创建SQL语句对象   
         s.executeUpdate("drop table 学生成绩"); // 删除数据库表: 学生成绩
            s.close( );
            c.close( );
            System.out.println("删除数据库表: 学生成绩");
        }
        catch (Exception e)
        {
            System.err.println("异常: " + e.getMessage( ));
        } // try-catch结构结束
    } // 方法main结束
```





# 二、自己的一些实验和总结

## 在方法中创建对象

- 注意 可以在子函数中创建对象然后返回引用，这时对象不会在堆中被回收

```java
public class Demo03 
{
	public static void main(String []args)
	{
		
		String string="1998";
		byte [] temp=toByte(string);  // 不会被回收
		for (byte b : temp) 
        {
			System.out.println(b+" ");
		}
	}

    //string -》 byte[] 函数
	public static byte[] toByte(String s)
	{
		byte []temp=new byte[s.length()]; //函数中创建对象
		for(int i=0;i<s.length();i++)
		{
			temp[i]=(byte) ((byte) s.charAt(i)-'0');
		}
		return temp;
	}
	
	
}
```









## 在方法中 使用引用类型作为参数

- String类型

```java
public class Demo03 {
	public static void main(String []args)
	{
		String string="1998";
		System.out.println(string);// 结果1998
        
		ChangeString(string);//调用
		System.out.println(string);//	结果1998
	}
    
	public static void ChangeString(String s)
	{
		s="a"+s+"AAA";
		System.out.println(s); // 结果a1998AAA
	}

}
```

**这个程序的执行过程：** 

- 创建String对象“1998” 然后用string引用它
- 然后string作为实参调用函数ChangeString
- 然后形参s获得值后同样指向“1998”  然后通过表达式s="a"+s+"AAA" 形参指向了“a1998AAA”
- 函数Changestring输出形参指向的“a1998AAA”
- mian方法输出string指向的“1998”
- 程序结束

**小结：** string类型作为实参 不会对实参引用对象有任何影响，因为string类型对象一旦创建就不再改变。

实参string  和  形参s  都指向堆中的 “1998” 但是 形参在函数中改变了指向，而指向了“a1998AAA”





- 数组类型

```java
public class Demo04 {
	public static void main(String []args)
	{
		char [] chararr= {'W','A','N','G'};
		for (char c : chararr) {
			System.out.print(c+" ");	//结果： W A N G
		}
		System.out.println();
		
		ChangeArr(chararr);//调用
		for (char c : chararr) {
			System.out.print(c+" ");	//结果： $ $ $ $
		}	
	}
	
	
	public static void ChangeArr(char []arry)
	{
		arry[0]='$';//访问栈中同一区域
		arry[1]='$';
		arry[2]='$';
		arry[3]='$';
	}
}

```

**综上总结：**

String类型对象不可改变 要想改变引用变量指向的string对象，只能改变引用

因此，引用string的变量做实参 只能单纯的传递一个引用不能改变什么东西



**另外：**

- java中没有C++中的引用
- 因此java基本数据类型 不能通过方法实现值交换或改变  （C++中可以通过 Swap(int &a,int &b)来实现）
- java引用类型通过方法 传递引用是可以改变实参对象的（注意String的特殊性）

---









## 格式化输出

```java
import java.text.DecimalFormat;  
  
public class Main {  
    public static void main(String[] args) {  
               DecimalFormat df = new DecimalFormat( "0.00"); //设置double类型小数点后位数格式
               double d1 = 2.1;
               double d2 = 3.45678;
               System.out.println(df.format(d1)); //将输出2.10
               System.out.println(df.format(d2)); //将输出3.46（四舍五入）
        }  
}  
```







```java
public class TestNumber {
    public static void main(String[] args) {
        int year = 2020;
        //左对齐，补0，千位分隔符，小数点位数，本地化表达

          
        //直接打印数字
        System.out.format("%d%n",year);//2020             后面没有占位
        //总长度是8,默认右对齐
        System.out.format("%8d%n",year);//    2020
        //总长度是8,左对齐
        System.out.format("%-8d%n",year);//2020xxxx		后面4个x是占位    	
        //总长度是8,不够补0
        System.out.format("%08d%n",year);//00002020
        //千位分隔符
        System.out.format("%,8d%n",year*10000);//20,200,000
        //保留5位小数
        System.out.format("%.5f%n",Math.PI);//3.14159
    }
}
```

```java
public class Main  
{  
    public static void main(String[] args)  
    {  
        // 定义一些变量，用来格式化输出。  
        double d = 345.678;  
        String s = "你好！";  
        int i = 1234;  
        // "%"表示进行格式化输出，"%"之后的内容为格式的定义。  
        System.out.printf("%f", d);// "f"表示格式化输出浮点数。  
        System.out.println();  
        System.out.printf("%9.2f", d);// "9.2"中的9表示输出的长度，2表示小数点后的位数。  
        System.out.println();  
        System.out.printf("%+9.2f", d);// "+"表示输出的数带正负号。  
        System.out.println();  
        System.out.printf("%-9.4f", d);// "-"表示输出的数左对齐（默认为右对齐）。  
        System.out.println();  
        System.out.printf("%+-9.3f", d);// "+-"表示输出的数带正负号且左对齐。  
        System.out.println();  
        System.out.printf("%d", i);// "d"表示输出十进制整数。  
        System.out.println();  
        System.out.printf("%o", i);// "o"表示输出八进制整数。  
        System.out.println();  
        System.out.printf("%x", i);// "x"表示输出十六进制整数。  
        System.out.println();  
        System.out.printf("%#x", i);// "#x"表示输出带有十六进制标志前缀。  
        System.out.println();  
        System.out.printf("%s", s);// "d"表示输出字符串。  
        System.out.println();  
        System.out.printf("输出一个浮点数：%f，一个整数：%d，一个字符串：%s", d, i, s);  
        // 可以输出多个变量，注意顺序。  
        System.out.println();  
        System.out.printf("字符串：%2$s，%1$d的十六进制数：%1$#x", i, s);  // "X$"表示第几个变量。     　  double x = 2.0 / 3;
		System.out.format("%n%s", Integer.toBinaryString(8));//输出二进制
　　}
}
```

> 总结，使用format printf 后就可以类似C语言那样了，
>
> 1. 有%d %f %s %o %x   
> 2. 加 n.m 输出n位，包括m位小数  
> 3. 加.m 输出m位小数
> 4. 加一个' 数字 '表示占多少位，默认右对齐
> 5. 加 '0'表示补0
> 6. 加 '-' 表示左对齐 
> 7. 加'+-'表示输出带正负号，
> 8. 加 ‘,’输出千位分隔符
> 9. 加'#'输出前缀 
> 10. 用'$'实现不同参数顺序
> 11. 二进制用Integer的静态方法











## 静态方法和非静态方法的调用

最近突然不明白，为什么在主函数也即(public static void main函数中)为什么不能调用在同一个类中定义的一个非静态方法，如下代码

```Java
public class ttest{
    int score;
    
    public static void main(String []args)
    {
        sout("hello");
        method();
    }
    
    public method()
    {
        sout("this is a non-static method");
    }
}
```

然后就报错了。 我之所以想错的原因是 幻想它们在同一个类中，调用一下没什么关系，但是实际上并不行。
首先我们要知道主函数也是函数，是一个**静态**公共的函数

 因为静态方法属于类，在其他外界类使用静态方法时，要以类名.静态方法名的形式调用；而非静态方法，要通过对象名.方法名的形式来调用。
 ~~在同一个类中，非静态方法是无法直接调用静态方法的，而只可以调用非静态方法；而非静态方法可以直接调用静态和非静态方法~~

同理，静态方法只能访问静态成员域，而不能访问

(因此 要想实现C++中写算法常用的习惯，可以 在类中定义静态变量（类似C++全局变量）在类中定义静态成员函数（类似C++的子函数）这样就可以拥有了C++的刷题模式)



1 java类中的静态方法 只能调用类中的静态方法； 2 java类中的非静态方法可以调用类中的非静态方法和静态方法。下面是具体的代码说明。

2 静态static方法中不能调用非静态non-static方法，准确地说是不能直接调用non-static方法。但是可以通过将一个对象的引用传入static方法中，再去调用该对象的non-static方法。

3 静态方法是属于类的，即静态方法是随着类的加载而加载的，在加载类时，程序就会为静态方法分配内存，而非静态方法是属于对象的，对象是在类加载之后创建的，也就是说静态方法先于对象存在，当你创建一个对象时，程序为其在堆中分配内存，一般是通过this指针来指向该对象。静态方法不依赖于对象的调用，它是通过‘类名.静态方法名’这样的方式来调用的。而对于非静态方法，在对象创建的时候程序才会为其分配内存，然后通过类的对象去访问非静态方法。因此在对象未存在时非静态方法也不存在，静态方法自然不能调用一个不存在的方法。

[关于null的一些理解](https://blog.csdn.net/shelbyandfxj/article/details/69677823?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2)



## 计算程序运行时间

public static long	currentTimeMillis()	返回以毫秒为单位的当前时间。
public static long	nanoTime()	返回最准确的可用系统计时器的当前值，以微秒为单位。

使用案例
毫秒为单位：

```        JAVA
System.out.println("执行代码块/方法");
long endTime=System.currentTimeMillis();
System.out.println("程序运行时间： "+(endTime - startTime)+"ms");
long startTime=System.currentTimeMillis();
```

纳秒为单位：

```JAVA
long startTime=System.nanoTime(); 
System.out.println("执行代码块/方法");
long endTime=System.nanoTime(); 
System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
```




## 产生随机数

Java产生随机数的三种方式
在Java中，随机数的概念从广义上讲，有三种。
1、通过System.currentTimeMillis（）来获取一个当前时间毫秒数的long型数字。   （不多说了，主要是下面的）
**2、通过Math.random（）方法返回一个0到1之间的double值。**
**3、通过Random类来产生一个随机数，这个是专业的Random工具类，功能强大。**



### 1、Math.random（）方法

Math.random（）方法是 Java 的一个静态方法，返回一个0到1之间，前闭后开区间的double值。[0, 1)

```JAVA
(int)(Math.random()*10） 返回0到9的随机整数。
(int)(Math.random()*n) 返回0到n的随机整数。
(int)(Math.random()*100）+1 返回1到100之间的随机整数，前面返回0到99之间的随机数，加1就成了1到100之间的随机数。
```





### 2、Random类

Random 类是 Java 的 util 包中的一个类。

一、Random类使用说明

Random类使用的根本策略是分带种子和不带种子的Random的实例。通俗说，两者的区别是：带种子的，每次运行生成的结果都是一样的。不带种子的，每次运行生成的都是随机的，没有规律可言。

**创建不带种子的Random对象**
**Random random = new Random（）；**使用一个和当前系统时间对应的相对时间有关的数字作为种子数。

**创建带种子的Random对象有两种方法：**
**1） Random random = new Random（10）；**
**2） Random random = new Random（）；random.setSeed（10）；**

种子的作用是什么？
　　种子就是产生随机数的第一次使用值,机制是通过一个函数,将这个种子的值转化为随机数空间中的某一个点上,并且产生的随机数均匀的散布在空间中。以后产生的随机数都与前一个随机数有关。

```java
public static void main(String[] args)
{    
　　Random r = new Random(1);
　　for(int i=0 ; i<5 ;  i++)
　　{
　　　　int ran1 = r.nextInt(100);
　　　　System.out.println(ran1);
　　}
}//在我的编译器下多次运行产生的五个数均为85,88,47,13,54，如果采用Random r = new Random()，产生的随机数就不同，这就是确定种子导致的结果。
```



二、下面是Java.util.Random类的方法摘要
**protected int next(int bits)**：		
生成下一个伪随机数。

**boolean nextBoolean()**：			
返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的boolean值。

**void nextBytes(byte[] bytes)**：
生成随机字节并将其置于用户提供的 byte 数组中。

**double nextDouble()**：	
返回下一个伪随机数，它是取自此随机数生成器序列的、在0.0和1.0之间均匀分布的 double值。

**float nextFloat()**：
返回下一个伪随机数，它是取自此随机数生成器序列的、在0.0和1.0之间均匀分布float值。

**double nextGaussian()**：
返回下一个伪随机数，它是取自此随机数生成器序列的、呈高斯（“正态”）分布的double值，其平均值是0.0标准差是1.0。

**int nextInt()**：
返回下一个伪随机数，它是此随机数生成器的序列中均匀分布的 int 值。

**int nextInt(int n)**：
返回一个伪随机数，它是取自此随机数生成器序列的、在（包括和指定值（不包括）之间均匀分布的int值。

**long nextLong()**：
返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 long 值。

**void setSeed(long seed)**：
使用单个 long 种子设置此随机数生成器的种子。

总结：

1. 同一个种子,生成N个随机数,当你设定种子的时候,这N个随机数是什么已经确定。相同次数生成的随机数字是完全相同的。
2. 如果用相同的种子创建两个 Random 实例,则对每个实例进行相同的方法调用序列,它们将生成并返回相同的数字序列。
3. Java的随机数都是通过算法实现的,Math.random()本质上属于Random()类。
4. 使用java.util.Random()会相对来说比较灵活一些，可以产生正态、高斯、均匀分布的随机数。








# 三、一些英文术语

JVM 		java virtual machine
JRE		java runtime environment
JDK		java development kit
SDK		software development kit	可以认为jdk只是sdk的一种(子集)，因为它是开发java程序的一个平台，开发其他程序的sdk可以没有jdk
JAVA SE		Java Standard Edition
JAVA EE		Java Enterprise Edition
JAVA ME		Java Micro Edition

preference  首选项
config			配置	configuration

wizard	安装向导

dedicated		专用的





---

# 四、IDE：

### 1、eclipse：

**快捷键**

| 功能                                            | 快捷键        |
| ----------------------------------------------- | ------------- |
| 生成getter/setter 、构造函数                    | alt+shift+S   |
| 移动本行代码                                    | alt+↑/↓       |
| 删除本行代码                                    | Ctrl+D        |
| 复制本行代码                                    | Ctrl+alt+↑/↓  |
| 自动引入所需要得包                              | Ctril+Shift+O |
| 运行                                            | Ctrl+F11      |
| 这个快捷键可自动补全代码                        | **ctrl+2+L**  |
| 对于Ctrl 2 L 失效的情况 可以试试在分号后 Ctrl+1 |               |
| 补全代码快捷键                                  | alt+/         |
| 快速修复                                        | **Ctrl+1**    |
| 格式化代码                                      | Ctrl+Shitf+F  |

[一个很全的Eclipse快捷键网站](https://www.cnblogs.com/iamfy/archive/2012/07/11/2586869.html)

1.eclipse还原英文找到eclipse 图标，右键属性，在 目标  后面加上 -nl en_US（- 前必须有空格），就可以还原英文了，去掉这个又回到中文了！                    （这个操作的前提是你得先按照[百度的教程](https://jingyan.baidu.com/article/cbf0e500443b0b2eaa289389.html)装过中文语言包了）
以上参考了 [CSDN](https://blog.csdn.net/x_i_xw/article/details/77775684?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2)

2、 eclipse中workplace 等价于idea中 Project











### 2、IDEA

#### 2.0可以参考



#### 2.1idea激活

我是参考了 [网址](https://macstore.info/a/Jetbrainscrack.html?cp=1#comments)，而且可行，另外这个 [网址](https://www.jb51.net/article/186186.htm)方法好像一样， 查看idea的激活日期的方法 可以 看这个[网址](https://blog.csdn.net/malimingwq/article/details/79135762)

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200726182643113.png" alt="image-20200726182643113" style="zoom: 80%;" />

为了防止链接失效，把教程放在这：

*小麦亲测目前可以成功破解的版本如下：*

- *IntelliJ IDEA 2020.2.3* 
- *AppCode 2020.2.4* 
- *CLion 2020.2.4* 
- *DataGrip 2020.2.3*
- *GoLand 2020.2.3* 
- *PhpStorm 2020.2.3*
- *PyCharm 2020.2.3*
- *Rider 2020.2.4*
- *RubyMine 2020.2.3*
- *WebStorm 2020.2.3*

本教程更新于: 2020-10-27 19:26（本次更新全面解决2020.4及以下版本的完美激活,已修复激活后还弹出激活窗口问题。）





如果您已经安装了JetBrains的IDE了或是自己去官网下载好了IDE的话，请直接通过下载的连接下载破解补丁。

- [下载地址](https://www.macfz.com/a/agent.html)，我放在A javafiles里了

注：2020-10-27 更新，支持 JetBrains 最新版本的激活！感谢 https://zhile.io/ 的站长大佬开发的此工具





3、开始激活

1. 以下以 「IDEAIntelliJ IDEA」为例，JetBrains 系列安装激活方法都是一样的。
2. 运行你的 IDE，进行基本的配置后会弹出激活窗口，选择Evaluate for free，然后点击Evaluate按钮。（如果试用过期请点击「OK」或者「Enter Key」）
3. 点击后会关闭试用窗口并出现「项目创建管理窗口」(也就是「Welcome to IDEAIntelliJ IDEA」窗口)，先不要动。(如果你之前创建过项目可能会直接进入项目，把项目关掉就会出现啦)
4. 将安装包内的「破解补丁」文件夹下面的 jetbrains-agent.zip 拖拽到你喜欢的位置（此文件你拖到你喜欢的位置后未来不能删除！）
5. 将 jetbrains-agent.zip 拖拽到「项目创建管理窗口」中，然后点击 Restart 按钮重新启动。
6. 重新启动后出现「JetbrainsAgent 配置助手」窗口，在安装参数处复制粘贴下面的安装参数，然后点击为 IDEAIntelliJ IDEA 安装，最后点击 是，会重新启动。
7. 重新启动后点击菜单栏的「IDEAIntelliJ IDEA」，再点击「Preferences…」打开软件的偏好设置，左上角的搜索框处输入「update」,取消勾选右侧的「Automatically check updates」，然后点击「OK」（为了不必要的麻烦，请务必操作！）

安装参数

Qr7EpuKzNtnTuEmGcLg/YnYyVEcnvR4iflCYTHc6dwuB8Jbx7e6E43CPRA+KjL2O/D/C+hj/rDFrwCNgGAvLcJd3bcaJ8UTMh8FPxd2EfjDt0eopoRIRQKtw8Ua3hlm2i+GvhYnaJ5/F1XN7H/8uEtYqFQlJc9auMxAL3gdnsmY 



2.1.1 最新激活方式

##### 新的思路方法

##### 0x0. 项目背景

Jetbrains家的产品有一个很良心的地方，他会允许你试用`30`天（这个数字写死在代码里了）以评估是否你真的需要为它而付费。
但很多时候会出现一种情况：**IDE并不能按照我们实际的试用时间来计算。**
我举个例子：如果我们开始了试用，然后媳妇生孩子要你回去陪产！陪产时我们并无空闲对IDE试用评估，它依旧算试用时间。（只是举个例子，或许你并没有女朋友）
发现了吗？你未能真的有`30`天来对它进行全面的试用评估，你甚至无法作出是否付费的决定。此时你会想要延长试用时间，然而Jetbrains并未提供相关功能，该怎么办？

事实上有一款插件可以实现这个功能，你或许可以用它来重置一下试用时间。**但切记不要无休止的一直试用，这并不是这个插件的本意！**

##### 0x1. 如何安装

###### 1). 插件市场安装：

- 在`Settings/Preferences...` -> `Plugins` 内手动添加第三方插件仓库地址：`https://plugins.zhile.io`
- 搜索：`IDE Eval Reset`插件进行安装。如果搜索不到请注意是否做好了上一步？网络是否通畅？
- 插件会提示安装成功。

###### 2). 下载安装：

- 点击这个[链接(v2.1.6)](https://macstore.lanzoux.com/iA35risa1da)下载插件的`zip`包（macOS可能会自动解压，然后把`zip`包丢进回收站）
- 通常可以直接把`zip`包拖进IDE的窗口来进行插件的安装。如果无法拖动安装，你可以在`Settings/Preferences...` -> `Plugins` 里手动安装插件（`Install Plugin From Disk...`）
- 插件会提示安装成功。

##### 0x2. 如何使用

- 一般来说，在IDE窗口切出去或切回来时（窗口失去/得到焦点）会触发事件，检测是否长时间（`25`天）没有重置，给通知让你选择。（初次安装因为无法获取上次重置时间，会直接给予提示）

- 也可以手动唤出插件的主界面：

  - 如果IDE没有打开项目，在`Welcome`界面点击菜单：`Get Help` -> `Eval Reset`
  - 如果IDE打开了项目，点击菜单：`Help` -> `Eval Reset`

- 唤出的插件主界面中包含了一些显示信息，

  2个按钮，1个勾选项：

  - 按钮：`Reload` 用来刷新界面上的显示信息。
  - 按钮：`Reset` 点击会询问是否重置试用信息并**重启IDE**。选择`Yes`则执行重置操作并**重启IDE生效**，选择`No`则什么也不做。（此为手动重置方式）
  - 勾选项：`Auto reset before per restart` 如果勾选了，则自勾选后**每次重启/退出IDE时会自动重置试用信息**，你无需做额外的事情。（此为自动重置方式）

##### 0x3. 如何更新

###### 1). 插件更新机制（推荐）：

- IDE会自行检测其自身和所安装插件的更新并给予提示。如果本插件有更新，你会收到提示看到更新日志，自行选择是否更新。
- 点击IDE的`Check for Updates...` 菜单手动检测IDE和所安装插件的更新。如果本插件有更新，你会收到提示看到更新日志，自行选择是否更新。
- 插件更新可能会需要**重启IDE**。

###### 2). 手动更新：

- ###### 从本页面下载最新的插件`zip`包安装更新。参考本文：`下载安装`小节。

- 插件更新需要**重启IDE**。

##### 0x4. 一些说明

- 本插件默认不会显示其主界面，如果你需要，参考本文：`如何使用`小节。

- 市场付费插件的试用信息也会**一并重置**。

- 对于某些付费插件（如: Iedis 2, MinBatis

  ）来说，你可能需要去取掉javaagent

  配置（如果有）后重启IDE：

  - 如果IDE没有打开项目，在`Welcome`界面点击菜单：`Configure` -> `Edit Custom VM Options...` -> 移除 `-javaagent:` 开头的行。
  - 如果IDE打开了项目，点击菜单：`Help` -> `Edit Custom VM Options...` -> 移除 `-javaagent:` 开头的行。

- 重置需要**重启IDE生效**！

- 重置后并不弹出`Licenses`对话框让你选择输入License或试用，这和之前的重置脚本/插件不同（省去这烦人的一步）。

- 如果长达`25`天不曾有任何重置动作，IDE会有**通知询问**你是否进行重置。

- 如果勾选：`Auto reset before per restart` ，重置是静默无感知的。

- 简单来说：勾选了`Auto reset before per restart`则无需再管，一劳永逸。

###### 0x5. 开源信息

- 插件是学习研究项目，源代码是开放的。源码仓库地址：[Gitee](https://gitee.com/pengzhile/ide-eval-resetter)。
- 如果你有更好的想法，欢迎给我提`Pull Request`来共同研究完善。
- 插件源码使用：`GPL-2.0`开源协议发布。
- 插件使用`PHP`编写，毕竟`PHP`是世界上最好的编程语言！









#### 2.2快捷键

| 按键                           | 功能                 |
| ------------------------------ | -------------------- |
| Alt+ Enter                     | 快速修复             |
| Alt + /                        | 快速补全             |
| **Ctrl + Alt + v或者直接.var** | 自动补全变量名称     |
| Ctrl+Shift+F                   | 格式化               |
| Ctrl+P                         | 查看方法所需要的参数 |
| Ctrl +Alt+t                    | Surround with        |
|                                |                      |
|                                |                      |

新快捷键

| 按键                           | 功能                 |
| ------------------------------ | -------------------- |
| Alt+ Enter                     | 快速修复             |
| Alt + /                        | 快速补全             |
| **Ctrl + Alt + v或者直接.var** | 自动补全变量名称     |
| Ctrl + N                       | 查找                 |
| **Ctrl+P**                     | 查看方法所需要的参数 |
| Ctrl +Alt+t                    | Surround with        |
| Fn+Alt+delete                  | 构造                 |
| **iter**                       | 生成一个增强for      |
| **list.for** fori forr         | 遍历集合             |
| **a.for** fori forr forEach    | 遍历数组             |
|                                |                      |



#### 2.3小知识

1、bin 目录下 的 properties
有idea.exe  也有idea64.exe 在各自的下面有idea.exe.vmoptions 是虚拟机的配置信息（我们一般都是使用x64的），可以用记事本编辑从而设置，-Xms初始内存数 -Xms是最大内存值，等等

2、在用户-用户名目录下 会生成IntelliJ idea目录这个目录保存各种配置
cofig目录是配置信息 有插件 模板快捷键
system目录是系统目录
如果你不小心把idea配置坏了，没关系，把IntellJ目录删了，一切都会回到原样（因为该目录有个特性，一旦删除，重启IDEA会自动生成一个全新的默认配置）

eclipse同理，在eclipse的工作区目录下 配置信息存于 .metadata ，若删除之，会恢复默认配置，重新生成



3、在 Eclipse 中我们有 Workspace（工作空间）和 Project（工程）的概念，在 IDEA 中只有 Project（工程）和 Module（模块）的概念。这里的对应关系为：
 IDEA 官网说明：
 An Eclipse workspace is similar to a project in IntelliJ IDEA ; An Eclipse project maps to a module in IntelliJ IDEA 
翻译： Eclipse 中 workspace   相当于   IDEA 中的 Project ,Eclipse 中 Project      相当于   IDEA 中的 Module 
也即 **eclipse 是 workplace-project-package    而 idea是 project-module-package**

4、从 Eclipse 转过来的人总是下意识地要在同一个窗口管理 n 个项目，这在 IntelliJ IDEA 是无法做到的。IntelliJ IDEA 提供的解决方案是打开多个项目实例， 即打开多个项目窗口。即：一个 Project 打开一个 Window 窗口。

5、在 IntelliJ IDEA 中 Project 是最顶级的级别，次级别是 Module。一个 Project可以有多个 Module。目前主流的大型项目都是分布式部署的，结构都是类似这种多 Module 结构。 <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200428153837101.png" alt="image-20200428153837101" style="zoom: 50%;" />

这类项目一般是这样划分的，比如：core Module、web Module、plugin Module、
solr Module 等等，模块之间彼此可以相互依赖。通过这些 Module 的命名也可
以看出，他们之间都是处于同一个项目业务下的模块，彼此之间是有不可分割的
业务关系的。举例： 

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220113101709799.png" alt="image-20220113101709799" style="zoom: 33%;" />

![image-20220113101835001](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220113101835001.png)

6、help里有find action

7、[bilibili视频讲解](https://www.bilibili.com/video/BV164411C71M?p=17)或者再网盘里也有尚硅谷

#### 2.4创建模块

有时创建完了 发现没有，去哪了呢？

注意！在创建时，不要直接输入名字，而是在路径那里输入，这样也直接同步到名字了









#### 2.6模板和快捷方式

https://www.cnblogs.com/asio/p/12582328.html#3



#### 2.7其他

##### 1项目的创建

![image-20220113101835001](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220113101835001.png)







##### 2IDEA的有关配置目录：



1、C:\Users\95266\.IntelliJIdea\config

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220114172628296.png" alt="image-20220114172628296" style="zoom: 50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220114200304078.png" alt="image-20220114200304078" style="zoom:33%;" />

2、<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220114172536355.png" alt="image-20220114172536355" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220114172728989.png" alt="image-20220114172728989" style="zoom:50%;" />



3、<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220114172507432.png" alt="image-20220114172507432" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220114172706530.png" alt="image-20220114172706530" style="zoom:50%;" />





##### 3.配置文件的导入导出



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220115112333693.png" alt="image-20220115112333693" style="zoom:50%;" />

# 五、关于JDK

### 1.关于ClassPath

1. classpath的作用: 作用是指定类搜索路径，要使用已经编写好的类，前提当然是能够找到它们了，一旦配置了classpath路径信息的时候，jvm与java编译器都会根据classpath指定的路径去寻找class文件。

2. jdk1.5之后不用再配置classpath了

> ## Path
>
> path是系统用来指定可执行文件的完整路径。例如：如果没有设置path路径，路径也可以执行java文件，但必须把完整的写出来。如：
> C:\ProgramFiles\Java\jdk1.6.0_10\bin\javac TheClass.java。path是用来搜索可执行文件路径的。如果执行的可执行文件不在当前目录下，那就会一次搜索path中设置的路径；而java的各种操作命令是放在安装路径中的bin目录下，所以path中设置了JDK的安装目录后就不用再把可执行文件的完整路径写出来了，它会自动去path中设置的路径中去找。
>
> ## Classpath
>
> classpath是指定你在程序中所使用的类（.class）文件所在的位置，就如在引入一个类时，import javax.swing.JTable这句话就是告诉编译器要引入java.swing这下的包下JTable类，而classpath就是告诉编译器该到哪里去找到这个类（前提是你在classpath中设置了这个类的路径）；如果你想要编译在当前目录下找，就加上“.”如：.;D:\development\jdk1.6\bin,这样编译器就会到当前目录和C:\ProgramFiles\Java\jdk\去找javax.swing.JTable这个类；

[讲得很形象](https://blog.csdn.net/cuipp0509/article/details/74852740?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control)

> 结论1：在没有配置CLASSPATH环境变量时，java命令在找class文件时是默认在当前目录下寻找的。
>
> 结论2：**配置过CLASSPATH环境后，java命令是按照CLASSPATH变量中的路径来的寻找class文件的，这就是为什么CLASSPATH变量中配置没有当前目录时，即使当前目录中有class文件，java命令仍然不能正常运行的原因。**





### 2.如何切换版本：



https://blog.csdn.net/qq_26545305/article/details/66472521?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.control

切换jdk版本，只需要修改对应的JAVA_HOME值即可
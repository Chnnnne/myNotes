# Java笔记本-3





## 反射

Class.forName：返回与给定的字符串名称相关联类或接口的Class对象。

Class.forName是一个静态方法，同样可以用来加载类。

该方法有两种形式：
Class.forName(String name, boolean initialize, ClassLoader loader)
和 Class.forName(String className)。
第一种形式的参数 name表示的是类的全名；initialize表示是否初始化类；loader表示加载时使用的类加载器。第二种形式则相当于设置了参数 initialize的值为 true，loader的值为当前类的类加载器。

如下图所示，java类型的属性名称叫name，可以通过forName的方法获取到这个类的实例，从而获取到类里面的属性。

![img](https://iknow-pic.cdn.bcebos.com/1b4c510fd9f9d72a73e80a53d92a2834359bbbeb?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1)

扩展资料：
注意：
在指定类给 class.forName() 方法后，如果找不到指定的类，会抛出ClassNotFoundException 异常。Class 的静态 forName() 方法有两个版本，上面的代码是只指定类名称的版本，
而另一个版本可以让你指定类名称、加载时是否运行静态区块、指定类加载器：Static Class forName(String name, boolean initialize, ClassLoader loader)    **默认在加载类的时候，如果类中有定义静态区块则会运行它**。你可以使用 class.forName() 的第二个版本，将 initialize 设定为 false，这样在加载类时并不会立即运行静态区块，而会在使用类建立对象时才运行静态区块。





```
主要功能
Class.forName(xxx.xx.xx)返回的是一个类
Class.forName(xxx.xx.xx)的作用是要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段
```

在初始化一个类，生成一个实例的时候，newInstance()方法和new关键字除了一个是方法，一个是关键字外，最主要有什么区别？它们的区别在于创建对象的方式不一样，前者是使用类加载机制，后者是创建一个新类。那么为什么会有两种创建对象方式？这主要考虑到软件的可伸缩、可扩展和可重用等软件设计思想。



通常编码过程中，在加载完成后，一般还要调用Class下的newInstance( )静态方法来实例化对象以便操作。因此，单单使用Class.forName( )是动态加载类是没有用的，其最终目的是为了实例化对象。

有数据库开发经验朋友会发现，为什么在我们加载数据库驱动包的时候有的却没有调用newInstance( )方法呢？
即有的jdbc连接数据库的写法里是Class.forName(xxx.xx.xx);而有一 些：Class.forName(xxx.xx.xx).newInstance()，为什么会有这两种写法呢？

刚才提到，Class.forName(“”);的作用是要求JVM查找并加载指定的类，首先要明白，java里面任何class都要装载在虚拟机上才能运行，而静态代码是和class绑定的，class装载成功就表示执行了你的静态代码了，而且以后不会再走这段静态代码了。
而我们前面也说了，Class.forName(xxx.xx.xx)的作用就是要求JVM查找并加载指定的类，如果在类中有静态初始化器的话，JVM必然会执行该类的静态代码段。





## 属性集

### 5.1 概述

`java.util.Properties ` 继承于` Hashtable` ，来表示一个持久的属性集。它**使用键值结构存储数据**，每个键及其对应值都是一个字符串。该类也被许多Java类使用，比如获取系统属性时，`System.getProperties` 方法就是返回一个`Properties`对象。

### 5.2 Properties类

#### 构造方法

- `public Properties()` :创建一个空的属性列表。

#### 基本的存储方法

- `public Object setProperty(String key, String value)` ： 保存一对属性。  
- `public String getProperty(String key) ` ：使用此属性列表中指定的键搜索属性值。
- `public Set<String> stringPropertyNames() ` ：所有键的名称的集合。

```java
public class ProDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // 创建属性集对象
        Properties properties = new Properties();
        // 添加键值对元素
        properties.setProperty("filename", "a.txt");
        properties.setProperty("length", "209385038");
        properties.setProperty("location", "D:\\a.txt");
        // 打印属性集对象
        System.out.println(properties);
        // 通过键,获取属性值
        System.out.println(properties.getProperty("filename"));
        System.out.println(properties.getProperty("length"));
        System.out.println(properties.getProperty("location"));

        // 遍历属性集,获取所有键的集合
        Set<String> strings = properties.stringPropertyNames();
        // 打印键值对
        for (String key : strings ) {
          	System.out.println(key+" -- "+properties.getProperty(key));
        }
    }
}
输出结果：
{filename=a.txt, length=209385038, location=D:\a.txt}
a.txt
209385038
D:\a.txt
filename -- a.txt
length -- 209385038
location -- D:\a.txt
```

#### 与流相关的方法

- `public void load(InputStream inStream)`： 从字节输入流中读取键值对。 
- `public void load(Reader reader)`

参数中使用了字节输入流，通过流对象，可以关联到某文件上，这样就能够加载文本中的数据了。

文本数据格式:

```
filename=a.txt
length=209385038
location=D:\a.txt
```

加载代码演示：

```java
public class ProDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        // 创建属性集对象
        Properties pro = new Properties();
        // 加载文本中信息到属性集
        pro.load(new FileInputStream("read.txt"));
        // 遍历集合并打印
        Set<String> strings = pro.stringPropertyNames();
        for (String key : strings ) {
          	System.out.println(key+" -- "+pro.getProperty(key));
        }
     }
}
输出结果：
filename -- a.txt
length -- 209385038
location -- D:\a.txt
```

> 小贴士：文本中的数据，必须是键值对形式，可以使用**空格、等号、冒号等符号**分隔。







#### 例子



**主函数**

```java
/*
    java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>
    Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。
    Properties集合是一个唯一和IO流相结合的集合
        可以使用Properties集合中的方法store,把集合中的临时数据,持久化写入到硬盘中存储
        可以使用Properties集合中的方法load,把硬盘中保存的文件(键值对),读取到集合中使用

    属性列表中每个键及其对应值都是一个字符串。
        Properties集合是一个双列集合,key和value默认都是字符串
*/
public class Demo01Properties {
    public static void main(String[] args) throws IOException {
        
    }
}
```

**show1**

```java
    /*
        使用Properties集合存储数据,遍历取出Properties集合中的数据
        Properties集合是一个双列集合,key和value默认都是字符串
        Properties集合有一些操作字符串的特有方法
            Object setProperty(String key, String value) 调用 Hashtable 的方法 put。
            String getProperty(String key) 通过key找到value值,此方法相当于Map集合中的get(key)方法
            Set<String> stringPropertyNames() 返回此属性列表中的键集，其中该键及其对应值是字符串,此方法相当于Map集合中的keySet方法
     */
    private static void show01() {
        //创建Properties集合对象
        Properties prop = new Properties();
        //使用setProperty往集合中添加数据
        prop.setProperty("赵丽颖","168");
        prop.setProperty("迪丽热巴","165");
        prop.setProperty("古力娜扎","160");
        //prop.put(1,true);

        //使用stringPropertyNames把Properties集合中的键取出,存储到一个Set集合中
        Set<String> set = prop.stringPropertyNames();

        //遍历Set集合,取出Properties集合的每一个键
        for (String key : set) {
            //使用getProperty方法通过key获取value
            String value = prop.getProperty(key);
            System.out.println(key+"="+value);
        }
    }
```

**show2**

```java
    /*
        可以使用Properties集合中的方法store,把集合中的临时数据,持久化写入到硬盘中存储
        void store(OutputStream out, String comments)
        void store(Writer writer, String comments)
        参数:
            OutputStream out:字节输出流,不能写入中文
            Writer writer:字符输出流,可以写中文
            String comments:注释,用来解释说明保存的文件是做什么用的
                    不能使用中文,会产生乱码,默认是Unicode编码
                    一般使用""空字符串

        使用步骤:
            1.创建Properties集合对象,添加数据
            2.创建字节输出流/字符输出流对象,构造方法中绑定要输出的目的地
            3.使用Properties集合中的方法store,把集合中的临时数据,持久化写入到硬盘中存储
            4.释放资源
     */
    private static void show02() throws IOException {
        //1.创建Properties集合对象,添加数据
        Properties prop = new Properties();
        prop.setProperty("赵丽颖","168");
        prop.setProperty("迪丽热巴","165");
        prop.setProperty("古力娜扎","160");

        //2.创建字节输出流/字符输出流对象,构造方法中绑定要输出的目的地
        //FileWriter fw = new FileWriter("09_IOAndProperties\\prop.txt");
        //3.使用Properties集合中的方法store,把集合中的临时数据,持久化写入到硬盘中存储
        //prop.store(fw,"save data");

        //4.释放资源
        //fw.close();

        prop.store(new FileOutputStream("09_IOAndProperties\\prop2.txt"),"");
    }
```

**show3**

```java
     /*
        可以使用Properties集合中的方法load,把硬盘中保存的文件(键值对),读取到集合中使用
        void load(InputStream inStream)
        void load(Reader reader)
        参数:
            InputStream inStream:字节输入流,不能读取含有中文的键值对
            Reader reader:字符输入流,能读取含有中文的键值对
        使用步骤:
            1.创建Properties集合对象
            2.使用Properties集合对象中的方法load读取保存键值对的文件
            3.遍历Properties集合
        注意:
            1.存储键值对的文件中,键与值默认的连接符号可以使用=,空格(其他符号)
            2.存储键值对的文件中,可以使用#进行注释,被注释的键值对不会再被读取
            3.存储键值对的文件中,键与值默认都是字符串,不用再加引号
     */
    private static void show03() throws IOException {
        //1.创建Properties集合对象
        Properties prop = new Properties();
        //2.使用Properties集合对象中的方法load读取保存键值对的文件
        prop.load(new FileReader("09_IOAndProperties\\prop.txt"));
        //prop.load(new FileInputStream("09_IOAndProperties\\prop.txt"));
        //3.遍历Properties集合
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key+"="+value);
        }
    }
```





## JavaWeb琐碎知识

导入css文件时，href指定的相对位置以项目路径开始







创建WEB项目时，没有选择web.xml，那么事后怎么再次创建xml呢？[csdn](https://blog.csdn.net/Mos_wen/article/details/84888098)







[html中插入视频](https://jingyan.baidu.com/article/90895e0f2bb82764ec6b0bc0.html)







## 路径

**/         除 、注释   、URL**

**\		文件路径用  、 转义**

> 记忆：==只有**文件路径**和**转义**用反斜杠==   \
>
> 注意在编程中要配合转义使用两个\ \或者一个/代表文件路径 





**路径分类**

1. 相对路径：通过相对路径不可以确定唯一资源

   * 如：**./index.html**

   * 不以/开头，**以.或..开头路径**

   * 规则：**找到当前资源和目标资源之间的相对位置关系**

     * ./：当前目录   **（./可省略）**

     * ../:后退一级目录

       > 例子： a.html 和b.html 都位于 /day15目录下， 那么从 a跳转到b  可以写成<a href="b.html或者./b.html"><a>

       

2. 绝对路径：通过绝对路径可以确定唯一资源

   * 如：http://localhost/day15/responseDemo2		/day15/responseDemo2

     * 以/开头的路径

         

       * 规则：**判断定义的路径是给谁用的？判断请求将来从哪儿发出**

         * 给**客户端浏览器使用**：**需要加虚拟目录(项目的访问路径)** 

           * `<a>` 标签中,

           * `<form>`标签中

           * <u>重定向...</u>

           * 在写虚拟目录时，由于虚拟目录可能变 因此最好写成动态的形式，建议虚拟目录动态获取：**request.getContextPath()**        **${pageContext.request.contextPath}**

             <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200927162029777.png" alt="image-20200927162029777" style="zoom:67%;" />

             
             

         * 给**服务器使用**：**不需要加虚拟目录**

           * <u>转发路径</u>

             







>  因此：以后写地址时，
>
>  1.要首先明确使用绝对还是相对路径，  (用谁都行，这俩路径只是找到资源的两种方式)
>  2使用**绝对路径的话    （/开头），然后再确定资源给谁用的（确定是否写虚拟路径）**
>  2使用相对路径的话  （.开头），确定位置关系		







## 其他

### 解决 idea 复制进项目的文件运行时无法找到的问题

IDEA文件复制进项目后文件夹下图片资源访问不到

**需要重构需要重构！！！！！**







问题描述：

将img文件夹整个复制到idea新项目中，发现路径正确的情况下无法访问到img下的图片资源，也就是404

问题原因：

idea项目部署后访问资源会查找out\artifacts下是否存在该资源，直接复制文件夹进项目而out下无该资源，自然访问不到

解决：

选中项目 Build-Rebuild Project 重新加载项目后，重启服务器 或者update resources即可






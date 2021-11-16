

# XML



### 概念

Extensible Markup Language 可扩展标记语言

* 可扩展：标签都是自定义的。（html则都是固定的） <user>  <student>

### 功能

* 存储数据（而不是展示数据 比如html）
	1. 配置文件
	2. 在网络中传输

### xml与html的区别

1. xml标签都是自定义的，html标签是预定义。
2. xml的语法严格，html语法松散
3. xml是存储数据的，html是展示数据

>  w3c:万维网联盟world wide web consortium

> html由于浏览器的恶性竞争，导致语法不太规范、混乱。但是这对于程序员很好，因为程序员写什么垃圾代码都会被浏览器解析，因此xml没有竞争过html，于是转过头去跟properties竞争去了。

### 语法：

#### 基本语法：

1. xml文档的后缀名 .xml
2. xml第一行必须定义为文档声明
3. xml文档中有且仅有一个根标签
4. 属性值必须使用引号(单双都可)引起来
5. 标签必须正确关闭 
   (要么自闭和标签比如说`<br/>`,要么是围堵比如`<user></user>`)
6. xml标签名称区分大小写

#### 快速入门：

```xml
<?xml version='1.0' ?>
<users>
	<user id='1'>
		<name>zhangsan</name>
		<age>23</age>
		<gender>male</gender>
		<br/>
	</user>
	<user id='2'>
		<name>lisi</name>
		<age>24</age>
		<gender>female</gender>
	</user>
</users>
```


#### 组成部分：

##### 1.文档声明

1. 格式：`<?xml 属性列表 ?>`
2. 属性列表：
	* version：版本号，必须的属性,不写会报错
	* encoding：编码方式。告知解析引擎当前文档使用的字符集，默认值：ISO-8859-1（关于编码的知识点请参考JAVAFIles里的编码）    
	  * 注意 ！   你的xml的编码格式（保存格式）和你通过属性列表encoding指定的（这一项告诉浏览器使用什么格式来解析xml文件）要一致。  
	  * 注意！  IDEA是高级的开发工具，当你在encoding中指定后，它会自动改变当前文件编码来匹配
	* standalone：是否独立
		* 取值：
			* yes：不依赖其他文件   （现在基本上没啥用了，yes也可以依赖 ）
			* no：依赖其他文件

##### 2.指令(了解)：结合css的

`<?xml-stylesheet type="text/css" href="a.css" ?>`

用来展示的，但xml主要是来存储的

##### 3.标签：标签名称自定义的

* xml元素命名规则：
	* 名称可以包含字母、数字以及其他的字符 
	* 名称不能以数字或者标点符号开始 
	* 名称不能以字母 xml（或者 XML、Xml 等等）开始 
	* 名称不能包含空格 

##### 4.属性：

和html共有的属性：键值对形式， 单引号或双引号

id属性值唯一

##### 5.文本：

* CDATA区：在该区域中的数据会被原样展示
	* 格式：  `<![CDATA[ 数据 ]]>`

### 约束：

**作用：规定xml文档的书写规则**

* 作为框架的使用者(程序员)：
	1. 能够在xml中引入约束文档
	2. 能够简单的读懂约束文档

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200918223726582.png" alt="image-20200918223726582" style="zoom: 50%;" />





##### 分类：

1. DTD:一种简单的约束技术
2. Schema:一种复杂的约束技术



##### 一、DTD：

缺点是：不能做内容的限定，只能做形式的限定



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200918193021897.png" alt="image-20200918193021897" style="zoom: 67%;" />
一个是DTD文档，一个是根据DTD写的Xml文档



一个DTD文件

```dtd
<!ELEMENT students (student+) >
<!ELEMENT student (name,age,sex)>
<!ELEMENT name (#PCDATA)>
<!ELEMENT age (#PCDATA)>
<!ELEMENT sex (#PCDATA)>
<!ATTLIST student number ID #REQUIRED>
```

注意： 对于 + 说明student必须>=1，而对于*说明student可有可无。
这个DTD文件要会读：students在最上面而且它包含别人，别人不包含它，说明它是根标签（Xml只能有一个根标签）而且+号说明student抱歉至少要有一个。 student标签内部有定义了name age sex标签，它们有且只有一个。#PCDATA说明是字符串



一个根据DTD写的Xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE students SYSTEM "student.dtd">  <!--引入-->

<students>
	
	<student number="s001">
		<name>zhangsan</name>
		<age>abc</age>
		<sex>hehe</sex>
	</student>

	<student number="s002">
		<name>lisi</name>
		<age>24</age>
		<sex>female</sex>
	</student>
	
</students>
```











注意：需要引入dtd文档到xml文档中

1. 内部dtd文件：将约束规则定义在xml文档中，做下了解就行了。把system和文件去掉，换成中括号里面写约束
2. 外部dtd文件：将约束的规则定义在外部的dtd文件中
   若dtd文件在本地：`<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">`
   若dtd文件在网络：`<!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件的位置URL">`



##### 二、Schema:

后缀名是.xsd    但是形式上跟xml一样

一个xsd文件

```xml-dtd
<?xml version="1.0"?>
<xsd:schema xmlns="http://www.itcast.cn/xml"
        xmlns:xsd="http://www.w3.org/2001/XMLSchema"
        targetNamespace="http://www.itcast.cn/xml" elementFormDefault="qualified">
    <xsd:element name="students" type="studentsType"/>
    <xsd:complexType name="studentsType">
        <xsd:sequence>
            <xsd:element name="student" type="studentType" minOccurs="0" maxOccurs="unbounded"/>
        </xsd:sequence>
    </xsd:complexType>
    <xsd:complexType name="studentType">
        <xsd:sequence>
            <xsd:element name="name" type="xsd:string"/>
            <xsd:element name="age" type="ageType" />
            <xsd:element name="sex" type="sexType" />
        </xsd:sequence>
        <xsd:attribute name="number" type="numberType" use="required"/>
    </xsd:complexType>
    <xsd:simpleType name="sexType">
        <xsd:restriction base="xsd:string">
            <xsd:enumeration value="male"/>
            <xsd:enumeration value="female"/>
        </xsd:restriction>
    </xsd:simpleType>
    <xsd:simpleType name="ageType">
        <xsd:restriction base="xsd:integer">
            <xsd:minInclusive value="0"/>
            <xsd:maxInclusive value="256"/>
        </xsd:restriction>
    </xsd:simpleType>
    <xsd:simpleType name="numberType">
        <xsd:restriction base="xsd:string">
            <xsd:pattern value="heima_\d{4}"/>
        </xsd:restriction>
    </xsd:simpleType>
</xsd:schema> 
```

一个根据Schema文件而写的xml文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!-- 
	1.填写xml文档的根元素
	2.引入xsi前缀.  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	3.引入xsd文件命名空间.  xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"
	4.为每一个xsd约束声明一个前缀,作为标识  xmlns="http://www.itcast.cn/xml" 
	
	
 -->
<students   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xmlns="http://www.itcast.cn/xml"
			xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"
>
	<student number="heima_0001">
		<name>tom</name>
		<age>18</age>
		<sex>male</sex>
	</student>

</students>
```







引入：
1.填写xml文档的根元素
2.引入xsi前缀.  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
3.引入xsd文件命名空间.  xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"
4.为每一个xsd约束声明一个前缀,作为标识  xmlns="http://www.itcast.cn/xml" 

<students   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://www.itcast.cn/xml"
	xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd">



以上说的那么多是针对 引入多个xsd文件，而xsd文件内的约束重名的情况



### 解析

操作xml文档，将文档中的数据读取到内存中



#### 1.操作xml文档

1. 解析(读取)：将文档中的数据读取到内存中
2. 写入：将内存中的数据保存到xml文档中。持久化的存储





#### 2.解析xml的方式：

1. DOM：将标记语言文档一次性加载进内存，在内存中形成一颗dom树   （服务器使用）
	* 优点：操作方便，可以对文档进行CRUD的所有操作
	* 缺点：占内存
2. SAX：逐行读取，基于事件驱动的。    （客户端 安卓端使用）
	* 优点：不占内存。读一行释放一行
	* 缺点：只能读取，不能增删改





​		

#### 3.xml常见的解析器：

1. JAXP：sun公司提供的解析器，支持dom和sax两种思想，比较烂。
2. DOM4J：一款非常优秀的解析器。   基于DOM思想，因此服务器端经常使用。
3. Jsoup：jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
4. PULL：Android操作系统内置的解析器，sax方式的。





##### 3.1Jsoup：

jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。

###### 3.1.1快速入门：

* 步骤：
	1. 导入jar包              	先在模块下创建一个Directory，命名为libs，然后把资料中的jsoup-1.11.2.jar复制进来，然后右键libs，Add as Library作为模块的库
	2. 获取Document对象，根据xml文档
	3. 获取对应的标签Element对象
	4. 获取数据

示例代码：

```java
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象 Element
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());
        //3.1获取第一个name的Element对象
        Element element = elements.get(0);
        //3.2获取数据
        String name = element.text();
        System.out.println(name);
    }
}
```





###### 3.1.2对象的使用：

1. Jsoup：工具类，可以解析html或xml文档，返回Document
	
	```java
	 Document document = Jsoup.parse(new File(path), "utf-8");
	```
	
	* parse：解析html或xml文档，返回Document
		* parse(File in, String charsetName)：解析xml或html文件的。
		* parse(String html)：解析xml或html字符串      (不常用，相当于直接传xml文件的内容)
		* parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象



```java
       URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");//代表网络中的一个资源路径
        Document document = Jsoup.parse(url, 10000);  //最大等待时间10秒
        System.out.println(document);
```







2. Document：文档对象。代表内存中的dom树（Document继承Element）

* 获取Element对象
	* getElementById(String id)：根据id属性值获取唯一的element对象     属性一定要是id
	* getElementsByTag(String tagName)：根据标签名称获取元素对象集合
	* getElementsByAttribute(String key)：根据属性名称获取元素对象集合
	* getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合

```java
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //1.获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.获取元素对象了。
        //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("-----------");


        //3.2 获取属性名为id的元素对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("-----------");
        //3.2获取 number属性值为heima_0001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);

        System.out.println("-----------");
        //3.3获取id属性值的元素对象
        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);
    }

}
```





3. Elements：元素Element对象的集合。可以当做 ArrayList<Element>来使用

4. Element：元素对象
   1. **获取子元素对象**（而Document的方法是获取DOM树中所有的元素对象，也即xml中的所有对应标签）
     - getElementById(String id)：根据id属性值获取唯一的element对象
     - getElementsByTag(String tagName)：根据标签名称获取元素对象集合
     - getElementsByAttribute(String key)：根据属性名称获取元素对象集合
     - getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
   2. 获取属性值
      - String attr(String key)：根据属性名称获取属性值
   3. 获取文本内容
      - String text():获取文本内容                     （获取所有子标签的纯文本内容）
      - String html():获取标签体的所有内容(包括字标签的字符串内容)            （获取字标签的字符串表示形式，连标签和文本都获取了）

   ```java
   public class JsoupDemo4 {
       public static void main(String[] args) throws IOException {
           //1.获取student.xml的path
           String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
           //2.获取Document对象
           Document document = Jsoup.parse(new File(path), "utf-8");
           /*
           Element：元素对象
   				1. 获取子元素对象
   					* getElementById​(String id)：根据id属性值获取唯一的element对象
   					* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
   					* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
   					* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
   
   				2. 获取属性值
   					* String attr(String key)：根据属性名称获取属性值
   				3. 获取文本内容
   					* String text():获取所有字标签的纯文本内容
   					* String html():获取标签体的所有内容(包括子标签的标签和文本内容)
            */
           //通过Document对象获取name标签，获取所有的name标签，可以获取到两个
           Elements elements = document.getElementsByTag("name");
           System.out.println(elements.size());
           System.out.println(elements);
           System.out.println("----------------");
           //通过Element对象获取子标签对象
           Element element_student = document.getElementsByTag("student").get(0);
           Elements ele_name = element_student.getElementsByTag("name");
           System.out.println(ele_name.size());
   
           //获取student对象的属性值
           String number = element_student.attr("NUMBER");
           System.out.println(number);
           System.out.println("------------");
           //获取文本内容
           String text = ele_name.text();
           String html = ele_name.html();
           System.out.println(text);
           System.out.println(html);
       }
   }
   ```
   
   
   
5. Node：节点对象

- 是Document和Element的父类
- Element又是Document的父类









###### 3.1.3快捷查询方式：

1. **selector**:选择器
	* 使用的方法：Elements	select(String cssQuery)             （这个方法，可以是Element或Document对象调用）
		* 语法：参考Selector类中定义的语法							（在资料 Jsoupdoc中找，有点难，要有js的基础，而我没学好，Xpath语法相对容易）
2. **XPath**：XPath即为XML路径语言，它是一种用来确定XML（标准通用标记语言的子集）文档中某部分位置的语言
	
	* 使用Jsoup的Xpath需要额外导入jar包。  在资料中 有一个JsoupXpath-0.3.2.jar包 复制到模块下的libs中
	
	* **查询w3cshool参考手册，使用xpath的语法完成查询**
   
   * 注意Documen对象是Jsoup里的，它并不支持Xpath语法。需要单独构建JXDocument对象，它支持Xpath语法
   
* 代码：
   	
     ```java
  //1.获取student.xml的path
        String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
      //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
     
      //3.根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
  
        //4.结合xpath语法查询
     //4.1查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
          System.out.println(jxNode);
        }
   
     System.out.println("--------------------");
     
     //4.2查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
          System.out.println(jxNode);
        }
   
        System.out.println("--------------------");
     
     //4.3查询student标签下带有id属性的name标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
      System.out.println("--------------------");
        //4.4查询student标签下带有id属性的name标签 并且id属性值为itcast
     
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='itcast']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }	
  ```
  
     



# 不懂

关于js和 选择器的查询写法还是不熟悉需要巩固
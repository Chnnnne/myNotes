# 今日内容



项目的部署目录

![image-20201015182111122](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201015182111122.png)

项目的真正目录

![image-20201015182153393](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201015182153393.png)

![image-20201015182213201](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201015182213201.png)

## JSP:
### 指令

* 作用：用于配置JSP页面，导入资源文件
* 格式：
	<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
* 分类：
	1. page		： 配置JSP页面的
		* pageEncoding
		* contentType：等同于response.setContentType()
			1. 设置响应体的mime类型以及字符集
			2. 设置当前jsp页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
		* import：导包
		* errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
		* isErrorPage：标识当前也是是否是错误页面。
			* true：是，**可以使用内置对象exception**
			* false：否。默认值。不可以使用内置对象exception

2. include	： 页面包含的。导入页面的资源文件
	* <%@include file="top.jsp"%>
3. taglib	： 导入资源
	* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		* prefix：前缀，自定义的 ，一般用c

### 注释:

1. html注释：
	<!-- -->:客户端查看源码可以看到
2. jsp注释：推荐使用
	<%-- --%>：可以注释所有，客户端看不见源码

### 内置对象

* 在jsp页面中不需要创建，直接使用的对象
* 一共有9个：
		            变量名					真实类型						    作用
	* pageContext				PageContext					当前页面共享数据，还可以获取其他八个内置对象
	* request					HttpServletRequest			一次请求访问的多个资源(转发)
	* session					HttpSession					一次会话的多个请求间
	* application				ServletContext				所有用户间共享数据
	* response					HttpServletResponse			响应对象
	* page						Object						当前页面(Servlet)的对象  this
	* out						JspWriter					输出对象，数据输出到页面上
	* config					ServletConfig				Servlet的配置对象
	* exception					Throwable					异常对象     isErrorPage=true

​	![image-20201015182525939](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201015182525939.png)










## MVC：开发模式	
1. jsp演变历史
	1. 早期只有servlet，只能使用response输出标签数据，非常麻烦
	2. 后来又jsp，简化了Servlet的开发，如果过度使用jsp，在jsp中即写大量的java代码，有写html表，造成难于维护，难于分工协作
	3. 再后来，java的web开发，借鉴mvc开发模式，使得程序的设计更加合理性

2. MVC：
	1. M：Model，模型。JavaBean
		* 完成具体的业务操作，如：查询数据库，封装对象
	2. V：View，视图。JSP
		* 展示数据
	3. C：Controller，控制器。Servlet
		* 获取用户的输入
		* 调用模型
		* 将数据交给视图进行展示

* 优缺点：
	1. 优点：
		1. 耦合性低，方便维护，可以利于分工协作
		2. 重用性高

	2. 缺点：
		1. 使得项目架构变得复杂，对开发人员要求高

不是设计模式，是开发模式



JSP不写代码了，那么怎么展示数据，要用别的东西替换JSP中JAvA代码



## EL表达式
#### 1.概念

Expression Language 表达式语言





#### 2.作用：

替换和简化jsp页面中java代码的编写





#### 3.语法：

${表达式}





#### 4.注意：

* jsp默认支持el表达式的。如果要忽略el表达式
	1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
	2.  `\$`{表达式} ：忽略当前这个el表达式





#### 5.使用：

##### 运算：

* 运算符：
	1. 算数运算符： +     -     *       /(div)      %(mod)
	2. 比较运算符： >    <      >=     <=    ==     !=
	3. 逻辑运算符： &&(and)       ||(or)          !(not)
	4. 空运算符： empty
		* 功能：用于判断字符串、集合、数组对象是否为null   或者  长度是否为0
		* ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
		* ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0





##### 获取值

1. el表达式只能从域对象(4个)中获取值

   

2. 语法：

   **${域名称.键名}**：从指定域中获取指定键的值

  	* 域名称：
  	      	 	1. pageScope		--> pageContext
  	         	2. requestScope 	--> request
  	         	3. sessionScope 	--> session
  	         	4. applicationScope --> application（ServletContext）

  * 举例：在request域中存储了name=张三
  
  	* 获取：**${requestScope.name}**  要是不存在就显示为空，而不是null

**${键名}**：表示依次从最小的域中（从上到下）查找是否有该键对应的值，直到找到为止。注意是键名





3. 获取**对象**、**List集合**、**Map集合**的值
		
		
		
		
		1. 对象：**${域名称.键名.属性名}**


* 本质上会去调用对象的getter方法

* 通过的是对象的**属性**来获取

  * setter或getter方法，去掉set或get，在将剩余部分，首字母变为小写，就是**属性**。

    比如**setName** --> Name --> **name**
  
  
  
  
  
  
  
  2. List集合：${域名称.键名[索引]}
  
  
  
  
  
  3.Map集合：
  
* ${域名称.键名.key名称}

* ${域名称.键名["key名称"]}

#### 6.例子

```jsp
<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>

    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());
        request.setAttribute("u",user);//requestScope

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);
        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);

    %>

<h3>el获取对象中的值</h3>
${requestScope.u}<br>

    
<%--
    * 通过的是对象的属性来获取
        * setter或getter方法，去掉set或get，在将剩余部分，首字母变为小写。
        * setName --> Name --> name
--%>

    ${requestScope.u.name}<br>
    ${u.age}<br>
    ${u.birthday}<br>
    ${u.birthday.month}<br>
    ${u.birStr}<br>

    <h3>el获取List值</h3>
    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>
    ${list[10]}<br>
    ${list[2].name}

    <h3>el获取Map值</h3>
    ${map.gender}<br>
    ${map["gender"]}<br>
    ${map.user.name}

</body>
</html>

```

```java
public class User {
    private String name;
    private int age;
    private Date birthday;

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public User() {
    }

    /**
     * 逻辑视图   不对应一个成员变量，只是为了显示格式
     * @return
     */
    public String getBirStr(){

        if(birthday != null){
            //1.格式化日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //2.返回字符串即可
            return sdf.format(birthday);

        }else{
            return "";
        }
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

```



#### 其他对象

3. 隐式对象：
	* el表达式中有11个隐式对象（前面有四个域对象）
	* pageContext：
		* 获取jsp其他八个内置对象
			* ${pageContext.request.contextPath}：动态获取虚拟目录

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>


    ${pageContext.request}<br>
    <h4>在jsp页面动态获取虚拟目录</h4>
    ${pageContext.request.contextPath}
</body>
</html>

```



## JSTL标签
### 概念

**JavaServer Pages Tag Library  JSP标准标签库**

* 是由Apache组织提供的开源的免费的jsp标签		<标签>





### 作用：

用于简化和替换jsp页面上的java代码		





### 使用步骤：

1. 导入jstl相关jar包
2. 引入标签库：taglib指令：  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jst1/core" %>
    //指定前缀和uri，注意这个uri版本更新一点
3. 使用标签





### 常用的JSTL标签

1. if:相当于java代码的if语句
	1. 属性：
         * test 必须属性，接受boolean表达式
             * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
             * 一般情况下，test属性值会结合el表达式一起使用
	 2. 注意：
   
      * c:if标签没有else情况，想要else情况，则可以再定义一个c:if标签
   
        
        
   
2. choose:相当于java代码的switch语句
	1. 使用choose标签声明         			相当于switch声明
     2. 使用when标签做判断         			相当于case
     3. 使用otherwise标签做其他情况的声明    	相当于default

	     
	     
	
3. foreach:相当于java代码的for语句
```
foreach:相当于java代码的for语句
    1. 完成重复的操作
        for(int i = 0; i < 10; i ++){

        }
        * 属性：
            begin：开始值
            end：结束值
            var：临时变量
            step：步长
            varStatus:循环状态对象
                index:容器中元素的索引，从0开始
                count:循环次数，从1开始
                
                
    2. 遍历容器
        List<User> list;
        for(User user : list){

        }

        * 属性：
            items:容器对象 相当于 list
            var:容器中元素的临时变量  相当于 user
            varStatus:循环状态对象
                index:容器中元素的索引，从0开始
                count:循环次数，从1开始
```

### 例子1：

```jsp

<c:if test="${not empty list}">
        遍历集合...

</c:if>

<c:choose>
        <c:when test="${number == 1}">星期一</c:when>
        <c:when test="${number == 2}">星期二</c:when>
        <c:when test="${number == 3}">星期三</c:when>
        <c:when test="${number == 4}">星期四</c:when>
        <c:when test="${number == 5}">星期五</c:when>
        <c:when test="${number == 6}">星期六</c:when>
        <c:when test="${number == 7}">星期天</c:when>

        <c:otherwise>数字输入有误</c:otherwise>
 </c:choose>



<c:forEach begin="1" end="10" var="i" step="1">
    ${i}
</c:forEach>

<c:forEach items="${books}" var="book" varStatus="s">
    ${s.count}
    ${book.bname}
    ${book.author}
    ${book.press}
    <br>
</c:forEach>


```







1. 练习：
  * 需求：在request域中有一个存有User对象的List集合。需要使用jstl+el将list集合数据展示到jsp页面的表格table中





### 例子2

在day14里，建议在ide中查看学习

```jsp
<%@ page import="cn.itcast.dao.UserDao1_login_Stu" %>
<%@ page import="cn.itcast.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎选购图书</title>
</head>
<% 
	List<Book> books = dao.GetAllBooks();
    request.setAttribute("books",books);

    User user = (User)session.getAttribute("user");
    List<Book> shoppingcar = dao.GetShoppingList(user);
    request.setAttribute("shoppingcar",shoppingcar);
%>      
<body>


<%--展示购物车--%>
<hr>
<c:if test="${not empty shoppingcar}">
    <h1>我的购物车：</h1>
    <table class="table table-hover table-bordered">
        <tr>
            <th>序号</th>
            <th>书名</th>
            <th>单价</th>
            <th>数量</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${shoppingcar}" var="book" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${book.bname}</td>
                <td>${book.prize}</td>
                <td>${book.num}</td>
                <td class="success"><a href="BookServlet?action=inc&&bno=${book.bno}">增加</a></td>
                <td class="danger"><a href="BookServlet?action=dec&&bno=${book.bno}">减少</a></td>
                <td class="danger"><a href="BookServlet?action=del&&bno=${book.bno}">删除</a></td>
                <br>
            </tr>
        </c:forEach>
    <tr>
        <td colspan="5"><h3 align="right">总价：<%=TotalPrize %></h3></td>
        <td colspan="2"><h3 align="left"><font color="#ff7f50"><b>点击支付</b></font></h3></td>
    </tr>
    </table>
</c:if>
<c:if test="${empty shoppingcar}">
    <h3>现在的时间是<%=str%></h3>
    <h1><font color="#ff7f50">当前购物车为空，快去选购教材吧！读书人！</font></h1>
</c:if>

<br><br>
<%--展示书籍列表--%>
<c:if test="${not empty requestScope.books}">
    <h1> 教材列表:</h1>
    <table class="table table-bordered table-hover">
        <tr>
            <th>序号</th>
            <th>书名</th>
            <th>书号</th>
            <th>作者</th>
            <th>出版社</th>
            <th>价格</th>
            <th>操作</th>
        </tr>

    <c:forEach items="${books}" var="book" varStatus="s">
        <tr>
                <td>${s.count}</td>
                <td>${book.bname}</td>
                <td>${book.bno}</td>
                <td>${book.author}</td>
                <td>${book.press}</td>
                <td>${book.prize}</td>
                <td><a href="BookServlet?action=inc&&bno=${book.bno}">添加至购物车</a></td>
        </tr>


    </c:forEach>
    </table>
</c:if>



</body>
</html>   
```



## 三层架构：软件设计架构
1. 界面层(表示层)：用户看的得界面。用户可以通过界面上的组件和服务器进行交互
2. 业务逻辑层：处理业务逻辑的。
3. 数据访问层：操作数据存储文件。








## 案例：用户信息列表展示
	1. 需求：用户信息的增删改查操作
	2. 设计：
		1. 技术选型：Servlet+JSP+MySQL+JDBCTempleat+Duird+BeanUtilS+tomcat
		2. 数据库设计：
			create database day17; -- 创建数据库
			use day17; 			   -- 使用数据库
			create table user(   -- 创建表
				id int primary key auto_increment,
				name varchar(20) not null,
				gender varchar(5),
				age int,
				address varchar(32),
				qq	varchar(20),
				email varchar(50)
			);
	
	3. 开发：
		1. 环境搭建
			1. 创建数据库环境
			2. 创建项目，导入需要的jar包
	
		2. 编码


	4. 测试
	5. 部署运维




















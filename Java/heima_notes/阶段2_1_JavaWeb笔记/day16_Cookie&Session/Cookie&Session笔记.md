# 今日内容
	1. 会话技术
		1. Cookie
		2. Session
	2. JSP：入门学习

name value

## 会话技术
1. 会话：**一次会话中包含多次请求和响应**。
	* 一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到有一方断开为止
2. 功能：**在一次会话的范围内的多次请求间，共享数据**
3. 方式：
	1. 客户端会话技术：Cookie           (数据存到客户端)
	2. 服务器端会话技术：Session    （数据存到服务器端）

## Cookie 甜点：

##### 0、前置

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220224112216880.png" alt="image-20220224112216880" style="zoom:50%;" />

##### 1.概念：

客户端会话技术，将数据保存到客户端

##### 2.快速入门：

* 使用步骤：
	1. 创建Cookie对象，绑定数据
		* new **Cookie(String name, String value)** 
	2. 发送Cookie对象
		* **response.addCookie(Cookie cookie)** 
	3. 获取Cookie，拿到数据
		* Cookie[]  **request.getCookies()**  

**Cookie对象的方法**

cookie.getName();

cookie.getValue();

cookie.setValue(str_date);  set完之后要重新response.add，如果不add的话没用

##### 3.实现原理

* 基于**响应头set-cookie和请求头cookie**实现
	
	<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201008173816903.png" alt="image-20201008173816903" style="zoom: 67%;" />



在复习一下请求消息和响应消息

请求消息

```http
POST /login.html	HTTP/1.1                                         行
Host: localhost                                            头
User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
Accept-Encoding: gzip, deflate
Referer: http://localhost/login.html
Connection: keep-alive
Upgrade-Insecure-Requests: 1
                                                          空行
username=zhangsan		                      	请求体 POST才有
```

响应消息

```http
HTTP/1.1 200 OK								 响应行
Content-Type: text/html;charset=UTF-8			响应头
Content-Length: 101
Date: Wed, 06 Jun 2018 07:08:42 GMT
													响应空行
<html>												响应体
	<head>
    	<title>$Title$</title>
	</head>
	<body>
  		hello , response
	</body>
</html>
```





##### 4.cookie的细节

###### 一次可不可以发送多个cookie?

* 可以
* 可以创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可。



###### cookie在浏览器中保存多长时间？

1. 默认情况下，**当浏览器关闭后，Cookie数据被销毁**
2. 持久化存储：
	* **setMaxAge(int seconds)**
		1. 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效    （关闭浏览器后，仍可以 ，超越了一次会话？？？）
		2. 负数：默认值
		3. 零：删除cookie信息





###### cookie能不能存中文？

* 在tomcat 8 之前 cookie中不能直接存储中文数据。
	* 需要将中文数据转码---一般采用URL编码(%E3)
* 在tomcat 8 之后，cookie支持中文数据。特殊字符还是不支持，建议使用URL编码存储，URL解码解析









###### cookie共享问题？

1. **假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？**
	* **默认情况下cookie不能共享**

	* setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录，因此不能共享
		* **如果要共享，则可以将path设置为"/"**
	
2. 不同的tomcat服务器间cookie共享问题？

* **setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享**
				* **setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共享**





###### Cookie的特点和作用

1. cookie存储数据在客户端浏览器
2. 浏览器对于单个cookie 的大小有限制(4kb) 以及 对同一个域名下的总cookie数量也有限制(20个)

* 作用：
	1. cookie一般用于存出少量的不太敏感的数据
	2. 在不登录的情况下，完成服务器对客户端的身份识别







##### 5.案例：记住上一次访问时间

1. 需求：
	1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
	2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串

2. 分析：
	1. 可以采用Cookie来完成
	2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
		1. 有：不是第一次访问
			1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
			2. 写回Cookie：lastTime=2018年6月10日11:50:01
		2. 没有：是第一次访问
			1. 响应数据：您好，欢迎您首次访问
			2. 写回Cookie：lastTime=2018年6月10日11:50:01

```java
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有cookie为lastTime
        //2.遍历cookie数组
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是否是：lastTime
                if("lastTime".equals(name)){
                    //有该Cookie，不是第一次访问
                    flag = true;//有lastTime的cookie

                    //响应数据
                    //获取Cookie的value，时间
                    String value = cookie.getValue();
                    System.out.println("解码前："+value);
                    //URL解码：
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");

                    //设置Cookie的value
                    //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
                    Date date  = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);

                    System.out.println("编码前："+str_date);
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后："+str_date);
                    cookie.setValue(str_date);
                    //设置cookie的存活时间
                    cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
                    response.addCookie(cookie);

                    break;

                }
            }
        }//有cookie在遍历之

		//没cookie，或者有cookie但是没有lastTime，则
        if(cookies == null || cookies.length == 0 || flag == false){
            //没有，第一次访问

            //设置Cookie的value
            //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
            Date date  = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前："+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后："+str_date);

            Cookie cookie = new Cookie("lastTime",str_date);
            //设置cookie的存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```



新实验：

```jsp
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 95266
  Date: 2020/11/12
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="ErrorPage.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/test.css";>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/Demo01Servlet">
    <label for="username">Username:</label>
    <input id="username" name="username" type="text">
    <hr>

    <label for="userpswd">Password:</label>
    <input id="userpswd" name="userpswd" type="password">
    <hr>
    <h4>Please Select Your Gender:</h4>
    male<input type="radio" name="gender" value="male" checked="true"> <br>
    female<input type="radio" name="gender" value="female">
    <hr>
    <h4>Please Select Your Hobbies</h4>
    唱歌<input type="checkbox" name="hobby" value="sing"><br>
    画画<input type="checkbox" name="hobby" value="draw"><br>
    跳舞<input type="checkbox" name="hobby" value="dance">
    <hr>
    请上传文件<input type="file">
    <hr>


    <select>
        <option>xxx</option>
        <option>yyy</option>
        <option>zzz</option>
        <option selected="selected">wangchen</option>
    </select>

    submit<input type="submit">
    button<input type="button">
    image<input type="image" src="img/password.png">
</form>




<h1>下面学习CSS简单用法</h1>
<div class="ac-game-menu">
    <div class="ac-game-menu-field">
        <div class="ac-game-menu-field-item ac-game-menu-field-item-single-mode">
            单人模式
        </div>
        <br>
        <div class="ac-game-menu-field-item ac-game-menu-field-item-multi-mode">
            多人模式
        </div>
        <br>
        <div class="ac-game-menu-field-item ac-game-menu-field-item-settings">
            设置
        </div>
    </div>
</div>


<h1>下面学习Cookie</h1>
<%
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if(cookies != null && cookies.length != 0){
        for (Cookie cookie : cookies) {
            if("lastVisitTime".equals(cookie.getName())){
                flag = true;
                String value = cookie.getValue();
                value = URLDecoder.decode(value, "utf-8");
                out.print("<h1>欢迎回来，您上次访问的时间是：" +value +"</h1>");

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String newDate = sdf.format(date);
                newDate = URLEncoder.encode(newDate, "utf-8");
                cookie.setValue(newDate);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);
                break;
            }
        }
    }
    if(cookies == null || cookies.length == 0 || flag == false){
        Date date  = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        String temp = str_date;
        str_date = URLEncoder.encode(str_date,"utf-8");

        Cookie cookie = new Cookie("lastVisitTime",str_date);
        //设置cookie的存活时间
        cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
        response.addCookie(cookie);

        out.print("<h1>您好欢迎您的首次访问！！当前时间："+ temp +"</h1>");
    }

%>

<h1>下面学习Session</h1>
</body>
</html>

```




​	


## JSP：入门学习
### 概念：

* Java Server Pages： java服务器端页面
	* 可以理解为：一个特殊的页面，其中既可以指定定义html标签，又可以定义java代码
	* 用于简化书写！！！  

### 原理

* JSP本质上就是一个Servlet ，也即JSP在服务器端最终还是要被转化为Servlet，是一个.java文件，然后被客户端访问
	
	  
	
	![image-20201008212356559](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201008212356559.png)

打开这个目录![image-20201010151258687](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201010151258687.png)



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201010151324013.png" alt="image-20201010151324013" style="zoom:67%;" />

在work目录下，有**实时生成的**文件，是**运行产生**的

在cofg目录下有相关的 虚拟目录、实际项目所在位置的文件

![image-20201010151412065](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201010151412065.png)

![image-20201010151353292](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201010151353292.png)







比如我在浏览器访问了 home.jsp 和 index.jsp后就产生了，（由此可见jsp工作原理也是Servlet）![image-20201010151534538](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201010151534538.png)



看一下index_jsp.java源码 的主要部分

```java
public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase  
    //HttpJspBase是HttpServlet的子类 ，因此这个类是Servlet！！！！！!!!!!!!!
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

                     //注意，下面的方法很重要！！！！！！！！！
                     //相当于 Servlet中的Service方法
  public void _jspService
      (final javax.servlet.http.HttpServletRequest request, 
       final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException 
  //类的开始
  {
    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && 				
        							!"HEAD".equals(_jspx_method) && 
        	!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) 
    {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }
	//Service方法中的形式变量，可以有 out对象！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title>$Title$</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("  $END$\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
```

> 
>
> 
>
> 
>
> 因此我认为 jsp实际上就是Servlet，jsp文件里的内容经过映射之后就可以得到Servlet类中的**Service方法**，然后浏览器展示jsp文件时，可以理解成运行java文件







### JSP的脚本：

JSP定义Java代码的方式

1. <%  代码 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。
2. <%! 代码 %>：定义的java代码，**在jsp转换后的java类的成员位置。**
3. <%= 代码 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。



### JSP的内置对象：

* 在jsp页面中不需要获取和创建，可以直接使用的对象
* jsp一共有9个内置对象。
* 今天学习3个：
	* request
	* response
	* out：字符输出流对象。可以将数据输出到页面上。和response.getWriter()类似
		* response.getWriter()和out.write()的区别：
			* 在tomcat服务器真正给客户端做出响应之前，会先找response缓冲区数据，再找out缓冲区数据。
			* response.getWriter()数据输出永远在out.write()之前

5. 案例:改造Cookie案例




## Session 主菜：
### 1.概念：

服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存在服务器端的对象中。HttpSession





### 2.快速入门：

1. 获取HttpSession对象：
	**HttpSession session = request.getSession();**
2. 使用HttpSession对象：
	Object **getAttribute**(String name)  
	void **setAttribute**(String name, Object value)
	void **removeAttribute**(String name)  





### 3.原理

* Session的实现是依赖于Cookie的。

​	<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20201008224500732.png" alt="image-20201008224500732" style="zoom: 67%;" />
​	



### 4. 细节：

  1. 当客户端关闭后，服务器不关闭，两次获取session是否为同一个？
     ​			* 默认情况下。不是。
     ​			* 如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
     ​				 Cookie c = new Cookie("JSESSIONID",session.getId());
     ​		         c.setMaxAge(60*60);
     ​		         response.addCookie(c);

     ```java
     @WebServlet("/sessionDemo3")
     public class SessionDemo3 extends HttpServlet {
         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             //1.获取session
             HttpSession session = request.getSession();
             System.out.println(session);
             
             //期望客户端关闭后，session也能相同
             Cookie c = new Cookie("JSESSIONID",session.getId());
             c.setMaxAge(60*60);
             response.addCookie(c);
     
         }
     
         protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             this.doPost(request, response);
         }
     }
     
     ```






		2. 客户端不关闭，服务器关闭后，两次获取的session是同一个吗？
			* 不是同一个，但是要确保数据不丢失。tomcat自动完成以下工作
				* session的钝化：
			  * 在服务器正常关闭之前，将session对象系列化到硬盘上
		* session的活化：
			* 在服务器启动后，将session文件转化为内存中的session对象即可。



IDEA会钝化，但是不会活化成功。因此只能用Tomcat本地部署web项目。 （可以在IDEA中，找到部署的项目文件，然后给它们打成个war包，然后放到webapps目录中，然后启动本地tomcat后，webapps中就是自动部署这个war包所代表的项目，生成了对应的文件夹。）

创建session后，关闭服务器，在tomcat的work目录中，可以找到序列化后（钝化）的session对象存储在.ser文件中，再次启动服务器后，.ser文件又会被删除，也即session对象从磁盘中又回到了内存中



3. session什么时候被销毁？
	1. 服务器关闭
	2. session对象调用invalidate() 。
	3. session默认失效时间 30分钟
		选择性配置修改	
		<session-config>
	        <session-timeout>30</session-timeout>
	    </session-config>
	
	在tomcat中的web.xml是 父文件，具体的项目中可以覆盖







### session的特点

1. session用于存储一次会话的多次请求的数据，存在服务器端（内存或磁盘）
 2. session可以存储任意类型，任意大小的数据

* session与Cookie的区别：
	1. session存储数据在服务器端，Cookie在客户端
	2. **session没有数据大小限制，可以是个对象，   Cookie有限制，且只能是字符串**
	3. session数据安全，Cookie相对于不安全






## 案例：验证码
	1. 案例需求：
		1. 访问带有验证码的登录页面login.jsp
		2. 用户输入用户名，密码以及验证码。
			* 如果用户名和密码输入有误，跳转登录页面，提示:用户名或密码错误
			* 如果验证码输入有误，跳转登录页面，提示：验证码错误
			* 如果全部输入正确，则跳转到主页success.jsp，显示：用户名,欢迎您


	2. 分析：
	 验证码Servlet是一个请求，登录Servlet也是一个请求

```java
package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao1_login_Stu;
import cn.itcast.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode1") == null?
                request.getParameter("checkCode2"):request.getParameter("checkCode1");
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        //user用于创建user对象并封装用户名和密码
        // dao对象只是用于连接数据库 和验证操作，
        // loginUser是实际对象
        UserDao1_login_Stu dao = new UserDao1_login_Stu();
        User user = dao.login(loginUser);

        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");

        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {//验证码正确
            if (user != null) {//用户名密码匹配成功
                //登录成功！
                String remember = request.getParameter("remember");
                if (remember==null)//下面负责cookie的创建和销毁
                {//选择不记录用户名和密码
                    Cookie[] cookies = request.getCookies();
                    for (Cookie cookie : cookies) {
                        if(cookie.getName().equals("username"))
                        {
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                        }
                        if (cookie.getName().equals("password"))
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                    }
                }
                else{//记录用户名和密码
                    Cookie cookie1 = new Cookie("username", username);
                    cookie1.setMaxAge(60*10);
                    Cookie cookie2 = new Cookie("password", password);
                    cookie2.setMaxAge(60*10);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }

                session.setAttribute("user", loginUser);//设置session
                UserDao1_login_Stu dao3=new UserDao1_login_Stu();
                if(dao3.isTeacher(loginUser))
                {
                    System.out.println("跳转到老师界面");
                    response.sendRedirect("/test/TeacherHome.jsp");
                }
                else {
                    System.out.println("跳转到学生界面");
                    response.sendRedirect("/test/StudentHome.jsp");
                }
            } else {//验证码正确，但是用户名和密码不匹配
                request.setAttribute("login_error", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }


        } else {  //验证码错误！
            request.setAttribute("cc_error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
```


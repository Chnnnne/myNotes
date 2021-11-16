## 零、注意



1.启动报错！！！！！ 

解决方法

确实跟那个web.xml里的mapping有关，（但是注意 有的web项目根本没有web.xml因为创建项目时可以选择取消创建，因为利用注解就可以完成Servlet的访问设置），因此如果你有web.xml要去web.xml里找错，没的话，就直接查看你写的Servlet实现类的注解有没有问题，注意要带\。    



2.访问Servlet失败

原因：在注解中不应该写成

```java
@WebServlet(name="/source")
```

而是

```java
@WebServlet("/source")
```




## 一、Servlet：
1. 概念

2. 步骤

3. 执行原理

4. 生命周期

5. Servlet3.0 注解配置

   
### 6.Servlet的体系结构	

Servlet -- 接口   （一个孙子一个儿子）
	|
GenericServlet -- 抽象类 
	|
HttpServlet  -- 抽象类

* GenericServlet：**将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象**

   将来定义Servlet类时，**可以继承GenericServlet，实现service()方法即可**，不用再实现init destory了....，当然也可以复写。

```java
@WebServlet("/demo2")
public class ServletDemo2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo2.....");
    }
}
```



* HttpServlet：对http协议的一种封装，简化操作
		使用Httpservlet时的步骤
	1. 定义类继承HttpServlet
	2. 复写doGet/doPost方法
	

>  serive方法 ：  表单发送数据 service来获取一些数据比如 password，表单中获取的 有 get post方式

在没有出现httpservlet时，就应该↓这样做，要判断表单数据是get方式还是post方式，然后写对应的语句体。
<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200921152340225.png" alt="image-20200921152340225" style="zoom: 67%;" />



Sun公司提供了httpservlet类，它写好了service方法。 并且写了一个DoGet方法和DoPost方法，因此我们只需要在以后的编程中 先继承httpservvelt然后复写DoGet和DoPost即可
<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200921152723439.png" alt="image-20200921152723439" style="zoom:80%;" />



1.

```java
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {

    //Service方法在父类HttpServlet中
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }
}
```



> **通过浏览器直接请求是get方式**，因此执行上面代码后 是显示的doGet



2.也可以写一个html页面 然后创建表项 使用post方式





### 7.Servlet相关配置

1. urlpartten:Servlet访问路径   （浏览器上输入的）
	1. 一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
	2. 路径定义规则：
		1. /xxx：路径匹配
		2. /xxx/xxx:多层路径，目录结构
		3. /*
		4. /xxx/*
		5. *.do：扩展名匹配     （优先级低，当冲突时，它最后被选择）





> 小结： src下定义的servelet类是供浏览器访问的，浏览器通过什么找到哪一个类呢？
>
> 浏览器通过虚拟路径找到web项目 再通过 web.xml的对应 或者 注解来找到具体的类

## 二、HTTP：
### 概念

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210128214903658.png" alt="image-20210128214903658" style="zoom:50%;" />

：**Hyper Text Transfer Protocol 超文本传输协议**

* 传输协议：**定义了，客户端和服务器端通信时，发送数据的格式**
* 特点：
	1. **基于TCP/IP**的高级协议
	2. 默认端口号:80
	3. **基于请求/响应模型的:一次请求对应一次响应**
	4. 无状态的：**每次请求之间相互独立，不能交互数据**

* 历史版本：
	* 1.0：每一次请求响应都会建立新的连接
	* 1.1：复用连接

### 请求消息数据格式

出现的先后顺序：

#### 1.请求行

>  请求头在浏览器中可以查看到，请求行看不到

**请求方式    请求url     请求协议/版本**
**GET      /login.html	HTTP/1.1**

* 请求方式：
	* HTTP协议有7中请求方式，常用的有2种
		* GET：
			1. **请求参数在请求行中，在url后**。
			2. 请求的url长度有限制的
			3. 不太安全
		* POST：
			1. **请求参数在请求体中**
			2. 请求的url长度没有限制的
			3. 相对安全

> 安全是相对的， 因为如果hack拦截了请求消息，那么可以在请求体中找到你的密码

> **get方式没有请求体，而post 有**！！！！！！！！！！！！

#### 2.请求头：客户端浏览器告诉服务器一些信息

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200921161704970.png" alt="image-20200921161704970" style="zoom: 80%;" />

格式： 	`请求头名称: 请求头值`

* 常见的请求头：
	1. **User-Agent**：浏览器告诉服务器使用的浏览器版本信息
		* 可以在**服务器端**通过java代码获取该头的信息，解决浏览器的兼容性问题
  <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200921165858573.png" alt="image-20200921165858573" style="zoom: 43%;" />
	2. Referer：http://localhost/login.html
		* 告诉服务器，我(当前请求)从哪里来？
			* 作用：
				1. 防盗链：也即在服务器端，通过java代码可以获取 客户 在访问该资源而发出请求时的点击来源。
				   <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200921171004362.png" alt="image-20200921171004362" style="zoom:50%;" />
				2. 统计工作：
				   <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200921171434324.png" alt="image-20200921171434324" style="zoom: 50%;" />
	3. Accept：告诉服务器，我需要接受什么文件 （比如html xml）
	4. Accept-Language：告诉服务器我能解析的语言

#### 3.请求空行

空行，就是用于分割POST请求的请求头，和请求体的。

#### 4.请求体(正文)：

* **封装POST请求消息的请求参数的，get没有请求体**

#### 5.字符串格式示例：

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
username=zhangsan		                      	请求体
```











### 响应消息数据格式









## 三、Request：

```http
POST /login.html	HTTP/1.1              请求行
Host: localhost                            请求头
User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
Accept-Encoding: gzip, deflate
Referer: http://localhost/login.html
Connection: keep-alive
Upgrade-Insecure-Requests: 1
                                         请求空行
username=zhangsan			           请求体
```







#### 一、request对象和response对象的原理

1. request和response对象是由服务器创建的。我们来使用它们
2. request对象是来获取请求消息，response对象是来设置响应消息,然后返回给浏览器

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200921213908579.png" alt="image-20200921213908579" style="zoom:80%;" />

1.也即这个过程是这样的：客户端请求url发送到服务器端，服务器端根据url找到相应的Servlet类（一般是继承了HTTPServlet的类），然后创建其对象，调用其Service方法，并且传给Service方法两个参数：Request和Response。

#### 二、request对象继承体系结构：	

**ServletRequest**		--	接口
	|	继承
HttpServletRequest	-- 接口
	|	实现
org.apache.catalina.connector.RequestFacade 类(tomcat)







#### 三、request对象的功能：

获取请求消息数据（上面所讲的四部分内容）
##### 1.获取请求行数据

* 比如 请求行是`GET /day14/demo1?name=zhangsan HTTP/1.1`
* 方法：
	1. 获取请求方式 ：GET
		* String getMethod()  
	2. **获取虚拟目录：/day14**
		* **String getContextPath()**
	3. 获取Servlet路径: /demo1
		* String getServletPath()
	4. **获取get方式请求参数**：name=zhangsan
		* **String getQueryString()**
	5. **获取请求URI：/day14/demo1**  (虚拟目录+Servelet路径？)
		* String getRequestURI():		/day14/demo1
		* StringBuffer getRequestURL()  :http://localhost/day14/demo1

		* URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
		* URI：统一资源标识符 : /day14/demo1					共和国
	
	6. 获取协议及版本：HTTP/1.1
		* String getProtocol()

	7. 获取客户机的IP地址：
		* String getRemoteAddr()


```java
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求方式 ：GET
        String method = request.getMethod();
        System.out.println(method);
        //2.(*)获取虚拟目录：/day14
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3. 获取Servlet路径: /demo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4. 获取get方式请求参数：name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5.(*)获取请求URI：/day14/demo1
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        //6. 获取协议及版本：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7. 获取客户机的IP地址：
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
```



##### 2.获取请求头数据

* 方法：
	* **String getHeader(String name)**:**通过请求头的名称获取请求头的值**  
	* Enumeration<String> getHeaderNames():获取所有的请求头名称  （Enumeration类似iterator,用法也基本一致）

```java
@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据:user-agent
        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if(agent.contains("Chrome")){
            //谷歌
            System.out.println("谷歌来了...");
        }else if(agent.contains("Firefox")){
            //火狐
            System.out.println("火狐来了...");
        }
    }
}
```

```java
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据:referer
        String referer = request.getHeader("referer");
        System.out.println(referer);//http://localhost/day14/login.html

        //防盗链
        if(referer != null ){
            if(referer.contains("/day14")){
                //正常访问
               // System.out.println("播放电影....");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影....");
            }else{
                //盗链
                //System.out.println("想看电影吗？来优酷吧...");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看电影吗？来优酷吧...");
            }
        }

    }
}
```



##### 3.获取请求体数据:

* 请求体：**只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数**
* 步骤：
	1. 获取流对象
		*  BufferedReader getReader()：通过request对象获取字符输入流，只能操作字符数据
		*  ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据（ServletInputStream继承了InputStream）
			* 在文件上传知识点后讲解

	2. 再从流对象中拿数据

```java
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息体--请求参数

        //1.获取字符流
        BufferedReader br = request.getReader();
        //2.读取数据
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
```





#### 四、request对象的其他功能：

> 

##### **1.获取请求参数通用方式：** 





>   以前对于**GET**方式是 通过获取**请求行**中的数据来获得**请求参数**（也即调用 getQueryString()），而对于**POST**方式 是通过**请求体**，调用方法getReader() 来获得**请求参数**。 
>
> 这样很麻烦 要写两份代码，有了以下的方法之后，只需要写一份就够了(DoGet写一份，然后DoPost直接调用this.DoGet)





**不论get还是post请求方式**都可以使用下列方法来获取**请求参数**

1. **String getParameter(String name):根据参数名称获取参数值    username=zs**
2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game (多用于复选框)
3. Enumeration<String> getParameterNames():获取所有请求的参数名称
4. **Map<String,String[]> getParameterMap():获取所有参数的map集合**

```java
@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post 获取请求参数

        //根据参数名称获取参数值
        String username = request.getParameter("username");
       /* System.out.println("post");
        System.out.println(username);*/

       //根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        /*for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/

        //获取所有请求的参数名称

        Enumeration<String> parameterNames = request.getParameterNames();
        /*while(parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("----------------");
        }*/

        // 获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历 
        Set<String> keyset = parameterMap.keySet();
        for (String name : keyset) {
            
            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }

            System.out.println("-----------------");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 获取请求参数
/*
        //根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/

        this.doPost(request,response);
    }
}

```











##### 2.请求转发：

**一种在服务器内部的资源跳转方式**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200923211138555.png" alt="image-20200923211138555" style="zoom: 50%;" />



1. 步骤：
	1. 通过request对象获取请求转发器对象：**RequestDispatcher getRequestDispatcher(String path)**
	2. 使用RequestDispatcher对象来进行转发：**forward(ServletRequest request, ServletResponse response)** 


```java
@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo8888被访问了。。。");
        //转发到demo9资源

        //存储数据到request域中
        request.setAttribute("msg","hello");
        request.getRequestDispatcher("/requestDemo9").forward(request,response);
        //request.getRequestDispatcher("http://www.itcast.cn").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
```

```java
@WebServlet("/requestDemo9")
public class RequestDemo9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);

        System.out.println("demo9999被访问了。。。");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}

```

写完以上两个Servlet之后，在浏览器输入 localhost:8080/虚拟路径/url-pattern(这里用demo8),然后就可以看到输出了demo8888和demo99999 



2. 特点：

   1. **浏览器地址栏路径不发生变化**
   2. **只能转发到当前服务器内部资源中。**
   3. **转发是一次请求  (多个资源Servlet使用同一个请求)**





##### 3.共享数据：

* 域对象：一个有作用范围的对象，可以在范围内共享数据
	* request域：代表一次请求的范围，**一般用于请求转发的多个资源中共享数据**
	* 方法：
		1. void setAttribute(String name,**Object obj**):存储数据
		2. Object getAttitude(String name):通过键获取值
		3. void removeAttribute(String name):通过键移除键值对



```java
@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo8888被访问了。。。");
        //转发到demo9资源
/*
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo9");
        requestDispatcher.forward(request,response);
        */
        //存储数据到request域中
        request.setAttribute("msg","hello");
        request.getRequestDispatcher("/requestDemo9").forward(request,response);
        //request.getRequestDispatcher("http://www.itcast.cn").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
```

```java
@WebServlet("/requestDemo9")
public class RequestDemo9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);
        System.out.println("demo9999被访问了。。。");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
```



##### 4.获取ServletContext：

* **ServletContext** getServletContext()

```java
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
    }
```

![image-20200923213253302](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200923213253302.png)



#### 五、中文乱码问题：

> 背景：通过request对象来获得参数时，英文没问题，中文可能出现乱码

* get方式：tomcat 8 已经将get方式乱码问题解决了（如果你用tomcat8以上的版本用get就不会乱码）
* post方式：会乱码
  
  * 解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");  （和html一致）
  
    > **也即使用post方式 getParameter前 一般加上这句话**

```java
@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置流的编码
        request.setCharacterEncoding("utf-8");

        //获取请求参数username
        String username = request.getParameter("username");

        System.out.println(username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}

```

​					





## 案例：用户登录

### 一、用户登录案例需求：

1.编写login.html登录页面
	username & password 两个输入框
2.使用Druid数据库连接池技术,操作mysql，day14数据库中user表
3.使用JdbcTemplate技术封装JDBC
4.登录成功跳转到SuccessServlet展示：登录成功！用户名,欢迎您
5.登录失败跳转到FailServlet展示：登录失败，用户名或密码错误

> - 把相关依赖jar包，放在web目录下的WEB-INF下，创建个lib目录，如果不勾选web.xml的话没有WEB-INF目录，需要手动创建







### 二、开发步骤





**总目录结构**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200924195342954.png" alt="image-20200924195342954" style="zoom:67%;" />



1. 创建项目，
   导入html页面（login.html），
   配置文件（Druid.properties），
   jar包(数据库jar包 一个，Druid jar包 一个，Spring Template  jar包  共5个 包括一个commons     ，  mchange那个是多余的，它是c3p0所依赖的包)

   > 把相关依赖jar包，放在web目录下的WEB-INF下，创建个lib目录，如果不勾选web.xml的话没有WEB-INF目录，需要手动创建

   

   <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200924181053543.png" alt="image-20200924181053543" style="zoom:67%;" />

2. 创建数据库环境


  ```sql
  CREATE DATABASE day14;
  USE day14;
  CREATE TABLE USER(
  	id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(32) UNIQUE NOT NULL,
  PASSWORD VARCHAR(32) NOT NULL
  );
  //再往里面添加点数据
  ```





3.创建包cn.itcast.util,编写工具类JDBCUtils   （采用Druid技术）
参考以前的文档，或者在idea中查看

```java
/**
 * JDBC工具类 使用Durid连接池
 */
public class JDBCUtils {
    private static DataSource ds ;

    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader加载配置文件，获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }
    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
}
```





4.创建包cn.itcast.domain,创建类User

  ```java
   package cn.itcast.domain;
  
  public class User {
  
          private int id;
          private String username;
          private String password;	
  ​			    public int getId() {
  ​			        return id;
  ​			    }		
  ​			    public void setId(int id) {
  ​			        this.id = id;
  ​			    }		
  ​			    public String getUsername() {
  ​			        return username;
  ​			    }	
  ​			    public void setUsername(String username) {
  ​			        this.username = username;
  ​			    }
  ​			    public String getPassword() {
  ​			        return password;
  ​			    }
  ​			    public void setPassword(String password) {
  ​			        this.password = password;
  ​			    }
  ​			    @Override
  ​			    public String toString() {
  ​			        return "User{" +
  ​			                "id=" + id +
  ​			                ", username='" + username + '\'' +
  ​			                ", password='" + password + '\'' +
  ​			                '}';
  ​			    }
  			}
  ```

 

5.创建包cn.itcast.dao,创建类UserDao,提供login方法  （DataBase Access Object 数据库访问对象）

```java
/**
 * 操作数据库中User表的类
 */
public class UserDao {
    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据,没有查询到，返回null
     */
    public User login(User loginUser){
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), 
                    loginUser.getPassword()
                     );//对应?
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }
}

```



6. 编写cn.itcast.web.servlet.LoginServlet类

   ```java
   package cn.itcast.web.servlet;
   
   import cn.itcast.dao.UserDao;
   import cn.itcast.domain.User;
   import org.apache.commons.beanutils.BeanUtils;
   
   import javax.servlet.ServletException;
   import javax.servlet.annotation.WebServlet;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import java.io.IOException;
   import java.lang.reflect.InvocationTargetException;
   import java.util.Map;
   
   
   @WebServlet("/loginServlet")
   public class LoginServlet extends HttpServlet {
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           //1.设置编码
           req.setCharacterEncoding("utf-8");
           //2.获取请求参数
           String username = req.getParameter("username");
           String password = req.getParameter("password");
           //3.封装user对象
           User loginUser = new User();
           loginUser.setUsername(username);
           loginUser.setPassword(password);
           
   /*        //2.获取所有请求参数
           Map<String, String[]> map = req.getParameterMap();
           //3.创建User对象
           User loginUser = new User();
           //3.2使用BeanUtils封装
           try {
               BeanUtils.populate(loginUser,map);
               //这样以后loginUser对象就有了 map对象键值对中user和password
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           } catch (InvocationTargetException e) {
               e.printStackTrace();
           }
   
   */
           //4.调用UserDao的login方法
           //user用于创建user对象并封装用户名和密码 ，而dao对象只是用于连接数据库 和验证操作
           UserDao dao = new UserDao();
           User user = dao.login(loginUser);
   
           //5.判断user
           if(user == null){
               //登录失败
               req.getRequestDispatcher("/failServlet").forward(req,resp);
           }else{
               //登录成功
               //存储数据
               req.setAttribute("user",user);
               //转发
               req.getRequestDispatcher("/successServlet").forward(req,resp);
           }
   
       }
   
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           this.doGet(req,resp);
       }
   }
   
   ```
```
   
   
   
7. 编写FailServlet和SuccessServlet类

   ```java
   @WebServlet("/successServlet")
   public class SuccessServlet extends HttpServlet {
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取request域中共享的user对象
           User user = (User) request.getAttribute("user");
   
           if(user != null){
               //给页面写一句话
   
               //设置编码
               response.setContentType("text/html;charset=utf-8");
               //输出
               response.getWriter().write("登录成功！"+user.getUsername()+",欢迎您");
           }
   
   
       }
   
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request,response);
       }
   }
   
```

   ```java
   @WebServlet("/failServlet")
   public class FailServlet extends HttpServlet {
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //给页面写一句话
   
           //设置编码
           response.setContentType("text/html;charset=utf-8");
           //输出
           response.getWriter().write("登录失败，用户名或密码错误");
   
       }
   
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request,response);
       }
   }
   
   ```

   

8. login.html中form表单的action路径的写法：虚拟目录+Servlet的资源路径

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/day14_test/loginServlet" method="post">
        用户名:<input type="text" name="username"> <br>
        密码:<input type="password" name="password"><br>

        <input type="submit" value="登录">

    </form>
</body>
</html>
```









9. BeanUtils工具类，简化数据封装
	* 用于封装JavaBean的
	1. JavaBean：标准的Java类
		1. 要求：
			1. 类必须被public修饰
			2. 必须提供空参的构造器
			3. 成员变量必须使用private修饰
			4. 提供公共setter和getter方法
		2. 功能：封装数据

2. 概念：
	成员变量：
	属性：setter和getter方法截取后的产物
		例如：getUsername() --> Username--> username

3. 方法：
		1. setProperty()
		2. getProperty()
		3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中








## 其他

html中 input  标签 name对应提交的参数的前边，value对应提交的后边，也即  **name:value**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200923205928606.png" alt="image-20200923205928606" style="zoom: 67%;" />![image-20200923205950500](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200923205950500.png)

![image-20200923205950500](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200923205950500.png)



## URI/URL/URL

1，URI、URL和URN之间的区别

URI全名为Uniform Resource Indentifier（统一资源标识），用来唯一的标识一个资源，是一个通用的概念，URI由两个主要的子集URL和URN组成

URL全名为Uniform Resource Locator（统一资源定位），通过描述资源的位置来标识资源

URN全名为Uniform Resource Name（统一资源命名），通过资源的名字来标识资源，与其所处的位置无关，这样即使资源的位置发生变动，其URN也不会变化

HTTP规范将更通用的概念URI作为其资源标识符，但是实际上，HTTP应用程序处理的只是URI的URL子集



[他们的方法](https://blog.csdn.net/Readiay/article/details/52862379?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param)

[关系](https://www.cnblogs.com/gaojing/archive/2012/02/04/2413626.html)



## BeanUtils参考环境搭建文档
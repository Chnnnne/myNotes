## 今日内容
	1. Filter：过滤器
	2. Listener：监听器

Web三大组件：Servlet、Filter、Listener

# Filter：过滤器

### 概念：

* 生活中的过滤器：净水器,空气净化器，土匪、
* web中的过滤器：当访问服务器的资源时，过滤器可以将请求拦截下来，完成一些特殊的功能。
* 过滤器的作用：
	* 一般用于完成通用的操作。如：登录验证、统一编码处理、敏感字符过滤...

### 快速入门：

1. 定义一个类，实现接口Filter
2. 复写方法
3. 配置拦截路径有两种方法：
	1. web.xml
	2. 注解



注解方式的代码实现：

```java
@WebFilter("/*")//访问所有资源之前，都会执行该过滤器
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	System.out.println("filterDemo1被执行了....");
     	//放行操作,↓操作很重要，要记得放行操作，否则用户会卡在这
  		filterChain.doFilter(servletRequest,servletResponse);
  	}	
	@Override
	public void destroy() {
		
	}
}
```



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210203212532462.png" alt="image-20210203212532462" style="zoom: 67%;" />

执行流程：      							**浏览器 —— 过滤器    —— 服务器**



### 过滤器细节：

#### web.xml配置方式

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <welcome-file-list>
        <welcome-file> login.jsp</welcome-file>
    </welcome-file-list>

    <filter>
        <filter-name>TestFilter</filter-name>
        <filter-class>cn.itcast.web.servlet.TestFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>TestFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</web-app>		

```

#### 过滤器执行流程

1. 执行过滤器
2. 执行放行后的资源
3. 回来执行过滤器放行代码下边的代码

下面是在idea创建filter后的初始代码，

```java
package cn.itcast.test;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author WangChen
 * @create 2022-02-26 10:38
 * @project: Project03_html&css
 * @ClassName: ${NAME}
 */
@WebFilter("/*")
public class FilterDemo01 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		//对request请求消息增强
        //放行
        chain.doFilter(req, resp);
        //对response响应消息增强
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

```



#### 过滤器生命周期方法

1. init:在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
2. doFilter:每一次请求被拦截资源时，会执行。执行多次
3. destroy:在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源





####  过滤器配置详解

##### **拦截路径配置：**

1. 具体资源路径： /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
2. 拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行
    		注意访问的是WebServlet注解所写的路径，因此可以在注解中写上"/user/xxxxServlet"
3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行
4. 拦截所有资源：/*		访问所有资源时，过滤器都会被执行





##### **拦截方式配置：资源被访问的方式**

也即通过不同的方式访问资源时，过滤器进行有针对性的拦截，比如我们直接通过浏览器访问index.jsp则进行拦截，如果通过内部转发的方式访问，则不进行操作。

###### 方法一：注解配置

	* 设置dispatcherTypes属性
				1. REQUEST：默认值。浏览器直接请求资源
	2. FORWARD：转发访问资源
	3. INCLUDE：包含访问资源
	4. ERROR：错误跳转资源
	5. ASYNC：异步访问资源

注解代码：

```java
@WebFilter(value="/index.jsp",dispatcherTypes=DispatcherType.FOWARD)
@WebFilter(value="/index.jsp",dispatcherTypes={DispatcherType.FOWARD,DispatcherType.REQUEST})
```

例子1：

```java
@WebFilter(value="/index.jsp", dispatcherTypes = DispatcherType.REQUEST)//那么只有当我们直接通过浏览器访问index.jsp则进行拦截，如果通过内部转发的方式访问，则不进行操作。
public class FilterDemo01 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
```

例子2

```java
@WebFilter(value="/index.jsp",dispatcherTypes={DispatcherType.FOWARD,DispatcherType.REQUEST})//转发和直接访问index.jsp都会触发该过滤器
ublic class FilterDemo01 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
```







###### 方法二web.xml

* web.xml配置
				* 设置<dispatcher></dispatcher>标签即可



​						
​						

#### 过滤器链(配置多个过滤器)

执行顺序：如果有两个过滤器：过滤器1和过滤器2：

1. 过滤器1
2. 过滤器2
3. 资源执行
4. 过滤器2
5.  过滤器1 



那么我们现在假如定义了两个过滤器，那我们怎么样配置他们先后拦截的顺序呢

1. 注解配置：按照类名的字符串比较规则比较，值小的先执行
   * 如： AFilter 和 BFilter，AFilter就先执行了。也即类名确定
2. web.xml配置： <filter-mapping>谁定义在上边，谁先执行







### 案例

#### 案例1_登录验证

**需求**：

1. 访问day17_case案例的资源。验证其是否登录
2. 如果登录了，则直接放行。
3. 如果没有登录，则跳转到登录页面，提示"您尚未登录，请先登录"。

**原理**：

判断Session中是否有user，如果有则放行。

此外如果是登录相关的资源，比如login.jsp 

**代码**

```java
package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(req);
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源路径,要注意排除掉 css/js/图片/验证码等资源
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")  ){
            //包含，用户就是想登录。放行
            chain.doFilter(req, resp);
        }else{
            //不包含，需要验证用户是否登录
            //3.从获取session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                //登录了。放行
                chain.doFilter(req, resp);
            }else{
                //没有登录。跳转登录页面

                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
                //编程的一个小技巧，在登录界面加一项login_msg 用request共享域，来显示各种信息。
            }
        }


        // chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}

```







#### 案例2_敏感词汇过滤

##### **需求：**

	1. 对day17_case案例录入的数据进行敏感词汇过滤
	2. 敏感词汇参考《敏感词汇.txt》
	3. 如果是敏感词汇，替换为 *** 





##### **前置知识：增强对象的功能**

设计模式：一些通用的解决固定问题的方式

1.**装饰模式**

2.**代理模式**

* 概念：
  		1. 真实对象：被代理的对象
    		2. 代理对象：
    		3. 代理模式：代理对象代理真实对象，达到增强真实对象功能的目的

* 实现方式：

     1. 静态代理：有一个类文件描述代理模式，不多说

      	2. 动态代理：在内存中形成代理类，重要。
     		* 实现步骤：
     			1. 代理对象和真实对象实现相同的接口
     		2. 代理对象 = Proxy.newProxyInstance();
     		3. 使用代理对象调用方法。
     		4. 增强方法
     	 * 增强方式：
     	     					1. 增强参数列表
     	          					2. 增强返回值类型
     	               					3. 增强方法体执行逻辑

例子：

```java
package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        //1.创建真实对象
        Lenovo lenovo = new Lenovo();
        
        //2.动态代理增强lenovo对象
        /*
            三个参数：
                1. 类加载器：真实对象.getClass().getClassLoader()
                2. 接口数组：真实对象.getClass().getInterfaces()
                3. 处理器：new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {

            /*
                代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
                    参数：
                        1. proxy:代理对象
                        2. method：代理对象调用的方法，被封装为的对象
                        3. args:代理对象调用的方法时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
*/
                //判断是否是sale方法
                if(method.getName().equals("sale")){
                    //1.增强参数
                    double money = (double) args[0];
                    money = money * 0.85;
                    System.out.println("专车接你....");
                    //使用真实对象调用该方法
                    String obj = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货...");
                    //2.增强返回值
                    return obj+"_鼠标垫";
                }else{
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }



            }
        });

        //3.调用方法

       /* String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);*/

        proxy_lenovo.show();
    }
}

```

##### 原理逻辑分析：

因为我们想要过滤用户提交的信息里的敏感词汇，也即浏览器表单通过POST或GET方法向服务器提交数据，我们在Servlet中通过request.getParameter获得参数，来进行其他操作。我们需要对这些参数在到达servelt之前通过过滤器进行处理敏感词汇。这些参数需要通过request.getParameter方法来获取，很明显在过滤器中如果直接放行的话，那么我们对与Request对象，以及getParameter方法没有任何改变，这时如果我们使用代理模式来增强的话，我们可以增强getParameter方法，从而达到增强request对象的效果，然后我们用增强之后的request对象放进DoFilter里。那么这样以后，到达Servlet里的req就不是原Servlet了，而是代理对象，这样我们通过request.getParameter获取参数时，就会调用invoke方法，invoke方法再调用原getParameter方法了。

**步骤：**

1. 对request对象进行增强。增强获取参数相关方法
2. 放行。传递代理对象

​	<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220226162354947.png" alt="image-20220226162354947" style="zoom:50%;" />



**敏感词汇过滤代码的最终实现**

```java
package cn.itcast.web.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法

        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if(method.getName().equals("getParameter")){
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req,args);
                    if(value != null){
                        for (String str : list) {
                            if(value.contains(str)){
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return  value;
                }

                //判断方法名是否是 getParameterMap

                //判断方法名是否是 getParameterValue

                return method.invoke(req,args);
            }//invoke方法结束
        });//创建代理对象结束

        //2.放行
        chain.doFilter(proxy_req, resp);
    }
    private List<String> list = new ArrayList<String>();//敏感词汇集合
    public void init(FilterConfig config) throws ServletException {

        try{
            //1.获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //2.读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //3.将文件的每一行数据添加到list中
            String line = null;
            while((line = br.readLine())!=null){
                list.add(line);
            }

            br.close();

            System.out.println(list);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void destroy() {
    }

}
```



# Listener：监听器

	* 概念：web的三大组件之一。
		* 事件监听机制
			* 事件	：一件事情
			* 事件源 ：事件发生的地方
			* 监听器 ：一个对象
			* 注册监听：将事件、事件源、监听器绑定在一起。 当事件源上发生某个事件后，执行监听器代码


	* ServletContextListener:监听ServletContext对象的创建和销毁
		* 方法：
			* void contextDestroyed(ServletContextEvent sce) ：ServletContext对象被销毁之前会调用该方法
			* void contextInitialized(ServletContextEvent sce) ：ServletContext对象创建后会调用该方法
		* 步骤：
			1. 定义一个类，实现ServletContextListener接口
			2. 复写方法
			3. 配置
				1. web.xml
						<listener>
	 					 <listener-class>cn.itcast.web.listener.ContextLoaderListener</listener-class>
						</listener>
	
						* 指定初始化参数<context-param>
				2. 注解：
					* @WebListener
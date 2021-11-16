

## 一、web相关概念回顾

### 软件架构

1. C/S：客户端/服务器端
2. B/S：浏览器/服务器端

### 资源分类

1. 静态资源：所有用户访问后，得到的结果都是一样的，称为静态资源.静态资源可以直接被浏览器解析
	* 如： html,css,JavaScript
2. 动态资源:每个用户访问相同资源后，得到的结果可能不一样。称为动态资源。动态资源被访问后，需要先转换为静态资源，在返回给浏览器
	* 如：servlet/jsp,php,asp....

> 响应：客户端返回给浏览器资源
>
> 

### 网络通信三要素

1. IP：电子设备(计算机)在网络中的唯一标识。
2. 端口：应用程序在计算机中的唯一标识。 0~65536
3. 传输协议：规定了数据传输的规则
	1. 基础协议：
		1. tcp:安全协议，三次握手。 速度稍慢
		2. udp：不安全协议。 速度快


## 二、web服务器软件：
服务器：安装了服务器软件的计算机（一般来说配置比较高的计算机）

服务器软件：接收用户的请求，处理请求，做出响应

web服务器软件：接收用户的请求，处理请求，做出响应。

- 在web服务器软件中，可以部署web项目，让用户通过浏览器来访问这些项目

* web容器（动态资源在里面运行）

### 常见的java相关的web服务器软件：

* webLogic：oracle公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
* webSphere：IBM公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
* JBOSS：JBOSS公司的，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
* Tomcat：Apache基金组织(开源免费)，中小型的JavaEE服务器，仅仅支持少量的JavaEE规范servlet/jsp。开源的，免费的。

> JavaEE：Java语言在企业级开发中使用的技术规范的总和，一共规定了13项大的规范





#### Tomcat：web服务器软件

Tomcat的默认端口是8080

###### 0.目录结构

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200919110725642.png" alt="image-20200919110725642" style="zoom:50%;" />

- bin目录里有 .sh（Linux下可执行） 、     bat(批处理文件)等等     启动tomcat要去bin目录下找windows下的启动文件 
- conf目录    配置文件
- lib目录   存放的是依赖jar包
- log目录   存放的是日志文件
- temp目录  临时文件
- webapps目录（**重要**）   存放web项目           因此直接在里面创建文件夹即可完成部署工作
- work目录    存放运行时的数据

###### 1.下载：

http://tomcat.apache.org/





###### 2.安装：

解压压缩包即可。

压缩包在资料中，64位的那个

* 注意：安装目录建议不要有中文和空格





###### 3.卸载：

删除目录就行了





###### 4.启动：

* bin/startup.bat ,双击运行该文件即可
* 访问：浏览器输入：http://localhost:8080 回车访问自己
				                        http://别人的ip:8080 访问别人
我（王晨）的是192.168.154.1

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200919111027659.png" alt="image-20200919111027659" style="zoom:50%;" />

* 可能遇到的问题：

  1.黑窗口一闪而过：

  * 原因： 没有正确配置JAVA_HOME环境变量
  * 解决方案：正确配置JAVA_HOME环境变量

  2.启动报错：

  - 原因：端口号被占用，可能你启动了两次TomCat,.这个错误可以在日志信息中找到

  - 解决方案：

    ​    1.暴力：找到占用的端口号，并且找到对应的进程，杀死该进程

  ​             步骤：    
  ​                1.在cmd中，输入netstat -ano             
  ​                 2.然后找到本地地址中是8080的那个。然后对应的PID(进程ID)             
  ​                 3.在任务管理器中，关闭PID为上述PID的进程 即可

  ​            2.温柔：修改自身的端口号
  ​            步骤：

  ​                   1.在conf目录下，编辑 server.xml文件 ，改里面的端口号

  ​                    2.`` <Connector port="8888" protocol="HTTP/1.1"  t="20000" redirectPort="8445" />``

  ​                 注意：
  ​               一般会将tomcat的默认端口号修改为80。**80端口号是http协议的默认端口号**。

  ​               **好处：在访问时，就不用输入端口号**





###### 5.关闭：

1. 正常关闭：
	* bin/shutdown.bat
	* ctrl+c
2. 强制关闭：
	* 点击启动窗口的×





###### 6.配置:

部署项目的方式：
1. 直接将项目（项目文件夹，或者war文件）放到webapps目录下即可。
	* /hello：项目的访问路径，也即虚拟目录（虚拟路径就是你在浏览器上输入的）
	* 简化部署：将项目打成一个war包，再将war包放置到webapps目录下。
		* war包会自动解压缩（也即自动变成一个文件夹）








2. 配置server.xml文件，该文件在conf目录下
   在``<Host>``标签体中配置  ，自己加
   `<Context docBase="D:\hello" path="/hehe" />`

* docBase:项目存放的路径(在电脑中的路径)
* path：虚拟目录（浏览器上输入的）  虚拟目录是项目的访问方式

不建议这样配置，



3. 在conf \ Catalina \ localhost 创建任意名称的xml文件。比如说xml文件名是bbb.xml，在文件中编写
   `<Context docBase="D:\hello" />`
   现在的虚拟目录就变成了：xml文件的名称 也即bbb。因此不用写path（虚拟路径）只需要写一个docBase即可

   好处：

   - 这是热部署，不用关闭服务器，直接修改即可







## 三、静态项目和动态项目：

* java动态项目的目录结构：
	-- 项目的根目录
		-- WEB-INF目录：
			-- web.xml：web项目的核心配置文件
			-- classes目录：放置字节码文件的目录
			-- lib目录：放置依赖的jar包





## 四、将Tomcat集成到IDEA中，

[这个讲得很好](https://blog.csdn.net/weixin_43716048/article/details/108639475)

并且创建JavaEE的项目，部署项目。

##### 步骤：

1. Run   -   Edit Configurations   -   Templates   -  Tomcat Server  - local
2. 在右侧面板中 的Sever中 点击 Configuration
3. 在弹出的面板中  选择配置Tomcat Home  （我的是在D:\develop\tomcat，然后点选apache-tomcat-8.5.31 ，到这就行了，不用再打开了）





##### 这就配置好了，下面可以检测一下是否安装好

1. Run   -   Edit Configurations   -   Templates   -  Tomcat Server  - local
2. 在右侧面板中 的Sever中 点击 Configuration，可以看到 加減号，以及class文件 jar包





##### 部署WEB项目（为了让用户访问嘛）

1. new 一个 模块 Module  
2. 选择Java Enterprise，version选择Java EE 7，选择Web Application勾上
3. 起个名字

> 此方法已失效，具体请参考上面的链接。要add framwork



##### 分析

1. 可以看到模块下 有src web 
2. 其中web下有WEB-INF
3. 有index.jsp   这个比较特殊，它是在浏览器上输入ip+端口，以及web项目名（我这里是day13_tomcat）之后直接默认打开的





##### 运行

1. 在Run   -   Edit Configurations   中有了一个Tomcat Server/Tomcat 8.5.31
2. 点击Deployment，可以看到day13_tomcat项目已经部署到tomcat里（war包形式）
3. 在下面还可以设置Application contexts，也即虚拟目录，可以设置成一个/  ,则表示不需要使用虚拟目录了，也即在访问localhost:8080时，不用输入web项目名day13_tomcat，即可进入day13_tomcat项目
4. 需要注意的是   访问项目下的web目录下的 html文件时，路径不用加web，而是直接项目名\html名



##### 配置

1. 在Run   -   Edit Configurations   -Tomcat Server-Tomcat 8.5.31，可以选择On Update action 和On frame deactivation中可以选择 Update resource实现热部署的功能



##### 此外

[为什么IDEA启动Tomcat后，无法访问tomcat首页 也即http://localhost:8080/](https://blog.csdn.net/qq_22708467/article/details/79070973)

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200920105630790.png" alt="image-20200920105630790" style="zoom: 67%;" />





## Servlet：  

server applet

#### 概念：

运行在服务器端的小程序。**说白了就是自己定义类实现Servlet接口。然后用户通过配置信息输入路径即可完成访问**

* Servlet就是一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则。
* 将来我们自定义一个类，实现Servlet接口，复写方法。

A servlet is a small Java program that runs within a Web server
**运行在Web服务器上 的 一个Java程序**

![image-20200919191111318](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200919191111318.png)

#### 快速入门：

1. 创建JavaEE项目

2. 定义一个类，实现Servlet接口

  ```java
  public class ServletDemo1 implements Servlet {
      @Override
      public void init(ServletConfig servletConfig) throws ServletException {
      }
  
      @Override
      public ServletConfig getServletConfig() {
          return null;
      }
  
      //提供服务的方法
      @Override
      public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
          System.out.println("Hello Servlet");
      }
      @Override
      public String getServletInfo() {
          return null;
      }
      @Override
      public void destroy() {
      }
  }
  ```

  

3. 实现接口中的抽象方法

4. 配置Servlet
	 在web.xml中配置：
    
    ```xml
    <!--配置Servlet -->
    <servlet>
        <servlet-name>demo1</servlet-name>
    	<servlet-class>cn.itcast.web.servlet.ServletDemo1</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>demo1</servlet-name>
        <url-pattern>/demo1</url-pattern>
    </servlet-mapping>
    ```
    
    

#### 执行原理：

1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
3. 如果有，则在找到对应的<servlet-class>全类名
4. tomcat会将字节码文件加载进内存，并且创建其对象
5. 调用其方法

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200919202108446.png" alt="image-20200919202108446" style="zoom: 50%;" />

几点注意：

1. url-pattern 对应虚拟路径，也即在浏览器上输入的路径
2. 然后根据url-pattern找到servlet-name 然后在找到servlet-class,然后tomcat找到该类后，加载进内存然后创建对象，然后执行service





#### Servlet中的生命周期方法：

###### 被创建

：执行init方法，只执行一次



1.Servlet什么时候被创建？默认情况下，第一次被访问时，Servlet被创建

​		可以配置执行Servlet的创建时机:(在<servlet>标签下配置)
​		1.第一次被访问时，创建:<load-on-startup>的值为负数
​		2.在服务器启动时，创建:<load-on-startup>的值为0或正整数



2.Servlet的init方法，只执行一次，说明**一个Servlet在内存中只存在一个对象，Servlet是单例的**

* 多个用户同时访问时，可能存在线程安全问题。
* 解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，也不要对修改值



例如

```xml
<!--
根据/demo1找到对应的url-pattern然后找到name然后找到class，然后执行service
根据load-on-startup 5 得到服务器tomcat一启动就执行init，而不是访问到该虚拟路径
 -->
<servlet>
    <servlet-name>demo1</servlet-name>
    <servlet-class>cn.itcast.web.servlet.ServletDemo1</servlet-class>
    <load-on-startup>5</load-on-startup> 
</servlet>

<servlet-mapping>
    <servlet-name>demo1</servlet-name>
    <url-pattern>/demo1</url-pattern>
</servlet-mapping>
```





###### 提供服务

：执行service方法，执行多次

* 每次访问Servlet时，Service方法都会被调用一次。





###### 被销毁

：执行destroy方法，只执行一次

* Servlet被销毁时执行。                    那么什么时候Servlet被销毁呢？服务器关闭时
* 只有服务器正常关闭时，才会执行destroy方法。
* destroy方法在Servlet被销毁之前执行，一般用于释放资源



###### 除此之外

还有
public ServletConfig getServletConfig()      其中ServletConfig对象是Serverlet的配置对象
和
public String getServletInfo()              获取Servelt的一些信息







#### Servlet3.0：

* 好处：
	* 支持注解配置。可以不需要web.xml了。

* 步骤：
	1. 创建JavaEE项目，选择Servlet的版本3.0以上，可以不创建web.xml
	2. 定义一个类，实现Servlet接口
	3. 复写方法
	4. 在类上使用@WebServlet注解，进行配置
		* @WebServlet("资源路径")



> java EE6之后才支持3.0版本

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200919221050401.png" alt="image-20200919221050401" style="zoom:50%;" />

例子

```java
package cn.itcast.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo2")
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {


    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet3.0来了.....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
```







	    @Target({ElementType.TYPE})
		@Retention(RetentionPolicy.RUNTIME)
		@Documented
		public @interface WebServlet {
		    String name() default "";//相当于<Servlet-name>
	    String[] value() default {};//代表urlPatterns()属性配置
	
	    String[] urlPatterns() default {};//相当于<url-pattern>
	
	    int loadOnStartup() default -1;//相当于<load-on-startup>
	
	    WebInitParam[] initParams() default {};
	
	    boolean asyncSupported() default false;
	
	    String smallIcon() default "";
	
	    String largeIcon() default "";
	
	    String description() default "";
	
	    String displayName() default "";
	}











## IDEA与tomcat的相关配置

##### 一、IDEA会为每一个tomcat部署的项目单独建立一份配置文件

* 查看控制台的log：Using CATALINA_BASE:   "C:\Users\fqy\.IntelliJIdea2018.1\system\tomcat\_itcast"
* 我的（王晨）的是C:\Users\95266\AppData\Local\JetBrains\IntelliJIdea2020.1\tomcat\_Project03_html&css

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200920111425273.png" alt="image-20200920111425273" style="zoom:67%;" />

可以看到我所部署的  两个WEB项目  所**对应的配置文件**在这里，打开一个看看：

![image-20200920111557343](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200920111557343.png)

发现里面写的有 path（虚拟路径） 和 docBase（实际访问路径）可以用于浏览器访问项目时，找到实际项目路径 。这是热部署，不写path也行，因为xml文件名即是虚拟路径。











##### 二、工作空间项目    和     tomcat部署的web项目

* tomcat真正访问的是“**tomcat部署的web项目**”，"**tomcat部署的web项目**"对应着"**工作空间项目**" 的**web**目录下的所有资源



打开项目文件夹啊

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200920111916203.png" alt="image-20200920111916203" style="zoom:50%;" />
**项目的out文件夹下的artifact文件下即是  tomcat集成到IDEA后 所创建的WEB项目**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200920112106911.png" alt="image-20200920112106911" style="zoom:50%;" />

打开后发现：
<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200920112144637.png" alt="image-20200920112144637" style="zoom:50%;" />

**部署的WEB项目**的文件结构和**IDEA工作空间中的web文件夹**内容一致

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200920112239765.png" alt="image-20200920112239765" style="zoom: 67%;" />

但是不同的是在WEB项目的文件夹结构中的**WEB-INF**内容更多，**它还有IDEA工作空间src下的class文件**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200920112416836.png" alt="image-20200920112416836" style="zoom:67%;" />







* **WEB-INF目录下的资源不能被浏览器直接访问。**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200920112600124.png" alt="image-20200920112600124" style="zoom:50%;" />

**因此不要把一些资源放到WEB-INF中**





##### 三、断点调试

：使用"小虫子"启动 dubug 启动
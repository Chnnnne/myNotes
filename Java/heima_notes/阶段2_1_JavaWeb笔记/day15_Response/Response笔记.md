# 今日内容

	1. HTTP协议：响应消息
	2. Response对象
	3. ServletContext对象

/      除号 、网址、注释
\       文件路径  

## HTTP协议：

### 请求消息：

客户端发送给服务器端的数据

* 数据格式：
	1. 请求行
	2. 请求头
	3. 请求空行
	4. 请求体

### 响应消息：

服务器端发送给客户端的数据

#### 响应字符串格式

```http
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Length: 101
Date: Wed, 06 Jun 2018 07:08:42 GMT

<html>
	<head>
    	<title>$Title$</title>
	</head>
	<body>
  		hello , response
	</body>
</html>
```



数据格式：

#### 一、响应行

1. 组成：**协议/版本   响应状态码   状态码描述**
            **HTTP/1.1      200        OK**
2. 响应状态码：**服务器告诉客户端浏览器本次请求和响应的一个状态。**
	1. 状态码都是3位数字 
	2. 分类：
		1. 1xx：服务器就收客户端消息，但没有接受完成，等待一段时间后，发送1xx多状态码
		2. 2xx：成功。代表：200
		3. 3xx：重定向。代表：302(重定向)，304(访问缓存)
		
		   
		
		   <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200925181922562.png" alt="image-20200925181922562" style="zoom: 50%;" />
		
		   <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200925181847277.png" alt="image-20200925181847277" style="zoom:50%;" />
		4. 4xx：客户端错误。
			
			* 代表：
				* 404（请求路径没有对应的资源） 
				* 405：请求方式没有对应的doXxx方法
		5. 5xx：服务器端错误。代表：500(服务器内部出现异常,服务器内部写的Servelt类中代码写的有错误)


​					
#### 二、响应头：

1. 格式：
   **头名称： 值**
2. 常见的响应头：
	1. **Content-Type**：服务器告诉客户端本次<u>响应体数据格式以及编码格式j</u>
	
	   ```http
	   Content-Type: text/html;charset=UTF-8
	   ```
	
	   **Content-disposition**：服务器告诉客户端以什么格式打开响应体数据
	
	   * 值：
	   	* in-line:默认值,在**当前页面内打开**
	   	* attachment;filename=xxx：以**附件形式打开响应体。文件下载**

#### 三、响应空行





#### 四、响应体:

**传输的数据**

字符串数据html  或者    图片：二进制数据



## Response对象
**功能：设置响应消息**

#### 1.设置响应行

1. 格式：HTTP/1.1 200 ok
2. 设置状态码：**setStatus(int sc)** 

#### 2.设置响应头

：**setHeader(String name, String value)** 

response.setHeader("content-type","text/html;charset=utf-8"); 
response.setContentType("text/html;charset=utf-8");  

#### 3.设置响应体：

* 使用步骤：
	1. 获取输出流
		* 字符输出流：PrintWriter **getWriter()**

		* 字节输出流：ServletOutputStream **getOutputStream()       （**当做OutputStream来使用）
2. 使用输出流，将数据输出到客户端浏览器



#### 重定向的URL中文问题

用这句话 response.sendRedirect("/day15/responseDemo2");来重定向时，如果不通过uRL传值的话，没有问题若想通过URL传值，且是中文的话，那么就错了！！！，经过试验要这样

```java
response.sendRedirect("TeaCorStu.jsp?Cname="+ URLEncoder.encode(cname,"utf-8"));
```

不知道原理是啥。。。

#### 案例：

##### 1、完成重定向

* 重定向：资源跳转的方式

* 代码实现：
	
  1. **设置状态码为302**
  2. **设置响应头location**
  
  ```java
   response.setStatus(302);
   response.setHeader("location","/day15/responseDemo2");
  ```
  
     **简单的重定向方法    二者等价**
  
  ```java
   response.sendRedirect("/day15/responseDemo2");
  ```
  
     <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200927153228040.png" alt="image-20200927153228040" style="zoom: 50%;" />
  
  
  
  
  
  
  
  

##### 1.4重定向与转发





  **（重定向时写写虚拟路径）**

* **重定向**的特点:redirect                   （客户端多次访问，也即服务器外跳转）
	
	1. **地址栏发生变化**
	
	2. **重定向可以访问其他站点(服务器)的资源**
	
	3. **重定向是两次请求，同时也会对应两次响应(因为HTTP模型是一对一的)。不能使用request对象来共享数据**
	
	   ```java
	   // response.setStatus(302);
	   // response.setHeader("location","/day15/responseDemo2");
	   response.sendRedirect("/day15/responseDemo2");
	   ```
	   
	   <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200927155118578.png" alt="image-20200927155118578" style="zoom:67%;" />
	   
	   
	   
	   
	   
	
* **转发**的特点：forward               （服务器内部跳转）
	
	1. **转发地址栏路径不变**
	2. **转发只能访问当前服务器下的资源**
	3. **转发是一次请求，可以使用request对象来共享数据**
	
```java
request.getRequestDispatcher("/requestDemo9").forward(request,response);
```



* forward 和  redirect 区别
	
	
	
	
	
	<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200927153228040.png" alt="image-20200927153228040" style="zoom: 50%;" />
	
	<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200923211138555.png" alt="image-20200923211138555" style="zoom: 50%;" />
	
	
	
	
##### 1.5、路径写法：

路径分类
1. 相对路径：通过相对路径不可以确定唯一资源
	* 如：**./index.html**
	* 不以/开头，**以.或..开头路径**

	* 规则：**找到当前资源和目标资源之间的相对位置关系**
		* ./：当前目录   （./可省略）
		
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
> 1.要首先明确使用绝对还是相对路径，  (用谁都行，这俩路径只是找到资源的两种方式)
> 2使用**绝对路径的话    （/开头），然后再确定资源给谁用的（确定是否写虚拟路径）**
> 2使用相对路径的话  （.开头），确定位置关系		





​						

##### 2、服务器输出字符数据到浏览器

* 步骤：
	1. **获取字符输出流**
	
2. **输出数据**   (可以输出 html标签)
	
	   ```java
	   @WebServlet("/responseDemo4")
	   public class ResponseDemo4 extends HttpServlet {
	       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	           //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
	          // response.setCharacterEncoding("utf-8");
	   
	           //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
	           //response.setHeader("content-type","text/html;charset=utf-8");
	   
	           //简单的形式，设置编码
	           response.setContentType("text/html;charset=utf-8");
	           //1.获取字符输出流
	           PrintWriter pw = response.getWriter();
	           //2.输出数据
	           //pw.write("<h1>hello response</h1>");
	           pw.write("你好啊啊啊 response");
	       }
	   
	       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	           this.doPost(request,response);
	       }
	   }
	   
	```
	
	   
	
	   
	
* 注意：
	* 乱码问题：
		1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
		2. 设置该流的默认编码
		3. 告诉浏览器响应体使用的编码

		//简单的形式，设置编码，**是在获取流之前设置** ，之后就晚了
		response.setContentType("text/html;charset=utf-8");

> 仅仅设置从response获得的流的编码 **response.setCharacterEncoding("utf-8");**这是不够的，还要告诉浏览器用什么解码**response.setHeader("content-type","text/html;charset=utf-8");** 
>
> 因此需要以上两个步骤  （实际上后面一个就够了）  实际上 这一句**response.setContentType("text/html;charset=utf-8");**也就够了





##### 3、服务器输出字节数据到浏览器

* 步骤：
	1. 获取字节输出流
	2. 输出数据

```java
@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.获取字节输出流
        ServletOutputStream sos = response.getOutputStream();
        //2.输出数据
        sos.write("你好".getBytes("utf-8"));
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
```







##### 4、验证码

1. 本质：图片
2. 目的：防止恶意表单注册

**CheckCodeServlet.java**

```java
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        //1.创建一对象，在内存中图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.PINK);//设置画笔颜色
        g.fillRect(0,0,width,height);

        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width - 1,height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //2.3写验证码
            g.drawString(ch+"",width/5*i,height/2);
        }

        //2.4画干扰线
        g.setColor(Color.GREEN);

        //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

```

register.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script>
        /*
            分析：
                点击超链接或者图片，需要换一张
                1.给超链接和图片绑定单击事件

                2.重新设置图片的src属性值

         */
    window.onload = function(){
        //1.获取图片对象
        var img = document.getElementById("checkCode");
        //2.绑定单击事件
        img.onclick = function(){
            //加时间戳
            var date = new Date().getTime();

            img.src = "/day15/checkCodeServlet?"+date;
        }

    }


    </script>


</head>
<body>


    <img id="checkCode" src="/day15/checkCodeServlet" />

    <a id="change" href="">看不清换一张？</a>

</body>
</html>
```





## ServletContext对象：
#### 一、概念：

代表整个web应用，可以和程序的容器(服务器)来通信
Defines a set of methods that a servlet uses to coummuicate with its servlet container, for example, to get the MIME type of a file,dispath requests or write to a log file
定义了很多Servlet能用的方法 能够去和Servlet的容器通信，比如 

#### 二、获取：

1. 通过request对象获取
	**request.getServletContext();**
2. 通过HttpServlet获取
	**this.getServletContext();**

两种方式 完全等价





#### 三、功能：

##### 1、获取MIME类型：

> **在互联网传输中，response返回中，需要告诉服务器解析引擎我服务器response的文件的格式，而这个格式就是MIME类型 ，如html类型的文件对应的就是 text/html        jpg 对应的是 image/jpeg**

* MIME类型:在互联网**通信过程中**定义的一种文件数据类型
	* 格式： 大类型/小类型   text/html		image/jpeg
* 获取：String getMimeType(String file)  







##### 2、域对象：共享数据

1. setAttribute(String name,Object value)
2. getAttribute(String name)
3. removeAttribute(String name)

* ServletContext对象范围：**所有用户所有请求的数据**  它从服务器开始到结束都存在，所有对象都可访问，谨慎使用





##### 3、获取文件的真实(服务器)路径

1. 方法：**String getRealPath(String path)**  
	 String b = context.getRealPath("/b.txt");//**web目录下资源访问**
      System.out.println(b);

     String c = context.getRealPath("/WEB-INF/c.txt");//**WEB-INF目录下的资源访问**
     System.out.println(c);

     String a = context.getRealPath("/WEB-INF/classes/a.txt");//**src目录下的资源访问**
     System.out.println(a);

> 目的是为了以后的数据传输，因为文件传输需要路径。 而路径的获取就要这样来获得， 先决知识是了解IDEA的WEB项目的目录结构

## 案例：
	* 文件下载需求：
		1. 页面显示超链接
		2. 点击超链接后弹出下载提示框
		3. 完成图片文件下载


	* 分析：
		1. 超链接指向的资源如果能够被浏览器解析，则在浏览器中展示，如果不能解析，则弹出下载提示框。不满足需求
		2. 任何资源都必须弹出下载提示框
		3. 使用响应头设置资源的打开方式：
			* content-disposition:attachment;filename=xxx


	* 步骤：
		1. 定义页面，编辑超链接href属性，指向Servlet，传递资源名称filename
		2. 定义Servlet
			1. 获取文件名称
			2. 使用字节输入流加载文件进内存
			3. 指定response的响应头： content-disposition:attachment;filename=xxx
			4. 将数据写出到response输出流


	* 问题：
		* 中文文件问题
			* 解决思路：
				1. 获取客户端使用的浏览器版本信息
				2. 根据不同的版本信息，设置filename的编码方式不同
download.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


    <a href="/day15_response_war_exploded/img/jiuwei.jpg">图片1</a>

    <a href="/day15_response_war_exploded/img/1.avi">视频</a>
    <hr>
    <hr>


    <a href="/day15_response_war_exploded/downloadServlet?filename=jiuwei.jpg">图片1</a>

    <a href="/day15_response_war_exploded/downloadServlet?filename=1.avi">视频</a>




</body>
</html>
```



**downloadServlet.java**

```java
package cn.itcast.web.download;

import cn.itcast.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式:content-disposition
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }

        fis.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

```


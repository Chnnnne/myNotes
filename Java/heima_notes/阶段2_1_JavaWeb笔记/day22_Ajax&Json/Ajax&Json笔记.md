# AJAX：
	1. 概念： ASynchronous JavaScript And XML	异步的JavaScript 和 XML
		1. 异步和同步：客户端和服务器端相互通信的基础上
			* 客户端必须等待服务器端的响应。在等待的期间客户端不能做其他操作。
			* 客户端不需要等待服务器端的响应。在服务器处理请求的过程中，客户端可以进行其他的操作。
	
			Ajax 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术。 [1] 
			通过在后台与服务器进行少量数据交换，Ajax 可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。
			传统的网页（不使用 Ajax）如果需要更新内容，必须重载整个网页页面。
	
			提升用户的体验
	
	2. 实现方式：
		1. 原生的JS实现方式（了解）
					 //1.创建核心对象
		            var xmlhttp;
		            if (window.XMLHttpRequest)
		            {// code for IE7+, Firefox, Chrome, Opera, Safari
		                xmlhttp=new XMLHttpRequest();
		            }
		            else
		            {// code for IE6, IE5
		                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		            }
		
		            //2. 建立连接
		            /*
		                参数：
		                    1. 请求方式：GET、POST
		                        * get方式，请求参数在URL后边拼接。send方法为空参
		                        * post方式，请求参数在send方法中定义
		                    2. 请求的URL：
		                    3. 同步或异步请求：true（异步）或 false（同步）
		
		             */
		            xmlhttp.open("GET","ajaxServlet?username=tom",true);
		
		            //3.发送请求
		            xmlhttp.send();
		
		            //4.接受并处理来自服务器的响应结果
		            //获取方式 ：xmlhttp.responseText
		            //什么时候获取？当服务器响应成功后再获取
		
		            //当xmlhttp对象的就绪状态改变时，触发事件onreadystatechange。
		            xmlhttp.onreadystatechange=function()
		            {
		                //判断readyState就绪状态是否为4，判断status响应状态码是否为200
		                if (xmlhttp.readyState==4 && xmlhttp.status==200)
		                {
		                   //获取服务器的响应结果
		                    var responseText = xmlhttp.responseText;
		                    alert(responseText);
		                }
		            }
		2. JQeury实现方式
			1. $.ajax()
				* 语法：$.ajax({键值对});
				 //使用$.ajax()发送异步请求
		            $.ajax({
		                url:"ajaxServlet1111" , // 请求路径
		                type:"POST" , //请求方式
		                //data: "username=jack&age=23",//请求参数
		                data:{"username":"jack","age":23},
		                success:function (data) {
		                    alert(data);
		                },//响应成功后的回调函数
		                error:function () {
		                    alert("出错啦...")
		                },//表示如果请求响应出现错误，会执行的回调函数
		
		                dataType:"text"//设置接受到的响应数据的格式
		            });
			2. $.get()：发送get请求
				* 语法：$.get(url, [data], [callback], [type])
					* 参数：
						* url：请求路径
						* data：请求参数
						* callback：回调函数
						* type：响应结果的类型
	
			3. $.post()：发送post请求
				* 语法：$.post(url, [data], [callback], [type])
					* 参数：
						* url：请求路径
						* data：请求参数
						* callback：回调函数
						* type：响应结果的类型



# JSON：

### 概念： 

JavaScript Object Notation		JavaScript对象表示法
Person p = new Person();
p.setName("张三");
p.setAge(23);
p.setGender("男");

var p = {"name":"张三","age":23,"gender":"男"};

* json现在多用于存储和交换文本信息的语法
* 进行数据的传输
* JSON 比 XML 更小、更快，更易解析。



### 语法：

#### 基本规则

* json数据是由**键值对**构成的
* **键**可以用**引号**(单双都行)引起来，也可以**不使用**引号
* **值**的取值类型：
  1. 数字（整数或浮点数）
  2. 字符串（在双引号中）
  3. 逻辑值（true 或 false）
  4. 数组（在方括号中）	{"persons":[{},{}]}
  5. 对象（在花括号中） {"address":{"province"："陕西"....}}
  6. null
* 数据由逗号分隔：多个键值对由逗号分隔
* **花括号保存对象**：使用{}定义json 格式
* **方括号保存数组**：[]



#### 获取数据:

	1. **json对象**.键名
	2. **json对象**["键名"]                 需要加引号
	3. **数组对象**[索引]
	4. 遍历


```json
         	//1.定义基本格式
	        var person = {"name": "张三", age: 23, 'gender': true};
        	var ps = [{"name": "张三", "age": 23, "gender": true},
            {"name": "李四", "age": 24, "gender": true},
            {"name": "王五", "age": 25, "gender": false}];

			//遍历person
            //获取person对象中所有的键和值
            //for in 循环
            for(var key in person){
            	//这样的方式获取不行。因为相当于  person."name"
            	//alert(key + ":" + person.key);
            	alert(key+":"+person[key]);
            }

			//遍历ps
            //获取ps中的所有值
            for (var i = 0; i < ps.length; i++) {
            	var p = ps[i];
            	for(var key in p){
            		alert(key+":"+p[key]);
            	}
            }
```



### JSON数据和Java对象的相互转换

* JSON解析器：
		* 常见的解析器：Jsonlib，Gson，fastjson，jackson



#### JSON转为Java对象

1. 导入jackson的相关jar包

2. 创建Jackson核心对象 ObjectMapper

3. 调用ObjectMapper的相关方法进行转换
      		1. readValue(json字符串数据,Class)

#### Java对象转换JSON

1. 使用步骤：
	1. 导入jackson的相关jar包，如下三个
	   ![image-20220227113457940](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220227113457940.png)
	   
	2. 创建Jackson核心对象 ObjectMapper
	
   3. 调用ObjectMapper的相关方法进行转换
   	1. 转换方法：
   		* writeValue(参数1，obj):
                 参数1：
                     File：将obj对象转换为JSON字符串，并保存到指定的文件中
	                  Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
	                  OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
	          
			    * writeValueAsString(obj):将对象转为json字符串
			    
			      <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220227124207123.png" alt="image-20220227124207123" style="zoom:50%;" />
			
		2. 注解：
			1. @JsonIgnore：排除属性。
			
			   ```java
			   //在一个JavaBean的成员域上面加上：
			       @JsonIgnore
			   	private Date birthday;
			   ```
			
			   
			
			2. @JsonFormat：属性值得格式化
				
				```java
				@JsonFormat(pattern = "yyyy-MM-dd")
				private Date birthday;
				```
				
				
			
		3. 复杂java对象转换
			1. List：数组
			2. Map：对象格式一致





```java
package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.FileWriter;
import java.util.*;

public class JacksonTest {


    //Java对象转为JSON字符串
    @Test
    public void test1() throws Exception {
        //1.创建Person对象
        Person p  = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //2.创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /*

            转换方法：
                writeValue(参数1，obj):
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串

         */
        String json = mapper.writeValueAsString(p);
        //{"name":"张三","age":23,"gender":"男"}
        //System.out.println(json);//{"name":"张三","age":23,"gender":"男"}



        //writeValue，将数据写到d://a.txt文件中
        //mapper.writeValue(new File("d://a.txt"),p);

        //writeValue.将数据关联到Writer中
        mapper.writeValue(new FileWriter("d://b.txt"),p);
    }


    @Test
    public void test2() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());



        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);

        System.out.println(json);
//{"name":"张三","age":23,"gender":"男"}//在birthday属性上加上@JsonIgnore时
    
//{"name":"张三","age":23,"gender":"男","birthday":1530958029263} //这是不加任何注解的情况
//{"name":"张三","age":23,"gender":"男","birthday":"2018-07-07"} //在birthday属性上加上@JsonFormat(pattern = "yyyy-MM-dd")时
    }



    @Test
    public void test3() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());


        //创建List集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);


        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
 /*
[{"name":"张三","age":23,"gender":"男","birthday":"2018-07-07"},
{"name":"张三","age":23,"gender":"男","birthday":"2018-07-07"},
{"name":"张三","age":23,"gender":"男","birthday":"2018-07-07"}]
*/
        System.out.println(json);
    }

    @Test
    public void test4() throws Exception {
        //1.创建map对象
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");


        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        //{"name":"张三","age":23,"gender":"男"}
        System.out.println(json);//{"gender":"男","name":"张三","age":23}
    }

    //演示 JSON字符串转为Java对象
    @Test
    public void test5() throws Exception {
       //1.初始化JSON字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";

        //2.创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //3.转换为Java对象 Person对象
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);
    }

}

```

```java
public class Person {
    private String name;
    private int age ;
    private String gender;

    //@JsonIgnore 		// 忽略该属性
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
```




# 案例：
	* 校验用户名是否存在
		1. 服务器响应的数据，在客户端使用时，要想当做json数据格式使用。有两种解决方案：
			1. $.get(type):将最后一个参数type指定为"json"
			2. 在服务器端设置MIME类型
				response.setContentType("application/json;charset=utf-8");






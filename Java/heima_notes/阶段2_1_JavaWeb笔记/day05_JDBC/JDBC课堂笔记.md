> 循序渐进： 
>
> 
>
> 1、JDBC
>
> 思路：我们希望通过统一的java代码规范，代码语言，来调用不同的数据库，因此我们需要定义规则叫做叫做jdbc，*（JDBC本质：其实是官方（sun公司）定义的一套操作所有**关系型数据库**的规则，即**接口**。**各个数据库厂商去实现这套接口，提供数据库驱动jar包**。我们可以使用这套接口（JDBC）编程，**真正执行的代码是驱动jar包中的实现类**。）*
>
> 因此我们需要导我们所使用的数据的包，比如mysql-connector-java-5.1.37-bin.jar
>
> 这样以后，我们就可以通过如下的步骤和代码来实现连接数据库了.
>
> <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220210221317274.png" alt="image-20220210221317274" style="zoom: 50%;" />
>
> ```java
> Class.forName("com.mysql.jdbc.Driver");    //把这个类的字节码文件加载进内存了并且完成了注册驱动
> Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
> String sql = "update account set balance = 500 where id = 1";    //注意不要加分号
> Statement stmt = conn.createStatement();
> int count = stmt.executeUpdate(sql);
> System.out.println(count);
> stmt.close();
> conn.close();
> ```
>
> 
>
> 2、JDBC+工具类
>
> 更进一步：
>
> 我们发现这样做有很多缺点，首先就是代码很长比较繁琐，其次是不灵活，因为我们直接把配置写到了代码里，这样很不规范，我们应该把配置单独写到一个文件里，供程序读取，这样我们只修改配置文件就可以了。
>
> 因此，我们可以采用下面大标题  **抽取JDBC工具类 ： JDBCUtils**的步骤，来创建一个工具类，这样我们就方便了很多，代码更标准，且配置容易修改了。此时的目录结构很简单，就是libs（存放各种jar包）、package01（我们写代码的地方）、Utils（里面写工具类）、jdbc.properties（配置文件）
>
> 
>
> 3、数据库连接池+工具类+JDBC
>
> 再更进一步：
>
> 我们上述的那样，其实效率很低，因为实际的情况下，是用户需要完成查询操作，每个用户的请求被tomcat接受后，都会开一个线程处理，然后完成链接的建立、查询、释放的操作，这样很慢，且耗费资源，为此我们引入**数据库连接池**的概念，好处：节约资源、用户访问高效。
>
> 首先，我们需要导一些依赖jar包，以Druid为例。步骤是：导入jar包 、定义配置文件、加载配置文件、获取数据库连接池对象、获取连接 （注意我所说的这些步骤同样是麻烦的，可以参考md文件，我们同样需要定义工具类来简化）请参考md文件。此时的目录结构是
>
> 
>
> 4、数据库连接池+JDBCTemplate+工具类+JDBC
>
> 这样以后，想一下还不是很方便，因为我们需要建立连接，释放资源，这些代码还是要写，而且对于查询语句不太好操作，要定义sql字符串，获取preparestatement对象，赋值，执行，释放连接。而且对于处理查询操作也很麻烦。我们可以用JDBC Template ，这是Spring框架对JDBC的简单封装，它可以更方便。   使用这一套，不用释放，不用归还连接了。不用申请资源，不用释放连接。
>
> 步骤：1.同样先导入各种jar包，截止到目前，我们需要导入mysql的一个，druid的一个，jdbctemplate的一堆 2.工具类还是以前的， 3.在主代码处，通过JdbcTemplate template = new JdbcTemplate(ds);   对象来操作数据库，这样就很方便了。
>
> 
>
> 最终版目录结构，详细说明：
>
> <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220211111639162.png" alt="image-20220211111639162" style="zoom:67%;" />
>
> 0.首先把spring的一堆包和jdbc的一个，druid的一个导进来。
>
> 1.配置文件properties在src下，
>
> 2.domain里定义JavaBean（规范：类名UpperCase，变量名LowerCase，数据库全小写）
>
> 3.libs
>
> 4.utils写工具类，工具类是使用了数据库连接池的。
>
> 5.package写其他代码
>
> 层次：JDBC、JDBC+工具类、数据库连接池+工具类+JDBC、数据库连接池+JDBCTemplate+工具类+JDBC





## 今日内容

	1. JDBC基本概念
	2. 快速入门
	3. 对JDBC中各个接口和类详解

## JDBC：

#### **1.概念：**

Java DataBase Connectivity           Java 数据库连接， Java语言操作数据库

* JDBC本质：其实是官方（sun公司）定义的一套操作所有**关系型数据库**的规则，即**接口**。**各个数据库厂商去实现这套接口，提供数据库驱动jar包**。我们可以使用这套接口（JDBC）编程，**真正执行的代码是驱动jar包中的实现类**。
* 也即实现通过不变java代码，只需要不同的jar包就可以操作不同的数据库

因此如果你想使用mysql数据库你就需要先把mysql数据库提供的jar包导入到项目里。如果使用sun公司的，就导sun公司的jar包







#### 2 快速入门：



##### 2.1步骤：

1. **导入驱动jar包 mysql-connector-java-5.1.37-bin.jar**
	1.复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下  （在模块下，new 新建directory）
	2.右键-->Add As Library
2. **注册驱动    （MySQL数据库驱动加载）**-Class.forName(“com.mysql.jdbc.Driver”);     
                             这步只是单纯告诉JVM使用哪个类型的数据库（是mysql啊 还是 微软的啊？还是其他的）还没有完成连接
     DriverManager是驱动管理对象（一个类），此步注册驱动应该写成DriverManager类调用 register方法啊？   但ForName 方法把masql的jar中的类加载进了内存，并且执行了静态代码块，块内 有 DriverManager调用regisiter, 因此使用forName就可以完成<u>加载类</u>与<u>注册驱动</u>这两个功能了
3. **获取数据库连接对象 Connection   （建立数据库连接）**
4. **定义sql    （获取SQL语句对象）**
5. **获取执行sql语句的对象 Statement**  
6. **执行sql，接受返回结果**
7. **处理结果**
8. **释放资源**

##### 2.2代码实现：

```java
Class.forName("com.mysql.jdbc.Driver");    //把这个类的字节码文件加载进内存了并且完成了注册驱动
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
String sql = "update account set balance = 500 where id = 1";    //注意不要加分号
Statement stmt = conn.createStatement();
int count = stmt.executeUpdate(sql);
System.out.println(count);
stmt.close();
conn.close();
```



#### 3.详解各个对象：

###### DriverManager：驱动管理对象

* 功能：  
	1. ==**注册驱动：告诉程序该使用哪一个数据库驱动jar**==  （因为jdbc接口并无实际代码，jar包里才有jdbc的实现类）
		
		 DriverManager类中有静态方法：   `static void registerDriver(Driver driver)`   
		
		**但是写代码使用：  Class.forName("com.mysql.jdbc.Driver");**
		
		
		
		
		
		
	
	通过查看源码发现：在com.mysql.jdbc.Driver类中存在静态代码块  ，因此用forName加载com.mysql.jdbc.Driver时会执行下面的静态代码块，完成注册驱动   （源码的查看 ，可以在src-com-mysql-jdbc文件夹中找到Driver类）
		
	```java
	 static {
	        try {
	            java.sql.DriverManager.registerDriver(new Driver());   <-这个才应该是 注册驱动的代码！！！！
	        } catch (SQLException E) {
	            throw new RuntimeException("Can't register driver!");
	        }
	}
	```
	
	
	​	
	
	注意：**mysql 5之后的驱动jar包可以省略注册驱动的步骤**。在 META-INF文件夹 的services文件夹中 有java.sql.Driver文件，里面写的有com.mysql.jdbc.Driver这几个词。因此如果你不手写注册驱动，它会读取这个文件，来注册驱动
	
	
	​	
	
	2. **获取数据库连接：**
	
	  * 方法：static Connection getConnection(String url, String user, String password) 
	  * 参数：
	  	* url：指定连接的路径      url指定了ip port 和具体哪一个数据库，不同的数据库类型，url语法不一样，比如微软的数据库可能就不这样写了
	        		* 语法：**jdbc : mysql :// ip地址(域名) : 端口号 / 数据库名称**
	                		* 例子：jdbc:mysql://localhost:3306/db3
	                  
	            
	            	* 细节：如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，则url可以简写为：**jdbc:mysql:///数据库名称**    也即把ip和端口省略了
	  	* user：用户名
	   * password：密码 
	
	        
	
	        
	
	        
	
	        
	
	        
	
	        

###### Connection：数据库连接对象

1. 功能：                 （代表代码 与 数据库 之间的桥梁）
	1. 获取执行sql 的对象
		* Statement createStatement()
		* PreparedStatement prepareStatement(String sql)  
	2. 管理事务：
		* 开启事务：setAutoCommit(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
		* 提交事务：commit() 
		* 回滚事务：rollback() 
		
		  
		
		  
		
		  
		  

###### Statement：执行sql的对象

1. 执行sql
	1. boolean execute(String sql) ：可以执行任意的sql        了解 
	2. int executeUpdate(String sql) ：执行DML（**insert、update、delete**）语句、DDL(**create，alter、drop**表 )语句
		* 返回值：<u>影响的行数</u>，可以通过这个影响的行数判断DML语句是否执行成功 返回值>0的则执行成功，反之，则失败。
	3. ResultSet executeQuery(String sql)  ：执行DQL（select)语句
2. 练习：
	1. account表 添加一条记录
	2. account表 修改记录
	3. account表 删除一条记录

	代码：
	
   
   ```java
   Statement stmt = null;
   Connection conn = null; //注意这种写法     
    //因为有异常所以要处理,你可以直接throw掉，但是这不是一种好的方式
   //你也可以 try-catch了，  注意因为无论如何 资源最终都要释放，因此要在finally中写释放资源的语句块，此时如果在try中定义对象的话，会导致try中作用域 进入不了catch中导致finally中无法释放，因此把statement和connection放在外边。另外注意的是要判断是否为空，因为对于空对象调用close方法会出现空指针异常
   try {
    //1. 注册驱动
   	Class.forName("com.mysql.jdbc.Driver");
   //2. 定义sql
   	String sql = "insert into account values(null,'王五',3000)";
   //3.获取Connection对象
   	conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root"); //此步可能出错，conn可能为null
   //4.获取执行sql的对象 Statement
   	stmt = conn.createStatement();		//上一步出错或下一步出错都将使stmt为null，从而影响finally的资源
   //5.执行sql
   	int count = stmt.executeUpdate(sql);//影响的行数
    //6.处理结果
        System.out.println(count);
      if(count > 0){
        System.out.println("添加成功！");
   }else{
        System.out.println("添加失败！");
   	 }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        //7. 释放资源
        //避免空指针
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   ```

例子:

```java
public class JDBCDemo2 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 定义sql
            String sql = "insert into account values(null,'王五',30000)";
            //3.获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            //4.获取执行sql的对象 Statement
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);//影响的行数
            //6.处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //stmt.close();
            //7. 释放资源
            //避免空指针异常
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
```









###### ResultSet：结果集对象,封装查询结果

 查询结果就是一个列表，而resultset封装了查询结果也即封装了列表

* boolean next(): 游标向下移动一行，判断当前行是否是最后一行末尾(是否有数据)，如果是，则返回false，如果不是则返回true     (1. 下移一行    2. 判断有无)

  

  

* Xxx getXxx(参数):获取数据
	* Xxx：代表数据类型   如： int getInt() ,	String getString()
	* 参数：
		1. int：代表列的编号,从1开始   如： getString(1)
		2. String：代表列名称。 如： getDouble("balance")

* 注意：
	* 使用步骤：
		1. 游标向下移动一行
		2. 判断是否有数据
		3. 获取数据

	   //循环判断游标是否是最后一行末尾。
         while(rs.next()){
             //获取数据
             //6.2 获取数据
             int id = rs.getInt(1);
             String name = rs.getString("name");
             double balance = rs.getDouble(3);
         System.out.println(id + "---" + name + "---" + balance);
     }
  
* 练习：
	* 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
		1. 定义Emp类
		2. 定义方法 public List<Emp> findAll(){}
		3. 实现方法 select * from emp;

```java
package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 */
public class JDBCDemo8 {

    public static void main(String[] args) {
        List<Emp> list = new JDBCDemo8().findAll2();
        System.out.println(list);
        System.out.println(list.size());
    }

    
    //方法1
    public List<Emp> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            //3.定义sql
            String sql = "select * from emp";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Emp emp = null;
            list = new ArrayList<Emp>();
            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象,并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                //装载集合
                list.add(emp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    
    

    
	//方法2   （同时借助下面的工具类）
    public List<Emp> findAll2(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            conn = JDBCUtils.getConnection();
            
            String sql = "select * from emp";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Emp emp = null;
            list = new ArrayList<Emp>();
            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象,并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                //装载集合
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }

}
```

工具类

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200707172109033.png" alt="image-20200707172109033" style="zoom:50%;" />

```java
package cn.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 文件的读取，只需要读取一次即可拿到这些值。使用静态代码块
     */
    static{
        try {
//1.创建Properties集合类。
            Properties pro = new Properties();
//获取src路径下的文件的方式--->ClassLoader 类加载器    //也可以不用类加载器，直接指定路径
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();

//2. 加载文件
            pro.load(new FileReader(path));
// pro.load(new FileReader("D:\\IdeaProjects\\itcast\\day04_jdbc\\src\\jdbc.properties"));
            //3. 获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4. 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

```







###### PreparedStatement：执行sql的对象

1. SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。会造成安全性问题
	
2. 输入用户随便，输入密码：a' or 'a' = 'a    这样拼接之后

      ```sql
      String sql="select * from user where username='"+username+"'and password='"+password+"'";
      ```
      
      ​      就产生了如下的效果


```sql

  select * from user where username = 'fhdsjkf' and password = 'a' or 'a' = 'a'    
```

2. 解决sql注入问题：使用PreparedStatement对象来解决

3. 预编译的SQL：参数使用?作为占位符

   - 静态的sql 都是拼接好后生成的sql
   - 预编译的sql

4. 步骤：
	1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
	2. 注册驱动
	3. 获取数据库连接对象 Connection
	4. 定义sql
		
		* 注意：sql的参数使用？作为占位符。 如：select * from user where username = ? and password = ?;
	5. 获取执行sql语句的对象 PreparedStatement  Connection.prepareStatement(String sql) 
	6. 给？赋值：
		* 方法： setXxx(参数1,参数2)
			* 参数1：？的位置编号 从1 开始
			* 参数2：？的值
	7. 执行sql，接受返回结果，不需要传递sql语句
	8. 处理结果
	
9. 释放资源
	
	   
	
5. <u>注意：后期都会使用PreparedStatement来完成增删改查的所有操作</u>
	
	1. <u>可以防止SQL注入</u>
	
2. <u>效率更高</u>
	
	<u>以后用statement用的少 ，  preparement用的多</u>

```java
package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * 事务操作
 */
public class JDBCDemo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            //2.定义sql
            //2.1 张三 - 500
            String sql1 = "update account set balance = balance - ? where id = ?";
            //2.2 李四 + 500
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3.获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4. 设置参数
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);

            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);
            //5.执行sql
            pstmt1.executeUpdate();
            // 手动制造异常
            int i = 3/0;

            pstmt2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //事务回滚
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt1,conn);
            JDBCUtils.close(pstmt2,null);
        }


    }

}
```











## 抽取JDBC工具类 ： JDBCUtils

### 1.自己的实现

使用工具类的目的就是为了方便，简化代码的书写，

使用工具类前需要注意的是：

1. 自己创个util包，在里面写个util类，具体代码参看下面的

   

   

2. 自己写个配置proerties文件，如图<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200913195534410.png" alt="image-20200913195534410" style="zoom: 50%;" />

   

   

   

3. 在文件里写上信息<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200913195614840.png" alt="image-20200913195614840" style="zoom:50%;" />

4. 然后就可以用了

**util类**

```java
package demo03_JDBC.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author WangChen
 * @create 2020-07-13 18:21
 */
public class JDBC_Utils {
//静态变量才能被静态代码块、静态方法所访问
    private static String url;
    private static String user;
    private static String password;
    private  static String driver;
    static {
        try {
            Properties pro=new Properties();
            //注意 不写绝对路径时，根目录为project路径
            pro.load(new FileReader("Module02_JavaWeb\\src\\jdbc.properties"));
            /*
                获取src路径下文件的方法(注意是project下的src 而不是模块下的src)：
                用ClassLoader类加载器
                可以加载字节码文件进内存
                可以获取src下资源文件的路径
			   替代写法：  （使用替代写法的前提是：该目标文件properties在project下的src目录下）
               
                ClassLoader classLoader = JDBC_Utils.class.getClassLoader();
                URL url1 = classLoader.getResource("src下的文件名");//注意根路径为src
                String path = url1.getPath();
                pro.load(new FileReader(path));
             */
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");

            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Connection con,Statement sta)
    {
        if(sta!=null)
        {
            try {
                sta.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(con!=null)
        {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(Connection con, Statement sta, ResultSet res)
    {
        if (res!=null) {
            try {
                res.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(sta!=null)
        {
            try {
                sta.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(con!=null)
        {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

```

**使用工具类编程**

```java
package demo03_JDBC.test02;

import demo03_JDBC.util.JDBC_Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author WangChen
 * @create 2020-07-13 19:20
 */
public class Demo01_util {
    public static void main(String[] args) {
        Connection con=null;
        Statement sta=null;
        ResultSet res=null;
        try {
            con=JDBC_Utils.getConnection();
            sta = con.createStatement();
            String sql="select * from student";
            res = sta.executeQuery(sql);

            while (res.next())
            {
                String name=res.getString("name");
                String sex=res.getString("sex");
                int age=res.getInt("age");
                System.out.println("name:"+name+"sex:"+sex+"age:"+age);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC_Utils.close(con,sta,res);
        }

    }
}
```

登录的练习 java

```java
package demo03_JDBC.test02;

import demo03_JDBC.util.JDBC_Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author WangChen
 * @create 2020-07-13 21:31
 */
public class Demo02_login {

    /**
     * 登录函数
     * @param username
     * @param password
     * @return 登录是否成功
     */
    public boolean login(String username,String password)
    {
        if(username==null||password==null)
            return false;
        
        Connection con =null;
        Statement sta =null;
        ResultSet res=null;
        try {
            con = JDBC_Utils.getConnection();
            sta = con.createStatement();
            String sql="select * from user where username='"+username+"'and password='"+password+"'";
            res = sta.executeQuery(sql);

            return res.next();//有下一个则返回true
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC_Utils.close(con,sta,res);
        }

        return false;
    }

    public static void main(String[] args) {
        //键盘录入
        Scanner sc=new Scanner(System.in);
        System.out.println("Plz enter your userword");
        String username = sc.nextLine();
        System.out.println("Plz enter your password");
        String password = sc.nextLine();
        //注意上面的登录方法 不是静态方法 需要创建对象
        boolean logflag = new Demo02_login().login(username, password);
        if (logflag)
            System.out.println("登录成功");
        else
            System.out.println("登陆失败");
    }
}
```







### 2.老师的实现

	* 目的：简化书写
	* 分析：
		1. 注册驱动也抽取
		2. 抽取一个方法获取连接对象
			* 需求：不想传递参数（麻烦），还得保证工具类的通用性。
			* 解决：配置文件
				jdbc.properties
					url=
					user=
					password=


```java
	3. 抽取一个方法释放资源

* 代码实现：
	public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 文件的读取，只需要读取一次即可拿到这些值。使用静态代码块
     */
    static{
        //读取资源文件，获取值。

        try {
            //1. 创建Properties集合类。
            Properties pro = new Properties();

            //获取src路径下的文件的方式--->ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res  = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);///D:/IdeaProjects/itcast/out/production/day04_jdbc/jdbc.properties
            //2. 加载文件
           // pro.load(new FileReader("D:\\IdeaProjects\\itcast\\day04_jdbc\\src\\jdbc.properties"));
            pro.load(new FileReader(path));

            //3. 获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4. 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
	    /**
	     * 获取连接
	     * @return 连接对象
	     */	    public static Connection getConnection() throws SQLException {

	        return DriverManager.getConnection(url, user, password);
	    }
	
	    /**
	     * 释放资源
	     * @param stmt
	     * @param conn
	     */
	    public static void close(Statement stmt,Connection conn){
	        if( stmt != null){
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        if( conn != null){
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }


​	
​	    /**
​	     * 释放资源
​	     * @param stmt
​	     * @param conn
​	     */
​	    public static void close(ResultSet rs,Statement stmt, Connection conn){
​	        if( rs != null){
​	            try {
​	                rs.close();
​	            } catch (SQLException e) {
​	                e.printStackTrace();
​	            }
​	        }
​	
​	        if( stmt != null){
​	            try {
​	                stmt.close();
​	            } catch (SQLException e) {
​	                e.printStackTrace();
​	            }
​	        }
​	
​	        if( conn != null){
​	            try {
​	                conn.close();
​	            } catch (SQLException e) {
​	                e.printStackTrace();
​	            }
​	        }
​	    }
​	
​	}
```




	* 练习：
		* 需求：
			1. 通过键盘录入用户名和密码
			2. 判断用户是否登录成功
				* select * from user where username = "" and password = "";
				* 如果这个sql有查询结果，则成功，反之，则失败
	
		* 步骤：
			1. 创建数据库表 user
				CREATE TABLE USER(
					id INT PRIMARY KEY AUTO_INCREMENT,
					username VARCHAR(32),
					PASSWORD VARCHAR(32)
				
				);
	
				INSERT INTO USER VALUES(NULL,'zhangsan','123');
				INSERT INTO USER VALUES(NULL,'lisi','234');
	
			2. 代码实现：
				public class JDBCDemo9 {
	
				    public static void main(String[] args) {
				        //1.键盘录入，接受用户名和密码
				        Scanner sc = new Scanner(System.in);
				        System.out.println("请输入用户名：");
				        String username = sc.nextLine();
				        System.out.println("请输入密码：");
				        String password = sc.nextLine();
				        //2.调用方法
				        boolean flag = new JDBCDemo9().login(username, password);
				        //3.判断结果，输出不同语句
				        if(flag){
				            //登录成功
				            System.out.println("登录成功！");
				        }else{
				            System.out.println("用户名或密码错误！");
				        }
				        ​				
	​				    }


​	
​					
​					
​					    /**
​	​				     * 登录方法
​	​				     */
​	​				    public boolean login(String username ,String password){
​	​				        if(username == null || password == null){
​	​				            return false;
​	​				        }
​	​				        //连接数据库判断是否登录成功
​	​				        Connection conn = null;
​	​				        Statement stmt =  null;
​	​				        ResultSet rs = null;
​	​				        //1.获取连接
​	​				        try {
​	​				            conn =  JDBCUtils.getConnection();
​	​				            //2.定义sql
​	​				            String sql = "select * from user where username = '"+username+"' and password = '"+password+"' ";
​	​				            //3.获取执行sql的对象
​	​				            stmt = conn.createStatement();
​	​				            //4.执行查询
​	​				            rs = stmt.executeQuery(sql);
​	​				            //5.判断
​	​				           /* if(rs.next()){//如果有下一行，则返回true
​	​				                return true;
​	​				            }else{
​	​				                return false;
​	​				            }*/
​	​				           return rs.next();//如果有下一行，则返回true
​	​				
​	​				        } catch (SQLException e) {
​	​				            e.printStackTrace();
​	​				        }finally {
​	​				            JDBCUtils.close(rs,stmt,conn);
​	​				        }
​	
​					        return false;
​	​				    }
​	​				}


​	














## JDBC控制事务：
1. 事务：一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。
2. 操作：
	1. 开启事务
	2. 提交事务
	3. 回滚事务
3. 使用Connection对象来管理事务
	* 开启事务：setAutoCommit(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
		* 在执行sql之前开启事务
	* 提交事务：commit() 
		* 当所有sql都执行完提交事务
	* 回滚事务：rollback() 
		* 在catch中回滚事务                            	

4. 代码：

```java
	public class JDBCDemo10 {

	    public static void main(String[] args) {
	        Connection conn = null;
	        PreparedStatement pstmt1 = null;
	        PreparedStatement pstmt2 = null;
	
	        try {
	            //1.获取连接
	            conn = JDBCUtils.getConnection();
	            //开启事务
	            conn.setAutoCommit(false);
	
	            //2.定义sql
	            //2.1 张三 - 500
	            String sql1 = "update account set balance = balance - ? where id = ?";
	            //2.2 李四 + 500
	            String sql2 = "update account set balance = balance + ? where id = ?";
	            //3.获取执行sql对象
	            pstmt1 = conn.prepareStatement(sql1);
	            pstmt2 = conn.prepareStatement(sql2);
	            //4. 设置参数
	            pstmt1.setDouble(1,500);
	            pstmt1.setInt(2,1);
	
	            pstmt2.setDouble(1,500);
	            pstmt2.setInt(2,2);
	            //5.执行sql
	            pstmt1.executeUpdate();
	            // 手动制造异常
	            int i = 3/0;
	
	            pstmt2.executeUpdate();
	            //提交事务
	            conn.commit();
	        } catch (Exception e) {
	            //事务回滚
	            try {
	                if(conn != null) {
	                    conn.rollback();
	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	            e.printStackTrace();
	        }finally {
	            JDBCUtils.close(pstmt1,conn);
	            JDBCUtils.close(pstmt2,null);
	        }
}
		
		}


```


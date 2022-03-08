



## 数据库连接池
#### 一、概念：

其实就是一个容器(集合)，存放数据库连接的容器。   （频繁的建立连接，调用底层，效率是很低的）
    当系统初始化好后，容器被创建，容器中会申请一些连接对象，当用户来访问数据库时，从容器中获取连接对象，用户访问完之后，会将连接对象归还给容器。

#### 二、好处：

1. 节约资源
2. 用户访问高效





#### 三、实现：

1. 标准接口：DataSource   javax.sql包下的            
	
	> （也即类似jdbc ，sun公司程序员只是提供了接口，也即定义了一些规则。而具体的类实现 是一些公司实现的，他们实现DataSource接口之后提供了一些jar包，我们导入之后就能利用接口编程了） 
	
1. 方法：
		* 获取连接：getConnection()
		* 归还连接：Connection.close()。<u>如果连接对象Connection是从连接池中获取的，那么调用Connection.close()方法，则不会再关闭连接了。而是归还连接</u>
	
2. 一般我们不去实现它，由数据库厂商来实现
	1. C3P0：数据库连接池技术
	2. Druid：数据库连接池实现技术，由阿里巴巴提供的





#### 四、C3P0：

数据库连接池技术

* 步骤：
	1. 导入jar包 (两个) c3p0-0.9.5.2.jar 和 mchange-commons-java-0.2.12.jar （前者c3p0的jar包依赖mchange的jar包）
		
		* **同时不要忘记导入数据库驱动jar包**!!!
		
		  <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200924150051500.png" alt="image-20200924150051500" style="zoom:67%;" />
	
		  
		
		  
		
	2. 定义配置文件：
	  * 名称： c3p0.properties 或者 c3p0-config.xml
	
	  * 路径：直接将文件放在项目的src目录下即可。
	
	    <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200924145505621.png" alt="image-20200924145505621" style="zoom:67%;" />
	    以下是c3p0-config.xml的文件内容
	
	    ```xml
	    <c3p0-config>
	      <!-- 使用默认的配置读取连接池对象 -->
	      <default-config>
	      	<!--  连接参数 -->
	        <property name="driverClass">com.mysql.jdbc.Driver</property>
	        <property name="jdbcUrl">jdbc:mysql://localhost:3306/db1</property>
	        <property name="user">root</property>
	        <property name="password">root</property>
	        
	        <!-- 连接池参数 -->
	        <!--初始化申请的连接数量-->
	        <property name="initialPoolSize">5</property>
	        <!--最大的连接数量-->
	        <property name="maxPoolSize">10</property>
	        <!--超时时间-->
	        <property name="checkoutTimeout">3000</property>
	      </default-config>
	    
	      <named-config name="otherc3p0"> 
	        <!--  连接参数 -->
	        <property name="driverClass">com.mysql.jdbc.Driver</property>
	        <property name="jdbcUrl">jdbc:mysql://localhost:3306/db3</property>
	        <property name="user">root</property>
	        <property name="password">root</property>
	        
	        <!-- 连接池参数 -->
	        <property name="initialPoolSize">5</property>
	        <property name="maxPoolSize">8</property>
	        <property name="checkoutTimeout">1000</property>
	      </named-config>
	    </c3p0-config>
	    ```
	
	    注意观察这个代码有重复的地方这是为什么呢？C3p0很人性化，他提供了多个配置，在建立数据库连接池时可以选择使用哪一个，默认的话使用 default config
	    ![image-20200924150501651](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200924150501651.png)
	
	    <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200924150628582.png" alt="image-20200924150628582" style="zoom:67%;" />
	
	3. 创建核心对象 数据库连接池对象 DataSource ds  = new ComboPooledDataSource();
	4. 获取连接：Connection conn = ds.getConnection();
	
* 代码演示：
	
   ```java
   public class C3P0Demo1 {
       public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象
           DataSource ds  = new ComboPooledDataSource();
	        //2. 获取连接对象
	        Connection conn = ds.getConnection();
	        //3. 打印
	        System.out.println(conn);
	    }
	}
	```
	
	

#### 五、Druid

：数据库连接池实现技术，由阿里巴巴提供的

##### 步骤：

1. 导入jar包        druid-1.0.9.jar   , mysql的别忘了
2. 定义配置文件：
	* 是properties形式的
	* 可以叫任意名称，可以放在任意目录下，因此需要手动加载
	
	  <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200924150914954.png" alt="image-20200924150914954" style="zoom:67%;" />
	
	  
	
	  <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200924150928993.png" alt="image-20200924150928993" style="zoom:67%;" />
	
	  
	
3. 加载配置文件。Properties
4. 获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
5. 获取连接：getConnection

* 代码：
	
   ```java
   /**
    * Druid演示
    */
   public class DruidDemo {
       public static void main(String[] args) throws Exception {
           //1.导入jar包
           //2.定义配置文件
           //3.加载配置文件
           Properties pro = new Properties();
           InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
           pro.load(is);
           //4.获取连接池对象
           DataSource ds = DruidDataSourceFactory.createDataSource(pro);
           //5.获取连接
           Connection conn = ds.getConnection();
           System.out.println(conn);
   
       }
   }
   ```
   
   
##### 定义工具类

采用上述的连接池技术后，工具类也要跟着完善。

1. 定义一个包、一个类 JDBCUtils
2. 在JDBCUtils类中提供静态代码块加载配置文件，初始化连接池对象
3. 提供方法
  1. 获取连接方法：通过数据库连接池获取连接
  2. 释放资源
  3. 获取连接池的方法  （有些框架，不需要直接获取接连，而是只用获取数据库连接池对象）

**JDBCUtils实现代码**

```java
/**
 * Druid连接池的工具类
 */
public class JDBCUtils {
    //1.定义成员变量 DataSource
    private static DataSource ds ;

    static{
        try {
            //1.加载配置文件
            Properties pro = new Properties();
   pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement stmt,Connection conn){
       /* if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

       close(null,stmt,conn);
    }


    public static void close(ResultSet rs , Statement stmt, Connection conn){
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
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 获取连接池方法
     */
    public static DataSource getDataSource(){
        return  ds;
    }

}

```

**利用工具类完成的实例**

```java
package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {

    public static void main(String[] args) {
        /*
         * 完成添加操作：给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into account values(null,?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给？赋值
            pstmt.setString(1,"王五");
            pstmt.setDouble(2,3000);
            //5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. 释放资源
            JDBCUtils.close(pstmt,conn);
        }
    }

}
```







## Spring JDBC

* Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC的开发

### 步骤：

1. **导入jar包**

   下面是需要导入的            (另外还有数据库一个 和Druid  一个也要)
    <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200924153534049.png" alt="image-20200924153534049" style="zoom:67%;" />

   
   
2. **创建JdbcTemplate对象。依赖于数据源DataSource**  （数据库连接池对象）
* JdbcTemplate template = new JdbcTemplate(ds);  
	**因此需要编写Druid对应的Utils工具类**
3. **调用JdbcTemplate的方法来完成CRUD的操作**

    1. **int   update(sql, ....对应？的参数)**:执行DML语句。**增、删、改**语句

    
    ​	2.**Map<String, Object>   queryForMap(sql,....对应？的参数):** 

   **查询**结果将结果集封装为map集合，将列名作为key (String 类型)，将值作为value (Object类型)将这条记录封装为一个map集合

       - 注意：这个方法查询的结果集长度只能是1   因此查询的记录只能是1不能有多条，0都不行。也即是一行，而不是多行，每行可以有好几列


​    

​		3..**List<Map<String, Object>>     queryForList(sql,....对应？的参数)**:查询结果将结果集封装为list集合
注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中

​    ​        注意它永远不可能为null，只是为空时，map长度为0， 用isEmpty判断
​    

4. **query(sql, new RowMapper<Emp>()):**查询结果，将结果封装为JavaBean对象
       query的参数：RowMapper

      - ​	一般我们使用**BeanPropertyRowMapper实现类**。可以完成数据到JavaBean的自动封装

      - new BeanPropertyRowMapper<类型>(类型.class)
   
        ```java
         List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        ```

        

     5.**queryForObject**：查询结果，将结果封装为对象      **一般用于聚合函数的查询**
   
      ```java
    Long total = template.queryForObject(sql, Long.class);
      ```
   
      ```java
           try {
               String sql = "select * from user where username = ? and password = ?";
               User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
               return user;
           } catch (Exception e) {
               e.printStackTrace();
               return null;	//当查询不到结果时，在catch中返回null
           }
      ```
   
   
   
   
   
   

```java
  /**
   * JdbcTemplate入门
   */
  public class JdbcTemplateDemo1 {
      public static void main(String[] args) {
          //1.导入jar包
          //2.创建JDBCTemplate对象
          JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
          //3.调用方法
          String sql = "update account set balance = 5000 where id = ?";
          int count = template.update(sql, 3);
          System.out.println(count);
      }
  }
  //不用释放，不用归还
```

  

### 练习（多看）：

* 需求：
	1. 修改1号数据的 salary 为 10000
	2. 添加一条记录
	3. 删除刚才添加的记录
	4. 查询id为1的记录，将其封装为Map集合
	5. 查询所有记录，将其封装为List   
	6. 查询所有记录，将其封装为Emp对象的List集合    注意！要用包装类
	7. 查询总记录数

* 代码：
	
	```java
	public class JdbcTemplateDemo2 {
	    //Junit单元测试，可以让方法独立执行
	    //1. 获取JDBCTemplate对象
	    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	    /**
	     * 1. 修改1号数据的 salary 为 10000
	     */
	    @Test
	    public void test1(){
	        //2. 定义sql
	        String sql = "update emp set salary = 10000 where id = 1001";
	        //3. 执行sql
	        int count = template.update(sql);
	        System.out.println(count);
	    }
	
	    /**
	     * 2. 添加一条记录
	     */
	    @Test
	    public void test2(){
	        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
	        int count = template.update(sql, 1015, "郭靖", 10);
	        System.out.println(count);
	    }
	    /**
	     * 3.删除刚才添加的记录
	     */
	    @Test
	    public void test3(){
	        String sql = "delete from emp where id = ?";
	        int count = template.update(sql, 1015);
	        System.out.println(count);
	    }
	    /**
	     * 4.查询id为1001的记录，将其封装为Map集合
	     * 注意：这个方法查询的结果集长度只能是1
	     */
	    @Test
	    public void test4(){
	        String sql = "select * from emp where id = ? or id = ?";
	        Map<String, Object> map = template.queryForMap(sql, 1001,1002);
	        System.out.println(map);
	        //{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}
	    }
	    /**
	     * 5. 查询所有记录，将其封装为List
	     */
	    @Test
	    public void test5(){
	        String sql = "select * from emp";
	        List<Map<String, Object>> list = template.queryForList(sql);
	
	        for (Map<String, Object> stringObjectMap : list) {
	            System.out.println(stringObjectMap);
	        }
	    }
	    /**
	     * 6. 查询所有记录，将其封装为Emp对象的List集合
	     */
	
	    @Test
	    public void test6(){
	        String sql = "select * from emp";
	        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
	
	            @Override
	            public Emp mapRow(ResultSet rs, int i) throws SQLException {
	                Emp emp = new Emp();
	                int id = rs.getInt("id");
	                String ename = rs.getString("ename");
	                int job_id = rs.getInt("job_id");
	                int mgr = rs.getInt("mgr");
	                Date joindate = rs.getDate("joindate");
	                double salary = rs.getDouble("salary");
	                double bonus = rs.getDouble("bonus");
	                int dept_id = rs.getInt("dept_id");
	
	                emp.setId(id);
	                emp.setEname(ename);
	                emp.setJob_id(job_id);
	                emp.setMgr(mgr);
	                emp.setJoindate(joindate);
	                emp.setSalary(salary);
	                emp.setBonus(bonus);
	                emp.setDept_id(dept_id);
	
	                return emp;
	            }
	        });
	        for (Emp emp : list) {
	            System.out.println(emp);
	        }
	    }
	    /**
	     * 6. 查询所有记录，将其封装为Emp对象的List集合
	     */
	
	    @Test
	    public void test6_2(){
	        String sql = "select * from emp";
	        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
	        for (Emp emp : list) {
	            System.out.println(emp);
	        }
	    }
	    /**
	     * 7. 查询总记录数
	     */
	    @Test
	    public void test7(){
	        String sql = "select count(id) from emp";
	        Long total = template.queryForObject(sql, Long.class);
	        System.out.println(total);
	    }
	}
	```
	
	
	
	
	
	
	


​			


maven集成tomcat插件，不再使用本地tomcat了



```
mvn tomcat:run
```



### 安装MVN

安装：下载之后，直接解压到一个不含中文的目录下即可。

![image-20220228192201735](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228192201735.png)



### 环境变量

然后我们就可以配置环境变量了

1、

![image-20220228193224446](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228193224446.png)

2、然后PATH中，新增

![image-20220228193259820](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228193259820.png)

3、我们在cmd中输入mvn -v 验证是否安装并配置成功











### 配置文件

在这里可以找到本地仓库的位置

![image-20220228193836043](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228193836043.png)

由于本地的仓库位置太偏了，而且在c盘中，因此我们做一个修改：（注意不要含中文）

![image-20220228195452323](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228195452323.png)





### 本地仓库

我们把资料中给的 (D:\BaiduNetdiskDownload\Java_IT_Heima\阶段2_1_JavaWeb\day24_maven基础\资料\资料\本地仓库)maven_repository.zip解压到D:\develop目录下，这个文件有点大 400多M。

然后改成：

![image-20220228200308030](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228200308030.png)

这样我们就改变了本地仓库的位置了



### 原理

箭头读作：向这找

![image-20220228195012486](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228195012486.png)



### 目录结构

一个项目一般都要有如下结构：

![image-20220228203706127](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228203706127.png)

**传统的工程目录结构**

![image-20220228203719016](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228203719016.png)



**maven项目标准目录结构：**  

**java工程：**

![image-20220228203816199](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228203816199.png)

**web工程**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228204123769.png" alt="image-20220228204123769" style="zoom: 67%;" />



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220307161146863.png" alt="image-20220307161146863" style="zoom:50%;" />

![image-20220228214035998](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228214035998.png)





执行package命令，生成war包

![image-20220228214351830](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220228214351830.png)

生成war包，是因为在.pom文件中有`<packaging>war<packaging>`指定了





install 命令 执行了compile test package命令 又把项目包加进了本地仓库 





pom.xml里面有1、项目自身的信息   2、依赖jar包 <dependencies>  3、运行环境信息<build>,比如jdk tomcat

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>cn.itcast.maven</groupId>
	<artifactId>maven-helloworld</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>第一个maven工程</name>
	<description>第一个maven工程</description>
	
	<!-- 添加servlet-api，jsp-api -->
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.9</version>
			<scope>test</scope>
		</dependency>


		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>jsp-api</artifactId>
			<version>2.0</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.5</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>
	<build>
		<!-- 配置了很多插件 -->
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<source>1.7</source>
					<target>1.7</target>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
		<plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.1</version>
                <configuration>
                    <port>9090</port>
                    <path>/mgr</path>
                    <uriEncoding>UTF-8</uriEncoding>
                    <server>tomcat7</server>
                </configuration>
            </plugin>

		</plugins>
	</build>
</project>
```

![image-20220301110956545](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220301110956545.png)



### 配置

默认

![image-20220301113616948](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220301113616948.png)







一般而言，我们创建一个普通的java工程，我们可以不选择Create from archetype 也可以选择了 然后选quickstart， 然后我们手动创建目录结构成如下

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220301191025809.png" alt="image-20220301191025809" style="zoom: 67%;" />



web工程，选webapp







### 导入坐标

当我们创建Servlet时，发现爆红了，因为我们刚开始的工程没有任何jar包，因此我们需要通过pom.xml来创建依赖。

先创建<depedences>标签组，在里面创建<depedence>标签组,自动补全很方便，（自动补全是根据本地仓库补的）我们需要中央仓库时，我们直接百度maven中央仓库，然后搜索，选择，复制dependence语句即可。

Maven 中央仓库地址：

> 1. http://www.sonatype.org/nexus/
>
> 2. http://mvnrepository.com/ （本人推荐仓库）
>
> 3. http://repo1.maven.org/maven2





生命周期的每一步，底层都有一个插件在工作。











### 问题



[初次使用报错，500 原因是maven自带的tomcat插件版本太低，解决方法请点击](https://www.cnblogs.com/hoyong/articles/12566775.html)

mysql也是runtime

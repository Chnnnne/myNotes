# 今日内容



## Bootstrap：
### 概念：

 一个前端开发的框架，Bootstrap，来自 Twitter，是目前很受欢迎的前端框架。Bootstrap 是基于 HTML、CSS、JavaScript 的，它简洁灵活，使得 Web 开发更加快捷。

* 框架:一个半成品软件，开发人员可以在框架基础上，在进行开发，简化编码。
* 好处：
	1. 定义了很多的css样式和js插件。我们开发人员直接可以使用这些样式和插件得到丰富的页面效果。
	2. 响应式布局。
		* 同一套页面可以兼容不同分辨率的设备。

### 快速入门

1. 下载Bootstrap

   - 直接搜索bootstrap 进入中文网 然后下载bootstrap3中文文档，然后下载用于生产环境的 Bootstrap

     （里面包含编译并压缩后的 CSS、JavaScript 和字体，这三个文件夹。不包含文档和源码文件。）
     <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220213112548551.png" alt="image-20220213112548551" style="zoom:50%;" />
     下载之后解压，有了三个文件夹：
     <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220213112621153.png" alt="image-20220213112621153" style="zoom:50%;" />

2. 在项目中将这三个文件夹复制
   <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220213112644421.png" alt="image-20220213112644421" style="zoom:50%;" />

3. 创建html页面

  - 然后把idea生成的代码删了，复制如下代码，
    ![image-20220213113135581](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220213113135581.png)

  - ```html
    <!doctype html>
    <html lang="zh-CN">
      <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
        <title>Bootstrap 101 Template</title>
    
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    
        <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
        <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
        <!--[if lt IE 9]>
          <script src="https://fastly.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
          <script src="https://fastly.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
        <![endif]-->
      </head>
      <body>
        <h1>你好，世界！</h1>
    
        <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
        <script src="https://fastly.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
        <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
      </body>
    </html>
    ```

  - 下面，我们开始改这个复制过来的代码。把https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css改成引用本地资源xxx/css/bootstrap.min.css.①

- ```html
  下面的都可以删除了，这是为了兼容的。②
  <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
  <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
  <!--[if lt IE 9]>
    <script src="https://fastly.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://fastly.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
  <![endif]-->
  ```

  - ③https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js这个也需要改成本地资源引用，试用同样的方式

- jquery也需要改成本地资源，但是这是一个js的框架，跟bootstrap没关系，因此我们需要单独下载，并复制进来，再引用，我们把所有资源都放进onedrive里了。④

- 至此，我们就完成了初步的动作。

  - 三个文件夹分别是 css js font 打开他们发现有待min的和不带min的，带min的是压缩后的文件（去掉了一些空格回车）。因此我们可以引入随便一个，但是最好引入带min的，因为它没有冗余，速度更快，然后不带min的用来阅读。

  - 下面是一个修改后的版本示意。


```html
	<!DOCTYPE html>
	<html lang="zh-CN">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	    <title>Bootstrap HelloWorld</title>
	
	    <!-- Bootstrap -->
	    <link href="css/bootstrap.min.css" rel="stylesheet"> <!-- 可见相对路径以项目路径开始-->
	    	    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	    <script src="js/jquery-3.2.1.min.js"></script>
	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	    <script src="js/bootstrap.min.js"></script>
	</head>
	<body>
	<h1>你好，世界！</h1>
	
	</body>
	</html>
```

- 相对路径以项目（又好像是模块）路径开始，并且按住ctrl的话，如果变成一个小手就说明成功了（写对路径了）



使用一些组件



## 响应式布局

### 概念

同一套页面可以兼容不同分辨率的设备。

实现依赖于栅格系统：将每一个设备的一行平均分成12个格子，可以指定元素占几个格子（也即可以在指定元素时，选择在大分辨率的设备站少点的格子，在小的设备上的站多点的格子）

### 步骤：

1. 定义容器。相当于之前的table、
	* 容器分类：
		1. container：两边留白
		2. container-fluid：每一种设备都是100%宽度
2. 定义行。相当于之前的tr   样式：row
3. 定义元素。指定该元素在不同的设备上，所占的格子数目。样式：col-设备代号-格子数目(如：如果一行只要六个元素，那么可以定义六个元素，每个元素两个格)
	* 设备代号：
		1. xs：超小屏幕 手机 (<768px)：
		2. sm：小屏幕 平板 (≥768px)
		3. md：中等屏幕 桌面显示器 (≥992px)
		4. lg：大屏幕 大桌面显示器 (≥1200px)

* 注意：
	1. 一行中如果格子数目超过12，则超出部分自动换行。
	2. 栅格类属性可以向上兼容。栅格类适用于与屏幕宽度大于或等于分界点大小的设备。比如如果你选择在手机上一行三个元素，那么在更大的电脑上也是三个元素
	3. 如果真实设备宽度小于了设置栅格类属性的设备代码的最小值，会一个元素沾满一整行。



```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap HelloWorld</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        .inner{
            border:1px solid red;
        }

    </style>
</head>
<body>
    <!--1.定义容器-->
    <div class="container">
        <!--2.定义行-->
        <div class="row">
            <!--3.定义元素
                在大显示器一行12个格子
                在pad上一行6个格子
            -->
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
            <div class="col-lg-1 col-sm-2 inner">栅格</div>
<!--            <div class="col-md-4 inner">栅格</div>-->
<!--            <div class="col-md-4 inner">栅格</div>-->
<!--            <div class="col-md-4 inner">栅格</div>-->

        </div>

    </div>

</body>
</html>
```



## CSS样式和JS插件
	1. 全局CSS样式：
		* 按钮：class="btn btn-default"
		* 图片：
			*  class="img-responsive"：图片在任意尺寸都占100%
			*  图片形状
				*  <img src="..." alt="..." class="img-rounded">：方形
				*  <img src="..." alt="..." class="img-circle"> ： 圆形
				*  <img src="..." alt="..." class="img-thumbnail"> ：相框
		* 表格
			* table
			* table-bordered
			* table-hover
		* 表单
			* 给表单项添加：class="form-control" 
	2. 组件：
		* 导航条
		* 分页条
	3. 插件：
		* 轮播图

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap HelloWorld</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>

    <table class="table table-bordered table-hover">

        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>

        </tr>
        <tr>
            <td>001</td>
            <td class="active">张三</td>
            <td class="warning">23</td>
        </tr>
        <tr>
            <td>002</td>
            <td>张三</td>
            <td>23</td>
        </tr>
        <tr>
            <td class="success">003</td>
            <td class="warning">张三</td>
            <td class="info">23</td>
        </tr>

    </table>

<hr><hr><hr>


    <form class="form-horizontal">
        <div class="form-group">
            <label for="exampleInputEmail1" class="col-sm-2 control-label">Email address</label>

           <div class="col-sm-10">
            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
           </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
        </div>
    </form>
</body>
</html>
```



## 案例

	<!DOCTYPE html>
	<html lang="zh-CN">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	    <title>Bootstrap HelloWorld</title>
	
	    <!-- Bootstrap -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">


​	    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
​	    <script src="js/jquery-3.2.1.min.js"></script>
​	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
​	    <script src="js/bootstrap.min.js"></script>
​	    <style>
​	        .paddtop{
​	            padding-top: 10px;
​	        }
​	        .search-btn{
​	            float: left;
​	            border:1px solid #ffc900;
​	            width: 90px;
​	            height: 35px;
​	            background-color:#ffc900 ;
​	            text-align: center;
​	            line-height: 35px;
​	            margin-top: 15px;
​	        }
​	
​	        .search-input{
​	            float: left;
​	            border:2px solid #ffc900;
​	            width: 400px;
​	            height: 35px;
​	            padding-left: 5px;
​	            margin-top: 15px;
​	        }
​	        .jx{
​	            border-bottom: 2px solid #ffc900;
​	            padding: 5px;
​	        }
​	        .company{
​	            height: 40px;
​	            background-color: #ffc900;
​	            text-align: center;
​	            line-height:40px ;
​	            font-size: 8px;
​	        }
​	    </style>
​	</head>
​	<body>
​	
​	   <!-- 1.页眉部分-->
​	   <header class="container-fluid">
​	       <div class="row">
​	           <img src="img/top_banner.jpg" class="img-responsive">
​	       </div>
​	       <div class="row paddtop">
​	           <div class="col-md-3">
​	               <img src="img/logo.jpg" class="img-responsive">
​	           </div>
​	           <div class="col-md-5">
​	               <input class="search-input" placeholder="请输入线路名称">
​	               <a class="search-btn" href="#">搜索</a>
​	           </div>
​	           <div class="col-md-4">
​	               <img src="img/hotel_tel.png" class="img-responsive">
​	           </div>

​	

	       </div>
	       <!--导航栏-->
	       <div class="row">
	           <nav class="navbar navbar-default">
	               <div class="container-fluid">
	                   <!-- Brand and toggle get grouped for better mobile display -->
	                   <div class="navbar-header">
	                       <!-- 定义汉堡按钮 -->
	                       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	                           <span class="sr-only">Toggle navigation</span>
	                           <span class="icon-bar"></span>
	                           <span class="icon-bar"></span>
	                           <span class="icon-bar"></span>
	                       </button>
	                       <a class="navbar-brand" href="#">首页</a>
	                   </div>
	
	                   <!-- Collect the nav links, forms, and other content for toggling -->
	                   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                       <ul class="nav navbar-nav">
	                           <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
	                           <li><a href="#">Link</a></li>
	                           <li><a href="#">Link</a></li>
	                           <li><a href="#">Link</a></li>
	                           <li><a href="#">Link</a></li>
	                           <li><a href="#">Link</a></li>
	
	                       </ul>
	                   </div><!-- /.navbar-collapse -->
	               </div><!-- /.container-fluid -->
	           </nav>
	
	       </div>
	
	       <!--轮播图-->
	       <div class="row">
	           <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	               <!-- Indicators -->
	               <ol class="carousel-indicators">
	                   <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	                   <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	                   <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	               </ol>
	
	               <!-- Wrapper for slides -->
	               <div class="carousel-inner" role="listbox">
	                   <div class="item active">
	                       <img src="img/banner_1.jpg" alt="...">
	                   </div>
	                   <div class="item">
	                       <img src="img/banner_2.jpg" alt="...">
	                   </div>
	                   <div class="item">
	                       <img src="img/banner_3.jpg" alt="...">
	                   </div>
	
	               </div>
	
	               <!-- Controls -->
	               <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	                   <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	                   <span class="sr-only">Previous</span>
	               </a>
	               <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	                   <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	                   <span class="sr-only">Next</span>
	               </a>
	           </div>


​	
​	
​	       </div>
​	
​	   </header>
​	   <!-- 2.主体部分-->
​	   <div class="container">
​	        <div class="row jx">
​	            <img src="img/icon_5.jpg">
​	            <span>黑马精选</span>
​	        </div>
​	
​	       <div class="row paddtop">
​	           <div class="col-md-3">
​	                <div class="thumbnail">
​	                    <img src="img/jiangxuan_3.jpg" alt="">
​	                    <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                    <font color="red">&yen; 699</font>
​	                </div>
​	           </div>
​	           <div class="col-md-3">
​	               <div class="thumbnail">
​	                   <img src="img/jiangxuan_3.jpg" alt="">
​	                   <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                   <font color="red">&yen; 699</font>
​	               </div>
​	
​	           </div>
​	           <div class="col-md-3">
​	
​	               <div class="thumbnail">
​	                   <img src="img/jiangxuan_3.jpg" alt="">
​	                   <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                   <font color="red">&yen; 699</font>
​	               </div>
​	           </div>
​	           <div class="col-md-3">
​	
​	               <div class="thumbnail">
​	                   <img src="img/jiangxuan_3.jpg" alt="">
​	                   <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                   <font color="red">&yen; 699</font>
​	               </div>
​	           </div>


​	
​	       </div>
​	       <div class="row jx">
​	           <img src="img/icon_6.jpg">
​	           <span>国内游</span>
​	       </div>
​	       <div class="row paddtop">
​	           <div class="col-md-4">
​	               <img src="img/guonei_1.jpg">
​	           </div>
​	           <div class="col-md-8">
​	               <div class="row">
​	                   <div class="col-md-4">
​	                       <div class="thumbnail">
​	                           <img src="img/jiangxuan_3.jpg" alt="">
​	                           <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                           <font color="red">&yen; 699</font>
​	                       </div>
​	                   </div>
​	                   <div class="col-md-4">
​	                       <div class="thumbnail">
​	                           <img src="img/jiangxuan_3.jpg" alt="">
​	                           <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                           <font color="red">&yen; 699</font>
​	                       </div>
​	
​	                   </div>
​	                   <div class="col-md-4">
​	
​	                       <div class="thumbnail">
​	                           <img src="img/jiangxuan_3.jpg" alt="">
​	                           <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                           <font color="red">&yen; 699</font>
​	                       </div>
​	                   </div>
​	
​	               </div>
​	               <div class="row">
​	                   <div class="col-md-4">
​	                       <div class="thumbnail">
​	                           <img src="img/jiangxuan_3.jpg" alt="">
​	                           <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                           <font color="red">&yen; 699</font>
​	                       </div>
​	                   </div>
​	                   <div class="col-md-4">
​	                       <div class="thumbnail">
​	                           <img src="img/jiangxuan_3.jpg" alt="">
​	                           <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                           <font color="red">&yen; 699</font>
​	                       </div>
​	
​	                   </div>
​	                   <div class="col-md-4">
​	
​	                       <div class="thumbnail">
​	                           <img src="img/jiangxuan_3.jpg" alt="">
​	                           <p>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</p>
​	                           <font color="red">&yen; 699</font>
​	                       </div>
​	                   </div>


​	
​	               </div>
​	
​	           </div>
​	
​	       </div>
​	   </div>
​	   <!-- 3.页脚部分-->
​	   <footer class="container-fluid">
​	       <div class="row">
​	           <img src="img/footer_service.png" class="img-responsive">
​	       </div>
​	       <div class="row company">
​	           江苏传智播客教育科技股份有限公司 版权所有Copyright 2006-2018, All Rights Reserved 苏ICP备16007882
​	       </div>
​	
​	   </footer>


​	
​	</body>
​	</html>
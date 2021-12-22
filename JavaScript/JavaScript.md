# JavaScript

[视频](https://www.bilibili.com/video/BV1jE411T7ya?from=search&seid=1668979747392528795)

semicolons(分号) are not mandatory(强制的)，but it's recommended to do that

注释方式同java



推荐编译器：VSCODE，配上插件 live server ， <script><script>标签建议写到body标签的最后面，另外推荐 <script src="main.js"> </script>这样的方式，来引入js ，而不是直接写



## 一、变量定义

**var** 是全局的，因此会产生冲突

而**let & const** have a block-level scope

**let** can reassign values
**const** can't              <-用的更多，更常见          just use constant unless you know you're going to  reassign it, and const must have a initial value!

```javascript
const t=1;
t=2;
console.log(t);
这样就会报错
```





## 二、数据类型

基本数据类型Primitive ：  **String , Numbers, Boolean , null , undefiined, symbol**

```javascript
const name = 'john';
const age = 30;
const rating =4.5;//there is no decimal or float in js,but just numbers
const isCool = true;
const x = null;
const y = undefined;
let z;

const hello ='my name is'+name;
const hello1=`my name is ${name}` //注意是反引号
```

### 1.String

Strings can have double or single quotes  . 字符串可以拼接，也可以用上面反引号的方法。

此外String 有Property and method  。 Property 比如可以 name.length ，注意Property 没有括号，而method有括号。可以name.toUpperCase(),可以 name.substring(0,5).toUpperCase 链式。还可以const name='hello,world,wow,wangchen'; 然后name.split(',')得到一个数组



### 2.null

从逻辑角度，null值表示一个空对象指针，而这也正是使用typeof操作符检测null值时会返回"object"的原因。

如果定义的变量准备在将来用于保存对象，应该将该变量初始化为null。

alert(null == undefined)  //true



### 3.Array数组

```javascript
const numbers = new Array(1,2,3,4,5);
const fruits = ['apple','pear','orange'];
//you can have multiple data types in a array 
const fruits = ['apple','pear','orange',11,true];
```

index begin from zero

用const声明，可以向数组中添加值，操纵使用方法。唯一不能做的是 重新赋值(指定)，就像const fruits=[11,22,33];fruits=[13,11];

向末尾添加的方法可以是 fruits[3]=44 或者fruits.push(44);

向头添加的方法是fruits.unshift (00)

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205144820792.png" alt="image-20210205144820792" style="zoom:50%;" />

判断是否是数组 可以Array.isArray(xx)



### 4.对象

```javascript
const person = {
    firstName:'John',
    lastName:'Doe',
    age:30,
    hobbies:['music','basketball','soccer'],
    address:{
        street:'50 Rd st',
        city:'Boston',
        state:'MA'
    }
}
console.log(person);
console.log(person.firstName,person.lastname);
console.log(person.hobbies[0]);
```

可以向里面添加属性

```js
person.email='john@gmail.com'
```





使用构造函数来构造对象

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205202915328.png" alt="image-20210205202915328" style="zoom: 50%;" />

使用date对象

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205203113929.png" alt="image-20210205203113929" style="zoom:50%;" />



添加一些函数

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205205356671.png" alt="image-20210205205356671" style="zoom:50%;" />



也可以使用原型Prototype替代以上写法（推荐），（把方法和属性加到原型上）↓

![image-20210205215816395](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205215816395.png)





也可以使用类（推荐），其作用和以上相同，因此它被叫做语法糖

注意：类中的函数function叫方法method   ，    constructor

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205220747095.png" alt="image-20210205220747095" style="zoom:80%;" />





### 5.对象数组

![image-20210205150319955](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205150319955.png)









### 5.JSON

a data format 一种数据格式

used within full stack development

向服务器发送数据会用到JSON格式

![image-20210205151135491](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205151135491.png)



## 三、循环

![image-20210205151311138](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205151311138.png)



![image-20210205151500403](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205151500403.png)



![image-20210205151607862](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205151607862.png)

![image-20210205151701423](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205151701423.png)

还有forEach、Map、filter。设计函数式编程，值得学习，很高效





## 四、条件语句

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205154939340.png" alt="image-20210205154939340" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205154955920.png" alt="image-20210205154955920" style="zoom: 67%;" />



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205155135453.png" alt="image-20210205155135453" style="zoom: 67%;" />



![image-20210205155256309](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210205155256309.png)



## 五、函数

```js
function addNums(num1,num2){
    console.log(`the sum of num1 and num2 is  ${num1+num2}`);
}

addNums(1,2);//the sum of num1 and num2 is  3
addNums();//the sum of num1 and num2 is  NaN
```



加上默认形参

```js
function addNums(num1 = 1 ,num2 = 2){
    console.log(`the sum of num1 and num2 is  ${num1+num2}`);
}
```





返回值

```js
function addNums(num1,num2){
    return num1+num2};
}
```





es6 (es2015)可以使用箭头表达式 ，lambda？？

```javascript
function addNums(num1,num2){
    console.log(`the sum of num1 and num2 is  ${num1+num2}`);
}

addNums(1,2);//the sum of num1 and num2 is  3
addNums();//the sum of num1 and num2 is  NaN

const addNums1 = (num1,num2)=>{
    console.log(`the sum of num1 and num2 is  ${num1+num2}`);
}
const addNums2 = (num1 =1,num2=3)=>{
    return num1+num2;
}
//函数体只有一行，可省略{}
const addNums3 = (num1,num2)=>console.log(`the sum of num1 and num2 is  ${num1+num2}`);
const addNums4 = (num1,num2)=>num1+num2;//可省略return

const addNums5 = num1 => num1+5;//当只有一个参数时，可去掉()，但是不能有初始参数值
```





## 六、DOM

全称document

作用：用来选择元素

选择类用**.类名**      选择id 用**#id名**       选择标签   直接选 



JQ作为JS的一个库，可以更简单地完成选择，而QuerySelector更像JQ





```javascript
//single element
console.log(document.getElementById('my-form'));//推荐
console.log(document.querySelector('h1'));//推荐,注意它是个单一元素选择器，如果有多个h1标签，那么会选择第一个     Returns the first element that is a descendant of node that matches selectors.
console.log(document.querySelector('.container'));//推荐


//multiple element
console.log(document.querySelectorAll('.item'));//推荐，可以选择 ID、Class、tag、anything。返回一个NodeList，非常类似数组
console.log(document.getElementsByClassName('item'));//不推荐，返回HTMLCollection，不能使用数组的方法，如果要用，需要受到转换为数组    Returns all element descendants of node that match selectors.
console.log(document.getElementsByTagName('li'));//不推荐



console.log('\n\n\n\n\n\n\n');
const items = document.querySelectorAll('.item');
items.forEach((item)=>console.log(item))

const ul= document.querySelector('.items');   //ul is a node list
console.log(ul); 
// ul.remove();
// ul.lastElementChild.remove();
// ul.firstElementChild.textContent = 'hello';
ul.children[1].innerText = 'Bread';
ul.lastElementChild.innerHTML= '<h1>Hello<h1>'

const btn = document.querySelector('.btn');
btn.style.background='red';
```











创建事件监听

```javascript
const btn = document.querySelector('.btn');
console.log(btn);
//指定两件事：  事件(比如click/mouseobver/mouseout事件)、函数(当事件发生时的函数)      
//作用：可以让界面有交互
btn.addEventListener('mouseout',(e)=>{
    e.preventDefault();
    console.log(e.target);
    console.log(e.target.className);

    document.querySelector('#my-form').style.background= '#ccc';
    document.querySelector('body').classList.add('bg-dark');//对body标签增加类       同理remove可以删除类
    document.querySelector('.items').lastElementChild.innerHTML='<h1>Hello</h1>';
});
```







```js
const myForm = document.querySelector('#my-form');
const nameInput= document.querySelector("#name");
const emailInput= document.querySelector("#email");
const msg= document.querySelector(".msg");
const userList= document.querySelector("#users");


//监听表单的提交事件
myForm.addEventListener('submit',onSubmit);

function onSubmit(e) {
    e.preventDefault();
    console.log(nameInput.value);
}
```









```java
const myForm = document.querySelector('#my-form');
const nameInput= document.querySelector("#name");
const emailInput= document.querySelector("#email");
const msg= document.querySelector(".msg");
const userList= document.querySelector("#users");


//监听表单的提交事件
myForm.addEventListener('submit',onSubmit);

function onSubmit(e) {
    e.preventDefault();
    if(nameInput.value === '' ||emailInput.value ===''){
        // alert('Plz enter all the fields');
        msg.classList.add('error');
        msg.innerHTML='Plz enter all firlds';

        setTimeout(()=>msg.remove(),2000);
    }else{
        const li =document.createElement('li');
        li.appendChild(document.createTextNode(
            `${nameInput.value} : ${emailInput.value} `
        ));
        userList.appendChild(li);

        //clear fileds
        nameInput.value='';
        emailInput.value='';
    }
}
```

## 七、原理

### 原理1

[以下参考](https://blog.csdn.net/GY_U_YG/article/details/72869315)

JS是一门脚本语言，不需要编译，边解释边执行，所以在性能上比不上C/C++这样的编译型语言。JS的执行引擎有好多种，这些解析引擎大都存在于浏览器内核之中，比如：

Chrome ：  webkit/blink ： V8
FireFox：  Gecko        :  SpiderMonkey
Safari ：  webkit       ： JavaScriptCore
IE     ：  Trident      ： Chakra

JS不一定非要在浏览器中运行，只要有JS引擎即可，最典型的比如NodeJS，采用了谷歌的v8引擎，使得JS完全脱离浏览器运行。

**浏览器显示HTML**
不同的浏览器对HTML的解析过程不太相同，这里介绍一下webkit的渲染过程：
构建DOM树、构建Render树，布局Render树，绘制Render树。

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211220105353321.png" alt="image-20211220105353321" style="zoom:50%;" />

**浏览器在解析HTML文件的时候，“自上而下”加在，加载的过程中进行解析渲染。在解析过程中，如果遇到请求外部资源，如图片、CSS、iconfot等，这些请求过程是异步的，不会影响HTML文档的继续加载和解析。**

**解析过程中，浏览器首先会解析HTML文件构造DOM树，然后解析CSS文件构建渲染树，渲染树构建完成后，浏览器开始布局渲染树并将其绘制到屏幕。这个过程非常复杂，涉及到两个概念：reflow 和 repaint。**

DOM节点中各个元素都是盒模型，要求浏览器去计算位置大小等，这个过程是reflow，当盒子模型位置、大小、其他属性如颜色，字体确定之后，浏览器便开始绘制内容，这个过程叫做repaint。

页面首次加载的时候，两个过程都会发生，这两个过程都很消耗性能，尤其是reflow，如果优化的不好，会造成很坏的用户体验。所以，我们要尽量减少reflow和repaint。尽量合并一些过程，比如要改变某个元素的多个属性。有三个方法：

ele.style.width = '100px';
ele.style.height = '200px';
ele.style.color = 'red';

ele.style.cssText = ';width:'+100+'px;height:'+200+'px;color:red';
1
.cls {
    width:100px;
    height:200px;
    color:red;
}

ele.addClass('cls');

这三种方法，明显我们不要采用第一种，因为每一句都会造成浏览器重绘，很消耗性能。第二种第三种就很好，合并之后，一次性渲染。

**JS的执行**
先上一幅图：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211220105332681.png" alt="image-20211220105332681" style="zoom:50%;" />

**当文档加载过程中遇到JS文件，HTML文档会立马挂起渲染的线程（加载解析渲染同步进行），挂起后，要等到JS文件加载完而且解析执行完之后，才恢复HTML文档的渲染线程。为啥？因为JS可能会修改DOM结构，最明显的例子就是document.write，一句让你前功尽弃。这也就意味着：在JS执行完成之前，后续所有资源的下载都可能没有必要没有意义，这也就是JS阻塞后续资源下载的根本原因，所以，开发过程中，经常把JS代码放到HTML文档末尾。**

JS的解析是由浏览器的JS解析引擎完成的。**JS是单线程运行**，换言之：同一个时间只做一件事，所有的任务都得排队，前面一个任务结束，后面一个任务才能开始。所以，当遇到很耗费时间的任务，比如I/O读写等，需要一种机制可以先执行后面的任务。这就有了同步和异步。

JS的执行机制就是一个主线程 + 一个任务队列。同步任务就是放在主线程上执行的任务，异步任务就是放在任务队列的任务。所有的同步任务都在主线程执行，这构成了一个执行栈，异步任务有了运行结果会在任务队列中放置一个事件，比如定时2秒，到2秒后才能放进任务队列（callback放进任务队列，而不是setTimeout函数放进队列）。脚本运行时，先依次运行执行栈，然后从队列中提取事件来运行任务队列中的任务，这个过程是不断重复的。所以叫事件循环（Event Loop）。





### 原理2

[以下参考](https://blog.csdn.net/minemi/article/details/111304718)

1.关于javascript
javascript是一门单线程语言，在最新的HTML5中提出了Web-Worker，但javascript是单线程这一核心仍未改变。所以一切javascript版的"多线程"都是用单线程模拟出来的，一切javascript多线程都是纸老虎！

2.javascript事件循环
  既然js是单线程，那就像只有一个窗口的银行，客户需要排队一个一个办理业务，同理js任务也要一个一个顺序执行。如果一个任务耗时过长，那么后一个任务也必须等着。那么问题来了，假如我们想浏览新闻，但是新闻包含的超清图片加载很慢，难道我们的网页要一直卡着直到图片完全显示出来？因此聪明的程序员将任务分为两类：

- 同步任务
- 异步任务

  当我们打开网站时，网页的渲染过程就是一大堆同步任务，比如页面骨架和页面元素的渲染。而像加载图片音乐之类占用资源大耗时久的任务，就是异步任务。

1. 同步和异步任务分别进入不同的执行"场所"，同步的进入主线程，异步的进入EventTable并注册函数。
2. 当指定的事情完成时，EventTable会将这个函数移入EventQueue。
3. 主线程内的任务执行完毕为空，会去EventQueue读取对应的函数，进入主线程执行。
4. 上述过程会不断重复，也就是常说的EventLoop(事件循环)。

  我们不禁要问了，那怎么知道主线程执行栈为空啊？js引擎存在monitoringprocess进程，会持续不断的检查主线程执行栈是否为空，一旦为空，就会去EventQueue那里检查是否有等待被调用的函数。
说了这么多文字，不如直接一段代码更直白：

```javascript
let data=[];
$.ajax({undefined
url:www.javascript.com,
data:data,
success:()=>{undefined
console.log('发送成功!');
}
})
console.log('代码执行结束');
```

上面是一段简易的ajax请求代码：
ajax进入EventTable，注册回调函数success。
执行console.log('代码执行结束')。
ajax事件完成，回调函数success进入EventQueue。
主线程从EventQueue读取回调函数success并执行。
相信通过上面的文字和代码，你已经对js的执行顺序有了初步了解。接下来我们来研究进阶话题：setTimeout。



### **setTimeout**

setTimeout是异步的

先看一个例子：

```javascript
setTimeout(()=>{undefined
task();
},3000)
console.log('执行console');
```

根据前面我们的结论，setTimeout是异步的，应该先执行console.log这个同步任务，所以我们的结论是：

```
//执行console
//task()复制代码
```

去验证一下，结果正确！

然后我们修改一下前面的代码：

```javascript
setTimeout(()=>{undefined
task()
},3000)
sleep(10000000)
```

  乍一看其实差不多嘛，但我们把这段代码在chrome执行一下，却发现控制台执行task()需要的时间远远超过3秒，说好的延时三秒，为啥现在需要这么长时间啊？

这时候我们需要重新理解setTimeout的定义。我们先说上述代码是怎么执行的：

1. task()进入EventTable并注册,计时开始。
2. 执行sleep函数，很慢，非常慢，计时仍在继续。
3. 3秒到了，计时事件timeout完成，task()进入EventQueue，但是sleep也太慢了吧，还没执行完，只好等着。
4. sleep终于执行完了，task()终于从EventQueue进入了主线程执行。



setTimeout(fn,0)的含义是，指定某个任务在主线程最早可得的空闲时间执行，意思就是不用再等多少秒了，只要主线程执行栈内的同步任务全部执行完成，栈为空就马上执行。



### **setInterval**

对于执行顺序来说，setInterval会每隔指定的时间将注册的函数置入EventQueue，如果前面的任务耗时太久，那么同样需要等待。
唯一需要注意的一点是，对于setInterval(fn,ms)来说，我们已经知道不是每过ms秒会执行一次fn，而是每过ms秒，会有fn进入EventQueue。



[以下参考，详细](https://blog.csdn.net/GY_U_YG/article/details/72869315)

JS的执行机制就是一个主线程 + 一个任务队列。同步任务就是放在主线程上执行的任务，异步任务就是放在任务队列的任务。所有的同步任务都在主线程执行，这构成了一个执行栈，异步任务有了运行结果会在任务队列中放置一个事件，比如定时2秒，到2秒后才能放进任务队列（callback放进任务队列，而不是setTimeout函数放进队列）。脚本运行时，先依次运行执行栈，然后从队列中提取事件来运行任务队列中的任务，这个过程是不断重复的。所以叫事件循环（Event Loop）。





四、具体来说，异步运行机制如下：

（1）所有同步任务都在主线程上执行，形成一个执行栈（execution context stack）。

（2）主线程之外，还存在一个"任务队列"（task queue）。只要异步任务有了运行结果，就在"任务队列"之中放置一个事件。

（3）一旦"执行栈"中的所有同步任务执行完毕，系统就会读取"任务队列"，看看里面有哪些事件。那些对应的异步任务，于是结束等待状态，进入执行栈，开始执行。

（4）主线程不断重复上面的第三步。





### 执行顺序

[参考](https://blog.csdn.net/wnvalentin/article/details/79769393)



## 其他

1、===：称为等同符，当两边值的类型相同时，直接比较值，若类型不相同，直接返回false；

2、==：称为等值符，当等号两边的类型相同时，直接比较值是否相等，若不相同，则先转化为类型相同的值，再进行比较；

类型转换规则：1）如果等号两边是boolean、string、number三者中任意两者进行比较时，优先转换为数字进行比较。

​             2）如果等号两边出现了null或undefined,null和undefined除了和自己相等，就彼此相等

注意：NaN==NaN //返回false，NaN和所有值包括自己都不相等。



```js
const x=10;
x==10 //true

const y='10';
y==10//true

const z='10';
z==10//false
```




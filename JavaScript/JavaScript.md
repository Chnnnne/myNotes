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


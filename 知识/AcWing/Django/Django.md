





## 1.1课程概论和Python3语法（上）

### 体系结构概论

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211206213628910.png" alt="image-20211206213628910" style="zoom: 33%;" />

云端的存储：Redis(内存数据库)、MySql、云盘(disk)    
本地的存储：Web Storage、js内存

一般的http协议：就是一个request和一个response，服务器不能主动向我发送信息的，服务器是一个被动接受者，我问它什么，它答什么。

而websocket是一个两端都能发信息的通信协议：websocket协议会在每一个用户浏览器和服务器端建立一个长连接，客户端可以向服务器发送请求，服务器也能向客户端发送请求。比如聊天系统就会用到这个协议，图解如下：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211206222003397.png" alt="image-20211206222003397" style="zoom: 50%;" />



### python部分

在ipython3里可以执行bash脚本，前面加个!即可

python的第一行，都要写上

```python
#! /usr/bin/env python3
# -*- coding: utf-8 -*-  
```

作用是：可以./运行了，会用第一行找解释器， 

指定编码格式，一般情况下不写也行，默认是utf-8



运行python文件的方式：1.`python3 文件名`  2.先`chmod +x main.py`，再`./main`运行



系统中默认的python是python2，如果要用python3就用python3， python2的编码是个很麻烦的问题，python2不再进行维护。ipython3是一个交互式的python3，有高亮提示，补全更智能，更高级一些。

#### 运算

除法运算（/）返回浮点数。
用 // 运算符执行 floor division 的结果是整数（忽略小数） 注意**是向下取整**，-1//3 = -1。C++和其他语言是像0取整
计算余数用 %；
右移操作 >>
"_"   下划线代表的是上一个表达式的值 
round(num, cnt) 把num保留cnt个小数，四舍五入



#### 字符串：

单引号内部的双引号是不需要转义的，双引号内部的单引号不需要转义

如果不希望前置 `\` 的字符转义成特殊字符，可以使用 原始字符串，在引号前添加 `r` 即可：

```python
>>> print('C:\some\name')  # here \n means newline!
C:\some
ame
>>> print(r'C:\some\name')  # note the r before the quote
C:\some\name
```

字符串字面值可以实现跨行连续输入。实现方式是用三引号：`"""..."""` 或 `'''...'''`，字符串行尾会自动加上回车换行，如果不需要回车换行，在行尾添加 `\` 即可。示例如下：

```python
print("""\
Usage: thingy [OPTIONS]
     -h                        Display this usage message
     -H hostname               Hostname to connect to
""")
```

输出如下（注意，第一行没有换行）：

```
Usage: thingy [OPTIONS]
     -h                        Display this usage message
     -H hostname               Hostname to connect to
```

字符串可以用 `+` 合并（粘到一起），也可以用 `*` 重复：

```python
>>> # 3 times 'un', followed by 'ium'
>>> 3 * 'un' + 'ium'
'unununium'
```

字符串支持 *索引* （下标访问），第一个字符的索引是 0。单字符没有专用的类型，就是长度为一的字符串：

```python
>>> word = 'Python'
>>> word[0]  # character in position 0
'P'
>>> word[5]  # character in position 5
'n'
```

索引还支持负数，用负数索引时，从右边开始计数： 

```python
>>> word[-1]  # last character
'n'
>>> word[-2]  # second-last character
'o'
>>> word[-6]
'P'
```

简记：不加-就是从左往右数，从0开始。加-就是从右往左数，下标从1开始。

除了索引，字符串还支持 *切片*。索引可以提取单个字符，*切片* 则提取子字符串：注意结束索引可以为数组长度（也即在最后一个索引的后面）

```python
>>> word[0:2]  # characters from position 0 (included) to 2 (excluded)
'Py'
>>> word[2:5]  # characters from position 2 (included) to 5 (excluded)
'tho'
```

切片索引的默认值很有用；省略开始索引时，默认值为 0，省略结束索引时，默认为到字符串的结尾：

```python
>>> word[:2]   # character from the beginning to position 2 (excluded)
'Py'
>>> word[4:]   # characters from position 4 (included) to the end
'on'
>>> word[-2:]  # characters from the second-last (included) to the end
'on'
```

注意，输出结果包含切片开始，但不包含切片结束。因此，`s[:i] + s[i:]` 总是等于 `s`：

```python
>>> word[:2] + word[2:]
'Python'
>>> word[:4] + word[4:]
'Python'
```

于使用非负索引的切片，如果两个索引都不越界，切片长度就是起止索引之差。例如， `word[1:3]` 的长度是 2。

索引越界会报错：

```python
>>> word[42]  # the word only has 6 characters
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
IndexError: string index out of range
```

但是，切片会自动处理越界索引：

```python
>>> word[4:42]
'on'
>>> word[42:]
''
```

Python 字符串不能修改，是 [immutable](https://docs.python.org/zh-cn/3.10/glossary.html#term-immutable) 的。因此，为字符串中某个索引位置赋值会报错：

内置函数 [`len()`](https://docs.python.org/zh-cn/3.10/library/functions.html#len) 返回字符串的长度：

```python
>>> s = 'supercalifragilisticexpialidocious'
>>> len(s)
34
```



strip函数（）



#### copy

![image-20211207172140218](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211207172140218.png)

1、

```python
x = [1, 2]
y = [3, 4]
a = [x, y]
b = a  #直接赋值，相当于C++中的指针，ab指向完全相同的对象，也即别名
```



2、

```python
x = [1, 2]
y = [3, 4]
a = [x, y]
b = a[:] #浅拷贝
```

例子：<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211207171340700.png" alt="image-20211207171340700" style="zoom:67%;" />



3、

```python
import copy
x = [1, 2]
y = [3, 4]
a = [x, y]
b = copy.deepcopy(a) #深拷贝
```

例子：<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211207171742983.png" alt="image-20211207171742983" style="zoom:50%;" />





#### 复合赋值（元组）

```python
a, b = 1, 2
```

实现交换两个变量

```python
a, b = b, a
```

例子：斐波那契数列

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211207180500058.png" alt="image-20211207180500058" style="zoom: 67%;" />

print可以输出多个内容，用','隔开， 默认输出'\n'。也可以不输出'\n'，只需要改成`print(a, end = ', ')`，即可改成输出逗号







#### 其他：

python没有三目运算符，但有类似的东西：<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211207182655363.png" alt="image-20211207182655363" style="zoom:50%;" />





一个语法糖：<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211207183226535.png" alt="image-20211207183226535" style="zoom:67%;" />





动一处而动全身，一个常见的错误：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211207183631132.png" alt="image-20211207183631132" style="zoom:80%;" />

## 1.2Python语法3（下）

### 0其他

遍历某个集合的同时修改该集合的内容，很难获取想要的结果。要在遍历时修改集合的内容，应该遍历该集合的副本或创建新的集合：

```python
# Create a sample collection
users = {'Hans': 'active', 'Éléonore': 'inactive', '景太郎': 'active'}

# Strategy:  Iterate over a copy
for user, status in users.copy().items():
    if status == 'inactive':
        del users[user]
#分析：items()函数会根据dictionary生成一个键值对的list，如果我们不用一个copy的话，而是直接用同一个，那么删除的时候，会导致这个list变化，但是我们如果用一个浅拷贝的话，第一层复制过去，这样删除users中的键值对也不会影响copy里的内容。经试验的，即使改变copy的内容（非删除），也不会影响users，如下图
        
# Strategy:  Create a new collection
active_users = {}
for user, status in users.items():
    if status == 'active':
        active_users[user] = status
```

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208163932085.png" alt="image-20211208163932085" style="zoom:67%;" />











#### 传递

**python数组list是引用传递，变量则是值传递。类似C++：传的是个变量则值传递，若是数组，则函数可以改变。**



### 1函数

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208213002642.png" alt="image-20211208213002642" style="zoom: 67%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208213113125.png" alt="image-20211208213113125" style="zoom:67%;" />

参数列表可以使用默认值，但是需要注意的是，采用后缀的方法，也即我们必须让后面的连续的一段具有默认参数值，不能间断，不能从前面开始赋值，	

![image-20211208213412210](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208213412210.png)

**参数列表的默认值，需要给后面连续若干个全部设置默认值，不能跳着设置默认值。**，一定要**倒序**，且**连贯**

python比较神奇的一点：调用函数时，可以采取这样的方式：

```python
def f(a, b, c, d):
    print(a, b, c, d)

f(a = 1, b = 2, c = 3, d = 4) #调用
```

这样的好处就是，可以部分赋值，部分采用默认参数

```python
def f(a = "wanchen", b = 3.1, c = [1, 2], d = 100):
    print(a, b, c, d)

f(b = 2, d = 4)
```









#### 解包：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208215228086.png" alt="image-20211208215228086" style="zoom: 67%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208215301074.png" alt="image-20211208215301074" style="zoom: 50%;" />

解包一个列表： 一个*

解包一个字典：两个**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208222644052.png" alt="image-20211208222644052" style="zoom: 67%;" />



`lambda a, b: a+b` 函数返回两个参数的和





### 2列表

==list是[] , tuple 是 () , set和dict是 {}==



`list.append`(*x*) 在列表末尾添加一个元素

`list.sort`(*, *key=None*, *reverse=False*) 就地排序列表中的元素 ，参考排序小结



**用列表实现堆栈：**把元素添加到堆栈的顶端，使用 `append()` 。从堆栈顶部取出元素，使用 `pop()` ，不用指定索引

**用列表实现队列：**

```python
>>> from collections import deque
>>> queue = deque(["Eric", "John", "Michael"])
>>> queue.append("Terry")           # Terry arrives
>>> queue.append("Graham")          # Graham arrives
>>> queue.popleft()                 # The first to arrive now leaves
'Eric'
>>> queue.popleft()                 # The second to arrive now leaves
'John'
>>> queue                           # Remaining queue in order of arrival
deque(['Michael', 'Terry', 'Graham'])
```





二维列表的初始化：

```python
l = [[0 for i in range(10)] for j in range(10)]
```









### 3元组



```python
t = 12345, 54321, 'hello!'

... u = t, (1, 2, 3, 4, 5)
>>> u
((12345, 54321, 'hello!'), (1, 2, 3, 4, 5))
```



元组不能修改，列表能改，这几乎是唯一区别

注意元组的声明采用的是小括号()，或者什么都不写，列表是[]

如：`a = (1, 2, 3) 或 a = 1, 2, 3`

len() 可以取任何东西的长度。

元组可以赋值给一个变量，也可以将一个元组反过来赋值给若干个元素。，我们可以称之为**展开**

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208225418263.png" alt="image-20211208225418263" style="zoom:67%;" />

元组最神奇的地方可以用来交换

```python
a, b = b, a
#等价于
a, b = (b, a) #利用的性质    1：元组括号可省。2：元组可以展开赋值给各个元素
```

列表也能完成上述操作，我们称之为**展开**或**解包**

一个常用的操作：`a, b = input().split(' ') 或 a, b = "abc 321".split(' ')` 解释：split函数可以将字符串用指定分隔符分割，然后形成一个**列表**，再用列表的**解包**赋值给a，b







### 4集合

创建集合用花括号或 set() 函数。
注意，创建空集合只能用 set()，不能用 {}，**{} 创建的是空字典**

```python
basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}
# 
basket.add('wangchen')
basket.add('wangchen')
```



集合一般都是用来对列表做判重的，

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211209104232862.png" alt="image-20211209104232862" style="zoom:67%;" />

标准实例：

```python
>>> basket = {'apple', 'orange', 'apple', 'pear', 'orange', 'banana'}
>>> print(basket)                      # show that duplicates have been removed
{'orange', 'banana', 'pear', 'apple'}
>>> 'orange' in basket                 # fast membership testing
True
>>> 'crabgrass' in basket
False

>>> # Demonstrate set operations on unique letters from two words
...
>>> a = set('abracadabra')
>>> b = set('alacazam')
>>> a                                  # unique letters in a
{'a', 'r', 'b', 'c', 'd'}
>>> a - b                              # letters in a but not in b
{'r', 'd', 'b'}
>>> a | b                              # letters in a or b or both
{'a', 'c', 'r', 'd', 'b', 'm', 'z', 'l'}
>>> a & b                              # letters in both a and b
{'a', 'c'}
>>> a ^ b                              # letters in a or b but not both
{'r', 'd', 'b', 'm', 'z', 'l'}

#与 列表推导式 类似，集合也支持推导式：
>>>
>>> a = {x for x in 'abracadabra' if x not in 'abc'}
>>> a
{'r', 'd'}
```









### 5字典

与以连续整数为索引的序列不同，字典以 *关键字* 为索引，关键字通常是字符串或数字，也可以是其他任意不可变类型。只包含字符串、数字、元组的元组，也可以用作关键字。但如果元组直接或间接地包含了可变对象，就不能用作关键字。列表不能当关键字，因为列表可以用索引、切片、`append()` 、`extend()` 等方法修改。

花括号 `{}` 用于创建空字典，另一种初始化字典的方式是，在花括号里输入逗号分隔的键值对，这也是字典的输出方式。

```python
>>> tel = {'jack': 4098, 'sape': 4139}
>>> tel['guido'] = 4127
>>> tel
{'jack': 4098, 'sape': 4139, 'guido': 4127}
>>> tel['jack']
4098
>>> tel['wangchen'] #索引不存在的key，会报错： KeyError
>>> del tel['sape']
>>> tel['irv'] = 4127
>>> tel
{'jack': 4098, 'guido': 4127, 'irv': 4127}
>>> list(tel)
['jack', 'guido', 'irv']
>>> sorted(tel)
['guido', 'irv', 'jack']
>>> 'guido' in tel
True
>>> 'jack' not in tel
False
```

[`dict()`](https://docs.python.org/zh-cn/3/library/stdtypes.html#dict) 构造函数可以直接用键值对序列创建字典：

```python
>>> dict([('sape', 4139), ('guido', 4127), ('jack', 4098)])
{'sape': 4139, 'guido': 4127, 'jack': 4098}
```

字典推导式可以用任意键值表达式创建字典：

```python
>>> {x: x**2 for x in (2, 4, 6)}
{2: 4, 4: 16, 6: 36}
```

关键字是比较简单的字符串时，直接用关键字参数指定键值对更便捷：

```python
>>> dict(sape=4139, guido=4127, jack=4098)
{'sape': 4139, 'guido': 4127, 'jack': 4098}
```





```python
# Create a sample collection
users = {'Hans': 'active', 'Éléonore': 'inactive', '景太郎': 'active'}

# Strategy:  Iterate over a copy
for user, status in users.copy().items():
    if status == 'inactive':
        del users[user]
#分析：items()函数会根据dictionary生成一个键值对的list，如果我们不用一个copy的话，而是直接用同一个，那么删除的时候，会导致这个list变化，但是我们如果用一个浅拷贝的话，第一层复制过去，这样删除users中的键值对也不会影响copy里的内容。经试验的，即使改变copy的内容（非删除），也不会影响users，如下图
        
# Strategy:  Create a new collection
active_users = {}
for user, status in users.items():
    if status == 'active':
        active_users[user] = status
```

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208163932085.png" alt="image-20211208163932085" style="zoom:67%;" />



### 6循环

[参考](https://docs.python.org/zh-cn/3/tutorial/datastructures.html#looping-techniques)

翻转a列表:`a[::-1]` ,Django自带reverse函数。

`a.reverse()`：翻转a

`a.sort()`:排序

循环语句支持 `else` 子句；[`for`](https://docs.python.org/zh-cn/3/reference/compound_stmts.html#for) 循环中，可迭代对象中的元素全部循环完毕时，或 [`while`](https://docs.python.org/zh-cn/3/reference/compound_stmts.html#while) 循环的条件为假时，执行该子句；也可以记作，不执行break语句时，执行该句话





### 7列表推导式

==就相当于把xx,xx,xx,xx,xx放在原处==



```python
squares = [x**2 for x in range(10)]
#[0, 1, 4, 9, 16, 25, 36, 49, 64, 81]
```

列表推导式的方括号内包含以下内容：**一个表达式，后面为一个 `for` 子句，然后，是零个或多个 `for` 或 `if` 子句**。**结果是由表达式依据 `for` 和 `if` 子句求值计算而得出一个新列表**。 举例来说，以下列表推导式将两个列表中不相等的元素组合起来：

```python
>>> [(x, y) for x in [1,2,3] for y in [3,1,4] if x != y]
[(1, 3), (1, 4), (2, 3), (2, 1), (2, 4), (3, 1), (3, 4)]
```



更多的例子：

表达式是元组（例如上例的 `(x, y)`）时，必须加上括号：

```python
>>> vec = [-4, -2, 0, 2, 4]
>>> # create a new list with the values doubled
>>> [x*2 for x in vec]
[-8, -4, 0, 4, 8]
>>> # filter the list to exclude negative numbers
>>> [x for x in vec if x >= 0]
[0, 2, 4]
>>> # apply a function to all the elements
>>> [abs(x) for x in vec]
[4, 2, 0, 2, 4]
>>> # call a method on each element
>>> freshfruit = ['  banana', '  loganberry ', 'passion fruit  ']
>>> [weapon.strip() for weapon in freshfruit]
['banana', 'loganberry', 'passion fruit']
>>> # create a list of 2-tuples like (number, square)
>>> [(x, x**2) for x in range(6)]
[(0, 0), (1, 1), (2, 4), (3, 9), (4, 16), (5, 25)]
>>> # the tuple must be parenthesized, otherwise an error is raised
>>> [x, x**2 for x in range(6)]
  File "<stdin>", line 1, in <module>
    [x, x**2 for x in range(6)]
               ^
SyntaxError: invalid syntax
>>> # flatten a list using a listcomp with two 'for'
>>> vec = [[1,2,3], [4,5,6], [7,8,9]]
>>> [num for elem in vec for num in elem]
[1, 2, 3, 4, 5, 6, 7, 8, 9]
```

列表推导式可以使用复杂的表达式和嵌套函数：



```python
>>> from math import pi
>>> [str(round(pi, i)) for i in range(1, 6)]
['3.1', '3.14', '3.142', '3.1416', '3.14159']
```



列表推导式就是倒装句，类似于山东话。比如：a的值是i，i是啥呢？i是100。或者 a列表的元素们是i的平方，i是啥呢？i是 for i in range(0,10),如下图所示:

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211208224745066.png" alt="image-20211208224745066" style="zoom:50%;" />



二维列表我们一般采取这样缩进来写：

```python
a = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
```





### 8排序

参考：[内置函数sorted()](https://docs.python.org/zh-cn/3/library/functions.html#sorted)     [排序小结](https://docs.python.org/zh-cn/3/howto/sorting.html#sortinghowto)



#### 8.0基础

**`sorted()`**与**`list.sort()`**

**区别：**前者可用于任何可迭代对象，并返回一个新的列表，不改变原序列。而后者只针对于列表，且会改变原列表。

下面介绍sorted():

`sorted(iterable, *, key=None, reverse=False) `：根据 *iterable* 中的项返回一个新的已排序列表。

 *key* 指定带有单个参数的函数，用于从 *iterable* 的每个元素中提取用于比较的键 (例如 `key=str.lower`)。 默认值为 `None` (直接比较元素)。

*reverse* 为一个布尔值。 如果设为 `True`，则每个列表元素将按反向顺序比较进行排序。

内置的 [`sorted()`](https://docs.python.org/zh-cn/3/library/functions.html#sorted) 确保是稳定的。 如果一个排序确保不会改变比较结果相等的元素的相对顺序就称其为稳定的 --- 这有利于进行多重排序（例如先按部门、再按薪级排序）。







#### 8.1key关键函数：

```python
>>> sorted("This is a test string from Andrew".split(), key=str.lower)
['a', 'Andrew', 'from', 'is', 'string', 'test', 'This']
```

*key* 形参的值应该是个函数（或其他可调用对象），它接受一个参数并返回一个用于排序的键

```python
#一种常见的模式是使用对象的一些索引作为键对复杂对象进行排序。例如：
>>> student_tuples = [
...     ('john', 'A', 15),
...     ('jane', 'B', 12),
...     ('dave', 'B', 10),
... ]
>>> sorted(student_tuples, key=lambda student: student[2])   # sort by age
[('dave', 'B', 10), ('jane', 'B', 12), ('john', 'A', 15)]


#同样的技术也适用于具有命名属性的对象。例如：
>>> class Student:
...     def __init__(self, name, grade, age):
...         self.name = name
...         self.grade = grade
...         self.age = age
...     def __repr__(self):
...         return repr((self.name, self.grade, self.age))

>>> student_objects = [
...     Student('john', 'A', 15),
...     Student('jane', 'B', 12),
...     Student('dave', 'B', 10),
... ]
>>> sorted(student_objects, key=lambda student: student.age)   # sort by age
[('dave', 'B', 10), ('jane', 'B', 12), ('john', 'A', 15)]
```

#### 8.2Operator 模块函数

上面显示的键函数模式非常常见，因此 Python 提供了便利功能，使访问器功能更容易，更快捷。 [`operator`](https://docs.python.org/zh-cn/3/library/operator.html#module-operator) 模块有 [`itemgetter()`](https://docs.python.org/zh-cn/3/library/operator.html#operator.itemgetter) 、 [`attrgetter()`](https://docs.python.org/zh-cn/3/library/operator.html#operator.attrgetter) 和 [`methodcaller()`](https://docs.python.org/zh-cn/3/library/operator.html#operator.methodcaller) 函数。

使用这些函数，上述示例变得更简单，更快捷：

```python
>>> from operator import itemgetter, attrgetter

>>> sorted(student_tuples, key=itemgetter(2))
[('dave', 'B', 10), ('jane', 'B', 12), ('john', 'A', 15)]

>>> sorted(student_objects, key=attrgetter('age'))
[('dave', 'B', 10), ('jane', 'B', 12), ('john', 'A', 15)]
```

Operator 模块功能允许**多级排序**。 例如，按 *grade* 排序，然后按 *age* 排序：

```python
>>> sorted(student_tuples, key=itemgetter(1,2))
[('john', 'A', 15), ('dave', 'B', 10), ('jane', 'B', 12)]

>>> sorted(student_objects, key=attrgetter('grade', 'age'))
[('john', 'A', 15), ('dave', 'B', 10), ('jane', 'B', 12)]
```

#### 8.3reverse升序和降序

[`list.sort()`](https://docs.python.org/zh-cn/3/library/stdtypes.html#list.sort) 和 [`sorted()`](https://docs.python.org/zh-cn/3/library/functions.html#sorted) 接受布尔值的 *reverse* 参数。这用于标记降序排序。 例如，要以反向 *age* 顺序获取学生数据：

reverse = True

```python
>>> sorted(student_tuples, key=itemgetter(2), reverse=True)
[('john', 'A', 15), ('jane', 'B', 12), ('dave', 'B', 10)]

>>> sorted(student_objects, key=attrgetter('age'), reverse=True)
[('john', 'A', 15), ('jane', 'B', 12), ('dave', 'B', 10)]
```





排序保证是 [稳定](https://en.wikipedia.org/wiki/Sorting_algorithm#Stability) 的。 

利用上述性质，实现多级排序Plus（第一个性质升序，第二性质降序）：

```python
#这个美妙的属性允许你在一系列排序步骤中构建复杂的排序。例如，要按 grade 降序然后 age 升序对学生数据进行排序，请先 age 排序，然后再使用 grade 排序：
>>> s = sorted(student_objects, key=attrgetter('age'))     # sort on secondary key
>>> sorted(s, key=attrgetter('grade'), reverse=True)       # now sort on primary key, descending
[('dave', 'B', 10), ('jane', 'B', 12), ('john', 'A', 15)]
```





### 9内置函数

len()

type()

sorted()： 默认升序，sorted(a)会得到一个排序的数组，但不会改变a

abs(number)，返回数字的绝对值

cmath.sqrt(number)，返回平方根，也可以应用于负数

float(object)，把字符串和数字转换为浮点数

help()，提供交互式帮助

input(prompt)，获取用户输入

int(object)，把字符串和数字转换为整数

math.ceil(number)，返回数的上入整数，返回值的类型为浮点数

math.floor(number)，返回数的下舍整数，返回值的类型为浮点数

math.sqrt(number)，返回平方根不适用于负数

pow(x,y[.z]),返回X的y次幂（有z则对z取模）

repr(object)，返回值的字符串标示形式

round(number[.ndigits])，根据给定的精度对数字进行四舍五入

str(object),把值转换为字符串





#### input函数（有关输入的知识）

```python
x = int(input("Please enter an integer: "))
```

从标准输入读入用input， input会返回一个**字符串** 。**int()**是一个函数，注意不是变量类型

每次input，会input一整行。







```python
#一行内读取两个整数
a, b = map(int, input().split())
```

解释：input读取的是**一行字符串**，所以需要用split(' ')来分割，注意split返回的是一个**列表**，列表里的元素都是**string**，因此我们需要用**map**，对列表的每一个元素做一个映射。



当我们想要读入一行数，并得到一个列表的时候：

```python
d = list(map(int, input().split()))
```

解释：1、split函数不加参数时，以空格分隔      2、map函数返回的是可迭代对象，返回一个将 *function* 应用于 *iterable* 中每一项并输出其结果的**迭代器**。而不是**列表** 3、我们要想返回列表再加一层list函数









#### print函数

[print用法](https://blog.csdn.net/jcjc918/article/details/9354815)或者[菜鸟](https://www.runoob.com/w3cnote/python3-print-func-b.html)

```python
>>> s
'Hello'
>>> x = len(s)
>>> print("The length of %s is %d" % (s,x))
The length of Hello is 5
```

```python
>>> pi = 3.141592653
>>> print('%10.3f' % pi) #字段宽10，精度3
     3.142
>>> print("pi = %.*f" % (3,pi)) #用*从后面的元组中读取字段宽度或精度
pi = 3.142
>>> print('%010.3f' % pi) #用0填充空白
000003.142
>>> print('%-10.3f' % pi) #左对齐
3.142     
>>> print('%+f' % pi) #显示正负号
+3.141593
```

```python
>>> for x in range(0,10):
	print (x,end = '')
 
0123456789
```

![image-20211209163012627](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211209163012627.png)



#### range函数：  

range返回整数区间











### 10模块

文件内容以及文件结构：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211209203036373.png" alt="image-20211209203036373" style="zoom:50%;" /><img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211209203530895.png" alt="image-20211209203530895" style="zoom: 50%;" />

导入方式1：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211209202518859.png" alt="image-20211209202518859" style="zoom:67%;" />

导入方式2：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211209202550163.png" alt="image-20211209202550163" style="zoom:67%;" />

当我们导入多个模块的时候，并且都用方式2：导入函数，那么就有可能出现不同模块中的函数重名的情况，这个时候我们使用as关键字来解决这个问题。如下所示：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211209203633383.png" alt="image-20211209203633383" style="zoom:50%;" />



python自带了很多比较实用的模块 比如random模块里的randint(x,y)函数，返回一个[x,y]之间的随机数



### 11输入输入

```python
>>> s
'Hello'
>>> x = len(s)
>>> print("The length of %s is %d" % (s,x))
The length of Hello is 5
```

这种格式化的方式，不仅可以用于print函数里，定义字符串也行,这种格式化的方式可以用于任何出现字符串的地方。

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211209205832001.png" alt="image-20211209205832001" style="zoom:67%;" />





#### 文件读入读出

**输出**

```python
fout = open('test.txt', 'w')
for i in range(10):
    fout.write(str(i) + '\n')
fout.flush() #或者fout.close()

#此时，当前目录下就有了test.txt文件，并写进去了内容
```

一般情况下，我们要用with操作，来增加程序的鲁棒性,避免数据丢失（在内存中，未写入文件）或者避免内存泄露的问题。

```python
with open('test.txt', 'w') as fout:
    for i in range(10):
    	fout.write(str(i) + '\n')        #不用显示地调用fout.close()了，会自己关闭
```

内存泄漏（Memory Leak）是指程序中已动态分配的堆内存由于某种原因程序未释放或无法释放，造成系统内存的浪费，导致程序运行速度减慢甚至系统崩溃等严重后果。





**读入**

```python
with open('test.txt', 'r') as fin:
    print(fin.read())

    
#也可以读入所有行
with open('test.txt', 'r') as fin:
    print(fin.readlines()) 
    #	['0\n', '1\n', '2\n', '3\n', '4\n', '5\n' ....] 返回一个列表

#
with open('test.txt', 'r') as fin:
    for line in fin:
        print(line, '') #由于每行的行末已经有回车了，所以此处我们可以取消print的行末换行
```







### 12异常处理

当一些代码段可能会出现错误的时候，我们就用到了异常处理的知识点，当出现异常时，如果不用try语句，那么程序会自动停止，但如果用了try，那么会把这个异常捕获掉，程序不会中断。

```python
def divide(x, y):
    try:
        res = x / y
    except Exception as e:
        print("you got an error:", str(e)) # try语句体发生异常，则执行此句话
    else:
        print("result is", res) # try语句体没发生异常，则执行此句话
    finally:
     	print("executing finally clause") #不管try语句体有没有异常都要执行此句话，一般用于关闭数据库
```









### 13类

```python
>>> class Student:
...     def __init__(self, name, grade, age):
...         self.name = name
...         self.grade = grade
...         self.age = age
...     def __repr__(self):
...         return repr((self.name, self.grade, self.age))
```



```python
class Car:
    w = [] # 静态变量，所有实例对象共享
    def __init__(self): #所有的成员函数都要加一个self
        print("Created")
        self.a = []
 	
    def update(self):
        for i in range(len(self.a)):
            self.a[i] *= 2
    

a = Car()
>>Created
b = Car()
>>Created
a.a += [1, 2, 3]
a.a
>>[1, 2, 3]
a.update()
a.a
>>[2, 4, 6]
a.x = 100 #很随意 
```

当类里直接定义的是列表时，所有对象以及类对象共享，但如果定义的是一个普通的整数则不行（实例对象和类对象独有）

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211209221151191.png" alt="image-20211209221151191" style="zoom: 50%;" />

但是在init函数里可以定义成员变量。

python很随意，可以随时生成成员函数，当实例对象都已经生成后，还可以随时定义。



构造函数也能加上参数

```python
class Car:
    w = [] # 静态变量，所有实例对象共享
    def __init__(self, x, y): #所有的成员函数都要加一个self
        print("Created")
        self.a = [x, y]
 	
    def update(self):
        for i in range(len(self.a)):
            self.a[i] *= 2
 
a = Car() #报错！！需要两个参数
a = Car(1, 2) #正确
a = Car(x = 1, y = 2) #正确
l = [1, 2]
a = Car(*l) #正确
#可见与函数用法一样
```







#### **继承**

```python
class DerivedClassName(BaseClassName):
    <statement-1>
    .
    .
    .
    <statement-N>
```

```python
 class Car: 
     w = -1# 静态变量，所有实例对象共享 
     def __init__(self): 
         print("Created") 
         self.a = []                                                     

 class Fa(Car): 
    def __init__(self): 
        super().__init__()  # 注意此处要调用基类的构造!!!!!!!!!!!!!
        print("Fa Created") 
```













## 2配置docker环境、git环境与项目创建



### 1、开始

加载镜像、生成container，attach到container，新建用户并分配sudo权限，开放云平台端口，配置免密登录和别名，复制配置文件（包括.gitconfig里的alias）

### 2、创建Django项目

`django-admin --version` 查看版本

`django-admin startproject acapp(名字)`

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211211154053785.png" alt="image-20211211154053785" style="zoom:50%;" />



建立云端仓库：

`git config --global user.name wangchen`

`git config --global user.email wangchen0333@163.com`

在container服务器里，`ssh-keygen`并复制到ACgit里

`git init /  git add . /  git commit / git remote add origin git@git.acwing.com:chnnnne/acapp.git /git push origin master`



### 3、试运行一下

先开个tmux，然后`python3 mange.py runserver 0.0.0.0:8000`

此时出现：<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211211163336392.png" alt="image-20211211163336392" style="zoom:67%;" />

我们用浏览器就可以通过`公网ip:8000`来访问网站了：<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211211163647874.png" alt="image-20211211163647874" style="zoom:67%;" />

  

我们发现，我们需要把上面所说的IP地址加到ALLOWED_HOSTS。ALLOWED_HOSTS在哪里呢？我们可以通过ag命令找到，它在acapp/acapp/settings.py里

然后我们把上图红圈里的ip复制到settings.py的ALLOWED_HOSTS里，记得加引号，保存之后，我们就成功了，重新访问这个网址：出现了↓

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211211164820692.png" alt="image-20211211164820692" style="zoom:67%;" />

到这，我们可以commit一下代码了，<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211211165049031.png" alt="image-20211211165049031" style="zoom:50%;" />

需要注意的是 `__pycache__文件夹` ，是python预编译好的，是为了加速python运行的，是python自动生成的，是中间文件，不是源代码，这种文件不要传到git上。因此我们要忽略这个文件夹，我们回到git仓库的家目录，创建一个文件`gitignore`,里面写上:

```bash
**/__pycache__
```

这样就可以了，我们再git st一下：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211211165814437.png" alt="image-20211211165814437" style="zoom:67%;" />

发现已经没`__pycache_`了，然后我们git add git commit git push 吧



### 4、接着开发

y总，习惯再开一个tmux（也即再开一个session（复习一下 tmux是session-window-panel的结构））

一个作为控制台，运行django服务器程序。一个用于开发写代码。



创建一个app（django专有名词）:`python3 manage.py startapp game（名字）` ，执行之后就创建了一个app叫game，其实就是创建了一个文件夹。

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211211213457412.png" alt="image-20211211213457412" style="zoom:67%;" />

其中admin.py存储管理员页面能看到哪些数据库，apps.py用的不多，只会用一次。models.py用来定义网站里的各种数据库表，tests.py不用管，views.py是写函数的。

然后可以add commit push一下。



Django有一个管理员页面，直接在url后面加上/admin即可访问，但是第一次访问时，可能是一堆提示报错，此时我们需要将数据库的内容更新上去，需要执行`python3 manage.py migrate`然后就可以再次访问admin了。

为了能登录管理员界面，我们需要创建一个管理员账号`python3 manage.py createsuperuser`

记录一个错误：我在执行创建管理员语句的时候，出现了错误：Python 中问题:django.db.utils.OperationalError: no such table: auth_user，解决方法其实就是上面所说的，做一个迁移就好了，[我参考了](https://blog.csdn.net/Moniicoo/article/details/80858129)。

现在我们就创建好了superuser，username：admin,  paswd:123456,

接下来我们就能登录到admin后台了！





创建一个app就足够了。

我们切换到game文件夹：

最重要的三个py文件， models/views/urls.还有一个文件夹templates,我们把没有的先创建出来（urls和templates原先没有）。templates存的是文件模板

整体结构：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211212103957940.png" alt="image-20211212103957940" style="zoom:67%;" />



- **models.py**用来定义网站里的各种数据库表，存各种**class**。比如默认生成的groups 和 users。注意现在的models是一个文件，当以后数据库变多的时候会变成一个文件夹。
- **views.py**存的是视图，是写**函数**的，调用的所有服务器端函数都是在views实现的。
- **urls.py**：**路由**，当用户点击时，此时传的是url，来一个url来判断调用哪个函数，根据url判断调什么函数。
- **templates**就是存**html**的。

整个项目要操作的就这四个东西。



先在~/acapp/game/views.py里实现一个最简单的函数（注意两个tmux，一个运行服务器，一个用于开发）：

```python
from django.http import HttpResponse

def index(request)
    return HttpResponse("我的第一个网页")
```

然后我们改一下~/acapp/game/urls.py，可以仿照 ~/acapp/acapp/urls.py写

```python
from django.urls import path
from game.views import index #不懂为什么是game.views 而不是直接views ，难道urls.py和views.py不在一个文件夹下吗？ 答：qs在一个文件夹下，但是此处背过吧，我猜测是从~/acapp作为起始文件夹，下面的写法也可以印证这点
urlpattens = [
    path("", index, name = "game_index"), #解释：首先可见path函数的第一个参数为空字符串，它的意义是如果url后啥都没有的话，也即只有ip地址和端口号，他就会调用views里的index函数。但是注意的是，我们等会儿还需要把app的url写到总url，也即acapp的urls.py里
]
```



~/acapp/acapp/urls.py是**总url**，我们做以下修改：

```python
from django.contrib import admin
from django.urls import path, include  #把include函数也要import进来

urlpatterns = [
    path('game/', include('game.urls')), #如果用户请求的是ip:port/game的话就会跳到~/acapp/game/urls.py里了
    path('admin/', admin.site.urls), #r如果用户请求的是ip:port/admin 就会调用admin/site的urls函数
]
```

为了方便，我们可以改为

```python
path('', include('game.urls'))
```





以上全过程的图解：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211212114546626.png" alt="image-20211212114546626" style="zoom: 50%;" />





#### 关于urls.py

> 先总urls，匹配前缀，后应用urls，匹配剩余部分。
>
> 在总urls中，import include。应用urls中，import veiws里的函数（注意以项目根目录作为起始），具体写法看上面例子

[参考](https://www.cnblogs.com/hanmk/p/12656391.html)

[整体逻辑](https://www.cnblogs.com/1a2a/p/7701254.html)

[更复杂的设计正则的](https://blog.csdn.net/jjjndk1314/article/details/79730750)







现在我们可以git保存一下了，注意会有很多.swp文件，这是我们不需要的，因此我们又需要.gitignore了

```bash
**/__pycache__
*.swp
```

[关于.gitignore](https://www.jianshu.com/p/1c74f84e56b4)



然后add commit push就行了







## 3创建菜单页面

这节课把骨架做出来，宏观系统设计



项目可以分为菜单、对战界面（单人模式、多人模式）、设置

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211212211551746.png" alt="image-20211212211551746" style="zoom:33%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211212214934658.png" alt="image-20211212214934658" style="zoom:50%;" />



### **3.1项目文件结构**（分工明确）

- **templates目录**：管理html文件
- **urls目录**：管理路由，即链接与函数的对应关系
- **views目录**：管理http函数，里面是py文件
- **models目录**：管理数据库数据
- **static目录**：管理静态文件，比如：
  - **css**：对象的格式，比如位置、长宽、颜色、背景、字体大小等
  - **js**：对象的逻辑，比如对象的创建与销毁、事件函数、移动、变色等
  - **image**：图片
  - **audio**：声音
    …
- **consumers目录**：管理websocket函数

需要注意的是 **urls/models/views** 三个文件夹都是python文件，管理的时候，如果想import，就必须在文件夹下创建三个索引文件**`__init__.py`** ,所有的python文件夹里都要创建，包括子文件夹，否则在import的时候就  `.`不进来，会报错



**开发流程，写templates的html，写views，写urls，完善js/css**



### 3.2接着开发了

另外需要注意的是：项目系统设计分为<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211213182245046.png" alt="image-20211213182245046" style="zoom:50%;" />这三个部分，后续我们的每一个目录最好都分为三个文件夹，比如templates里最好有三个文件夹分别叫`menu、playground、settings`，同理urls目录下也有`menu、playground、settings`这三个文件夹。也即项目的系统设计要对应到每一个文件夹里面，每个文件夹都要创建这三个模块，这样不容易乱。





在`~/acapp/acapp/settings.py`文件中，更改下时区，把第108行的TIME_ZONE更改成 'Asia/Shanghai',这样在控制台的信息就是我们的时间了。

LANGUAGE语言默认是英语，不推荐改变。



下面我们需要将写的app装进来（这个操作对这节课没影响，但下节涉及到数据库的时候就有影响了）。 ~/acapp/game/apps.py里有个Class叫GameConfig,我们需要将它加到 ~/acapp/acapp/settings.py里的INSTALLED_APPS参数列表里。

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211212223606789.png" alt="image-20211212223606789" style="zoom:67%;" />



### 3.3static资源

#### 1、路径设置

下面：我们设置一下静态文件的地址，进到acapp/acapp/settings.py的最后一行，看到120+行有STATIC_URL参数。接下来我们还需要加上另外三句话：`STATIC_ROOT = os.path.join(BASE_DIR, 'static')`代表静态文件存到项目的哪一个文件夹里面，BASE_DIR在开头定义的，另外需要导入一下os包，在开头`import os`。表示我们要将文件放到BASE_DIR/static文件夹下了。也即~/acapp/game/static

除此之外，还有一个类似的，`MEDIA_ROOT = os.path.join(BASE_DIR, 'media')`和`MEDIA_URL = '/media/'`

此处的os.path.join函数的作用就是合并路径。



STATIC和MEDIA都能存静态文件，一般习惯的是：static存开发者的文件，media里存用户的文件。

#### 2、图片

怎么找到静态文件呢？我们先在`~/acapp/game/static/image/`下，再创建三个文件夹，分别叫`menu、playground、settings` ，下载图片的命令是：`wget --output-document=自定义图片名称 图片地址`  [图片地址](https://gimg2.baidu.com/image_search/src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_match%2F0%2F11156556256%2F0.jpg&refer=http%3A%2F%2Finews.gtimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg)

然后我们把网上的图片下载到了服务器上，注意文件下会多一个wget-log没啥用，可以直接删掉。然后我们的~/acapp/game/static/image/menu下就多了一个图片background.gif，我们在浏览器上访问它的路径是：ip:port/static/image/menu/background.gif  为什么呢？ 为什么url里的static对应acapp/game/static呢？ 经测试之后，这与~acapp/acapp/settings.py的INSTALLED_APPS参数有关，如果不加入GameConfig就找不到该图片！！！ 关于这点，想深入学习的话，参考 [1](https://cn.bing.com/search?q=django%E9%9D%99%E6%80%81%E6%96%87%E4%BB%B6&qs=n&form=QBRE&sp=-1&pq=&sc=0-0&sk=&cvid=CD1E3F90CBA540B48689601B7C98B7A2)   [2](https://code.ziqiangxuetang.com/django/django-static-files.html#:~:text=%E9%9D%99%E6%80%81%E6%96%87%E4%BB%B6%E6%98%AF%E6%8C%87%20%E7%BD%91%E7%AB%99%E4%B8%AD%E7%9A%84%20js%2C%20css%2C%20%E5%9B%BE%E7%89%87%EF%BC%8C%E8%A7%86%E9%A2%91%E7%AD%89%E6%96%87%E4%BB%B6,%E5%BC%80%E5%8F%91%E9%98%B6%E6%AE%B5%20%E6%8E%A8%E8%8D%90%E7%94%A8%E6%96%B0%E7%89%88%E6%9C%AC%E7%9A%84Django%E8%BF%9B%E8%A1%8C%E5%BC%80%E5%8F%91%EF%BC%8C%E5%8F%AF%E4%BB%A5%E8%82%AF%E5%AE%9A%E7%9A%84%E6%98%AF%20Django%201.4%20%E4%BB%A5%E5%90%8E%E7%9A%84%E7%89%88%E6%9C%AC%E5%BA%94%E8%AF%A5%E9%83%BD%E6%94%AF%E6%8C%81%E4%B8%8B%E9%9D%A2%E7%9A%84%E8%AE%BE%E7%BD%AE%20%E6%B3%A8%E6%84%8F%EF%BC%9ADjan)     [3](https://www.cnblogs.com/olivertian/p/10968158.html)

 

#### 3、CSS

现在我们看`game/static/css`，按照刚才的理论也要拆分成三部分，但是CSS不需要，因为内容比较少，一个文件就行了。我们新创个文件叫`game.css`我们同样可以通过路径来访问它。

#### 4、JS

下面我们看js文件，因为它会非常多，因此我们分成两个文件夹 `dist 和 src` 。mkdir这两个文件，dist是最终使用的js文件，src存的是所有的js源文件， src中可能有几十个源文件，通过自己的操作生成一个完整的js文件放到dist里面，src下再设三个文件夹`menu/playground/settings`。上述的合并操作可以自己写个脚本来实现。可以把脚本都放到~/acapp的scripts文件夹里面，然后创建一个脚本叫compress_game_js.sh，是一个bash脚本，它的作用就是将src里面的所有js文件合并成一个完整的文件，放到dist里面（打包）。以下是 ~/acapp/scripts/game.sh文件内容:

```bash
#! /bin/bash

JS_PATH=/home/wangchend/acapp/game/static/js/
JS_PATH_DIST=${JS_PATH}dist/
JS_PATH_SRC=${JS_PATH}src/

# 把src下所有的js文件(注意忽略文件夹和.swp文件) 集中到dist文件夹里的game.js文件
find ${JS_PATH_SRC} -type f -name '*.js' | sort | xargs cat > ${JS_PATH_DIST}game.js
#这只是一个简略版，以后用其他的打包工具代替
```

然后加上`chmod +x game.sh`，就可以运行了。

add commit push以下





### 3.4再接着开发

#### 1、templates

 下面在templates文件夹下html了。创建`menu/playground/settings`三个目录，再创建一个multiends文件夹，里面写个web.html。内容如下：

```html
{% load static %}
<head>
    <!--head里可以引入资源 第一行是css文件，第二行是jQuery文件。-->
    <link rel="stylesheet" href="https://cdn.acwing.com/static/jquery-ui-dist/jquery-ui.min.css">
    <script src="https://cdn.acwing.com/static/jquery/js/jquery-3.3.1.min.js"></script>
    <!--我们也可以引入自己写的css文件，写法如下： 注意的是，我们使用Django自带的工具,如下面的写法所示：！！！，此外还需要在开头加上一句话-->
    <link rel="stylesheet" href="{% static 'css/game.css'%}"
</head>
wangchend@ea880cb7c957:~/acapp/game/templates/multiends$ tmux a
[detached (from session 1)]
wangchend@ea880cb7c957:~/acapp/game/templates/multiends$ cat web.html 
{% load static %}
<head>
    <!--head里可以引入资源 第一行是css文件，第二行是jQuery文件。-->
    <link rel="stylesheet" href="https://cdn.acwing.com/static/jquery-ui-dist/jquery-ui.min.css">
    <script src="https://cdn.acwing.com/static/jquery/js/jquery-3.3.1.min.js"></script>
    <!--我们也可以引入自己写的css文件，写法如下： 注意的是，我们使用Django自带的工具,如下面的写法所示：！！！，此外还需要在开头加上一句话-->
    <link rel="stylesheet" href="{% static 'css/game.css'%}"
    <!--下面导入js文件,注意Django里的静态文件就要这样写，大括号百分百号{%%}。   注意script需要闭标签-->
    <script src="{% static 'js/dist/game.js' %}"> </script>

</head>

<!--margin:0什么含义呢？ html里面每一个元素都有一个属性叫margin，比如我们有一个矩形，margin:5的意思就是，矩形的真实宽度是矩形的一圈加上5px，而margin:0就表示当前的边界就是真实边界，不要外延，后者不加这句话会默认外延一小部分-->
<body style="margin: 0">
    <div id="ac_game_12345678"></div>
    <script>
        $(document).ready(function(){
            let ac_game = new AcGame();
        })
    </script>
</body>
```



#### 2、JS

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211214212314412.png" alt="image-20211214212314412" style="zoom:67%;" />

下面回到`~/acapp/game/static/js/src`目录下，`mkdir menu/ playground/ settings` 然后在src目录下创建一个总的js文件，比如可以叫`zbase.js`因为打包工具是按字典序打包的，总的class会调用三个文件夹里其他的class，js是在调用之前必须定义好，在打包成一个文件之后，需要保证三个目录里的文件在总文件前面，由于是按文件名字典序，所以加个z可以保证zbase.js一定会被排到所有文件的后面。



下面我们简单写一下base.js

```javascript
class AcGame {
    constructor(id){
        
    }
}
```

然后我们调用一下`~/acapp/srcipts/compress_game_js.sh`，发现`~/acapp/game/static/js/dist/game.js`已经改变。这样的话，我们的html就写完了，我们就不用动templates里的html了，而是在js里写。可以调用一下compress_脚本了



### 3.5写views(py函数)

去到`~/acapp/game/views`目录下，创建`menu/playground/settings`然后在这三个目录中都分别创建`__init__.py`文件

然后在`~/acapp/game/views`写一个总的函数叫**`index.py`**，只会在web端会被调用，在其他端（比如acapp端？）不会被调用，它的主要作用就是返回刚刚写的`template/multiends/web.html`文件。index.py的写法：

```python
from django.shortcuts import render # 在服务器端渲染一个html文件。渲染的意思就是将html文件的内容拿过来拼接字符串

def index(request):
    return render(request, "multiends/web.html") # 从templates目录下开始写,可能是因为render默认会去templates文件夹,注意！！！！！！！
```



所谓渲染页面：就是在python里面把字符串拼接出来，有前端渲染，后端渲染。前后端分离就是在前端渲染

渲染就是生成html？

### 3.6写urls路由

写完view里的py函数就可以写路由了。

进到`~/acapp/game/urls/`目录下，创建`menu/playground/settings`目录，分别创建`__init__.py`文件

然后再`~/acapp/game/urls/`目录下创建**`index.py`**，每个urls文件夹下都是由index.py，作用是将这个路径下所有其他文件夹的路径include进来。它的写法仿照`~/acapp/acapp/urls.py`来写

```python
from django.urls import path, include
from game.views.index import index # 从~acapp/game/views/index.py里import一个index函数
urlpatterns = [
    path("", index, name="index"), #此处不写东西了
    path("menu/", include("game.urls.menu.index")),
    path("playground/", include("game.urls.playground.index")),
    path("settings/", include("game.urls.settings.index")),
]
```

进到menu/playground/settings里先暂时创建index.py

```python
from django.urls import path
urlpatterns = [

]
```

视频1:07:00讲了urls的寻找方法: 前缀匹配，比如`path("menu/", include("game.urls.menu.index"))`,就是当url是ip:port/menu时会进入game/urls/menu/index.py进行再匹配，注意关键词include。或者`path("", index, name="index")`意思就是当url是ip:port然后就没有了的时候，会直接匹配index函数，index函数在上面import进来了，它在views文件夹下，index函数又返回了templates里的html文件。

**总的过程简单地说就是: 用户发送URL->总urls->app_urls->views函数->template文件->用户得到html**

可见urls的作用就是**给定URL找到函数**







### 3.7最终目录结构









### 3.8终于完成了准备工作了

思路整理：

我们通过上面的一通操作，我们弄好了目录结构。

以templates/multiends/web.html为例说明。用户请求的url经过url映射先后经过了acapp/acapp/urls.py和acapp/game/urls/index.py，然后又找到了acapp/game/views/index.py里的index函数，这个函数返回的是template/multiends/web.html。这个界面的内容得先在后端服务器上进行渲染，也即拼接，注意包含了把game/static/js/dist/game.js引入的操作（这里面又包含把src里的内容先compress一下），然后把拼接好后的字符串作为html文件返回给用户前端浏览器，浏览器执行js代码。

### 3.9接着弄

在我们的设计结构下，每一个结构都是一个class，比如一个矩形就是一个class，class负责控制这个对象的所有功能，如果模块很小的话没有必要单开一个class，但像界面这样比较大的对象，都会有一个class来管理它的所有行为。下面我们开始创建这个class：在acapp/game/static/js/src/menu/zbase.js

```javascript
class AcGameMenu{
    constructor(root){
        this.root = root; //root对象就是web.html里的ac_game对象
        this.$menu = $(`
<div class="ac-game-menu">

</div>
            `);
        //创建当前界面,html对象前一般加一个$，普通对象不加$,注意不是'而是`,类似python的''' 怎么写怎么显示到前端。
    }
}
```

下面我们要设置一下背景图案的样式，需要创建css文件了，编辑staic/css/game.css



### 3.10本节课的关键文件！！

#### html和JS

game/templates/web.html

```html
{% load static %}
<head>
    <!--head里可以引入资源 第一行是css文件，第二行是jQuery文件。-->
    <link rel="stylesheet" href="https://cdn.acwing.com/static/jquery-ui-dist/jquery-ui.min.css">
    <script src="https://cdn.acwing.com/static/jquery/js/jquery-3.3.1.min.js"></script>
    <!--我们也可以引入自己写的css文件，写法如下： 注意的是，我们使用Django自带的工具,如下面的写法所示：！！！，此外还需要在开头加上一句话-->
    <link rel="stylesheet" href="{% static 'css/game.css'%}"
    <!--下面导入js文件,注意Django里的静态文件就要这样写，大括号百分百号。   注意script需要闭标签-->
    <script src="{% static 'js/dist/game.js' %}"> </script>

</head>

<!--margin:0什么含义呢？ html里面每一个元素都有一个属性叫margin，比如我们有一个矩形，margin:5的意思就是，矩形的真实宽度是矩形的一圈加上5px，而margin:0就表示当前的边界就是真实边界，不要外延，后者不加这句话会默认外延一小部分-->
<body style="margin: 0">
    <div id="ac_game_12345678"></div>
    <script>
        $(document).ready(function(){
            let ac_game = new AcGame("ac_game_12345678");
        })
    </script>
</body>

```

game/static/js/src/zbase.js

```javascript
class AcGame {
    constructor(id){
        this.id = id;
        this.$ac_game = $('#' + id); //ac_game是给div取的名字，这行代码的意义是使用jQuery获得html里的div对象
        this.menu = new AcGameMenu(this);
        this.playground = new AcGamePlayground(this);

        this.start();
    }

    start(){//start其实就是构造函数的延伸
    
    }
}
```

game/static/js/src/menu/zbase.js

```javascript
class AcGameMenu{
    constructor(root){
        this.root = root; //root对象就是web.html里的ac_game对象
        this.$menu = $(`
<div class="ac-game-menu">
    <div class="ac-game-menu-field">
        <div class="ac-game-menu-field-item ac-game-menu-field-item-single-mode">
            单人模式
        </div>
        <br>
        <div class="ac-game-menu-field-item ac-game-menu-field-item-multi-mode">
            多人模式
        </div>
        <br>
        <div class="ac-game-menu-field-item ac-game-menu-field-item-settings">
            设置
        </div>
    </div>
</div>
         `);
        //创建当前界面,html对象前一般加一个$，普通对象不加$。注意不是'而是`,类似python的''' 怎么写怎么显示到前端。
        this.root.$ac_game.append(this.$menu);
        this.$single_mode = this.$menu.find(".ac-game-menu-field-item-single-mode");
        this.$multi_mode = this.$menu.find(".ac-game-menu-field-item-multi-mode");
        this.$settings = this.$menu.find(".ac-game-menu-field-item-settings")
         
        this.start();
    }

    start(){
        this.add_listening_events();
    }
    //流程：constructor->start->add_listening_events
    add_listening_events(){
        //注意：在function内部使用this的时候其实是function本身，而不是外边的this，所以我们需要先把外边的this存一下
        let outer = this;
        this.$single_mode.click(function(){
            outer.hide();
            outer.root.playground.show();
        });
        this.$multi_mode.click(function(){
            console.log("click multi mode");
        });
        this.$settings.click(function(){
            console.log("click settings");
        });
    }
    show(){
        this.$menu.show();
    }
    hide(){//关闭menu界面。点完单人多人模式后，关闭menu界面打开游戏界面
        this.$menu.hide();
    }
}
```

acapp/game/static/js/playground/zbase.js

```javascript
class AcGamePlayground{
    constructor(root){
        this.root = root;
        this.$playground = $(`<div>游戏界面<div/>`);
    
        this.hide();
        this.root.$ac_game.append(this.$playground);

        this.start();
    }
    start(){

    }
    update(){

    }

    show(){//打开playground界面
        this.$playground.show();
    }
    hide(){//关闭playground界面
        this.$playground.hide();
    }
}
```

game/static/css/game.css

```css
.ac-game-menu {
    width: 100%;
    height: 100%;
    background-image: url("/static/image/menu/background.gif");
    background-size: 100% 100%;
    user-select:none;
}

.ac-game-menu-field {
    /*百分比单位，vh是百分比高度，  vw是百分比宽度 
     top是左上角距离上方的高度
     left是到左边的宽度
     * */
    width: 20vw;
    position: relative;
    top: 40vh;
    left: 19vw;
}
.ac-game-menu-field-item {
    color: white;
    height: 6vh;
    width: 18vw;
    font-size: 4vh;
    font-style: italic;
    text-align: center;
    background-color: rgba(39,21,28, 0.6);
    border-radius: 10px;
    letter-spacing: 0.5vw;
    cursor: pointer;
}

.ac-game-menu-field-item:hover {
    transform: scale(1.2);
    transition: 100ms;
}
```



#### URL

acapp/acapp/urls.py

```python
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('', include('game.urls.index')),
    path('admin/', admin.site.urls),
]
```



acapp/game/urls/index.py

```python
from django.urls import path, include
from game.views.index import index # 从~acapp/game/views/index.py里import一个index函数
urlpatterns = [
    path("", index, name="index"), #此处不写东西了
    path("menu/", include("game.urls.menu.index")),
    path("playground/", include("game.urls.playground.index")),
    path("settings/", include("game.urls.settings.index")),
]
```



acapp/game/urls/menu/index.py

```python
from django.urls import path

urlpatterns = [

]
```

acapp/game/views/index.py

```python
from django.shortcuts import render

def index(request):
    return render(request, "multiends/web.html")
```





前面的页面切换时用链接切换，而在这里我们是在前端渲染，在用户端自己渲染不会跟服务器产生交互。

### 3.11关于前端



关于CSS的小知识：html里\<div class = "ac-game-menu" \> 类名叫ac-game-menu，那么在CSS想设置样式的话要写成`.ac-game-menu`            class加.  id加#          注释为/**/

关于JS的小知识：find就是在某个对象内部找class

我们的一般的程序语言变量名用下划线，而html的类一般用杠-

js是跑在浏览器的高级程序语言，核心思想是对象。

---

## 4创建游戏界面

纯js实现，先实现一个类似ulity3d的引擎。



我们发现现在生成的game.js里的全局变量，会变成html内部的全局变量，当引入多个js文件的时候，不同的js之间可能存在同名现象，我们最好做一个模块化，jsecm6最新版本支持面向对象，我们可以用模块的方式来重新组织。不用前面的方式了

```html
<script type= "module">
	import {AcGame} from "{% static 'js/dist/game.js' %}";
</script> <!--这样的话就可以把前面的script内容给删了-->
```

然后记得在acapp/game/static/js/src/zbase.js的`class`关键字前面加上`export` 这样就可以了，注意清空缓存



然后我们对js做一些基本的修改，只显示游戏界面，方便调试。



游戏里的动是怎么实现呢？每秒画60张图。我们发现整个游戏，每个物体（小球、火球、地图）都需要每秒画60次，实现一个基类AcGameObject（一个简易的游戏引擎），它的作用是去让每一个物体每一帧都画一次。基类是它的对象，每一帧都会调用它的刷新函数。它是未来所有画面里的class的基类，作用是每一帧都重新渲染







![image-20211219143506519](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211219143506519.png)



## 5部署nginx与对接acapp

把网站对应到https协议，一般来说都需要申请一个https证书，而且这个https证书一般和域名挂钩，极少会出现ip与证书绑定。 搞域名需要备案，



#### 1、常用端口号

| 网络服务 | 端口号 | 套接字 |
| -------- | ------ | ------ |
| FTP数据  | 20     | tcp    |
| FTP控制  | 21     | tcp    |
| SSH      | 22     | tcp    |
| Telnet   | 23     | tcp    |
| SMTP     | 25     | tcp    |
| HTTP     | 80     | tcp    |
| POP3     | 110    | tcp    |
| HTTPS    | 443    | tcp    |
| SOCKS    | 1080   | tcp    |
| DNS      | 53     | udp    |
| DHCP     | 67     | udp    |
| TFTP     | 69     | udp    |
| MySQL    | 3306   |        |
| Mongodb  | 27017  |        |
| Tomcat   | 8080   |        |
| 调试     | 8000   |        |



#### 2、

1. 增加容器的映射端口：80与443
第一步，登录容器，关闭所有运行中的任务。

第二步，登录运行容器的服务器，然后执行：

```bash
docker commit CONTAINER_NAME IMAGE_NAME  # 将容器保存成镜像，将CONTAINER_NAME替换成容器名称
docker stop CONTAINER_NAME  # 关闭容器
docker rm CONTAINER_NAME # 删除容器

# 使用保存的镜像重新创建容器

docker run -p 20000:22 -p 8000:8000 -p 80:80 -p 443:443 --name CONTAINER_NAME -itd django_lesson:1.1
```



第三步，去云服务器控制台，在安全组配置中开放80和443端口。

注意免密登录是不需要重新配置的，因为container->images





#### 3、上线acapp

按照链接内容走一遍即可



然后启动nginx服务：

```
sudo /etc/init.d/nginx start
```

如果报错了，可以重新加载Nginx,这样会提示错误信息

```
sudo nginx -s reload
```

此外，看报错信息还可以在/var/log/nginx/error.log里查看





y总提供的配置文件里nginx.conf里有内容要修改

```bash
:1,$s/acs/wangchend/gc        #将全文的word1替换为word2，且在替换前要求用户确认。
```







注意的是归档操作：

注意我们以前有个疑惑就是，通过这句话：<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211222141018281.png" alt="image-20211222141018281" style="zoom:67%;" />

后，我们在DEBUG =  True的模式下，直接访问ip:port/static就能访问到~/acapp/game/static文件下的内容，我当时还纳闷为什么一个app里的static可以直接对应一个项目的ip地址呢？现在发现，原来是DEBUG  = Ture的原因，我们吧DEBGU置为False，然后则必须把static文件放到~/acapp/目录下才能访问了！！

归档static文件：`python3 manage.py collectstatic`,这样就会自动把static放到~/acapp下了









以前是8000端口直接访问django。现在我们在django的前面加了层nginx，现在通过443或80端口访问nginx，而nginx和我们的django需要有一个桥梁，这个桥梁就是uwsgi。而且这个访问效率比python3 manage.py runserver效率快很多。

在启动uwsgi服务之前，记得关掉前面的runserver启动的进程。`uwsgi --ini scripts/uwsgi.ini`



## 6创建账号系统



## 7实现联机对战
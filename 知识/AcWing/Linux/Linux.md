传统资源型社会->知识密集型社会



# Linux





## 零、简介

Linux，全称GNU/Linux，是一套免费使用和自由传播的类UNIX操作系统，其内核由Linus林纳斯·本纳第克特·托瓦兹于1991年第一次释出，它主要受到Minix和Unix思想的启发，是一个基于POSIX和Unix的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的Unix工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。Linux有上百种不同的发行版，如基于社区开发的debian、archlinux，和基于商业开发的Red Hat Enterprise Linux、SUSE、oracle linux等。

Linux内核的主要模块（或组件）分以下几个部分：存储管理、CPU和[进程管理](https://baike.baidu.com/item/进程管理)、文件系统、设备管理和驱动、网络通信，以及系统的初始化（引导）、系统调用等。

Linux的发行版本其实就是Linux核心再加上外围的实用程序组成的一个大软件包而已。相对于Linux操作系统内核版本，发行版本的版本号随发布者的不同而不同，与Linux系统内核的版本号是相对独立的。因此把SUSE、RedHat、Ubuntu、Slackware等直接说成是Linux是不确切的，它们是Linux的发行版本，更确切地说，应该叫做“以Linux为核心的操作系统软件包”。根据GPL准则，这些发行版本虽然都源自一个内核，并且都有自己各自的贡献，但都没有自己的版权。Linux的各个发行版本（distribution），都是使用Linus主导开发并发布的同一个Linux内核，因此在内核层不存在什么兼容性问题。每个版本都不一样的感觉，只是在发行版本的最外层才有所体现，而绝不是Linux本身特别是内核不统一或是不兼容。



## 一、Ubuntu安装

[文件夹](D:\VMachine_And_iso)

1.最好创三个文件夹，一个放置Vmware 一个放置操作镜像，一个放置操作系统

我使用的是公众号（名字：软件安装目录）上的下载途径  下载后的压缩包在D:\VMachine_And_iso\iso里。安装步骤是  [链接](https://mp.weixin.qq.com/s?__biz=MzU5MDQ2MDQ3Ng==&mid=2247492888&idx=4&sn=33c0d8e249705ae15c904d4523f95f6a&chksm=fe3f464bc948cf5dae504202b5638391c8c8a77ef4da93c28de28a1bd83b66542e0439caf03c&scene=21&ascene=1&devicetype=Windows+10+x64&version=62090529&nettype=WIFI&abtest_cookie=AAACAA%3D%3D&lang=zh_CN&exportkey=AVZQ15yHS5r0oW5%2FyWK1a5Y%3D&pass_ticket=%2F%2BT35xnrSH49Q3Lv9bltWbLfqLd0s2ydlSJs2LQVAZC1ODPpE17tY1oQeQiRYbhN&wx_header=0&key=bf444740d953619059fac6a40536f65a3150ef8972b0eaddad574897ceac21ebcdf635a4f5f128ce2e2e8306f2ec8d79e584b4284205c9b6f2041525fb866297eac0894cd11a40fff6b653fb60ad7a20f8f9e288fe51f7161d07b9a6cb7738e5f094f5303aeb062b21b8f4896004f46ce7db168b179362cfb9f059c6ab6c4b83&uin=MTcxMDA3MjQzNQ%3D%3D)

也即概括为

1. 先安装VMware 输入秘钥
2. 再在虚拟机里新建一个操作系统，注意设置内存 磁盘 网络模式等等



## 二、VMware设置

（可以通过搜索按钮，输入网络连接，出现了下图）<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20200914202455946.png" alt="image-20200914202455946" style="zoom: 33%;" />

1. 对于设置-网络适配器
   1. 对于**桥接模式**：虚拟机和真实机进行通信利用的是真实网卡。缺点是虚拟机要占用真实机的ip
   2. 对于**NAT**：利用Vmnet8 和真实机进行通信   ，可以上网
   3. 对于**Host-only**：利用Vmnet1和真实机进行通信   ，  不能上网0
      对于NAT和Hostonly 只能和真实机进行通信而不能和局域网内的其他设备通信，桥接可以和其他计算机通信
2. 对于拍摄快照，这一点很好，当虚拟机玩蹦时可以点击扳手按钮回到以前创建快照时的状态
3. 对于虚拟机-管理-克隆选项 可以选择克隆方式 可以创建一个链接克隆（原文件没了克隆文件也受到影响） 或者一个完整克隆（原文件删了，克隆文件可以使用）









## 三、Centos安装







## 四、Linux学习

![image-20210323175147268](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210323175147268.png)

var 里 有log文件夹

home所有用户的家目录

bin可执行文件

lib头文件



含义解释：

![image-20210323180641350](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20210323180641350.png)

root是用户， itcast01是主机名   ~代表当前所处于的目录，如果是root用户，那么 ~代表/root目录，如果是普通用户，一般会在/home/username

![image-20211023115115051](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211023115115051.png)

![image-20211023115130936](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211023115130936.png)







> **记忆：**
> **/斜杠： 除、注释、URL、Linux文件路径分隔、Linux根路径、Vim命令行模式**
>
> **\反斜杠：windows文件路径、转义**





---

### 命令

ls    ， ls -a， ls -l = ll，



cd ， cd - 返回上一次所在的目录  ， cd /   ,  cd ~



mkdir aaa, mkdir -p aaa/bbb



cat 文件名、 more 文件名  按q退出 按空格一帧 回车一行



### 密码忘记

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211023114104128.png" alt="image-20211023114104128" style="zoom:50%;" />



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211023114116517.png" alt="image-20211023114116517" style="zoom:50%;" />







## 五、有关配置文件

**tmux**的配置文件是 `.tmux.conf`   放在云端的~家目录下。内容在配置文件夹里。

**vim**的配置文件是 `.vimrc`  放在云端的~家目录下。内容在配置文件夹里。

**bash**的配置文件：.bashrc 放在云端的~家目录下。里面有PATH等内容，在启动bash时会自动执行该文件。

**bash的历史命令**文件是` .bash_history` 在云端的~目录下。`history`命令执行的是当前的1000条命令，退出bash后，才会把最新的命令更新到`.bash_histroy`中

**git**的配置文件是`.gitconfig`,在云端的~目录下。存的是username、email、alias快捷键等

**ssh**的配置文件夹在`.ssh`目录下, 里面的config文件存的是服务器的别名以及其对应的HostName和User。以及第一次访问别的服务器时所保存的信息，在known_hosts里。id_rsa以及.pub存的ssh-keygen生成的公钥和秘钥



# AcWing Linux

## 1、常用文件管理命令

### 1、文件目录结构

![image-20211023154811782](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211023154811782.png)

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211023161800253.png" alt="image-20211023161800253" style="zoom: 33%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211025110525691.png" alt="image-20211025110525691" style="zoom:50%;" />



### 2、常用命令

#### 其它

ctrl+u  清空一行、

ctrl + c 终止执行 、

Tab补全 、

Tab（两次） 提示补全

复制粘贴
在功能模式下：
复制：fn + ctrl + insert
粘贴：fn + shitf + insert

ps aux 当前打开的所有进程

top 当前系统运行的所有进程         M可以按照所占内存排序

kill -9 PID 可以杀死进程id为PID的进程

date 获取时间

---

#### **ls**     

语法

```
 ls [-alrtAFR] [name...]
```

-a -A 		显示隐藏的
-al = ll	
-l				显示详细信息
-h				人性化显示

---

#### **pwd**

---

#### **cd**

跳到 /usr/bin/ :

```
cd /usr/bin
```

跳到自己的 home 目录 :

```
cd ~   等价于 cd
```

跳到目前目录的上上两层 :

```
cd ../..
```

返回上一层 cd..
返回上一个 cd -             注意cd -只允许两个文件夹，不能多个

---

#### **cp**

语法

```
cp [options] source dest
```

或

```
cp [options] source... directory
```



**Linux 将一个文件夹的所有内容拷贝到另外一个文件夹**

cp 命令使用 **-r** 参数可以将 packageA 下的所有文件拷贝到 packageB 中：

```
cp -r /home/packageA/* /home/packageB/
```

将一个文件夹复制到另一个文件夹下，以下实例 packageA 文件会拷贝到 packageB 中：

```
cp -r /home/packageA /home/packageB
```

运行命令之后 packageB 文件夹下就有 packageA 文件夹了。



把当前目录下的a文件夹里的tmp.txt复制到b文件夹里

```
cp a/tmp.txt b
```

把当前目录下的a文件夹里的tmp.txt复制到b文件夹里，并且**重命名**为tmp2.txt

```
cp a/tmp.txt b/tmp2.txt
```



把a文件夹（包含里面的内容）放到b文件夹（**已存在**）里

```
cp a b -r
```

把当前目录下的a文件夹复制到当前目录下，因为不能重名，因此我们需要有一个新的c文件夹(**之前不存在**)

```
cp a c -r
它等价于
mkdir c
cp a/* c
```

**注意区别↑**



---

#### mkdir

语法

```
mkdir [-p] dirName
```

-p 确保目录名称存在，不存在的就建一个。

可以一次创建多个

```
mrdir a b c d
```

创建名为“wc nb”的文件夹,使用转义字符

```
mkdir wc\ nb
```

在~目录下创建a目录，a目录下创建b目录，b目录创建c

```
mkdir a/b/c -p
```





---

#### **rm**

```
rm * -r //注意不会删掉隐藏文件 也即.开头的
```

```
rm a.txt b.txt
```

支持正则表达式

```
rm *.txt
```

-f强制删除一些不能删除的文件

- -f 即使原档案属性设为唯读，亦直接删除，无需逐一确认。
- -r 将目录及以下之档案亦逐一删除。

> **删除文件夹，复制文件夹都要加-r  表示递归**



删除名为dir_a、dir_b、dir_c的文件夹,    `rm dir_* -r`



---

#### mv

语法

```
mv [options] source dest
mv [options] source... directory
```

| 命令格式                                          | 运行结果                                                     |
| :------------------------------------------------ | :----------------------------------------------------------- |
| `mv source_file(文件) dest_file(文件)`            | 将源文件名 source_file 改为目标文件名 dest_file              |
| `mv source_file(文件) dest_directory(目录)`       | 将文件 source_file 移动到目标目录 dest_directory 中          |
| `mv source_directory(目录) dest_directory(目录) ` | 目录名 dest_directory 已存在，将 source_directory **移动到**目录名 dest_directory 中；<br />目录名 dest_directory 不存在则 source_directory **改名为**目录名 dest_directory |
| `mv source_directory(目录) dest_file(文件)`       | 出错                                                         |



mv到本地就是重命名

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211025101811819.png" alt="image-20211025101811819" style="zoom:50%;" />

---

#### touch









---

#### cat

语法格式

```
cat [-AbeEnstTuv] [--help] [--version] fileName
```

**-n 或 --number**：由 1 开始对所有输出的行数编号。

**-b 或 --number-nonblank**：和 -n 相似，只不过对于空白行不编号。



---

#### **find**







---

#### **history**







## 2、 tmux 和 vim

### 1、tmux

功能：
    (1) 分屏。
    (2) 允许断开Terminal连接后，继续运行进程。
结构：
    一个tmux可以包含多个session，一个session可以包含多个window，一个window可以包含多个pane。
    实例：
        tmux:
            session 0:
                window 0:
                    pane 0
                    pane 1
                    pane 2
                    ...
                window 1
                window 2
                ...
            session 1
            session 2
            ...



操作：
    (1) tmux：新建一个session，其中包含一个window，window中包含一个pane，pane里打开了一个shell对话框。
    (2) 按下Ctrl + a后手指松开，然后按%：将当前pane左右平分成两个pane。
    (3) 按下Ctrl + a后手指松开，然后按"（注意是双引号"）：将当前pane上下平分成两个pane。
    (4) Ctrl + d：关闭当前pane；如果当前window的所有pane均已关闭，则自动关闭window；如果当前session的所有window均已关闭，则自动关闭session。
    (5) 鼠标点击可以选pane。
    (6) 按下ctrl + a后手指松开，然后按方向键：选择相邻的pane。
    (7) 鼠标拖动pane之间的分割线，可以调整分割线的位置。
    (8) 按住ctrl + a的同时按方向键，可以调整pane之间分割线的位置。
    (9) 按下ctrl + a后手指松开，然后按z：将当前pane全屏/取消全屏。
    (10) **按下ctrl + a后手指松开，然后按d：挂起当前session。**
    (11) tmux a：打开之前挂起的session。
    (12) 按下ctrl + a后手指松开，然后按s：选择其它session。
        方向键 —— 上：选择上一项 session/window/pane
        方向键 —— 下：选择下一项 session/window/pane
        方向键 —— 右：展开当前项 session/window
        方向键 —— 左：闭合当前项 session/window
    (13) 按下Ctrl + a后手指松开，然后按c：*在当前session中创建一个新的window。*
    (14) 按下Ctrl + a后手指松开，然后按w：选择其他window，操作方法与(12)完全相同。
    (15) 按下Ctrl + a后手指松开，然后按PageUp：翻阅当前pane内的内容。
    (16) 鼠标滚轮：翻阅当前pane内的内容。
    (17) 在tmux中选中文本时，需要按住shift键。（仅支持Windows和Linux，不支持Mac，不过该操作并不是必须的，因此影响不大）
    (18) tmux中复制/粘贴文本的通用方式：
        (1) 按下Ctrl + a后松开手指，然后按[
        (2) 用鼠标选中文本，被选中的文本会被自动复制到tmux的剪贴板
        (3) 按下Ctrl + a后松开手指，然后按]，会将剪贴板中的内容粘贴到光标处

```
1、创建session
tmux

2、创建panel
Ctrl a + % 左右   				Ctrl + a + " 上下
Ctrl d  关闭

3、选择
Ctrl  a + 方向 选择框
Ctrl  a 方向（不松开） 移动边框

4、全屏
Ctrl a + z 全屏

5、挂起
Ctrl a + d 挂起
tmux a 或 tmux attach 恢复挂起

6、查看所有
Ctrl a + s
Ctrl a + w

7、创建window
Ctrl a + c  在当前session中创建一个新的window。

8、创建小结
创建session 要 ctrl a + d挂起后，然后输入tmux再创建
创建window ctrl a + c
创建panel 直接ctrl a + % "

9、其他
在tmux中选中文本时，需要按住shift键

tmux中复制/粘贴文本的通用方式：
        (1) 按下Ctrl + a后松开手指，然后按[
        (2) 用鼠标选中文本，被选中的文本会被自动复制到tmux的剪贴板
        (3) 按下Ctrl + a后松开手指，然后按]，会将剪贴板中的内容粘贴到光标处
       
```





y总推荐做法：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211026095059371.png" alt="image-20211026095059371" style="zoom:50%;" />

也即Ctrl a + c用不到，若需要多开，直接Ctrl a + D，再tmux





### 2、vim

```
功能：
    (1) 命令行模式下的文本编辑器。
    (2) 根据文件扩展名自动判别编程语言。支持代码缩进、代码高亮等功能。
    (3) 使用方式：vim filename
        如果已有该文件，则打开它。
        如果没有该文件，则打开个一个新的文件，并命名为filename
模式：
    (1) 一般命令模式（默认模式）
        默认模式。命令输入方式：类似于打游戏放技能，按不同字符，即可进行不同操作。可以复制、粘贴、删除文本等。
    (2) 编辑模式
        在一般命令模式里按下i，会进入编辑模式。
        按下ESC会退出编辑模式，返回到一般命令模式。
    (3) 命令行模式
        在一般命令模式里按下:/?三个字母中的任意一个，会进入命令行模式。命令行在最下面。
        可以查找、替换、保存、退出、配置编辑器等。
操作：
*    (1) i：进入编辑模式
*    (2) ESC：进入一般命令模式
    (3) h 或 左箭头键：光标向左移动一个字符
    (4) j 或 向下箭头：光标向下移动一个字符
    (5) k 或 向上箭头：光标向上移动一个字符
    (6) l 或 向右箭头：光标向右移动一个字符
*    (7) n<Space>：n表示数字，按下数字后再按空格，光标会向右移动这一行的n个字符
*    (8) 0 或 功能键[Home]：光标移动到本行开头
*    (9) $ 或 功能键[End]：光标移动到本行末尾             vim的光标会停在最后一个字符的前面
*    (10) G：光标移动到最后一行
*    (11) :n 或 nG：n为数字，光标移动到第n行
*    (12) gg：光标移动到第一行，相当于1G
*    (13) n<Enter>：n为数字，光标向下移动n行
*    (14) /word：向光标之下寻找第一个值为word的字符串。
*    (15) ?word：向光标之上寻找第一个值为word的字符串。
*    (16) n：重复前一个查找操作
*    (17) N：反向重复前一个查找操作
*    (18) :n1,n2s/word1/word2/g：n1与n2为数字，在第n1行与n2行之间寻找word1这个字符串，并将该字符串替换为word2
*    (19) :1,$s/word1/word2/g：将全文的word1替换为word2
*    (20) :1,$s/word1/word2/gc：将全文的word1替换为word2，且在替换前要求用户确认。
    (21) v：选中文本    取消选中状态：按俩下ESC
    (22) d：删除选中的文本
*    (23) dd: 删除当前行    (剪切)
    (24) y：复制选中的文本
*    (25) yy: 复制当前行
*    (26) p: 将复制的数据在光标的下一行/下一个位置粘贴
**    (27) u：撤销
*    (28) Ctrl + r：取消撤销
*    (29) 大于号 >：将选中的文本整体向右缩进一次
    (30) 小于号 <：将选中的文本整体向左缩进一次
    (31) :w 保存
    (32) :w! 强制保存
    (33) :q 退出
    (34) :q! 强制退出
    (35) :wq 保存并退出
    (36) :set paste 设置成粘贴模式，取消代码自动缩进    用于将外界代码复制到Ubuntu里的情况
    (37) :set nopaste 取消粘贴模式，开启代码自动缩进
*    (38) :set nu 显示行号
*    (39) :set nonu 隐藏行号
*    (40) gg=G：将全文代码格式化
    (41) :noh 关闭查找关键词高亮
*    (42) Ctrl + q：当vim卡死时，可以取消当前正在执行的命令
异常处理：
    每次用vim编辑文件时，会自动创建一个.filename.swp的临时文件。
    如果打开某个文件时，该文件的swp文件已存在，则会报错。此时解决办法有两种：
        (1) 找到正在打开该文件的程序，并退出
        (2) 直接删掉该swp文件即可
*    (43) = 格式化选中区域 
*    	==格式化选中的行
    	
小结： 对于d 和 =都可以先v选中再按d或= ， 也可以先按然后再选区域：格式为 `d或= 加 定位符 ` 前面可以加前置的定位符  
组合技能：ggdG 删除所有内容  //gg回到首行，
		gg=G 格式化所有内容
		
注意：Linux系统自带的剪切板 和 Vim自带的剪切板 不一样 
```



## 3、Shell

### 0、其他

>  **Bash的思路：**
>
> 1、 Bash也是一种新的语言，对于变量定义，我们可以直接写；
>
> 2、对于变量使用，我们要加\$；
>
> 3、对于表达式求值，我们要用expr,但是要注意expr计算后的表达式的值输出在stdout里，我们要用\$()来得到值，才能进一步应用，或者用\`\`来获得（截获stdout），此外就是如果参与表达式的变量是数字的话，不用加引号。如果是字符串的话，最好加上" "，防止字符串包含空格  如
>
> ```bash
> `expr length "$str"` 等价于 ${#str}
> `expr $a + $b` 
> ```
>
> 4、当我们需要分支、循环语句时，这就涉及到了判断，而判断就要用test关键字，它是返回值
>
> 5、返回值相当于return 、stdout就是cout
>

字符串总结：

1. 单引号是原样，不做转义操作，是什么就是什么，也即变量不会被value替换。
2. 双引号，进行本地转义，变量会被实际的value替换

==shell在执行命令时，会把字符串先处理一遍==，只有加上 \ 转义，才能告诉shell，你别给我转义







### 1、[概论](https://www.acwing.com/blog/content/9688/)

**概论**
<u>shell是我们通过命令行与操作系统沟通的语言。</u>

<u>shell脚本可以直接在命令行中执行，也可以将一套逻辑组织成一个文件，方便复用。</u>
<u>AC Terminal中的命令行可以看成是一个“shell脚本在逐行执行”。</u>

<u>Linux中常见的shell脚本有很多种，常见的有：</u>

- Bourne Shell(/usr/bin/sh或/bin/sh)
- **Bourne Again Shell(/bin/bash)**
- C Shell(/usr/bin/csh)
- K Shell(/usr/bin/ksh)
- zsh
- …

Linux系统中<u>一般默认使用bash</u>，所以接下来讲解bash中的语法。
文件开头需要写#! /bin/bash，指明bash为脚本解释器。

**学习技巧**

不要死记硬背，遇到含糊不清的地方，可以在AC Terminal里实际运行一遍。



**脚本示例**

新建一个`test.sh`文件，内容如下：

```bash
#! /bin/bash
echo "Hello World!"
```



**运行方式**

作为可执行文件

```bash
chmod +x test.sh
./test.sh
```

```bash
acs@9e0ebfcd82d7:~$ chmod +x test.sh  # 使脚本具有可执行权限
acs@9e0ebfcd82d7:~$ ./test.sh  # 当前路径下执行
Hello World!  # 脚本输出
acs@9e0ebfcd82d7:~$ /home/acs/test.sh  # 绝对路径下执行
Hello World!  # 脚本输出
acs@9e0ebfcd82d7:~$ ~/test.sh  # 家目录路径下执行
Hello World!  # 脚本输出
```

用解释器执行

```bash
acs@9e0ebfcd82d7:~$ bash test.sh
Hello World!  # 脚本输出
```



echo 

```bash
echo wangchen
echo "wangchen"
name=nb
echo $name
echo ${name}  #加{}方便识别边界
echo "wangchen ${name}"
```





### 2、[注释](https://www.acwing.com/blog/content/9710/)

**单行注释**

每行中#之后的内容均是注释。

```bash
#这是一行注释
echo 'Hello World'  #  这也是注释
```



**多行注释**

格式：

```bash
:<<EOF
第一行注释
第二行注释
第三行注释
EOF
```

其中EOF可以换成其它任意字符串。例如：

```bash
:<<abc
第一行注释
第二行注释
第三行注释
abc

:<<!
第一行注释
第二行注释
第三行注释
!
```



### 3、[变量](https://www.acwing.com/blog/content/9689/)

==注意我们在使用变量时，为了鲁棒性，最好这样写`"${name}"`==，加引号可以防止变量带有空格,加{}有利于识别

**定义变量**

定义变量，不需要加$符号，例如：

```bash
name1='yxc'  # 单引号定义字符串
name2="yxc"  # 双引号定义字符串
name3=yxc    # 也可以不加引号，同样表示字符串
#不能有空格
```

**使用变量**

使用变量，需要加上``$符号，或者${}``符号。花括号是可选的，主要为了帮助解释器识别变量边界。

```bash
name=yxc
echo $name  # 输出yxc
echo ${name}  # 输出yxc
echo ${name}acwing  # 输出yxcacwing
```



**只读变量**

使用readonly或者declare可以将变量变为只读。

```bash
name=yxc
readonly name
declare -r name  # 两种写法均可

name=abc  # 会报错，因为此时name只读
```

**删除变量**

`unset`可以删除变量。

```bash
name=yxc
unset name
echo $name  # 输出空行
```

**变量类型**

1. 自定义变量（局部变量）
   子进程不能访问的变量
2. 环境变量（全局变量）
   子进程可以访问的变量

自定义变量改成环境变量：

```bash
acs@9e0ebfcd82d7:~$ name=yxc  # 定义变量
acs@9e0ebfcd82d7:~$ export name  # 第一种方法
acs@9e0ebfcd82d7:~$ declare -x name  # 第二种方法
```


环境变量改为自定义变量：

```bash
acs@9e0ebfcd82d7:~$ export name=yxc  # 定义环境变量
acs@9e0ebfcd82d7:~$ declare +x name  # 改为自定义变量
```



**字符串**

字符串可以用单引号，也可以用双引号，也可以不用引号。

单引号与双引号的区别：

- 单引号中的内容会原样输出，不会执行、不会取变量；
- 双引号中的内容可以执行、可以取变量；

```bash
name=yxc  # 不用引号
echo 'hello, $name \"hh\"'  # 单引号字符串，输出 hello, $name \"hh\"
echo "hello, $name \"hh\""  # 双引号字符串，输出 hello, yxc "hh"
```



获取字符串长度

```bash
name="yxc"
echo ${#name}  # 输出3
```

提取子串

```bash
name="hello, yxc"
echo ${name:0:5}  # 提取从0开始的5个字符
```





注意=号两边不能有空格

```bash
name1='yxc'  # 单引号定义字符串
name2="yxc"  # 双引号定义字符串
name3=yxc    # 也可以不加引号，同样表示字符串

```

定义变量的时候都是字符串。可以根据情况转换



变量可以重名，这样就覆盖了

```bash
name=wangchen
name=wc
```



直接echo不存在的变量，会输出空行

```bash
echo ${nothing}
```







字符串可以用单引号，也可以用双引号，也可以不用引号。

单引号与双引号的区别：

单引号中的内容会原样输出，不会执行、不会取变量；
双引号中的内容可以执行、可以取变量；

```bash
name=yxc  # 不用引号
echo 'hello, $name \"hh\"'  # 单引号字符串，输出 hello, $name \"hh\"
echo "hello, $name \"hh\""  # 双引号字符串，输出 hello, yxc "hh"             双引号等价于无引号
```

获取字符串长度

```bash
name="yxc"
echo ${#name}  # 输出3
```


提取子串

```bash
name="hello, yxc"
echo ${name:0:5}  # 提取从0开始的5个字符
```





### 4、[默认变量](https://www.acwing.com/blog/content/9691/)



注意退出状态和stdout不一样，一个是退出的返回值，一个是标准输出

```bash
$?				上一条命令的退出状态（注意不是stdout，而是exit code）。0表示正常退出，其他值表示错误
$(command)		返回command这条命令的stdout（可嵌套）
`command`		返回command这条命令的stdout（不可嵌套）
```

例如

```bash
ls
$?     		#此时输出了0，是ls函数的返回值
${ls}		#此时输出文件内容，是ls的stdout值
`ls`		#等价于上面
```



通常 expr要搭配 $( ) 或 \`  \`使用



### 5、[数组](https://www.acwing.com/blog/content/9701/)

可以跳着赋值

### 6、[expr命令](https://www.acwing.com/blog/content/9702/)

> **用于求表达式的值**

类比：在C++里，我们想要得到的一个表达式的值的时候（比如算数表达式、逻辑表达式），我们直接使用算数符号和逻辑符号就行了。但是在bash中，不能这样，我们要借助expr关键字来计算算数表达式、逻辑表达式、字符串表达式等。expr会将结果输出到stdout中，我们可以借助${}或者``来获得值，然后就可以用了



求逻辑表达式 用 单引号''扩住符号

### 7、[read命令](https://www.acwing.com/blog/content/9712/)

```bash
read -p "Please input your name: " -t 30 name
```



### 8、[echo命令](https://www.acwing.com/blog/content/9703/)



### 9、[printf命令](https://www.acwing.com/blog/content/9711/)







---

### 10、[test命令与判断符号](https://www.acwing.com/blog/content/9704/)

test命令与判断符号[]

> **用于判断**

&&和||是bash自带的，&和|是expr自带的



利用短路特性可以实现if else的操作



！可以加在[]里，也可以在[]外



---

### 11、[判断语句](https://www.acwing.com/blog/content/9705/)



#### 1、单层if

命令格式：

```bash
if condition
then
    语句1
    语句2
    ...
fi
```

示例：

```bash 
a=3
b=4

if [ "$a" -lt "$b" ] && [ "$a" -gt 2 ]
then
    echo ${a}在范围内
fi
```

输出结果：

3在范围内

#### 2、单层if-else

命令格式

```bash
if condition
then
    语句1
    语句2
    ...
else
    语句1
    语句2
    ...
fi
```

示例：

```bash
a=3
b=4

if ! [ "$a" -lt "$b" ]
then
    echo ${a}不小于${b}
else
    echo ${a}小于${b}
fi
```


输出结果：

3小于4

#### 3、多层if-elif-elif-else

命令格式

```bash
if condition
then
    语句1
    语句2
    ...
elif condition
then
    语句1
    语句2
    ...
elif condition
then
    语句1
    语句2
else
    语句1
    语句2
    ...
fi
```

示例：

```bash
a=4

if [ $a -eq 1 ]
then
    echo ${a}等于1
elif [ $a -eq 2 ]
then
    echo ${a}等于2
elif [ $a -eq 3 ]
then
    echo ${a}等于3
else
    echo 其他
fi
```

输出结果：

其他

#### 4、case…esac形式

类似于C/C++中的switch语句。

命令格式

```bash
case $变量名称 in
    值1)
        语句1
        语句2
        ...
        ;;  # 类似于C/C++中的break
    值2)
        语句1
        语句2
        ...
        ;;
    *)  # 类似于C/C++中的default
        语句1
        语句2
        ...
        ;;
esac
```

示例：

```bash
a=4

case $a in
    1)
        echo ${a}等于1
        ;;  
    2)
        echo ${a}等于2
        ;;  
    3)                                                
        echo ${a}等于3
        ;;  
    *)
        echo 其他
        ;;  
esac
```

输出结果：

其他





### 12、[循环语句](https://www.acwing.com/blog/content/9706/)



break即使在case里，也会跳出最近的一层for循环，而不会跳出case

### 13、[函数](https://www.acwing.com/blog/content/9707/)

`bash`中的函数类似于``C/C++``中的函数，但`return`的返回值与`C/C++`不同，返回的是exit code，取值为0-255，0表示正常结束。

**如果想获取函数的输出结果，可以通过echo输出到stdout中，然后通过$(function_name)来获取stdout中的结果。**

函数的return值可以通过$?来获取。

命令格式：

```bash
[function] func_name() {  # function关键字可以省略
    语句1
    语句2
    ...
}
```



**不获取 return值和stdout值**

示例

```bash
func() {
    name=yxc
    echo "Hello $name"
}

func
```

输出结果：

```bash
Hello yxc
```



**获取 return值和stdout值**

不写return时，默认return 0。

示例

```bash
func() {
    name=yxc
    echo "Hello $name"

	return 123
}

output=$(func)
ret=$?

echo "output = $output"
echo "return = $ret"
```

输出结果：

````bash
output = Hello yxc
return = 123
````


**函数的输入参数**
在函数内，`$1`表示第一个输入参数，`$2`表示第二个输入参数，依此类推。

注意：函数内的`$0`仍然是文件名，而不是函数名。

示例：

```bash
func() {  # 递归计算 $1 + ($1 - 1) + ($1 - 2) + ... + 0
    word=""
    while [ "${word}" != 'y' ] && [ "${word}" != 'n' ]
    do
        read -p "要进入func($1)函数吗？请输入y/n：" word
    done

if [ "$word" == 'n' ]
then
    echo 0
    return 0
fi  

if [ $1 -le 0 ] 
then
    echo 0
    return 0
fi  

sum=$(func $(expr $1 - 1))
echo $(expr $sum + $1)

}

echo $(func 10)
```

输出结果：

```bash
55
```


**函数内的局部变量**
可以在函数内定义局部变量，作用范围仅在当前函数内。

可以在递归函数中定义局部变量。

命令格式：

```bash
local 变量名=变量值
```


例如：

```bash
#! /bin/bash

func() {
    local name=yxc
    echo $name
}
func

echo $name
```

输出结果：

```bash
yxc
```

第一行为函数内的name变量，第二行为函数外调用name变量，会发现此时该变量不存在。





### 14、[exit命令](https://www.acwing.com/blog/content/9731/)





### 15、[文件重定向](https://www.acwing.com/blog/content/9708/)

每个进程默认打开3个文件描述符：

- stdin标准输入，从命令行读取数据，文件描述符为0
- stdout标准输出，向命令行输出数据，文件描述符为1
- stderr标准错误输出，向命令行输出数据，文件描述符为2

可以用文件重定向将这三个文件重定向到其他文件中。

---

#### **重定向命令列表**

| 命令             | 说明                                  |
| ---------------- | ------------------------------------- |
| command > file   | 将stdout重定向到file中                |
| command < file   | 将stdin重定向到file中                 |
| command >> file  | 将stdout以追加方式重定向到file中      |
| command n> file  | 将文件描述符n重定向到file中           |
| command n>> file | 将文件描述符n以追加方式重定向到file中 |

==说明：文件的重定向，无所谓前后。它的一般形式是 `>或< + 文件名`==
	

```bash
	>或< 加上 文件名
```



#### **输入和输出重定向**

```bash
echo -e "Hello \c" > output.txt  # 将stdout重定向到output.txt中
echo "World" >> output.txt  # 将字符串追加到output.txt中

read str < output.txt  # 从output.txt中读取字符串

echo $str  # 输出结果：Hello World
```



​	

#### 一个例子	

test.sh如下

```bash
#! /bin/bash
read a
read b
echo $(expr "$a" + "$b")
```

可见默认情况下：它需要从stdin读入，然后输出到stdout



我们可以采用如下的写法：

1.把stdin重定向到input.txt

2.把stdout重定向到output.txt

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211031182039862.png" alt="image-20211031182039862" style="zoom:50%;" />

```bash
./test.sh < input.txt > output.txt
./test.sh > output.txt < input.txt
```

这两种写法均可,因为文件的重定向的命令格式就是 

```bash
>或< 加上 文件名
```







### 16、[引入外部脚本](https://www.acwing.com/blog/content/9709/)

语法格式：

```bash
. filename  # 注意点和文件名之间有一个空格

或

source filename

# 当引入的文件和本文件不在同一目录下时，可以使用路径
```

原理就是**直接展开**





![image-20211031225946982](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211031225946982.png)

加入dir4写错了，可能造成$为空，然后会删除根目录，所以，建议把/写成dir4那种形式





### 17、例子

把C++里的

```C++
int a[100];
a[0] = 1;
a[1] = 1;
for(int i = 2; i <= n; i++)
	a[i] = a[i - 1] + a[i - 2]
```

翻译成bash

```bash
a[0]=1;
a[1]=1;
for(i = 2; i <= n; i++)
do
	x=`expr $i - 1`
	y=`expr $i - 2`
	a[$i]=`expr ${a[$x]} + ${a[$y]}`
done
```





## 4、ssh

本地终端、云端终端

ssh默认端口是22
$$
云服务器
\begin{cases}
hostname&域名\ 或\ 服务器\\
username&用户名\\
password&密码
\end{cases}
$$

$$
我未来租服务器后初始给定：
\begin{cases}
hostname\\
给root用户\\
password
\end{cases}
\\后续可以自己再分配一些用户
$$



ssh登录：从一个服务器登录到另一个服务器上

scp：将本地和服务器的文件可以进行传输



也可以使用如下命令一键添加公钥：

ssh-copy-id myserver1（本地terminal执行，还要输入密码）





```bash
ssh user@hostname command
```

会将服务器端执行的command的标准输出stdout，重定向到当前的终端里





```bash
scp -r ~/tmp myserver:/home/acs/
```

注意-r放在前面！！！



复制文件夹：

```bash
scp -r ~/tmp myserver:/home/acs/
```


将本地家目录中的tmp文件夹复制到myserver服务器中的/home/acs/目录下。



```bash
scp -r ~/tmp myserver:homework/
```

将本地家目录中的tmp文件夹复制到myserver服务器中的~/homework/目录下。 因此myserver中有用户的信息





上述我们说的都是 本地服务器<-> 其他远程服务器交换文件，我们想两个远程服务器传输文件时，可以通过本地服务器来传(y总建议)，当然也可以两个远程服务器直接传，但是需要完整的授权，比较麻烦。





```bash
scp -P 22 source1 source2 destination
```


注意： scp的-r -P等参数尽量加在source和destination之前。 是大写P





### 一个毛坯服务器怎么改造：

1. 下载tmux，下载vim
2. 在terminal里，~/.ssh/文件夹下的config文件添加自己的服务器ip以及用户名
3. 通过ssh-keygen命令生成公钥和私钥，把公钥复制到服务器中（可以直接复制，也可以使用命令）
4. 然后就可以直接登录服务区了。
5. 把y总的旷世配置文件scp进自己的服务器里，也即.vimrc和.tmux.conf





thrift

RPC（Remote Procedure Call）远程过程调用，简单的理解是一个节点请求另一个节点提供的服务





我们可以在本地服务器使用tmux命令，每个窗口ssh到另外一个服务器





作业讲解:

进入homework_4文件夹，编写脚本remote_mkdir.sh和remote_rmdir.sh，要求：
    [1] 在myserver服务器上创建并清空文件夹：~/homework/lesson_4/homework_4/
    [2] 本地目录下仅包含remote_mkdir.sh和remote_rmdir.sh
    [3] remote_mkdir.sh和remote_rmdir.sh具有可执行权限
    [4] remote_mkdir.sh接收一个传入参数。格式为 ./remote_mkdir.sh directory_name
        该操作可以在myserver服务器上的~/homework/lesson_4/homework_4/目录下，创建一个名为directory_name的文件夹
    [5] remote_rmdir.sh接收一个传入传输。格式为 ./remote_rmdir.sh directory_name
        该操作可以将myserver服务器上的~/homework/lesson_4/homework_4/目录下的名为directory_name的文件夹删掉。
    [6] 注意：传入的文件参数可能包含空格。两个脚本均不需要判断传入参数的合法性。



错误写法：

```bash
ssh myserver mkdir homework/lesson_4/homework_4/$1 #文件夹的名称可能带有空格，因此需要加""，这样就会在远程服务器上创建两个文件夹

ssh myserver mkdir homework/lesson_4/homework_4/"$1" #还不行，因此本地解析的时候会去掉""，也即服务器端接收的不包含""，然后把参数搬到$1处。因此会出现和上面一样的结果，没有任何区别。
```



正确写法：

```bash
ssh myserver mkdir homework/lesson_4/homework_4/\"$1\" #这样就可以把双引号传到服务器端了
ssh myserver mkdir "homework/lesson_4/homework_4/\"$1\"" #等价
```



字符串总结：

1. 单引号是原样，不做转义操作，是什么就是什么，也即变量不会被value替换。
2. 双引号，进行本地转义，变量会被实际的value替换

==shell在执行命令时，会把字符串先处理一遍==，只有加上 \ 转义，才能告诉shell，你别给我转义





当第一次ssh登录到远程服务器的时候，会提示远程服务器的ip地址我本机没有见过，这时需要输入yes，来信任我ssh所登录的远程服务器。





## 5、git

### 一、基本概念

- 工作区：仓库的目录。工作区是独立于各个分支的。  在本地看git的时候，其实就是一个文件夹，工作区就是当前的工作目录、工作文件夹。不管在哪一个分支，工作区都是同一个，不要以为每一个分支都有一个工作区。
- 暂存区：数据暂时存放的区域，类似于工作区写入版本库前的缓存区。暂存区是独立于各个分支的。是版本库和工作区的桥梁。每一次将工作区存到版本库的某一节点时，不会直接存，会先存在暂存区里。然后把暂存区的内容放到版本库里，
- 版本库：存放所有已经提交到本地仓库的代码版本。将所有的版本用一颗树的形式存下来。
- 版本结构：树结构，树中每个节点代表一个代码版本。



**工作区 -> 暂存区(缓冲区) -> 版本库**

每次commit就把暂存区放到版本库，从而实现暂存区的清空操作

### 二、命令

#### 1、git diff

```bash
git diff 文件名 #查看当前文件与缓冲区的区别，也即工作区的文件与缓冲区的文件的区别
git diff <$id1> <$id2> # 比较两次提交之间的差异 
git diff <branch1>..<branch2> # 在两个分支之间比较
git diff --staged # 比较暂存区和版本库差异
```



#### 2、暂存区管理

```bash
git rm --cached 文件名 	  # 将文件从仓库索引目录中删掉,不会再管理该文件
git restore --staged 文件名 	#把暂存区的文件从暂存区撤出，也即撤销了add操作
git restore 文件名 / git checkout 文件名#将XX文件尚未加入暂存区的修改全部撤销,也即将工作区的代码回滚成暂存区里的版本，如果暂存区为空的话，则工作区的内容回滚到HEAD所指版本的样子。

#每次commit都是有意义的
```







#### 3、切换版本

git reset --hard HEAD^ 或 git reset --hard HEAD~：将代码库回滚到上一个版本
git reset --hard HEAD^^：往上回滚两次，以此类推
git reset --hard HEAD~100：往上回滚100个版本
git reset --hard 版本号：回滚到某一特定版本

git reflog：查看HEAD指针的移动历史（包括被回滚的版本） 可以获得每个版本的编号(也即是每次commit的哈希值的前7位)

注意：回滚并不删除新的版本，只是单纯改变HEAD指向





**标签**

```bash
git tag #查看标签列表
git tag v1.0 #给当前状态（HEAD所指）做标记
```









git log打印从空节点到当前节点的路径（HEAD指向的点)，从下往上看











可以只add一部分修改过的文件后，就立马commit



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211113204253920.png" alt="image-20211113204253920" style="zoom:50%;" />

本地跟云端节点逐一对应



### 三、分支以及合并



分支是可以从任意结点出发创建一个新的分支，注意创建分支是不会创建节点的，commit才会产生新的节点。

**分支跟暂存区是独立的，暂存区跟分支没有任何关系，不管在master分支还是在dev分支都共用一个暂存区，commit的时候会看当前在哪一个分支（HEAD所指)，然后将暂存区的内容加到后面，不管在哪一个分支都共用一个暂存区和工作区**



checkout切换分支操作包含两个步骤，把分支切换到某分支，然后把HEAD指向该分支的头结点(最新版本结点)



merge操作是fast-forward，因此它实际上是把分支的头变成了master的头，并HEAD指向它 。**将某一个分支的最新的版本（头结点），合并到当前分支的当前节点上**。具体看我下面的实验



---

#### 如果没冲突，则把从分支处的一串直接接过来

![image-20211114122842024](C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211114122842024.png)

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211114122854243.png" alt="image-20211114122854243" style="zoom:50%;" />



---

#### master分支已修改的情况，但是没有冲突的情况：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211114123706118.png" alt="image-20211114123706118" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211114123725443.png" alt="image-20211114123725443" style="zoom: 80%;" />



---

#### master分支已修改的情况，但是没有冲突的情况：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211114124728621.png" alt="image-20211114124728621" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211114124751412.png" alt="image-20211114124751412" style="zoom: 67%;" />



---

#### master分支已修改，并出现冲突（修改同一文件）

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211114153007579.png" alt="image-20211114153007579" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211114153024519.png" alt="image-20211114153024519" style="zoom:50%;" />



---





### 四、云端

发现上面用了这个-u参数，也没作解释，特意搜索了下这个-u的用法，加了参数-u后，以后即可直接用git push 代替git push origin master

```
git push -u origin master 
```

也可以不用git push，而用完整版 git push origin 分支名。当在本地dev分支时，而云端没dev分支，可以用git push origin dev ，这时云端会自动创建dev分支并上传本地的dev分支的版本库信息。云本端的分支名字一样





### 五、几种操作

#### 1、本地分支上传到云端

当只使用git push操作时，我们可以用`git push --set-upstream origin branch_name：设置本地的branch_name分支对应远程仓库的branch_name分支`  此时云本端的分支名字一样。



云端的分支和本地的分支没有什么关系，谁删除都不影响另外一个。



如何将本地的其他分支推到云端呢？

git push 会自动将当前分支推到云端。



git push -u origin master 命令后 在master分支只需要使用git push就能推到云端了

当有新分支dev时，通过git push --set-upstream origin branch_name，可以在远程建立dev分支，以后在dev分支直接git push就能推了





#### 2、将云端分支pull到本地

**方法1**

首先在本地 new 一个 branch，然后通过

```zsh
git branch --set-upstream-to=origin/branch_name1 branch_name2
```

将远程的branch_name1分支与本地的branch_name2分支对应，然后pull一下



**方法2**

```bash
git checkout -t origin/branch_name #将远程的branch_name分支拉取到本地
```







**还可以将云端的某分支，pull（merge）到当前分支**



#### 3、一个复杂操作：

我们把云端的dev分支拉取到本地，把本地的dev和master合并后，删掉本地的dev分支和云端的dev分支，再把master分支push到云端master。

先在本地创建一个分支，通过`git branch --set-upstream-to=origin/branch_name1 branch_name2`让本地和云端的dev绑定，然后pull一下（或者直接`git checkout -t origin/branch_name`），把云的dev拉到本地，此后merge一下，通过`git branch -d dev`删本地，通过`git push -d origin branch_name`删云端，然后再在master分支下，``git push -u origin master` ，在git push，就可以了



#### 4、几个merge

git pull origin dev5， 把远程的dev5分支拉去到本地并merge。本地合并云端。

云端合并本地不太好做

本地合并本地的

云端合并云端的。还没讲：

分支：
在云端合并本地的（不太容易），在云端合并云端的，在本地合并本地的，在本地合并云端的



#### 5、stash

git stash只涉及本地，不涉及云端

```bash
git stash		#将工作区和暂存区中尚未提交的修改存入栈中
git stash apply	#将栈顶存储的修改恢复到当前分支，但不删除栈顶元素
git stash drop	#删除栈顶存储的修改
git stash pop	#将栈顶存储的修改恢复到当前分支，同时删除栈顶元素
git stash list	#查看栈中所有元素
```



#### 6、处理冲突

多人合作，云端有个dev分支，两个小伙伴都要对dev分支进行开发，可以先本地创建，然后绑定，然后pull（或者直接`git checkout -t origin/branch_name`）。这样两个小伙伴的本地都有了dev分支，他们都在上面做修改，并且A先push了，那么云端的版本就是A的版本，此后B想push的时候就会报错。解决办法：B先pull一下，把云端的代码拉下来，显然拉下来的代码跟自己的代码有冲突，因此pull之后会显示conflict，那么我们此时就要处理conflict。  

但因为大部分的时候不同人处理不同的文件，所以这种情况会比较少。







#### 7、从零把新仓库同步到云端

我在一个新的电脑上，建了一个新git仓库，怎样把仓库push到云端呢？

1. 完成本地git的创建工作（  init add commit）
2. 在新电脑上通过ssh-keygen 生成秘钥和公钥 （Linux/Mac 系统 在 ~/.ssh 下，win系统在 /c/Documents and Settings/username/.ssh 下）
3. 在网站内添加ssh公钥 （**添加ssh公钥之后，本地服务器访问云端服务器（我的账号所在的服务器）就可以不用密码访问了**）
4. 在云端新建仓库(图形化界面)
5. `git remote add origin 仓库地址`    本地仓库关联远程仓库
6. `git push origin master`    本地push到云端



### 六、其他

#### 1、图解

使用git时，心里要有两个图：1、版本库（树）和HEAD指针          2、暂存区

<img src="C:\Users\95266\Desktop\new.png" alt="new" style="zoom:60%;" />





#### 2、clone

clone一个项目前，也需要ssh公钥秘钥生成、添加那一套流程。



当第一次ssh登录到远程服务器的时候，会提示远程服务器的ip地址我本机没有见过，这时需要输入yes，来信任我ssh所登录的远程服务器。

#### 3、公钥秘钥

公钥秘钥

Linux/Mac 系统 在 ~/.ssh 下，win系统在 /c/Documents and Settings/username/.ssh 下









## 6、thrift（未看）

### 一、预备知识

#### 1、软件系统架构-微服务

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211116222935326.png" alt="image-20211116222935326" style="zoom: 50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211116222958801.png" alt="image-20211116222958801" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211116223035643.png" alt="image-20211116223035643" style="zoom:50%;" /> <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211116223124104.png" alt="image-20211116223124104" style="zoom: 25%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211116223213118.png" alt="image-20211116223213118" style="zoom:33%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211116223227194.png" alt="image-20211116223227194" style="zoom: 67%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211116223311461.png" alt="image-20211116223311461" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211116223540590.png" alt="image-20211116223540590" style="zoom:50%;" />

维基上对其定义为：一种软件开发技术- 面向服务的体系结构（SOA）架构样式的一种变体，它提倡将单一应用程序划分成一组小的服务，服务之间互相协调、互相配合，为用户提供最终价值。每个服务运行在其独立的进程中，服务与服务间采用轻量级的通信机制互相沟通（通常是基于HTTP的RESTful API）。每个服务都围绕着具体业务进行构建，并且能够独立地部署到生产环境、类生产环境等。另外，应尽量避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据上下文，选择合适的语言、工具对其进行构建。



#### 2、RPC

RPC是远程过程调用（Remote Procedure Call）的缩写形式。SAP系统RPC调用的原理其实很简单，有一些类似于三层构架的C/S系统，第三方的客户程序通过接口调用SAP内部的标准或自定义函数，获得函数返回的数据进行处理后显示或打印。

#### 3、[C语言编译过程详解](https://www.cnblogs.com/CarpenterLee/p/5994681.html)

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211117154613534.png" alt="image-20211117154613534" style="zoom:50%;" />

或者https://www.cnblogs.com/mickole/articles/3659112.html

1、编译

```bash
g++ -c main.cpp match_server/*.cpp
```

几个.cpp生成几个.o



2、连接

```bash
g++ *.o -o main -lthrift
```







### 二、

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211117084735672.png" alt="image-20211117084735672" style="zoom:50%;" />

thrift就是其中的有向边。

服务器节点进程想调用另外一个服务器节点进程就要用到thrift了。



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211117144956166.png" alt="image-20211117144956166" style="zoom:50%;" />

game节点（match的client端）、
match_system节点（match的server端、savedata的client端）





## 7、管道、环境变量与常用命令

### 1.管道

#### **概念**

管道类似于文件重定向，==**可以将前一个命令的stdout重定向到下一个命令的stdin。**==

**我的理解**

> 这是一个链式编程。将一个工作分解成几个工作步骤完成，上一个命令的stdout 通过 | 传给下一个命令的stdin。这样以来就可以得到想要的结果。因此对于命令我们要知道它的stdin要什么，stdout输出什么

也即：==将|前的命令的stdout           传给->     |后命令的stdin==

命令1| 命令2

---

#### **要点**

- 管道命令仅处理stdout，会忽略stderr。
- ==**管道右边的命令必须能接受stdin**==。 若是不能接受，则也不能用管道了
- 多个管道命令可以串联。

---

#### **与文件重定向的区别**

- 文件重定向左边为命令，右边为文件。
- 管道左右两边均为命令，左边有stdout，右边有stdin。

---

#### **举例**

统计当前目录下所有python文件的总行数，其中find、xargs、wc等命令可以参考常用命令这一节内容。

```bash
find . -name '*.py' | xargs cat | wc -l
```

解释：

```bash
1、find /path/to/directory/ -name '*.py'   #搜索某个文件路径下的所有*.py文件

2、xargs  # 将stdin中的数据用空格或回车分割成命令行参数传给命令，stdin->命令参数 。**也即把stdin的内容接到xargs后面的命令的后面!!!!**

3、比如cat命令，它接受标准输入stdin就直接输出到stdout了，若接受命令行参数，则把文件的内容展示

4、wc：统计行数、单词数、字节数。既可以从stdin中直接读入内容；也可以在命令行参数中传入文件名列表；
 -l：统计行数
 -w：统计单词数
 -c：统计字节数
 
5、标准输入 和 命令参数
```

---

#### **例子1：**

对于目录结构：<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211119152647536.png" alt="image-20211119152647536" style="zoom:67%;" />

注意所有cpp的内容都一样，且为10行（包含空行），

则：

```bash
find . -name "*.cpp" | xargs cat | wc -l  #结果是40
```

```bash
find . -name "*.cpp" | cat | wc -l #结果是4
```



#### 例子2

对于目录结构：<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211119152647536.png" alt="image-20211119152647536" style="zoom:67%;" />

注意所有cpp的内容都一样，且为10行（包含空行），

```bash
find . -name '*.cpp' | wc -l #结果是4
find . -name '*.cpp' | xargs wc -l #结果是10\n 10\n 10\n 10\n
```

结果如下所示：

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211119154204483.png" alt="image-20211119154204483" style="zoom:50%;" />

知识点：wc：统计行数、单词数、字节数。既可以从stdin中直接读入内容；也可以在命令行参数中传入文件名列表









### 2.环境变量

#### **概念**

Linux系统中会用很多环境变量来记录配置信息。

环境变量类似于全局变量，可以被各个进程访问到。我们可以通过修改环境变量来方便地修改系统配置。

配置存储到环境变量里：如HOME、PATH

配置存储到文件里：cpuinfo存储在/proc/cpuinfo里

---

#### **查看**

列出当前环境下的所有环境变量：

```bash
env  # 显示当前用户的变量
set  # 显示当前shell的变量，包括当前用户的变量;
export  # 显示当前导出成用户变量的shell变量
```

输出某个环境变量的值：

```bash
echo $PATH
```

---

#### 修改

环境变量的定义、修改、删除操作可以参考3. shell语法——变量这一节的内容。

为了将对环境变量的修改应用到未来所有环境下，可以将修改命令放到~/.bashrc文件中。
修改完~/.bashrc文件后，记得执行source ~/.bashrc，来将修改应用到当前的bash环境下。

为何将修改命令放到~/.bashrc，就可以确保修改会影响未来所有的环境呢？

- 每次启动bash，都会先执行~/.bashrc。
- 每次ssh登陆远程服务器，都会启动一个bash命令行给我们。
- 每次tmux新开一个pane，都会启动一个bash命令行给我们。
- 所以未来所有新开的环境都会加载我们修改的内容。



---

#### 常见环境变量

1. HOME：用户的家目录。
2. PATH：可执行文件（命令）的存储路径。路径与路径之间用:分隔。当某个可执行文件同时出现在多个路径中时，会选择从左到右数第一个路径中的执行。下列所有存储路径的环境变量，均采用从左到右的优先顺序。
3. LD_LIBRARY_PATH：用于指定动态链接库(.so文件)的路径，其内容是以冒号分隔的路径列表。
4. C_INCLUDE_PATH：C语言的头文件路径，内容是以冒号分隔的路径列表。
5. CPLUS_INCLUDE_PATH：CPP的头文件路径，内容是以冒号分隔的路径列表。
6. PYTHONPATH：Python导入包的路径，内容是以冒号分隔的路径列表。
7. JAVA_HOME：jdk的安装目录。
8. CLASSPATH：存放Java导入类的路径，内容是以冒号分隔的路径列表。



### 3.常用命令

#### **系统状况**

1. top：查看所有进程的信息（Linux的任务管理器）
   - 打开后，输入M：按使用内存排序
   - 打开后，输入P：按使用CPU排序
   - 打开后，输入q：退出

2. df -h：查看硬盘使用情况
3. free -h：查看内存使用情况
4. du -sh：查看当前目录占用的硬盘空间
5. ps aux：查看所有进程
6. kill -9 pid：杀死编号为pid的进程
7. 传递某个具体的信号：kill -s SIGTERM pid
8. netstat -nt：查看所有网络连接
   w：列出当前登陆的用户
9. ping www.baidu.com：检查是否连网



#### 文件权限

1. chmod：修改文件权限
   - chmod +x xxx：给xxx添加可执行权限
   - chmod -x xxx：去掉xxx的可执行权限
   - chmod 777 xxx：将xxx的权限改成777
   - chmod 777 xxx -R：递归修改整个文件夹的权限

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211120144124301.png" alt="image-20211120144124301" style="zoom:50%;" />









#### 文件检索

1. **find** /path/to/directory/ -name '*.py'：搜索某个文件路径下的所有*.py文件
2. **grep** xxx：从stdin中读入若干行数据，如果某行中包含xxx，则输出该行；否则忽略该行。
3. **wc**：统计行数、单词数、字节数
   - 既可以从**stdin**中直接读入内容；也可以在**命令行参数**中传入文件名列表；
   - 不加参数，展示行数、单词数、字节数
   - wc **-l**：统计行数
   - wc **-w**：统计单词数
   - wc **-c**：统计字节数
   - 可以跟多个参数  例如 `tmp/*`
   - **wc和grep都可以在命令行直接输入，然后命令行变成执行状态，可以输入字符、回车，然后Ctrl+D可以推出**
4. **tree**：展示当前目录的文件结构
   - tree /path/to/directory/：展示某个目录的文件结构
   - tree -a：展示隐藏文件
5. ==ag== xxx：搜索当前目录下的所有文件，检索xxx字符串
6. cut：分割每行的内容
   - 从stdin中读入多行数据
   - -c ：以字符为单位进行分割。
   - -d ：自定义分隔符，默认为制表符。
   - -f ：与-d一起使用，指定显示哪个区域。
   - 例子：
     - echo $PATH | cut -d ':' -f 3,5：输出PATH用:分割后第3、5列数据
     - echo $PATH | cut -d ':' -f 3-5：输出PATH用:分割后第3-5列数据
     - echo $PATH | cut -c 3,5：输出PATH的第3、5个字符
     - echo $PATH | cut -c 3-5：输出PATH的第3-5个字符
     - <img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211120165038691.png" alt="image-20211120165038691" style="zoom:50%;" />
     - cut命令，从stdin读入多行数据，-d指定分隔符，-f选择其中的某一列
7. sort：将每行内容按字典序排序
   - 可以从stdin中读取多行数据
   - 可以从命令行参数中读取文件名列表
   - 配合find来用
8. **xargs**：将stdin中的数据用空格或回车分割成命令行参数
   - 因为有些命令不接受标准输入，而管道符之间的连接必须是stdout和stdin，也即后一个命令接受到的只能是前一个命令的stdout，并且放在stdin里，这时xargs就很关键了
   - find . -name '*.py' | xargs cat | wc -l：统计当前目录下所有python文件的总行数
   - find . -name '*.py' | xargs cat 将所有Python文件输出

#### 查看文件内容

1. more：浏览文件内容
   - 回车：下一行
   - 空格：下一页
   - b：上一页
   - q：退出

2. less：与more类似，功能更全
   - 回车：下一行
   - y：上一行
   - Page Down：下一页
   - Page Up：上一页
   - q：退出

3. head -3 xxx：展示xxx的前3行内容，
   - 同时支持从stdin读入内容
   - `ps aux | head -3`  head可用于截取一部分内容



4. tail -3 xxx：展示xxx末尾3行内容
   - 同时支持从stdin读入内容



---

#### 用户相关

history：展示当前用户的历史操作。内容存放在~/.bash_history中

关闭bash后，才会把当前的最新的history写进.bash_history中





#### 工具

1. md5sum：计算md5哈希值
   - 去网上下载东西时，会给一个哈希值。可以将任意长度的字符串，求一个哈希值。由字符串求哈希值，很简单，但是反过来几乎不可能。
   - 可以从stdin读入内容
   - 也可以在命令行参数中传入文件名列表；
2. time command：统计command命令的执行时间
3. ipython3：交互式python3环境。可以当做计算器，或者批量管理文件。
   - ! echo "Hello World"：!表示执行shell脚本
   - 加上！可以执行shell脚本
4. watch -n 0.1 command：每0.1秒执行一次command命令
   - 可以观察内存占用情况
5. tar：压缩文件
   - tar -zcvf xxx.tar.gz /path/to/file/*：压缩  不加\*应该也行。
   - 加\*：   进压缩包是直接进到了里面， 不加\*：进压缩包时，是先显示了一个文件夹
   - tar -zxvf xxx.tar.gz：解压缩
6. diff xxx yyy：查找文件xxx与yyy的不同点



#### 例子

##### 例1

找出tmp文件夹中cpp文件里，哪些地方出现了关键词"main"（注意没有标明出处，只是把所有出处的行给列举出来了，没有列举这一行属于哪一个文件）

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211120152734565.png" alt="image-20211120152734565" style="zoom:50%;" />

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211120152752736.png" alt="image-20211120152752736" style="zoom: 67%;" />

##### 例2

同上，只不过要列举出处

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211120153439060.png" alt="image-20211120153439060" style="zoom:50%;" />

##### 例3

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211120154247785.png" alt="image-20211120154247785" style="zoom:50%;" />

找tmp文件夹下，所有cpp文件的总行数

找tmp文件夹下，所有py文件的总行数

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211120154306615.png" alt="image-20211120154306615" style="zoom:67%;" />



#### 注意

top 只能查看几个排名top的进程，看不全，一般我们会有三四百的进程

ps aux 详细展示每一个进程，一般用来查某一个进程，百分之八十的情况下都是用来杀进程

==`xargs + 命令` 就是将stdin变成参数放到了 xargs后面了==

---

[kill命令详解](https://linux.cn/article-2116-1.html)



当你执行一个"kill"命令，你实际上发送了一个信号给系统，让它去终结不正常的应用。总共有60个你可以使用的信号，但是基本上你只需要知道SIGTERM(15)和SIGKILL(9)。

你可以用这个命令看到所有信号的列表： `kill -l`

- SIGTERM - 此信号请求一个进程停止运行。此信号是可以被忽略的。进程可以用一段时间来正常关闭，一个程序的正常关闭一般需要一段时间来保存进度并释放资源。换句话说，它不是强制停止。
- SIGKILL - 此信号强制进程立刻停止运行。程序不能忽略此信号，而未保存的进度将会丢失。

使用"kill"的语法是：

```bash
kill [信号或选项] PID(s)
```

默认信号（当没有指定的时候）是SIGTERM。当它不起作用时，你可以使用下面的命令来强制kill掉一个进程:

```bash
kill SIGKILL PID 或 kill -9 PID
```

这里"-9"代表着SIGKILL信号。

如果你不知道应用的PID，仅需要运行这个命令： `ps aux`  

也可以在同一时间kill多个进程。`kill -9 PID1 PID2 PID3`



#### 拓展小知识

密码的存储：数据库中一般不存用户的密码，而是存密码的哈希值（现在一般不用md5），这样的话，当用户登录时，输入的密码会先求一遍哈希值然后与数据库的哈希值进行比较，这样的话我们就不用存密码了，这样就保护了用户的隐私，而且防止了密码的泄露。

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211120212713166.png" alt="image-20211120212713166" style="zoom:50%;" />



假如我们现在是考官（出卷者），我们通过哈希的方法就能完成：

1. 不让学生看答案
2. 同时可评测





一般命令行参数里都是文件名，因此find命令（会返回文件名参数）管道的下一项，一般要接xargs





## 8、租云服务器及配docker环境



<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211122201955278.png" alt="image-20211122201955278" style="zoom: 33%;" />

我们租到的服务器可以分为两大类毛坯服务器和提供一些服务的服务器（比如cdn、mysqll、redis，直播等等）

一般来说，毛坯服务器上跑框架、thrift。可定制化强

而提供服务的服务器，就不能自己做修改了，也即功能固定，提供服务的方式有两大类：1.socket：IP+port(比如数据库)、  2.http。

关系：中心服务器是毛坯服务器（比如上面跑Django）、然后调用其他提供服务的服务器。



1核2GB的一般学生<100，非学生得小1000元。服务器可以动态扩容，因此可以买一个小的



docker可以在服务器上开一堆虚拟的小服务器，在房子的内部再建小房子，docker很大的优势是迁移。 将在阿里云搭的服务器，可以很方便的迁移到华为云，避免踩坑。acwing提供配置好环境的docker镜像，用docker可以省掉配环境的步骤

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211122205324219.png" alt="image-20211122205324219" style="zoom: 33%;" />



怎样进到docker容器，两种方式：1、进行到运行docker毛坯服务器上，通过docker自带的命令attach，进入到docker。2、可以把docker当做一个新的独立的linux环境，可以配置ssh登录，可以在其他地方直接ssh登录到docker容器里





1、<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211122205724937.png" alt="image-20211122205724937" style="zoom:50%;" />

2、<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20211122205908815.png" alt="image-20211122205908815" style="zoom:50%;" />



docker怎么迁移出来？两行命令：1、把容器生成一个镜像 2、把镜像打包成一个文件。



### 1.租云服务器以及配环境

**从零开始**：（以腾讯云为例）

#### 一、进入官网

进入官网：https://cloud.tencent.com/ ，然后点击控制台，“云产品”-“云服务器” （阿里云网站叫ECS弹性服务器）-“实例”-“创建实例” 这样就进入到了服务器配置界面，以上可以通过官网的一些双十一活动进入，注意选择云服务器，而不是轻量化应用服务器。

我购买的时候，参考了这篇[文章](https://www.acwing.com/blog/content/11826/)

#### 二、购买云服务器

1、配置的选择问题:首先记得选择“自定义购买”，它相较于“一键购买”来说可定制化更强。
2、“付费方式”一般选择包年包月、“地域和可用区”不用太纠结，型号选择“一核2G”。
3、镜像选择“公共镜像”、“ubuntu 20.04 LTS”。公网ip一定要勾选。
4、宽带计费模式选择“按使用量”然后把带宽峰值拉到最大200M。
5、“安全组”如果没有要去新建，腾讯云有默认安全组，它的作用是控制服务器的哪些端口可以被访问 HTTP80 HTTPS443 SSH22。
6、登录名和密码需要注意的是阿里云华为云给的都是root用户，而腾讯云给的是Ubuntu用户，但它具有sudo权限
7、大部分设置都选择默认。

购买完成！



#### 三、登录云服务器并完成配置

1. 第一次登录：`ssh root@公网ip地址` ，然后输入密码。 
2. 查看配置：`free -h`查看内存，`/proc/cpuinfo`查看cpu的配置信息。
3. 一个建议：root用户不推荐使用，因为它的权限太大，推荐创建一个非根的用户，给它分配一个sudo权限，这样会更安全。
4. 添加用户：`adduser wangchen`回车，输入两次密码，其他信息可以不填，Y，
5. 给新建的用户分配sudo权限：`usermod -aG sudo wangchen`
6. 退回AcTerminal：Ctrl + D
7. 配置ACterminal中的acs免密登录我的云服务器：1、先配置别名：在~/.ssh/config中,输入以下

```bash
Host myserver1
	HostName 82.156.36.251
	User wangchen
```

​	2、配置免密登录：如果本地服务器中没有生产ssh公钥秘钥的话要先生成`ssh-keygen`，在`~/.ssh/config`文件夹下。 通过`ssh-copy-id myserver1`,输入密码，完成！

8. 我们直接`ssh myserver1`就可以登录到服务器了！以上就完成了服务器用户的添加，密码登录

9. 下面开始进一步改造：

10. 先`sudo apt-get update`,输入密码

11. 安装tmux: `sudo apt-get install tmux`, Y ,完成，此时的tmux是原始tmux，没有经过改造。

12. 改造tmux、vim、bash：先Ctrl+D回到AcTreminal， `scp .bashrc .vimrc .tmux.conf myserver1:`。回车，这样就把tmux、vim、bash的配置文件传到了云端服务器。这样以后就完成了配置。

13. 打开tmux，以后的工作都在tmux中完成，防止进度丢失。

14. 装docker：[网址](https://docs.docker.com/engine/install/ubuntu/)，依次复制粘贴上面的命令，一字不差的执行

    ```bash
    sudo apt-get update
    
    sudo apt-get install \
        ca-certificates \
        curl \
        gnupg \
        lsb-release
        
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
    
    echo \
      "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
      $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
      
    sudo apt-get update
     sudo apt-get install docker-ce docker-ce-cli containerd.io
    ```

15. 通过`docker --version`，查看docker版本，完成安装！

16. 其他工具的安装：`sudo apt-get install tree` 、 `sudo apt-get install python3` 、`sudo apt-get install ipython3`



其他：重装操作系统就是更换操作系统

养成好习惯，所有工作都在tmux里进行，防止意外关闭终端后，工作进度丢失







### 2、doker教程

配完docker之后，发现docker很多命令都要加上sudo权限才能运行，怎样才能避免每次使用docker命令都要sudo权限呢？ 把当前的用户添加到docker用户组里就行了。






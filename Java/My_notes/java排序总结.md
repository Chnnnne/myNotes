# java排序总结



### 1. 对数组排序，使用Arrays工具类 

1. 基本类型数组，只能默认排序
2. 引用类型数组，默认排序（Comparable）
   引用类型，自定义排序（Comparator实现方式1、comparable对象  2、匿名内部类 3、Lambda）

<img src="C:\Users\95266\AppData\Roaming\Typora\typora-user-images\image-20220118174415830.png" alt="image-20220118174415830" style="zoom:50%;" />

数组：

```java
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 10, 4, 9, 5 ,8 ,6 ,7};
            System.out.println(Arrays.toString(arr));
            Arrays.sort(arr);//基本类型，默认排序
            System.out.println(Arrays.toString(arr));
            System.out.println("------------------");


            Integer arr2[] = {1, 10, 2, 8, 3, 7, 4, 6, 5};
            System.out.println(Arrays.toString(arr2));
            Arrays.sort(arr2, 2, 9);//引用类型，默认排序（若是对象的话，对象类需要实现Comparable接口）
            System.out.println(Arrays.toString(arr2));
            Arrays.sort(arr2, 2, 9, (i1, i2)->i2 - i1); //引用类型，自定义排序，此处可以用Lambda、匿名、实名等方式
            System.out.println(Arrays.toString(arr2));
    }
[1, 2, 3, 10, 4, 9, 5, 8, 6, 7]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
------------------
[1, 10, 2, 8, 3, 7, 4, 6, 5]
[1, 10, 2, 3, 4, 5, 6, 7, 8]
[1, 10, 8, 7, 6, 5, 4, 3, 2]
```



### 2.对集合排序，使用Collections工具类

集合指的是LIst，也即Vector、ArrayList、LinkedList

集合：

```java
public class Student implements Comparable<Student>{//继承Comparable作为默认排序方式
	private String name;
	private Integer age;

	@Override
	public int compareTo(Student o) {
		if(this.age==o.age)//先年龄升序再名字升序
			return this.name.charAt(0)-o.name.charAt(0);//名字首字母升序
		else {
			return this.age-o.age;//年龄升序
		}
	}

	public static void main(String args[]) {
		ArrayList<Student> al = new ArrayList<Student>();
		Collections.addAll(al, new Student("cchen",20),new Student("achen",20),new Student("bchen",21));
		System.out.println(al);
		
		Collections.sort(al);//默认排序
		System.out.println(al);
		
		Collections.sort(al, (o1,o2)->{return o2.age-o1.age;});//年龄降序
		System.out.println(al);
	}
	
}
结果：
[Student [name=cchen, age=20], Student [name=achen, age=20], Student [name=bchen, age=21]]
[Student [name=achen, age=20], Student [name=cchen, age=20], Student [name=bchen, age=21]]
[Student [name=bchen, age=21], Student [name=achen, age=20], Student [name=cchen, age=20]]
```



### 3.排序原则

**前 - 后** 是升序



### 




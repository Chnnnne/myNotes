package practice01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Student implements Comparable<Student>{
	private String name;
	private Integer age;
	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public static void main(String args[]) {
//		Student stu1 = new Student("wangchen",12);
//		Student stu2 = new Student("wangchen",12);
//		System.out.println(stu1.equals(stu2));
		
		ArrayList<Student> al = new ArrayList<Student>();
		Collections.addAll(al, new Student("cchen",20),new Student("achen",20),new Student("bchen",21));
		System.out.println(al);
		
		Collections.sort(al);
		System.out.println(al);
		
		Collections.sort(al, (o1,o2)->o2.age-o1.age);
		System.out.println(al);
		
		Integer arr[]={2,34,35,4,657,8,69,9}; 
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, (o1,o2)->{return o2-o1;});//注意只能是 包装类！！！
		System.out.println(Arrays.toString(arr));
		
	}
	@Override
	public int compareTo(Student o) {
		if(this.age==o.age)//先年龄升序再名字升序
			return this.name.charAt(0)-o.name.charAt(0);//名字首字母升序
		else {
			return this.age-o.age;//年龄升序
		}
	}
	
	
}

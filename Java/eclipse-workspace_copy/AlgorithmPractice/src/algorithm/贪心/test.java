package algorithm.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Student implements Comparable<Student>{
	int id;
	String name;
	double Score;
	public Student(int id, String name, double score) {
		super();
		this.id = id;
		this.name = name;
		Score = score;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Score=" + Score + "]";
	}
	@Override
	public int compareTo(Student o) {
		
		return (int) Math.signum(o.Score-this.Score);
	}
	
	
	
}

public class test {
	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(1,"wangchen",99.5));
		al.add(new Student(9,"lihua",100));
		al.add(new Student(2,"xiaohong",50.5));
		al.add(new Student(8,"xiaoming",80.3));
		al.add(new Student(5,"zhangsan",10));
		
		Collections.sort(al);
		
		for (Student student : al) {
			System.out.println(student);
		}
		System.out.println("\n\n\n\n");
		Student [] sArray= new Student[4];
		sArray[1]=new Student(1,"wangchen",4.166666);
		sArray[2]=new Student(2,"lihua",4.8);
		sArray[3]=new Student(3,"xiaohong",4.5);
		System.out.println("排序前");
		for (Student student : sArray) {
			System.out.println(student);
		}
		Arrays.sort(sArray,1,4);
		System.out.println("排序后");
		for (Student student : sArray) {
			System.out.println(student);
		}
	}//main
}

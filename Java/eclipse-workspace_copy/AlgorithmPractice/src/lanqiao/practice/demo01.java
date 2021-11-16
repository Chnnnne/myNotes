package lanqiao.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class demo01 {
	public static void main(String[] args) {
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		hashMap.put("wangchen",98);
		hashMap.put( "xia",96);
		hashMap.put( "ta",85);
		hashMap.put( "hu",77);
		Set<String> keySet = hashMap.keySet();
		for (String string : keySet) {
			System.out.println(string + " : " + hashMap.get(string));
		}
		
		
		
		//对key定义排序规则,也即按照名字的首字母排序
		System.out.println("\n名字升序：");
		Object[] array = keySet.toArray();
		Arrays.sort(array);
		for (Object object : array) {
			System.out.println(object + " : " + hashMap.get(object));
		}
		
		//对value定义排序规则,也即按照成绩高低升序
		System.out.println("\n成绩升序");
		Set<Entry<String,Integer>> entrySet = hashMap.entrySet();
		ArrayList<Entry<String, Integer>> al = new ArrayList<>(entrySet);
		Collections.sort(al,(o1,o2)->o1.getValue()-o2.getValue());
		for (Entry<String, Integer> entry : al) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		
		
//		HashMap<Student,Integer> hashMap = new HashMap<Student,Integer>();
//		Student s1 = new Student(001,"wangchen","male","2018");
//		Student s2 = new Student(001,"wangchen","female","2018");
//		Student s3 = new Student(003,"bichen","female","2017");
//		hashMap.put(s1, 99);
//		hashMap.put(s2, 45);
//		hashMap.put(s3, 87);
//		Set<Entry<Student,Integer>> entrySet = hashMap.entrySet();
//		for (Entry<Student, Integer> entry : entrySet) {
//			System.out.println(entry.getKey()+"  "+entry.getValue());
//		}
//		System.out.println(hashMap.values());
//		System.out.println(hashMap.values().contains(99));
//		System.out.println(hashMap.values().contains(45));
//
	}//main
}


class Student {
	private int id;
	private String name;
	private String gender;
	private String Enrollyear;
	public Student(int id, String name, String gender, String enrollyear) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		Enrollyear = enrollyear;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEnrollyear() {
		return Enrollyear;
	}
	public void setEnrollyear(String enrollyear) {
		Enrollyear = enrollyear;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", Enrollyear=" + Enrollyear + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	
	
}
package lanqiao.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;


class Studentt implements Comparable<Studentt>{
	private int id;
	private String name;
	public Studentt(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Studentt() {
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
	@Override
	public String toString() {
		return "Studentt [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Studentt o) {
		return o.id-this.id;
	}

	
	
	
}

public class demo02_queue {
	public static void main(String[] args) {
		PriorityQueue<Studentt> pq = new	PriorityQueue<Studentt> ();
		Studentt s2 = new Studentt(2, "lisi");
		Studentt s1 = new Studentt(1, "wangchen");
		Studentt s4 = new Studentt(4, "xiaohong");
		Studentt s3 = new Studentt(3, "zhangsan");
		pq.offer(s2);
		pq.offer(s1);
		pq.offer(s4);
		pq.offer(s3);
		System.out.println(pq.size());
		while(pq.peek()!=null) {
			System.out.println(pq.poll());
		}
		
	}//main
}

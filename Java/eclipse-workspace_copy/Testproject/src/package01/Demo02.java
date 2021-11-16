package package01;

import java.util.Iterator;
import java.util.Vector;


//////////////////////////////////////////////// 实验vector
public class Demo02 {
	public static void main(String []args)
	{
		Vector<String> V=new Vector<String>();
		V.add("AAA");
		V.add("BBB");
		V.add("CCC");
		V.add("DDD");
		for(Iterator<String> it= V.iterator();it.hasNext();)
			System.out.println(it.next());
		
		
//		V.set(1, "SSS");
//		for(Iterator<String> it= V.iterator();it.hasNext();)
//			System.out.println(it.next());
		
		
//		V.remove(1);
//		V.remove("WWW");
//		for(Iterator<String> it= V.iterator();it.hasNext();)
//			System.out.println(it.next());
		
//		System.out.println(V.firstElement()+V.lastElement());
		for(Iterator<String> it= V.iterator();it.hasNext();)
			System.out.println(it.next());
	}
}

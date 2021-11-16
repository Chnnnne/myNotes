package package01;
import java.lang.Math;
import java.util.Collections;
import java.util.Vector;

public class Work2 {
	public static void main(String []args)
	{
		int count=1;
		Vector<Character> v=new Vector<Character>();
		while(count<=10)
		{
			int temp=(int)(Math.random()*24);
			char c=(char)('a'+temp);
			if(!v.contains(c))
			{
				v.add(c);
				count++;
			}
			
		}
		
		
		System.out.println("排序前的字母序列：");
		for (Character character : v) {
			System.out.print(" "+character);
		}
		
		System.out.println("\n排序后的字母序列：");
		Collections.sort(v);
		for (Character character : v) {
			System.out.print(" "+character);
		}
		
	}

}

package package01;
import java.util.Iterator;
import java.util.Vector;

public class Work1 {
	public static void main(String []args)
	{
		Vector<Integer> vector= new Vector<Integer>();
		for(int i=2;i<=100;i++)
		{
			if(is_Prim(i))
			{
			  vector.add(i);
			}	
		}
		int sum=0;
		Iterator<Integer> it=vector.iterator();
		for(;it.hasNext();)
		{
			int temp=it.next();
			System.out.print(" "+temp);
			sum=sum+temp;
		}
//		for (Integer integer : vector) {
//			sum+=integer;
//			System.out.print(" "+integer);
//		}
		
		System.out.println("\n它们的和是"+sum);
	}
	
	private static boolean is_Prim(int a)
	{
		for(int i=2;i<=Math.sqrt(a);i++)
		{
			if(a%i==0)
				return false;
		}
		return true;
	}
}

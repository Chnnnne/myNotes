package package01;

public class Demo04 {
	public static void main(String []args)
	{
		char [] chararr= {'W','A','N','G'};
		for (char c : chararr) {
			System.out.print(c+" ");	
		}
		System.out.println();
		
		ChangeArr(chararr);

		for (char c : chararr) {
			System.out.print(c+" ");	
		}	
	}
	
	
	public static void ChangeArr(char []arry)
	{
		arry[0]='$';
		arry[1]='$';
		arry[2]='$';
		arry[3]='$';
	}
}

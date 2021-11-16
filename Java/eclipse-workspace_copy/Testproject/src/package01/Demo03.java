package package01;

public class Demo03 {
	public static void main(String []args)
	{
		
		String string="1998";
		byte [] temp=toByte(string);
		for (byte b : temp) {
			System.out.println(b+" ");
		}
//	System.out.println(string);
//	ChangeString(string);
//	System.out.println(string);
	
	
	}
	public static void ChangeString(String s)
	{
		s="a"+s+"AAA";
		System.out.println(s);
	}
	
	public static byte[] toByte(String s)
	{
		byte []temp=new byte[s.length()];
		for(int i=0;i<s.length();i++)
		{
			temp[i]=(byte) ((byte) s.charAt(i)-'0');
		}
		
		
		
		return temp;
	}
	
	
	
}
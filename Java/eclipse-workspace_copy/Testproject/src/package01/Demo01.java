package package01;

////////////////////////////////////实验 string
public class Demo01 {
	public static void main(String []args)
	{
		char [] array1=new char[5];
		char [] array2=new char[] {'A','B','C'};
		char [] array3= {'f','b','c','d','e','f'};
		byte [] array4= {97,98,99,100};
		String str1=new String();
		String str2=new String(array3);
		String str3=new String(array4);
		String str4=String.valueOf(false);
		String str5="ABC".concat("DEF");
//		String str6="ABC"+"DEF"+(11+11)+false;//22
//		String str7="ABC"+"DEF"+11+11+false;//1111
//		System.out.println(str6);
//		System.out.println(str7);
//		System.out.println(str2.length());
//		System.out.println(str1.isEmpty());
//		System.out.println(str2.charAt(9));
		System.out.println(str2.indexOf('f', 3));
		
		
		
	}
}

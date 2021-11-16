package package03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Work2_1 {
	public static void main(String []args) throws IOException
	{
		String []a=new String[5];
		System.out.println("请依次输入五个学生的成绩：");
		Scanner s=new Scanner(System.in);
		
		FileOutputStream f=new FileOutputStream("StuScore.txt");

		
		for(int i=0;i<5;i++)
		{
			a[i]=s.next();
			byte []b =a[i].getBytes();
			f.write(b);
			f.write(' ');
			
		}
			
		f.close();
		
		
	}
}

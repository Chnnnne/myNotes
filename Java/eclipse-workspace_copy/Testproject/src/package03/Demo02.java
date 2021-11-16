package package03;

import java.io.FileInputStream;
import java.io.IOException;



public class Demo02 {
	public static void main(String [] args) throws IOException
	{
		FileInputStream f=new FileInputStream("TestNote.txt");
		while(true)
		{
			int i=f.read();
			if(i==-1)
				break;
			System.out.print(i);
			
		}
		f.close();
		System.out.println("结束了！");
		
		
	}
}

package package03;

import java.io.IOException;

public class Demo01 {
	public static void main(String []args) throws IOException
	{
		while(true)
		{
			int i=System.in.read();
			if(i==-1)
				break;
			char c=(char)i;
			System.out.print(c); 
		}
		System.out.println("ctrl Z 有用了！");
	
	}
}

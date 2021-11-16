package practice01;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;



public abstract class demo01 {
	public static void main(String []args) throws IOException  {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format = sdf.format(date);
		System.out.println(format);
		
//		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("mytest.txt"));
//		bos.write("my name is wangchen".getBytes());
//		bos.close();
		FileInputStream fis = new FileInputStream("mytest.txt");
		byte [] barray=new byte[1024];
		int len=0;
		while((len=fis.read(barray))!=-1) {
			System.out.println(new String(barray,0,len));
		}
		fis.close();
		
		
		
	}
	
	@Test
	public void method() {
		System.out.println("test");
	}
}

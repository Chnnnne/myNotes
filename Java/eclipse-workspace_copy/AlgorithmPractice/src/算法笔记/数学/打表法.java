package 算法笔记.数学;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class 打表法 {

	
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\95266\\Desktop\\test.txt");
		fos.write("bool prime[]={false,false".getBytes());
		for(int i=2;i<=300000010;i++) {
			if(isPrime(i)) {
				byte bts[]=(",true").getBytes();
				fos.write(bts);
			}
			byte[] bs = ",true".getBytes();
			fos.write(bs);
		}
		fos.write("};".getBytes());
		fos.close();
		System.out.println("OK");
	}

	private static boolean isPrime(int n) {
		int sqrt=(int) Math.sqrt(n);
		for(int i=2;i<=sqrt;i++) {
			if(n%i==0) return false;
		}
		return true;
	}//main
}

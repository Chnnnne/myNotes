package lanqiao.练习系统;

import java.io.IOException;
import java.util.Scanner;

public class ALGO_246_猴子 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int x = Reader.nextInt();
		int y = Reader.nextInt();
		int z = Reader.nextInt();
		int x1 = Reader.nextInt();
		int y1 = Reader.nextInt();
		int z1 = Reader.nextInt();
		int p = Reader.nextInt();
		String format="%."+p+"f";
		System.out.printf(format,x1*1.0/x
				+y1*1.0/y
				+z1*1.0/z);
		
	}//main
}

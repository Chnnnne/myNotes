package lanqiao.year2018_9th;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

/*
 * 求 (2+3i)^123456 等于多少？
 * (a+bi)(c+di)=ac-bd+(ad+bc)i
 */
public class P03_复数幂 {
	public static void main(String[] args) throws IOException {
		BigInteger baseA = new BigInteger("1",10 );
		BigInteger baseB = new BigInteger("0",10 );
		BigInteger a = new BigInteger("2", 10);
		BigInteger b = new BigInteger("3", 10);
		
		BigInteger temp;
		for(int i=1;i<=123456;i++) {
			temp=baseA;
			baseA=baseA.multiply(a).subtract(baseB.multiply(b));
			baseB=temp.multiply(b).add(baseB.multiply(a));
		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\95266\\Desktop\\a.txt");
		fos.write(baseA.toString(10).getBytes());//由于位数太多，标准输出无效，转为用文件
		fos.close();
	}//main

}

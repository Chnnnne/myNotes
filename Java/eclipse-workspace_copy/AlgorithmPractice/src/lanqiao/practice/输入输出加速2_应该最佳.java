package lanqiao.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Reader {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = new StringTokenizer("");

	static String next() throws IOException {// 读取下一个字符串
		while (!tokenizer.hasMoreTokens()) {// 返回是否还有分隔符
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();// 返回从当前位置到下一个分隔符的字符串
	}

	static String nextLine() throws IOException {// 读取下一行字符串
		return reader.readLine();
	}

	static int nextInt() throws IOException {// 读取下一个int型数值
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {// 读取下一个long型数值
		return Long.parseLong(next());
	}

	static double nextDouble() throws IOException {// 读取下一个double型数值
		return Double.parseDouble(next());
	}
}


public class 输入输出加速2_应该最佳 {
	public static void main(String[] args) throws IOException {
//		String nextLine = Reader.nextLine();
//		System.out.println(nextLine);
//		String next = Reader.next();
//		System.out.println(next);
//		int nextInt = Reader.nextInt();
//		System.out.println(nextInt);
//		long nextLong = Reader.nextLong();
//		System.out.println(nextLong);
//		double nextDouble = Reader.nextDouble();
//		System.out.println(nextDouble);
		int nextInt = Reader.nextInt();
		System.out.println(nextInt);
		String nextLine = Reader.nextLine();//不会读取残余的回车
		System.out.println(nextLine);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("aaa");
		stringBuilder.append("bbb");
//		stringBuilder.insert(offset, b)
	}//main
}

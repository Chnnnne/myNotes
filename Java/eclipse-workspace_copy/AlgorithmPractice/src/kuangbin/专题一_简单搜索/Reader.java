package kuangbin.专题一_简单搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

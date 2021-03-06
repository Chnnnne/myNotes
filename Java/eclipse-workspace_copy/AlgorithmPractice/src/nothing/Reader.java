package nothing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reader {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = new StringTokenizer("");
	
	static String next() throws IOException {
		while(!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
	static String nextLine() throws IOException {
		return reader.readLine();
	}
	static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
	static long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}
	static double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(next());
	}
}

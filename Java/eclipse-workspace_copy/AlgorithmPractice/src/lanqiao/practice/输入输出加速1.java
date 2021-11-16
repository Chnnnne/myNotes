//package lanqiao.practice;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class Reader {
//    static BufferedReader reader;
//    static StringTokenizer tokenizer;
//
//    /** call thReader method to initialize reader for InputStream */
//    static void init(InputStream input) {
//        reader = new BufferedReader(
//                     new InputStreamReader(input) );
//        tokenizer = new StringTokenizer("");
//    }
//
//    /** get next word */
//    static String next() throws IOException {
//        while ( ! tokenizer.hasMoreTokens() ) {
//            //TODO add check for eof if necessary
//            tokenizer = new StringTokenizer(
//                   reader.readLine() );
//        }
//        return tokenizer.nextToken();
//    }
//
//    static int nextInt() throws IOException {
//        return Integer.parseInt( next() );
//    }
//
//    static double nextDouble() throws IOException {
//        return Double.parseDouble( next() );
//    }
//}
//
//public class 输入输出加速1 {
//	public static void main(String[] args) throws IOException {
//		Reader.init(System.in);
//		String next = Reader.next();
//		System.out.println(next);
//		
//		int nextInt = Reader.nextInt();
//		System.out.println(nextInt);
//		
//		double nextDouble = Reader.nextDouble();
//		System.out.println(nextDouble);
//
//	}//main
//	
//}

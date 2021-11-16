package PAT;

import java.io.IOException;

public class P1005_Spell_it_right {
	public static void main(String[] args) throws IOException {
		String str = Reader.next();
		char[] charArray = str.toCharArray();
		int sum=0;
		for (int i = 0; i < charArray.length; i++) {
			sum+=charArray[i]-'0';
		}
		String sumStr=sum+"";
		char[] charArray2 = sumStr.toCharArray();
		int len=charArray2.length;
		for (int i = 0; i < len-1; i++) {
			System.out.print(toEnglish(charArray2[i])+" ");
		}
		System.out.print(toEnglish(charArray2[len-1]));
	}//main

	private static String toEnglish(char c) {
		switch (c) {
		case '0':
			return"zero";
		case '1':
			return"one";
			
		case '2':
			return"two";
		case '3':
			return"three";
		case '4':
			return"four";
		case '5':
			return"five";
		case '6':
			return"six";
		case '7':
			return"seven";
		case '8':
			return"eight";
		case '9':
			return"nine";

		default:
			System.out.println("error");
			break;
		}
		return null;
	}
	
}

package lanqiao.year2020_11th;

public class P_A {
	public static void main(String[] args) {
		int count=0;
		for(int i=1;i<=2020;i++) {
			String str=i+"";
			char[] charArray = str.toCharArray();
			for (int j = 0; j < charArray.length; j++) {
				if(charArray[j]=='2')
					count++;
			}
		}
		System.out.println(count);

	}//main
}

package lanqiao.year2021_12th_simulate;

import java.util.Scanner;

public class P5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n =sc.nextInt();
		int z=703;
		for(char i='A';i<='Z';i++) {
			for(char j='A';j<='Z';j++) {
				for(char k='A';k<='Z';k++) {
					if(z==2021) {
						String str=i+""+j+k;
						System.out.println(str);
					}
					z++;
				}
			}
			
		}

	}//main
}

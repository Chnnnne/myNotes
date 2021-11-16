package nothing;

import java.util.Scanner;

public class P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			String before=getTitle(a);
			String after=getTitle(b);
			if(before.equals(after))
				System.out.println("No");
			else
				System.out.println(getTitle(a)+" to "+getTitle(b));
		}
	}//main

	private static String getTitle(int score) {
		if(score<=1199) return "Newbie";
		if(score<=1399) return "Pupil";
		if(score<=1599) return "Specialist";
		if(score<=1899) return "Expert";
		if(score<=2099) return "Candidate Master";
		if(score<=2399) return "Master";
		if(score<=2999) return "Grandmaster";
		if(score<=4000) return "Legendary Grandmaster";
		return null;
	}
}

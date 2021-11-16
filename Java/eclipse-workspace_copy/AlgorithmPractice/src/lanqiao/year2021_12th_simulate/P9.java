package lanqiao.year2021_12th_simulate;

import java.util.Scanner;

public class P9 {
	public static void main(String[] args) {
		int N =1000010;
		int A=N,B=N,C=N,BC=N,AC=N,AB=N,ABC=N;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int prize;
		String str;
		while(n--!=0) {
			prize = sc.nextInt();
			str = sc.next();
			switch (str) {
			case "A":
				if(prize<=A)
					A=prize;
				break;
			case "B":
				if(prize<=B)
					B=prize;
				break;
			case "C":
				if(prize<=C)
					C=prize;
				break;
			case "AB":
			case "BA":
				if(prize<=AB)
					AB=prize;
				break;
			case "AC":
			case "CA":
				if(prize<=AC)
					AC=prize;
				break;
			case "BC":
			case "CB":
				if(prize<=BC)
					BC=prize;
				break;
			case "ABC":
			case "ACB":
			case "BCA":
			case "BAC":
			case "CAB":
			case "CBA":
				if(prize<=ABC)
					ABC=prize;
				break;

			default:
				System.out.println("WRONG");
				break;
			}
		}
		
		int minPrize=300010;
		// A B C 形式
		if(A!=N&&B!=N&&C!=N) 
			minPrize=A+B+C;
		
		//两个的形式
		if(A!=N&&BC!=N  &&A+BC<minPrize)
			minPrize=A+BC;
		if(B!=N&&AC!=N  &&B+AC<minPrize)
			minPrize=B+AC;
		if(C!=N&&AB!=N  &&C+AB<minPrize)
			minPrize=C+AB;
		
		//ABC
		if(ABC!=N &&ABC<minPrize)
			minPrize=ABC;
		System.out.println(minPrize);

	}//main
}

package lanqiao.year2020_11th;

import java.io.IOException;

public class P_F {
	public static void main(String[] args) throws IOException {
		int n = Reader.nextInt();
		int max=-9999,min=9999,sum=0,score;
		for(int i=1;i<=n;i++) {
			score = Reader.nextInt();
			if(score>max) max=score;
			if(score<min) min=score;
			sum+=score;
		}
		System.out.println(max);
		System.out.println(min);
		System.out.printf("%.2f",sum*1.0/n);

	}//main
}

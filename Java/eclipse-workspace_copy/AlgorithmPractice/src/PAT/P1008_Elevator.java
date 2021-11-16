package PAT;

import java.io.IOException;

public class P1008_Elevator {
	public static void main(String[] args) throws IOException {
		int N = Reader.nextInt();
		int next=0,now=0,sum=0;
		for (int i = 0; i < N; i++) {
			next=Reader.nextInt();
			if(next>=now)
			{
				sum+=(next-now)*6;
			}
			else {
				sum+=(now-next)*4;
			}
			sum+=5;
			now=next;
		}
		System.out.println(sum);
	}//main
}

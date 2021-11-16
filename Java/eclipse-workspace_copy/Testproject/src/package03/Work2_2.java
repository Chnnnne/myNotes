package package03;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Work2_2 {
	public static void main(String []args) throws IOException
	{
		int []stusoe=new int [5];
		FileInputStream f=new FileInputStream("StuScore.txt");
		int temp=0;
		int count=0;
		int sum=0;
		while(true)
		{
			temp=f.read();
			if(temp==-1)
				break;
			if(temp==' ')
			{
				stusoe[count++]=sum;
				sum=0;
			}
			else
			{
				sum=sum*10+temp-'0';
			}
			
			
		}
		
		f.close();
		int scoresum=0;
		for(int x:stusoe)
		scoresum=scoresum+x;
		System.out.println("所有成绩的平均数是"+scoresum/5*1.0);
		
		System.out.println("他们的成绩分别为:");
		for(int x:stusoe)
			System.out.print(" "+x);
		
		Arrays.sort(stusoe);
		System.out.println("\n排序之后他们的成绩分别为：");
		for(int x:stusoe)
			System.out.print(" "+x);
		
	}
}

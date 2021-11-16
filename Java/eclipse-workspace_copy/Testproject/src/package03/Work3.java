package package03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;



public class Work3 {
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
		double aver= scoresum/5*1.0;
		stusoe[2]=(int) aver;

		

		FileOutputStream o=new FileOutputStream("StuScore.txt");
			

		for(int i=0;i<5;i++)
		{
			byte [] t=String.valueOf(stusoe[i]).getBytes();
			
			o.write(t);
			o.write(' ');
		}
		
		o.close();

		
		System.out.println("已经完成把平均数覆盖第三个数据的工作！");
		
	}
}

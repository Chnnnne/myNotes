package nothing;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws IOException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		System.out.println(cal.get(Calendar.YEAR)+" "
				+cal.get(Calendar.MONTH)+" "+cal.get(Calendar.DAY_OF_MONTH));
		int count= 0;
		for(;!(cal.get(Calendar.YEAR)==2021&&
				cal.get(Calendar.MONTH)==3&&
				cal.get(Calendar.DAY_OF_MONTH)==15)
				;cal.add(Calendar.DAY_OF_MONTH,1)) {
			count++;
			System.out.println(cal.get(Calendar.YEAR)+" "
					+cal.get(Calendar.MONTH)+" "+cal.get(Calendar.DAY_OF_MONTH));
		}
		System.out.println(count);
	}//main
}

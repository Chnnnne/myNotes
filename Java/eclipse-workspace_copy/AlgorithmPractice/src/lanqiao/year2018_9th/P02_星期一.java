package lanqiao.year2018_9th;

import java.util.Calendar;
/*
 * 有点麻烦,也有不用Calendar的方法： 就是算出总天数，闰年366天，平年365天可得出sumday=36525(天）；
 * 翻电脑日历得2000年12月31日是周日，按照周日，六，五，四，三，二，一的顺序往前推，共有36525/7=5217 个循环，余数是6. 
 * 故可知一共5217个星期一
 */
public class P02_星期一 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year;
		int month;
		int day;
		int xq;
		int count=0;
		cal.set(Calendar.YEAR, 1901);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);
		while(!(year==2000&&month==11&&day==31)) {
			xq = cal.get(Calendar.DAY_OF_WEEK);
			if(xq==2) count++;
			cal.add(Calendar.DAY_OF_MONTH, 1);
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DAY_OF_MONTH);
		}
		System.out.println(count);
	}//main

}

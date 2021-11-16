package lanqiao.year2020_11th;

public class test {
	public static void main(String[] args) {
		int a[] = new int[128];
			for(int i = 1;i<128;i++) {
				a[i] = Integer.parseInt(Integer.toBinaryString(i));
//				首先将十进制转换为二进制，因为Integer.toBinaryString()函数返回的是String类型
//				所以再用Integer.parseInt()函数转换成十进制（或者说是转换成int类型）重新存储进数组
			}
			for(int i = 0;i<128;i++) {
				System.out.printf("%07d",a[i]);
//				利用整形宽度，输出七位代表状态码的数字
				System.out.println();
			}		
		}
}

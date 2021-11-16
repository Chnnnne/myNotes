package package01;

import java.util.Arrays;

public class BigInteger {
	public byte[] mb_data;

//构造方法
	public BigInteger() {
		super();
	}

	public BigInteger(byte[] mb_data) {
		super();
		this.mb_data = mb_data;
	}

	public byte[] getMb_data() {
		return mb_data;
	}

	public void setMb_data(byte[] mb_data) {
		this.mb_data = mb_data;
	}

//重写toString
	@Override
	public String toString() {
		return "BigInteger [mb_data=" + Arrays.toString(mb_data) + "]";
	}

//静态成员方法 完成 String->byte数组
	public static byte[] StrtoBs(String s) {
		byte[] temp = new byte[s.length()];
		for (int i = 0; i < s.length(); i++) {
			temp[i] = (byte) ((byte) s.charAt(i) - '0');
		}
		return temp;
	}

//静态成员方法 完成 byte数组->	String
	public static String BstoStr(byte[] bs) {
		for (int i = 0; i < bs.length; i++) {
			bs[i] = (byte) (bs[i] + '0');
		}
		return new String(bs);
	}

//静态成员方法 完成两个String字符串的对齐工作
	public static void Adjust(String str1, String str2) {
		if (str1.length() > str2.length()) {
			int t = str1.length() - str2.length();
			while (t > 0) {
				str2 = "0" + str2;
				t--;
			}
		} else {
			int t = str2.length() - str1.length();
			while (t > 0) {
				str1 = "0" + str1;
				t--;
			}
		}
	}

//普通成员方法 完成遍历打印byte数组
	public void Prin_mbdata() {
		for (byte b : mb_data) {
			System.out.print(b);
		}
		System.out.println();
	}

//普通成员方法  完成加法运算 （注意byte数组已完成高位的对齐工作）
	public BigInteger Add(BigInteger b) {
		byte[] rec = new byte[this.mb_data.length];
		int cout = 0;
		for (int i = this.mb_data.length - 1; i >= 0; i--) {
			int temp = this.mb_data[i] + b.mb_data[i];
			if (i != 0) {
				if (temp >= 10)
					rec[i - 1]++;
				rec[i] = (byte) (temp % 10);
			} else {
				if (temp >= 10)
					cout = 1;
				rec[i] = (byte) (temp % 10);
			}
		}

		byte[] finalrec;
		if (cout == 1) {
			finalrec = new byte[this.mb_data.length + 1];
			finalrec[0] = 1;
		} else {
			finalrec = rec;
		}
		return new BigInteger(finalrec);
	}

//普通成员方法  完成乘法运算 （注意byte数组已完成高位的对齐工作）
//(需要完善）
	public BigInteger Multiply(BigInteger b) {
//	byte [] rec=new byte[this.mb_data.length*2];
//	BigInteger trec=new BigInteger(rec);
		long sum1 = 0;
		long sum2 = 0;
		for (int i = 0; i < this.mb_data.length - 1; i++)
			sum1 = sum1 * 10 + this.mb_data[i];

		for (int i = 0; i < b.mb_data.length - 1; i++)
			sum2 = sum2 * 10 + b.mb_data[i];
		long rec = sum1 * sum2;
		BigInteger recBigInteger = new BigInteger(BigInteger.StrtoBs("" + rec));

		return recBigInteger;
	}

//普通成员方法  完成减法运算 （注意byte数组已完成高位的对齐工作） 
//(还有bug)
	public BigInteger Subtract(BigInteger b) {
		byte[] rec = new byte[this.mb_data.length];
		int cout = 0;

		for (int i = this.mb_data.length - 1; i >= 0; i--) {
			int temp = this.mb_data[i] - b.mb_data[i];
			if (i != 0) {
				if (temp < 0)
					rec[i - 1]--;

				rec[i] = (byte) ((temp + 10) % 10);
			} else {
				if (temp < 0)
					cout = 1;
				rec[i] = (byte) ((temp + 10) % 10);
			}
		}
		byte[] finalrec;
		if (cout == 1) {
			finalrec = new byte[this.mb_data.length + 1];
			finalrec[0] = '-';
		} else {
			finalrec = rec;
		}
		return new BigInteger(finalrec);
	}
}

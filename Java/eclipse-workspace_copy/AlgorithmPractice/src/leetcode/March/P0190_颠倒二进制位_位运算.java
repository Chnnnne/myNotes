package leetcode.March;

public class P0190_颠倒二进制位_位运算 {
	public static void main(String[] args) {
		

	}//main
	
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++) {
        	int k=(n>>(31-i))&1;//提取第i位
        	k=k<<i;//移动到适当位置
        	res|=k;//赋值
        }
    	return res;
    }
}

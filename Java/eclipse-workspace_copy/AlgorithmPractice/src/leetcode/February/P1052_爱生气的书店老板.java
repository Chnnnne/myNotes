package leetcode.February;

public class P1052_爱生气的书店老板 {
	public static void main(String[] args) {
		System.out.println(new P1052_爱生气的书店老板().maxSatisfied(
				new int[] {1,0,1,2,1,1,7,5}, new int[] {0,1,0,1,0,1,0,1}, 3));

	}//main
	
	
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    	//grumpy[i]为1代表老板生气 ，customers[i]代表i分钟的顾客数
    	//固定窗口大小，记住可以因为老板trick而留住的（原本被老板气走）顾客数，并求最大值
    	int N=customers.length;
    	int sum[]=new int [N];//前缀和，sum[i] 表示 从0~i中原本被老板气走的customer总数
        int right=X;
        sum[0]= grumpy[0]==0?0:customers[0];
        for(int i=1;i<N;i++) {
        	if(grumpy[i]==1)
        		sum[i]=sum[i-1]+customers[i];
        	else
        		sum[i]=sum[i-1];
        	
        }
        int Max =sum[X-1];//Max是固定窗口大小内，可以挽留住的客人的最大值
        int Maxi=0,Maxj=X-1;
        while(right<N) {
    		if(sum[right]-sum[right-X]>Max) {
    			Max=sum[right]-sum[right-X];
    			Maxi=right-X+1;
    			Maxj=right;
    		}
        	right++;
        }
        for(int i=Maxi;i<=Maxj;i++)
        	grumpy[i]=0;
        
        int psg=0;
        int i=0;
        while(i<N) {
        	psg+= grumpy[i]==1? 0:customers[i];
        	i++;
        }
    	
    	return psg;
    }
}

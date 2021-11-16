package lanqiao.year2018_9th;


public class P04_方格计数 {
	public static void main(String[] args) {
		int count=0;
		int n=2000;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (Is_inside(i, j)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}//main
	
	public static boolean Is_inside(int i,int j) {
		if(Math.sqrt(Math.pow(1000-i, 2)+Math.pow(1000-j, 2))>1000)
		return false; 
		if (Math.sqrt(Math.pow(1000-(i-1), 2)+Math.pow(1000-(j), 2))>1000) 
		return false;
		if(Math.sqrt(Math.pow(1000-(i-1), 2)+Math.pow(1000-(j-1), 2))>1000)
		return false;
		if(Math.sqrt(Math.pow(1000-(i), 2)+Math.pow(1000-(j-1), 2))>1000)
		return false;
		return true;
	}

}

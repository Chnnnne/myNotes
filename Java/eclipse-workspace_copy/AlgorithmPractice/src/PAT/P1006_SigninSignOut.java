package PAT;

import java.io.IOException;

public class P1006_SigninSignOut {
	static String inTime,mininTime;
	static String outTime,maxoutTime;
	static String id,minId,maxId;
	public static void main(String[] args) throws IOException {
		int M=Reader.nextInt();
		id=Reader.next();
		minId=id;
		maxId=id;
		mininTime=Reader.next();
		maxoutTime=Reader.next();
		while(M--!=1) {
			id=Reader.next();
			inTime=Reader.next();
			outTime=Reader.next();
			Compare();
		}
		System.out.print(minId+" "+maxId);

	}//main

	private static void Compare() {
		String[] in = inTime.split(":");
		String[] out = outTime.split(":");
		String[] minIn = mininTime.split(":");
		String[] maxOut = maxoutTime.split(":");
		for(int i=0;i<3;i++) {
			if(Integer.parseInt(in[i])<Integer.parseInt(minIn[i])) {
				mininTime=inTime;
				minId=id;
				break;
			}
		}
		for(int i=0;i<3;i++) {
			if(Integer.parseInt(out[i])>Integer.parseInt(maxOut[i])) {
				maxoutTime=outTime;
				maxId=id;
				break;
			}
		}
	}
}

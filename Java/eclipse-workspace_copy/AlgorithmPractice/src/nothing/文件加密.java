package nothing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class 文件加密 {

	
	
	
	public static void main(String[] args) throws IOException {
//		encode();
		decode();
	}//main

	private static void decode() throws IOException {
		byte myPassword=9;
		FileInputStream fis = new FileInputStream("C:\\Users\\95266\\Desktop\\nothing.txt");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\95266\\Desktop\\secret_back.mp4");
		
	 	byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b))!=-1) {
        	for(int i=0;i<len;i++) {
        		b[i]=(byte) (b[i]^myPassword);
        	}
            fos.write(b, 0 , len);
        }

        fos.close();
        fis.close();
	}

	private static void encode() throws IOException {
		byte myPassword=9;
		FileInputStream fis = new FileInputStream("C:\\Users\\95266\\Desktop\\secret.mp4");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\95266\\Desktop\\nothing.txt");
		
	 	byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b))!=-1) {
        	for(int i=0;i<len;i++) {
        		b[i]=(byte) (b[i]^myPassword);
        	}
            fos.write(b, 0 , len);
        }

        fos.close();
        fis.close();
	}
}

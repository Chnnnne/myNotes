package leetcode.February;

public class P0006_Z字型变换 {
	public static void main(String[] args) {
		System.out.println(new P0006_Z字型变换().convert("ABC", 1));

	}//main
	
    public String convert(String s, int numRows) {
    	if(numRows==1) return s;
    	StringBuilder []rows= new StringBuilder[numRows+1];
    	for (int i = 1; i < rows.length; i++) {
			rows[i]=new StringBuilder();
		}
    	int curRow=1;
    	boolean godown=true;
    	for (int i = 0; i < s.length(); i++) {
    		rows[curRow].append(s.charAt(i));
    		if(godown) {
    			curRow++;
    			if(curRow==numRows+1)
    			{
    				godown=false;
    				curRow-=2;
    			}
    		}else {
				curRow--;
				if(curRow==0) {
					godown=true;
					curRow+=2;
				}
			}
				
		}
    	StringBuilder ret=new StringBuilder();
    	for (int i = 1; i < rows.length; i++) {
			ret.append(rows[i]);
		}
    	
    	return ret.toString();
    }
}

package algorithm.递归与分治;

/*
 * 对一个大小为size*size的棋盘，给出一个残缺点，然后用L棋子填充剩下的棋盘位置，
 * 分治（递归）的思想：
 * 1、递归方程：将棋盘分成四等分，对于不含残缺点的子棋盘，其边角用L棋子覆盖后再递归
 * 若含残缺点，则直接递归该子棋盘
 * 2、结束条件：棋盘大小为1时
 */
public class 棋盘覆盖 {
	static int MaxSize=16;//棋盘最大长度
	static int Board[][]=new int[MaxSize+1][MaxSize+1];//index from 1
	static int num=1;//使用的L棋子
	/**
	 * 
	 * @param tr	棋盘左上角 row
	 * @param tc	棋盘左上角 col
	 * @param size	棋盘长度
	 * @param dr	残缺点 row
	 * @param dc	残缺点 col
	 */
	public static void ChessBoard(int tr,int tc,int size,int dr,int dc) {
		if(size==1) {
			return;//size=1时，在上一层递归时已经完成填充，无序再做任何操作
		}
		else {
			int numL=num++;
			int sizeZi=size/2;
			//①左上角
			if(dr<tr+sizeZi&&dc<tc+sizeZi) 
				ChessBoard(tr, tc, sizeZi, dr, dc);
			else {
				Board[tr+sizeZi-1][tc+sizeZi-1]=numL;
				ChessBoard(tr, tc, sizeZi, tr+sizeZi-1, tc+sizeZi-1);
			}
			//②右上角
			if(dr<tr+sizeZi&&dc>=tc+sizeZi)
				ChessBoard(tr, tc+sizeZi, sizeZi, dr, dc);
			else {
				Board[tr+sizeZi-1][tc+sizeZi]=numL;
				ChessBoard(tr, tc+sizeZi, sizeZi, tr+sizeZi-1, tc+sizeZi);
			}
			//③左下角
			if(dr>=tr+sizeZi&&dc<tc+sizeZi)
				ChessBoard(tr+sizeZi, tc, sizeZi, dr, dc);
			else {
				Board[tr+sizeZi][tc+sizeZi-1]=numL;
				ChessBoard(tr+sizeZi, tc, sizeZi, tr+sizeZi, tc+sizeZi-1);
			}
			//④右下角
			if(dr>=tr+sizeZi&&dc>tc+sizeZi)
				ChessBoard(tr+sizeZi, tc+sizeZi, sizeZi, dr, dc);
			else {
				Board[tr+sizeZi][tc+sizeZi]=numL;
				ChessBoard(tr+sizeZi, tc+sizeZi, sizeZi, tr+sizeZi, tc+sizeZi);
			}
		}
	}
	public static void main(String[] args) {
		
		ChessBoard(1, 1, 8, 1, 1);
		for(int i=1;i<=8;i++) {
			for(int j=1;j<=8;j++)
				System.out.print(Board[i][j]+"\t");
			System.out.println();
		}
		
				

	}//main
	
}

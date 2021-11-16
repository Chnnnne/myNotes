package algorithm.数据结构;

import java.util.Scanner;

public class BiTree {
	public static void main(String[] args) {
		BiTree root = null;
		root=PreCreateBiTree(root);
		PostOrderTraverse(root);
	}//main
	

	int value;
	BiTree lchild=null;
	BiTree rchild=null;
	
	public BiTree() {
		
	}
	//从任意结点开始，先创根节点，再创左子树、右子树
	public static BiTree PreCreateBiTree(BiTree T) {
		//此代码原本有bug 
		//幻想的是传入root(初值为null，然后赋值形参，从而root指向一个对象)
		//注意堆栈关系！！
		//返回根节点
		System.out.println("cin plz");
		int c = new Scanner(System.in).nextInt();
		if(c==0) {
			T=null;
			return null;
		}
		else {
			T=new BiTree();
			T.value=c;
			T.lchild=PreCreateBiTree(T.lchild);
			T.rchild=PreCreateBiTree(T.rchild);
			return T;
		}
	}
	
	public static void PreOrderTraverse(BiTree T) {
		if(T==null) return;
		visit(T);
		PreOrderTraverse(T.lchild);
		PreOrderTraverse(T.rchild);
	}
	//T为二叉树中任意的结点，一般初值为根结点
	public static void InOrderTraverse(BiTree T) {
		if(T==null) return;
		InOrderTraverse(T.lchild);
		visit(T);
		InOrderTraverse(T.rchild);
	}
	public static void PostOrderTraverse(BiTree T) {
		if(T==null) return;
		PostOrderTraverse(T.lchild);
		PostOrderTraverse(T.rchild);
		visit(T);
	}
	public static void visit(BiTree t) {
		System.out.println("Visit:"+t.value);
	}
}

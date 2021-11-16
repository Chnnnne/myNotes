package package04_1;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class J_GridLayout {
	public static void main(String args[])
	{
		JFrame app=new JFrame("网络布局管理器");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(520,120);
		Container c=app.getContentPane();
		c.setLayout(new GridLayout(2,5));
		String s;
		JButton b;
		for(int i=0;i<5;i++)
		{
			s="按钮"+(i+1);
			b=new JButton(s);
			c.add(b);
		}
		app.setVisible(true);
	}
}

package package04_1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class J_Borderlayout {
	public static void main(String args[])
	{
		JFrame app=new JFrame("边界布局管理器例程");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(360,130);
		Container c = app.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new JButton("东"),BorderLayout.EAST);
		c.add(new JButton("西"),BorderLayout.WEST);
		c.add(new JButton("南"),BorderLayout.SOUTH);
		c.add(new JButton("北"),BorderLayout.NORTH);
		c.add(new JButton("中"),BorderLayout.CENTER);
		app.setVisible(true);
	}
}

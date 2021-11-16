package package04_1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.PopupMenu;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class J_FlowBoxLayout {
	public static void main(String args[])
	{
		JFrame app = new JFrame("组合布局方式例程");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(215,150);
		Container c = app.getContentPane();
		c.setLayout(new FlowLayout());
		JPanel [] p= new JPanel[3];
		int i;
		for(i=0;i<3;i++)
		{
			p[i]=new JPanel();
			p[i].setLayout(new BoxLayout(p[i], BoxLayout.X_AXIS));
			c.add(p[i]);
		}
		String s;
		JButton b;
		int []pj= {0,1,1,2,2,2};
		for(i=0;i<6;i++)
		{
			s="按钮"+(i+1);
			b=new JButton(s);
			p[pj[i]].add(b);
		}
		app.setVisible(true);
	}
}

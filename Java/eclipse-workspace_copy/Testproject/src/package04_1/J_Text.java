package package04_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class J_Text {
	public static void main(String args [])
	{
		JFrame app=new JFrame("文本编辑框例程");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(320,120);
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout());
		JTextField [] t= {
				new JTextField("用户名",8),
				new JTextField("显示",15),
				new JTextField("密码文本：",8),
				new JPasswordField("隐藏",15)
				
		};
		t[0].setEditable(false);
		t[2].setEditable(false);
		for(int i=0;i<t.length;i++)
		{
			c.add(t[i]);
		}
		app.setVisible(true);
	}
}

package package04_1;

import java.awt.Container; 
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class J_Lines extends JFrame{

	public J_Lines() 
	{
		super("多行组件例程");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		String[] s= {"选项1","选项二","选项三" };
		JComboBox cb=new JComboBox(s);
		c.add(cb);
		JList t=new JList(s);
		c.add(t);
		JTextArea ta=new JTextArea("啦啦啦啦啦么么么么么哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈\n2\n3\n4\n5", 3, 10);
		JScrollPane sta=new JScrollPane(ta);
		c.add(sta);
	}
	public static void main(String [] args)
	{
		J_Lines app=new J_Lines();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(450,120);
		app.setVisible(true);
	}
	
	
}

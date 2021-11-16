package package04_1;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.FlowLayout;

public class J_FrameDialog {
	public static void main(String []argc)
	{
		JFrame app=new JFrame("这里是框架");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(300,200);
		
		Container cF= app.getContentPane();
		cF.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l=new JLabel("这里是框架里的标签内容");
		cF.add(l);
		app.setVisible(true);
		
		JDialog d=new JDialog(app,"这里是依赖于父框架对话框",true);
		Container c=d.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		c.add(new JLabel("这里是对话框里的标签内容"));
		c.add(new JLabel("需要关闭本对话框才能返回父框架"));
		d.setSize(250,200);
//		d.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);		不能加 否则错误！！！！
		d.setVisible(true);
		
//		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		app.setSize(300,200);
//		app.setVisible(true);
	}
}

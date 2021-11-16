package package04_1;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class J_Button extends JFrame{
	public J_Button()
	{
		super("按钮例程");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		ImageIcon [] ic= {
				new ImageIcon(".\\src\\pic\\left.jpg"),
				new ImageIcon(".\\src\\pic\\right.jpg")
		};
		JButton [] b= {
				new JButton("左",ic[0]),
				new JButton("中间"),
				new JButton("右",ic[1])
		};
		
		for(int i=0;i<b.length;i++)
			c.add(b[i]);
		
		JCheckBox [] ck= {
				new JCheckBox("左"),
				new JCheckBox("右")
		};
		for(int i=0;i<ck.length;i++)
			{
			c.add(ck[i]);
			ck[i].setSelected(true);
			}
		
		JRadioButton [] r= {
				new JRadioButton("左"),
				new JRadioButton("右")
		};
		ButtonGroup rg=new ButtonGroup();
		for(int i=0;i<r.length;i++)
		{
			c.add(r[i]);	
			rg.add(r[i]);
		}
		
		r[0].setSelected(true);
		r[1].setSelected(false);
	}
	
	public static void main(String []args)
	{
		J_Button app=new J_Button();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(260,150);
		app.setVisible(true);
	}

}

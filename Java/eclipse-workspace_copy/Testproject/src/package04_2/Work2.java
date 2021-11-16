package package04_2;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Work2 extends JFrame {
	public static void main(String []args)
	{
		JFrame f=new JFrame("8.7题");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(250,150);
		Container c= f.getContentPane();
		c.setLayout(new FlowLayout());
		JButton [] buttons = {
				new JButton("按钮1"),
				new JButton("按钮2"),
				new JButton("按钮3"),
				new JButton("按钮4"),
				new JButton("按钮5"),
				new JButton("按钮6")
		};
		c.add(buttons[0]);
		c.add(buttons[1]);
		c.add(buttons[2]);

		
		
		JButton j1=new JButton("  ");
	        j1.setContentAreaFilled(false);
	  	j1.setBorderPainted(false);
		j1.setEnabled(false);
			
		c.add(j1);
		c.add(buttons[3]);
		JButton j2=new JButton("       ");
        j2.setContentAreaFilled(false);
        j2.setBorderPainted(false);
        j2.setEnabled(false);
		
        c.add(j2);
		c.add(buttons[4]);
		c.add(buttons[5]);
		
		f.setVisible(true);
	}
}

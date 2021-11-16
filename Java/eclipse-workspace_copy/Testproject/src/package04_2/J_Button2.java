package package04_2;

import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class J_Button2 extends JFrame{

	public J_Button2() {
		super("动作事件例程—匿名内部类版本");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(100,80);
		Container c=getContentPane();
		
		JButton b=new JButton();
		b.setText("单击0次了");
		b.addActionListener(new ActionListener() {
			int m_count=0;
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton a=	(JButton)e.getSource();
				a.setText("单击"+(++m_count)+"次了");
				if(m_count==10)
				{
					JOptionPane.showMessageDialog(null, "宁都点击10下了 不累吗？");
				}
			}
		});
		c.add(b);
		
		setVisible(true);
	}
	
	public static void main(String [] args)
	{
		J_Button2 app=new J_Button2();
	}
	
}

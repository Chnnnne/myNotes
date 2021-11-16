package package04_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




//监听器接口的实现类  
class J_ActionListener implements ActionListener
{
	int m_count=0;

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		m_count++;
		JButton b= (JButton) e.getSource();
		b.setText("单击"+m_count+"次");
		if(m_count==20)
		{
			JOptionPane.showMessageDialog(null, "宁都点了20下了？ 不累吗？", "用户您好", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}



public class J_Button1 extends JFrame
{
	//构造函数
	public J_Button1()
	{
		super("动作事件例程");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(100,80);
		Container c=getContentPane();
		
		JButton b=new JButton("单击0次");
		
		J_ActionListener a=new J_ActionListener();
		
		b.addActionListener(a);
		
		c.add(b,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	
	public static void main(String []args)
	{
		J_Button1 app=new J_Button1();
//		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		app.setSize(100,80);
//		app.setVisible(true);
		
		
	}
	
}

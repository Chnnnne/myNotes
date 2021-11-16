package package04_2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;







public class Demo_Password extends JFrame {
	
	public Demo_Password() {
		super("登录");
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,150);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		JTextField [] t= {
				new JTextField("用户名",8),
				new JTextField("",15),
				new JTextField("密码文本：",8),
				new JPasswordField("",15)
				
		};
		
		t[0].setEditable(false);
		t[2].setEditable(false);
		for(int i=0;i<t.length;i++)
		{
			c.add(t[i]);
		}
		
		
		String USERNAME="wangchen";
		String PASSWORD="cc952952952";
		JButton y=new JButton("确认"); 
		y.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=t[1].getText();
				String password=t[3].getText();
				if(USERNAME.equals(username)&&PASSWORD.equals(password))
				{
					JOptionPane.showMessageDialog(null, "         恭喜宁\n用户名密码匹配成功");
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "         告辞！！\n用户名密码匹配失败");
					System.exit(0);
				}
				
			}
		});
		JButton n=new JButton("取消"); 
		
		c.add(y);c.add(n);
		
		setVisible(true);
	}
	
	
	public static void main(String []args)
	{
		Demo_Password app=new Demo_Password();
	}

}

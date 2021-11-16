package package04_1;

import java.awt.FlowLayout;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class J_LabelFrame extends JFrame{
	public J_LabelFrame()
	{
		super("框架和标签例程");
		String [] s= {"文本标签","文字在图标的左侧","文字在图标的下方"};
		ImageIcon [] ic= {null,new ImageIcon(".\\src\\pic\\left.jpg"),new ImageIcon(".\\src\\pic\\right.jpg")};
		int []ih= {0,JLabel.LEFT,JLabel.CENTER}; 	//水平方向
		int []iv= {0,JLabel.CENTER,JLabel.BOTTOM};	//竖直方向
		 
		java.awt.Container c=getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));//流式分布  按行从左到右 并且设置为左对齐
		for(int i=0;i<3;i++)
		{
			JLabel aLabel =new JLabel(s[i],ic[i],JLabel.RIGHT);//指定文字与图片水平方向上的对齐方式
			if(i>0)
			{
				aLabel.setHorizontalTextPosition(ih[i]);
				aLabel.setVerticalTextPosition(iv[i]);
			}
			aLabel.setToolTipText("第"+(i+1)+"个标签");
			c.add(aLabel);
		}
				
	}
	
	public static void main(String args[])
	{
		J_LabelFrame app=new J_LabelFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(360,150);
		app.setVisible(true);
	}
	
		
		
}

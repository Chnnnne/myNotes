package package04_1;

import javax.swing.JOptionPane;



public class J_OptionPane {
	public static void main(String []args)
	{
		JOptionPane.showMessageDialog(null, "message","title",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showConfirmDialog(null,  "message");
		JOptionPane.showInputDialog(null,"message");
		String [] s= {"亚索","盲僧","石头人"};
		JOptionPane.showInputDialog(null,"message","title",JOptionPane.QUESTION_MESSAGE,null,s,s[0]);
	}
}

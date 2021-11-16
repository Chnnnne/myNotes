package package04_2;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Work1 extends JFrame{
 
	public static void main(String argc[]){
		JFrame jf = new JFrame("Sum");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(360, 100);
		
		Container c = jf.getContentPane();
		c.setLayout(new FlowLayout());
		
		JTextField [] t = {
				new JTextField(6),
				new JTextField(6),
				new JTextField(6)
		};
		
		JButton [] b = {
				new JButton("+"),
				new JButton("=")
		};
		
		c.add(t[0]);
		c.add(b[0]);
		c.add(t[1]);
		c.add(b[1]);
		c.add(t[2]);
		
		b[1].addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e){
				 t[2].setText(Integer.parseInt(t[0].getText()) + Integer.parseInt(t[1].getText())+"");
			 }
		});
 
		jf.setVisible(true);
	}
}
 
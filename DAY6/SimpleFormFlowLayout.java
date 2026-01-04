package DAY6;
import java.awt.*;
import javax.swing.*;

public class SimpleFormFlowLayout extends JFrame
{
	JLabel l1,l2;
	JTextField tf1,tf2;
	JButton b1,b2,b3;
	JFrame jf; //user defined frame- no need to code for windowClosing 

	
	SimpleFormFlowLayout()
	{
		jf=new JFrame("Flow layout Example!");
		jf.setSize(300,150);
		
		l1=new JLabel("Enter name: ");
		l2=new JLabel("Enter city: ");
		
		tf1=new JTextField(15);  //15 - is length of textfield-default=20
		tf2=new JTextField(15);
		
		b1=new JButton("Clear");
		b2=new JButton("Submit");
		b3=new JButton("Exit");
		
		jf.setLayout(new FlowLayout());
		
		//add elements on frame
		jf.add(l1);
		jf.add(tf1);
		
		jf.add(l2);
		jf.add(tf2);
		
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
		
		jf.setVisible(true);
		
		
	}

	public static void main(String[] args) {

 new SimpleFormFlowLayout();
	}

}

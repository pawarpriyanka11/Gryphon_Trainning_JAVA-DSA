package DAY6;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class CradLayoutUI extends JFrame implements ActionListener{
	JFrame jf;
	JPanel pp;
	CardLayout cd;
	
	CradLayoutUI()
	{
		jf=new JFrame("Card Layout Example!");
		cd=new CardLayout();
		
		
		//create a main parent panel that will contain two child panels.
		pp=new JPanel();
		
		//create two child panels.
		JPanel cp1=new JPanel();//numbers
		JPanel cp2=new JPanel();//alphabets

		//creating two parent buttons(numbers,alphabets)
		JButton b1=new JButton("Numbers");
		JButton b2=new JButton("Alphabets");
		
		//creating two child buttons(1,2,3
		JButton b3=new JButton("1");
		JButton b4=new JButton("2");
		JButton b5=new JButton("3");
		
		//adding b3,b4 & b5 to child panel 1(cp1).
		cp1.add(b3);
		cp1.add(b4);
		cp1.add(b5);

		//creating 4 child buttons
		JButton b6=new JButton("A");
		JButton b7=new JButton("B");
		JButton b8=new JButton("C");
		JButton b9=new JButton("D");
		
		//adding b6,b7,b8,b9 to child panel 2(cp2).
		cp2.add(b6);
		cp2.add(b7);
		cp2.add(b8);
		cp2.add(b9);
		
		//setting the positioning of the components in pp (that contains cp1 and cp2)
		//to cardLayout
		pp.setLayout(cd);
		
		//add child panels cp1,cp2 to parent panel pp
		pp.add(cp1,"Numbers");
		pp.add(cp2,"Alphabets");
		
		
		
		//eventListener
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		//Setting container JFrame's Layout to FlowLayout.
		jf.setLayout(new FlowLayout());
		
		//adding two parent buttons to JFrame, these buttons
		//will remain commonly visible to all panels.
		jf.add(b1);
		jf.add(b2);
		
		//adding pp to jf
		jf.add(pp);
		
		jf.setSize(300,200);
		jf.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand()=="Numbers")
		{
			cd.show(pp,"Numbers");
		}
		else
		{
			cd.show(pp,"Alphabets");	
		}
		
	}
	
	public static void main(String[] args) 
	{
		
		new CradLayoutUI();
	}

}

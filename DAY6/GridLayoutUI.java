package DAY6;
import java.awt.*;

import javax.swing.*;

public class GridLayoutUI extends JFrame{

	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	JFrame jf;
	GridLayoutUI()
	{
		jf=new JFrame("Grid layout Example!");
		jf.setSize(300,150);
		
		b1=new JButton("7");
		b2=new JButton("8");
		b3=new JButton("9");
		b4=new JButton("-");
		b5=new JButton("4");
		b6=new JButton("5");
		b7=new JButton("6");
		b8=new JButton("*");
		b9=new JButton("1");
		b10=new JButton("2");
		b11=new JButton("3");
		b12=new JButton("+");
		b13=new JButton(".");
		b14=new JButton("0");
		b15=new JButton("=");
		b16=new JButton("/");
		
		jf.setLayout(new GridLayout(4,4));
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
		jf.add(b4);
		jf.add(b5);
		jf.add(b6);
		jf.add(b7);
		jf.add(b8);
		jf.add(b9);
		jf.add(b10);
		jf.add(b11);
		jf.add(b12);
		jf.add(b13);
		jf.add(b14);
		jf.add(b15);
		jf.add(b16);
		
		jf.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
new GridLayoutUI();
	}

}

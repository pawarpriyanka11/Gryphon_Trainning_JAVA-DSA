package DAY6;
import java.awt.*;
import java.awt.event.*;

public class MouseListener23 extends Frame implements ActionListener{

	Button R,G,B;
	MouseListener23()
	{
		R=new Button("R");
		G=new Button("G");
		B=new Button("B");
		
		setLayout(new FlowLayout());
		add(R);
		add(G);
		add(B);
		
		R.addActionListener(this);
		G.addActionListener(this);
		B.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==R)
		{
			setBackground(Color.RED);
		}
		else if(ae.getSource()==G)
		{
			setBackground(Color.GREEN);
		}
		else
		{
			setBackground(Color.BLUE);
		}
	}
	
	public static void main(String[] args) {

		MouseListener23 op=new MouseListener23();
		
		op.setSize(350,350);
		op.setVisible(true);
		op.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
			
		});

	}

}

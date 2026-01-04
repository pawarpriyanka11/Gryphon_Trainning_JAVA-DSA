package DAY6;
import java.awt.*;

public class UIDesigninig extends Frame
{
	UIDesigninig()
	{
		Button b=new Button("Home");
		b.setBounds(30,100,80,30);
		add(b);
		setSize(300,300);
		setLayout(null);
		setVisible(true);
		
	}

	public static void main(String[] args)
	{
		 new UIDesigninig();

	}

}

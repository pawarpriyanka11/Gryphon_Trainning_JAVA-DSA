package DAY6;
import java.awt.*;
import java.awt.event.*;

//Listener interface use for event listener
/*
 * TYPES OF LISTENERS:
 * ActionListener
 * WindowListener
 * MouseListener
 * MouseMotionListener
 * KeyListener
 * TextListener
 * 
 * 
 * TYPES OF EVENTS
 * ActionEvent
 * WindowEvent
 * MouseEvent
 * MouseMotionEvent
 * KeyEvent
 * TextEvent
 * 
 * 
 * TYPES OF ADAPTER:
 * ActionAdapter
 * WindowAdapter
 * MouseAdapter
 * MouseAdapter
 * KeyAdapter
 * TextAdapter
 * 
 * when we don't want to use all the methods of any eventListener at that time we use adapter predefined class
 *  
 */
public class NewUIDesign extends Frame
{
	NewUIDesign()
	{
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		
		
		Label lb=new Label("Window Closing Example!");
		this.add(lb);
		setTitle("SCOE");
		setSize(300,300);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new NewUIDesign();

	}

}

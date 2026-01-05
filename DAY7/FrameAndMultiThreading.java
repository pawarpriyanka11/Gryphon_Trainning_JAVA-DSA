package DAY7;
import java.awt.*;
import java.awt.event.*;

class BookingSystem extends Thread
{

	static int avialable=10;
	private int seat;
	protected String user;
	BookingSystem(int seat, String user)
	{
	this.seat=seat;
	this.user=user;
	}
	public void run()
	{
		synchronized(BookingSystem.class){
			if(avialable>=seat)
			{
				FrameAndMultiThreading.ta.append(user+" booked "+seat+" seats\n");
				avialable=avialable-seat;
				
			}
			else
			{
				FrameAndMultiThreading.ta.append(user+" sorry not enough seats avialable\n");
			}
		}
	}
}



public class FrameAndMultiThreading extends Frame implements ActionListener{
	Label l1,l2,l3;
	TextField tfName,tfSeats;
	Button b1;
	static TextArea ta;

	FrameAndMultiThreading()
	{
	  setTitle("Multithreading seat booking");
	  setSize(500,350);
	  setLayout(new FlowLayout());
	  
	  
	  
	  l1=new Label("Enter User Name: ");
	  tfName=new TextField(15);
	  
	  l2=new Label("Enter seats to book(comma separated): ");
	  tfSeats=new TextField(20);
	  
	  b1=new Button("Book seats");
	  
	  ta=new TextArea(10,45);
	  ta.setEditable(false);
	  
	  l3=new Label("Enter seat numbers separated by commas, eg. 2,8,4,3");
	  
	  add(l1);
	  add(tfName);
	  
	  add(l2);
	  add(tfSeats);
	  
	  add(b1);
	  add(l3);
	  add(ta);
	  
	  b1.addActionListener(this);
	  setVisible(true);
	  
	  addWindowListener(new WindowAdapter(){
		 public void windowClosing(WindowEvent we)
		 {
			 System.exit(0);
		 }


	  });
	}
	  
	  public void actionPerformed(ActionEvent ae)
	  {
		  try{
			  String baseName=tfName.getText().trim();
			  String[] seatArray=tfSeats.getText().trim().split(",");
			  
			  for(int i=0;i<seatArray.length;i++)
			  {
				  int seat=Integer.parseInt(seatArray[i].trim());
				  String UserName=baseName+" : Thread : "+(i+1);
				  
				  BookingSystem op=new BookingSystem(seat,UserName);
				  op.start();
				  
			  }
			  l3.setText("Booking request send for "+seatArray.length+ " threads");
			  
		  }catch(NumberFormatException nfe)
		  {
			  l3.setText("Error: please enetr valid seat numbers separated by commas");
		  }
	  }
	  
	  
	  
	  
	  
	
	
	public static void main(String[] args) {
		new FrameAndMultiThreading();
		
		
	 
	}

}

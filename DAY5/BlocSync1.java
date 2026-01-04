package DAY5;
import java.util.*;


/*
 * HINT FOR MULTITHREADING: 
 * In the java programming language every object have only one key 
 * and this key is given to only one thread at the time.
 * 
 * 
 * 
 */
class BookSeats {

	int avaialble=10;
	public int seat;
	void printing(int seat)
	{
		System.out.println("Hello: "+Thread.currentThread().getName());
		System.out.println("Hello: "+Thread.currentThread().getName());
		System.out.println("Hello: "+Thread.currentThread().getName());
		
		synchronized(this)
		{
			String name=Thread.currentThread().getName();
			
			if(avaialble>=seat)
			{
				System.out.println("------seats are booked:"+name);
				avaialble-=seat;
				System.out.println("------seats are avaialable:"+avaialble);
				
				
			}
			else
			{
				System.out.println("------sorry"+name);
				System.out.println("------seats are avaialable:"+avaialble);
				
			}
		}
		
		System.out.println("Bye: "+Thread.currentThread().getName());
		System.out.println("Bye: "+Thread.currentThread().getName());
		System.out.println("Bye: "+Thread.currentThread().getName());
	}
}
public class BlocSync1 extends Thread {
	int seat;
	static BookSeats op;
	public BlocSync1(BookSeats op2) {
		// TODO Auto-generated constructor stub
	}
	public void run()
	{
		op.printing(seat);
	}
	public static void main(String[] args) 
	{
		op=new BookSeats();
		
		BlocSync1 t1=new BlocSync1(op);
		BlocSync1 t2=new BlocSync1(op);
		
		t1.setName("Priyanka");
		t2.setName("Pratiksha");
			
	    t1.seat=6;
	    t2.seat=7;
	    
	    t1.start();
	    t2.start();
	    
	    
				

	}


}

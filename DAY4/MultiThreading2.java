package DAY4;
import java.lang.*;

class Bus extends Thread
{
	int s;
	int avail=5;
	Bus(int s)
	{
		this.s=s;
	}
	public synchronized void run()
	{
		String name=Thread.currentThread().getName();
		if(avail>=s)
		{
			System.out.println(name+" seats are booked");
			avail-=s;
		}
		else
		{
			System.out.println(name+ " sorry");
		}
	}
	
}
public class MultiThreading2 {

	public static void main(String[] args) {
		Bus op=new Bus(2);
		
		Thread t1=new Thread(op);
		Thread t2=new Thread(op);
		Thread t3=new Thread(op);
		
		t1.setName("A");
		t2.setName("B");
		t3.setName("C");
		
		t1.start();
		t2.start();
		t3.start();

	}

}

package DAY4;
import java.lang.*; // optional
/*
 * SEVEN STEPS: 
 * step 1: import the java.lang package.
 * step 2: A)By extending Thread class.
 *         B)By implementing Runnable interface(Best Approach-security purpose.
 * step 3: initialize the run() method.
 * step 4: give the public access to the run method
 * step 5: implementing the run() method OR application. 
 * step 6: create the number of users or threads,
 * step 7: start the threads(call the start() method).
 * 
 * 
 * STEPS IN JAVA THREAD: 
 * 1) new/born
 * 2) ready 
 * 3) execution
 * 4) waiting/block
 * 5) dead
 * 
 * 
 * 
 */
class MultiThreading001 extends Thread
{
	public void run()
	{
		try{
			for(int i=1;i<3;i++)
			{
				System.out.println("Bye");
				Thread.sleep(2000);
			}
		}
		catch(InterruptedException e){
			
		}
	}
}
public class MultiThreading1 {

	public static void main(String[] args) {
		MultiThreading001 op=new MultiThreading001();
		op.start();
		try{
			for(int i=1;i<3;i++)
			{
				System.out.println("hello");
				Thread.sleep(2000);
			}
		}
		catch(InterruptedException e){
			
		}
	
	}

}

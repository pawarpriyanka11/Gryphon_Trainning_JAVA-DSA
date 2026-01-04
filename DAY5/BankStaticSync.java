package DAY5;
import java.util.*;
 
/*
 * POINTS: 
 * 1) Multithreading:
 * Multithreading is a process to execute multiple threads
 * at the same time without dependency of other threads.
 * 
 * 2)Thread:
 * Thread is predefined class which is available in java.lang package.
 * Thread is a basic unit of CPU and it is well known for independent execution.
 * 
 * 3)How to create Thread in java:
 * a.extends Thread class
 * b.Implement runnable interface(best for security).
 * 
 * 4)phases of thread
 * a. new state/born
 * b. runnable/ready
 * c. running/execution
 * d. waiting/block- sleep ,wait, suspend, joints
 * e. exit/dead
 * 
 * 5)Synchronization:
 * Synchronization is a technique through which we can control multiple threads
 * or among the number of threads that means only
 * one thread which enter inside the synchronized area
 * 
 * the main purpose of synchronization is 
 * to overcome the problem of multithreading
 * (problem- when multiple thread trying to access same resources at the same time)
 * on that situation it may provide some wrong or currupted result.
 * 
 * 
 * Synchronization is broadly classified into two categories:
 * method level
 * block level
 * 
 * problems with multithreading:
 * multithreading is very good whenever we want to complete our task as soon as possible
 * but in some situations
 * it may provide some wrong result  or corrupted data
 * this situation is occur when an same resuorece is accesible by multiple threads at the same time.
 * 
 * 
 * Method level Synchronization:
 * in method level synchronization the entire method gets synchronized so 
 * only one thread with enter inside synchronized area and remaining all the thread will wait method level
 * 
 * 
 * Blocklevel sync:
 * entire method is not get sync only the part of method get sync
 * we have to enclosed those few lines of the code put inside synchronized block
 * 
 * 
 * NOTE:
 * In the java programming language every object have only one key 
 * and this key is given to only one thread at the time.
 * 
 * 
 * Static Synchronization:
 * as we know every object has a only one key java and this key can be given to only one thread
 * but if we have multiple objects then we can also have multiple keys and
 * this key can be given multiple threads at all the time so again
 * we will get corrupted data even in the synchronized area thats why we 
 * use the static concept because static deals with class not with object and 
 * this concept is called static Synchronization
 *  
 * 
 */

class Bank {

	static int avaialble=5000;
	public int amount=2000;
	void printing()
	{
			String name=Thread.currentThread().getName();		
			if(avaialble>=amount)
			{
				System.out.println("sucess "+name);
				avaialble-=amount;
			}
			else
			{
				System.out.println("sorry "+name);
			}
	}
}
public class BankStaticSync extends Thread {
	static Bank op;
	
	public BankStaticSync(Bank op2) {
		op=op2;
	}
	public void run()
	{
		run1();
	}
    static synchronized void run1()
	{
		op.printing();
	}
	public static void main(String[] args) 
	{
		op=new Bank();
		
		BankStaticSync t1=new BankStaticSync(op);
		BankStaticSync t2=new BankStaticSync(op);
		Bank op2=new Bank();
		BankStaticSync t3=new BankStaticSync(op2);
		BankStaticSync t4=new BankStaticSync(op2);
		t1.setName("Priyanka");
		t2.setName("Pratiksha");
		t3.setName("Akanksha");
		t4.setName("Sanksruti");
	    t1.start();
	    t2.start();
	    t3.start();
	    t4.start();

	}


}

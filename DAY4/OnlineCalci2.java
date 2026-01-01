package DAY4;


class Print{
	
	 synchronized void printTbale(int n)
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(i*n);
		}
	}
}
class Five extends Thread
{
	Print F;
	Five(Print op)
	{
		F=op;
	}
	public void run()
	{
		F.printTbale(5);
	}
}
class Seven extends Thread
{
	Print S;
	Seven(Print op)
	{
		S=op;
	}
	public void run()
	{
		S.printTbale(7);
	}
}
public class OnlineCalci2 {

	public static void main(String[] args) {
		Print op=new Print();
		
		//threads
		Five t1=new Five(op);
		Seven t2=new Seven(op);
		
		t1.start();
		t2.start();
	}

}

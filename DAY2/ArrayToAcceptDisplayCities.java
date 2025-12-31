package DAY2;
import java.util.*;

public class ArrayToAcceptDisplayCities {




	
	public static void main(String[] args) {
	int i,n;
	String cn;
	
	Collection c=new ArrayList();
	Scanner sc=new Scanner(System.in);
	
	System.out.println("\nEnter the number of cities: ");
	n=sc.nextInt();
	
	for(i=0;i<=n;i++)
	{
	
		System.out.println("Enter "+i+" city: ");
		cn=sc.next();
		c.add(cn);//add city in arraylist
	}
	System.out.println("\nYour City name: "+c);
	
	

	}

}

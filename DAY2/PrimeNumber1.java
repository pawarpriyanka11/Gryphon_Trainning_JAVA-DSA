package DAY2;
import java.util.*;

public class PrimeNumber1 {
	
	public static void main (String[] args)
	{
		int i ;
		int n = 40 ;
		int temp = 0;
		
		for ( i = 2 ; i <= n ; i++)
		{
			System.out.println(i+" "+ isPrime(i));
		}
	}
	
	static boolean isPrime(int num)
	{
		 
		if(num <= 1)
		{
			return false;
		}
		int i=2;
		while(i*i <= num)
		{
			if(num%i==0)
			{
				return false;
			}
			i++;
			 
		}
		return true;
		
	}
}
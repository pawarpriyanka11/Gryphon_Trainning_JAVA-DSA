package DAY3;

import java.util.*;

public class FormUsingNestedIfElse {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\nEnter your gender: ");
		boolean gender;
		int age = 0;
		gender=sc.nextBoolean();//true-male,false-female
		String category;//OPEN or OBC
		double income;
		String state;
		
		

		if(gender==true)
		{
			System.out.println("\nEnter your age: ");
			age=sc.nextInt();
			if(age>=18)
			{
				System.out.println("\nEnter your category: ");
				category=sc.nextLine();
				sc.next();
				if(category=="obc"||category=="OBC")
				{
					System.out.println("You are eligible to get 50% scholorship!");
				}
				//category is Open
				else
				{
					System.out.print("\nEnter your yearly income: ");
					income=sc.nextDouble();
					if(income<=800000)
					{
						System.out.println("\nYou are eligible to get 50% scholorship!");
						
					}
					else
					{
						System.out.println("\nYou are eligible to get 25% scholorship!");
					}
				}
				
			}
//			age is less than 18
//			government schemes for your child
			else
			{
				if(age<=10)
				{
					System.out.println("\nYour child eligible for child health card policy!");
					
				}
				//age is greater than 10 and less than 18
				else
				{
					System.out.println("\nEnter your state: ");
					state=sc.nextLine();
					sc.next();
					if(state=="maharashtra"&&age!=0)
					{
						System.out.println("\nYour child eligible for free primary eductaion!");
					}
					else
					{
						System.out.println("\nYour child get 50% discount on primary eductaion!");	
					}
					
				}
			}
		}
		
		
		
		//for female
		else
		{
			
			if(age<18)
			{
				System.out.println("\nEnter your category: ");
				category=sc.nextLine();
                sc.next();
				if(category=="obc"||category=="OBC")
				{
					System.out.println("You are eligible to get 100% scholorship!");
				}
				//category is Open
				else
				{
					
					System.out.print("\nEnter your yearly income: ");
					income=sc.nextDouble();
					if(income<=800000)
					{
						System.out.println("\nYou are eligible to get 75% scholorship!");
						
					}
					else
					{
						System.out.println("\nYou are eligible to get 50% scholorship!");
					}
				}	
			}
			else
			{
				if(age<=10)
				{
					System.out.println("\nYour child eligible for 100% child health care scheme!");
					
				}
				//age is greater than 10 and less than 18
				else
				{   
					System.out.println("\nEnter your state: ");
					state=sc.nextLine();
					sc.next();
					if(state=="maharashtra")
					{
						System.out.println("\nYour child eligible for free primary eductaion!");
					}
					else
					{
						System.out.println("\nYour child get 70% discount on primary eductaion!");	
					}
				}
			}
		}
		
	}

}



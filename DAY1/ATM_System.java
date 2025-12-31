package DAY1;
import java.util.*;//use for DSA and Scanner
import java.text.*;

class Account
{
	Scanner sc=new Scanner(System.in);
	
	//df1=current account
	DecimalFormat df1=new DecimalFormat("###,##0.00' Rupee'");//inside double quote it has format
	//df2=saving account
	DecimalFormat df2=new DecimalFormat("###,##0.00' Doller'");
	
	private int CN;
	private int PN;
	double CB=2000;//current account balance 
	double SB=1000;//saving account balance
	
	//Setters
	void setCustomerNumber(int CN)
	{
		this.CN=CN;
	}
	void setPINNumber(int PN)
	{
		this.PN=PN;
	}
	
	//Getters:it contains return keyword
	int getCustomerNumber()
	{
		return CN;
		
	}
	
	int getPINNumber()
	{
		return PN;
	}
	
	//method to check balance
	void getCurrentBalance()
	{
		System.out.println("\nCurrent Account Balance: "+ df1.format(CB));
	}
	void getSavingBalance()
	{
		System.out.println("\nSaving Account Balance: "+ df2.format(SB));
	}
	
	//input calculations
	void getCurrentWithdrawInput()
	{
		System.out.println("\nCurrent Account Balance: "+ df1.format(CB));
		System.out.println("Enter withdraw amount: ");
		double amount=sc.nextDouble();
		if((CB-amount)>=0)//CB>=amount
		{
			System.out.println("\nTransaction Successful");
			calcCurrentWithdraw(amount);//output calculations
			System.out.println("New Current Account Balance: "+ df1.format(CB));
			

		}
		else
		{
			System.out.println("\nInsufficient balance");
		}
	}
	
	double calcCurrentWithdraw(double amt)
	{
		CB=CB-amt;
		return CB;
	}

	
	//saving-Deposite
	void getSavingDepositeInput()
	{
		System.out.println("\nSaving Account Balance: "+ df2.format(SB));
		System.out.println("Enter withdraw amount: ");
		double amount=sc.nextDouble();
		if((SB+amount)>=0)//SB>=amount
		{
			System.out.println("\nTransaction Successful");
			calcSavingWithdraw(amount);//output calculations
			System.out.println("New Saving Account Balance: "+ df2.format(SB));
			

		}
		else
		{
			System.out.println("\nInvalid balance");
		}
	}
	
	double calcSavingWithdraw(double amt)
	{
		SB=SB+amt;
		return SB;
	}
	
	

	
	
}
class optionMenu extends Account
{
	Scanner sc=new Scanner(System.in);
	HashMap<Integer, Integer> data=new HashMap();//store data in the key-value pair
	
	
	
	void getLogin()
	{
		do{
			try{
				
				
				//Bank- customer data
				data.put(11111,111);//use to put data into database
				data.put(11112,222);
				data.put(11113,333);
				data.put(11114,444);
				data.put(11115,111);
				
				System.out.println("Welcome to the SCOE!!");
				
				System.out.print("Enter customer number: ");
				setCustomerNumber(sc.nextInt());//abstraction
				
				System.out.print("Enter customer PIN: ");
				setPINNumber(sc.nextInt());
				
				
				int P=getCustomerNumber();
				int Q=getPINNumber();
				
				
				if(data.containsKey(P)&&data.get(P)==Q)
				{
					//System.out.print("Login Successful!");
					getAccountType();
					
				}
				else
				{
					System.err.print("Invalid customer number or pin number ");
					System.err.println("Enter VALID customer number or PIN number ");
					
				}	
			}
			catch(InputMismatchException e)
			{
				System.err.println("\nEnter only numbers.");
				System.err.println("\nCharacters and symbols are not allowed.\n");
				sc.next();//buffer zone is created here
				getLogin();
			}
			
			
		}while(true);
		
	}
	
	
	
	void getAccountType()
	{
		System.err.println("\nAccount type: ");
		System.out.println("\n1.Current Account\n2.Saving Account\n3.Exit\n Choice: ");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			getCurrent();
			break;
			
		case 2:
			getSaving();
			break;
			
		case 3:
			System.out.println("\nThankyou for VISITING.");
			System.err.println("\nVISIT again");
			
			break;
			
		default:
			System.err.println("Invalid case!");
			System.out.println("Enter VALID CHOICE\n");
			getAccountType();//recursion
			break;
		}
		
	}
	
	
	void getCurrent()
	{
		System.err.println("\nCURRENT ACCOUNT ");
		System.out.println("\n1.Balance Enquiry\n2.Withdraw Money\n3.Deposite\n4.Exit\n CHOICE: ");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			getCurrentBalance();
			getAccountType();
			break;
		
		case 2:
			getCurrentWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			//getCurrentDepositeInput();
			//getAccountType();
			break;
			
		case 4:
			System.out.println("\nThankyou for VISITING.");
			System.err.println("\nVISIT again");
			break;
			
		default:
			System.err.println("Invalid case!");
			System.out.println("Enter VALID CHOICE\n");
			getCurrent();//recursion
			break;
		}
		
	}
	void getSaving()
	{
		System.err.println("\nSAVING ACCOUNT ");
		System.out.println("\n1.Balance Enquiry\n2.Withdraw Money\n3.Deposite\n4.Exit\n CHOICE: ");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			getSavingBalance();
			getAccountType();
			break;
		
		case 2:
			//getSavingWithdrawInput();
			//getAccountType();
			break;
			
		case 3:
			getSavingDepositeInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("\nThankyou for VISITING.");
			System.err.println("\nVISIT again");
			break;
			
		default:
			System.err.println("Invalid case!");
			System.out.println("Enter VALID CHOICE\n");
			getSaving();//recursion
			break;
		}
	}
	
	
	
}

public class ATM_System {
	public static void main(String[] args)
	{
		optionMenu rr=new optionMenu();
		//rr.getLogin();
		rr.getAccountType();
		
	}
	
}

package DAY5;

//Represents one element of the LinkedList.
class Node
{
	//stores the value of node
	int data;
	
	//stores the reference to the next node in the list
	//initially it is null
	Node next;
	
	//constructor to initialize a new node
	Node(int data)
	{
		//sets the node's data(hide)
		this.data=data;
		
		//Ensures it doesn't point to any other node initially
		this.next=null;
	}
}


//
class LinkedList
{
	//declares a class with head node that marks the start of the list.
	//head is initially null(i.e. list is empty).
	Node head;
	
	void add(int data)
	{
		//creates a new node using the node class constructor.
		Node newNode=new Node(data);
		
		
		//if the list is empty (head==null)
		//set the new node  as the head of the list.
		if(head==null)
		{
			head=newNode;
		}
		//if the list is not empty (head!=null)
	    //then start from the head node.
		else
		{
			
			Node current=head;
			
			//traverse the list until you find the last node(whose next is null)
			
			while(current.next!=null)
			{
				current=current.next;
			}
			
			//attach the new node to the end of the list.
			//updating the next pointer of the node.
			
			current.next=newNode;
		}
		
	}
	
	//print the list
	void print()
	{
		Node current=head;
		while(current!=null)
		{
			System.out.println(current.data+" ");
			current=current.next;
		}
	}
}

public class LinkedList3 {
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		System.out.println("Our list data: ");
		list.print();
		
		
	}
	
	

}

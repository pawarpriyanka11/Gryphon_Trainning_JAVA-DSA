	package DAY6;
	
	// use floyd's algorithm to detect the cycle
	// cycle detection
	
	class Node {
	    int data;
	    Node next;
	
	    Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}
	
	public class LinkedList22 {
	
	    public static void main(String[] args) {
	
	        // create head
	        Node head = new Node(1);
	
	        // create nodes
	        head.next = new Node(2);
	        head.next.next = new Node(3);
	        head.next.next.next = new Node(4);
	        head.next.next.next.next = new Node(5);
	
	        // create a cycle: node 5 points back to node 2
	        head.next.next.next.next.next = head.next;
	
	        boolean hasCycle = detectCycle(head);
	        System.out.println("if list has cycle or not: "+hasCycle);
	        printList(head);
	    }
	
	    static boolean detectCycle(Node head) {
	        // initialize two pointers (slow & fast)
	        Node slow = head;
	        Node fast = head;
	
	        while (fast != null && fast.next != null) {
	            slow = slow.next;         // 1 step
	            fast = fast.next.next;   // 2 steps
	
	            if (slow == fast) {
	            	//remove cycyle
	            	removeCycle(slow,head);
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    static void removeCycle(Node meetingPoint,Node head)
	    {
	    	
	    	//start the pointer from the head and use the meeting point from the cycle
	    	Node start=head;
	    	
	    	
	    	//move both pointer one step at a time until
	    	//there .next reference match.
	    	
	    	//this identifies the node just before cycle
	    	//the start of the cycle
	    	while(start.next!=meetingPoint.next){
	    		start=start.next;
	    		meetingPoint=meetingPoint.next;
	    	}
	    	
	    	//break the cycle by setting .next of the last node to null
	    	meetingPoint.next=null;
	    	
	    }
	
	    static void printList(Node head) {
	        Node current = head;
	        while (current != null) {
	            System.out.println(current.data);
	            current = current.next;
	        }
	    }
	}

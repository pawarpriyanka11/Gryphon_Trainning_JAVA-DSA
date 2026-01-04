package DAY5;
import java.util.*;

public class LargeHistogArea {


	
	 static int Histogram(Stack<Integer> s1) {
		    Stack<Integer> s2 = new Stack();
		    int Max=0;
			int n=s1.size();
			int width;
			int curr;
			int next;
			int max;
			try {
				
				for(int i=0;i<n;i++) {
				width=1;
				if(s1.isEmpty()) {return Max;}
				curr = s1.peek();
				s1.pop();
				max=curr*width;
				Max=Math.max(Max, max);
				
				
				while(!s1.isEmpty()) {
					width++;
					next=s1.peek();
					curr=Math.min(curr, next);
					max=curr*width;
					Max=Math.max(Max, max);
					s2.push(s1.pop());
				}
				
				
				width=1;
				if(s2.isEmpty()) {return Max;}
				curr = s2.peek();
				s2.pop();
				max=curr*width;
				Max=Math.max(Max, max);
				
				while(!s2.isEmpty()) {
					width++;
					next=s2.peek();
					curr=Math.min(curr, next);
					max=curr*width;
					Max=Math.max(Max, max);
					s1.push(s2.pop());
				}
				}
				
			
			}catch(EmptyStackException e) {
				System.out.println(e);
			}
				
		 
		 
		 
		 
		 return Max;
	}
		
	public static void main(String args[]) {
		Stack<Integer> s1 = new Stack();
		
		s1.push(1);
		s1.push(10);
		s1.push(1);
		
		System.out.println("Max Area: "+Histogram(s1));
		
		
		
		
	}
}

package DAY5;
import java.util.*;

public class StackQuestion1 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		System.out.println("Is stack empty: "+stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		System.out.println("Our stack is: "+stack);
		System.out.println("Top of stack is: "+stack.peek());
		System.out.println("Deleted element is: "+stack.pop());
		System.out.println("Our stack is: "+stack);
		System.out.println("Top of stack is: "+stack.peek());
		System.out.println("Is stack empty: "+stack.isEmpty());
		System.out.println("Number of element in stack: "+stack.size());

	}

}

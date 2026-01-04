package DAY5;
import java.util.*;
/*
 * sort a stack using another temp stack
 * sort the elements of stack in ascending order using stack operation only
 */
public class StackQuestion2 {
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack();
		Stack<Integer> temp = new Stack();
		stack.push(34);
		stack.push(3);
		stack.push(31);
		stack.push(98);
		stack.push(92);
		stack.push(23);
		System.out.println("Stack in acsending order: "+stack);
		
		while(!stack.empty())
		{
			int current=stack.pop();
			while(!temp.isEmpty()&&temp.peek()>current)
			{
				stack.push(temp.pop());
			}
			temp.push(current);
		}
		
		while(!temp.empty()){
			stack.push(temp.pop());
		}
		
		System.out.println("Stack in acsending order: "+stack);
	}

}

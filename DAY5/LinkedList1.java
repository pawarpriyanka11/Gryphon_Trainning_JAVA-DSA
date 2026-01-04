package DAY5;
import java.util.*;

public class LinkedList1 {
	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList();
		list.add("Mango");
		list.add("Banana");
		list.add("Apple");
		list.addFirst("Orange");
		list.addLast("Cherry");
		list.add("Kiwi");
		
		list.remove("Apple");
		
		System.out.println("fruits: "+list);
		System.out.println("First fruit: "+list.getFirst());
		System.out.println("Last fruit: "+list.getLast());
		
		System.out.println();
		for(String f:list)
		{
			System.out.print(f+" ");
		}
		

	}

}

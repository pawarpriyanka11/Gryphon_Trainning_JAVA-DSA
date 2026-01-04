package DAY5;
import java.util.*;

/*
 * problem -2: reverse a linked list
 * 1. create linkedlist of int
 * 
 * 
 */

public class LinkedList2 {

	public static void main(String[] args) {
		//problem 1- reverse the linkedlist
//		LinkedList<Integer> list=new LinkedList(Arrays.asList(1,2,3,4,5));
//		System.out.println("input: "+ list);
//		Collections.reverse(list);
//		System.out.println("output: "+ list);
		
		
		
		
		//problem 2- find the middle element of the linked list
//		LinkedList<Integer> list1=new LinkedList(Arrays.asList(10,20,30,40,50,60,70));
//		int middle=(list1.size())/2;
//		System.out.println("middle element is: "+ list1.get(middle));
		
		
        //problem 3- remove duplicates from linkedlist
//		LinkedList<Integer> list3=new LinkedList(Arrays.asList(1,2,2,3,5,4,8,8,9,8,4));
//		//linkhashset - type of set
//		System.out.println("Input list: "+list3);
//		Set<Integer> set=new LinkedHashSet(list3);
//	    /* A set does not allow duplicate elements linkedhashset is a type of set 
//	     * that remembers the insertion order.*/
//		
//		list3.clear();  
//		//removes all the elements from original list
//		list3.addAll(set);
//		System.out.println("Output list: "+list3);
		
		
		
		//problem 4- convert linkedlist to the array
		LinkedList<Integer> list4=new LinkedList(Arrays.asList(1,2,2,3,5,4,8,8,9,8,4));
        Integer[] a = list4.toArray(new Integer[0]);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
		
		

	}

}

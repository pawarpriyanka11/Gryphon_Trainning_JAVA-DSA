

package DAY2;

import java.util.*;
public class IteratorClass {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Integer op;
        int i, num, c;

        Collection<Integer> op1 = new ArrayList();

        System.out.print("Enter Total Numbers : ");
        num = sc.nextInt();

        for (i = 1; i <= num; i++) {
            System.out.print("Enter " + i + " Number : ");
            c = sc.nextInt();
            op1.add(c);
        }

        java.util.Iterator<Integer> it = op1.iterator();

        while (it.hasNext()) {
            op = it.next();
            if (op < 0) {
                System.out.println("Negative Number : " + op);
            }
        }

        System.out.println("OP1: " + op1);
    }
}

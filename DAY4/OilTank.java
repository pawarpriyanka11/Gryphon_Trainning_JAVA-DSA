package DAY4;
import java.util.*;

public class OilTank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people (N): ");
        int n = sc.nextInt();

        System.out.print("Enter tank capacity (C): ");
        int C = sc.nextInt();

        int oil = 0;
        int minOil = 0;

        System.out.println("Enter +1 for sell, -1 for buy:");

        for (int i = 0; i < n; i++) {
            oil += sc.nextInt();
            minOil = Math.min(minOil, oil);
        }

        int X = -minOil;   // minimum initial oil

        if (X > C) {
            System.out.println("Disturbance");
        } else {
            System.out.println("Minimum initial oil X = " + X);
        }

        sc.close();
    }
}

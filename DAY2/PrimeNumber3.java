package DAY2;

import java.util.*;

public class PrimeNumber3 {

    static void sieve(int n, boolean[] prime) {

      
      

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Enter the number : ");
        n = sc.nextInt();

        boolean[] prime = new boolean[n + 1];

        sieve(n, prime);   // passing number and boolean array

        System.out.println("Prime numbers are:");
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}


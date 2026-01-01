package DAY4;

public class Array1Question {

    public static void main(String[] args) {

        int[] a = {4, 3, 5, 2, 6};
        int n = a.length;

        int cnt = 1;          // first element counted
        int max = a[0];       // initialize with first element

        for (int i = 1; i < n; i++) {   // go till last element
            if (a[i] > max) {
                cnt++;
                max = a[i];
            }
        }

        System.out.println(cnt);
    }
}

package DAY4;
import java.util.*;

public class StringOvelConsonent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your text: ");
        String ss = sc.nextLine();

        int vc = 0;
        int cc = 0;

        for (int i = 0; i < ss.length(); i++) {

            char ch = Character.toLowerCase(ss.charAt(i));

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vc++;
            } 
            else if (ch >= 'a' && ch <= 'z') {
                cc++;
            }
        }

        System.out.println("Vowels: " + vc);
        System.out.println("Consonants: " + cc);

        sc.close();
    }
}

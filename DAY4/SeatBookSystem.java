package DAY4;
import java.util.*;

class BookBus {

    Scanner sc = new Scanner(System.in);
    int available = 5;

    void bus() {

        while (available > 0) {

            System.out.print("\nEnter name: ");
            String name = sc.nextLine();

            System.out.println("Hello " + name);
            System.out.println("Available seats: " + available);

            System.out.print("Enter number of seats: ");
            int seats = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (seats <= available) {
                available -= seats;
                System.out.println(seats + " seats booked for " + name);
            } else {
                System.out.println("Sorry, not enough seats!");
            }
        }

        System.out.println("\nAll seats are booked!");
    }
}

public class SeatBookSystem {

    public static void main(String[] args) {
        BookBus bb = new BookBus();
        bb.bus();
    }
}

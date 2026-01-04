package DAY6;
import java.util.Scanner;

public class RaceProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Day 1 Data ---");
        System.out.print("Enter total track distance (m): ");
        double trackLength = scanner.nextDouble();

        System.out.print("Enter distance A beats B by (m): ");
        double beatDistance = scanner.nextDouble();

        System.out.print("Enter time A beats B by (s): ");
        double beatTime = scanner.nextDouble();

        System.out.println("\n--- Day 2 Data ---");
        System.out.print("Enter injury offset (m less than half): ");
        double injuryOffset = scanner.nextDouble();

        // 1. Calculate B's original speed
        // Speed = Distance / Time (The distance B covers in the time after A finishes)
        double speedB = beatDistance / beatTime;

        // 2. Calculate A's total time on Day 1
        double timeBTotal = trackLength / speedB;
        double timeATotal = timeBTotal - beatTime;

        // 3. Calculate Day 2 Injury Point
        double injuryPoint = (trackLength / 2) - injuryOffset;

        // 4. Calculate B's time on Day 2
        // Segment 1: Normal speed until injury
        double timeBBeforeInjury = injuryPoint / speedB;

        // Segment 2: Half speed after injury
        double speedBInjured = speedB / 2;
        double remainingDistance = trackLength - injuryPoint;
        double timeBAfterInjury = remainingDistance / speedBInjured;

        double totalTimeBDay2 = timeBBeforeInjury + timeBAfterInjury;

        // 5. Calculate how much A wins by
        double winningMargin = totalTimeBDay2 - timeATotal;

        // Output results
        System.out.println("\n--- Results ---");
        System.out.printf("Runner B's original speed: %.2f m/s\n", speedB);
        System.out.printf("Runner A's finish time: %.2f seconds\n", timeATotal);
        System.out.printf("Injury occurred at: %.2f meters\n", injuryPoint);
        System.out.printf("Runner B's Day 2 total time: %.2f seconds\n", totalTimeBDay2);
        System.out.println("------------------------------------");
        System.out.printf("A wins by: %.2f seconds\n", winningMargin);

        scanner.close();
    }
}
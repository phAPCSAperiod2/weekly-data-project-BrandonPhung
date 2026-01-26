import java.util.Scanner;
import java.util.Arrays;

class WeeklyDogWalkData {

    private int[] minutes;

    public WeeklyDogWalkData(int[] minutes) {
        this.minutes = minutes;
    }

    public int getTotal() {
        int total = 0;
        for (int m : minutes) {
            total += m;
        }
        return total;
    }

    public double getAverage() {
        return (double) getTotal() / minutes.length;
    }

    public int getMin() {
        return Arrays.stream(minutes).min().orElse(0);
    }

    public int getMax() {
        return Arrays.stream(minutes).max().orElse(0);
    }

    public int getLongestWalkDayIndex() {
        int max = minutes[0];
        int index = 0;
        for (int i = 1; i < minutes.length; i++) {
            if (minutes[i] > max) {
                max = minutes[i];
                index = i;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        String[] days = {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
        };

        StringBuilder sb = new StringBuilder("📅 Daily Walk Minutes:\n");
        for (int i = 0; i < minutes.length; i++) {
            sb.append(days[i]).append(": ").append(minutes[i]).append(" minutes\n");
        }
        return sb.toString();
    }
}

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("🐕 Weekly Dog Walking Tracker");
        System.out.println("Track how many minutes your dog walks each day!");
        System.out.println("=================================\n");

        int[] weekData = new int[7];
        String[] days = {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
        };

        // Collect data with validation
        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Enter walking minutes for " + days[i] + ": ");
            int minutes = scanner.nextInt();

            while (minutes < 0) {
                System.out.print("Minutes cannot be negative. Re-enter: ");
                minutes = scanner.nextInt();
            }

            weekData[i] = minutes;
        }

        WeeklyDogWalkData data = new WeeklyDogWalkData(weekData);

        System.out.println("\n📊 Weekly Summary");
        System.out.println("---------------------------");
        System.out.println("Total minutes walked: " + data.getTotal());
        System.out.printf("Average minutes per day: %.2f\n", data.getAverage());
        System.out.println("Shortest walk: " + data.getMin() + " minutes");
        System.out.println("Longest walk: " + data.getMax() + " minutes");

        int longestDayIndex = data.getLongestWalkDayIndex();
        System.out.println("Longest walk day: " + days[longestDayIndex]);

        System.out.println("\n" + data);

        // Useful insights
        System.out.println("🧠 Weekly Insight:");
        double avg = data.getAverage();

        if (avg < 20) {
            System.out.println("Your dog may need more exercise 🐾 Try longer walks!");
        } else if (avg < 45) {
            System.out.println("Good job! Your dog is getting healthy daily activity 👍");
        } else {
            System.out.println("Excellent! Your dog is very active and happy 💪🐕");
        }

        scanner.close();
    }
}

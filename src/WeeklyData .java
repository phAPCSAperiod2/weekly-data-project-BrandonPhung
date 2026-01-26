public class WeeklyData {

    private double[] minutes;

    // Constructor (deep copy)
    public WeeklyData(double[] minutes) {
        this.minutes = new double[minutes.length];
        for (int i = 0; i < minutes.length; i++) {
            this.minutes[i] = minutes[i];
        }
    }

    // Total minutes walked
    public double getTotal() {
        double total = 0.0;
        for (double m : minutes) {
            total += m;
        }
        return total;
    }

    // Average minutes per day
    public double getAverage() {
        return getTotal() / minutes.length;
    }

    // Minimum minutes
    public double getMin() {
        double min = minutes[0];
        for (double m : minutes) {
            if (m < min) {
                min = m;
            }
        }
        return min;
    }

    // Maximum minutes
    public double getMax() {
        double max = minutes[0];
        for (double m : minutes) {
            if (m > max) {
                max = m;
            }
        }
        return max;
    }

    // Display full week
    @Override
    public String toString() {
        String[] days = {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
        };

        StringBuilder output = new StringBuilder("🐕 Dog Walk Minutes for the Week:\n");
        for (int i = 0; i < minutes.length && i < days.length; i++) {
            output.append(days[i])
                  .append(": ")
                  .append(minutes[i])
                  .append("\n");
        }
        return output.toString();
    }
}

package weeklyTimeRecord;

import employee.Employee;

import java.time.LocalDate;
import java.util.Arrays;

public class WeeklyTimeRecord {
    private Employee employee;
    private double[] dailyHours = new double[7];

    public WeeklyTimeRecord(Employee employee, double[] dailyHours) {
        this.employee = employee;
        this.dailyHours = Arrays.copyOf(dailyHours, 7);
    }

    private void validateDay(int day) {
        if (day > 7 || day < 1) {
            throw new IllegalArgumentException("Invalid day");
        }
    }

    public void addDailyHours(int day, double hours) {
        validateDay(day);
        dailyHours[day - 1] = hours;
    }

    public double getDailyHours(int day) {
        validateDay(day);
        return dailyHours[day - 1];
    }

    public double getTotalHours() {
        double regularHours = getTotalRegularHours();
        double overtimeHours = getTotalOvertimeHours();

        return regularHours + overtimeHours;
    }

    public double getTotalRegularHours() {
        double total = 0;

        for (int i = 0; i < dailyHours.length; i++) {
            // Skip Saturday (5) and Sunday (6)
            if (i == 5 || i == 6) {
                continue;
            }

            total += Math.min(dailyHours[i], 8);
        }

        return total;
    }

    public double getTotalOvertimeHours() {
        double total = 0;

        for (int i = 0; i < dailyHours.length; i++) {
            if (i >= 5) {
                total += dailyHours[i]; // weekend
            } else {
                total += Math.max(0, dailyHours[i] - 8); // weekday overtime only
            }
        }

        return total;
    }

    public double[] getWeeklyRegularHours() {
        double[] regularWeeklyHours = new double[7];

        for (int i = 0; i < dailyHours.length; i++) {
            if (i == 5 || i == 6) {
                regularWeeklyHours[i] = 0;
            }

            regularWeeklyHours[i] = Math.min(dailyHours[i], 8);
        }

        return regularWeeklyHours;
    }

    public double[] getWeeklyOvertimeHours() {
        double[] overtimeWeeklyHours = new double[7];

        for (int i = 0; i < dailyHours.length; i++) {
            if (i >= 5) {
                overtimeWeeklyHours[i] = dailyHours[i];
            } else {
                overtimeWeeklyHours[i] = Math.max(0, dailyHours[i] - 8);
            }
        }

        return overtimeWeeklyHours;
    }
}

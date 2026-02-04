package weeklyTimeRecord;

import employee.Employee;

import java.time.LocalDate;
import java.util.Arrays;

public class WeeklyTimeRecord {
    private Employee employee;
    private int[] dailyHours = new int[7];
    private LocalDate weekStart;

    public WeeklyTimeRecord(Employee employee, int[] dailyHours, LocalDate weekStart) {
        this.employee = employee;
        this.dailyHours = Arrays.copyOf(dailyHours, 7);
        this.weekStart = weekStart;
    }

    public void validateDay(int day) {
        if (day > 7 || day < 1) {
            throw new IllegalArgumentException("Invalid day");
        }
    }

    public void addDailyHours(int day, int hours) {
        validateDay(day);
        dailyHours[day - 1] = hours;
    }

    public int getDailyHours(int day) {
        validateDay(day);
        return dailyHours[day - 1];
    }

    public int getTotalHours() {
        int regularHours = getRegularHours();
        int overtimeHours = getOvertimeHours();

        return regularHours + overtimeHours;
    }

    public int getRegularHours() {
        int total = 0;

        for (int hours : dailyHours) {
            total += Math.min(hours, 8);
        }

        return total;
    }

    public int getOvertimeHours() {
        int total = 0;

        for (int hours : dailyHours) {
            if (hours > 8) {
                total += hours - 8;
            }
        }

        return total;
    }
}

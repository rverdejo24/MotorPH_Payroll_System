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
        this.dailyHours = dailyHours;
    }

    public void addDailyHours(int day, int hours) {
        dailyHours[day - 1] = hours;
    }

    public int getDailyHours(int day) {
        return dailyHours[day - 1];
    }

    public int getTotalHours() {
        int regularHours = getRegularHours();
        int overtimeHours = getOvertimeHours();

        return regularHours + overtimeHours;
    }

    public int getRegularHours() {
        int[] regularHours = new int[7];
        int index = 0;

        for (int hours : dailyHours) {
            regularHours[index] = Math.min(hours, 8);
            index++;
        }

        System.out.println(Arrays.toString(regularHours));

        return Arrays.stream(regularHours).sum();
    }

    public int getOvertimeHours() {
        int[] overtimeHours = new int[7];
        int index = 0;

        for (int hours : dailyHours) {
            if (hours > 8) {
                overtimeHours[index] = hours - 8;
            } else {
                overtimeHours[index] = 0;
            }
            index++;
        }

        System.out.println(Arrays.toString(overtimeHours));

        return Arrays.stream(overtimeHours).sum();
    }
}

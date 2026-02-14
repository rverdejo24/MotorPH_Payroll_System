package weeklyTimeRecord;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CalculateHoursWorked {

    public static class SkipDayException extends RuntimeException {}

    public static double calculateRegularHours(double wh, String dayOfWeek) {
        // handle cases where work hours is a negative value.
        if (wh < 0) {
            throw new IllegalArgumentException("Worked hours cannot be negative.");
        }

        return switch (dayOfWeek) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> {
                if (wh >= 7.8333) {
                    yield 8;
                }
                yield wh;
            }
            default -> 0; // No regular hours for weekends
        };
    }

    public static double calculateOvertimeHours(double wh, String dayOfWeek) {
        // handle cases where work hours is a negative value.
        if (wh < 0) {
            throw new IllegalArgumentException("Worked hours cannot be negative.");
        }

        return switch (dayOfWeek) {
            case "Saturday", "Sunday" -> wh; // All weekend hours count as overtime
            default -> Math.max(0, wh - 8); // Weekday overtime only above 8 hours
        };
    }

    public static LocalTime readTime(Scanner scanner, String message) {
        while(true) {
            System.out.println(message + "(Type \"skip\" to skip this day.)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("skip") || input.isEmpty()) {
                throw new SkipDayException();
            }

            try {

                return LocalTime.parse(input);

            } catch (DateTimeParseException e) {

                System.out.println("Invalid time format. Please use HH:mm (e.g., 08:00, 14:30 etc.,) " + e.getMessage());

            }
        }
    }

    public static LocalTime readBreakTime(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();

            // if ever employees wanted to skip breaks
            if (input.equalsIgnoreCase("skip") || input.isEmpty()) {
                return null; // If user chooses not to take a break
            }

            try {

                return LocalTime.parse(input);

            } catch (DateTimeParseException e) {

                System.out.println("Invalid time format. Please use HH:mm (e.g., 08:00, 14:30 etc.,) " + e.getMessage());

            }

        }
    }
}

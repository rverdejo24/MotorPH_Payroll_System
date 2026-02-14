package motorph;

import employee.Employee;
import enums.EmploymentStatus;
import weeklyTimeRecord.CalculateHoursWorked;
import weeklyTimeRecord.WeeklyTimeRecord;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

import static weeklyTimeRecord.CalculateHoursWorked.readTime;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        WeeklyTimeRecord[] monthlyTimeRecord = new WeeklyTimeRecord[4];

        System.out.println("Enter the following employee details:");
        System.out.println("Employee Number: ");
        int empNum = sc.nextInt();
        System.out.println("Employee First Name: ");
        String firstName = sc.next();
        System.out.println("Employee Last Name: ");
        String lastName = sc.next();
        System.out.println("Employee Suffix(leave blank if none): ");
        String suffix = sc.next();
        System.out.println("Employee birth date: ");
        String birthDate = sc.next();
        LocalDate parsedBirthDate = LocalDate.parse(birthDate);
        System.out.println("Employee hourly rate: ");
        double hourlyRate = sc.nextDouble();


        Employee emp1 = new Employee(empNum, firstName, lastName, suffix, parsedBirthDate, hourlyRate);

        System.out.println(emp1.getEmpName());
        System.out.println(EmploymentStatus.REGULAR);

        for (int w = 0; w < 4; w++) {
            double[] weeklyHours = new double[7];
            monthlyTimeRecord[w] = new WeeklyTimeRecord(emp1, weeklyHours);

            for (int d = 0; d < daysOfWeek.length; d++) {
                System.out.println("Good morning, today is " + daysOfWeek[d]);
                try {
                    // Read time-in from user input (Time in HH:mm format)
                    LocalTime timeInParsed = CalculateHoursWorked.readTime(sc, "Enter time-in (format(Military-time): 08:00, 14:30): ");

                    // Lunch break start
                    LocalTime breakTimeStartParsed;
                    // while loop was added to handle control flow to repeat the current iteration if ever there's an error in the time input.
                    while (true) {
                        breakTimeStartParsed = CalculateHoursWorked.readBreakTime(sc, "Enter break time start(format(Military-time): 08:00, 14:30): ");
                        if (breakTimeStartParsed != null && breakTimeStartParsed.isBefore(timeInParsed)) {
                            System.out.println("Break start cannot be before time-in.");
                        } else {
                            break;
                        }
                    }

                    // Read Lunch break end with validation
                    LocalTime breakTimeEndParsed;
                    // while loop was added to handle control flow to repeat the current iteration if ever there's an error in the time input.
                    while (true) {
                        if (breakTimeStartParsed == null) { // If the user skips the break
                            breakTimeEndParsed = null;
                            break;
                        }

                        breakTimeEndParsed = CalculateHoursWorked.readBreakTime(sc, "Enter break time end(format(Military-time)): ");
                        if (breakTimeEndParsed != null && breakTimeEndParsed.isBefore(breakTimeStartParsed)) {
                            System.out.println("Break end cannot be before break time start.");
                        } else {
                            break;
                        }
                    }


                    // Read time-out with validation against time-in and break end (Time out HH:mm format)
                    LocalTime timeOutParsed;
                    while (true) {
                        timeOutParsed = CalculateHoursWorked.readTime(sc, "Enter time-out (format(Military-time): 17:30, 22:30):");
                        if (timeOutParsed.isBefore(timeInParsed)) {
                            System.out.println("Time out cannot be before time-in.");
                        } else {
                            // Handles over break if it exceeds the time-out
                            if (breakTimeEndParsed != null && breakTimeEndParsed.isAfter(timeOutParsed)) {
                                breakTimeEndParsed = timeOutParsed;
                            }
                            break;
                        }
                    }

                    // Calculate the total worked hours minus break duration
                    Duration workedHoursDuration = Duration.between(timeInParsed, timeOutParsed);
                    Duration breakTimeDuration = Duration.ZERO;

                    if (breakTimeStartParsed != null && breakTimeEndParsed != null) {
                        breakTimeDuration = Duration.between(breakTimeStartParsed, breakTimeEndParsed);
                    }

                    Duration netWorkingHours = workedHoursDuration.minusMinutes(breakTimeDuration.toMinutes());
                    double totalWorkingHours = (double) netWorkingHours.toMinutes() / 60;

                    // Calculate regular and overtime hours based on business rules
                    double regularHours = CalculateHoursWorked.calculateRegularHours(totalWorkingHours, daysOfWeek[d]);
                    double overtimeHours = CalculateHoursWorked.calculateOvertimeHours(totalWorkingHours, daysOfWeek[d]);

                    monthlyTimeRecord[w].addDailyHours(d, totalWorkingHours);

                    // Display daily results
                    System.out.println("Total worked hours for: " + daysOfWeek[d] + " " + totalWorkingHours);
                    System.out.println("Regular hours: " + Arrays.toString(monthlyTimeRecord[w].getWeeklyRegularHours()));
                    System.out.println("Overtime hours: " + Arrays.toString(monthlyTimeRecord[w].getWeeklyOvertimeHours()));
                    System.out.println("---------\n");

                } catch (CalculateHoursWorked.SkipDayException e) {
                    System.out.println("Skipping " + daysOfWeek[d]);
                }

            }
        }

        // To prevent memory leaks
        sc.close();
    }
}

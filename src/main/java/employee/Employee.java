package employee;

import enums.EmploymentStatus;

import java.time.LocalDate;

public class Employee {
    private final int employeeNumber;
    private final String firstName;
    private String lastName;
    private String suffix;
    private final LocalDate birthDay;
    private double hourlyRate;

    public Employee(int employeeNumber, String firstName, String lastName, String suffix, LocalDate birthDay, double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly Rate cannot be negative or zero.");
        }

        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.birthDay = birthDay;
        this.hourlyRate = hourlyRate;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFullName() {
        return suffix != null  && !suffix.isEmpty() ? firstName + " " + lastName + " " + suffix : firstName + " " + lastName;
    }

//    Need to refactor later to convert into date
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void displayInfo() {
        System.out.println("Employee Number: " + getEmployeeNumber());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Birth Day: " + getBirthDay());
    }
}

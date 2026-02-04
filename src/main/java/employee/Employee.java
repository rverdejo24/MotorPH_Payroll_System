package employee;

import enums.EmploymentStatus;

import java.time.LocalDate;

public class Employee {
    private int employeeNumber;
    private String firstName;
    private String lastName;
    private String suffix;
    private LocalDate birthDay;
    private double hourlyRate;

    public Employee(int employeeNumber, String firstName, String lastName, String suffix, String birthDay, double hourlyRate) {
        LocalDate birthday = LocalDate.parse(birthDay);
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.birthDay = birthday;
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

package employee;

import enums.EmploymentStatus;

import java.time.LocalDate;

public class Employee {
    private final int employeeNumber;
    private String firstName;
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

    public String getEmpName() {
        return suffix != null  && !suffix.isEmpty() ? firstName + " " + lastName + " " + suffix : firstName + " " + lastName;
    }

//    Need to refactor later to convert into date
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void displayInfo() {
        System.out.println("Employee Number: " + getEmployeeNumber());
        System.out.println("Full Name: " + getEmpName());
        System.out.println("Birth Day: " + getBirthDay());
    }
}

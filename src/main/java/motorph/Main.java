package motorph;

import employee.Employee;
import enums.EmploymentStatus;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        System.out.println("Employee salary: ");
        double salary = sc.nextDouble();


        Employee owner = new Employee(empNum, firstName, lastName, suffix, parsedBirthDate, salary);

        System.out.println(owner.getEmpName());
        System.out.println(EmploymentStatus.REGULAR);

//        To prevent memory leaks
        sc.close();
    }
}

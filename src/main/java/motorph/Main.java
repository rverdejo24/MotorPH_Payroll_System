package motorph;

import employee.Employee;
import enums.EmploymentStatus;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the following employee details:");
        System.out.println("Employee Number: ");
        int empNum = sc.nextInt();

        Employee owner = new Employee(empNum, "Manuel", "Garcia", "III", "10/11/1983", 500);

        System.out.println(owner.getFullName());
        System.out.println(EmploymentStatus.REGULAR);
    }
}

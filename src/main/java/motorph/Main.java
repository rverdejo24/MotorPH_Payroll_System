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

        Employee owner = new Employee(empNum, "Manuel", "Garcia", "III", "10/11/1983", "Valero Carpark Building Valero Street 1227, Makati City", "966-860-270", "44-4506057-3", "820126853951", "691295330870", "442-605-657-000", EmploymentStatus.REGULAR, "Chief Executive Officer", "N/A");

        System.out.println(owner.getFullName());
        System.out.println(EmploymentStatus.REGULAR);
    }
}

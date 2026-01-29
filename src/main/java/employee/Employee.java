package employee;

import enums.EmploymentStatus;

public class Employee {
    private int employeeNumber;
    private String firstName;
    private String lastName;
    private String suffix;
    private String birthDay;
    private String address;
    private String phoneNumber;
    private String sss;
    private String philHealth;
    private String pagIbig;
    private String tinNumber;
    private EmploymentStatus status;
    private String position;
    private String immediateSupervisor;
    
    public Employee(int employeeNumber, String firstName, String lastName, String suffix, String birthDay, String address, String phoneNumber, String sss, String philHealth, String pagIbig, String tinNumber, EmploymentStatus status, String position, String immediateSupervisor) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.birthDay = birthDay;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sss = sss;
        this.philHealth = philHealth;
        this.pagIbig = pagIbig;
        this.tinNumber = tinNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFullName() {
        return suffix != null  && !suffix.isEmpty() ? firstName + " " + lastName + " " + suffix : firstName + " " + lastName;
    }

//    Need to refactor later to convert into date
    public String getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSSS() {
        return sss;
    }

    public String getPhilHealth() {
        return philHealth;
    }

    public String getPagIbig() {
        return pagIbig;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public EmploymentStatus getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public String getImmediateSupervisor() {
        return immediateSupervisor;
    }
}

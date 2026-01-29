package enums;

public enum EmploymentStatus {
    REGULAR("Regular"),
    PROBATIONARY("Probationary");

    private final String status;

    EmploymentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

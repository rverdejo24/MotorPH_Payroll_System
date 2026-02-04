package salaryCalculator;

public abstract class SalaryComponent {
    protected String name;
    protected double amount = 0;

    public SalaryComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

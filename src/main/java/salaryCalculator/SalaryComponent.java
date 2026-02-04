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

    public double getAmount() {
        return amount;
    }

    public abstract void calculate(double baseSalary);
}

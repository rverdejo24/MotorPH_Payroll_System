package salaryCalculator;

public class Allowance extends SalaryComponent {
    public Allowance(String name, double amount) {
        super(name);
        this.amount = amount;
    }

    @Override
    public void calculate(double baseSalary) {}
}

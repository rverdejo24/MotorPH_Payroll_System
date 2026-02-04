package salaryCalculator;

public class Deduction extends SalaryComponent {
    private double rate;

    public Deduction(String name, double rate) {
        super(name);
        this.rate = rate;
    }

    @Override
    public void calculate(double salary) {
        this.amount = rate * salary;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}

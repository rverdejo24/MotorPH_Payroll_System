package salaryCalculator;

public class Deduction extends SalaryComponent {
    private double rate;

    public Deduction(String name, double rate) {
        super(name);
        this.rate = rate;
    }

    public double calculateAmount(double salary) {
        double deduction = rate * salary;
        setAmount(deduction);

        return getAmount();
    }

    public double getRate() {
        return rate;
    }


}

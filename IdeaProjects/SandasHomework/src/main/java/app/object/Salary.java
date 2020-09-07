package app.object;

public class Salary {
    private SalaryType salaryType;
    private double amount;

    public Salary(SalaryType salaryType, double amount) {
        this.salaryType = salaryType;
        this.amount = amount;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

    public double getAmount() {
        return amount;
    }
}

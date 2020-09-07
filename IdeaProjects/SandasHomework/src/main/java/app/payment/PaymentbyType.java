package app.payment;

import app.object.Employee;
import app.object.SalaryType;

public class PaymentbyType {
    private Employee employee;
    private SalaryType salaryType;
    private double sum;

    public PaymentbyType(Employee employee, SalaryType salaryType, double sum) {
        this.employee = employee;
        this.salaryType = salaryType;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return employee +"," + salaryType + "," + sum;
    }
}

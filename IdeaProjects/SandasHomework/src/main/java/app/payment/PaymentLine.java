package app.payment;

import app.object.Employee;
import app.object.Salary;

public class PaymentLine {
    private Employee employee;
    private Salary salary;

    public PaymentLine(Employee employee, Salary salary) {
        this.employee = employee;
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Salary getSalary() {
        return salary;
    }
}

package app.payment;

import app.object.Employee;

public class PaymentPerEmployee {
    private Employee employee;
    private double sumPayment;
    private double taxes;

    public PaymentPerEmployee(Employee employee, double sumPayment, double taxes) {
        this.employee = employee;
        this.sumPayment = sumPayment;
        this.taxes = taxes;
    }

    @Override
    public String toString() {
        return employee + "," + sumPayment + "," + taxes;
    }
}

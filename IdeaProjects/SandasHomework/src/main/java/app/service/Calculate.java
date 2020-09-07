package app.service;

import app.object.Employee;
import app.object.SalaryType;
import app.payment.PaymentLine;
import app.payment.PaymentPerEmployee;
import app.payment.PaymentbyType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Calculate {

    private static final Logger logger = Logger.getLogger(Calculate.class);
    private static final List<PaymentLine> initialEmployeesAndSalaryList = IOservice.readFromFile();
    private static final List<String> sortedEmployeesByNameList = getEmployeesListSortedByName();

    public static List<PaymentPerEmployee> getPaymentAndTaxesListbyEmployee() {
        List<PaymentPerEmployee> salaryAndTaxesByPersonList = new ArrayList<>();

        for (String name : sortedEmployeesByNameList) {
            double salarySum = initialEmployeesAndSalaryList.stream()
                    .filter(element -> element.getEmployee().getName().equals(name))
                    .mapToDouble(element -> element.getSalary().getAmount())
                    .sum();
            double taxes = salarySum * 0.4;

            salaryAndTaxesByPersonList.add(new PaymentPerEmployee(new Employee(name), salarySum, taxes));
                    }
        logger.info("PaymentPerEmployee List generated successfully");
        return salaryAndTaxesByPersonList;
            }

    public static List<PaymentbyType> getEmployeesListBySalaryType() {
        List<PaymentbyType> employeesListBySalaryType = new ArrayList<>();

        for (String name : sortedEmployeesByNameList) {
            List<SalaryType> salaryTypeList = initialEmployeesAndSalaryList.stream()
                    .filter(paymentLine -> paymentLine.getEmployee().getName().equals(name))
                    .map(paymentLine -> paymentLine.getSalary().getSalaryType())
                    .distinct()
                    .collect(Collectors.toList());

            for (SalaryType salaryType : salaryTypeList) {
                double sum = initialEmployeesAndSalaryList.stream()
                        .filter(paymentLine -> paymentLine.getEmployee().getName().equals(name))
                        .filter(paymentLine -> paymentLine.getSalary().getSalaryType().equals(salaryType))
                        .mapToDouble(paymentLine -> paymentLine.getSalary().getAmount())
                        .sum();

                employeesListBySalaryType.add(new PaymentbyType(new Employee(name), salaryType, sum));
            }
        }
        logger.info("PaymentbyType List generated successfully");
        return employeesListBySalaryType;
    }

    public static List<String> getEmployeesListSortedByName() {
        List<String> sortedEmployeesByNameList = initialEmployeesAndSalaryList.stream()
                .map(PaymentLine::getEmployee)
                .map(Employee::getName)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return sortedEmployeesByNameList;
    }

}

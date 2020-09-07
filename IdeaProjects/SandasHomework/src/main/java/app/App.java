package app;

import app.payment.PaymentPerEmployee;
import app.payment.PaymentbyType;
import app.service.Calculate;
import app.service.IOservice;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    private static final List<PaymentPerEmployee> paymentPerEmployeeList =
            Calculate.getPaymentAndTaxesListbyEmployee(); // exercise 1 List
    private static final List<PaymentbyType> employeesListBySalaryType =
            Calculate.getEmployeesListBySalaryType(); // exercise 2 List

    public static void main(String[] args) {
        IOservice.readFromFile(); //reads from input file

        List<String> paymentPerEmployeeStringList =
                paymentPerEmployeeList.stream().map(PaymentPerEmployee::toString).collect(Collectors.toList()); //
        // generate String for upload to file write method

        List<String> employeesStringListBySalaryType =
                employeesListBySalaryType.stream().map(PaymentbyType::toString).collect(Collectors.toList());
        // generate String for upload to file write method

        IOservice.deleteOutputFileContent(); // delete output file content. Prevents from duplicating data
        IOservice.writeMessageToFile("Exercise 1"); // text input
        IOservice.writeDataToFile("Darbuotojas,Suma,Mokesciai", paymentPerEmployeeStringList); // data output to file: app/service/output.csv

        IOservice.writeMessageToFile("\nExercise 2"); // text input
        IOservice.writeDataToFile("Darbuotojas,Tipas,Suma", employeesStringListBySalaryType); // data output to file: app/service/output.csv
    }
}

package app.service;

import app.object.*;
import app.payment.PaymentLine;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOservice {

    private static final Logger logger = Logger.getLogger(IOservice.class);
    private static final String INPUT_DATA = "src/main/java/app/service/input.csv";
    private static final String OUTPUT_FILE = "src/main/java/app/service/output.csv";

    public static List<PaymentLine> readFromFile() {
        List<PaymentLine> initialEmployeesAndSalaryList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_DATA))) {
            String firstLine = br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] splittedLine = line.split(",");
                initialEmployeesAndSalaryList.add(mapDataToObject(splittedLine));
                line = br.readLine();
            }
        } catch (IOException e) {
            logger.error("Error while reading file");
        }
        return initialEmployeesAndSalaryList;
    }

    public static PaymentLine mapDataToObject(String[] data) {
        return new PaymentLine(new Employee(data[0]), new Salary(SalaryType.getEnumBySalaryType(data[1]),
                Integer.parseInt(data[2])));
    }

    public static void deleteOutputFileContent (){
        try (PrintWriter pw = new PrintWriter(new FileWriter(OUTPUT_FILE,false))) {
        } catch (IOException e) {
            logger.error("Error while deleting file content");
        }
    }

    public static void writeMessageToFile (String message){
        try (PrintWriter pw = new PrintWriter(new FileWriter(OUTPUT_FILE,true))) {
            pw.println(message);
        } catch (IOException e) {
            logger.error("Error while writing into the file");
        }
    }

    public static void writeDataToFile(String message, List<String> inputList) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(OUTPUT_FILE,true))) {
            pw.println(message);
            for (String line : inputList)
                pw.println(line);
        } catch (IOException e) {
            logger.error("Error while writing into the file");
        }
    }
}

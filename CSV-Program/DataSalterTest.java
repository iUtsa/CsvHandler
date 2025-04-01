import java.util.List;
import java.util.Scanner;

public class DataSalterTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the salting range for test (e.g., 3.0, 5.0, etc.): ");
        double saltRange = scanner.nextDouble();
        scanner.close();

        List<Point> dataPoints = DataSalter.readCSV("test_function_data.csv");

        DataSalter.saltData(dataPoints, saltRange);
        System.out.println("Salted test data with range " + saltRange + ".");

        // Exporting test
        DataSalter.exportToCSV(dataPoints, "test_salted_data.csv");
        System.out.println("Test salted data exported successfully as test_salted_data.csv.");
    }
}

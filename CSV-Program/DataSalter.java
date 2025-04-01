import java.io.*;
import java.util.*;

public class DataSalter {
    private static final String INPUT_FILE = "function_data.csv";
    private static final String OUTPUT_FILE = "salted_data.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the salting range (e.g., 3.0, 5.0, etc.): ");
        double saltRange = scanner.nextDouble();
        scanner.close();

        List<Point> dataPoints = readCSV(INPUT_FILE);

        // Salt the data with user-defined range
        saltData(dataPoints, saltRange);

        // Export salted data
        exportToCSV(dataPoints, OUTPUT_FILE);
        System.out.println("Salted data exported to " + OUTPUT_FILE + " with range " + saltRange);
    }

    // Reads CSV file and loads (x, y) data
    public static List<Point> readCSV(String fileName) {
        List<Point> dataPoints = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double x = Double.parseDouble(values[0]);
                double y = Double.parseDouble(values[1]);
                dataPoints.add(new Point(x, y));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataPoints;
    }

    // Adds random noise to only the Y values
    public static void saltData(List<Point> data, double range) {
        Random rand = new Random();
        for (Point p : data) {
            double noise = rand.nextDouble() * (2 * range) - range; // Generates a value between [-range, +range]
            p.y += noise;
        }
    }

    // Exports modified data to a new CSV file
    public static void exportToCSV(List<Point> data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("X,Y\n");
            for (Point p : data) {
                writer.append(p.x + "," + p.y + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

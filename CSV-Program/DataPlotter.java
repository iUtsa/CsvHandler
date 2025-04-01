import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPlotter {
    private static final String FILE_NAME = "function_data.csv";

    public static void main(String[] args) {
        List<Point> dataPoints = generateData();

        // Export data to CSV
        exportToCSV(dataPoints, FILE_NAME);
        System.out.println("Data exported successfully to " + FILE_NAME);
    }

    // Generates function data y = x^2 - 3x + 2
    public static List<Point> generateData() {
        List<Point> dataPoints = new ArrayList<>();
        for (double x = -10; x <= 10; x += 0.5) {
            double y = Math.pow(x, 2) - 3 * x + 2;
            dataPoints.add(new Point(x, y));
        }
        return dataPoints;
    }

    // Export data to CSV
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

// Class to store (x, y) values
class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

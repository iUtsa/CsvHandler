import java.io.*;
import java.util.*;

public class DataHandler {
    // Reads CSV file and loads (x, y) data into a list
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

    // Writes (x, y) data into a CSV file
    public static void writeCSV(String fileName, List<Point> dataPoints) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("X,Y\n");
            for (Point p : dataPoints) {
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

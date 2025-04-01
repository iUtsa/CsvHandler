import java.util.List;

public class DataPlotterTest {
    public static void main(String[] args) {
        List<Point> dataPoints = DataPlotter.generateData();
        System.out.println("Generated " + dataPoints.size() + " data points.");

        // Export test
        DataPlotter.exportToCSV(dataPoints, "test_function_data.csv");
        System.out.println("Test CSV exported successfully as test_function_data.csv.");
    }
}

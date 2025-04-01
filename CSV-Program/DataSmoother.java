import java.util.List;

public class DataSmoother {
    private static final String INPUT_FILE = "test_salted_data.csv"; // Corrected filename
    private static final String OUTPUT_FILE = "test_smoothed_data.csv";

    public static void main(String[] args) {
        List<Point> dataPoints = DataHandler.readCSV(INPUT_FILE);

        // Check if data was loaded
        if (dataPoints.isEmpty()) {
            System.out.println("Error: No data found in " + INPUT_FILE);
            return;
        }

        // Smooth the data
        smoothData(dataPoints);

        // Export smoothed data using DataHandler
        DataHandler.writeCSV(OUTPUT_FILE, dataPoints);
        System.out.println("Smoothed data exported to " + OUTPUT_FILE);
    }

    // Applies moving average smoothing on Y values
    public static void smoothData(List<Point> data) {
        for (int i = 1; i < data.size() - 1; i++) {
            data.get(i).y = (data.get(i - 1).y + data.get(i).y + data.get(i + 1).y) / 3;
        }
    }
}

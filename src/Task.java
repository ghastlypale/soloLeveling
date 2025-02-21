import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task {
    private final String taskFile = "tasks.txt";
    Map<Integer, List<String>> tasks;

    public Task() {
        tasks = new HashMap<>();
        loadTasksFromFile();
    }

    private void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(taskFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                tasks.put(Integer.parseInt(parts[0]), Arrays.asList(parts[1], parts[2]));
            }
        }catch (IOException e){
           System.out.println("File not found, creating a new one");
           saveStatsToFile();
        }
    }
    private void saveStatsToFile() {

    }

}

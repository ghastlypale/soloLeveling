import java.io.*;
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

    public Integer getTaskId (int taskId) {
            if (tasks.containsKey(taskId)) {
                return taskId;
            }
            return null;
    }

    public String getTaskDescription(int taskId) {
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId).get(0);
        }
        return null;
    }

    public String getTaskStats (int taskId) {
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId).get(1);
        }
        return null;
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
           saveTasksToFile();
        }
    }
    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile))) {
            for (Map.Entry<Integer, List<String>> entry : tasks.entrySet()) {
                int taskId = entry.getKey();
                String taskDescription = entry.getValue().get(0);
                String taskStats = entry.getValue().get(1);
                writer.write(taskId+":"+taskDescription+":"+taskStats+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Stats {
    private final String fileName = "stats.txt";
    Map<String, Integer> stats;

    public Stats() {
        stats = new HashMap<>();
        loadStatsFromFile();
    }
    public Integer getIntelligence() {
             return (stats.getOrDefault("intelligence", 0));
    }

    public Integer getStrength() {
        return (stats.getOrDefault("strength",0));
    }

    public void setIntelligence(Integer intPoint) {
        stats.put("intelligence", intPoint);
        saveStatsToFile();
    }
    public void setStrength(Integer strPoint) {
        stats.put("strength", strPoint);
        saveStatsToFile();
    }

    private void loadStatsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
           String line;
           while ((line = reader.readLine()) != null) {
               String[] parts = line.split(":");
               stats.put(parts[0], Integer.parseInt(parts[1]));
           }
        } catch (IOException e){
            System.out.println("Error loading stats from file");
            saveStatsToFile();
        }
    }

    private void saveStatsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (Map.Entry<String, Integer> entry : stats.entrySet()) {
               String statName = entry.getKey();
               int statValue = entry.getValue();
               writer.write(statName + ":" + statValue  + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

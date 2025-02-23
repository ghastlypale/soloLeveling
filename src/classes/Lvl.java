package classes;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Lvl {
    private final String fileName = "lvl.txt";
    Map<String, Integer> lvl;

    public Lvl() {
        lvl = new HashMap<>();
        loadLvlFromFile();
    }

    public int getLvlValue(){
        return lvl.getOrDefault("lvl",0);
    }

    public int getLvlPercentage(){
        return lvl.getOrDefault("percentage",0);
    }

    public void setLvlValue(int lvlValue){
        lvl.put("lvl", lvlValue);
        saveLvlToFile();
    }

    public void setLvlPercentage(int lvlPercentage){
        lvl.put("percentage", lvlPercentage);
        saveLvlToFile();
    }

    private void loadLvlFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String  line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("‖");
            lvl.put(parts[0], Integer.parseInt(parts[1]));
        }

    }catch(IOException e){
        System.out.println("File not found, creating new one");
        saveLvlToFile();
    }
    }
    private void saveLvlToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        for (Map.Entry<String, Integer> entry : lvl.entrySet()) {
            writer.write(entry.getKey() + "‖" + entry.getValue() + "\n");
        }

    }catch(IOException e){
        e.printStackTrace();
    }
    }

}

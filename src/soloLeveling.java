import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class soloLeveling {


    public static void addTask (){
        try(
                BufferedWriter writer = new BufferedWriter( new FileWriter("tasks.txt", true));
                Scanner input = new Scanner(System.in)
        ) {
            int lastLineNumber = getLastStringNumber("tasks.txt");
            System.out.println("Enter the task:");
            while (true){
                String task = input.nextLine();
                if ("done".equalsIgnoreCase(task)) break;
                lastLineNumber++;
                writer.write( lastLineNumber + ". " + task +  "\n" );
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public static void deleteTask () throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"));
        Scanner input = new Scanner(System.in))
        {
            ArrayList<String> tasks = new ArrayList<>();
            System.out.println("Enter the completed task:");
            int taskNumber = input.nextInt();
            input.nextLine();
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int lineNumber = Integer.parseInt(line.split("\\.")[0]);
                    if (lineNumber != taskNumber){
                       tasks.add(line);
                    }
                }catch (NumberFormatException | ArrayIndexOutOfBoundsException ignored){
                    tasks.add(line);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))){
                int lastLineNumber = 0;
                for (String task : tasks){
                    lastLineNumber++;
                    writer.write( lastLineNumber + ". " + task.replaceFirst("^\\d+\\.\\s*", "") +"\n" );
                }
            }
        }
    }

    public static int getLastStringNumber(String filename) throws IOException{
        int lastNumber = 0;
        try (BufferedReader reader = new BufferedReader( new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lastNumber = Integer.parseInt(line.split("\\.")[0]);
            }

        }catch  (NumberFormatException | ArrayIndexOutOfBoundsException ignored){}
        return lastNumber;
    }


    public static void main(String[] args) throws IOException {
        deleteTask();
    }
}
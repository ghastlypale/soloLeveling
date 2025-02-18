import java.io.*;
import java.util.Scanner;

public class soloLeveling {

    public static void addTask (){
        try(
                BufferedWriter fw = new BufferedWriter( new FileWriter("tasks.txt", true));
                Scanner input = new Scanner(System.in)
        ) {
            int lastLineNumber = getLastStringNumber("tasks.txt");
            System.out.println("Enter the task:");
            while (true){
                String task = input.nextLine();
                if ("done".equalsIgnoreCase(task)) break;
                lastLineNumber++;
                fw.write(lastLineNumber + ". " + task + "\n");
                fw.flush();
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static int getLastStringNumber(String filename) throws IOException{
        int lastNumber = 0;
        try (BufferedReader ft = new BufferedReader( new FileReader(filename))) {
            String line;
            while ((line = ft.readLine()) != null) {
                lastNumber = Integer.parseInt(line.split("\\.")[0]);
            }

        }catch  (NumberFormatException | ArrayIndexOutOfBoundsException ignored){}
        return lastNumber;
    }


    public static void main(String[] args) {
        addTask();
    }
}
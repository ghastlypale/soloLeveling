import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class soloLeveling {
    int intelligence;
    int strength;
    int lvl;
    int streak;
    String[] keywords = {"book", "workout", "code",};

    public static void addTask (){
        try(
                FileWriter fw = new FileWriter("tasks.txt", true);
                Scanner input = new Scanner(System.in)
        ) {
            System.out.println("Enter the task:");
            String task = input.nextLine();
            fw.write(task + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        addTask();
    }
}
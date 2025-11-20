import java.util.ArrayList;
import java.util.Scanner;


public class TaskManager {
  public static void main(String[] args) {
    ArrayList<String> tasks = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    while (true) {
      System.out.println("\nTask Manager");
      System.out.println("1. Add Task");
      System.out.println("2. View Tasks");
      System.out.println("3. Delete Task");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");


      int choice = sc.nextInt();
      sc.nextLine();


      if (choice == 1) {
        System.out.print("Enter task: ");
        String t = sc.nextLine();
        tasks.add(t);
        System.out.println("Task added.");


      } else if (choice == 2) {
        if (tasks.isEmpty()) {
          System.out.println("No tasks available.");
        } else {
          System.out.println("Your Tasks:");
          for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
          }
        }


      } else if (choice == 3) {
        if (tasks.isEmpty()) {
          System.out.println("Nothing to delete.");
        } else {
          System.out.print("Enter task number to delete: ");
          int num = sc.nextInt();
          if (num >= 1 && num <= tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("Task deleted.");
          } else {
            System.out.println("Invalid number.");
          }
        }


      } else if (choice == 4) {
        break;
      }
    }
  }
}

import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;

class Task {
    String id;
    String title;
    boolean status;

    public Task(String title) {
        UUID uuid = UUID.randomUUID();
        this.title = title;
        this.id = uuid.toString();
        status = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | status: " + status;
    }
}

class Manager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void showTasks() {
        IO.println(tasks);
    }
}

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        Task taskObj = new Task("Moje nowe zadanie");

        IO.println("=== Pola obiektu taskObj ===");
        IO.println("id: " + taskObj.id);
        IO.println("title: " + taskObj.title);
        IO.println("status: " + taskObj.status);

        while (isRunning) {
            IO.println("");
            IO.println("=== Task Manager ===");
            IO.println();
            IO.println("1. Show tasks");
            IO.println("2. Add tasks");
            IO.println("3. Complete tasks");
            IO.println("4. Delete tasks");
            IO.println("5. Exit tasks");
            IO.println();
            IO.print("Choose option: ");

            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                case 1:
                    IO.println("Showing tasks...");
                    manager.showTasks();
                    break;
                case 2:
                    IO.println();
                    IO.print("Enter task: ");
                    String title = scanner.nextLine();

                    IO.println("Adding tasks...");

                    Task task = new Task(title);
                    manager.addTask(task);
                    break;
                case 3:
                    IO.println("Completed tasks...");
                    break;
                case 4:
                    IO.println("Deleted tasks...");
                    break;
                case 5:
                    IO.println("Closing app...");
                    isRunning = false;
                    break;
                default:
                    IO.println("Somethings happend, try again!");
                    break;
            }
        }
    }
}

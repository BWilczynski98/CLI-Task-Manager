import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;

class Task {
    String id;
    String title;
    boolean completed;

    public Task(String title) {
        UUID uuid = UUID.randomUUID();
        this.title = title;
        this.id = uuid.toString();
        completed = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | status: " + completed;
    }
}

class TasksCollection {
    private ArrayList<Task> collectionOfTasks = new ArrayList<Task>();

    public void addTask(Task task) {
        collectionOfTasks.add(task);
    }

    public void showTasks() {
        for (int i = 0; i < collectionOfTasks.size(); i++) {
            IO.println(i);
            IO.println(collectionOfTasks.get(i).id);
            IO.println(collectionOfTasks.size());
        }
    }

    public void completeTask(String id) {

    }
}

public class Main {
    public static void main(String[] args) {
        TasksCollection tasksCollection = new TasksCollection();
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

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
                    tasksCollection.showTasks();
                    break;
                case 2:
                    IO.println();
                    IO.print("Enter task: ");
                    String title = scanner.nextLine();

                    IO.println("Adding tasks...");

                    Task task = new Task(title);
                    tasksCollection.addTask(task);
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

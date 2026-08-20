import java.util.*;

class Task {
    String id;
    String title;
    boolean completed;

    public Task(String title) {
        UUID uuid = UUID.randomUUID();
        this.title = title;
        this.id = uuid.toString();
        this.completed = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | status: " + (completed ? "Completed" : "Not completed");
    }

    public void markAsCompleted() {
        this.completed = true;
    }
}

class TasksCollection {
    private ArrayList<Task> collectionOfTasks = new ArrayList<Task>();

    public void addTask(Task task) {
        collectionOfTasks.add(task);
    }

    public void showTasks() {
        for (int i = 0; i < collectionOfTasks.size(); i++) {
            int taskPosition = i + 1;
            IO.println(taskPosition + ". " + collectionOfTasks.get(i));
        }
    }

    public void completeTask(int index) {
        collectionOfTasks.get(index).markAsCompleted();
    }

    public void deleteTask(int index) {
        collectionOfTasks.remove(index);
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
                    tasksCollection.showTasks();
                    IO.print("Which one do you wanna mark as completed, enter the number of task: ");
                    tasksCollection.completeTask(Integer.parseInt(scanner.nextLine()) - 1);
                    break;
                case 4:
                    IO.println("Deleted tasks...");
                    tasksCollection.showTasks();
                    IO.print("Which one task do you wanna delete, enter the number of task: ");
                    tasksCollection.deleteTask(Integer.parseInt(scanner.nextLine()) - 1);
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

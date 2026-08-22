import java.util.*;

class Task {
    private String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
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

class TasksManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void showTasks() {
        int index = 0;
        for (Task task : tasks) {
            index++;
            IO.println(index + ": " + task);
        }
    }

    public void completeTask(int index) {
        tasks.get(index).markAsCompleted();
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }
}

public class Main {
    public static void main(String[] args) {
        TasksManager tasksManager = new TasksManager();
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        IO.println("");
        IO.println("=== Task Manager ===");
        IO.println();

        while (isRunning) {
            IO.println("1. Show tasks");
            IO.println("2. Add tasks");
            IO.println("3. Complete tasks");
            IO.println("4. Delete tasks");
            IO.println("5. Exit tasks");
            IO.println();
            IO.print("Choose option: ");

            try {
                userInput = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                IO.println("Wrong input, you wasn't enter a number. Try again.");
                continue;
            }

            switch (userInput) {
                case 1:
                    IO.println("Showing tasks...");
                    tasksManager.showTasks();
                    break;
                case 2:
                    IO.println();
                    IO.print("Enter task: ");

                    String title = scanner.nextLine();

                    if (title.isEmpty()) {
                        IO.println("Task title can't be empty");
                        continue;
                    }

                    IO.println("Adding tasks...");
                    Task task = new Task(title);
                    tasksManager.addTask(task);

                    break;
                case 3:
                    IO.println("Completed tasks...");
                    tasksManager.showTasks();
                    IO.print("Which one do you wanna mark as completed, enter the number of task: ");
                    tasksManager.completeTask(Integer.parseInt(scanner.nextLine()) - 1);
                    break;
                case 4:
                    IO.println("Deleted tasks...");
                    tasksManager.showTasks();
                    IO.print("Which one task do you wanna delete, enter the number of task: ");
                    tasksManager.deleteTask(Integer.parseInt(scanner.nextLine()) - 1);
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

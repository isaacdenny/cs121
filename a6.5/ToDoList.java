import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ToDoList implements ToDoListInterface { // @inheritance

  String name;
  ArrayList<Task> tasks; // @keyterm attributes

  /**
   * Constructor for ToDoList with name.
   * @param name
   */
  public ToDoList(String name) {
    this.name = name;
    this.tasks = new ArrayList<Task>();
  }

  /**
   * Constructs a ToDoList with file.
   * @param file
   */
  public ToDoList(File file) {
    try (Scanner fs = new Scanner(file)) {
      this.name = fs.nextLine();
      this.tasks = new ArrayList<Task>();
      fs.useDelimiter(",");
      while (fs.hasNext()) {
        String desc = fs.next();
        Boolean isComplete = Boolean.parseBoolean(fs.next());
        Category cat = Category.valueOf(fs.next());
        int priority = Integer.valueOf(fs.next());

        Task task = new Task(desc, priority);
        task.setCategory(cat);
        task.setIsComplete(isComplete);
        this.tasks.add(task);
        fs.nextLine();
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error: opening file: " + file.getName());
    }
  }
  
  public void saveOut(File file) { // @keyterm method
    try (PrintWriter pw = new PrintWriter(file)) {
      pw.write(name + "\n");
      for (Task task : tasks) {
        pw.write(task.getDescription() + ",");
        pw.write(task.getIsComplete() + ",");
        pw.write(task.getCategory() + ",");
        pw.write(task.getPriority() + ",\r\n");
      }
    }
    catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error opening file: " + file.getName());
    }
  }

  public String getName() { // @keyterm encapsulation
    return name;
  }

  public void addTask(Task newTask) {
    for (Task task : this.tasks) {
      if (task.equals(newTask)) {
        System.out.println("Adding task: " + newTask.getDescription());
        return;
      }
    }
    this.tasks.add(newTask);
  }

  public void addTask(String description) {
    Task newTask = new Task(description);
    for (Task task : this.tasks) {
      if (task.equals(newTask)) {
        return;
      }
    }
    this.tasks.add(newTask);
  }

  public Task getWork() {
    if (tasks.isEmpty()) return null;
    ArrayList<Task> tempTasks = getTaskList(); // @keyterm pass-by-reference
    Task maxTask = Collections.max(tempTasks); // @keyterm static method
    while (maxTask.getIsComplete()) {
      tempTasks.remove(maxTask);
      if (tempTasks.isEmpty()) {
        return null;
      }
      maxTask = Collections.max(tempTasks);
    }
    return maxTask;
  }

  public ArrayList<Task> getTaskList() {
    ArrayList<Task> newTasks = new ArrayList<Task>();
    for (Task task : this.tasks) {
      newTasks.add(task);
    }
    return newTasks;
  }

  /**
   * Returns a String representation of the ToDoList along with each of its tasks.
   * @return String
   */
  @Override
  public String toString() {
    String res = "-------------\n";
    res += name + "\n" + "-------------\n";
    for (Task task : tasks) {
      res += task.toString() + "\n";
    }
    return res;
  }
}

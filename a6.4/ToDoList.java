import java.util.ArrayList;
import java.util.Collections;

public class ToDoList implements ToDoListInterface { // @inheritance

  String name;
  ArrayList<Task> tasks; // @keyterm aggregation

  /**
   * Constructor for ToDoList with name.
   * @param name
   */
  public ToDoList(String name) {
    this.name = name;
    this.tasks = new ArrayList<Task>();
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
    ArrayList<Task> tempTasks = getTaskList();
    Task maxTask = Collections.max(tempTasks);
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

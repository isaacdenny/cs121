public class TaskMaster {

  public static void main(String[] args) {
    Task task1 = new Task("Finish Activity 6.3");
    task1.setIsComplete(true);
    task1.setCategory(Category.SCHOOL);

    Task task2 = new Task("Give Tigger a bath", 10);
    task2.setPriority(0);

    Task task3 = new Task("Eat a Marshmellow", 11);

    ToDoList todos = new ToDoList("My ToDo List");
    todos.addTask(task1);
    todos.addTask(task2);
    todos.addTask(task3);
    todos.addTask("Take a nap");
    System.out.println(todos.toString());

    System.out.println(todos.getWork() == null ? todos.getWork().toString() : "No work");
  }
}

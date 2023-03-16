public class TaskMaster {
  public static void main(String[] args) {
    doTask1Stuff();
    // @keyterm object
    Task task2 = new Task("Give Tigger a bath", 10); // @keyterm object declaration
    System.out.println(task2.toString());
    task2.setPriority(20);
    if (task2.getPriority() == 20) {
      System.out.println("Priority Set Successfully");
    }
    System.out.println(task2.toString());
  }

  private static void doTask1Stuff() {
    Task task1 = new Task("Finish Activity 6.3");
    System.out.println(task1.toString());
    task1.setIsComplete(true);
    if (task1.getIsComplete()) { // @keyterm method invocation
      System.out.println("Task is complete!");
    }
    System.out.println(task1.toString());
    task1.setCategory(Category.SCHOOL);

    if (task1.getCategory() == Category.SCHOOL) {
      System.out.println("Task Category is SCHOOL");
    }
    System.out.println(task1.toString());
  }
}

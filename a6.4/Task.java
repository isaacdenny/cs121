/**
 * Task class for the TaskMaster Application
 * @author Isaac Denny
 */
public class Task implements Comparable<Task> {

  private Category category;
  private String desc;
  private int priority;
  private boolean isComplete;

  /**
   * Constructs a Task with a description
   * @param description
   */
  public Task(String description) {
    this.desc = description;
    this.category = Category.NONE;
    this.priority = 0;
    this.isComplete = false;
  }

  /**
   * Constructs a Task with a description and priority
   * @param description
   * @param priority
   */
  public Task(String description, int priority) {
    this.desc = description; // @keyterm object initialization
    this.category = Category.NONE;
    this.priority = priority;
    this.isComplete = false;
  }

  /**
   * Gets the description of the task
   * @return String
   */
  public String getDescription() {
    return this.desc;
  }

  /**
   * Sets the task description
   * @param newDescription
   */
  public void setDescription(String newDescription) {
    this.desc = newDescription;
  }

  /**
   * Gets the priority of the task
   * @return int
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * Sets the priority of the task
   * @param value
   */
  public void setPriority(int value) {
    this.priority = value;
  }

  /**
   * Gets whether the task is complete
   * @return boolean
   */
  public boolean getIsComplete() {
    return this.isComplete;
  }

  /**
   * Sets whether the task is complete
   * @param value
   */
  public void setIsComplete(boolean value) {
    if (this.isComplete != value) {
      this.isComplete = value;
    }
  }

  /**
   * Gets the task's category
   * @return Category
   */
  public Category getCategory() {
    return this.category;
  }

  /**
   * Sets the task's category
   * @param newCategory
   */
  public void setCategory(Category newCategory) {
    this.category = newCategory;
  }

  /**
   * Returns a string of the object values
   * @return String
   */
  @Override
  public String toString() {
    String pre = isComplete ? "[x]" : "[ ]";
    String out = desc + ", " + priority + ", " + category;
    return pre + out;
  }

  /**
   * Indicates whether some task is "equal to" this task. Tasks are equal if
   * they have the same description (case insensitive).
   * @param The other task to compare this task to.
   * @return true if the tasks are equal, false otherwise.
   */
  public boolean equals(Task other) {
    if (
      this.desc.equalsIgnoreCase(other.desc) &&
      this.category.equals(other.category)
    ) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Compares two tasks based on their priorities.
   * @param The other task to compare this task to.
   * @return difference between the tasks if they are either both complete or
   * both incomplete, return -1 if this task is complete and the parameter task
   * is incomplete, returns 1 if parameter task is complete and this task is not
   * complete.
   */
  @Override
  public int compareTo(Task other) {
    if (this.isComplete == other.isComplete) {
      return this.priority - other.priority;
    } else if (this.isComplete && !other.isComplete) {
      return -1;
    } else {
      return 1;
    }
  }
}

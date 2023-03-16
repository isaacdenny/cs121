/**
 * Task class for the TaskMaster Application
 * @author Isaac Denny
 */
public class Task {

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

}
import java.util.ArrayList;

/**
 * Employee class representing an employee at a company
 */
public class Employee {
  private String name, email;
  private ArrayList<Employee> coworkers;

  /**
   * Constructs a new employee with a given name and email, setting their coworkers to an empty ArrayList<Employee>
   * @param name
   * @param email
   */
  public Employee(String name, String email) {
    this.name = name;
    this.email = email;
    this.coworkers = new ArrayList<Employee>();
  }

  /**
   * Gets the Employee's name
   * @return String name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the Employee's Email address
   * @return String email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Gets the a list of Employee's coworkers
   * @return ArrayList<Employee> copy of coworkers
   */
  public ArrayList<Employee> getCoworkers() {
    ArrayList<Employee> copyCoworkers = new ArrayList<Employee>();
    for (Employee e : coworkers) {
      copyCoworkers.add(e);
    }
    return copyCoworkers;
  }
  /**
   * Adds an Employee to the list of coworkers
   * @param e
   */
  public void addCoworker(Employee e) {
    coworkers.add(e);
  }

  /**
   * Main entrypoint for the program
   * @param args
   */
  public static void main(String[] args) {
    Employee me = new Employee("Isaac Denny", "isaacdenny@u.boisestate.edu");
    Employee nat = new Employee("Natasha Romonav", "natasha@marvel.com");
    me.addCoworker(nat);
  }

}
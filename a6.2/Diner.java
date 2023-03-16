import java.util.ArrayList;

public class Diner {

  private String address;
  private String name;
  private ArrayList<String> menu; // @keyterm attributes

  /**
   * Constructs a new Diner object with the given address, name, and menu.
   * @param address
   * @param name
   * @param menu
   */
  public Diner(String address, String name, ArrayList<String> menu) { // @keyterm contructor
    this.address = address; // @keyterm instance variables
    this.name = name;
    this.menu = menu;
  }

  /**
   * Constructor for Diner. No menu
   * @param address
   * @param name
   */
  public Diner(String address, String name) {
    this.address = address;
    this.name = name;
    this.menu = new ArrayList<String>();
  }

  /**
   * Gets the name of the diner.
   * No setter because it should not be changed.
   * @return String
   */
  public String getName() { // @keyterm accessor
    return this.name;
  }

  /**
   * Gets the address of the diner.
   * No setter because it should not be changed.
   * @return String
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Gets the menu of the diner.
   * @return ArrayList<String>
   */
  public ArrayList<String> getMenu() {
    return this.menu;
  }

  /**
   * Adds a menu item to the diner.
   * returns true if the menu item was added, false otherwise.
   * @param item
   * @return boolean
   */
  public boolean addToMenu(String item) { // @keyterm mutator
    if (!menu.contains(item)) {
      this.menu.add(item);
      return true;
    }
    return false;
  }

  /**
   * Removes a menu item from the diner.
   * returns true if the menu item was removed, false otherwise.
   * @param item
   * @return boolean
   */
  public boolean removeFromMenu(String item) {
    if (this.menu.contains(item)) {
      this.menu.remove(item);
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    String res = (name + " on " + address + "\n");
    res += "=======================================\n";
    res += "menu: " + this.menu;
    return res;
  }
}

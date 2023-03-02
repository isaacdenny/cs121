import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 12: Activity - ArrayLists
 *
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
public class MASHGame {

  public static void main(String[] args) {
    /* Define list of options */
    ArrayList<String> homeList = new ArrayList<String>(); // @keyterm ArrayList
    ArrayList<String> spouseList1 = new ArrayList<String>();
    ArrayList<String> spouseList2 = new ArrayList<String>();
    ArrayList<String> occupationList = new ArrayList<String>();
    ArrayList<String> transportationList = new ArrayList<String>();
    ArrayList<String> hometownList = new ArrayList<String>();

    /* Add items to home list */
    homeList.add("mansion");
    homeList.add("apartment");
    homeList.add("shack");
    homeList.add("house");

    /* TODO: 1. Add items to spouseList1 */
    spouseList1.add("Cindy");
    spouseList1.add("Tilly");
    spouseList1.add("Jess");
    spouseList1.add("Britney");

    /* TODO: 2. Add items to spouseList2 */
    spouseList2.add("Micah");
    spouseList2.add("Thaddeus");
    spouseList2.add("Jacob");
    spouseList2.add("Joe");

    /* TODO: 3. Add items to occupationList */
    occupationList.add("Computer Scientist");
    occupationList.add("Regular Scientist");
    occupationList.add("Web Dev");
    occupationList.add("Full Stack Dev");

    /* TODO: 4. Add items to transportationList */
    transportationList.add("Car");
    transportationList.add("Spaceship");
    transportationList.add("boat");
    transportationList.add("batmobile");

    /* TODO: 5. Add items to hometownList */
    hometownList.add("Indiana");
    hometownList.add("Spain");
    hometownList.add("Georgia");
    hometownList.add("Alabama");

    /* Print the database */
    System.out.println(
      "--------------------- Future Possibilities Database ------------------------"
    );
    System.out.print("Home List: ");
    for (String item : homeList) {
      System.out.print(item + ", ");
    }
    System.out.println();

    /* TODO: 6. Print the items in spouseList1 using the ArrayList toString() method */
    System.out.print("Spouse List 1: ");
    System.out.println(spouseList1.toString());

    /* TODO: 7. Print the items in spouseList2 using a for loop (IE: use indexes to print items ) */
    System.out.print("Spouse List 2: ");
    for (int i = 0; i < spouseList2.size(); i++) {
      System.out.print(spouseList2.get(i) + ", ");
    }
    System.out.println();

    /* TODO: 8. Print the items in the occupationList using the ArrayList iterator and a while loop */
    Iterator<String> iterator = occupationList.iterator(); // @keyterm Iterator
    System.out.print("Occupation List: ");
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + ", ");
    }
    System.out.println();

    /* TODO: 9. Print the items in the transportationList using a foreach loop */
    System.out.print("Transportation List: "); // @keyterm for-each loop
    for (String item : transportationList) {
      System.out.print(item + ", ");
    }
    System.out.println();

    /* TODO: 10. Print the items in the hometownList using the method of your choice */
    System.out.print("Hometown List: ");
    for (String item : hometownList) { // @keyterm object reference
      System.out.print(item + ", ");
    }
    System.out.println();

    System.out.println(
      "----------------------------------------------------------------------------"
    );
    System.out.println("\n");

    /* Ask the player for their name */
    Scanner kbd = new Scanner(System.in);
    System.out.print("Please enter your name: ");
    String name = kbd.nextLine();
    kbd.close();
    System.out.println("\n\n");

    /* Randomly choose items from each List */
    Random rand = new Random();

    /* TODO: 11. Use rand object to select each of the following future
     * components from above lists.
     * */
    String firstHome = homeList.get(rand.nextInt(homeList.size()));
    String secondHome = homeList.get(rand.nextInt(homeList.size()));
    String occupation = occupationList.get(rand.nextInt(occupationList.size()));
    String transportation = transportationList.get(
      rand.nextInt(transportationList.size())
    );
    String hometown = hometownList.get(rand.nextInt(transportationList.size()));

    /* TODO: 12. Use the coin to determine whether player's spouse comes from spouseList1 or spouseList2,
     * then randomly select spouse from the cooresponding list.
     */
    boolean coin = rand.nextBoolean();
    String spouse;
    if (coin) {
      spouse = spouseList1.get(rand.nextInt(spouseList1.size()));
    } else {
      spouse = spouseList2.get(rand.nextInt(spouseList2.size()));
    }

    /* Randomly choose number of years player will be married */
    int yearsOfMarriage = rand.nextInt(30) + 1;

    /* Print the player's future*/
    System.out.println("Welcome " + name + ", this is your future...");
    System.out.println(
      "You will marry " + spouse + " and live in a " + firstHome + "."
    );
    System.out.println(
      "After " +
      yearsOfMarriage +
      (yearsOfMarriage == 1 ? " year" : " years") +
      " of marriage, you will finally get your dream job of being a " +
      occupation +
      "."
    );
    System.out.println(
      "Your family will move to a " +
      secondHome +
      " in " +
      hometown +
      " where you will " +
      transportation +
      " to work each day."
    );
  }
}

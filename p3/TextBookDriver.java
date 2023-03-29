import java.util.Scanner;

/**
 * Driver for the TextBook Social Media Application. Provides an interface for TextBook and Post functionality.
 */
public class TextBookDriver {

  /**
   * Main entry point for the TextBook Social Media Application.
   * @param args
   */
  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);
    TextBook tb = new TextBook();
    String name;
    String input;

    System.out.println("Initializing TextBook Social Media Services...");
    System.out.print("Enter your name to enter TextBook: ");

    name = inputScanner.nextLine();
    System.out.println(
      name + ", welcome to TextBook, the totally-text social media service!"
    );
    printMenu();
    System.out.print("Select an option or M for menu: ");
    input = inputScanner.nextLine().toLowerCase();

    while (!input.equals("q")) {
      switch (input) {
        case "p":
          printPosts();
          break;
        case "a":
          addNewPost();
          break;
        case "d":
          deletePost();
          break;
        case "c":
          commentOnPost();
          break;
        case "r":
          readPostWithComments();
          break;
        case "m":
          printMenu();
          break;
        default:
          System.out.println("Error: Invalid input. Please try again...");
          break;
      }
      System.out.print("Select an option or M for menu: ");
      input = inputScanner.nextLine().toLowerCase();
    }
    System.out.println("Goodbye!");
    inputScanner.close();
  }

  private static void readPostWithComments() {}

  private static void commentOnPost() {}

  private static void deletePost() {}

  private static void addNewPost() {}

private static void printPosts() {}

  private static void printMenu() {
    System.out.println("----------------------------------------");
    System.out.println("TextBook Service Menu");
    System.out.println("----------------------------------------");
    System.out.println("  (P)rint TextBook posts");
    System.out.println("  (A)dd new post");
    System.out.println("  (D)elete a post");
    System.out.println("  (C)omment on a post");
    System.out.println("  (R)ead a post and its comments");
    System.out.println("  (Q)uit");
    System.out.println("----------------------------------------");
    System.out.println("----------------------------------------");
  }
}

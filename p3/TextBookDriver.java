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
    System.out.println("\n" + name + ", welcome to TextBook, the totally-text social media service!\n");
    printMenu();
    System.out.print("Select an option or M for menu: ");
    input = inputScanner.nextLine().toLowerCase();

    while (!input.equals("q")) {
      switch (input) {
        case "p":
          printPosts(tb);
          break;
        case "a":
          addNewPost(tb, inputScanner, name);
          break;
        case "d":
          deletePost(tb, inputScanner, name);
          break;
        case "c":
          commentOnPost(tb, inputScanner, name);
          break;
        case "r":
          readPostWithComments(tb, inputScanner);
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

  private static void readPostWithComments(TextBook tb, Scanner scanner) {
    System.out.print("Enter the index of the post to read: ");
    int index = Integer.parseInt(scanner.nextLine());

    String toPrint = tb.getPostString(index);

    while (toPrint == null) {
      System.out.print("Error: Invalid index. Please try again: ");
      index = Integer.parseInt(scanner.nextLine());
      toPrint = tb.getPostString(index);
    }
    System.out.println();
    System.out.println(toPrint);
  }

  private static void commentOnPost(TextBook tb, Scanner scanner, String name) {
    System.out.print("Enter the index of the post to comment on: ");
    int index = Integer.parseInt(scanner.nextLine());

    while (index < 0 || index >= tb.getPostCount()) {
      System.out.print("Error: Invalid index. Please try again: ");
      index = Integer.parseInt(scanner.nextLine());
    }
    System.out.print("Enter your comment: ");
    String text = scanner.nextLine();

    tb.addComment(index, name, text);
  }

  private static void deletePost(TextBook tb, Scanner scanner, String name) {
    System.out.print("Enter the index of the post to delete: ");
    int index = Integer.parseInt(scanner.nextLine());
    while (tb.removePost(index) == null) {
      System.out.print("Error: Invalid index. Please try again: ");
      index = Integer.parseInt(scanner.nextLine());
    }
    System.out.println();
    System.out.println("Successfully deleted the post");
  }

  private static void addNewPost(TextBook tb, Scanner scanner, String name) {
    System.out.print("Enter the text for your new post: ");
    String text = scanner.nextLine();
    tb.addPost(name, text);
  }

  private static void printPosts(TextBook tb) {
    System.out.println();
    System.out.println(tb.toString());
  }

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

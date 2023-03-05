import java.util.Scanner;

/**
 *  Provides menu structure and console UI for the JukeboxHero application.
 *  @author Isaac Denny
 */

public class JukeboxHero {
  
  /**
   * 
   * @param args (command line arguments)
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    String keyScanner = scanner.nextLine();

    while (keyScanner != null) {
      System.out.println("*****************************");
      System.out.println("*      Program Menu         *");
      System.out.println("*****************************");

      switch (keyScanner.toLowerCase()) { 
        case "l":
          break;
        case "s":
          break;
        case "a":
          break;
        case "p":
          break;
        case "q":
          break;
        default:
          System.out.println("Invalid selection!");
          break;
      }
    }

    scanner.close();
  }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    ArrayList<Song> songList = new ArrayList<Song>();
    Scanner keyScanner = new Scanner(System.in);

    System.out.println("*****************************");
    System.out.println("*      Program Menu         *");
    System.out.println("*****************************");
    System.out.println("(L)oad catalog");
    System.out.println("(S)earch catalog");
    System.out.println("(A)nalyse catalog");
    System.out.println("(P)rint catalog");
    System.out.println("(Q)uit");
    System.out.println();
    System.out.print("Please enter a command (press 'm' for Menu): ");
    String input = keyScanner.nextLine();

    while (input != null) {
      switch (input.toLowerCase()) {
        case "m":
          System.out.println("*****************************");
          System.out.println("*      Program Menu         *");
          System.out.println("*****************************");
          System.out.println("(L)oad catalog");
          System.out.println("(S)earch catalog");
          System.out.println("(A)nalyse catalog");
          System.out.println("(P)rint catalog");
          System.out.println("(Q)uit");
          System.out.println();
          break;
        case "l":
          System.out.println("Load catalog...");
          System.out.println("Please enter filename: ");

          String filename = keyScanner.nextLine();
          File file = new File(filename);

          try (Scanner fileScanner = new Scanner(file);) {
            songList.clear();
            while (fileScanner.hasNext()) {
              String scannedLine = fileScanner.nextLine();
              try (Scanner lineScanner = new Scanner(scannedLine);) {
                lineScanner.useDelimiter(",");
                String artist = lineScanner.next();
                String album = lineScanner.next();
                String title = lineScanner.next();
                int duration = Integer.parseInt(lineScanner.next());

                Song song = new Song(title, artist, album, duration);
                songList.add(song);
              } catch (Exception e) {
                System.out.println(
                  e.getMessage() != null
                    ? e.getMessage()
                    : "Cannot read line: " + scannedLine
                );
              }

            }
          } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
          } catch (Exception e) {
            System.out.println("Error opening file");
          }
          break;
        case "s":
          break;
        case "a":
          break;
        case "p":
          break;
        case "q":
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid selection!");
          break;
      }
      System.out.print("Please enter a command (press 'm' for Menu): ");
      input = keyScanner.nextLine();
    }

    keyScanner.close();
  }
}

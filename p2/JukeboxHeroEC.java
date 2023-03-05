import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Provides menu structure and console UI for the JukeboxHero application.
 *  @author Isaac Denny
 */

public class JukeboxHeroEC {

  /**
   * main method for the JukeboxHero application. Calls helper methods for catalog actions.
   * @param args (command line arguments)
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    ArrayList<Song> songList = new ArrayList<Song>();
    Scanner keyScanner = new Scanner(System.in);

    displayMenu();
    System.out.print("Please enter a command (press 'm' for Menu): ");
    String input = keyScanner.nextLine().toLowerCase();

    while (!input.equals("q")) {
      switch (input) {
        case "m":
          displayMenu();
          break;
        case "l":
          loadCatalog(songList, keyScanner);
          break;
        case "s":
          searchCatalog(songList, keyScanner);
          break;
        case "a":
          analyzeCatalog(songList);
          break;
        case "p":
          printCatalog(songList);
          break;
        default:
          System.out.println("Invalid selection!");
          break;
      }

      System.out.print("Please enter a command (press 'm' for Menu): ");
      input = keyScanner.nextLine().toLowerCase();
    }

    System.out.println("Goodbye!");

    keyScanner.close();
  }

  //#region helper methods

  /**
   * loads a song catalog from a .csv file.
   * @param sl
   * @param ks
   */
  private static void loadCatalog(ArrayList<Song> sl, Scanner ks) {
    System.out.println("Load catalog...");
    System.out.print("Please enter filename: ");

    String filename = ks.nextLine();

    if (filename == null || filename.equals("")) {
      System.out.println("Filename cannot be empty.");
      return;
    }
    File file = new File(filename);
    try (Scanner fileScanner = new Scanner(file);) {
      sl.clear();
      while (fileScanner.hasNext()) {
        String scannedLine = fileScanner.nextLine();
        try (Scanner lineScanner = new Scanner(scannedLine);) {
          lineScanner.useDelimiter(",");
          String artist = lineScanner.next();
          String album = lineScanner.next();
          String title = lineScanner.next();
          int duration = Integer.parseInt(lineScanner.next());

          Song song = new Song(title, artist, album, duration);
          sl.add(song);
        } catch (Exception e) {
          System.out.println(
            e.getMessage() != null
              ? e.getMessage()
              : "Cannot read line: " + scannedLine
          );
        }
      }
      System.out.println(
        "Successfully loaded " + sl.size() + " songs!"
      );
      System.out.println();
    } catch (Exception e) {
      System.out.println("Unable to open file: " + filename);
      System.out.println();
    }
    return;
  }
  
  /**
   *  displays the menu.
   */
  private static void displayMenu() {
    System.out.println();
    System.out.println("*****************************");
    System.out.println("*      Program Menu         *");
    System.out.println("*****************************");
    System.out.println("(L)oad catalog");
    System.out.println("(S)earch catalog");
    System.out.println("(A)nalyse catalog");
    System.out.println("(P)rint catalog");
    System.out.println("(Q)uit");
    System.out.println();
  }
  
  /**
   * prints the currently loaded catalog.
   * @param sl
   */
  private static void printCatalog(ArrayList<Song> sl) {
    System.out.println();
    System.out.println("Song list contains " + sl.size() + " songs...");
    System.out.println("---------------------------------");
    for (Song song : sl) {
      System.out.println(song.toString());
    }
    System.out.println();
  }

  /**
   * Searches the catalog for songs that match the search query.
   * @param sl
   * @param ks
   */
  private static void searchCatalog(ArrayList<Song> sl, Scanner ks) {
    ArrayList<Song> searchResults = new ArrayList<Song>();

    System.out.println();
    System.out.println("Search catalog...");
    System.out.print("Please enter search query: ");
    String searchQuery = ks.nextLine().toLowerCase();

    for (Song song : sl) {
      if (song.getTitle().toLowerCase().contains(searchQuery)) {
        searchResults.add(song);
      }
    }

    System.out.println("Found " + searchResults.size() + " matches");
    System.out.println("---------------------------------");
    for (Song song : searchResults) {
      System.out.println(song.toString());
    }
    System.out.println();
  }
  
  /**
   * Analyzes the currently loaded catalog for number 
   * of artists, number of albums, and the duration of the catalog.
   * @param sl
   */
  private static void analyzeCatalog(ArrayList<Song> sl) {
    ArrayList<String> artistList = new ArrayList<String>();
    ArrayList<String> albumList = new ArrayList<String>();
    int catalogPlaytime = 0;

    System.out.println("Catalog analysis...");
    for (Song song : sl) {
      if (!artistList.contains(song.getArtist())) {
        artistList.add(song.getArtist());
      }
      if (!albumList.contains(song.getAlbum())) {
        albumList.add(song.getAlbum());
      }
      catalogPlaytime += song.getPlayTime();
    }

    System.out.println("  Number of Artists: " + artistList.size());
    System.out.println("  Number of Albums: " + albumList.size());
    System.out.println("  Number of Songs: " + sl.size());
    System.out.println("  Catalog Playtime: " + catalogPlaytime);
    System.out.println();
  }
  //#endregion
}

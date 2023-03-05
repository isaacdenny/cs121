import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Provides menu structure and console UI for the JukeboxHero application.
 *  @author Isaac Denny
 */

public class JukeboxHero {

  /**
   * main method for the JukeboxHero application. It features 
   * an absolutely disgusting amount of code for just one method.
   * 
   * @param args (command line arguments)
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    ArrayList<Song> songList = new ArrayList<Song>();
    Scanner keyScanner = new Scanner(System.in);

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
    System.out.print("Please enter a command (press 'm' for Menu): ");
    String input = keyScanner.nextLine().toLowerCase();

    while (!input.equals("q")) {
      switch (input) {
        case "m":
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
          break;
        case "l":
          System.out.println("Load catalog...");
          System.out.print("Please enter filename: ");

          String filename = keyScanner.nextLine();

          if (filename == null || filename.equals("")) {
            System.out.println("Filename cannot be empty.");
            break;
          }
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
                        : "Cannot read line: " + scannedLine);
              }
            }
            System.out.println("Successfully loaded " + songList.size() + " songs!");
            System.out.println();
          } catch (Exception e) {
            System.out.println("Unable to open file: " + filename);
            System.out.println();
          }
          break;
        case "s":
          ArrayList<Song> searchResults = new ArrayList<Song>();

          System.out.println();
          System.out.println("Search catalog...");
          System.out.print("Please enter search query: ");
          String searchQuery = keyScanner.nextLine().toLowerCase();

          for (Song song : songList) {
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
          break;
        case "a":
          ArrayList<String> artistList = new ArrayList<String>();
          ArrayList<String> albumList = new ArrayList<String>();
          int catalogPlaytime = 0;

          System.out.println("Catalog analysis...");
          for (Song song : songList) {
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
          System.out.println("  Number of Songs: " + songList.size());
          System.out.println("  Catalog Playtime: " + catalogPlaytime);
          System.out.println();

          break;
        case "p":
          System.out.println();
          System.out.println("Song list contains " + songList.size() + " songs...");
          System.out.println("---------------------------------");
          for (Song song : songList) {
            System.out.println(song.toString());
          }
          System.out.println();
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
}

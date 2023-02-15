import java.util.Scanner;

/**
 *  The <code>MusicList</code> class reads music lists and outputs some statistics in the console.
 *  Author Isaac Denny
 */

public class MusicList {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String album;
    String artist;
    String title;
    String playTime;
    
    System.out.print("Enter album: ");
    album = scanner.nextLine();
    System.out.print("Enter artist: ");
    artist = scanner.nextLine();
    System.out.print("Enter title: ");
    title = scanner.nextLine();
    System.out.print("Enter play time (mm:ss): ");
    playTime = scanner.nextLine();

    int colonIndex = playTime.indexOf(':');
    int min = Integer.parseInt(playTime.substring(0, colonIndex));
    int sec = Integer.parseInt(playTime.substring(colonIndex + 1));
    int totalSeconds = min * 60 + sec;

    Track track1 = new Track(album, artist, title, totalSeconds);
    System.out.println(track1.toString());
    
    scanner.close();
  }
}

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *  The <code>MusicList</code> class reads music lists and outputs some statistics in the console.
 *  Author Isaac Denny
 */

public class MusicList {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
    
    Track track1 = PromptForTrack(scanner);
    System.out.println(track1.toString());

    Track track2 = PromptForTrack(scanner);
    System.out.println(track2.toString());

    Track track3 = PromptForTrack(scanner);
    System.out.println(track3.toString());

    double averagePlayTime = CalculateAveragePlayTime(track1, track2, track3);
    System.out.println("Average play time: " + df.format(averagePlayTime));
    System.out.println();

    Track closestToTarget = GetClosestToMinutes(track1, track2, track3, 3);
    System.out.println("Track with play time closest to 180 seconds is: " + closestToTarget.getTitle());
    System.out.println();

    PrintSortedMusicList(track1, track2, track3, df);
    
    scanner.close();
  }

  private static void PrintSortedMusicList(Track track1, Track track2, Track track3, DecimalFormat df) {
    String columnNames = "Title                          Artist               Album                           Time";
    String div = "========================================================================================";
    System.out.println(div);
    System.out.println(columnNames);
    System.out.println(div);
    if (track1.getPlayTime() > track2.getPlayTime() && track1.getPlayTime() > track3.getPlayTime()) {
      System.out.println(track1.toString());
      if (track2.getPlayTime() < track3.getPlayTime()) {
        System.out.println(track3.toString());
        System.out.println(track2.toString());
      }
      else {
        System.out.println(track2.toString());
        System.out.println(track3.toString());
      }
    }
    else if (track2.getPlayTime() > track1.getPlayTime() && track2.getPlayTime() > track3.getPlayTime()) {
      System.out.println(track2.toString());
      if (track2.getPlayTime() < track3.getPlayTime()) {
        System.out.println(track3.toString());
        System.out.println(track1.toString());
      }
      else {
        System.out.println(track1.toString());
        System.out.println(track3.toString());
      }
    }
    else {
      System.out.println(track3.toString());
      if (track1.getPlayTime() < track2.getPlayTime()) {
        System.out.println(track2.toString());
        System.out.println(track1.toString());
      }
      else {
        System.out.println(track1.toString());
        System.out.println(track2.toString());
      }
    }
    System.out.println(div);
  }

  private static Track GetClosestToMinutes(Track track1, Track track2, Track track3, int minutesTarget) {
    int secondsTarget = minutesTarget * 60;

    int t1Distance = Math.abs(track1.getPlayTime() - secondsTarget);
    int t2Distance = Math.abs(track2.getPlayTime() - secondsTarget);
    int t3Distance = Math.abs(track3.getPlayTime() - secondsTarget);
    
    if (t1Distance < t2Distance && t1Distance < t3Distance) {
      return track1;
    }
    else if (t2Distance < t1Distance && t2Distance < t3Distance) {
      return track2;
    }
    else {
      return track3;
    }
  }

  private static double CalculateAveragePlayTime(Track track1, Track track2, Track track3) {
    return (track1.getPlayTime() + track2.getPlayTime() + track3.getPlayTime()) / 3.0;
  }

  private static Track PromptForTrack(Scanner scanner) {
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
    if (playTime.length() > 5) {
      playTime = playTime.substring(0, 5);
    }

    int colonIndex = playTime.indexOf(':');
    if (colonIndex == -1) {
      return new Track("ERROR", "ERROR", "ERROR", 0);
    }
    int min = Integer.parseInt(playTime.substring(0, colonIndex));
    int sec = Integer.parseInt(playTime.substring(colonIndex + 1));
    int totalSeconds = min * 60 + sec;

    return new Track(album, artist, title, totalSeconds);
  }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Post implements PostInterface {
  private String author, text;
  private Instant timestamp;
  private int postID;
  private ArrayList<String> comments;

  private DecimalFormat df = new DecimalFormat("00000.#");

  /**
   * Constructs a new Post with the given id, author, and text.
   * 
   * @param id
   * @param author
   * @param text
   */
  public Post(int id, String author, String text) {
    this.postID = id;
    this.author = author;
    this.text = text;

    this.timestamp = Instant.now();
    this.comments = new ArrayList<String>();

    File postFile = new File("Post-" + df.format(postID) + ".txt");
    try {
      if (postFile.exists()) {
        postFile.delete();
      }
      if (postFile.createNewFile()) {
        FileWriter fileWriter = new FileWriter(postFile);
        String toWrite = df.format(postID) + " " + timestamp.toString() + " " + this.author + " " + this.text;
        fileWriter.write(toWrite);
        fileWriter.close();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error creating file " + postID);
    }
  }

  /**
   * Attempts to construct a new Post object from a previously written file based
   * on the given post ID
   * 
   * @param id
   */
  public Post(int id) {
    File file = new File("Post-" + df.format(id) + ".txt");
    try (Scanner fileScanner = new Scanner(file)) {
      if (!fileScanner.hasNext())
        System.out.println("File empty: " + file.getName());

      // read initial values
      this.postID = Integer.parseInt(fileScanner.next());
      this.timestamp = Instant.parse(fileScanner.next());
      this.author = fileScanner.next();
      this.text = fileScanner.next() + fileScanner.nextLine();

      // read all comments
      while (fileScanner.hasNext()) {
        this.comments.add(fileScanner.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error creating file " + postID);
    }
  }

  @Override
  public void addComment(String author, String text) {
    Instant currentTime = Instant.now();
    String comment = currentTime + " " + author + " " + text;
    this.comments.add(comment);

    String fileName = "Post-" + df.format(this.postID) + ".txt";
    File file = new File(fileName);
    try (FileWriter fileWriter = new FileWriter(file, true)) {
      fileWriter.write("\n" + comment);
    } catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error writing to file: " + fileName);
    }
  }

  @Override
  public String toString() {
    String toReturn = "Post:\n";
    String fileName = "Post-" + df.format(this.postID) + ".txt";
    File file = new File(fileName);
    try (Scanner fileScanner = new Scanner(file)) {
      toReturn += fileScanner.nextLine() + "\n";
      toReturn += "Comments:\n";
      while (fileScanner.hasNext()) {
        toReturn += fileScanner.nextLine() + "\n";
      }
      return toReturn;
    } catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error reading file: " + fileName);
      return null;
    }
  }

  @Override
  public String toStringPostOnly() {
    return df.format(this.postID) + " " + this.timestamp + " " + this.author + " " + this.text + "\n";
  }

  @Override
  public String getFilename() {
    String fileName = "Post-" + df.format(this.postID) + ".txt";
    return fileName;
  }

  @Override
  public int getPostID() {
    return this.postID;
  }

  @Override
  public String getText() {
    return this.text;
  }

  @Override
  public Instant getTimestamp() {
    return this.timestamp;
  }

  @Override
  public String getAuthor() {
    return this.author;
  }

}

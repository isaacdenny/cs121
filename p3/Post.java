import java.io.File;
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

  /**
   * Constructs a new Post with the given id, author, and text.
   * @param id
   * @param author
   * @param text
   */
  public Post(int id, String author, String text) {
    DecimalFormat df = new DecimalFormat("00000.#");
    this.postID = id;
    this.author = author;
    this.text = text;

    this.timestamp = Instant.now();
    this.comments = new ArrayList<String>();

    try {
      File postFile = new File("Post-" + df.format(postID) + ".txt");
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
   * Attempts to construct a new Post object from a previously written file based on the given post ID
   * @param id
   */
  public Post(int id) {
    DecimalFormat df = new DecimalFormat("00000.#");
    String fileName = "Post-" + df.format(id) + ".txt";
    try (Scanner fileScanner = new Scanner(fileName)) {
      if (!fileScanner.hasNext())
        System.out.println("File empty: " + fileName);
      
      // read initial values
      this.postID = Integer.parseInt(fileScanner.next());
      this.timestamp = Instant.parse(fileScanner.next());
      this.author = fileScanner.next();
      this.text = fileScanner.nextLine();

      // read all comments
      while (fileScanner.hasNext()) {
        this.comments.add(fileScanner.nextLine());
      }
    }
    catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error creating file " + postID);
    }
  }

  @Override
  public void addComment(String author, String text) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addComment'");
  }

  @Override
  public String toStringPostOnly() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toStringPostOnly'");
  }

  @Override
  public String getFilename() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilename'");
  }

  @Override
  public int getPostID() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPostID'");
  }

  @Override
  public String getText() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getText'");
  }

  @Override
  public Instant getTimestamp() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getTimestamp'");
  }

  @Override
  public String getAuthor() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAuthor'");
  }
  
}

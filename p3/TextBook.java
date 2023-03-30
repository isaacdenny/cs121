import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the TextBook class that handles all of the application's functionality on 
 * the TextBook level, including handling posts and their associated save files.
 * 
 * @author Isaac Denny
 */
public class TextBook implements TextBookInterface {
  private ArrayList<Post> posts;
  private int lastID;

  /**
   * Constructs a new TextBook instance.
   */
  public TextBook() {
    posts = new ArrayList<Post>();
    lastID = 0;

    DecimalFormat df = new DecimalFormat("00000");

    File postsFile = new File(POST_LIST_FILENAME);
    if (!postsFile.exists())
      return;
    try (Scanner fileScanner = new Scanner(postsFile)) {
      while (fileScanner.hasNextLine()) {
        int id = Integer.parseInt(fileScanner.nextLine());
        File file = new File("Post-" + df.format(id) + ".txt");
        try (Scanner reader = new Scanner(file)) {
          Post post = new Post(reader.nextInt());
          posts.add(post);
        } catch (FileNotFoundException e) {
          System.out.println(e.getMessage());
        } catch (Exception e) {
          System.out.println(e.getMessage() != null ? e.getMessage() : "Error reading file: " + file.getName());
        }
        lastID = id;
      }
    }
    catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error reading file: " + postsFile.getName());
    }
  }

  @Override
  public int getLastID() {
    return lastID;
  }

  @Override
  public int getPostCount() {
    return posts.size();
  }

  @Override
  public String getPostString(int index) {
    if (index >= 0 && index < posts.size()) {
      return posts.get(index).toString();
    }
    return null;
  }

  @Override
  public boolean addPost(String author, String text) {
    lastID++;
    Post newPost = new Post(lastID, author, text);
    posts.add(newPost);

    if (!posts.contains(newPost)) {
      return false;
    }

    File file = new File(POST_LIST_FILENAME);
    try (FileWriter fw = new FileWriter(file, true)) {
      fw.write(lastID + "\n");
      return true;
    }
    catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      return false;
    }
    catch (Exception e) {
      System.out.println(e.getMessage() != null ? e.getMessage() : "Error reading file: " + file.getName());
      return false;
    }
  }

  @Override
  public Post removePost(int index) {
    if (index < 0 || index >= getPostCount()) {
      return null;
    }

    DecimalFormat df = new DecimalFormat("00000");
    File postFile = new File("Post-" + df.format(index + 1) + ".txt");
    if (postFile.exists()) {
      postFile.delete();
    }

    Post post = posts.remove(index);
    File file = new File(POST_LIST_FILENAME);

    if (post != null) {
      try (FileWriter fw = new FileWriter(file)) {
        for (Post p : posts) {
          fw.write(p.getPostID() + "\n");
        }
      }
      catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
      }
      catch (Exception e) {
        System.out.println(e.getMessage() != null ? e.getMessage() : "Error reading file: " + file.getName());
      }
    }
    return post;
  }

  @Override
  public boolean addComment(int postIndex, String author, String text) {
    if (postIndex >= 0 && postIndex < posts.size()) {
      Post post = posts.get(postIndex);
      post.addComment(author, text);
      return true;
    }
    return false;
  }

  @Override
  public ArrayList<Post> getPosts() {
    ArrayList<Post> postsCopy = new ArrayList<Post>();
    for (Post post : posts) {
      postsCopy.add(post);
    }
    return postsCopy;
  }

  @Override
  public String toString() {
    String toReturn = "TextBook contains " + getPostCount() + " posts:\n";
    for (Post post : posts) {
      toReturn += posts.indexOf(post) + " - " + post.toStringPostOnly();
    }
    return toReturn;
  }
  
}

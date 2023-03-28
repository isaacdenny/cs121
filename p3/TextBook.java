import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class TextBook implements TextBookInterface {
  private ArrayList<Post> posts;
  private int lastID;

  public TextBook() {
    posts = new ArrayList<Post>();
    lastID = 0;

    File postsFile = new File(POST_LIST_FILENAME);
    try (Scanner fileScanner = new Scanner(postsFile)) {
      while (fileScanner.hasNextLine()) {
        String id = fileScanner.next();
        File file = new File("Post-" + id + ".txt");
        try (Scanner reader = new Scanner(file)) {
          Post post = new Post(reader.nextInt());
          posts.add(post);
        } catch (FileNotFoundException e) {
          System.out.println(e.getMessage());
        } catch (Exception e) {
          System.out.println(e.getMessage() != null ? e.getMessage() : "Error reading file: " + file.getName());
        }
        lastID = Integer.parseInt(id);
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
    if (index >= 0 && index <= posts.size() - 1) {
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
    try (FileWriter fw = new FileWriter(file)) {
      fw.write("\n" + lastID);
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
    Post post = posts.remove(index);
    File file = new File(POST_LIST_FILENAME);
    if (post == null) {
      try (FileWriter fw = new FileWriter(file)) {
        for (Post p : posts) {
          fw.write("\n" + p.getPostID());
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
    if (postIndex >= 0 && postIndex > posts.size() - 1) {
      return false;
    }
    Post post = posts.get(postIndex);
    post.addComment(author, text);
    return true;
  }

  @Override
  public ArrayList<Post> getPosts() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPosts'");
  }
  
}

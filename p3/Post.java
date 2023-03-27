import java.time.Instant;

public class Post implements PostInterface {

  public Post(int id, String author, String text) {
    // TODO constructor stub
  }

  public Post(int id) {
    // TODO constructor stub
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

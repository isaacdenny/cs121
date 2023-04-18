import javax.swing.JFrame;

public class MineWalker {
  public static void main(String[] args) {
    JFrame frame = new JFrame("MineWalker");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MineWalkerPanel mainPanel = new MineWalkerPanel();
    
    frame.getContentPane().add(mainPanel);
    frame.pack();
    frame.setVisible(true);
  }
}

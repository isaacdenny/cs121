import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Button for the LiteBriteBoardPanel
 * @author Isaac Denny
 */
public class LitePegButton extends JButton { // @keyterm component
  private final Color[] COLORS = { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN };
  private int colorIndex;

  public LitePegButton() {
    colorIndex = 0;
    this.setBackground(COLORS[colorIndex]);
    this.addActionListener(new LitePegListener());
  }

  /**
   * Resets the button to black
   */
  public void reset() {
    colorIndex = 0;
    this.setBackground(COLORS[colorIndex]);
  }

  /**
   * Action Listener for the button
   */
  private class LitePegListener implements ActionListener { // @keyterm listener
  
    @Override
    public void actionPerformed(ActionEvent e) { // @keyterm event
      colorIndex = (colorIndex + 1) % COLORS.length;
      JButton button = (JButton) e.getSource();
      button.setBackground(COLORS[colorIndex]);
    }
  
  }
}


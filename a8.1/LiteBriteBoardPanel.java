import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Button panel for the LiteBrite application
 * @author Isaac Denny
 */
public class LiteBriteBoardPanel extends JPanel { // @keyterm inheritance
  private LitePegButton[][] pegs;

  /**
   * Construct a LiteBriteBoardPanel with the given columns and rows for the LiteBrite Application
   * @param columns
   * @param rows
   */
  public LiteBriteBoardPanel(int columns, int rows) {
    pegs = new LitePegButton[columns][rows];

    this.setLayout(new GridLayout(columns, rows));

    for (int i = 0; i < pegs.length; i++) {
      for (int j = 0; j < pegs[i].length; j++) {
        pegs[i][j] = new LitePegButton();
        pegs[i][j].setPreferredSize(new Dimension(30,30));
        this.add(pegs[i][j]);
      }
    }
  }
  
  /**
   * Resets the pegs on the board to black
   */
  public void reset() {
    for (int i = 0; i < pegs.length; i++) {
      for (int j = 0; j < pegs[i].length; j++) {
        pegs[i][j].reset();
      }
    }
  }
}

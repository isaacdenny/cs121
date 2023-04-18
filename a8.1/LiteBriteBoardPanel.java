
public class LiteBriteBoardPanel {
  private LitePegButton[][] pegs;

  /**
   * Construct a LiteBriteBoardPanel with the given columns and rows for the LiteBrite Application
   * @param columns
   * @param rows
   */
  public LiteBriteBoardPanel(int columns, int rows) {
    pegs = new LitePegButton[columns][rows];
    for (int i = 0; i < pegs.length; i++) {
      for (int j = 0; j < pegs[i].length; j++) {
        pegs[i][j] = new LitePegButton();
      }
    }
  }
  
  /**
   * Resets the pegs on the board to black
   */
  public void reset() {
    for (int i = 0; i < pegs.length; i++) {
      for (int j = 0; j < pegs[i].length; j++) {
        pegs[i][j] = new LitePegButton();
      }
    }
  }
}

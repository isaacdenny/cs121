import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Main App Panel for the MineWalker Application
 * @author Isaac Denny
 */
public class MineWalkerPanel extends JPanel {

  private JPanel controlsPanel, gridPanel, colorKeyPanel, reportPanel;
  private final int DEFAULT_MINE_PERCENTAGE = 50;
  private int minePercentage;
  private int lives;
  private TileButton playerButton;

  public MineWalkerPanel() {
    controlsPanel = new ControlsPanel(500, 100);
    gridPanel = new GridPanel(500, 400);
    colorKeyPanel = new ColorKeyPanel(200, 400);
    reportPanel = new ReportPanel(500, 100);

    this.setLayout(new BorderLayout());

    this.add(controlsPanel, BorderLayout.NORTH);
    this.add(colorKeyPanel, BorderLayout.WEST);
    this.add(gridPanel, BorderLayout.EAST);
    this.add(reportPanel, BorderLayout.SOUTH);
  }

  /**
   * Grid Panel for the MineWalker Application
   * @author Isaac Denny
   */
  private class GridPanel extends JPanel {
    private Random rand = new Random();
    private final int GRID_DIMENSION = 10;
    private TileButton[][] tiles;

    public GridPanel(int width, int height) {
      setPreferredSize(new Dimension(width, height));

      setUpGrid();
      ArrayList<Point> path = generatePath();
      placeMines(path);

      findNeighbors();
    }

    private void findNeighbors() {
      for (int i = 0; i < tiles.length; i++) {
        for (int j = 0; j < tiles[i].length; j++) {
          TileButton tile = tiles[i][j];
          int numNeighbors = 0;
          if (i < tiles.length - 1 && tiles[i + 1][j].isMine()) {
            numNeighbors++;
          }
          if (i > 0 && tiles[i - 1][j].isMine()) {
            numNeighbors++;
          }
          if (j < tiles[i].length - 1 && tiles[i][j + 1].isMine()) {
            numNeighbors++;
          }
          if (j > 0 && tiles[i][j - 1].isMine()) {
            numNeighbors++;
          }
          tile.setNumMineNeighbors(numNeighbors);
        }
      }
    }

    private void placeMines(ArrayList<Point> path) {
      // Place mines
      int numMinesToPlace = (int) (Math.pow(GRID_DIMENSION, 2) - path.size()) *
      minePercentage /
          100;
      
      while (numMinesToPlace > 0) {
        TileButton tile = tiles[rand.nextInt(tiles.length)][rand.nextInt(tiles[0].length)];
        if (tile.isMine() || tile.isPath()) {
          continue;
        }
        tile.setMine(true);
        numMinesToPlace--;
      }
    }

    private ArrayList<Point> generatePath() {
      // Generate a Path
      ArrayList<Point> path = RandomPath.getPath(GRID_DIMENSION);

      for (Point point : path) {
        tiles[point.x][point.y].setPath(true);
      }
      return path;
    }

    private void setUpGrid() {
      tiles = new TileButton[GRID_DIMENSION][GRID_DIMENSION];
      GridLayout gridLayout = new GridLayout(10, 10);

      // Set up grid
      for (int i = 0; i < tiles.length; i++) {
        for (int j = 0; j < tiles[i].length; j++) {
          TileButton button = new TileButton(i, j);
          button.setEnabled(true);
          button.setVisible(false);
          button.setPath(false);
          button.setMine(false);
          button.setNumMineNeighbors(0);
          button.setText("");
          button.setBackground(Color.gray);
          button.addActionListener(new GridActionListener());

          tiles[i][j] = button;
          this.add(button);
        }
      }
      this.setLayout(gridLayout);
    }

    private class GridActionListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
          "Unimplemented method 'actionPerformed'"
        );
      }
    }
  }

  /**
   * A control panel for the MineWalker Application
   * @author Isaac Denny
   */
  public class ControlsPanel extends JPanel {

    private JLabel minePercentLabel;
    private JTextField minePercentField;
    private JButton newGameButton;

    public ControlsPanel(int width, int height) {
      minePercentage = DEFAULT_MINE_PERCENTAGE;
      setPreferredSize(new Dimension(width, height));

      newGameButton = new JButton("New Game");
      minePercentLabel = new JLabel("Percent:");
      minePercentField = new JTextField("50");

      minePercentField.setEditable(true);
      minePercentField.addActionListener(new ControlPanelListener());

      this.add(newGameButton);
      this.add(minePercentLabel);
      this.add(minePercentField);
    }

    private class ControlPanelListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
        minePercentage = Integer.parseInt(minePercentField.getText());
      }
    }

    /**
     * Gets the minePercentage attribute of this component
     * @return int the mine percentage
     */
    public int getMinePercentage() {
      return minePercentage;
    }
  }

  /**
   * Color Key Panel for the MineWalker Application
   * @author Isaac Denny
   */
  public class ColorKeyPanel extends JPanel {

    private final Color[] colorKeyColors = {
      Color.gray,
      Color.black,
      Color.green,
      Color.yellow,
      Color.orange,
      Color.red,
    };
    private final String[] colorKeyNames = {
      "hidden tile",
      "exposed mine",
      "0 mine neighbors",
      "1 mine neighbor",
      "2 mine neighbors",
      "3 mine neighbors",
    };

    public ColorKeyPanel(int width, int height) {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setPreferredSize(new Dimension(width, height));

      for (int i = 0; i < colorKeyColors.length; i++) {
        JTextArea text = new JTextArea(colorKeyNames[i]);
        text.setBackground(colorKeyColors[i]);
        text.setForeground(Color.WHITE);
        add(text);
      }
    }
  }

  /**
   * Report Panel for the MineWalker Application
   * @author Isaac Denny
   */
  public class ReportPanel extends JPanel {

    private JLabel livesLabel;
    private JTextField livesField;

    public ReportPanel(int width, int height) {
      setPreferredSize(new Dimension(width, height));
    }
  }
}

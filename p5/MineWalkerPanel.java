import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Main App Panel for the MineWalker Application
 * @author Isaac Denny
 */
public class MineWalkerPanel extends JPanel {

  private final Color[] COLOR_KEY_COLORS = {
    Color.green,
    Color.yellow,
    Color.orange,
    Color.red,
    Color.gray,
    Color.black,
  };
  private final String[] COLOR_KEY_NAMES = {
    "0 mine neighbors",
    "1 mine neighbor",
    "2 mine neighbors",
    "3 mine neighbors",
    "hidden tile",
    "exposed mine",
  };

  private final int DEFAULT_MINE_PERCENTAGE = 50;
  private final int GRID_DIMENSION = 10;
  private final int STARTING_LIVES = 5;

  private int minePercentage;
  private int lives; 

  private Random rand = new Random();

  private TileButton[][] tiles;
  private JLabel minePercentLabel;
  private JTextField minePercentField;
  private JLabel livesLabel;
  private TileButton playerButton;

  public MineWalkerPanel() {
    JPanel controlsPanel = new ControlsPanel();
    JPanel gridPanel = new GridPanel();
    JPanel colorKeyPanel = new ColorKeyPanel();
    JPanel reportPanel = new ReportPanel();

    this.setLayout(new BorderLayout());

    this.add(controlsPanel, BorderLayout.NORTH);
    this.add(colorKeyPanel, BorderLayout.WEST);
    this.add(gridPanel, BorderLayout.EAST);
    this.add(reportPanel, BorderLayout.SOUTH);
  }

  private void setPlayer(TileButton button) {
    if (playerButton != null) {
      playerButton.setText("");
    }
    playerButton = button;
    playerButton.setText("X");
    playerButton.setBackground(
      COLOR_KEY_COLORS[playerButton.getNumMineNeighbors()]
    );
    playerButton.setHidden(false);
  }

  private void showMessagePanel(String message) {
    JOptionPane.showMessageDialog(this, message);
  }

  /**
   * Grid Panel for the MineWalker Application
   * @author Isaac Denny
   */
  private class GridPanel extends JPanel {

    public GridPanel() {
      setUpGrid();
      ArrayList<Point> path = generatePath();
      placeMines(path);
      findNeighbors();
      setPlayer(tiles[0][0]);
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
      minePercentage = Integer.parseInt(minePercentField.getText());
      int numMinesToPlace = (int) (Math.pow(GRID_DIMENSION, 2) - path.size()) *
      minePercentage /
      100;

      while (numMinesToPlace > 0) {
        TileButton tile =
          tiles[rand.nextInt(tiles.length)][rand.nextInt(tiles[0].length)];
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
      this.setLayout(gridLayout);

      // Set up grid
      for (int i = 0; i < tiles.length; i++) {
        for (int j = 0; j < tiles[i].length; j++) {
          TileButton button = new TileButton(i, j);
          button.setEnabled(true);
          button.setPath(false);
          button.setMine(false);
          button.setNumMineNeighbors(0);
          button.setText("");
          button.setBackground(COLOR_KEY_COLORS[4]);
          button.setHidden(true);
          button.addActionListener(new TileButtonActionListener());

          tiles[i][j] = button;
          this.add(button);
        }
      }
    }
  }

  /**
   * A control panel with new game functionality for the MineWalker Application
   * @author Isaac Denny
   */
  public class ControlsPanel extends JPanel {

    public ControlsPanel() {
      minePercentage = DEFAULT_MINE_PERCENTAGE;

      JButton newGameButton = new JButton("New Game");
      minePercentLabel = new JLabel("Mine Percent:");
      minePercentField = new JTextField("" + minePercentage);

      minePercentField.setEditable(true);
      newGameButton.addActionListener(new NewGameListener());

      this.add(newGameButton);
      this.add(minePercentLabel);
      this.add(minePercentField);
    }
  }

  /**
   * Color Key Panel for instructions on how to play MineWalker
   * @author Isaac Denny
   */
  public class ColorKeyPanel extends JPanel {

    public ColorKeyPanel() {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      for (int i = 0; i < COLOR_KEY_COLORS.length; i++) {
        JTextField text = new JTextField(COLOR_KEY_NAMES[i]);
        text.setBackground(COLOR_KEY_COLORS[i]);
        text.setForeground(Color.WHITE);
        text.setEditable(false);
        add(text);
      }
    }
  }

  /**
   * Report Panel for the MineWalker Application
   */
  public class ReportPanel extends JPanel {

    public ReportPanel() {
      lives = STARTING_LIVES;
      livesLabel = new JLabel("Lives: " + lives);
      this.add(livesLabel);
    }
  }

  /**
   * Action listener for each TileButton on the game grid
   * @author Isaac Denny
   */
  private class TileButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      TileButton buttonClicked = (TileButton) e.getSource();
      Point buttonLoc = buttonClicked.getLocation();
      Point playerLoc = playerButton.getLocation();
      int xDist = Math.abs(playerLoc.x - buttonLoc.x);
      int yDist = Math.abs(playerLoc.y - buttonLoc.y);

      if (xDist > 1 || yDist > 1) {
        return;
      } else if (xDist == 1 && yDist == 1 || xDist == 1 && yDist == 1) {
        return;
      }

      if (buttonClicked.isMine()) {
        buttonClicked.setHidden(false);
        buttonClicked.setBackground(COLOR_KEY_COLORS[5]); // exposed mine
        buttonClicked.setEnabled(false);
        lives--;
        System.out.println(lives + " Lost 1 life");
        livesLabel.setText("Lives: " + lives);
      } else if (!buttonClicked.isHidden()) {
        playerButton.setText("");
        buttonClicked.setText("X");
        playerButton = buttonClicked;
      } else { // not a mine, and is hidden
        setPlayer(buttonClicked);
      }
      if (playerButton.getLocation().x == GRID_DIMENSION - 1 && playerButton.getLocation().y == GRID_DIMENSION - 1) {
        for (int i = 0; i < tiles.length; i++) {
          for (int j = 0; j < tiles[i].length; j++) {
            TileButton button = tiles[i][j];
            button.setEnabled(false);
          }
        }
        showMessagePanel("You have emerged victorious! Or whatever your name is...");
      } else if (lives <= 0) {
        for (int i = 0; i < tiles.length; i++) {
          for (int j = 0; j < tiles[i].length; j++) {
            TileButton button = tiles[i][j];
            button.setEnabled(false);
          }
        }
        showMessagePanel("You have been blown to smithereens...");
      }
    }
  }

  /**
   * Action listener for the New Game button
   * @author Isaac Denny
   */
  private class NewGameListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      lives = STARTING_LIVES;
      livesLabel.setText("Lives: " + lives);
      setUpGrid();
      ArrayList<Point> path = generatePath();
      placeMines(path);
      findNeighbors();
      setPlayer(tiles[0][0]);
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
      minePercentage = Integer.parseInt(minePercentField.getText());
      int numMinesToPlace = (int) (Math.pow(GRID_DIMENSION, 2) - path.size()) *
      minePercentage /
      100;

      while (numMinesToPlace > 0) {
        TileButton tile =
          tiles[rand.nextInt(tiles.length)][rand.nextInt(tiles[0].length)];
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
      for (int i = 0; i < tiles.length; i++) {
        for (int j = 0; j < tiles[i].length; j++) {
          tiles[i][j].setEnabled(true);
          tiles[i][j].setPath(false);
          tiles[i][j].setMine(false);
          tiles[i][j].setNumMineNeighbors(0);
          tiles[i][j].setText("");
          tiles[i][j].setBackground(COLOR_KEY_COLORS[4]);
          tiles[i][j].setHidden(true);
        }
      }
    }
  }
}

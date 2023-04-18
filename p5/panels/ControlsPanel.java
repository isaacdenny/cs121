package panels;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A control panel for the MineWalker Application 
 */
public class ControlsPanel extends JPanel implements ActionListener {
  private JLabel minePercentLabel;
  private JTextField minePercentField;
  private JButton newGameButton;

  private final int DEFAULT_MINE_PERCENTAGE = 50;
  private int minePercentage;
  
  public ControlsPanel() {
    minePercentage = DEFAULT_MINE_PERCENTAGE;

    newGameButton = new JButton("New Game");
    minePercentLabel = new JLabel("Percent:");
    minePercentField = new JTextField("50");

    minePercentField.setEditable(true);
    minePercentField.addActionListener(this);

    this.add(newGameButton);
    this.add(minePercentLabel);
    this.add(minePercentField);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    minePercentage = Integer.parseInt(minePercentField.getText());
  }

  /**
   * Gets the minePercentage attribute of this component
   * @return int the mine percentage
   */
  public int getMinePercentage() {
    return minePercentage;
  }
}

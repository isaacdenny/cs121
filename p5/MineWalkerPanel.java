import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import panels.ColorKeyPanel;
import panels.ControlsPanel;
import panels.GridPanel;
import panels.ReportPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MineWalkerPanel extends JPanel{
  private JPanel controlsPanel, gridPanel, colorKeyPanel, reportPanel;
  private GridBagConstraints layoutConstraints;

  public MineWalkerPanel() {
    controlsPanel = new ControlsPanel();
    gridPanel = new GridPanel();
    colorKeyPanel = new ColorKeyPanel();
    reportPanel = new ReportPanel();

    this.setLayout(new GridBagLayout());
    layoutConstraints = new GridBagConstraints();
    layoutConstraints.gridx = 0;
    layoutConstraints.gridy = 0;
    layoutConstraints.insets = new Insets(10, 10, 10, 10);

    this.add(controlsPanel, layoutConstraints);
    this.add(gridPanel, layoutConstraints);
    this.add(colorKeyPanel, layoutConstraints);
    this.add(reportPanel, layoutConstraints);
  }
  

}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 0: Traffic Animation
 *
 * Animates a spaceship flying through space.
 * The stars are randomly generated on the first frame of the animation
 *
 * @author BSU CS 121 Instructors
 * @author Isaac Denny
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	Random random = new Random(4);
	Boolean isFirstFrame = true;
	final int UNITSIZE_MODIFIER = 20;
	int[][] map = new int[UNITSIZE_MODIFIER][UNITSIZE_MODIFIER];
	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 10; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 1;

	private final Color BACKGROUND_COLOR = Color.black;

	public void paintComponent(Graphics g)
	{
		
		int width = getWidth();
		int height = getHeight();
		final int UNITSIZE = Math.min(width, height) / UNITSIZE_MODIFIER;
		
		int planetSize = 3 * UNITSIZE;
		

		// fill background
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);
		// fill top of background with dark purple (to highlight the path of the spaceship)
		g.setColor(new Color(10, 0, 10));
		g.fillRect(0, 0, width, getCenterHeight() - UNITSIZE * 4);
		// fill bottom of background with dark purple (to highlight the path of the spaceship)
		g.setColor(new Color(10, 0, 10));
		g.fillRect(0, getCenterHeight() + UNITSIZE * 4, width, getCenterHeight() - UNITSIZE * 4);

		// fill the map (two dimensional array) with random 
		// star positions on the first frame only
		if (isFirstFrame) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (random.nextInt() % 100 > 75) {
						map[i][j] = 1;
					} else {
						map[i][j] = 0;
					}
				}
			}
			isFirstFrame = false;
		}

		// use the map previously generated to draw stars
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					g.setColor(Color.WHITE);
					g.fillOval(i * getWidth() / UNITSIZE_MODIFIER, j * getHeight() / UNITSIZE_MODIFIER, UNITSIZE / 4, UNITSIZE / 4);
				}
			}
		}

		// draw planets
		drawPlanet(g, planetSize, -7, 4, UNITSIZE, new Color(196, 68, 59), false);
		Planet textPlanet = drawPlanet(g, planetSize  - UNITSIZE, 0, -2, UNITSIZE, new Color(191, 141, 54), true); // store planet for text
		drawPlanet(g, planetSize, 9, -5, UNITSIZE, new Color(91, 143, 70), false);
		Planet inhabitable = drawPlanet(g, planetSize + 1 * UNITSIZE, -10, -8, UNITSIZE, new Color(60, 129, 130), true); // store this planet for dude positioning
		drawPlanet(g, planetSize - 2 * UNITSIZE, -10, -7, UNITSIZE, new Color(102, 66, 90), false);

		// draw the dude
		int alienW = UNITSIZE / 2;
		int alienH = UNITSIZE;
		Point alienPos = new Point(inhabitable.GetPosition().x + inhabitable.GetSize() / 2 - alienW / 2, inhabitable.GetPosition().y - alienH);

		g.setColor(Color.YELLOW);
		g.fillRect(alienPos.x, alienPos.y, alienW, alienH);
		g.setColor(Color.black);
		g.fillRect(alienPos.x + alienW / 4, alienPos.y, alienW / 2, alienH / 4);
		// right hand
		g.setColor(Color.YELLOW);
		g.fillArc(alienPos.x + alienW, alienPos.y + alienH / 2, alienW / 4, alienH / 4, -90, 180);
		// left hand
		g.setColor(Color.YELLOW);
		g.fillArc(alienPos.x - alienW / 4, alienPos.y + alienH / 2, alienW / 4, alienH / 4, 90, 180);
		
		// draw text
		g.setColor(Color.WHITE);
		g.drawString("\"The Final Frontier\"", textPlanet.GetPosition().x + textPlanet.GetSize() / 2, textPlanet.GetPosition().y - UNITSIZE);
		
		// Calculate the new xOffset position of the moving object.
		if (xOffset >= width + UNITSIZE * 2) {
			xOffset = -UNITSIZE * 5;
		}
		else {
			xOffset += stepSize * UNITSIZE / 10;
		}
		
		// This draws the spaceship
		DrawSpaceship(g, UNITSIZE);
		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	private void DrawSpaceship(Graphics g, final int UNITSIZE) {
		int squareW = UNITSIZE * 3;
		int squareH = UNITSIZE * 2;
		int squareX = xOffset;
		int squareY = getCenterHeight() - squareW / 2;
		
		// nose
		g.setColor(new Color(102, 66, 90));
		g.fillOval(squareX + squareW - squareH / 2, squareY, squareH, squareH);
		// Windshield
		g.setColor(new Color(60, 129, 130));
		g.fillOval(squareX + (squareW - UNITSIZE / 2) - (squareH / 4), squareY - squareH / 4, squareH / 2, squareH / 2);
		// Thruster 1
		g.setColor(new Color(102, 66, 90));
		g.fillArc(squareX - UNITSIZE * 2, squareY - squareH / 4, UNITSIZE * 2, UNITSIZE * 1, -90, 180);
		// Thruster 2
		g.setColor(new Color(102, 66, 90));
		g.fillArc(squareX - UNITSIZE * 2, squareY + squareH / 2, UNITSIZE * 2, UNITSIZE * 1, -90, 180);
		
		//body
		g.setColor(Color.WHITE);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.fillRect(squareX, squareY - squareH / 4, squareW - UNITSIZE / 2, squareH / 2);
		// stripe
		g.setColor(new Color(102, 66, 90));
		g.fillRect(squareX, squareY - squareH / 4, squareW / 8, squareH + squareH / 4);
	}


	private Planet drawPlanet(Graphics g, int size, int x, int y, int unitSize, Color color, Boolean hasRing) {
		Point bodyAnchor = new Point(getCenterWidth() + x * unitSize, getCenterHeight() + y * unitSize);
		Planet planet = new Planet(g, bodyAnchor, size, color, hasRing);
		planet.Draw();
		return planet;
	}

	private int getCenterWidth() {
		return getWidth() / 2;
	}

	private int getCenterHeight() {
		return getHeight() / 2;
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}

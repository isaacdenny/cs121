import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 0: Traffic Animation
 *
 * Animates a plane moving across the sky between some clouds.
 *
 * @author BSU CS 121 Instructors
 * @author Isaac Denny
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

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
		final int UNITSIZE = Math.min(width, height) / 20;
		
		int planetSize = 3 * UNITSIZE;

		// fill background
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		// draw clouds
		DrawPlanet(g, planetSize, -7, 4, UNITSIZE, Color.BLUE);
		DrawPlanet(g, planetSize  - UNITSIZE, 0, -2, UNITSIZE, Color.GREEN);
		DrawPlanet(g, planetSize, 9, -5, UNITSIZE, Color.ORANGE);
		DrawPlanet(g, planetSize + 1 * UNITSIZE, -10, -8, UNITSIZE, Color.RED);
		DrawPlanet(g, planetSize, -10, -8, UNITSIZE, Color.RED);

		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize * UNITSIZE) % width;

		// This draws the plane
		int squareW = UNITSIZE * 3;
		int squareH = UNITSIZE * 2;
		int squareX = xOffset;
		int squareY = GetCenterHeight() - squareW/2;

		g.setColor(Color.gray);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.fillOval(squareX + squareW - squareH / 2, squareY, squareH, squareH);
		g.fillRect(squareX, squareY - squareH / 4, squareW - UNITSIZE / 2, squareH / 2);
		g.fillOval(squareX + (squareW - UNITSIZE / 2) - (squareH / 4), squareY - squareH / 4, squareH / 2, squareH / 2);



		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	private void DrawPlanet(Graphics g, int planetSize, int xOffset, int yOffset, int unitSize, Color color) {
		Point bodyAnchor = new Point(GetCenterWidth() + xOffset * unitSize, GetCenterHeight() + yOffset * unitSize);
		g.setColor(color);
		g.fillOval(bodyAnchor.x, bodyAnchor.y, planetSize, planetSize);
	}

	private int GetCenterWidth() {
		return getWidth() / 2;
	}

	private int GetCenterHeight() {
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

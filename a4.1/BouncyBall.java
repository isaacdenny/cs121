import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Animated program with a ball bouncing off the program boundaries
 * @author CS121 Instructors
 * @author mvail
 * @author yourname
 */
@SuppressWarnings("serial")
public class BouncyBall extends JPanel
{
	private final int INIT_WIDTH = 600;
	private final int INIT_HEIGHT = 400;
	private final int DELAY = 60;       // milliseconds between Timer events

	private Random random;              // random number generator
	private Color color;                // initial ball color

	private int x, y;                   // ball anchor point coordinates
	private int xDelta, yDelta;         // change in x and y from one step to the next

	private int radius = 10;            // ball radius
	private int radiusDelta = 1;
	/**
	 * Draws a filled bouncy ball that stays within the bounds of the screen.
	 *
	 * @param g Graphics context
	 */
	public void paintComponent(Graphics g)
	{
		int width = getWidth();
		int height = getHeight();

		// Clear canvas
		g.setColor(getBackground());
		g.fillRect(0, 0, width, height);

		// Calculate new x anchor point value
		x += xDelta;
		if (x + radius >= width) {
			xDelta *= -1;
			x = width - radius;
		}
		else if (x - radius <= 0) { // @keyterm nested statements
			xDelta *= -1;
			x = 0 + radius;
		}

		radius += radiusDelta;
		// @keyterm conditional statements
		if (radius > 10 || radius < 5) {
			radiusDelta *= -1;
		}


		// Calculate new y anchor point value
		y += yDelta;
		// @keyterm relational operators
		if (y + radius >= height) {
			yDelta *= -1;
			y = height - radius;
		}
		else if (y - radius <= 0) { // @keyterm equality would be ==
			yDelta *= -1;
			y = 0 + radius;
		}
    
		
		// Paint the ball at the calculated anchor point
		g.setColor(color);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

		// Makes the animation smoother
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins.
	 * This method also sets up a Timer that will call paintComponent() 
	 * with frequency specified by the DELAY constant.
	 */
	public BouncyBall()
	{
		setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
		setDoubleBuffered(true);
		setBackground(Color.black);

		 // Instantiate instance variable for reuse in paintComponent()
		random = new Random();

    color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		int xPos = random.nextInt(INIT_WIDTH - radius);
		int yPos = random.nextInt(INIT_HEIGHT - radius);
		x = xPos < 0 ? xPos + radius : xPos;
		y = yPos < 0 ? yPos + radius : yPos;

		// Initialize deltas for x and y
		xDelta = 5;
		yDelta = 5;
    

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically. DO NOT MODIFY.
	 */
	private void startAnimation()
	{
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		};
		new Timer(DELAY, taskPerformer).start();
	}

	/**
	 * Starting point for the BouncyBall program. DO NOT MODIFY.
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Bouncy Ball");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BouncyBall());
		frame.pack();
		frame.setVisible(true);
	}
}

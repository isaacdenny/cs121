import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

/**
 * Lesson 4: Activity - Using Classes and Objects
 * 
 * Uses the MiniFig class to draw a custom avatar.
 * 
 * @author CS121 instructors
 * @author Isaac Denny
 */
@SuppressWarnings("serial")
public class MyAvatar extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param canvas The drawing area of the window.
	 */
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		int mid = currentWidth / 2;
		int top = 50;
		
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );

		MiniFig bob = DrawMinifig(g, currentHeight, currentWidth, mid, top, scaleFactor);

		DrawGround(g, currentHeight, currentWidth, bob);
	}


	private void DrawGround(Graphics g, int currentHeight, int currentWidth, MiniFig bob) {
		int grassYOffset = (int)bob.getBaseMidPoint().getY();
		int buildingHeight = 300;
		int buildingWidth = 200;
		int windoWidth = 50;
		int windowHeight = 50;
		
		Point buildingPoint = new Point(30, grassYOffset - buildingHeight);

		//draw buildings
		g.setColor(Color.darkGray);
		g.fillRect(buildingPoint.x, buildingPoint.y, buildingWidth, buildingHeight);

		g.setColor(Color.blue);
		g.fillRect(buildingPoint.x + 20, buildingPoint.y + 20, windoWidth, windowHeight); // top left
		g.fillRect(buildingPoint.x + buildingWidth - 20 - windoWidth, buildingPoint.y + 20, windoWidth, windowHeight); // top right
		

		// draw ground
		Color grassGreen = new Color (60,80,38);
		g.setColor(grassGreen);
		g.fillRect(0, grassYOffset, currentWidth, currentHeight - grassYOffset);
		g.fillRect(0, grassYOffset, currentWidth, currentHeight - grassYOffset);
		
	}


	private MiniFig DrawMinifig(Graphics g, int currentHeight, int currentWidth, int mid, int top, double scaleFactor) {
		// @keyterm coordinates
		// @keyterm anchor point
		Point anchor = new Point(mid,top);
		int crabHandWidth = 100;
		int crabHandHeight = 100;
		int hatWidth = 100;
		int hatHeight = 100;
		int hatRimWidth = 150;
		int hatRimHeight = 20;
		
		MiniFig bob = new MiniFig(g, scaleFactor, anchor);

		bob.draw();
		
		// draw accessory
		g.setColor(Color.RED);
		g.fillArc(bob.getLeftHandCenterPoint().x - crabHandWidth / 3, bob.getLeftHandCenterPoint().y - crabHandHeight / 3, crabHandWidth, crabHandHeight, 0, 300);
		
		// draw hat
		// @keyterm RGB
		Color newBlack = new Color(0, 0, 0);
		g.setColor(newBlack);
		g.fillRect(bob.getCapPoint().x - hatWidth / 2, bob.getCapPoint().y - hatHeight, hatWidth, hatHeight);
		g.setColor(Color.black);
		g.fillRect(bob.getCapPoint().x - hatRimWidth / 2, bob.getCapPoint().y - hatRimHeight, hatRimWidth, hatRimHeight);

		return bob;
	}


	public MyAvatar()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}

	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MyAvatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyAvatar());
		frame.pack();
		frame.setVisible(true);
	}
}

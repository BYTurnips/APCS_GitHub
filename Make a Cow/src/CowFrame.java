import java.awt.*;
import java.util.Random;

import javax.swing.JFrame;

public class CowFrame extends JFrame {
	/*
	 * Constructor that automatically creates the cow upon creation
	 * @param none
	 * @return none, but draws on the screen
	 */
	public CowFrame () {
		init();
	}
	/*
	 * Function that calls the paint function after setting the background and canvas size
	 * @param none
	 * @return none, but draws on screen
	 */
	public void init() {
		setSize(700,600);
		setBackground(Color.GREEN);
		repaint();
	}
	/*
	 * Simple function to get a random int between two numbers
	 * @param range in the form of minimum and maximum
	 * @return a random integer within that range
	 */
	public int randi(int min, int max) {
		Random r=new Random();
		return (r.nextInt(max-min))+min;
	}
	/*
	 * Principal function that draws most of the cow
	 * @param Graphics g
	 * @return nothing, but draws on screen
	 */
	public void paint(Graphics g) {
		//Drawn in a specific order so some shapes are covered by other shapes
		drawOutRect(g, 130, 180, 50, 200); //Back Hind Leg
		drawOutRect(g, 100, 200, 50, 200); //Front Hind Leg
		drawOutRect(g, 370, 180, 50, 200); //Back Fore Leg
		drawOutRect(g, 350, 200, 50, 200); //Front Fore Leg
		drawOutOval(g, 50, 100, 400, 200); //Body
		drawOutOval(g, 380, 50, 100, 120); //Head
		
		g.setColor(Color.BLACK);
		g.fillOval(405, 80, 20, 10); //Left Eye
		g.fillOval(435, 80, 20, 10); //Right Eye
		g.drawOval(400, 100, 60, 40); //Snout
		g.drawOval(410, 120, 10, 10); //Left Nostril
		g.drawOval(440, 120, 10, 10); //Right Nostril
		
		g.setColor(Color.PINK);
		g.fillOval(410, 120, 10, 10); //Left Nostril
		g.fillOval(440, 120, 10, 10); //Right Nostril
		
		//Drawing the spots on the cow
		g.setColor(Color.BLACK);
		//Main part of the body
		for(int i=0; i<10; i++) {
			g.fillOval(randi(70,360), randi(160,190), randi(50,80), randi(40,70));
		}
		//Edges
		for(int i=0; i<10; i++) {
			if(Math.random()>0.5) {
				g.fillOval(randi(110,330), randi(120,150), randi(30,50), randi(20,40));
			}
			else {
				g.fillOval(randi(110,360), randi(210,240), randi(30,50), randi(20,40));
			}
		}
	}
	
	/*
	 * Following two functions are extensions of the lib functions which draw and outline the main shapes
	 * @param Graphics g and x, y, w, h in accordance with the lib function it represents
	 * @return nothing, but draws on the screen
	 */
	public void drawOutOval(Graphics g,int x,int y,int w,int h) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, w, h);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, w, h);
	}
	public void drawOutRect(Graphics g,int x,int y,int w,int h) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, w, h);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, w, h);
	}
}

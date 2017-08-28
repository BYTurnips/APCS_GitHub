import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.math.*;

public class Flag extends JPanel {
	private final int sx = 50;
	private final int sy = 50;
	private double hlen = 200;
	Draggo draggo = new Draggo();
	/*
	 * Constructor of Flag that adds MouseListeners and starts initial picture
	 * @params: none
	 * @return: none, but draws on screen
	 */
	public Flag () {
		addMouseMotionListener(draggo);
		addMouseListener(draggo);
		setSize(700, 600);
		setBackground(Color.WHITE);
		repaint();
	}
	/*
	 * The main drawing function in the class - draws the flag
	 * @param none, but uses private class fields
	 * @return none, but draws on screen
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint (Graphics g) {
		int h = (int) hlen;
		g.drawRect(sx, sy, (int)(h*1.9), h); //Main Rectangle (for guidance)
		g.drawRect((int)(sx+h*1.9-10), sy+h-10, 20, 20); //Corner target area
		for(int i=0;i<13;i++) {
			
		}
	}
	
	class Draggo extends MouseAdapter {
		private int px, py;
		private int x, y;
		private double ilen;
		/*
		 * Overwritten function to get mouse position upon clicking (in prep for dragging)
		 * (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
		 */
		public void mousePressed(MouseEvent event) {
			px = event.getX();
			py = event.getY();
			x = px;
			y = py;
			ilen=hlen;
		}
		/*
		 * Overwritten function to resize the flag upon drag
		 * (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
		 */
		public void mouseDragged(MouseEvent event) {

			int dx = event.getX()-x;
			int dy = event.getY()-y;
			double dl;
			int maxd = 5;
			if ((validloc(px, py))) {
				dl=hlen*((cosform(19,10,dx,dy)*Math.sqrt(dx*dx+dy*dy))/(2.14709*hlen));
				if(maxd>0) {
					if(dl>maxd) dl=maxd;
					else if(dl<-maxd) dl=-maxd;
				}
				hlen += dl;
				repaint();
			}
			x += dx;
			y += dy;
		}
		/*
		 * Employs the cosine formula to find the angle (used for scaling the flag in mouseDragged)
		 * @params: the coordinates of two vectors
		 * @return: the cosine of the angle between them
		 */
		public double cosform(int ax, int ay, int bx, int by) {
			double amag=Math.sqrt(ax*ax+ay*ay);
			double ans=(ax*bx+ay*by)/(amag);
			return ans;
		}
		/*
		 * Function to tell if the user clicked on the corner of the flag
		 * @params: coordinates
		 * @return: whether or not it's a valid corner
		 */
		public boolean validloc(int tx, int ty) {
			double cor4x = sx+ilen*1.9;
			double cor4y = sy+ilen;
			if(((Math.abs(tx-cor4x)<10)&&(Math.abs(ty-cor4y)<10))) return true;
			else return false;
		}
	}
	/*
	 * Driver for the flag to be created
	 * @params: args
	 * @return nothing
	 */
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Flag");
		Flag flag = new Flag();
		flag.setDoubleBuffered(true);
		jFrame.add(flag);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(700, 600);
		jFrame.setVisible(true);
	}
}
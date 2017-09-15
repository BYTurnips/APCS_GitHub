import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Flag extends JPanel {
	private static final long serialVersionUID = 1L;
	private int sx = 50;
	private int sy = 50;
	private double hlen = 400;
	Draggo draggo = new Draggo();
	/*
	 * Constructor of Flag that adds MouseListeners and starts initial picture
	 * @params: none
	 * @return: none, but draws on screen
	 */
	public Flag () {
		addMouseMotionListener(draggo);
		addMouseListener(draggo);
		setSize(1000, 1000);
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
		int w = (int) (hlen*1.9);
		int uh = (int) (hlen*7/13);
		int uw = (int) (hlen*0.76);
		double sd = (hlen*0.0616);
		g.drawRect(sx, sy, (int)(h*1.9), h); //Main Rectangle (for guidance)
		g.drawRect((int)(sx+h*1.9-10), sy+h-10, 20, 20); //Corner target area
		Color fill;
		//Stripes
		for(int i=0;i<13;i++) {
			if(i%2 == 0) fill = Color.RED;
			else fill = Color.WHITE;
			drawOutRect(g, sx, (int) (sy+i*hlen/13), w, (int) (hlen/13), fill);
		}
		//Union
		drawOutRect(g, sx, sy, uw, uh, Color.BLUE);
		//in the for loop the first star looks overly small so I hardcoded this star in
		drawStar(g, (int) (hlen*0.063)+sx, (int) (hlen*0.054)+sy, sd/2);
		//Stars
		for(int i=1; i<=9; i++) {
			if(i%2 == 1) {
				for(int j=1; j<=11; j+=2) {
					drawStar(g, (int) (j*hlen*0.063)+sx, (int) (i*hlen*0.054)+sy, sd/2);
				}
			}
			else {
				for(int j=2; j<=10; j+=2) {
					drawStar(g, (int) (j*hlen*0.063)+sx, (int) (i*hlen*0.054)+sy, sd/2);
				}
			}
		}
	}
	/*
	 * Outlines and fills a rectangle with a color (0 = R, 1 = W, 2 = B)
	 * @param Graphics object and parameters for the rectangle including fill color
	 * @return none, but draws on screen
	 */
	public void drawOutRect(Graphics g, int x, int y, int w, int h, Color c) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, w, h);
		g.setColor(c);
		g.fillRect(x, y, w, h);
	}
	/*
	 * Draws and fills a star
	 * @param Graphics, cx, cy = center x, center y coordinate. 
	 * 		  or, ir = outer radius, inner radius
	 * @return none, but draws on screen
	 */
	public void drawStar(Graphics g, int cx, int cy, double or) {
		int points = 5;
		int sides = points*2;
		int xcor[] = new int[sides];
		int ycor[] = new int[sides];
		double offset = (Math.PI/2) % (Math.PI*2/points);
		double ir = ((or*Math.sin(offset)/Math.sin(Math.PI*2/sides+offset)));
		double cr;
		for(int i=0; i<sides ; i++) {
			if(i%2 == 0) cr = ir;
			else cr = or;
			xcor[i] = ((int) (Math.cos(i*Math.PI*2/sides+offset)*cr) + cx);
			ycor[i] = ((int) (Math.sin(i*Math.PI*2/sides+offset)*cr) + cy);
		}
		g.drawPolygon(xcor, ycor, sides);
		g.setColor(Color.WHITE);
		g.fillPolygon(xcor, ycor, sides);
	}
	
	class Draggo extends MouseAdapter {
		private int px, py;
		private int x, y;
		private double ilen;
		private int ix, iy;
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
			ix = sx;
			iy = sy;
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
			boolean n = false;
			int maxd = 5;
			if (validloc(px, py) == 1) {
				dl=cosform(19,10,dx,dy)*Math.sqrt(dx*dx+dy*dy);
				if (dl<0) n = true;
				if(maxd>0) {
					if(dl>maxd) dl=maxd;
					else if(dl<-maxd) dl=-maxd;
				}
				dl = Math.sqrt(dl*dl/4.61);
				if (n) dl *= -1;
				hlen += dl;
				repaint();
			}
			else if (validloc(px, py) == 2) {
				sx += dx;
				sy += dy;
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
		public int validloc(int tx, int ty) {
			double cor4x = sx+ilen*1.9;
			double cor4y = sy+ilen;
			if(((Math.abs(tx-cor4x)<10)&&(Math.abs(ty-cor4y)<10))) return 1;
			else if(((Math.abs(tx-ix)<hlen*1.9)&&(Math.abs(ty-iy)<hlen))) {
				return 2;
			}
			else return 0;
		}
	}
	/*
	 * Driver for the flag to be created
	 * @param: args
	 * @return nothing
	 */
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Draggable, Resizable Flag");
		Flag flag = new Flag();
		flag.setDoubleBuffered(true);
		jFrame.add(flag);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(1000, 1000);
		jFrame.setVisible(true);
	}
}
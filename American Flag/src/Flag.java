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
	
	public Flag () {
		addMouseMotionListener(draggo);
		addMouseListener(draggo);
		init();
	}
	public void init () {
		setSize(700, 600);
		setBackground(Color.WHITE);
		repaint();
	}
	public void paint (Graphics g) {
		int h = (int) hlen;
		g.drawRect(sx, sy, (int)(h*1.9), h);
		g.drawRect((int)(sx+h*1.9-10), sy+h-10, 20, 20);
	}
	
	class Draggo extends MouseAdapter {
		private int px, py;
		private int x, y;
		private double ilen;
		public void mousePressed(MouseEvent event) {
			px = event.getX();
			py = event.getY();
			x = px;
			y = py;
			ilen=hlen;
		}
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
		public double cosform(int ax, int ay, int bx, int by) {
			double amag=Math.sqrt(ax*ax+ay*ay);
			double ans=(ax*bx+ay*by)/(amag);
			return ans;
		}
		public boolean validloc(int tx, int ty) {
			double cor4x = sx+ilen*1.9;
			double cor4y = sy+ilen;
			if(((Math.abs(tx-cor4x)<10)&&(Math.abs(ty-cor4y)<10))) return true;
			else return false;
		}
	}
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


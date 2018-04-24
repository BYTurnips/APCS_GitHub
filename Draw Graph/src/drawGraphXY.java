import java.awt.*;
import java.util.*;
import javax.swing.*;

public class drawGraphXY extends JPanel{
	private static final long serialVersionUID = 1L;
	ArrayList<ArrayList<ArrayList<Integer>>> graph;
	ArrayList<ArrayList<Integer>> listxy;
	
	public drawGraphXY(ArrayList<ArrayList<ArrayList<Integer>>> Graph, 
			ArrayList<ArrayList<Integer>> Listxy) {
		graph = Graph;
		listxy = Listxy;
		setBackground(Color.WHITE);
		repaint();
	}
	public void paint(Graphics g) {
		((Graphics2D) g).setStroke(new BasicStroke(4));
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.BLACK);
		for(int i=0; i<graph.size(); i++) {
			for(ArrayList<Integer> j : graph.get(i)) {
				drawEdge(listxy.get(i).get(0), listxy.get(i).get(1), 
						listxy.get(j.get(0)).get(0), listxy.get(j.get(0)).get(1), 
						j.get(1), g);
			}
		}
		for(int i=0; i<listxy.size(); i++) drawNode(i, listxy.get(i).get(0), listxy.get(i).get(1), g);
		Math.hypot(10-8, 40-20);
	}
	/*
	 * Function to draw an edge with a randomized color and label it with its length
	 */
	public void drawEdge(int ix, int iy, int fx, int fy, int dist, Graphics g) {
		g.setColor(Color.getHSBColor((float) Math.random(), 
				(float) Math.random(), (float) (Math.random()/2+0.25))); 
		g.drawLine(ix, iy, fx, fy);
		int t1 = fx-ix, t2 = fy-iy;
		System.out.println(t1 + " " + t2);
		int offlen = (int) Math.hypot(Math.abs(t1), Math.abs(t2));
		if(offlen == 0) offlen = 5;
		int labx = (int) ((ix + fx)/2 + (fy-iy)/offlen);
		int laby = (int) ((iy + fy)/2 + (fx-ix)/offlen);
		g.drawString(Integer.toString(dist), labx, laby);
	}
	
	/*
	 * Function to draw a Node given its id and the desired XY position.
	 * Creates and fills the circle and labels it with a number
	 */
	public void drawNode(int id, int x, int y, Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x-20, y-20, 40, 40);
		g.setColor(Color.BLACK);
		g.drawOval(x-20, y-20, 40, 40);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		int width = g.getFontMetrics().stringWidth(Integer.toString(id));
		g.drawString(Integer.toString(id), x-width/2, y+6);
	}
	
	/*
	 * Simple function to make creating the graph structure easier; takes two ints and returns
	 * an ArrayList with them
	 */
	public static ArrayList<Integer> makeP(int node, int dist) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(node);
		x.add(dist);
		return x;
	}
	public static void main(String args[]) {
		ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> store1 = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> store2 = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> store3 = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> store4 = new ArrayList<ArrayList<Integer>>();
		store1.add(makeP(0, 11));
		store1.add(makeP(1, 22));
		store1.add(makeP(3, 44));
		graph.add(store1);
		store2.add(makeP(1, 32));
		store2.add(makeP(2, 43));
		store2.add(makeP(3, 27));
		graph.add(store2);
		store3.add(makeP(0, 10));
		graph.add(store3);
		store4.add(makeP(2, 22));
		store4.add(makeP(3, 55));
		graph.add(store4);
		
		ArrayList<ArrayList<Integer>> listxy = new ArrayList<ArrayList<Integer>>();
		listxy.add(makeP(100, 120));
		listxy.add(makeP(150, 200));
		listxy.add(makeP(108, 40));
		listxy.add(makeP(300, 190));
		
		JFrame jFrame = new JFrame("Graph Visualizer");
		drawGraphXY d = new drawGraphXY(graph, listxy);
		d.setDoubleBuffered(true);
		jFrame.add(d);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(500, 500);
		jFrame.setVisible(true);
	}
}

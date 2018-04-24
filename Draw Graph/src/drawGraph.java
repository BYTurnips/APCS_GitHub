import java.awt.*;
import java.util.*;
import javax.swing.*;

public class drawGraph extends JPanel{
	ArrayList<ArrayList<ArrayList<Integer>>> graph;
	
	public drawGraph(ArrayList<ArrayList<ArrayList<Integer>>> Graph) {
		graph = Graph;
		repaint();
	}
	void paint(Graphics2D g) {
		
	}
	
	public void drawNode() {
		
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
		
		JFrame jFrame = new JFrame("Graph Visualizer");
		drawGraph d = new drawGraph(graph);
		d.setDoubleBuffered(true);
		jFrame.add(d);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(1000, 1000);
		jFrame.setVisible(true);
	}
}

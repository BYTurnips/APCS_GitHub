/*
 * This program implements Dijkstra's Algorithm for graphs of nodes with integer identifiers
 * (denoted by a triple-nested ArrayList). This program fulfills the specifications of the assignment
 * because it does exactly what it should do; it implements the algorithm in ways that allow a user to
 * both calculate the shortest distance and find the shortest path. There are no current errors that I
 * know of, although I haven't extensively tested the getPath() function. Furthermore, from a
 * client-based perspective this program is incomplete because it relies on the fact that the client
 * understands that getPath and getPreviousList are only valid for the parameters used in the most
 * recent call of calcPath; using calcPath more than once in the program requires caution so that
 * the wrong arrays aren't pulled! I would probably fix this with better encapsulation, possibly
 * making the source and end parameters private fields in the graph so they can't be changed.
 * The code essentially runs like a BFS; from the start node, the program stores all the neighbor
 * nodes in a queue for further viewing, then calculates the minimum distance between the start and
 * the currently researched node via use of the edges in the graph. If a new path is discovered that
 * is more optimal between two nodes, the minimum distance is updated. Thus, once most paths are
 * exhausted, what remains is the minimum path to each node.
 * Major challenges included understanding what previous[] was and how to use it and figuring out the
 * best way for manually inputting a graph structure (and finally resorting to the ultimate brute force
 * solution). The relevant Wikipedia article was very helpful in getting me to understand what
 * previous[] did, and Jonathan Park (my classmate) was sort of helpful in that he shared some of his
 * knowledge on the specifications of the assignment.
 */

import java.util.*;

public class Dijkstras {
	ArrayList<ArrayList<ArrayList<Integer>>> graph;
	int[] previous;
	ArrayList<Integer> distances;
	LinkedList<Integer> check;

	/*
	 * Constructs the graph and initializes the relevant data structures
	 */
	public Dijkstras(ArrayList<ArrayList<ArrayList<Integer>>> Graph) {
		graph = Graph;
		previous = new int[Graph.size()];
		check = new LinkedList<Integer>();
	}
	
	/*
	 * Simple function to initialize the distance array of the algorithm; sets the source index
	 * to 0 distance and the rest of them to infinity
	 */
	ArrayList<Integer> setInfinity(int n, int start) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			ar.add(Integer.MAX_VALUE);
		}
		ar.set(start, 0);
		return ar;
	}
	
	/*
	 * Meat and bones of the algorithm; given a start and end node, calculate the shortest path
	 * and fill out the previous[] array.
	 * @param: start node, end node
	 * @return: magnitude of shortest path
	 */
	public int calcPath(int start, int end) {
		for (int i = 0; i < previous.length; i++) {
			previous[i] = -1;
		}
		distances = setInfinity(graph.size(), start);
		check.add(start);
		int cur, id, dist;
		int t = 0;
		while (!check.isEmpty()) {
			cur = check.poll();
			// System.out.print("Checking Node " + cur + ": \n");
			for (ArrayList<Integer> edge : graph.get(cur)) {
				id = edge.get(0);
				dist = edge.get(1) + distances.get(cur);
				// System.out.println("Edge " + id + " " + dist + " ");
				if (distances.get(id) > dist) {
					/*
					 * System.out.println("  Distance from "+start+" to "+id+" changes from "+
					 * distances.get(id)+" to "+dist);
					 */
					distances.set(id, dist);
					check.add(id);
					previous[id] = cur;
				} else if (distances.get(id) < dist) {
					// System.out.println(" Took the long way around...");
				}
			}
			// System.out.println();
		}
		return distances.get(end);
	}
	
	/*
	 * Returns the array of previous values after running the algorithm.
	 * In this array, index I holds the id of the 'previous' node when traveling from the source to I
	 * or -1 if there is no previous node (in case of disconnected graph or if I is the source)
	 * For example, if in a graph the ideal path between node 0 and 4 is 0->3->2->1->4,
	 * then the array would probably look like [-1, 2, 3, 0, 1]
	 */
	public int[] getPreviousList() {
		return previous;
	}
	
	/*
	 * Returns an ArrayList with the nodes along the shortest path from the start to the end
	 */
	public ArrayList<Integer> getPath(int start, int end){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int mark = end;
		while(mark!=start) {
			ans.add(0, mark);
			mark = previous[mark];
		}
		ans.add(0,start);
		return ans;
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

	/*
	 * Driver function to test the algorithm
	 */
	public static void main(String args[]) {
		//Create the graph...
		//Represents {{{0,11},{1,22},{3,44}}, {{1,32},{2,43},{3,27}},{{0,10}},{{2,22},{3,55}}}
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
		
		Dijkstras find = new Dijkstras(graph);
		int start = 1;
		int end = 2;
		//Returns the shortest path given the graph, the start point, and the end point
		System.out.println("Shortest Distance from " + start + " to " + 
					end + " is: " + find.calcPath(start, end));
		System.out.println("The shortest path is: ");
		for (int i : find.getPath(start, end))
			System.out.print(i + " ");
	}
}

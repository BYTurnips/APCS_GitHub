import java.util.*;

/*
 * This class is essentially a container for all the methods included in SetStuff,
 * the CodingBat assignment online. Among other things, it tasks us with creating
 * methods to do ArrayList operations and set operations (such as union).
 * All methods have been tested and refined using the CodingBat test cases.
 */

public class SetStuff {
	ArrayList<Integer> ret17() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(17);
		return a;
	}

	Integer zerothElement(ArrayList<Integer> al) {
		return al.get(0);
	}
	//Returns true if ar[] contains a
	boolean contains(int a, int[] ar) {
		for (int i : ar) {
			if (a == i)
				return true;
		}
		return false;
	}
	//Returns true if any element of a[] is contained in b[]
	boolean anyContains(int[] a, int[] b) {
		for (int x : a) {
			for (int y : b) {
				if (x == y)
					return true;
			}
		}
		return false;
	}
	//Returns the union of two arrays sorted by the order they appeared in the array
	int[] union(int[] a, int[] b) {
		ArrayList<Integer> union = new ArrayList<Integer>();
		for (int n : a)
			union.add(n);
		for (int n : b)
			union.add(n);
		Integer[] Ans = union.toArray(new Integer[0]);
		int[] ans = new int[Ans.length];
		for (int i = 0; i < Ans.length; i++) {
			ans[i] = Ans[i];
		}
		return ans;
	}
	//Returns the intersection of two arrays sorted by natural order
	int[] intersect(int[] a, int[] b) {
		Set<Integer> intersection = new HashSet<Integer>();
		for (int n : a) {
			for (int x : b) {
				if (n == x) {
					intersection.add(n);
					break;
				}
			}
		}
		Integer[] Ans = intersection.toArray(new Integer[0]);
		int[] ans = new int[Ans.length];
		for (int i = 0; i < Ans.length; i++) {
			ans[i] = Ans[i];
		}
		return ans;
	}
	/*
	 * nearestUnvisitedNode: Returns the name of the "node" with the smallest distance
	 * that is still unvisited.
	 */
	String nearestUnvisitedNode(boolean[] visited, int[] distance, String[] nodeName) {
		int mindist = 100000;
		String minstr = "";
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				if (distance[i] < mindist) {
					mindist = distance[i];
					minstr = nodeName[i];
				}
			}
		}
		return minstr;
	}
	
	ArrayList<ArrayList<Object>> addEdge(ArrayList<ArrayList<Object>> graph, int a, int b, int c) {
		graph.add(listify(a, b, c));
		return graph;
	}
	/*
	 * Converts three integers into an ArrayList
	 */
	ArrayList<Object> listify(int a, int b, int c) {
		ArrayList<Object> x = new ArrayList<Object>();
		x.add(a);
		x.add(b);
		x.add(c);
		return x;
	}
	/*
	 * collectNodes: Rather contrived function that takes an ArrayList
	 * of ArrayList of Integers and returns an ArrayList with a union
	 * of the first two elements in each ArrayList
	 */
	ArrayList<Integer> collectNodes(ArrayList<ArrayList<Integer>> edgelist) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		boolean val;
		for (ArrayList<Integer> list : edgelist) {
			val = true;
			for (int x : ans) {
				if (list.get(0) == x) {
					val = false;
					break;
				}
			}
			if (val)
				ans.add(list.get(0));
			val = true;
			for (int x : ans) {
				if (list.get(1) == x) {
					val = false;
					break;
				}
			}
			if (val)
				ans.add(list.get(1));
		}
		return ans;
	}
	
	/*
	 * setInfinity: returns an ArrayList of size 'n' where all elements except
	 * the index 'start' are set to infinity and 'start' is set to 0
	 */
	ArrayList<Integer> setInfinity(int n, int start) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			ar.add(Integer.MAX_VALUE);
		}
		ar.set(start, 0);
		return ar;
	}

}

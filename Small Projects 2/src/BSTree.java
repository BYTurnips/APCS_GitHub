import java.util.*;

/*
 * Prediction: ~15 levels
 * Actual: ~30 levels
 * Reasoning: 15 levels is the best case scenario, so average will be much higher.
 * 
 * Questions:
 * What is the worst case order of growth for finding a datum in a binary search tree?
 * 		The worst case is if the entire tree is just a linked list, so O(n)
 * What is the best case?
 * 		The best case is if the tree is balanced, so O(log n)
 * What do you think the average case order of growth is?  (In other words, if a tree were created as
 	in (3), above, in random order, what would you expect the typical order of growth
 	for searching to be?)
 		Somewhere between the two...maybe O(sqrt{n})?
 * What is the order of growth to insert an element in the tree?
 * 		Should be around the same as searching, so O(sqrt{n})
 * What is the order of growth to print the tree?
 * 		It will always be O(n) because it prints n elements
 */

public class BSTree {
	// The BSTree is actually a node lol
	int id;
	int ind;
	BSTree lower;
	BSTree upper;
	static int inputsize = 10000;

	public static void main(String args[]) {
		int[] arr = new int[inputsize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * inputsize);
		}
		BSTree tree = new BSTree(arr[0], 0);
		for (int i = 1; i < arr.length; i++) {
			tree.add(arr[i], i);
		}
		tree.printTree();
		System.out.println("\n" + tree.depth());
	}

	BSTree(int n, int index) {
		id = n;
		ind = index;
	}

	public String toString() {
		return "Node " + id;
	}
	
	//Getters for each instance field
	public int getVal() {
		return id;
	}
	public BSTree getLower() {
		return lower;
	}
	public BSTree getUpper() {
		return upper;
	}

	//Inserts an element with a recursive process
	public void add(int val, int index) {
		Add(val, index);
	}
	public void Add(int val, int index) {
		if (val > id) {
			if (upper != null)
				upper.Add(val, index);
			else
				upper = new BSTree(val, index);
		} else if (val <= id) {
			if (lower != null)
				lower.Add(val, index);
			else
				lower = new BSTree(val, index);
		}
	}

	// Returns the index of a random value matching the test,
	// unstable with duplicates
	public int findval(int test) {
		if (test == id)
			return ind;
		else if (test > id)
			return upper.findval(test);
		else if (test < id)
			return lower.findval(test);
		else
			return -1;
	}

	//Returns the depth of the tree with a recursive process
	public int depth() {
		int u = 0, l = 0;
		if (lower != null)
			l = lower.depth();
		if (upper != null)
			u = upper.depth();
		return max(l, u) + 1;
	}

	//Small internal max function
	public int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	//Prints the tree in sorted order
	public void printTree() {
		print();
	}
	private void print() {
		if (lower != null)
			lower.print();
		System.out.print(id + " ");
		if (upper != null)
			upper.print();
	}

	//Prints the tree's structure in a (very confusing but deterministic) diagram
	public void printTreeStruct() {
		print(0);
	}
	private void print(int depth) {
		if (upper != null)
			upper.print(depth + 1);
		for (int i = 0; i < depth; i++)
			System.out.print("\t");
		System.out.println(id);
		if (lower != null)
			lower.print(depth + 1);
	}
}

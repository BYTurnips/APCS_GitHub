import java.util.*;
import java.util.concurrent.*;
public class BSTree {
	//The BSTree is actually a node lol
	int id;
	int ind;
	int dep;
	BSTree lower;
	BSTree upper;
	public static void main(String args[]) {
		int[] arr = new int[20];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random()*20);
		}
		BSTree tree = new BSTree (arr[0], 0);
		for(int i=1; i<arr.length; i++) {
			tree.add      (arr[i], i);
		}
		tree.printTree();
	}
	
	BSTree(int n, int index){
		id = n;
		ind = index;
		dep = 0;
	}
	
	BSTree(int n, int index, int depth){
		id = n;
		ind = index;
		dep = depth;
	}

	public String toString() {
		return "Node " + id;
	}

	public int getVal() {
		return id;
	}
	public BSTree getLower() {
		return lower;
	}
	public BSTree getUpper() {
		return upper;
	}
	
	public void add (int val, int index) {
		Add(val, index, 0);
	}
	
 	public void Add (int val, int index, int dep) {
		if (val > id) {
			if (upper!=null) upper.Add(val, index, dep+1);
			else upper = new BSTree(val, index, dep);
		}
		else if (val <= id) {
			if (lower!=null) lower.Add(val, index, dep+1);
			else lower = new BSTree(val, index, dep);
		}
	}
	
	//Returns the index of a random value matching the test,
	// unstable with duplicates
	public int findval (int test) {
		if(test == id) return ind;
		else if(test > id) return upper.findval(test);
		else if(test < id) return lower.findval(test);
		else return -1;
	}
	
	public int depth () {
		if((lower!=null)&&(upper!=null)) return 1;
		return max(lower.depth(), upper.depth()) + 1;
	}
	
	public int max(int a, int b) {
		if (a>b) return a;
		else return b;
	}
	
	public void printTree() {
		print(0);
	}
	private void print(int depth) {
		if (upper!=null) upper.print(depth+1);
		for(int i=0;i<depth; i++) System.out.print("\t");
		System.out.println(id);
		if (lower!=null) lower.print(depth+1);
	} 
	/*private void vertPrint() throws InterruptedException {
		int offset = (int) Math.pow(2, depth()+1);
		LinkedBlockingQueue<BSTree> queue = new LinkedBlockingQueue<BSTree>();
		LinkedBlockingQueue<BSTree> hold = new LinkedBlockingQueue<BSTree>();
		BSTree traverse = this;
		BSTree test;
		queue.put(traverse);
		while(!queue.isEmpty()) {
			while(!queue.isEmpty()) {
				test = queue.take();
				for(int i=0; i<offset-Math.pow(2,test.dep); i++) System.out.print(" ");
				System.out.print(test.id);
				if(            )
			}
			
		}
	}*/
}

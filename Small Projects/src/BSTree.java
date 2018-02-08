
public class BSTree {
	//The BSTree is actually a node lol
	int id;
	int ind;
	BSTree lower;
	BSTree upper;
	public static void main(String args[]) {
		int[] arr = {1, 5, 4, 9, 8, 7};
		BSTree tree = new BSTree (arr[0], 0);
		for(int i=1; i<arr.length; i++) {
			tree.add(arr[i], i);
		}
		System.out.println(tree.findval(9));
		System.out.println(tree.findval(4));
	}
	
	public void add (int val, int index) {
		if (val > id) {
			if (upper!=null) upper.add(val, index);
			else upper = new BSTree(val, index);
		}
		else if (val <= id) {
			if (lower!=null) lower.add(val, index);
			else lower = new BSTree(val, index);
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
	
	BSTree(int n, int index){
		id = n;
		ind = index;
	}
}

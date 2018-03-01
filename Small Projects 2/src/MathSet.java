import java.util.*;

public class MathSet implements Set{
	ArrayList<Integer> store;
	MathSet() {
		store = new ArrayList<Integer>();
	}
	//Adds an element if it isn't already a duplicate
	public boolean add(Object o) {
		for(int i : store) {
			if ((int) o == i) return true;
		}
		store.add((int) o);
		return false;
	}
	//Removes an element if it exists
	public boolean remove(Object o) {
		store.remove(o);
		return false;
	}
	//Checks if a set is empty
	public boolean isEmpty(int[] arr) {
		if (arr.length == 0) return true;
		else return false;
	}
	//Inefficient algorithm to determine if a set is a subset
	public boolean subset(int[] sub, int[] arr) {
		boolean valid, valid2;
		valid2 = true;
		for (int i : sub) {
			valid = false;
			for (int j : arr) {
				if (i == j) valid = true;
			}
			if (valid == false) {
				valid2 = false;
				break;
			}
		}
		return valid2;
	}
	
	//Takes an element and sees if it's part of a set
	public boolean contains(Object o) {
		for (int i : store) {
			if ((int) o == i)
				return true;
		}
		return false;
	}

	// Union: takes two arrays and returns their union (no duplicates)
	public static int[] union(int[] a, int[] b) {
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

	// Intersection: takes two arrays and returns their intersection
	public static int[] intersection(int[] a, int[] b) {
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
	@Override
	public int size() {
		return store.size();
	}
	@Override
	public boolean isEmpty() {
		return store.isEmpty();
	}
	@Override
	public Iterator iterator() {
		return store.iterator();
	}
	@Override
	public Object[] toArray() {
		return store.toArray();
	}
	@Override
	public Object[] toArray(Object[] a) {
		if(a.length>store.size()) {
			for(int i=0;i<store.size();i++) {
				a[i]=store.get(i);
			}
			a[store.size()] = null;
		}
		return null;
	}
	
	//Collection equivalent of the single-element methods above
	//Each element in the collection undergoes the process.
	@Override
	public boolean containsAll(Collection c) {
		for(Object o: c) if(!contains(o)) return false;
		return true;
	}
	@Override
	public boolean addAll(Collection c) {
		for(Object o: c) add(o);
		return true;
	}
	//Only retains elements contained in collection c
	@Override
	public boolean retainAll(Collection c) {
		for(Object o: c) if(!contains(o)) remove(o);
		return false;
	}
	@Override
	public boolean removeAll(Collection c) {
		for(Object o: c) remove(o);
		return false;
	}
	@Override
	public void clear() {
		store.clear();
	}
}

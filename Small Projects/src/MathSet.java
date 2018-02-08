import java.util.*;

public class MathSet {
	
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
	public boolean contains(int a, int[] ar) {
		for (int i : ar) {
			if (a == i)
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
}

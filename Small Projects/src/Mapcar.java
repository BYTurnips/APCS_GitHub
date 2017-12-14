import java.util.*;
import java.util.function.*;

public class Mapcar {
	public static void main(String args[]) {
		// Initializes collections used
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arr1.add(i);
			arr2.add(i);
		}

		// Prepares the argument collection of collections for use by mapcar
		ArrayList<ArrayList<Integer>> argus = new ArrayList<ArrayList<Integer>>();
		argus.add(arr1);
		argus.add(arr2);

		// Prints the result mapcar returns
		ArrayList<Integer> arrF = new ArrayList<Integer>();
		arrF = mapcar(argus, Mapcar::sum);
		for (int i = 0; i < 10; i++) {
			System.out.println(arrF.get(i));
		}
	}

	/*
	 * Emulates mapcar from lisp (given an ArrayList of arguments and a function
	 * @params: an ArrayList of Collections to be evaluated, and a function in the class that
	 * 			can take a variable number of integer arguments and returns an integer
	 * @return: the resulting collection
	 */
	public static ArrayList<Integer> mapcar(ArrayList<ArrayList<Integer>> lists,
			Function<ArrayList<Integer>, Integer> fn) {
		
		//result array
		ArrayList<Integer> ans = new ArrayList<Integer>(); 
		//array to store parameters for the function
		ArrayList<Integer> params = new ArrayList<Integer>(); 
		
		//Loops through the collection; equivalent of foreach
		for (int i = 0; i < lists.get(0).size(); i++) {
			params.clear();
			try {
				for (ArrayList<Integer> q : lists) {
					//Insert parameters into the params collection
					params.add(q.get(i));
				}
				//Evaluates the function with the parameters and addes the result to the ans collection
				ans.add(fn.apply(params));
			} catch (ArrayIndexOutOfBoundsException e) {
				//In case the arrays given were different sizes
				break;
			}
		}
		return ans;
	}
	
	/*
	 * Example functions to use with mapcar
	 * All functions must take a single ArrayList argument to emulate their parameters
	 * However, they can be as complicated 
	 */
	public static Integer sum(ArrayList<Integer> n) {
		int s = 0;
		for (Integer i : n) {
			s += i;
		}
		return s;
	}

	public static Integer square(ArrayList<Integer> n) {
		return n.get(0) * n.get(0);
	}
}
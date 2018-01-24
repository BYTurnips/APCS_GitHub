import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;

public class Vocab14 {
	//Union: takes two arrays and returns their union (no duplicates)
	public static int[] union(int[] a, int[] b) {
		Set<Integer> union = new HashSet<Integer>();
		for(int n:a) union.add(n);
		for(int n:b) union.add(n);
		Integer[] Ans = union.toArray(new Integer[0]);
		int[] ans = new int[Ans.length];
		for(int i=0;i<Ans.length;i++) {
			ans[i]=Ans[i];
		}
		return ans;
	}
	
	//Intersection: takes two arrays and returns their intersection
	public static int[] intersection(int[] a, int[] b) {
		Set<Integer> intersection = new HashSet<Integer>();
		for(int n:a) {
			for(int x:b) {
				if (n==x) {
					intersection.add(n);
					break;
				}
			}
		}
		Integer[] Ans = intersection.toArray(new Integer[0]);
		int[] ans = new int[Ans.length];
		for(int i=0;i<Ans.length;i++) {
			ans[i]=Ans[i];
		}
		return ans;
	}
	
	//Setdiff: returns the elements that are in the source but not in the remove
	public static int[] setdiff(int[] remove, int[] source) {
		Set<Integer> setdiff = new HashSet<Integer>();
		boolean add;
		for(int n:source) {
			add = true;
			for(int x:remove) {
				if (n==x) {
					add = false;
					break;
				}
			}
			if (add) setdiff.add(n);
		}
		Integer[] Ans = setdiff.toArray(new Integer[0]);
		int[] ans = new int[Ans.length];
		for(int i=0;i<Ans.length;i++) {
			ans[i]=Ans[i];
		}
		return ans;
	}
	
	//Limit: approximates the limit of a function at a given x value (resolution of 0.00001)
	public static double limit(Function<Double, Double> f, double x) {
		try {
			return f.apply(x);
		} catch (Exception e) {
			return f.apply(x+0.00001);
		}
	}
	private static Double f(Double x) {
		return 1/x;
	}
	
	//L'Hopital's Rule: Given a rational function in the form of top (numerator) and bottom (denominator), 
	//      this function will determine whether lHopital's rule should be used to prevent indetermination
	//      if x==0 then it will calculate limit at 0, if x==1 then infinity, if x==-1 then minus infinity
	public static boolean lHopital(Function<Double,Double> top, Function<Double,Double> bottom, int x) {
		double xcor;
		if(x==0) xcor = 0;
		else if(x==1) xcor = Double.POSITIVE_INFINITY;
		else xcor = Double.NEGATIVE_INFINITY;
		if(Double.isInfinite(top.apply(xcor))&&Double.isInfinite(bottom.apply(xcor))) return true;
		if((top.apply(xcor)==0)&&(bottom.apply(xcor)==0)) return true;
		else return false;
	}
	private static Double top(Double x) {
		return Math.sqrt(x);
	}
	private static Double bottom(Double x) {
		return Math.log(x);
	}
	
	//Standard Deviation: Calculates the standard deviation of an array of numbers
	public static double stdDev(int[] arr) {
		double mean=0;
		for(int i:arr) mean+=i;
		mean/=arr.length;
		double sumofDiffs=0;
		for(int i:arr) sumofDiffs+=(i-mean)*(i-mean);
		return Math.sqrt(sumofDiffs/(arr.length-1));
	}
	
	//Binomial Coefficient: Recursively calculates a binomial coefficient given n and k
	public static BigInteger biCoef(int n, int k) {
		if(k>n) return BigInteger.valueOf(1); //something went wrong;
		if((k==0)||(k==n)) return BigInteger.valueOf(1);
		return biCoef(n-1, k-1).add(biCoef(n-1,k));
	}
	
	public static void main(String args[]) {
		int[] a = {1, 2, 3};
		int[] b = {2, 3, 4};
		int[] array = setdiff(a, b);
		print(array);
		System.out.println(limit(Vocab14::f, 0));
		System.out.println(lHopital(Vocab14::top, Vocab14::bottom, 1));
		System.out.println(stdDev(a));
		System.out.println(biCoef(30,15));
	}
	public static void print(int[] arr) {
		System.out.print("{");
		for(int i=0;i<arr.length-1;i++) System.out.print(arr[i]+", ");
		System.out.println(arr[arr.length-1]+"}");
	}
}

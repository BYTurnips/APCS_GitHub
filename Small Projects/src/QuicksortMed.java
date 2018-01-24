import java.util.*;

//Modifies quicksort to find the median of an array
public class QuicksortMed {
	//Find Mode: 0 = median, -1 = minimum, 1 = maximum;
	//twoMed: true = two medians, false = one median;
	public static float quicksortMed(ArrayList<Integer> arr, int medInd, int lowInd, int highInd, int mode, boolean twoMed) {
		//Finds the extremity in the case that one of the two medians have been selected as the pivot
		if(mode!=0) {
			int ext = arr.get(0);
			for(int i:arr) {
				if (ext*mode < i*mode) ext = i;
			}
			return ext;
		}
		if(lowInd>highInd) return -1;
		boolean found = true;
		int temp = arr.get(0);
		for(int i:arr) if(i!=temp) found = false;
		if (found) return temp;
		else {
			int pivot = arr.get(0);
			for(int i:arr) {
				if (i<pivot) {
					pivot = i;
					break;
				}
			}
			ArrayList<Integer> lower = new ArrayList<Integer>();
			ArrayList<Integer> upper = new ArrayList<Integer>();
			for(int i:arr) {
				if(i<=pivot) lower.add(i);
				else upper.add(i);
			}
			//only find one median
			if(!twoMed) {
				if(lowInd+lower.size()>medInd) return quicksortMed(lower, medInd, lowInd, highInd-upper.size(), 0, twoMed);
				else return quicksortMed(upper, medInd, lowInd+lower.size(), highInd, 0, twoMed);
			}
			//must find two medians
			else {
				if(lowInd+lower.size()>medInd) return quicksortMed(lower, medInd, lowInd, highInd-upper.size(), 0, twoMed);
				else if(highInd-upper.size()<medInd-1) return quicksortMed(upper, medInd, lowInd+lower.size(), highInd, 0, twoMed);
				else if(lowInd+lower.size()==medInd) return (quicksortMed(upper, medInd, lowInd+lower.size(), highInd, -1, twoMed)+pivot)/2;
				else if(highInd-upper.size()==medInd-1) return (quicksortMed(lower, medInd, lowInd, highInd-upper.size(), 1, twoMed)+pivot)/2;
				else return pivot;
			}
		}
	}
	public static void main(String args[]) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random rand = new Random();
		boolean test = true;
		if (test) {
			for(int j=0;j<10;j++) {
				System.out.print("Array: ");
				for(int i=0;i<5;i++) {
					arr.add(rand.nextInt(10));
					System.out.print(arr.get(i)+" ");
				}
				System.out.print("yields a median of ");
				System.out.println(quicksortMed(arr, arr.size()/2, 0, arr.size()-1, 0, arr.size()%2==0));
				arr.clear();
			}
		}
		else {
			arr.addAll(Arrays.asList(53,38,73,64,66,13,66,89,83,53,66,18,65,62,75,2,64,82,78,97));
			System.out.print("Array: ");
			for(int i=0;i<20;i++) System.out.print(arr.get(i)+" ");
			System.out.println();
			System.out.println(quicksortMed(arr, arr.size()/2, 0, arr.size()-1, 0, arr.size()%2==0));
			arr.clear();
		}
		
	}
}
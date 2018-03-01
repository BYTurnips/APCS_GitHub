import java.util.Random;

public class ThreeSorts {
	static Random rand = new Random();

	public static void bubblesort(int[] arr) {
		//For every element in the array...
		for (int i = arr.length - 1; i > 0; i--) {
			//Perform a series of swaps to make sure the largest value goes to the top
			for (int j = 0; j < i; j++) {
				//Check if largest value
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}
	
	public static void insertionsort(int[] arr) {
		//For every element in the array (except the first)...
		for(int i=1;i<arr.length;i++) {
			//Find the right place to insert that element and shift everything to accommodate
			for(int j=0;j<i;j++) {
				//Check if the new element will be less than the test element
				//If it is, the correct location is determined and the element is shifted in
				if(arr[j]>arr[i]) shift(arr,j,i);
			}
		}
	}
	
	public static void selectionsort(int[] arr) {
		int minind;
		//For every element in the array...
		for(int i=0;i<arr.length;i++) {
			minind=i;
			//Find minimum value in the unsorted portion
			for(int j=i;j<arr.length;j++) {
				if(arr[j]<arr[minind]) minind=j;
			}
			//Place that minimum value in the sorted portion
			swap(arr,i,minind);
		}
	}

	public static void main(String args[]) {
		int[] arr = new int[50];
		//Initialize the array with values
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		shuffle(arr);
		System.out.println("This is an unsorted array: ");
		print(arr);
		bubblesort(arr);
		System.out.println("Now sorted with bubble sort: ");
		print(arr);
		System.out.println();
		shuffle(arr);
		System.out.println("This is another unsorted array: ");
		print(arr);
		insertionsort(arr);
		System.out.println("Now sorted with insertion sort: ");
		print(arr);
		System.out.println();
		shuffle(arr);
		System.out.println("This is yet another unsorted array: ");
		print(arr);
		selectionsort(arr);
		System.out.println("Now sorted with selection sort: ");
		print(arr);
	}
	
	public static void print(int[] arr) {
		//Simple function to format and print an array (design taken from a Python list)
		System.out.print("[");
		for(int i=0;i<arr.length-1;i++) {
			System.out.print(arr[i]+", ");
			//Quick newline to prevent ugly horizontal scrolling
			if ((i%20==0)&&(i>0)) System.out.print("\n");
		}
		System.out.print(arr[arr.length-1]+"]\n");
	}

	public static void shuffle(int[] arr) {
		//Standard function to shuffle an array:
		//For every element in the array, swap that element with another random element
		for (int i = 0; i < arr.length; i++) {
			swap(arr, i, rand.nextInt(arr.length - i) + i);
		}
	}

	public static void swap(int[] arr, int a, int b) {
		//Takes an array and two indices and swaps the values at those indices
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	
	public static void shift(int[] arr, int shift, int jump) {
		//Takes an array, a shift index, and a jump index
		//Moves the jump value to the shift index and 'shifts' everything else up one
		//Ex: arr = [1, 8, 3, 2] shift = 1 jump = 3 so new arr = [1, 2, 8, 3]
		int t=arr[jump];
		for(int i=jump; i>shift; i--) {
			arr[i]=arr[i-1];
		}
		arr[shift]=t;
	}
}

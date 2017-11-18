import java.util.Random;

public class ThreeSorts {
	static Random rand = new Random();

	public static void bubblesort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}
	
	public static void insertionsort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[i]) shift(arr,j,i);
			}
		}
	}
	
	public static void selectionsort(int[] arr) {
		int minind;
		for(int i=0;i<arr.length;i++) {
			minind=i;
			for(int j=i;j<arr.length;j++) {
				if(arr[j]<arr[minind]) minind=j;
			}
			swap(arr,i,minind);
		}
	}

	public static void main(String args[]) {
		int[] arr = new int[50];
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
		System.out.print("[");
		for(int i=0;i<arr.length-1;i++) {
			System.out.print(arr[i]+", ");
			if ((i%20==0)&&(i>0)) System.out.print("\n");
		}
		System.out.print(arr[arr.length-1]+"]\n");
	}

	public static void shuffle(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			swap(arr, i, rand.nextInt(arr.length - i) + i);
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	
	public static void shift(int[] arr, int shift, int jump) {
		int t=arr[jump];
		for(int i=jump; i>shift; i--) {
			arr[i]=arr[i-1];
		}
		arr[shift]=t;
	}
}

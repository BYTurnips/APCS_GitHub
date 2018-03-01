/*
VOCAB 11:
Try
catch
finally
error
compile time error
run time error
error correction code*/

public class Vocab11 {
	// this method SHOULD print all numbers from 1 to 10 in a horizontal line
	public static void main(String args[]) {
		int[] arr = new int[10];
		int i = 0;
		while (true) {
			try { // try clause
				arr[i] = i+1;
			} catch (ArrayIndexOutOfBoundsException e) { // catch clause
				break;
			} finally { // finally clause
				i++;
			}
		}
		for (i = 0; i < 10; i++) { // error correction code
			if (arr[i] != 0)
				System.out.print(arr[i]); // Runtime error: there are no spaces b/w numbers
			else {
				arr[i] = i + 1;
				i--; // Compile Time error: there is no terminating semicolon
			}
		}
	}
}

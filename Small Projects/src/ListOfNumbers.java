import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {
	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++)
			list.add(new Integer(i));
	}

	public void writeList() {
		PrintWriter out = null;
		try {
			System.out.println("Entering try statement");
			out = new PrintWriter(new FileWriter("OutFile.txt"));

			for (int i = 0; i < SIZE; i++)
				out.println("Value at: " + i + " = " + list.get(i));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
	}

	public void readList() {
		String line = null;
		try {
			RandomAccessFile stream = new RandomAccessFile("test.txt", "r");
			line = stream.readLine();
			while (line != null) {
				Integer i = new Integer(Integer.parseInt(line));
				System.out.println(i);
				list.add(i);
				line = stream.readLine();
			}
		} catch (IOException io) {
			System.err.println(io.toString());
		}

	}
}
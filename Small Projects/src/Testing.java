import java.io.*;

public class Testing {
	public static void main(String args[]) {
		try {
			InputStream in = new FileInputStream("testIn.txt");
			OutputStream out = new FileOutputStream("testOut.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
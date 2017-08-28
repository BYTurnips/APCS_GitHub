import java.lang.*;

public class Main {
	public int ret() {
		return 17;
	}
	public boolean logic(boolean a, boolean b, boolean c) {
		return (a&&b)&&c;
	}
	public String stars(int n) {
		String a = "";
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) a += "*";
			a += "\n";
		}
		return a;
	}
	public int coins(int n) {
		if((n%5)%2 == 0) return (n/5+(n%5)/2);
		else if(n>5) return (n/5-1+(n%5+5)/2);
		else return -1;
	}
	/*
	 * Driver method to test other methods
	 * @param args
	 * @return nothing
	 */
	public static void main(String args[]) {
		Main m = new Main();
		System.out.println(m.stars(6));
	}
}


public class functions {
	public static int recSeq(int n) {
		if (n < 3)
			return n;
		return recSeq(n - 1) + 2 * recSeq(n - 2) + 3 * recSeq(n - 3);
	}

	public static int iterSeq(int n) {
		int a = 0, b = 1, c = 2, t;
		for (int i = 0; i < n; i++) {
			a = c + 2 * b + 3 * a;
			t = a;
			a = b;
			b = c;
			c = t;
		}
		return a;
	}

	public static void pascal(int n) {
		int[][] tri = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tri[i][j] = 0;
			}
			tri[i][0] = 1;
			tri[i][i] = 1;
		}
		pRec(0, n, tri);
	}

	public static void pRec(int x, int n, int tri[][]) {
		if (x == n) {
			for (int i = 0; i < n; i++) {
				for (int j=n-1; j>i; j--) {
					System.out.print("\t");
				}
				for (int j = 0; j <= i; j++) {
					System.out.print(tri[i][j] + "\t\t");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 0; i < x; i++) {
			if (tri[x][i] == 0)
				tri[x][i] = tri[x - 1][i] + tri[x - 1][i - 1];
		}
		pRec(x + 1, n, tri);
	}

	public static void main(String args[]) {
		System.out.println(recSeq(3));
		System.out.println(iterSeq(3));
		System.out.println();
		pascal(10);
	}
}

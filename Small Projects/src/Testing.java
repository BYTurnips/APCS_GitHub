public class Testing {
	public interface dashboard {
		int control(int i);
	}
	public class vehicle {
		
	}
	public class car extends vehicle implements dashboard {
		public int control (int i) {
			return 1;
		}
	}
	public void main2() {
		vehicle a = new car();
		/*dashboard b = new vehicle();
		dashboard c = new car();
		car d = new dashboard();
		vehicle q = new dashboard();
		car e = new vehicle();
		dashboard f = new dashboard();*/
	}
	public static void main(String args[]) {
		Testing t = new Testing();
		t.main2();
	}
}
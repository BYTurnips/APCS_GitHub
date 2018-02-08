import java.util.Random;

public class Randp {
	private int[] nums;
	private int numsLeft;
	
	public static void main(String args[]) {
		int n = 100;
		Randp r = new Randp(n);
		for(int i=0;i<n+4; i++) {
			System.out.println(r.nextInt());
		}                        
	}
	public Randp(int n) {
		numsLeft = n;
		initNums(n);
    }

	private void initNums(int n) {
		nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = i+1;
		}
		Random rand = new Random();
		int ind, temp;
		for(int i=n-1; i>1; i--) {
			ind = rand.nextInt(i-1);
			temp = nums[i];
			nums[i] = nums[ind];
			nums[ind] = temp;
		}
    }

	public int nextInt() {
		if (numsLeft == 0) return 0;
		else return nums[numsLeft-- -1];
    }
}

import java.util.ArrayList;

public class FRQ_2017_P1 {
	public ArrayList<Integer> digitList;
	public FRQ_2017_P1(int num) {
		//Forgot about ArrayList.add(index, num) so made this constructor very complicated
		//-1 point, forgot case where num = 0;
		digitList = new ArrayList<Integer>();
		int length = 0, test = num;
		if(num == 0) {
			digitList.add(0);
			return;
		}
		while(test>0) {
			test /= 10;
			length++;
		}
		int[] store = new int[length];
		for(int i=0; i<length; i++) {
			store[length-i-1] = num%10;
			num /= 10;
		}
		for(int i: store) digitList.add(i);
	}
	public boolean isStrictlyIncreasing() {
		//-1 point, confused ArrayList.get() with array[]
		for(int i=1; i<digitList.size();i++) if(digitList.get(i)<=digitList.get(i-1)) return false;
		return true;
	}
	public static void main(String args[]) {
		FRQ_2017_P1 test = new FRQ_2017_P1(0);
		for(int i: test.digitList) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println(test.isStrictlyIncreasing());
	}
}

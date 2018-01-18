import java.io.*;
import java.util.ArrayList;

public class Testing {
	public static void main(String args[]) {
		go();
	}
	public static void go(){
		int[] el = {1,2,3};
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int e:el) al.add(e);
                int v = 6;

		alterThings(v,el,al);

		pr(v);
		apr(el);
		apr(al);
	}

	static int v;

	public static void alterThings(int val, int[] ar,
                                       ArrayList<Integer> al){
		v = 0;
		for(int e:ar) e = 0;
		for(int e:al) e = 0;
	}

	private static void apr(ArrayList<Integer> el) {
		for(int e:el) pr(e);	
	}

	private static void apr(int[] el) {
		for(int e:el) pr(e);
	}
	
	public static void pr(int e) {
		
	}

}
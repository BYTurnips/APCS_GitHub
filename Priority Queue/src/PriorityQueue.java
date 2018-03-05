import java.util.*;
import java.util.function.*;

public class PriorityQueue {
	//private BiFunction<Integer, Integer, Boolean> fn;
	//Using a comparator is more standard, but I don't want to deal with it
	private Comparator<Integer> c;
	public ArrayList<Integer> queue = new ArrayList<Integer>();
	
	public static void main(String args[]) {
		Comparator<Integer> myComp = new Comparator<Integer>() {
		    public int compare(Integer a, Integer b) {
		        if(a<b) return 1;
		        else if(a==b) return 0;
		        else return -1;
		    }
		};
		PriorityQueue pq = new PriorityQueue(myComp);
		PriorityQueue opq = new PriorityQueue(myComp);
		Random rand = new Random();
		for(int i=0;i<20;i++) {
			pq.add(rand.nextInt(50));
			opq.add(rand.nextInt(60));
		}
		
		//System.out.println(opq);
		//pq.merge(opq);
		System.out.println(pq);
		pq.remove(8);
		System.out.println(pq);
	}
	//Constructors that don't create an initial capacity but can take a custom comparator
	PriorityQueue(){
		c = new Comparator<Integer>() {
		    public int compare(Integer a, Integer b) {
		        if(a>b) return 1;
		        else if(a==b) return 0;
		        else return -1;
		    }
		};
	}
	
	PriorityQueue(Comparator<Integer> func) {
		c = func;
	}
	
	//Adds an element into its properly sorted place in the queue
	public void add(int element) {
		if(queue.size()==0) {
			queue.add(element);
			return;
		}
		for(int i=0;i<queue.size();i++) {
			if(c.compare(queue.get(i), element)>=0) {
				queue.add(i, element);
				return;
			}
		}
		queue.add(element);
	}
	//Clears the queue
	public void clear() {
		queue.clear();
	}
	//Checks if an element is contained in a queue
	public boolean contains(int a) {
		return queue.contains(a);
	}
	//Returns the value of the queue head without removing it
	public int peek() {
		return queue.get(queue.size()-1);
	}
	//Returns the value of the queue head and removes it
	public int poll() {
		int i = queue.get(queue.size()-1);
		queue.remove(queue.size()-1);
		return i;
	}
	//Removes a value from the queue if it existed
	public boolean remove(int a) {
		return queue.remove((Integer) a);
	}
	//Returns size of the queue
	public int size() {
		return queue.size();
	}
	//Returns an array version of the queue
	public int[] toArray() {
		int[] ar = new int[queue.size()];
		for(int i=0;i<queue.size();i++) {
			ar[i]=queue.get(i);
		}
		return ar;
	}
	/*
	 * Uses a modified version of heap sort to merge another
	 * priority queue into this queue. Runs in O(n) time.
	 */
	public void merge(PriorityQueue opq) {
		int ind=0;
		boolean exhaust=false;
		for(int i:opq.toArray()) {
			if(exhaust) queue.add(i);
			else {
				while(c.compare(queue.get(ind),i)<=0) {
					ind++;
					if(ind>=queue.size()) {
						exhaust=true;
						break;
					}
				}
				queue.add(ind, i);
			}
		}
	}
	//Function to allow directly PriorityQueue printing in terminal
	public String toString(){
		String str = new String();
		for(int i:queue) {
			str=str.concat(i+" ");
		}
		try{
			return str.substring(0,str.length()-1);
		} catch(Exception e) {
			return "Empty!";
		}
	}
}
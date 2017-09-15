import java.lang.*;
import java.util.*;

public class LogicPuzzle {
	public static void main(String[] args) {
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		LogicalSentence l5 =  new Conjunction(l3, new Negation(l4));

		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b,true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));

		String[] pc = {"p"};
		truthTable(pc);
	}
	//Represents a certain configuration of the proposition constants and their truths
	public static class TruthAssignment {
		HashMap<String,Boolean> map = new HashMap<>();
		//Places a proposition constant and its truth value into the hash map
		public void put(PropositionConstant key, boolean value) {
			map.put(key.name, value);
		}
		//Given a constant, returns its value
		public boolean get(String name) {
			return map.get(name);
		}
	}
	public static class PropositionConstant {
		String name;
		public PropositionConstant (String Name) {
			name = Name;
		}
	}
	//Equivalent to wire directly leading from a constant
	public static class LogicalSentence {
		String name;
		//No parameter constructor to allow subclass constructors
		public LogicalSentence () {}
		public LogicalSentence (PropositionConstant x) {
			name = x.name;
		}
		//Calls the TruthAssignment
		public boolean evaluate (TruthAssignment x) {
			return x.get(name);
		}
	}
	//Equivalent to NOT gate
	public static class Negation extends LogicalSentence {
		LogicalSentence child;
		public Negation (LogicalSentence x) {
			child = x;
		}
		public boolean evaluate (TruthAssignment x) {
			return !(child.evaluate(x));
		}
	}
	//Equivalent to AND gate
	public static class Conjunction extends LogicalSentence {
		LogicalSentence child1, child2;
		public Conjunction (LogicalSentence x1, LogicalSentence x2) {
			child1 = x1;
			child2 = x2;
		}
		public boolean evaluate (TruthAssignment x) {
			return (child1.evaluate(x) && child2.evaluate(x));
		}
	}
	//Equivalent to OR gate
	public static class Disjunction extends LogicalSentence {
		LogicalSentence child1, child2;
		public Disjunction (LogicalSentence x1, LogicalSentence x2) {
			child1 = x1;
			child2 = x2;
		}
		public boolean evaluate (TruthAssignment x) {
			return (child1.evaluate(x) || child2.evaluate(x));
		}
	}
	//Conditional gate (if child1 then child2)
	public static class Conditional extends LogicalSentence {
		LogicalSentence child1, child2;
		public Conditional (LogicalSentence x1, LogicalSentence x2) {
			child1 = x1;
			child2 = x2;
		}
		public boolean evaluate (TruthAssignment x) {
			return (!child1.evaluate(x) || child2.evaluate(x));
		}
	}
	//Biconditional gate (child1 iff child2)
	public static class Biconditional extends LogicalSentence {
		LogicalSentence child1, child2;
		public Biconditional (LogicalSentence x1, LogicalSentence x2) {
			child1 = x1;
			child2 = x2;
		}
		public boolean evaluate (TruthAssignment x) {
			return (child1.evaluate(x) == child2.evaluate(x));
		}
	}
	/*
	 * Returns the index of the rightmost character in a substring 
	 * with at most numpara pairs of matching parentheses
	 * @param string to test and number of pairs of matching parentheses
	 * @return index of the rightmost valid character
	 */
	public static int findMatch(String input, int numpara) {
		int curpara = 0;
		int testind = 0;
		int curind = input.length()-1;
		for(int i=input.length()-1; i>=0; i--) {
			if(input.charAt(i) == ')') {
				testind = i-1;
			}
			if(input.charAt(i) == '(') {
				curpara++;
				if (curpara >= numpara) {
					curind = testind;
					break;
				}
			}
		}
		return curind;
	}
	/*
	 * Takes a string and returns if it's a legal logical expression
	 * Copied and adapted from legalSentence
	 * @param string to test
	 * @return a bool representing whether the test string is a legal logical expression or not
	 */
	public static boolean legal(String input) {
		int numpara=0;
		boolean charbef=false, bad=false;
		char c;
		for(int i=0; i<input.length(); i++) {
			c=input.charAt(i);
			if (c==' ') {
				continue;
			}
			else if(c=='~') {
				if(charbef) {
					bad=true;
					break;
				}
				else {
					charbef=false;
					continue;
				}
			}
			else if(c=='(') {
				numpara++;
				continue;
			}
			else if(c==')') {
				if(!charbef) {
					bad=true;
					break;
				}
				else {
					numpara--;
					continue;
				}
			}
			else if(Character.isLetter(c)) {
				if(charbef) {
					bad=true;
					break;
				}
				else charbef=true;
			}
			else if((c=='&')||(c=='|')){
				if(!charbef) {
					bad=true;
					break;
				}
				else {
					charbef=false;
					continue;
				}
			}
			else {
				bad=true;
				break;
			}
		}
		if (numpara!=0) bad=true;
		return bad;
	}
	/*
	 * Prepares and calls a recursive function that prints a truth table
	 * @param String array of variables to make truth table with
	 * @return none, but prints table header to screen
	 */
	public static void truthTable(String[] strarr) {
		boolean[] boolarr = new boolean[strarr.length];
		for(int i=0; i<strarr.length; i++) {
			System.out.print(strarr[i]+"\t");
		}
		System.out.print("\n");
		
		calcTable(strarr, boolarr, 0);
	}
	/*
	 * Recursively creates a truth table
	 * @param String of variables to make truth table with and recursive parameters
	 * @return none, but prints truth table to screen
	 */
	public static void calcTable(String[] strarr, boolean[] boolarr, int ind) {
		if(ind == strarr.length) {
			for(int i=0; i<strarr.length; i++) {
				System.out.print(boolarr[i]+"\t");
			}
			System.out.print("\n");
			return;
		}
		boolarr[ind] = true;
		calcTable(strarr, boolarr, ind+1);
		boolarr[ind] = false;
		calcTable(strarr, boolarr, ind+1);
	}
}
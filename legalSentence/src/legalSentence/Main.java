package legalSentence;

import java.io.*;
import java.lang.Character;

public class Main {
	/*
	 * Runs legalSentence, takes the result, and prints a corresponding statement
	 * @param args
	 * @return none, but prints to screen
	 */
	public static void main(String [] args) throws IOException{
		boolean bad=legalSentence();
		if(bad) System.out.println("That was not a legal logical expression");
		else System.out.println("That was a legal logical expression");
	}
	/*
	 * Takes a string and returns if it's a legal logical expression
	 * @param string to test
	 * @return a bool representing whether the test string is a legal logical expression or not
	 */
	public static boolean legalSentence() throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		String input=br.readLine();
		System.out.println(input);
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
}
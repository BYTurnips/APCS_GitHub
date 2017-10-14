import java.util.Scanner;

/*
 * Created by Brion Ye, uses Chinese Remainder Theorem to solve
 * systems of modular congruences (here labeled as "equations").
 * I got this idea because I had wanted to learn about how to use
 * the theorem to solve problems involving modular arithmetic, and
 * decided that it was a mechanical process that could easily be
 * turned into a program. Comments explain the process.
 */

public class main {
	//Equation class holds the two properties
	public static class Equation {
		int residue;
		int modulus;
	}
	/*
	 * Driver function takes input
	 * @param args
	 * @return none, but prints to screen
	 */
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		Equation answer = new Equation();
		
		//Take input from user
		int num = 0;
		System.out.println("How many equations will you input?");
		num = s.nextInt();
		Equation[] system = new Equation[num];
		System.out.println("Enter your equations (in the form \"r mod n\"): ");
		for (int i = 0; i < num; i++) {
			system[i] = new Equation();
			system[i].residue = s.nextInt();
			s.next();
			system[i].modulus = s.nextInt();
		}
		
		/*
		 * loops through the system of equations, merging each two and setting
		 * the merged result as an operand for the next iteration.
		 */
		for (int i = 0; i < num - 1; i++) {
			answer = mergeCongruence(system[i], system[i + 1]);
			
			//Check for invalid parameters
			if (answer.modulus == -1) {
				System.out.println("This is impossible");
				break;
			}
			
			system[i + 1] = answer;
		}
		//Print the final answer
		System.out.println("The answer is: " + answer.residue + " mod " + answer.modulus);
	}
	
	/*
	 * Returns the merged form of two equations (in the form of another equation)
	 * via the Chinese Remainder Theorem (commonly used in modular arithmetic). 
	 * Details can be found on https://brilliant.org/wiki/chinese-remainder-theorem/
	 * @param two equations
	 * @return merged equation
	 */
	public static Equation mergeCongruence(Equation a, Equation b) {
		Equation answer = new Equation();
		//Switches equations if necessary to prepare for algorithm
		//because the first equation must have the lower modulus
		if (a.modulus > b.modulus) {
			int hold;
			hold = a.modulus;
			a.modulus = b.modulus;
			b.modulus = hold;
			hold = a.residue;
			a.residue = b.residue;
			b.residue = hold;
		}
		//stores initial values (because the moduli and residues will be changed)
		int leftMod = a.modulus;
		int rightMod = b.modulus;
		int rightRes = b.residue;
		
		//equation at this step: x*b.mod + b.res = a.res
		
		//take the equation mod a.mod
		b.modulus %= a.modulus;
		b.residue %= a.modulus;
		
		//equation at this step: (new x)*b.mod + b.res == a.res mod a.mod
		
		//solve for b.mod
		a.residue -= b.residue;
		//check for invalid parameters
		if (inverse(b.modulus, a.modulus) == -1) {
			answer.modulus = -1;
			return (answer);
		}
		a.residue *= inverse(b.modulus, a.modulus);
		a.residue %= a.modulus;
		if (a.residue < 0)
			a.residue += a.modulus;
		
		//final modulus is product of original two moduli
		answer.modulus = leftMod * rightMod;
		//final residue is essentially substituted back into the original equation
		answer.residue = a.residue * rightMod + rightRes;
		return (answer);
	}
	
	/*
	 * Given modulus n and number m < n, computes its modular inverse x 
	 * such that (x * m) == 1 mod n.
	 * @param modulo and number
	 * @return inverse (or -1 if there is none)
	 */
	public static int inverse(int res, int mod) {
		for (int i = 0; i < mod; i++) {
			//checks if the number is an inverse
			if ((res * i) % mod == 1)
				return (i);
		}
		return (-1);
	}
}

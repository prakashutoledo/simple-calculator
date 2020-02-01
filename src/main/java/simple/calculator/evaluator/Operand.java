package simple.calculator.evaluator;

/**
 * Operand class used to represent an operand in a valid mathematical
 * expression.
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 *
 */
public class Operand {
	private int value;

	public Operand(String token) {
		this(Integer.parseInt(token));
	}

	public Operand(int value) {
		this.value = value;
	}

	/**
	 * 
	 * @return a value of this operand 
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Check to see if given token is a valid operand.
	 * 
	 * @param token a string token to be checked
	 * @return true if token matches number expression otherwise false 
	 */
	public static boolean check(String token) {
		// No double value will be evaluated so need to handle double
		// value matcher
		return token.matches("^[0-9]+");
	}
}

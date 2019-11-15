package simple.calculator.evaluator;

/**
 * Operand class used to represent an operand in a valid mathematical
 * expression.
 */
public class Operand {
	/**
	 * construct operand from string token.
	 * 
	 */

	private int value;

	public Operand(String token) {
		this(Integer.parseInt(token));
	}

	/**
	 * construct operand from integer
	 */
	public Operand(int value) {
		this.value = value;
	}

	/**
	 * return value of operand
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Check to see if given token is a valid operand.
	 */
	public static boolean check(String token) {
		//As we are not handling any float types. So, this  parsing integer is
		//more than enough to validate the string is Integer operand
		
		/*try {
			Integer.parseInt(token);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;*/
		
		return token.matches("^[0-9]+");
	}
}

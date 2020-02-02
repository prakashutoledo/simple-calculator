package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class representing available operators to use during 
 * the runtime of the program. Priority level represents the execution level
 * of two given operands or groups to be evaluated first. Higher int value
 * represents higher priority than lower positive int value
 * 
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 *
 */
public abstract class Operator {

	private static Map<String, Operator> operators = new HashMap<>();
	
	static {
		operators.put("+", new AddOperator());
		operators.put("-", new SubtractOperator());
		operators.put("/", new DivideOperator());
		operators.put("*", new MultiplyOperator());
		operators.put("^", new PowerOperator());
		operators.put("(", new LeftParenthesisOperator());
		operators.put(")", new RightParenthesisOperator());
	}

	/**
	 * Returns the priority value set for this operator
	 * 0 is high priority and so on priority decreases
	 * 
	 * @return The priority int value of given operator
	 */
	public abstract int priority();

	/**
	 * Execute the given operands to this operator. And returns the operator
	 * execution of given operands
	 * 
	 * @param op1 First operand 
	 * @param op2 Second operand
	 * 
	 * @return the operator execution resulting operand
	 */
	public abstract Operand execute(Operand op1, Operand op2);
	
	/**
	 * Returns the operater string set this Operator
	 * 
	 * @return the string representation of this operator
 	 */
	public abstract String operator();

	/**
	 * Determines if a given token is a valid operator. please do your best to avoid
	 * static checks for example token.equals("+") and so on. Think about what
	 * happens if we add more operators.
	 * 
	 * @param token A string token to check
	 */
	public static boolean check(String token) {
		if (token.length() > 1) {
			return false;
		}
		switch (token) {
			case "+" : return true;
			case "-" : return true;
			case "/" : return true;
			case "^" : return true;
			case "*" : return true;
			case "(" : return true;
			case ")" : return true;
			default  : return false;
		}
	}

	/**
	 * Returns the object representation of given string operator set to this
	 * operator map
	 * 
	 * @param token A token to check to get operator
	 * @return Object representation from the given string operator
	 */
	public static Operator getOperator(String token) {
		if (token.isEmpty() || token == null) {
			return null;
		} else {
			return operators.get(token.trim());
		}
		
	}
}

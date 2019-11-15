package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

import java.util.HashMap;

public abstract class Operator {

	private static HashMap<String, Operator> operators = new HashMap<>();
	
	static {
		operators.put("+", new AddOperator());
		operators.put("-", new SubtractOperator());
		operators.put("/", new DivideOperator());
		operators.put("*", new MultiplyOperator());
		operators.put("^", new PowerOperator());
		operators.put("(", new  LeftParenthesisOperator());
		operators.put(")", new RightParenthesisOperator());
	}

	public abstract int priority();

	public abstract Operand execute(Operand op1, Operand op2);
	public abstract String operator();

	/**
	 * determines if a given token is a valid operator. please do your best to avoid
	 * static checks for example token.equals("+") and so on. Think about what
	 * happens if we add more operators.
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

	public static Operator getOperator(String token) {
		if (token.isEmpty() || token == null) {
			return null;
		} else {
			return operators.get(token.trim());
		}
		
	}
}

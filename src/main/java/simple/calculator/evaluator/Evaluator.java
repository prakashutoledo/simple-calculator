package simple.calculator.evaluator;

import simple.calculator.operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {
	private Stack<Operand> operandStack;
	private Stack<Operator> operatorStack;
	private StringTokenizer tokenizer;
	private static final String DELIMITERS = "(+-*^/)";

	public Evaluator() {
		operandStack = new Stack<>();
		operatorStack = new Stack<>();
	}

	public int eval(String expression) {
		String token;
		// Replace all whitespace character with empty space
		expression = expression.replaceAll("\\s+", "");
		
		this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

		while (this.tokenizer.hasMoreTokens()) {
			token = this.tokenizer.nextToken();
			token = token.trim();
			
			// check if token is an operand
			if (Operand.check(token)) {
				operandStack.push(new Operand(token));
				
			// Check the operator is right parenthesis operator
			} else if (token.equals("(")) {
				operatorStack.push(Operator.getOperator(token));
			} else if (token.equals(")")) {
				while (operatorStack.peek().operator() != "(") {
					Operator op = null;
					Operand second = null, first = null;
					if (!operatorStack.isEmpty()) {
						op = operatorStack.pop();
					} else {
						throw new RuntimeException("Invalid Expression");
					}
					
					if(!operandStack.isEmpty()) {
						second = operandStack.pop();
					} else {
						throw new RuntimeException("Invalid Expression");
					}
					
					if(!operandStack.isEmpty()) {
						first = operandStack.pop();
					} else {
						throw new RuntimeException("Invalid Expression");
					}
					
					operandStack.push(op.execute(first, second));
				}
				operatorStack.pop();
			} else {
				if (!Operator.check(token)) {
					throw new RuntimeException("*****invalid token******");
				}

				Operator newOperator = Operator.getOperator(token);
				while (!operatorStack.empty() && operatorStack.peek().priority() >= newOperator.priority()) {
					Operator oldOpr = null;
					Operand op1 = null, op2 = null;
					if(!operatorStack.isEmpty()) {
						oldOpr= operatorStack.pop();
					} else {
						throw new RuntimeException("Invalid Expression");
					}
					
					if(!operandStack.isEmpty()) {
						op2 = operandStack.pop();
					} else {
						throw new RuntimeException("Invalid Expression");
					}
					
					if(!operandStack.isEmpty()) {
						op1 = operandStack.pop();
					} else {
						throw new RuntimeException("Invalid Expression");
					}
					
					
					operandStack.push(oldOpr.execute(op1, op2));
				}
				operatorStack.push(newOperator);
			}
			

		}

		while (!operatorStack.isEmpty()) {
			Operator operator = null;
			Operand first = null, second = null;
			if (!operatorStack.isEmpty()) {
				operator = operatorStack.pop();
			} else {
				throw new RuntimeException("Invalid Expression");
			}

			if (!operandStack.isEmpty()) {
				second = operandStack.pop();
			} else {
				throw new RuntimeException("Invalid Expression");
			}

			if (!operandStack.isEmpty()) {
				first = operandStack.pop();
			} else {
				throw new RuntimeException("Invalid Expression");
			}
			operandStack.push(operator.execute(first, second));
		}
		
		return operandStack.pop().getValue();
	}
}

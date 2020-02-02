package simple.calculator.evaluator;

import simple.calculator.operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Infix expression evaluator uses stacks to evaluate expressions.
 * If the expression is not in right format {@link RuntimeException}
 * is thrown.
 * 
 * Evaluates the given infix expression based on their operator priority
 * and returns the resulting operands in int value. No, double value is
 * returned. It hasn't been implemented yet.
 * 
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 * 
 * @throws RuntimeException
 * 
 * @see java.util.Stack
 */
public class InfixEvaluator {
	private final Stack<Operand> operandStack;
	private final Stack<Operator> operatorStack;
	private StringTokenizer tokenizer;
	private static final String DELIMITERS = "(+-*^/)";

	public InfixEvaluator() {
		this.operandStack = new Stack<>();
		this.operatorStack = new Stack<>();
	}

	/**
	 * Evaluates the given infix expression and returns the resulting
	 * operation after the execution of the operators
	 * 
	 * @param expression an infix string expression
	 * @return a resulting operand after evaluation and execution
	 * 
	 * @throws RuntimeException if any invalid expression
	 */
	public int evaluate(String expression) {
		String token;
		expression = expression.replaceAll("\\s+", "");
		
		this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

		while (this.tokenizer.hasMoreTokens()) {
			token = this.tokenizer.nextToken();
			token = token.trim();
			
			// check if token is an operand
			if (Operand.check(token)) {
				this.operandStack.push(new Operand(token));
			} // Check the operator is right parenthesis operator
			else if (token.equals("(")) {
				this.operatorStack.push(Operator.getOperator(token));
			} 
			else if (token.equals(")")) {
				while (this.operatorStack.peek().operator() != "(") {
					Operator op = null;
					Operand second = null, first = null;
					
					if (!this.operatorStack.isEmpty()) {
						op = this.operatorStack.pop();
					} 
					else {
						throw new RuntimeException("Invalid Expression");
					}
					
					if(!this.operandStack.isEmpty()) {
						second = operandStack.pop();
					} 
					else {
						throw new RuntimeException("Invalid Expression");
					}
					
					if(!this.operandStack.isEmpty()) {
						first = operandStack.pop();
					} 
					else {
						throw new RuntimeException("Invalid Expression");
					}
					
					this.operandStack.push(op.execute(first, second));
				}
				this.operatorStack.pop();
			} 
			else {
				if (!Operator.check(token)) {
					throw new RuntimeException("*****invalid token******");
				}

				Operator newOperator = Operator.getOperator(token);
				
				while (!this.operatorStack.empty() && this.operatorStack.peek().priority() >= newOperator.priority()) {
					Operator oldOpr = null;
					Operand op1 = null, op2 = null;
					
					if(!this.operatorStack.isEmpty()) {
						oldOpr= this.operatorStack.pop();
					} 
					else {
						throw new RuntimeException("Invalid Expression");
					}
					
					if(!this.operandStack.isEmpty()) {
						op2 = this.operandStack.pop();
					}
					else {
						throw new RuntimeException("Invalid Expression");
					}
					
					if(!this.operandStack.isEmpty()) {
						op1 = this.operandStack.pop();
					}
					else {
						throw new RuntimeException("Invalid Expression");
					}
					
					
					this.operandStack.push(oldOpr.execute(op1, op2));
				}
				this.operatorStack.push(newOperator);
			}
			

		}

		while (!this.operatorStack.isEmpty()) {
			Operator operator = null;
			Operand first = null, second = null;
			
			if (!this.operatorStack.isEmpty()) {
				operator = this.operatorStack.pop();
			} 
			else {
				throw new RuntimeException("Invalid Expression");
			}

			if (!this.operandStack.isEmpty()) {
				second = operandStack.pop();
			} 
			else {
				throw new RuntimeException("Invalid Expression");
			}

			if (!this.operandStack.isEmpty()) {
				first = operandStack.pop();
			} 
			else {
				throw new RuntimeException("Invalid Expression");
			}
			
			this.operandStack.push(operator.execute(first, second));
		}
		
		return this.operandStack.pop().getValue();
	}
}

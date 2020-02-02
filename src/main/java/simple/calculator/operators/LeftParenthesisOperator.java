package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

/**
 * Left parenthesis operator representing string "("
 * Groups the pattern starting with this operator ending right parenthesis.
 * Priority level is of lowest among all other operators.
 * 
 * @author Prakash Khadka  
 * 		   Created on: Feb 1, 2020
 *
 */
public class LeftParenthesisOperator extends Operator {

    /**
     * {@inheritDoc}
     */
	@Override
	public int priority() {
		return 0;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	// Do nothing
	public Operand execute(Operand op1, Operand op2) {
		return null;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String operator() {
		return "(";
	}

}

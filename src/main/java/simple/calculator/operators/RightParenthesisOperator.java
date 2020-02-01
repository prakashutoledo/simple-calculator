package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

/**
 * Right parenthesis operator representing string ")"
 * Groups the pattern ending with this operator starting left parenthesis.
 * Prioroty level is of lowest among all other operators.
 * 
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 *
 */
public class RightParenthesisOperator extends Operator {

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
	public Operand execute(Operand op1, Operand op2) {
		return null;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String operator() {
		return ")";
	}

}

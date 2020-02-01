package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

/**
 * Subtract operator string representing '-'. Subtracts the given operands
 * and returns the resulting operand to user.
 * 
 * Priority level is among the lowest
 * 
 * @author Prakash Khadka 
 *         Created on: Feb 1, 2020
 *
 */
public class SubtractOperator extends Operator {

    /**
     * {@inheritDoc}
     */
	@Override
	public int priority() {
		return 1;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Operand execute(Operand op1, Operand op2) {
		return new Operand(op1.getValue() - op2.getValue());
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String operator() {
		return "-";
	}

}

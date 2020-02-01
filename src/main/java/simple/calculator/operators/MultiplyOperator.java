package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

/**
 * Multiply operator with string representing "*"
 * Multiply the given operands and returns single operands
 * Priority level is of 2 which is still high
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 *
 */
public class MultiplyOperator extends Operator{

    /**
     * {@inheritDoc}
     */
	@Override
	public int priority() {
		return 2;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Operand execute(Operand op1, Operand op2) {
		return new Operand(op1.getValue() * op2.getValue());
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String operator() {
		return "*";
	}

}

package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

/**
 * Divide operator class with string operator representing "/"
 * Divides the 2 operands and returns the resulting operand.
 * Pririty level is 2 for this operator which is high
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 */
public class DivideOperator extends Operator{

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
		int value = op1.getValue()/ op2.getValue();		
		return new Operand(value);
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String operator() {
		return "/";
	}

}

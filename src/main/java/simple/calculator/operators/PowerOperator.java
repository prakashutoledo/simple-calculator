package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

/**
 * This class represents two operands in which one operands is raised
 * to power of other. This operator is of higher priority than other available
 * operators.
 * 
 * @author Prakash Khadka
 * 		   Created on: Feb 1, 2020
 *
 */
public class PowerOperator extends Operator {

    /**
     * {@inheritDoc}
     */
	@Override
	public int priority() {
		return 3;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Operand execute(Operand op1, Operand op2) {
		return new Operand(power(op1.getValue(), op2.getValue()));
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String operator() {
		return "^";
	}
	
	/**
	 * Raised base to given power and returns the result
	 * 
	 * @param base a base to set
	 * @param power a power to raise for given base
	 * @return the resulting operation raising base to it's power
	 */
	private int power(int base, int power) {
		int value = 1;
		for(int i = 1; i <= power; i++) {
			value = value * base;
		}
		return value;
	}

}

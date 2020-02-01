package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

public class PowerOperator extends Operator {

	@Override
	public int priority() {
		return 3;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		return new Operand(power(op1.getValue(), op2.getValue()));
	}

	@Override
	public String operator() {
		return "^";
	}
	
	private int power(int base, int power) {
		int value = 1;
		for(int i = 1; i <= power; i++) {
			value = value * base;
		}
		return value;
	}

}

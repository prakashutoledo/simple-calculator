package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

public class AddOperator extends Operator {

	@Override
	public int priority() {
		return 1;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		return new Operand(op1.getValue() + op2.getValue());
	}

	@Override
	public String operator() {
		return "+";
	}

}

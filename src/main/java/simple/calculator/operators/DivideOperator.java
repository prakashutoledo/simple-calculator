package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

public class DivideOperator extends Operator{

	@Override
	public int priority() {
		return 2;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		int value = op1.getValue()/ op2.getValue();		
		return new Operand(value);
	}

	@Override
	public String operator() {
		return "/";
	}

}

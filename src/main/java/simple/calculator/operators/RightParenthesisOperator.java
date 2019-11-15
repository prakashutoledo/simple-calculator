package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

public class RightParenthesisOperator extends Operator{

	@Override
	public int priority() {
		return 0;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		return null;
	}

	@Override
	public String operator() {
		return ")";
	}

}

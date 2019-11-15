package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

public class MultiplyOperator extends Operator{

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// TODO Auto-generated method stub
		return new Operand(op1.getValue() * op2.getValue());
	}

	@Override
	public String operator() {
		// TODO Auto-generated method stub
		return "*";
	}

}

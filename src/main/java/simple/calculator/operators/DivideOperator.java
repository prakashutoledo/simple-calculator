package simple.calculator.operators;

import simple.calculator.evaluator.Operand;

public class DivideOperator extends Operator{

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// TODO Auto-generated method stub
		int value = op1.getValue()/ op2.getValue();		
		return new Operand(value);
	}

	@Override
	public String operator() {
		// TODO Auto-generated method stub
		return "/";
	}

}

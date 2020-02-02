package simple.calculator.operators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import simple.calculator.evaluator.InfixEvaluator;

@DisplayName("Evaluater Test")
public class EvaluatorTest {
	
	InfixEvaluator infixEvaluator;
	
	@BeforeEach
	public void setUp() {
		infixEvaluator = new InfixEvaluator();
	}

	@Test
	void testExpression01() {
		String exp = "1+2";
		double res;

		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(3.0, res);

	}

	@Test
	void testExpression02() {
		String exp = "1/2";
		double res;

		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(0, res);
	}

	@Test
	void testExpression03() {
		String exp = "1+2*3";
		int res;
        InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(7, res);
	}

	@Test
	void testExpression04() {
		String exp = "(1+2)*3";
		int res;

		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(9, res);
	}

	@Test
	void testExpression05() {
		String exp = "2-(3/10)+2-5";
		int res;
		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(-1, res);
	}

	@Test
	void testExpression06() {
		String exp = "(6-12*2)/3";
		int res;

		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(-6, res);
	}

	@Test
	void testExpression07() {
		String exp = "3^2";
		int res;
		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(9, res);
	}

	@Test
	void testExpression08() {
		String exp = "3^2/2";
		int res;

		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(4, res);
	}

	@Test
	void testExpression09() {
		String exp = "3^2/2 +(4+5)";
		int res;

		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(13, res);
	}

	@Test
	void testExpression10() {
		String exp = "3^2 + (2^4) +(4+5)";
		int res;
		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(34, res);
	}

	@Test
	void testExpression11() {
		String exp = "3+2-9+8*2 + (3+9-8/2)";
		int res;
		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(20, res);
	}

	@Test
	void testExpression12() {
		String exp = "2+3-5*((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)*2-9";
		int res;

		InfixEvaluator ev = new InfixEvaluator();
		res = ev.evaluate(exp);
		assertEquals(1176, res);
	}

}

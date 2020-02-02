package simple.calculator.operators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Operator Test")
public class OperatorTester {

    @Test
    void testCheck(){
        assertTrue(Operator.check("+"));
        assertTrue(Operator.check("*"));
        assertTrue(Operator.check("^"));
        assertTrue(Operator.check("-"));
        assertTrue(Operator.check("/"));
        assertTrue(Operator.check("("));
        assertTrue(Operator.check(")"));
        assertFalse(Operator.check("156"));
        assertFalse(Operator.check("156.0"));
        assertFalse(Operator.check("x"));
        assertFalse(Operator.check("**"));
        
        
    }

    @Test
    void testGetOperator(){
        Operator op = Operator.getOperator("+");
        assertTrue(op instanceof AddOperator);
        op = Operator.getOperator("-");
        assertTrue(op instanceof SubtractOperator);
        op = Operator.getOperator("/");
        assertTrue(op instanceof DivideOperator);
        op = Operator.getOperator("*");
        assertTrue(op instanceof MultiplyOperator);
        op = Operator.getOperator("^");
        assertTrue(op instanceof PowerOperator);
        op = Operator.getOperator("(");
        assertTrue(op instanceof LeftParenthesisOperator);
        op = Operator.getOperator(")");
        assertTrue(op instanceof RightParenthesisOperator);
        op = Operator.getOperator("c");
        assertTrue(op == null);
    }
}

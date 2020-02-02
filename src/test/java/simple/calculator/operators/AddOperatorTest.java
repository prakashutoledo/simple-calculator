package simple.calculator.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import simple.calculator.evaluator.Operand;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Addition Test")
public class AddOperatorTest {

    @Test
    public void additionTest01(){
        Operand op1 =  new Operand(6);
        Operand op2 =  new Operand(11);
        AddOperator ap =  new AddOperator();
        Operand res = new Operand(ap.execute(op1,op2).getValue());
        assertEquals(17, res.getValue());
    }

    @Test
    public void additionTest02(){
        Operand op1 =  new Operand(11);
        Operand op2 =  new Operand(6);
        AddOperator ap =  new AddOperator();
        Operand res = new Operand(ap.execute(op1,op2).getValue());
        assertEquals(17, res.getValue());
    }

    @Test
    public void additionTest03(){
        Operand op1 =  new Operand(6);
        Operand op2 =  new Operand(-11);
        AddOperator ap =  new AddOperator();
        Operand res = new Operand(ap.execute(op1,op2).getValue());
        assertEquals(-5, res.getValue());
    }

    @Test
    public void additionTest04(){
        Operand op1 =  new Operand(-11);
        Operand op2 =  new Operand(6);
        AddOperator ap =  new AddOperator();
        Operand res = new Operand(ap.execute(op1,op2).getValue());
        assertEquals(-5, res.getValue());
    }

    @Test
    public void additionPriorityTest(){
        assertEquals(1, (new AddOperator().priority()));
    }
}
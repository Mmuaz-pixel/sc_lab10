package expressivo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdditionExpressionTest {

    @Test
    public void testAdditionExpression() {
        Expression exp1 = new NumberExpression(10);
        Expression exp2 = new NumberExpression(20);
        Expression addExpr1 = new AdditionExpression(exp1, exp2);
        Expression addExpr2 = new AdditionExpression(exp2, exp1);

        // Test toString
        assertEquals("10.0000+20.0000", addExpr1.toString());
        
        // Test equals
        assertFalse(addExpr1.equals(addExpr2));
        assertTrue(addExpr1.equals(new AdditionExpression(exp1, exp2)));
        
        // Test hashCode
        assertNotEquals(addExpr1.hashCode(), addExpr2.hashCode());
    }
}

package expressivo;

import org.junit.Test;
import static org.junit.Assert.*;

public class VariableExpressionTest {

    // Test for VariableExpression
    @Test
    public void testVariableExpression() {
        Expression exp1 = new VariableExpression("x");
        Expression exp2 = new VariableExpression("y");
        Expression exp3 = new VariableExpression("x");
        
        // Test toString
        assertEquals("x", exp1.toString());
        
        // Test equals
        assertTrue(exp1.equals(exp3));
        assertFalse(exp1.equals(exp2));
        
        // Test hashCode
        assertEquals(exp1.hashCode(), exp3.hashCode());
        assertNotEquals(exp1.hashCode(), exp2.hashCode());
    }
}

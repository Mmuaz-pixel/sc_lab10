package expressivo;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberExpressionTest {

    // Test for NumberExpression
    @Test
    public void testNumberExpression() {
        Expression exp1 = new NumberExpression(6.3829);
        Expression exp2 = new NumberExpression(6.3829);
        Expression exp3 = new NumberExpression(5.2375);
        
        // Test toString
        assertEquals("6.3829", exp1.toString());
        
        // Test equals
        assertTrue(exp1.equals(exp2));  // Same values
        assertFalse(exp1.equals(exp3)); // Different values
        
        // Test hashCode
        assertEquals(exp1.hashCode(), exp2.hashCode());
        assertNotEquals(exp1.hashCode(), exp3.hashCode());
    }
}

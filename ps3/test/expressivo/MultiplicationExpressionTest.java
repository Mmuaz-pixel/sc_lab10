package expressivo;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplicationExpressionTest {

    // Test for MultiplicationExpression
    @Test
    public void testMultiplicationExpression() {
        Expression exp1 = new NumberExpression(20);
        Expression exp2 = new NumberExpression(30);
        Expression multExpr1 = new MultiplicationExpression(exp1, exp2);
        Expression multExpr2 = new MultiplicationExpression(exp2, exp1);
        Expression exp3 = new NumberExpression(6);

        // Test toString
        assertEquals("20.0000*30.0000", multExpr1.toString());

        // Test equals (order matters in multiplication)
        assertTrue(multExpr1.equals(multExpr2));  // Multiplication is commutative
        assertTrue(multExpr1.equals(new MultiplicationExpression(exp1, exp2))); // Same order
        assertFalse(multExpr1.equals(new MultiplicationExpression(exp1, exp3))); // Different values

        // Test hashCode
        assertEquals(multExpr1.hashCode(), multExpr2.hashCode());  // Commutative property
        assertNotEquals(multExpr1.hashCode(), new MultiplicationExpression(exp1, exp3).hashCode());
    }
}

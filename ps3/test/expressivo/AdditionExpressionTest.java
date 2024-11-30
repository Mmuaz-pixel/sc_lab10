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
        assertFalse(addExpr1.equals(addExpr2));  // Different operand order
        assertTrue(addExpr1.equals(new AdditionExpression(exp1, exp2)));  // Same operands
        
        // Test hashCode
        assertNotEquals(addExpr1.hashCode(), addExpr2.hashCode());  // Different operand order
    }

    // Test with negative numbers
    @Test
    public void testAdditionWithNegativeNumbers() {
        Expression exp1 = new NumberExpression(-10);
        Expression exp2 = new NumberExpression(20);
        Expression addExpr = new AdditionExpression(exp1, exp2);

        // Test toString with negative number
        assertEquals("-10.0000+20.0000", addExpr.toString());
        
        // Test equals
        Expression exp3 = new NumberExpression(10);
        Expression exp4 = new NumberExpression(30);
        Expression addExpr2 = new AdditionExpression(exp3, exp4);
        assertFalse(addExpr.equals(addExpr2));  // Different operands

        // Test hashCode
        assertNotEquals(addExpr.hashCode(), addExpr2.hashCode());
    }

    // Test with floating-point numbers
    @Test
    public void testAdditionWithFloatingPointNumbers() {
        Expression exp1 = new NumberExpression(10.5);
        Expression exp2 = new NumberExpression(20.3);
        Expression addExpr = new AdditionExpression(exp1, exp2);

        // Test toString with floating-point numbers
        assertEquals("10.5000+20.3000", addExpr.toString());
        
        // Test equality
        Expression exp3 = new NumberExpression(15.0);
        Expression exp4 = new NumberExpression(15.8);
        Expression addExpr2 = new AdditionExpression(exp3, exp4);
        assertFalse(addExpr.equals(addExpr2));  // Different operands

        // Test hashCode
        assertNotEquals(addExpr.hashCode(), addExpr2.hashCode());
    }


    // Test adding same operand twice (e.g., x + x)
    @Test
    public void testAdditionWithSameOperands() {
        Expression exp1 = new NumberExpression(10);
        Expression addExpr = new AdditionExpression(exp1, exp1);

        // Test toString for same operands
        assertEquals("10.0000+10.0000", addExpr.toString());
        
        // Test equality with same operands in different order
        Expression exp2 = new NumberExpression(10);
        Expression addExpr2 = new AdditionExpression(exp2, exp2);
        assertTrue(addExpr.equals(addExpr2));  // Same operands
        
        // Test hashCode
        assertEquals(addExpr.hashCode(), addExpr2.hashCode());
    }

    // Test addition with large numbers
    @Test
    public void testAdditionWithLargeNumbers() {
        Expression exp1 = new NumberExpression(1_000_000);
        Expression exp2 = new NumberExpression(2_000_000);
        Expression addExpr = new AdditionExpression(exp1, exp2);

        // Test toString for large numbers
        assertEquals("1000000.0000+2000000.0000", addExpr.toString());
        
        // Test equality with the same numbers
        Expression exp3 = new NumberExpression(1_000_000);
        Expression exp4 = new NumberExpression(2_000_000);
        Expression addExpr2 = new AdditionExpression(exp3, exp4);
        assertTrue(addExpr.equals(addExpr2));
        
        // Test hashCode
        assertEquals(addExpr.hashCode(), addExpr2.hashCode());
    }
}

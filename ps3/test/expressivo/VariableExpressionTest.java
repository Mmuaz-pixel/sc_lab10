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
        assertTrue(exp1.equals(exp3));  // Same variable name
        assertFalse(exp1.equals(exp2)); // Different variable names
        
        // Test hashCode
        assertEquals(exp1.hashCode(), exp3.hashCode()); // Same variable name
        assertNotEquals(exp1.hashCode(), exp2.hashCode()); // Different variable names
    }

    // Test with different variable names
    @Test
    public void testDifferentVariableNames() {
        Expression exp1 = new VariableExpression("a");
        Expression exp2 = new VariableExpression("b");

        // Different variable names should not be equal
        assertFalse(exp1.equals(exp2));

        // Different variable names should have different hash codes
        assertNotEquals(exp1.hashCode(), exp2.hashCode());
    }

    // Test with variable name that includes special characters
    @Test
    public void testVariableWithSpecialCharacters() {
        Expression exp1 = new VariableExpression("var_1");
        Expression exp2 = new VariableExpression("var_1");

        // Special character in variable name should still be considered in equality
        assertTrue(exp1.equals(exp2));
        assertEquals(exp1.hashCode(), exp2.hashCode());
    }


    // Test with longer variable names
    @Test
    public void testLongVariableName() {
        String longVarName = "this_is_a_very_long_variable_name";
        Expression exp1 = new VariableExpression(longVarName);
        Expression exp2 = new VariableExpression(longVarName);

        // Long variable names should still be considered equal
        assertTrue(exp1.equals(exp2));
        assertEquals(exp1.hashCode(), exp2.hashCode());
    }

    // Test with variables with the same name but created in different instances
    @Test
    public void testSameNameDifferentInstances() {
        Expression exp1 = new VariableExpression("temp");
        Expression exp2 = new VariableExpression("temp");

        // Same variable name in different instances should be equal
        assertTrue(exp1.equals(exp2));
        assertEquals(exp1.hashCode(), exp2.hashCode());
    }

    // Test toString on different variable names
    @Test
    public void testToStringWithDifferentNames() {
        Expression exp1 = new VariableExpression("foo");
        Expression exp2 = new VariableExpression("bar");

        // Check that toString returns correct string representation
        assertEquals("foo", exp1.toString());
        assertEquals("bar", exp2.toString());
    }
}

package expressivo;

/**
 * Represents a variable in the expression.
 */
public class VariableExpression implements Expression {
    private final String variable;

    public VariableExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof VariableExpression)) {
            return false;
        }
        VariableExpression that = (VariableExpression) thatObject;
        return this.variable.equals(that.variable);
    }

    @Override
    public int hashCode() {
        return variable.hashCode();
    }
}

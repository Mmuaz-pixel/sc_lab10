package expressivo;

/**
 * Represents the addition operation in the expression.
 */
public class AdditionExpression implements Expression {
    private final Expression operand1;
    private final Expression operand2;

    public AdditionExpression(Expression operand1, Expression operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public String toString() {
        return operand1.toString() + "+" + operand2.toString();
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof AdditionExpression)) {
            return false;
        }
        AdditionExpression that = (AdditionExpression) thatObject;
        return this.operand1.equals(that.operand1) && this.operand2.equals(that.operand2);
    }

    @Override
    public int hashCode() {
        return 31 * operand1.hashCode() + operand2.hashCode();
    }
}

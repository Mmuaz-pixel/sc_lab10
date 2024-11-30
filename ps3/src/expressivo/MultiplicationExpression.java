package expressivo;

public class MultiplicationExpression implements Expression {
    private final Expression operand1;
    private final Expression operand2;

    public MultiplicationExpression(Expression operand1, Expression operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public String toString() {
        return operand1.toString() + "*" + operand2.toString();
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof MultiplicationExpression)) {
            return false;
        }
        MultiplicationExpression that = (MultiplicationExpression) thatObject;
        // Check for commutativity: (a * b) is equal to (b * a)
        return (this.operand1.equals(that.operand1) && this.operand2.equals(that.operand2)) ||
               (this.operand1.equals(that.operand2) && this.operand2.equals(that.operand1));
    }

    @Override
    public int hashCode() {
        // Ensure the hash code respects the commutative property
        int leftHash = operand1.hashCode();
        int rightHash = operand2.hashCode();
        return 31 * Math.min(leftHash, rightHash) + Math.max(leftHash, rightHash);
    }
}

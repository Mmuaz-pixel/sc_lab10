package expressivo;

public class NumberExpression implements Expression {
    private final double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%.4f", value); // Represent number with 4 decimal places
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof NumberExpression)) {
            return false;
        }
        NumberExpression that = (NumberExpression) thatObject;
        return Math.abs(this.value - that.value) < 1e-4; // Compare with tolerance
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}

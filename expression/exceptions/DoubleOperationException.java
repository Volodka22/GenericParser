package expression.exceptions;

public class DoubleOperationException extends UnsupportedOperationException {
    public DoubleOperationException() {
        super("Double is not support in this parser");
    }
}

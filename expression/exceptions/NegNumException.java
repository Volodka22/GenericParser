package expression.exceptions;

public class NegNumException extends EvaluateException {
    public NegNumException() {
        super("Expected positive argument");
    }
}

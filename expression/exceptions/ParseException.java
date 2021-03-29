package expression.exceptions;

import java.io.IOException;

public class ParseException extends RuntimeException {
    public ParseException(String exception, int pos) {
        super(exception + ", on position " + pos);
    }
}

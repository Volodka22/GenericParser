package expression.generic.genericType;

import expression.exceptions.DivideByZeroException;
import expression.exceptions.ExpressionMathOperation;

public class UncheckedByte implements BaseOperations<Byte> {

    private void checkOnZero(byte y) {
        if (y == 0) {
            throw new DivideByZeroException();
        }
    }

    @Override
    public Byte add(Byte x, Byte y) {
        return (byte) (x + y);
    }

    @Override
    public Byte subtract(Byte x, Byte y) {
        return (byte) (x - y);
    }

    @Override
    public Byte multiply(Byte x, Byte y) {
        return (byte) (x * y);
    }

    @Override
    public Byte divide(Byte x, Byte y) {
        checkOnZero(y);
        return (byte) (x / y);
    }

    @Override
    public Byte negate(Byte a) {
        return (byte) -a;
    }

    @Override
    public Byte mod(Byte x, Byte y) {
        checkOnZero(y);
        return (byte) (x % y);
    }

    @Override
    public Byte square(Byte a) {
        return (byte) (a * a);
    }

    @Override
    public Byte abs(Byte a) {
        return (byte) ExpressionMathOperation.abs(a);
    }

    @Override
    public Byte getValueFromInteger(int x) {
        return (byte) x;
    }

    @Override
    public Byte getValueFromString(String x) {
        return Byte.valueOf(x);
    }
}

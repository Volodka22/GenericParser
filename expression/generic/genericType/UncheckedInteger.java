package expression.generic.genericType;

import expression.exceptions.DivideByZeroException;
import expression.exceptions.ExpressionMathOperation;

public class UncheckedInteger implements BaseOperations<Integer>{
    protected void checkOnZero(int y) {
        if (y == 0) {
            throw new DivideByZeroException();
        }
    }

    @Override
    public Integer add(Integer x, Integer y) {
        return x + y;
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return x - y;
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        return x * y;
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        checkOnZero(y);
        return x / y;
    }

    @Override
    public Integer negate(Integer a) {
        return -a;
    }

    @Override
    public Integer mod(Integer x, Integer y) {
        checkOnZero(y);
        return x % y;
    }

    @Override
    public Integer square(Integer a) {
        return a * a;
    }

    @Override
    public Integer abs(Integer a) {
        return ExpressionMathOperation.abs(a);
    }

    @Override
    public Integer getValueFromInteger(int x) {
        return x;
    }

    @Override
    public Integer getValueFromString(String x) {
        return Integer.parseInt(x);
    }
}

package expression.generic.genericType;

import expression.exceptions.ExpressionMathOperation;
import expression.exceptions.OverflowException;

public class CheckedInteger extends UncheckedInteger {

    @Override
    public Integer add(Integer x, Integer y) {
        OverflowException.checkAdd(x, y);
        return super.add(x, y);
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        OverflowException.checkSubtract(x, y);
        return super.subtract(x, y);
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        OverflowException.checkMultiplyThrow(x, y);
        return x * y;
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        OverflowException.checkDivide(x, y);
        return super.divide(x, y);
    }

    @Override
    public Integer negate(Integer a) {
        OverflowException.checkNegate(a);
        return -a;
    }

    @Override
    public Integer square(Integer a) {
        OverflowException.checkMultiplyThrow(a, a);
        return a * a;
    }

    @Override
    public Integer abs(Integer a) {
        return ExpressionMathOperation.abs(a);
    }
}

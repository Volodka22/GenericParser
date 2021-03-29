package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

import java.util.NoSuchElementException;

public class GenericVariable<T> implements GenericModifyExpression<T> {
    public String value;

    public GenericVariable(String x) {
        value = x;
    }


    @Override
    public String toMiniString() {
        return value;
    }

    @Override
    public String toString() {
        return toMiniString();
    }

    @Override
    public T evaluate(T x, BaseOperations<T> operations) {
        return x;
    }

    @Override
    public T evaluate(T x, T y, T z, BaseOperations<T> operations) {
        switch (value) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                throw new NoSuchElementException();
        }
    }

    @Override
    public String getOp() {
        return null;
    }
}

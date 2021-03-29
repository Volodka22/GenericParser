package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

public class GenericConst<T> implements GenericModifyExpression<T> {
    public String value;

    public GenericConst(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public T evaluate(T x, BaseOperations<T> operations) {
        return operations.getValueFromString(value);
    }

    @Override
    public String toMiniString() {
        return toString();
    }

    @Override
    public T evaluate(T x, T y, T z, BaseOperations<T> operations) {
        return operations.getValueFromString(value);
    }


    @Override
    public String getOp() {
        return null;
    }
}

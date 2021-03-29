package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

public abstract class GenericAbstractBinaryOperation<T> implements GenericModifyExpression<T> {

    protected GenericModifyExpression<T> a;
    protected GenericModifyExpression<T> b;
    protected boolean brackets;


    public GenericAbstractBinaryOperation(GenericModifyExpression<T> a, GenericModifyExpression<T> b) {
        this.a = a;
        this.b = b;
        brackets = false;
    }

    @Override
    public String toString() {
        return String.format("(%s %s %s)", a, getOp(), b);
    }

    @Override
    public String toMiniString() {
        if (brackets) {
            return String.format("(%s %s %s)", a.toMiniString(), getOp(), b.toMiniString());
        }
        return String.format("%s %s %s", a.toMiniString(), getOp(), b.toMiniString());
    }

    protected abstract T operate(T a, T b, BaseOperations<T> operations);

    @Override
    public T evaluate(T x, BaseOperations<T> operations) {
        return operate(a.evaluate(x, operations), b.evaluate(x, operations), operations);
    }

    @Override
    public T evaluate(T x, T y, T z, BaseOperations<T> operations) {
        return operate(a.evaluate(x, y, z, operations), b.evaluate(x, y, z, operations), operations);
    }
}

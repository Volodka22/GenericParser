package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;


public abstract class GenericAbstractUnaryOperation<T> implements GenericModifyExpression<T> {

    protected final GenericModifyExpression<T> a;

    public GenericAbstractUnaryOperation(GenericModifyExpression<T> a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", getOp(), a);
    }

    @Override
    public String toMiniString() {
        return String.format("(%s %s)", getOp(), a);
    }

    protected abstract T operate(T x, BaseOperations<T> operations);

    @Override
    public T evaluate(T x, BaseOperations<T> operations) {
        return operate(a.evaluate(x, operations), operations);
    }

    @Override
    public T evaluate(T x, T y, T z, BaseOperations<T> operations) {
        return operate(a.evaluate(x, y, z, operations), operations);
    }

}

package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

public class GenericMultiply<T> extends GenericAbstractBinaryOperation<T> {
    public GenericMultiply(GenericModifyExpression<T> a, GenericModifyExpression<T> b) {
        super(a, b);
    }

    @Override
    public T operate(T a, T b, BaseOperations<T> operations) {
        return operations.multiply(a, b);
    }

    @Override
    public String getOp() {
        return "*";
    }
}

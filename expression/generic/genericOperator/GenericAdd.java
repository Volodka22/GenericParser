package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;


public class GenericAdd<T> extends GenericAbstractBinaryOperation<T> {

    public GenericAdd(GenericModifyExpression<T> a, GenericModifyExpression<T> b) {
        super(a, b);
    }

    @Override
    public String getOp() {
        return "+";
    }

    @Override
    public T operate(T a, T b, BaseOperations<T> operations) {
        return operations.add(a, b);
    }
}

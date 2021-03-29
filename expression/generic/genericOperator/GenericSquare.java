package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

public class GenericSquare<T> extends GenericAbstractUnaryOperation<T> {
    public GenericSquare(GenericModifyExpression<T> a) {
        super(a);
    }

    @Override
    protected T operate(T x, BaseOperations<T> operations) {
        return operations.square(x);
    }

    @Override
    public String getOp() {
        return "square";
    }
}

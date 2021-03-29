package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

public class GenericAbs<T> extends GenericAbstractUnaryOperation<T> {
    public GenericAbs(GenericModifyExpression<T> a) {
        super(a);
    }

    @Override
    protected T operate(T x, BaseOperations<T> operations) {
        return operations.abs(x);
    }

    @Override
    public String getOp() {
        return "abs";
    }
}

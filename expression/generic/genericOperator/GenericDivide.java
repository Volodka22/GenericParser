package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

public class GenericDivide<T> extends GenericAbstractBinaryOperation<T> {
    public GenericDivide(GenericModifyExpression<T> a, GenericModifyExpression<T> b) {
        super(a, b);
    }


    @Override
    public String getOp() {
        return "/";
    }

    @Override
    protected T operate(T a, T b, BaseOperations<T> operations) {
        return operations.divide(a, b);
    }
}

package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

public class GenericMod<T> extends GenericAbstractBinaryOperation<T> {
    public GenericMod(GenericModifyExpression<T> a, GenericModifyExpression<T> b) {
        super(a, b);
    }

    @Override
    protected T operate(T x, T y, BaseOperations<T> operations) {
        return operations.mod(x, y);
    }


    @Override
    public String getOp() {
        return "mod";
    }

}

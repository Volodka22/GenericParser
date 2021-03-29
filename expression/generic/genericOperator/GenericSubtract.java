package expression.generic.genericOperator;


import expression.generic.genericType.BaseOperations;

public class GenericSubtract<T> extends GenericAbstractBinaryOperation<T> {
    public GenericSubtract(GenericModifyExpression<T> a, GenericModifyExpression<T> b) {
        super(a, b);
    }


    @Override
    public T operate(T a, T b, BaseOperations<T> operations) {
        return operations.subtract(a, b);
    }

    @Override
    public String getOp() {
        return "-";
    }
}

package expression.generic.genericOperator;


import expression.generic.genericType.BaseOperations;

public class GenericNegate<T> extends GenericAbstractUnaryOperation<T> {
    public GenericNegate(GenericModifyExpression<T> a) {
        super(a);
    }

    @Override
    public T operate(T a, BaseOperations<T> operations) {
        return operations.negate(a);
    }

    @Override
    public String getOp() {
        return "-";
    }

}

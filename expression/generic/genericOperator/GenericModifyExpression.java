package expression.generic.genericOperator;

public interface GenericModifyExpression<T> extends Expression<T>, GenericTripleExpression<T> {
    String getOp();
}

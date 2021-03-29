package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface GenericTripleExpression<T> extends GenericToMiniString {
    T evaluate(T x, T y, T z, BaseOperations<T> operations);
}

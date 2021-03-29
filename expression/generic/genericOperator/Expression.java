package expression.generic.genericOperator;

import expression.generic.genericType.BaseOperations;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Expression<T> extends GenericToMiniString {
    T evaluate(T x, BaseOperations<T> operations);
}

package expression.generic.genericOperator;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface GenericToMiniString {
    default String toMiniString() {
        return toString();
    }
}

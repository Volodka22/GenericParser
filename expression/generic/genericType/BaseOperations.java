package expression.generic.genericType;

public interface BaseOperations<T> {
    T add(T x, T y);

    T subtract(T x, T y);

    T multiply(T x, T y);

    T divide(T x, T y);

    T negate(T a);

    T mod(T x, T y);

    T square(T a);

    T abs(T a);

    T getValueFromInteger(int x);

    T getValueFromString(String x);
}

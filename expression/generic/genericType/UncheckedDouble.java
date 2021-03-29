package expression.generic.genericType;

public class UncheckedDouble implements BaseOperations<Double> {
    @Override
    public Double add(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double subtract(Double x, Double y) {
        return x - y;
    }

    @Override
    public Double multiply(Double x, Double y) {
        return x * y;
    }

    @Override
    public Double divide(Double x, Double y) {
        return x / y;
    }

    @Override
    public Double negate(Double a) {
        return -a;
    }

    @Override
    public Double mod(Double x, Double y) {
        return x % y;
    }

    @Override
    public Double square(Double a) {
        return a * a;
    }

    @Override
    public Double abs(Double a) {
        return Math.abs(a);
    }

    @Override
    public Double getValueFromInteger(int x) {
        return (double) x;
    }

    @Override
    public Double getValueFromString(String x) {
        return Double.parseDouble(x);
    }
}

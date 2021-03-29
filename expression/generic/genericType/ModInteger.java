package expression.generic.genericType;

import expression.exceptions.ExpressionMathOperation;

public class ModInteger extends UncheckedInteger {

    final private int MOD = 1009;

    @Override
    public Integer add(Integer x, Integer y) {
        return super.add(x, y) % MOD;
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return (x - y + MOD) % MOD;
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        return super.multiply(x, y) % MOD;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        checkOnZero(b);
        return a * ExpressionMathOperation.binPow(b, MOD - 2, MOD) % MOD;
    }

    @Override
    public Integer negate(Integer a) {
        return (super.negate(a) + MOD) % MOD;
    }

    @Override
    public Integer mod(Integer a, Integer b) {
        checkOnZero(b);
        return a % Math.min(MOD, b);
    }

    @Override
    public Integer square(Integer a) {
        return a * a % MOD;
    }

    @Override
    public Integer getValueFromInteger(int x) {
        return (x % MOD + MOD) % MOD;
    }

    @Override
    public Integer abs(Integer a) {
        return a;
    }

    @Override
    public Integer getValueFromString(String x) {
        return (super.getValueFromString(x) % MOD + MOD) % MOD;
    }
}

package expression.generic.genericType;

import expression.exceptions.DivideByZeroException;
import expression.exceptions.NegNumException;

import java.math.BigInteger;

public class BigInt implements BaseOperations<BigInteger> {

    private void checkOnZero(BigInteger y) {
        if (y.equals(BigInteger.ZERO)) {
            throw new DivideByZeroException();
        }
    }

    @Override
    public BigInteger add(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    @Override
    public BigInteger subtract(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    @Override
    public BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    @Override
    public BigInteger divide(BigInteger x, BigInteger y) {
        checkOnZero(y);
        return x.divide(y);
    }

    @Override
    public BigInteger negate(BigInteger a) {
        return a.negate();
    }

    @Override
    public BigInteger mod(BigInteger x, BigInteger y) {
        checkOnZero(y);
        if (y.compareTo(BigInteger.ZERO) < 0) {
            throw new NegNumException();
        }
        return x.mod(y);
    }

    @Override
    public BigInteger square(BigInteger a) {
        return a.multiply(a);
    }

    @Override
    public BigInteger abs(BigInteger a) {
        return a.abs();
    }

    @Override
    public BigInteger getValueFromInteger(int x) {
        return BigInteger.valueOf(x);
    }

    @Override
    public BigInteger getValueFromString(String x) {
        return new BigInteger(x);
    }
}

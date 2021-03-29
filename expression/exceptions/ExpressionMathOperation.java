package expression.exceptions;

import expression.exceptions.NegNumException;
import expression.exceptions.OverflowException;

public abstract class ExpressionMathOperation {

    public static int binPow(int x, int n, int mod) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                res *= x;
                res %= mod;
            }
            x *= x;
            x %= mod;
            n >>= 1;
        }
        return res;
    }

    public static int sqrt(int a) {
        if (a < 0) {
            throw new NegNumException();
        }
        int l = 0;
        int r = a + 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (OverflowException.checkMultiply(mid, mid) || mid * mid > a) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int c = a;
            a = b;
            b = c;
        }
        return abs(a);
    }

    public static int lcm(int a, int b) {
        if (a == 0 && b == 0) {
            return 0;
        }
        OverflowException.checkMultiplyThrow(a / gcd(a, b), b);
        return a / gcd(a, b) * b;
    }

    public static int abs(int a) {
        OverflowException.checkNegate(a);
        if (a < 0) {
            a = -a;
        }
        return a;
    }
}

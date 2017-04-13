package euler;

import java.math.BigInteger;

public class Problem234 implements Problem {

    private static long sumFromTo(long a, long b) { // (a+1) + (a+2) + ... + b
        return ((b + 1) * b - (a + 1) * a) / 2;
    }

    public String solve() {
        // p^2 < n < pn^2
        BigInteger result = BigInteger.ZERO;
        BigInteger iter = BigInteger.valueOf(2);
        long maxN = 999966663333L;
        long p = iter.longValue();

        while (p * p < maxN) {
            iter = iter.nextProbablePrime();
            long pn = iter.longValue();
            long lb = p * p;
            long ub = Math.min(maxN, pn * pn);

            // sum(p*k) - sum(p*pn*k)
            long k = ub / p;
            result = result.add(BigInteger.valueOf(p).multiply(
                    BigInteger.valueOf(sumFromTo(p, k) - pn * sumFromTo(0, k / pn))));

            // sum(pn*l) - sum(pn*p*k)
            long l = lb / pn;
            long u = ub / pn;
            if (u == pn) u -= 1;  // exclude pn*pn
            result = result.add(BigInteger.valueOf(pn).multiply(
                    BigInteger.valueOf(sumFromTo(l, u) - p * sumFromTo(l / p, u / p))));

            p = pn;
        }

        return result.toString();  // 1259187438574927161
    }

}

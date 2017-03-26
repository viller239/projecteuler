package euler;

import java.math.BigInteger;

public class Problem288 implements Problem {

    public String solve() {
        // 605857431263981935
        int p = 61;
        int q = 10_000_000;
        int a = 10;

        BigInteger resultMod = BigInteger.valueOf(p).pow(a);
        BigInteger result = BigInteger.ZERO;

        BigInteger P = BigInteger.valueOf(p);
        BigInteger PPow = BigInteger.ONE;
        BigInteger PPowSum = BigInteger.ZERO;

        BigInteger S = BigInteger.valueOf(290797);
        BigInteger SMod = BigInteger.valueOf(50515093);

        for (int n = 0; n <= q; n++) {
            BigInteger T = S.mod(P);

            result = result.add(T.multiply(PPowSum)).mod(resultMod);

            S = S.multiply(S).mod(SMod);
            PPowSum = PPowSum.add(PPow).mod(resultMod);
            PPow = PPow.multiply(P).mod(resultMod);
        }

        return result.mod(resultMod).toString();
    }

}

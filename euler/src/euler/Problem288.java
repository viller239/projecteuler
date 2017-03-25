package euler;

import static java.lang.System.out;
import java.math.BigInteger;

public class Problem288 {

    public static void main(String[] args) {
        String res = NF(3, 10_000, 20).toString();
        out.println(res + " " + res.equals("624955285"));
        out.println(NF(61, 10_000_000, 10).toString());
        // 605857431263981935
    }

    private static BigInteger NF(int p, int q, int a) {
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

        return result.mod(resultMod);
    }

}

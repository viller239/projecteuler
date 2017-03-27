package euler;

import java.math.BigInteger;

class Utils {

    static BigInteger cnk(int n, int k) { //optimize
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) result = result.multiply(BigInteger.valueOf(i));
        for (int i = 1; i <= k; i++) result = result.divide(BigInteger.valueOf(i));
        for (int i = 1; i <= n - k; i++) result = result.divide(BigInteger.valueOf(i));
        return result;
    }

}

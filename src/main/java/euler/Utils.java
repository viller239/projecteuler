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

    static long modpow(long base, long exp, long modulus) {
        if (exp == 0) return 1;

        base %= modulus;
        long result = 1;
        while (exp > 0) {
           if (exp % 2 == 1) result = (result * base) % modulus;
           base = (base * base) % modulus;
           exp /= 2;
        }

        return result;
    }

    static long primeFactorInFactorial(long n, long p) {
        long result = 0;
        long pPow = p;
        while (pPow <= n) {
            result += n / pPow;
            pPow *= p;
        }
        return result;
    }

}

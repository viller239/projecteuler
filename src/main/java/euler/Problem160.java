package euler;

public class Problem160 implements Problem {

    private static long remWithout2and5(long n, long mod) {
        if (n <= mod) {
            long r = 1;
            for (long i = 1; i <= n; i++) {
                if ((i % 5 != 0) && (i % 2 != 0)) {
                    r = (r * i) % mod;
                }
            }
            return r;
        }
        return (remWithout2and5(n % mod, mod) * Utils.modpow(remWithout2and5(mod, mod), n / mod, mod)) % mod;
    }

    public String solve() {
        long b = 100_000L;
        long n = 1_000_000_000_000L;

        long extra2 = Utils.primeFactorInFactorial(n, 2) - Utils.primeFactorInFactorial(n, 5);
        long result = Utils.modpow(2, extra2, b);

        long p2 = 1;
        while (p2 <= n) {
            long p5 = 1;
            while (p5 * p2 <= n) {
                result = (result * remWithout2and5(n / (p2 * p5), b)) % b;
                p5 *= 5;
            }
            p2 *= 2;
        }

        return Long.toString(result);  // 16576
    }
}

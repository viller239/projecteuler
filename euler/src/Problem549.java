import java.util.stream.LongStream;

public class Problem549 {

    public static void main(String[] args) {
        int n = 100_000_000;
//        int n = 100;
        long[] s = new long[n + 1];

        for (int i = 2; i <= n; i++) {
            if (s[i] != 0) continue;  // not prime

            long a = 1;
            long p = i;  // power of prime = i ^ a
            while (p <= n) {
                long k = p;
                while (k <= n) {
                    int ki = (int) k;
                    long m = magic((long) i, a);
                    if (m > s[ki]) s[ki] = m;
                    k += p;
                }

                a += 1;
                p *= i;
            }
        }

        System.out.println(LongStream.of(s).sum());
    }

    private static long magic(long p, long a) {
        if (a < p) return a * p;
        long x = a;
        while (x > 0) {
            x -= 1;
            long f = factor(x * p, p);
            if (f < a) break;
        }
        return (x + 1) * p;
    }

    private static long factor(long n, long p) {
        long result = 0;
        long pp = 1;
        while (pp <= n) {
            pp *= p;
            result += n / pp;
        }
        return result;
    }

}
// n / p + n / p^2 + n / p ^ 3 ... = k
// n = p * x
//
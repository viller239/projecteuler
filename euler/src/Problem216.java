import java.math.BigInteger;
import java.util.stream.LongStream;

import static java.lang.System.out;

public class Problem216 {

    public static void main(String[] args) {
        int lim = 50_000_000;
        out.println("result: " + solve(lim) + " for n<=" + lim);
    }

    private static long solve(int lim) {
        return LongStream.rangeClosed(2, lim)
                .parallel()
                .filter((n) -> BigInteger.valueOf(2 * n * n - 1).isProbablePrime(100))
                .count();
    }

}

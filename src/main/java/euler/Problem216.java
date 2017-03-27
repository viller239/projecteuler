package euler;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Problem216 implements Problem {

    public String solve() {
        int lim = 50_000_000;
        long result = LongStream.rangeClosed(2, lim)
                .parallel()
                .filter((n) -> BigInteger.valueOf(2 * n * n - 1).isProbablePrime(100))
                .count();
        return Long.toString(result);
    }

}

import java.math.BigInteger;
import java.util.stream.LongStream;

import static java.lang.System.out;

public class Main {

    static private void solve216() {
        int lim = 50_000_000;
        long count = LongStream.rangeClosed(2, lim)
                .parallel()
                .filter((n) -> BigInteger.valueOf(2 * n * n - 1).isProbablePrime(100))
                .count();
        out.println("result: " + count + " for n<=" + lim);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        solve216();

        out.println("calculated in:" + (System.currentTimeMillis() - startTime));
    }

}

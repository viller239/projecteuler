import java.math.BigInteger;
import java.util.Arrays;
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

    static private long solve265_res = 0;

    static private void solve265(int n) {
        int N = 1 << n;
        byte[] bytes = new byte[N];
        byte[] values = new byte[N];
        values[0] = 1;

        solve265_re(n, 1, bytes, values);
        out.println("result: " + solve265_res + " for n=" + n);
    }

    static private void solve265_re(int n, int index, byte[] bytes, byte[] values) {
        int N = 1 << n;
        if (index == N) {
            int res = 0;
            for (int i = 0; i < N; i++) {
                res += bytes[N - i - 1] << i;
            }
            out.println(res + " " + Arrays.toString(bytes));
            solve265_res += res;
            return;
        }
        int nextValue = 0;
        for (int i = n - 1; i >= 0; i--) {
            nextValue += bytes[(N + index + i) % N];
            nextValue = nextValue << 1;
        }
        if (values[nextValue] == 0) {
            byte[] newBytes = bytes.clone();
            byte[] newValues = values.clone();
            newValues[nextValue] = 1;
            solve265_re(n, index + 1, newBytes, newValues);
        }
        if (values[nextValue + 1] == 0) {
            byte[] newBytes = bytes.clone();
            byte[] newValues = values.clone();
            newBytes[index + n - 1] = 1;
            newValues[nextValue + 1] = 1;
            solve265_re(n, index + 1, newBytes, newValues);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        solve265(5);

        out.println("calculated in:" + (System.currentTimeMillis() - startTime));
    }

}

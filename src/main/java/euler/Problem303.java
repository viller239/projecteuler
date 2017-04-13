package euler;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem303 implements Problem {

    private static long[] fn = new long[10001];

    private static void tick(long n, int depth) {
        for (int i = 3; i < 10001; i++) {
            if (i > n) break;
            if (n % i == 0) {
                long k = n / i;
                if (fn[i] == 0 || k < fn[i]) fn[i] = k;
            }
        }

        if (depth > 0) {
            long n10 = 10 * n;
            if (n10 > 0) tick(n10, depth - 1);
            tick(n10 + 1, depth - 1);
            tick(n10 + 2, depth - 1);
        }
    }

    private static void tickHard(long n, int depth, int[] hard) {
        for (int aHard : hard) {
            if (n % aHard == 0) {
                long k = n / aHard;
                if (fn[aHard] == 0 || k < fn[aHard]) fn[aHard] = k;
            }
        }

        if (depth > 0) {
            long n10 = 10 * n;
            if (n10 > 0) tickHard(n10, depth - 1, hard);
            tickHard(n10 + 1, depth - 1, hard);
            tickHard(n10 + 2, depth - 1, hard);
        }
    }

    public String solve() {
        fn[0] = 0;
        fn[1] = 1;
        fn[2] = 1;

        tick(0, 11);

        int[] hard = IntStream.range(2, fn.length).filter(i -> fn[i] == 0).toArray();
        System.out.println("fails: " + hard.length);

        tickHard(0, 16, hard);

        int[] veryHard = IntStream.range(2, fn.length).filter(i -> fn[i] == 0).toArray();
        System.out.println("super fails: " + Arrays.toString(veryHard));


        return Long.toString(LongStream.of(fn).sum());  // 648549117391 + (11112222222222222222 / 9999) = 1111981904675169
    }

}

/*
 fails: 14
 bad number: 0
 bad number: 999
 bad number: 1998
 bad number: 2997
 bad number: 3996
 bad number: 4995
 bad number: 5994
 bad number: 6993
 bad number: 7992
 bad number: 8991
 bad number: 9899
 bad number: 9989
 bad number: 9990
 bad number: 9999
 class euler.Problem303: 972536347
 calculated in:43796


 fails: 35
 super fails: [9999]
 class euler.Problem303: 648549117391
 calculated in:27586
 */
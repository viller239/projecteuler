package euler;

import java.util.HashSet;
import java.util.Set;

public class Problem346 implements Problem {

    public String solve() {
        long lim = 1_000_000_000_000L;
        Set<Long> strong = new HashSet<>();

        long base = 2;
        while (true) {
            long n = 1 + base * (base + 1);
            if (n >= lim) break;
            while (n < lim) {
                strong.add(n);
                n = n * base + 1;
            }
            base += 1;
        }

        //336108797689259276
        return Long.toString(strong.stream().reduce(Long::sum).orElse(0L) + 1);
    }

}

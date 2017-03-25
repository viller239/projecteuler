package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// GARBAGE
public class Problem346 {

    public static void main(String[] args) {
        long lim = 1_000_000_000_000L;
        Set<Long> strongs = new HashSet<>();

        long base = 2;
        while (true) {
            long n = 1 + base * (base + 1);
            if (n >= lim) break;
            while (n < lim) {
                strongs.add(n);
                n = n * base + 1;
            }
            base += 1;
        }

        //336108797689259275 + 1
        System.out.println(strongs.stream().reduce(Long::sum).get() + 1);
    }

}

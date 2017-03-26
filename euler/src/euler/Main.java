package euler;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        printSolution(new Problem216(), false);
        printSolution(new Problem265(), false);
        printSolution(new Problem277(), true);

        out.println("calculated in:" + (System.currentTimeMillis() - startTime));
    }

    private static void printSolution(Problem p, boolean f) {
        if (f) out.println(p.getClass() + ": " + p.solve());
    }

}

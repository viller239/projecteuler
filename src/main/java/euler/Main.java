package euler;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        printSolution(new Problem216(), false);
        printSolution(new Problem265(), false);
        printSolution(new Problem288(), false);
        printSolution(new Problem277(), false);
        printSolution(new Problem346(), false);
        printSolution(new Problem493(), false);
        printSolution(new Problem549(), false);
        printSolution(new Problem234(), false);
        printSolution(new Problem303(), true);

    }

    private static void printSolution(Problem p, boolean f) {
        if (f) {
            long startTime = System.currentTimeMillis();
            out.println(p.getClass() + ": " + p.solve());
            out.println("calculated in:" + (System.currentTimeMillis() - startTime));
        }
    }

}

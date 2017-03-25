package euler;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        euler.Problem216.main(args);
//        euler.Problem265.main(args);
//        euler.Problem277.main(args);
//        euler.Problem288.main(args);
//        euler.Problem493.main(args);
//        euler.Problem549.main(args);
        Problem346.main(args);

        out.println("calculated in:" + (System.currentTimeMillis() - startTime));
    }

}

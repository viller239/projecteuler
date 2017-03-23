import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        Problem216.main(args);
//        Problem265.main(args);
        Problem277.main(args);

        out.println("calculated in:" + (System.currentTimeMillis() - startTime));
    }

}

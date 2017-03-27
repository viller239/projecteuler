package euler;

import java.math.BigInteger;

public class Problem277 implements Problem{

    public String solve() {
        String S = "UDDDUdddDDUDDddDdDddDDUDDdUUDd";
        long lowerBound = (long) 1e15;

        // an = a1 * a / b + c / b
        BigInteger big2 = BigInteger.valueOf(2);
        BigInteger big3 = BigInteger.valueOf(3);
        BigInteger big4 = BigInteger.valueOf(4);

        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(0);

        for (char op : S.toCharArray()) {
            if (op == 'D') {
                b = b.multiply(big3);
            } else if (op == 'U') {
                a = a.multiply(big4);
                c = c.multiply(big4).add(b.multiply(big2));
                b = b.multiply(big3);
            } else {
                a = a.multiply(big2);
                c = c.multiply(big2).subtract(b);
                b = b.multiply(big3);
            }
        }

        BigInteger reminder = c.negate().multiply(a.modInverse(b)).mod(b);
        BigInteger result = BigInteger.valueOf(lowerBound).divide(b).add(BigInteger.ONE).multiply(b).add(reminder);

        return result.toString();
    }

}

package euler;

import java.math.BigInteger;
import java.util.Arrays;
import static euler.Utils.cnk;

public class Problem493 implements Problem {

    public String solve() {
        BigInteger[] colorCounts = new BigInteger[8];
        Arrays.fill(colorCounts, BigInteger.ZERO);

        for (int c1 = 1; c1 <= 10; c1++) {
            BigInteger cnk1 = cnk(10, c1);

            for (int c2 = 1; c2 <= 10; c2++) {
                BigInteger cnk2 = cnk(10, c2);
                if (c1 + c2 == 20) {
                    int colors = 2;
                    BigInteger count = cnk(7, colors)
                            .multiply(cnk1)
                            .multiply(cnk2);
                    colorCounts[colors] = colorCounts[colors].add(count);
                    break;
                }

                for (int c3 = 1; c3 <= 10; c3++) {
                    BigInteger cnk3 = cnk(10, c3);
                    if (c1 + c2 + c3 == 20) {
                        int colors = 3;
                        BigInteger count = cnk(7, colors)
                                .multiply(cnk1)
                                .multiply(cnk2)
                                .multiply(cnk3);
                        colorCounts[colors] = colorCounts[colors].add(count);
                        break;
                    }

                    for (int c4 = 1; c4 <= 10; c4++) {
                        BigInteger cnk4 = cnk(10, c4);
                        if (c1 + c2 + c3 + c4 == 20) {
                            int colors = 4;
                            BigInteger count = cnk(7, colors)
                                    .multiply(cnk1)
                                    .multiply(cnk2)
                                    .multiply(cnk3)
                                    .multiply(cnk4);
                            colorCounts[colors] = colorCounts[colors].add(count);
                            break;
                        }

                        for (int c5 = 1; c5 <= 10; c5++) {
                            BigInteger cnk5 = cnk(10, c5);
                            if (c1 + c2 + c3 + c4 + c5 == 20) {
                                int colors = 5;
                                BigInteger count = cnk(7, colors)
                                        .multiply(cnk1)
                                        .multiply(cnk2)
                                        .multiply(cnk3)
                                        .multiply(cnk4)
                                        .multiply(cnk5);
                                colorCounts[colors] = colorCounts[colors].add(count);
                                break;
                            }

                            for (int c6 = 1; c6 <= 10; c6++) {
                                BigInteger cnk6 = cnk(10, c6);
                                if (c1 + c2 + c3 + c4 + c5 + c6 == 20) {
                                    int colors = 6;
                                    BigInteger count = cnk(7, colors)
                                            .multiply(cnk1)
                                            .multiply(cnk2)
                                            .multiply(cnk3)
                                            .multiply(cnk4)
                                            .multiply(cnk5)
                                            .multiply(cnk6);
                                    colorCounts[colors] = colorCounts[colors].add(count);
                                    break;
                                }

                                for (int c7 = 1; c7 <= 10; c7++) {
                                    BigInteger cnk7 = cnk(10, c7);
                                    if (c1 + c2 + c3 + c4 + c5 + c6 + c7 == 20) {
                                        int colors = 7;
                                        BigInteger count = cnk(7, colors)
                                                .multiply(cnk1)
                                                .multiply(cnk2)
                                                .multiply(cnk3)
                                                .multiply(cnk4)
                                                .multiply(cnk5)
                                                .multiply(cnk6)
                                                .multiply(cnk7);
                                        colorCounts[colors] = colorCounts[colors].add(count);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        double total = cnk(70, 20).doubleValue();
        double expected = colorCounts[2].multiply(BigInteger.valueOf(2))
                .add(colorCounts[3].multiply(BigInteger.valueOf(3)))
                .add(colorCounts[4].multiply(BigInteger.valueOf(4)))
                .add(colorCounts[5].multiply(BigInteger.valueOf(5)))
                .add(colorCounts[6].multiply(BigInteger.valueOf(6)))
                .add(colorCounts[7].multiply(BigInteger.valueOf(7)))
                .doubleValue();

        return Double.toString(expected / total).substring(0, 11);
    }

}

import static java.lang.System.out;

public class Problem265 {

    public static void main(String[] args) {
        int n = 5;
        out.println("result: " + solve(n) + " for n=" + n);
    }

    static private long solve(int n) {
        int N = 1 << n;
        byte[] bytes = new byte[N];
        byte[] values = new byte[N];
        values[0] = 1;
        return solve(n, 1, bytes, values);
    }

    static private long solve(int n, int index, byte[] bytes, byte[] values) {
        int N = 1 << n;
        long res = 0;
        if (index == N) {
            for (int i = 0; i < N; i++) {
                res += bytes[N - i - 1] << i;
            }
        } else {
            int nextValue = 0;
            for (int i = n - 1; i >= 0; i--) {
                nextValue += bytes[(N + index + i) % N];
                nextValue = nextValue << 1;
            }
            if (values[nextValue] == 0) {
                byte[] newBytes = bytes.clone();
                byte[] newValues = values.clone();
                newValues[nextValue] = 1;
                res += solve(n, index + 1, newBytes, newValues);
            }
            if (values[nextValue + 1] == 0) {
                byte[] newBytes = bytes.clone();
                byte[] newValues = values.clone();
                newBytes[index + n - 1] = 1;
                newValues[nextValue + 1] = 1;
                res += solve(n, index + 1, newBytes, newValues);
            }
        }
        return res;
    }


}

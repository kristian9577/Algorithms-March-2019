import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p07_NChooseKCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        long result = binomialCoefficientRecursion(n, k);

        System.out.println(result);
    }

    private static long binomialCoefficientRecursion(int n, int k) {
        if (k > n) {
            return 0L;
        }
        if (k == 0 || k == n) {
            return 1L;
        }
        return binomialCoefficientRecursion(n - 1, k - 1) + binomialCoefficientRecursion(n - 1, k);
    }
}

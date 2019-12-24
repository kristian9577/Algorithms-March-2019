import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_VariationsWithRepetition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().trim().split("\\s+");

        int n = Integer.parseInt(reader.readLine());

        String[] variation = new String[n];

        generateVariations(elements, variation, n, 0);
    }

    private static void generateVariations(String[] elements, String[] variation, int n, int index) {
        if (index >= n) {
            System.out.println(String.join(" ", variation));
        } else {
            for (String element : elements) {
                variation[index] = element;
                generateVariations(elements, variation, n, index + 1);
            }
        }
    }
}

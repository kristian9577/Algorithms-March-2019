import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_VariationsWithoutRepetition {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().trim().split("\\s+");

        n = Integer.parseInt(reader.readLine());

        generateVariations(0, elements);
    }

    private static void generateVariations(int index, String[] elements) {
        if (index >= n) {
            System.out.println(String.join(" ", elements));
        } else {
            generateVariations(index + 1, elements);

            for (int i = index + 1; i < elements.length; i++) {
                swap(index, i, elements);
                generateVariations(index + 1, elements);
                swap(i, index, elements);
            }
        }
    }

    private static void swap(int i, int j, String[] elements) {
        String temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}

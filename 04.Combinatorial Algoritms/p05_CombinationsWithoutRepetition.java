import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p05_CombinationsWithoutRepetition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().trim().split("\\s+");

        int n = Integer.parseInt(reader.readLine());

        String[] combination = new String[n];

        generateCombinations(elements, combination, 0, 0);
    }

    private static void generateCombinations(String[] elements, String[] combination, int index, int start) {
        if (index >= combination.length) {
            System.out.println(String.join(" ", combination));
        } else {
            for (int i = start; i < elements.length; i++) {
                combination[index] = elements[i];
                generateCombinations(elements, combination, index + 1, i + 1);
            }
        }

    }
}

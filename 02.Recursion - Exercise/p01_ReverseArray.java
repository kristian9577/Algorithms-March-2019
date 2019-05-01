import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p01_ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        reverseArray(numbers, 0, numbers.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void reverseArray(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;

        reverseArray(numbers, ++left, --right);
    }
}

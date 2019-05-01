import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_NestedLoops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int level = Integer.parseInt(reader.readLine());

        nestedLoops(new int[level], 0);
    }

    private static void nestedLoops(int[] arr, int start) {
        if (start == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }
        for (int i = 1; i <= arr.length; i++) {
            arr[start] = i;
            nestedLoops(arr, start + 1);
        }
    }
}

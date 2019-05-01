import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class p04_TowersOfHanoi {

    private static final Deque<String> AUXILIARY = new LinkedList<>();
    private static final Deque<String> TARGET = new LinkedList<>();
    private static final Deque<String> SOURCE = new LinkedList<>();
    private static final StringBuilder OUTPUT = new StringBuilder();

    private static int stepsTaken = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int disks = Integer.parseInt(reader.readLine());

        for (int i = disks; i > 0; i--) {
            SOURCE.addLast(Integer.toString(i));
        }
        printCurrentState();

        move(disks, SOURCE, TARGET, AUXILIARY);

        System.out.println(OUTPUT);
    }

    private static void move(int disks, Deque<String> source, Deque<String> target, Deque<String> auxiliary) {
        if (disks > 0) {
            // move n - 1 disks from source to auxiliary, so they are out of the way
            move(disks - 1, source, auxiliary, target);

            // move the nth disk from source to target
            OUTPUT.append(String.format("Step #%d: Moved disk%n", ++stepsTaken));
            target.addLast(source.removeLast());

            // Display our progress
            printCurrentState();

            // move the n - 1 disks that we left on auxiliary onto target
            move(disks - 1, auxiliary, target, source);
        }
    }

    private static void printCurrentState() {
        OUTPUT.append(String.format("Source: %s%n", String.join(", ", SOURCE)));
        OUTPUT.append(String.format("Destination: %s%n", String.join(", ", TARGET)));
        OUTPUT.append(String.format("Spare: %s%n%n", String.join(", ", AUXILIARY)));
    }
}

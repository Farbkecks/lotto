import java.util.Random;
import java.util.Scanner;

// TimeUnit.SECONDS.sleep(1);

class App {
    final static Random rand = new Random();
    final static Scanner scanner = new Scanner(System.in);
    static int[] guess = new int[6];

    static int get_input(int index) {
        int input;
        index++;
        System.out.println("Biite die " + index + " Zahle eingaben");
        while (true) {
            input = 0;
            if (scanner.hasNextInt()) { // scannes if it is an int
                input = scanner.nextInt();
            } else {
                System.out.println("Nur Zahlen eingeben"); // return if it check fails
                scanner.nextLine();
                continue;
            }
            if (input <= 0 || input > 49) { // checks if the int is on the board
                System.out.println("Nur Zahlen zwischen 1 und 49 eingeben");
                continue;
            }
            var found = false;
            for (int i : guess) {
                if (i == input) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("Du kannst jede Zahl nur ein mal auswählen");
                continue;
            }
            break;
        }
        return input;
    }

    public static void main(String[] args) {
        for (int i = 0; i < guess.length; i++) {
            guess[i] = get_input(i);
        }
        System.out.println("Deine Zahlen; ");
        for (int i : guess) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Und hier die Lotto zahlen:");
        for (int i = 0; i < 6; i++) {
            System.out.print(rand.nextInt(50) + " ");
        }

        System.out.println();
    }
}

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class App {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static String colorGreen = ANSI_GREEN;
    static String colorRed = ANSI_RED;
    static String colorRest = ANSI_RESET;

    final static Random rand = new Random();
    final static Scanner scanner = new Scanner(System.in);
    static int[] guesses = new int[6];

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
            for (int i : guesses) {
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

    public static void main(String[] args) throws InterruptedException {
        for (String i : args) {
            if (i.equals("color")) {
                colorGreen = "";
                colorRed = "";
                colorRest = "";
            } else {
                System.out.println("Mögliches Argument \"color\"");
                break;
            }
        }

        for (int i = 0; i < guesses.length; i++) {
            guesses[i] = get_input(i);
        }
        System.out.println("Deine Zahlen; ");
        for (int i : guesses) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Und hier die Lottozahlen:");

        var numbers = new int[6];
        for (int i = 0; i < 6; i++) {
            var found = false;
            int number;
            while (true) {
                number = rand.nextInt(49) + 1;
                var found2 = false;
                for (int y : numbers) {
                    if (y == number) {
                        found2 = true;
                    }
                }
                if (found2) {
                    continue;
                } else {
                    numbers[i] = number;
                    break;
                }

            }

            for (int guess : guesses) {
                if (guess == number) {
                    found = true;
                }
            }
            if (found) {
                System.out.print(colorGreen + number + colorRest + " ");
            } else {

                System.out.print(colorRed + number + colorRest + " ");
            }

            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println();
    }
}

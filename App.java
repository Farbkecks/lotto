import java.util.Random;

// TimeUnit.SECONDS.sleep(1);

class App {
    static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("Und hier die Lotto zahlen:");

        for (int i = 0; i < 6; i++) {
            System.out.print(rand.nextInt(50) + " ");
        }

        System.out.println();
    }
}

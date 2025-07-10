import java.util.Scanner;
import java.util.Random;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.println("Point is set to: " + point);
                boolean rolling = true;

                while (rolling) {
                    System.out.println("Trying for point...");
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Die 1: " + die1);
                    System.out.println("Die 2: " + die2);
                    System.out.println("Sum: " + sum);

                    if (sum == point) {
                        System.out.println("You made your point! You win!");
                        rolling = false;
                    } else if (sum == 7) {
                        System.out.println("Got a 7. You lose.");
                        rolling = false;
                    }
                }
            }

            System.out.print("Do you want to play again? (Y/N): ");
            String response = in.nextLine().trim().toUpperCase();
            if (!response.equals("Y")) {
                playAgain = false;
                System.out.println("Thank you for playing!");
            }
        }

        in.close();
    }
}

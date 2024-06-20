import java.util.Scanner;
import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int point = 0;

        System.out.println("Welcome Number game!");
        System.out.println("number between " + minRange + " to " + maxRange);

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                attempts++;

                if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
                    point += attempts;
                    guessedCorrectly = true;
                }

                if (!guessedCorrectly && attempts >= 5) {
                    System.out.println(" you reached the maximum number of attempts.");
                    System.out.println("The correct number was: " + targetNumber);
                    break;
                }
            }

            System.out.print("want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine();
            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over. Your total score is: " + point);
        scanner.close();
    }
}

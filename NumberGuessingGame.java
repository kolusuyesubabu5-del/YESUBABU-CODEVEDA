import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int maxAttempts = 5;
        int attempts = 0;

        System.out.println("===== Number Guessing Game =====");
        System.out.println("Guess a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Remove invalid input
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("🎉 Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too Low!");
            } else {
                System.out.println("Too High!");
            }

            System.out.println("Attempts Left: " + (maxAttempts - attempts));
        }

        if (attempts == maxAttempts) {
            System.out.println("\nGame Over!");
            System.out.println("The correct number was: " + secretNumber);
        }

        scanner.close();
    }
}
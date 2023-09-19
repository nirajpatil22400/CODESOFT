import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        try (// Initialize a scanner for user input and a random number generator.
        Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            // Define game parameters
            int minRange = 1;         // Minimum number in the range
            int maxRange = 100;       // Maximum number in the range
            int maxAttempts = 10;     // Maximum number of attempts allowed per round
            int totalAttempts = 0;    // Track the total number of attempts across rounds
            int roundsWon = 0;        // Track the number of rounds won
            
            // Print a welcome message and set up a flag to control playing again.
            System.out.println("Welcome to the Number Guessing Game!");
            boolean playAgain = true;
            
            // Main game loop, allows playing multiple rounds.
            while (playAgain) {
                // Generate a random target number within the specified range.
                int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;  // Track the number of attempts in the current round
                boolean guessedCorrectly = false;  // Flag to check if the user guessed correctly
                
                // Display instructions for the current round.
                System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");
                
                // Loop to handle user attempts in the current round.
                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();  // Read the user's guess
                    attempts++;  // Increment the attempt count
                    
                    // Check if the user's guess is correct, too low, or too high.
                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        totalAttempts += attempts;  // Add attempts to the total
                        roundsWon++;  // Increment rounds won
                        break;  // Exit the current round's loop
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }
                
                // If the user didn't guess correctly, display the correct number.
                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                }
                
                // Ask the user if they want to play again.
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainInput = scanner.next();
                playAgain = playAgainInput.equalsIgnoreCase("yes");  // Set playAgain flag based on user input
            }
            
            // Print game over message with the user's score.
            System.out.println("Game Over! You played " + roundsWon + " rounds and took " + totalAttempts + " attempts in total.");
        }
    }
}
/*
Explanation:
We import the necessary Java libraries: Random for generating random numbers and Scanner for user input.
We set up variables and constants to control the game, such as the range of numbers, maximum attempts, and variables to track statistics like total attempts and rounds won.
The program starts with a welcome message and initializes a boolean variable playAgain to control whether the game continues.
The main game loop (while (playAgain)) allows the user to play multiple rounds.
In each round, a random target number is generated within the specified range.
A nested loop handles the user's attempts, providing feedback on whether their guess is correct, too low, or too high.
If the user guesses correctly, the program updates statistics (total attempts and rounds won) and breaks out of the inner loop.
If the user runs out of attempts without guessing correctly, the program displays the correct number.
After each round, the program asks the user if they want to play again and sets the playAgain flag accordingly.
Finally, after the user decides not to play again, the program prints a game over message with the user's score (rounds won and total attempts).
 */
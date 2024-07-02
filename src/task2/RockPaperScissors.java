package task2;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        String playAgain = null;
        do {
            System.out.println("\nLet's play Rock, Paper, Scissors!");

            // Get user's choice
            System.out.print("Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            // Validate user input
            if (!isValidChoice(userChoice, choices)) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                continue; // Skip to the next iteration if invalid choice
            }

            // Generate computer's choice
            int computerIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerIndex];

            // Determine winner
            int result = compareChoices(userChoice, computerChoice);

            // Display results
            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);

            switch (result) {
                case 0:
                    System.out.println("It's a tie!");
                    break;
                case 1:
                    System.out.println("You win!");
                    break;
                case 2:
                    System.out.println("Computer wins!");
                    break;
            }

            // Ask user to play again
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().toLowerCase();

        } while (playAgain.equals("yes")); // Continue playing until user chooses no

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static boolean isValidChoice(String choice, String[] validChoices) {
        for (String validChoice : validChoices) {
            if (choice.equals(validChoice)) {
                return true;
            }
        }
        return false;
    }

    // Function to compare choices and determine winner
    public static int compareChoices(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return 0; // Tie
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return 1; // User wins
        } else {
            return 2; // Computer wins
        }
    }
}
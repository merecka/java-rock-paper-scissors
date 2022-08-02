package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 3;
        boolean keepPlaying;

        do {
            int rounds;
            int ties = 0;
            int userWins = 0;
            int cpuWins = 0;
            int userSelection;

            System.out.println("How many rounds would you like to play? (1-10)");
            rounds = scanner.nextInt();

            if (rounds < 1 || rounds > 10) {
                System.out.println("This is not a valid selection.");
                return;
            }

            // Loop game through the number of rounds
            for (int i = 0; i < rounds; i++) {
                while (true) {
                    userSelection = userSelect();

                    if (userSelection >= 1 && userSelection <= 3) {
                        break;
                    } else {
                        System.out.println("Invalid selection.  Please try again.");
                    }
                }

                int computerSelection = (int) (min + Math.random() * max);
                System.out.println("Computer selection is: " + computerSelection);

                if (computerSelection == userSelection) {
                    ties++;
                    System.out.println("Result was a tie.");
                } else if (userSelection == 1) {  // User chooses Rock
                    if (computerSelection == 2) {  // CPU chooses Paper
                        cpuWins++;
                        System.out.println("Computer wins.");
                    } else {  // CPU chooses Scissors
                        userWins++;
                        System.out.println("You win!");
                    }
                } else if (userSelection == 2) {  // User chooses Paper
                    if (computerSelection == 3) {  //CPU chooses Scissors
                        cpuWins++;
                        System.out.println("Computer wins.");
                    } else if (computerSelection == 1) {  // CPU chooses Rock
                        userWins++;
                        System.out.println("You win!");
                    }
                } else {  // User chooses Scissors
                    if (computerSelection == 1) {  // CPU chooses Rock
                        cpuWins++;
                        System.out.println("Computer wins.");
                    } else if (computerSelection == 2) {  // CPU chooses Paper
                        userWins++;
                        System.out.println("You win!");
                    }
                }
            }

            // End of game
            System.out.println("Ties: " + ties + ", Your Wins: " + userWins + ", Computer Wins: " + cpuWins);
            if (userWins > cpuWins) {
                System.out.println("You are the overall winner!");
            } else {
                System.out.println("The computer is overall winner.");
            }

            // Ask if User wants to keep playing
            System.out.println("Would you like to play again?  Enter 'Y' or 'N' ");
            String decision = scanner.next();

            if (decision.equalsIgnoreCase("y")) {
                keepPlaying = true;
            } else {
                System.out.println("Thanks for playing!");
                keepPlaying = false;
            }
        } while (keepPlaying);
    }

    public static int userSelect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose:  Rock = 1, Paper = 2, Scissors = 3");
        return scanner.nextInt();
    }
}
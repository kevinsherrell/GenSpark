package com.genspark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 20;
        int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
        System.out.println(random);
        int tries = 0;
        System.out.println("Hello! What is your name?");
        String name = scanner.nextLine();
        System.out.println("Well, " + name + " I am thinking of a number between 1 and 20");
        while (tries < 6) {
            try {
                System.out.println("Take a guess");
                int guess = scanner.nextInt();

                if (guess == random) {
                    tries++;
                    if (continueGame(tries, scanner, name)) {
                        tries = 0;
                        continue;
                    } else {
                        break;
                    }
                } else if (guess < random) {
                    System.out.println("Your guess is too low");
                } else if (guess > random) {
                    System.out.println("Your guess is too high.");
                }
            } catch (Exception e) {
                System.out.println("invalid input");
                scanner.nextLine();
            }

        }
    }

    public static boolean continueGame(int tries, Scanner scanner, String name) {
        boolean end = false;
        boolean startOver = false;

        while (!end) {
            try {
                System.out.println("Good job, " + name + "!" + " You guessed my number in " + tries + " guesses!");
                System.out.println("Would you like to play again? (y or n)");
                String restart = scanner.next();
                if (restart.equals("y")) {
                    startOver = true;
                    break;
                } else if (restart.equals("n")) {
                    startOver = false;
                    break;
                } else {
                    System.out.println("Please enter a valid choice. (y or n)");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("invalid response");
                scanner.nextLine();
                continue;
            }

        }

        return startOver;
    }
}

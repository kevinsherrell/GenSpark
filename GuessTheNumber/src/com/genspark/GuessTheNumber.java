package com.genspark;

import java.util.Scanner;

public class GuessTheNumber {
    private int min = 0;
    private int max = 20;
    private int random;
    private int tries = 0;
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int guess;
    private boolean running = true;

    public void runGame() {
        while (running) {
            random = (int) Math.floor(Math.random() * (max - min + 1) + min);
            startGame();
            if (startIntroPhase()) {
                while (tries < 6) {
                    if (startGuessPhase()) {
                        if (checkGuess(guess)) {
                            if (victoryPhase(tries, scanner, name)) {
                                continue;
                            } else {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }
        }


    }

    public void startGame() {
        System.out.println(random);
        System.out.println("Hello! What is your name?");
    }

    public boolean startIntroPhase() {
        try {
            setName(scanner.nextLine());
            return true;
        } catch (Exception e) {
            System.out.println("Exception: Invalid Input");
            scanner.nextLine();
            return false;
        }
    }

    public boolean startGuessPhase() {
        try {
            System.out.println("Well, " + name + " I am thinking of a number between 1 and 20");
            System.out.println("Take a guess");
            setGuess(scanner.nextInt());
            return true;
        } catch (Exception e) {
            System.out.println("invalid input");
            scanner.nextLine();
            return false;
        }
    }

    public boolean checkGuess(int guess) {
        if (guess == random) {
            tries++;
            return true;
        } else if (guess < random) {
            tries++;
            System.out.println("Your guess is too low");
            return false;
        } else if (guess > random) {
            tries++;
            System.out.println("Your guess is too high.");
            return false;
        }else if(tries == 6){
            running = false;
        }
        return false;
    }

    public boolean victoryPhase(int tries, Scanner scanner, String name) {
//        boolean end = false;
//        boolean startOver = false;
//        while (!end) {
        boolean restartGame = false;
        try {

            System.out.println("Good job, " + name + "!" + " You guessed my number in " + tries + " guesses!");
            System.out.println("Would you like to play again? (y or n)");
            String restart = scanner.next();
            if (restart.equals("y")) {
                restartGame = true;
                //startOver = true;
//                    break;
            } else if (restart.equals("n")) {
                running = false;
//                    startOver = false;
//                running = false;
//                    break;
            }
//            else {
//                System.out.println("Please enter a valid choice. (y or n)");
////                    continue;
//            }
        } catch (Exception e) {
            System.out.println("invalid response");
            scanner.nextLine();
//                continue;
        }

//        }

        return restartGame;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
}

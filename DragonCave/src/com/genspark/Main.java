package com.genspark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("You are in a land full of dragons. In front of you,\nyou see two caves. In one cave, the dragon is friendly\nand will share his treasure with you. The other dragon\nis greedy and hungry and will eat you on sight.\n Which cave will you go into? (1 or 2 )");
        try {
            runGame();
        } catch (Exception e) {
            System.out.println("Please enter a valid response");
            runGame();
        }

    }

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        int input;
        input = scanner.nextInt();
        System.out.println("You approach the cave...\nIt is dark and spooky...\n");
        if (input == 1) {
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...\n Gobbles you down in one bite! ");
        } else if (input == 2) {
            System.out.println("A friendly dragon approaches you and offers you all of his treasure!!! ");
        } else {
            System.out.println("Pleas enter a valid choice! (1 or 2)");
        }
    }
}

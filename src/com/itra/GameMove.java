package com.itra;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class GameMove {
    public int computerMove(String[] args) {
        return new Random().nextInt(args.length)+1;
    }

    public int getMove(String[] args) {
        System.out.println("Enter your move: ");
        Scanner scan = new Scanner(System.in);
        int userMove;
        try {
            userMove = scan.nextInt();
            if (userMove > args.length || userMove < 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException ie) {
            System.out.println("Incorrect input. Try again\n");
            userMove = getMove(args);
        }
        return userMove;
    }

    public String getWinner(String[] args, int userMove, int computerMove) {
        int sub = Math.abs(computerMove - userMove);
        int countOfOptions = (args.length - 1) / 2;
        if (computerMove == userMove) {
            return "No";
        } else if (computerMove > userMove && countOfOptions >= sub || computerMove < userMove && countOfOptions < sub) {
            return "Computer is ";
        } else {
            return "You are ";
        }
    }
}

package com.itra;

import java.security.SecureRandom;
import static com.itra.SecureKey.generateHmac256;

public class StartGame {
    public static void startGame(String[] args) {
        GameMove game = new GameMove();

        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);

        int stepSystem = new SecureRandom().nextInt(args.length - 1);
        String firstHMAC = generateHmac256(args[stepSystem] ,bytes);

        int pcMove = game.computerMove(args);
        String pcMoveHMAC = generateHmac256(firstHMAC + args[pcMove-1], bytes);
        System.out.println("HMAC + PC move: " + pcMoveHMAC.toUpperCase());
        showListOfMoves(args);
        int userMove = game.getMove(args);
        if(userMove==0){System.out.println("You left the game");
        } else{
            String winner = game.getWinner(args, userMove, pcMove);
            showResultOfGame(args, winner, userMove, pcMove);
            System.out.println("HMAC: " + firstHMAC.toUpperCase());
        }
    }

    private static void showListOfMoves(String[] args) {
        System.out.println("Player, please make a move. " +
                "Point your choice by entering one of the options below:");
        for (int i = 0; i < args.length; i++) {
            System.out.println((i + 1) + " - " + args[i]);
        } System.out.println("0 - exit");
    }

    private static void showResultOfGame(String[] args, String winner, int userMove, int pcMove) {
        System.out.printf("Your move is: %s\nPC move is: %s\n%s winner\n", args[userMove - 1], args[pcMove - 1], winner);
    }
}

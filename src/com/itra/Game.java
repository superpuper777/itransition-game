package com.itra;

import java.util.Arrays;
import java.util.HashSet;

import static com.itra.StartGame.startGame;

    public class Game {
        public static void main(String[] args) {
            try {
                if (args.length % 2 == 0 ||
                        args.length <= 1 ) {
                    throw new Exception("Incorrect input, please enter an odd number of non-repeating lines, for example java -jar game.jar rock paper scissors lizard Spock");
                }
                if(args.length != new HashSet<>(Arrays.asList(args)).size()){
                    throw new Exception("Same options");
                }
                startGame(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

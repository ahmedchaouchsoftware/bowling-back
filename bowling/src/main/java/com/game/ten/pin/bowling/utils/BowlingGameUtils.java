package com.game.ten.pin.bowling.utils;

public class BowlingGameUtils {

    public static boolean isStrike(int index, Integer[] game) {
        return game[index] != null && game[index] == 10;
    }

    public static int calculateStrikeBonus(int index, Integer[] game) {
        return (game[index + 1] != null && game[index + 2] != null) ? game[index + 1] + game[index + 2] : 0;
    }

    public static boolean isSpare(int index, Integer[] game) {
        return game[index] != null && game[index + 1] != null && game[index] + game[index + 1] == 10;
    }

    public static int calculateSpareBonus(int index, Integer[] game) {
        return (game[index + 2] != null) ? game[index + 2] : 0;
    }

    public static int calculateFrameScore(int index, Integer[] game) {
        return (game[index] != null && game[index + 1] != null) ? game[index] + game[index + 1] : 0;
    }
}

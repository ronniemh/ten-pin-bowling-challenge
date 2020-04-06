package dev.ronniemoncayo;

public class ExceedsNumberGamesException extends Exception {

    private static final long serialVersionUID = 1L;

    public ExceedsNumberGamesException(String playerName, int number) {
        super(playerName.concat(" exceeds the maximum number of games: " + number));
    }

}
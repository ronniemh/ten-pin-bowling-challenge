package dev.ronniemoncayo;

/* Exception when player exceeds the number of*/
public class PinThrowingExceedsException extends Exception {

    private static final long serialVersionUID = 1L;

    public PinThrowingExceedsException(String playerName, int number) {
        super(playerName.concat(" exceeded the number of throwing pins: " + number));
    }

    public PinThrowingExceedsException(String playerName, int number, int expected) {
        super(playerName
                .concat(" exceeded the number of throwing pins, encountered: " + number + ", expected: " + expected));
    }

}
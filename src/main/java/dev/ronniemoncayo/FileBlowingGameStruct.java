package dev.ronniemoncayo;

/**
 * Final Structure to which some type of valid information entry will be converted
 * (e.g., text file, database, etc...)
 */
public class FileBlowingGameStruct {

    private final String playerName;
    private final String pinsKnockedDown;
    private final boolean isFoul;

    public FileBlowingGameStruct(String playerName, String pinsKnockedDown, boolean isFoul) {
        this.playerName = playerName;
        this.pinsKnockedDown = pinsKnockedDown;
        this.isFoul = isFoul;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPinsKnockedDown() {
        return pinsKnockedDown;
    }

    public boolean isFoul() {
        return isFoul;
    }
}
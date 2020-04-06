package dev.ronniemoncayo;

import java.util.List;

/**
 * Abstract class for BowlingGame, has the most important information
 * (Logic Game)
 */
public abstract class BowlingGame {

    private static final int MAX_FRAME_NUMBER = 10;

    private final String playerName;

    private List<Frame> frames;

    public BowlingGame(String playerName) {
        this.playerName = playerName;
    }

    /**
     * The class that extends the abstract class must know how to get the frames
     * @throws PinThrowingExceedsException
     */
    public abstract List<Frame> createFrames() throws PinThrowingExceedsException;

    public String getPlayerName() {
        return playerName;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }

    public static int getMaxFrameNumber() {
        return MAX_FRAME_NUMBER;
    }

}

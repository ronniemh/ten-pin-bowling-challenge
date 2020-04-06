package dev.ronniemoncayo;

import java.util.List;

public abstract class BowlingGame {

    private static final int MAX_FRAME_NUMNBER = 10;
    private final String playerName;
    private List<Frame> frames;

    public BowlingGame(String playerName) {
        this.playerName = playerName;
    }

    public abstract List<Frame> createFrames() throws ExceedsNumberGamesException;

    public String getPlayerName() {
        return playerName;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }

    public static int getMaxFrameNumnber() {
        return MAX_FRAME_NUMNBER;
    }

}

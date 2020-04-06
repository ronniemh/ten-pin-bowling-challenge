package dev.ronniemoncayo;

public abstract class Frame implements FrameString {

    private int score;
    private final int numberFrame;

    private final Roll firstRoll;
    private final Roll secondRoll;

    private final boolean isStrike;
    private final boolean isSpare;
    private final boolean isNormal;
    

    @Override
    public String toString() {
        return getFrameString();
    }

    public Frame(int numberFrame, Roll firstRoll, Roll secondRoll) {
        this.numberFrame = numberFrame;
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        isStrike = firstRoll.getKnockedPins() == 10;
        isSpare = !isStrike && (firstRoll.getKnockedPins() + secondRoll.getKnockedPins())==10;
        isNormal = !isSpare && !isStrike;
    }

    public int getNumberFrame() {
        return numberFrame;
    }

    public Roll getFirstRoll() {
        return firstRoll;
    }

    public Roll getSecondRoll() {
        return secondRoll;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public boolean isNormal() {
        return isNormal;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

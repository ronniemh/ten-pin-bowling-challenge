package dev.ronniemoncayo;

public class Roll {

    private final int knockedPins;
    private final boolean isFoul;

    public Roll(int knockedPins, boolean isFoul) {
        this.knockedPins = knockedPins;
        this.isFoul = isFoul;
    }

    public int getKnockedPins() {
        return knockedPins;
    }

    public boolean isFoul() {
        return isFoul;
    }
    
}

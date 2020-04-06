package dev.ronniemoncayo;

public class NormalFrame extends Frame {

    public NormalFrame(int numberFrame, Roll firstRoll, Roll secondRoll) {
        super(numberFrame, firstRoll, secondRoll);
    }



    @Override
    public String getFrameString() {
        StringBuilder sb = new StringBuilder();
        if(super.isStrike()){
            sb.append("\t\tX");
        }
        else if(super.isSpare()){
            sb.append("\t");
            sb.append(getFirstRoll().isFoul() ? "F" : getFirstRoll().getKnockedPins());
            sb.append("\t/");
        }
        else{
            sb.append("\t");
            sb.append(getFirstRoll().isFoul() ? "F":getFirstRoll().getKnockedPins());
            sb.append("\t");
            sb.append(getSecondRoll().isFoul() ? "F":getSecondRoll().getKnockedPins());
        }

        return sb.toString();
    }

}
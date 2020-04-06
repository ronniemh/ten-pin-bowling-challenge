package dev.ronniemoncayo;

public class TenthFrame extends Frame {

    private final Roll thirdRoll;

    public TenthFrame(int numberFrame, Roll firstRoll, Roll secondRoll, Roll thirdRoll) {
        super(numberFrame, firstRoll, secondRoll);
        this.thirdRoll = thirdRoll;
    }

    @Override
    public String getFrameString() {
        StringBuilder sb = new StringBuilder();
        if(super.isStrike()){
            sb.append("\t");
            sb.append("X");
        }
        else{
            sb.append("\t");
            if(super.getFirstRoll().isFoul()){
                sb.append("F");
            }
            else{
                sb.append(super.getFirstRoll().getKnockedPins());
            }
        }
        sb.append("\t");
        sb.append(super.getSecondRoll().isFoul() ? "F" : (super.getSecondRoll().getKnockedPins() == 10) ? "X" : (super.isSpare()) ? "/" : super.getSecondRoll().getKnockedPins());
        if(getThirdRoll() != null){
            sb.append("\t");
            sb.append(getThirdRoll().isFoul()? "F" :  (getThirdRoll().getKnockedPins() == 10) ? "X" : getThirdRoll().getKnockedPins());
        }
       return sb.toString();
    }

    public Roll getThirdRoll() {
        return thirdRoll;
    }
}
package dev.ronniemoncayo;

import java.util.ArrayList;
import java.util.List;

public class FileBowlingGame extends BowlingGame {

    private final List<FileBlowingGameStruct> data;
    private int score = 0;

    public FileBowlingGame(String playerName, List<FileBlowingGameStruct> data) {
        super(playerName);
        this.data = data;
        super.setFrames(createFrames());

    }

    @Override
    public List<Frame> createFrames() {
        List<Frame> frames = new ArrayList<>();
        FileBlowingGameStruct[] arrayData = data.stream().toArray(FileBlowingGameStruct[]::new);
        if (arrayData.length > 21) {
            //TODO verify exception
        }
        int frameIndex = 0;
        for (int i = 1; i <= super.getMaxFrameNumnber(); i++) {
            if (i < super.getMaxFrameNumnber()) {
                if (arrayData[frameIndex].getPinsKnockedDown().equals(String.valueOf(super.getMaxFrameNumnber()))) {
                    frames.add(new NormalFrame(i, new Roll(Integer.valueOf(arrayData[frameIndex].getPinsKnockedDown()),
                            arrayData[frameIndex].isFoul()), new Roll(0, false)));
                    frameIndex++;
                } else {
                    frames.add(new NormalFrame(i,
                            new Roll(Integer.valueOf(arrayData[frameIndex].getPinsKnockedDown()),
                                    arrayData[frameIndex].isFoul()),
                            new Roll(Integer.valueOf(arrayData[frameIndex + 1].getPinsKnockedDown()),
                                    arrayData[frameIndex + 1].isFoul())));
                    frameIndex = frameIndex + 2;
                }

            } else {
                Roll first = new Roll(Integer.valueOf(arrayData[frameIndex].getPinsKnockedDown()),
                        arrayData[frameIndex].isFoul());
                Roll second = new Roll(Integer.valueOf(arrayData[frameIndex + 1].getPinsKnockedDown()),
                        arrayData[frameIndex + 1].isFoul());
                Roll third = (frameIndex + 1) > arrayData.length ? null
                        : new Roll(Integer.valueOf(arrayData[frameIndex + 2].getPinsKnockedDown()),
                                arrayData[frameIndex + 2].isFoul());

                frames.add(new TenthFrame(i, first, second, third));
                frameIndex = third == null ? frameIndex + 1 : frameIndex + 2;

            }

        }
        System.out.println("frame index: " + frameIndex);
        frames.forEach(frm -> {
            if (frm.getNumberFrame() == super.getMaxFrameNumnber()) {
                TenthFrame thent = (TenthFrame) frm;
                score += frm.getFirstRoll().getKnockedPins() + frm.getSecondRoll().getKnockedPins()
                        + (thent.getThirdRoll() == null ? 0 : thent.getThirdRoll().getKnockedPins());
            } else {
                if (frm.isStrike()) {
                    score += 10;
                    Frame nextOne = frames.stream()
                            .filter(frame -> frame.getNumberFrame() == (frm.getNumberFrame() + 1)).findFirst()
                            .orElse(null);
                    // TODO: poner la validacion
                    int frmSearch = frm.getNumberFrame() + 2 > super.getMaxFrameNumnber() ? super.getMaxFrameNumnber()
                            : frm.getNumberFrame() + 2;
                    Frame nextTwo = nextOne.isStrike() ? frames.stream()
                            .filter(frame -> frame.getNumberFrame() == frmSearch).findFirst().orElse(null) : null;
                    score += nextOne.isStrike()
                            ? ((nextOne.equals(nextTwo)) ? (nextTwo.getSecondRoll().getKnockedPins() + 10)
                                    : (nextTwo.getFirstRoll().getKnockedPins() + 10))
                            : (nextOne.getFirstRoll().getKnockedPins() + nextOne.getSecondRoll().getKnockedPins());

                } else if (frm.isSpare()) {
                    Frame nextOne = frames.stream()
                            .filter(frame -> frame.getNumberFrame() == (frm.getNumberFrame() + 1)).findFirst()
                            .orElse(null);
                    score += 10 + nextOne.getFirstRoll().getKnockedPins();
                } else if (frm.isNormal()) {
                    score += frm.getFirstRoll().getKnockedPins() + frm.getSecondRoll().getKnockedPins();
                }
            }
            frm.setScore(score);
        });
        return frames;
    }

}
package dev.ronniemoncayo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FileBowlingGameTest {

    List<FileBlowingGameStruct> perfectGame;
    List<FileBlowingGameStruct> allFouls;
    List<FileBlowingGameStruct> allZero;

    FileBowlingGame fileBowlingGame;

    @Before
    public void setup() {

        allFouls = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            allFouls.add(new FileBlowingGameStruct("fuolPlayer", "0", true));
        }

        perfectGame = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            perfectGame.add(new FileBlowingGameStruct("ronnie", "10", false));
        }

        allZero = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            allZero.add(new FileBlowingGameStruct("ronnie", "0", false));
        }

    }

    @Test(expected = PinThrowingExceedsException.class)
    public void testExceedDataArgumentException() throws PinThrowingExceedsException {
        List<FileBlowingGameStruct> exceedData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            exceedData.add(new FileBlowingGameStruct("ronnie", "0", false));
        }
        fileBowlingGame = new FileBowlingGame("exceedPlayer", exceedData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() throws PinThrowingExceedsException {
        List<FileBlowingGameStruct> littleData = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            littleData.add(new FileBlowingGameStruct("ronnie", "0", false));
        }
        fileBowlingGame = new FileBowlingGame("zeroPlayer", littleData);
    }

    @Test
    public void scoreAllZeroGame() throws PinThrowingExceedsException {
        fileBowlingGame = new FileBowlingGame("zeroPlayer", allZero);
        assertEquals(0, fileBowlingGame.getFrames().get(fileBowlingGame.getFrames().size() - 1).getScore());
    }

    @Test
    public void framesNumberAllZeroGame() throws PinThrowingExceedsException {
        fileBowlingGame = new FileBowlingGame("zeroPlayer", allZero);
        assertEquals(10, fileBowlingGame.getFrames().size());
    }

    @Test
    public void scoreAllFoulGame() throws PinThrowingExceedsException {
        fileBowlingGame = new FileBowlingGame("ronnie", allFouls);
        assertEquals(0, fileBowlingGame.getFrames().get(fileBowlingGame.getFrames().size() - 1).getScore());
    }

    @Test
    public void throwNumberAllFoulsGame() throws PinThrowingExceedsException {
        fileBowlingGame = new FileBowlingGame("fuolPlayer", allFouls);
        assertEquals(10, fileBowlingGame.getFrames().size());
    }

    @Test
    public void throwNumberPerfectGame() throws PinThrowingExceedsException {
        fileBowlingGame = new FileBowlingGame("ronnie", perfectGame);
        assertEquals(10, fileBowlingGame.getFrames().size());
    }

    @Test
    public void scorePerfectGame() throws PinThrowingExceedsException {
        fileBowlingGame = new FileBowlingGame("ronnie", perfectGame);
        assertEquals(300, fileBowlingGame.getFrames().get(fileBowlingGame.getFrames().size() - 1).getScore());
    }

}
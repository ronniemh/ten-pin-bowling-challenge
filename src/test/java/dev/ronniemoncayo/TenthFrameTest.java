package dev.ronniemoncayo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TenthFrameTest {

    TenthFrame tenthFrame;

    @Test
    public void testIsStrike() {
        tenthFrame = new TenthFrame(1, new Roll(10, false), new Roll(0, false), null);
        assertEquals(true, tenthFrame.isStrike());
    }

    @Test
    public void testIsSpare() {
        tenthFrame = new TenthFrame(1, new Roll(5, false), new Roll(5, false), null);
        assertEquals(true, tenthFrame.isSpare());
    }

    @Test
    public void testIsNormal() {
        tenthFrame = new TenthFrame(1, new Roll(5, false), new Roll(2, false), null);
        assertEquals(true, tenthFrame.isNormal());
    }

    @Test
    public void printThirdFrame() {
        tenthFrame = new TenthFrame(1, new Roll(10, false), new Roll(0, false), new Roll(0, true));
        assertEquals("\tX\t0\tF", tenthFrame.toString());
    }

    @Test
    public void printNullThirdFrame() {
        tenthFrame = new TenthFrame(1, new Roll(5, false), new Roll(5, false), null);
        assertEquals("\t5\t/", tenthFrame.toString());
    }

    @Test
    public void printSpareAndNotNullThirdFrame() {
        tenthFrame = new TenthFrame(1, new Roll(5, false), new Roll(5, false), new Roll(5, false));
        assertEquals("\t5\t/\t5", tenthFrame.toString());
    }

}
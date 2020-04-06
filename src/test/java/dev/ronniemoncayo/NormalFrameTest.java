package dev.ronniemoncayo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NormalFrameTest {

    NormalFrame normalFrame;

    @Test
    public void testIsStrike(){
        normalFrame = new NormalFrame(1, new Roll(10, false),new Roll(0, false));
        assertEquals(true, normalFrame.isStrike());
    }

    @Test
    public void testIsSpare(){
        normalFrame = new NormalFrame(1, new Roll(5, false),new Roll(5, false));
        assertEquals(true, normalFrame.isSpare());
    }

    @Test
    public void testIsNormal(){
        normalFrame = new NormalFrame(1, new Roll(5, false),new Roll(2, false));
        assertEquals(true, normalFrame.isNormal());
    }

    @Test
    public void printStrike(){
        normalFrame = new NormalFrame(1, new Roll(10, false),new Roll(0, false));
        assertEquals("\t\tX", normalFrame.toString());
    }

    @Test
    public void printSpare(){
        normalFrame =  new NormalFrame(1, new Roll(5, false),new Roll(5, false));
        assertEquals("\t5\t/", normalFrame.toString());
    }

    @Test
    public void printNormal(){
        normalFrame = new NormalFrame(1, new Roll(5, false),new Roll(2, false));
        assertEquals("\t5\t2", normalFrame.toString());
    }

}
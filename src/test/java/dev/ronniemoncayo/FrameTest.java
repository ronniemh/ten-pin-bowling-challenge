package dev.ronniemoncayo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class FrameTest {

    @Test
    public void givenNonAbstractMethod_whenMockitoMock_testCorrectBehaviour() {
        Frame frame = Mockito.mock(Frame.class, Mockito.CALLS_REAL_METHODS);
        assertEquals(0, frame.getScore());
    }

}
package dev.ronniemoncayo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChallengeCaseFileReaderTest {

    @Test
    public void testValidationPinGoodArgument() {

        for (int i = 0; i <= 10; i++) {
            assertEquals(true, ChallengeCaseFileReader.validateKnockedDownPins(String.valueOf(i)));
        }
    }

    @Test
    public void testValidationPinFoulArgument() {

        assertEquals(true, ChallengeCaseFileReader.validateKnockedDownPins("F"));
    }

    @Test
    public void testValidationPinBadArgument() {

        assertEquals(false, ChallengeCaseFileReader.validateKnockedDownPins(String.valueOf("11")));
    }

}
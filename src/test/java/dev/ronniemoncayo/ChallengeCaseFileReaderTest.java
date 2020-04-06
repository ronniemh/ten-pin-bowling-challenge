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

    @Test
    public void testValidationPinNegativeNumberArgument() {

        assertEquals(false, ChallengeCaseFileReader.validateKnockedDownPins(String.valueOf("-6")));
    }

    @Test
    public void testValidationPinEmptyArgument() {

        assertEquals(false, ChallengeCaseFileReader.validateKnockedDownPins(String.valueOf("")));
    }

    @Test
    public void testMapLineToFileBlowingGameStruct() {
        ChallengeCaseFileReader challengeCaseFileReader = new ChallengeCaseFileReader(null);
        String line = "ronnie\t2";
        FileBlowingGameStruct fileBlowingGameStruct = challengeCaseFileReader.mapFileLine(line);
        assertEquals("ronnie", fileBlowingGameStruct.getPlayerName());
        assertEquals("2", fileBlowingGameStruct.getPinsKnockedDown());
    }
    

}
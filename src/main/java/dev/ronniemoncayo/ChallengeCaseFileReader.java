package dev.ronniemoncayo;

import java.nio.file.Path;

/**
 * Class that will be used to read the file proposed in the challenge
 */
public class ChallengeCaseFileReader extends GenericBowlingFileReader {

    private static final String LINE_SEPARATOR = "\\t";

    /* Only numerics from 0 to 10 and 'F' */
    private static final String PINS_KNOCKED_DOWN_REGEX = "([0-9]|10|F)";

    protected ChallengeCaseFileReader(Path filePath) {
        super(filePath);
    }

    protected static boolean validateKnockedDownPins(String pin) {
        return pin.matches(PINS_KNOCKED_DOWN_REGEX);
    }

    /* Challenge rules*/
    @Override
    protected FileBlowingGameStruct mapFileLine(String line) {
        
        String[] information = line.split(LINE_SEPARATOR);

        if (information.length != 2) {
            throw new ClassCastException("Invalid length, ".concat(line).concat(" can not be casted to ")
            .concat(FileBlowingGameStruct.class.getName()));
        }

        if (!validateKnockedDownPins(information[1])) {
            throw new IllegalArgumentException(information[1].concat(" is not an allowed argument"));
        }

        boolean isFoul = information[1].equals("F");

        return new FileBlowingGameStruct(information[0], isFoul ? "0" : information[1], isFoul);
    }

}
package dev.ronniemoncayo;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class IntegrationTest {

    @Test
    public void calculatePerfectScore() throws Exception {
        GenericBowlingFileReader genericBowlingFileReader = new ChallengeCaseFileReader(
                Paths.get("src/test/resources/perfect_game"));

        Match match = new BowlingGameFileService(genericBowlingFileReader);
        assertEquals(300,
                match.getGames().get(0).getFrames().get(match.getGames().get(0).getFrames().size() - 1).getScore());
    }

    @Test
    public void calculateZeroScore() throws Exception {
        GenericBowlingFileReader genericBowlingFileReader = new ChallengeCaseFileReader(
                Paths.get("src/test/resources/zero_score"));

        Match match = new BowlingGameFileService(genericBowlingFileReader);
        assertEquals(0,
                match.getGames().get(0).getFrames().get(match.getGames().get(0).getFrames().size() - 1).getScore());
    }

    @Test
    public void twoPlayers() throws Exception {
        GenericBowlingFileReader genericBowlingFileReader = new ChallengeCaseFileReader(
                Paths.get("src/test/resources/2players"));
        Match match = new BowlingGameFileService(genericBowlingFileReader);
        assertEquals(2, match.getGames().size());
    }

    @Test
    public void challengeScore() throws Exception {
        GenericBowlingFileReader genericBowlingFileReader = new ChallengeCaseFileReader(
                Paths.get("src/test/resources/2players"));
        Match match = new BowlingGameFileService(genericBowlingFileReader);
        assertEquals(151,
                match.getGames().get(0).getFrames().get(match.getGames().get(0).getFrames().size() - 1).getScore());
        assertEquals(167,
                match.getGames().get(1).getFrames().get(match.getGames().get(0).getFrames().size() - 1).getScore());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidFile() throws Exception {
        GenericBowlingFileReader genericBowlingFileReader = new ChallengeCaseFileReader(
                Paths.get("src/test/resources/incorrect"));
        Match match = new BowlingGameFileService(genericBowlingFileReader);
    }

}
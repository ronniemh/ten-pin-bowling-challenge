package dev.ronniemoncayo;

import java.nio.file.Paths;

/**
 * Class containing main method
 * 
 * @author Ronnie Moncayo
 */
public class App {
  public static void main(String[] args) throws Exception {
    String tmp = "/tmp/bad";
    GenericBowlingFileReader genericBowlingFileReader = new ChallengeCaseFileReader(Paths.get(tmp));
    Match match = new BowlingGameFileService(genericBowlingFileReader);
    match.printScore();
  }

}

package dev.ronniemoncayo;

import java.nio.file.Paths;

/**
 * Class containing main method
 * 
 * @author Ronnie Moncayo
 */
public class App {
  public static void main(String... args) throws Exception {
    if(args.length != 1){
      throw new IllegalArgumentException("Exactly 1 parameter required");
    }
    GenericBowlingFileReader genericBowlingFileReader = new ChallengeCaseFileReader(Paths.get(args[0]));
    Match match = new BowlingGameFileService(genericBowlingFileReader);
    match.printScore();
  }

}

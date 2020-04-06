package dev.ronniemoncayo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BowlingGameFileService extends Match {

    private final GenericBowlingFileReader genericBowlingFileReader;

    public BowlingGameFileService(GenericBowlingFileReader genericBowlingFileReader)
            throws IOException{
        this.genericBowlingFileReader = genericBowlingFileReader;
        super.setGames(getGames());
    }

    public List<BowlingGame> getGames() throws IOException  {
        List<FileBlowingGameStruct> list = genericBowlingFileReader.readFile();

        Map<String, List<FileBlowingGameStruct>> gamesMap = list.stream()
                .collect(Collectors.groupingBy(FileBlowingGameStruct::getPlayerName));
       
        return gamesMap.entrySet().stream().map(c -> new FileBowlingGame(c.getKey(), c.getValue()))
                .collect(Collectors.toList());

    }

    @Override
    public void printScore() throws IOException, Exception {
       StringBuilder sb = new StringBuilder("Frame");
       for (int i = 1; i <= 10; i++) {
           sb.append("\t\t"+i);
       }
       super.getGames().forEach(c ->
       {
           
           sb.append("\n"+c.getPlayerName()+"\n");
           sb.append("Paintfalls");
           c.getFrames().forEach(f -> sb.append(f));
           sb.append("\nScore\t\t");
           sb.append(c.getFrames().stream().map(d -> String.valueOf(d.getScore())).collect(Collectors.joining("\t\t")));
       });
       System.out.println(sb.toString());
    }

}
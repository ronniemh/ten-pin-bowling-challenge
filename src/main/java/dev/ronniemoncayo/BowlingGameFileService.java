package dev.ronniemoncayo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BowlingGameFileService extends Match {

    private final GenericBowlingFileReader genericBowlingFileReader;

    public BowlingGameFileService(GenericBowlingFileReader genericBowlingFileReader) throws Exception {
        this.genericBowlingFileReader = genericBowlingFileReader;
        super.setGames(getGames());
        super.getGames().stream().filter(game -> game != null).findAny()
                .orElseThrow(() -> new Exception("The file does not meet the game requirements"));
    }

    public List<BowlingGame> getGames() throws IOException {
        List<FileBlowingGameStruct> list = genericBowlingFileReader.readFile();

        Map<String, List<FileBlowingGameStruct>> gamesMap = list.stream()
                .collect(Collectors.groupingBy(FileBlowingGameStruct::getPlayerName));

        return gamesMap.entrySet().stream().map(gameMap -> {
            try {
                return new FileBowlingGame(gameMap.getKey(), gameMap.getValue());
            } catch (PinThrowingExceedsException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

    }

    @Override
    public void printScore() throws IOException {
        StringBuilder sb = new StringBuilder("Frame");
        for (int i = 1; i <= 10; i++) {
            sb.append("\t\t" + i);
        }
        super.getGames().forEach(game -> {

            sb.append("\n" + game.getPlayerName() + "\n");
            sb.append("Paintfalls");

            game.getFrames().forEach(f -> sb.append(f));

            sb.append("\nScore\t\t");
            sb.append(game.getFrames().stream().map(d -> String.valueOf(d.getScore())).collect(Collectors.joining("\t\t")));
        });
        System.out.println(sb.toString());
    }

}
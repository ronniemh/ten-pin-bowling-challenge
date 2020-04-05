package dev.ronniemoncayo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract class for read a file for can map information file to FileBlowingGameStruct class,
 * 
 */
public abstract class GenericBowlingFileReader{
    protected Path filePath;

    protected GenericBowlingFileReader(Path filePath) {
        this.filePath = filePath;
    }
     
    public Path getFilePath() {
        return filePath;
    }
     
    public List<FileBlowingGameStruct> readFile() throws IOException {
        return Files.lines(filePath)
          .map(this::mapFileLine).collect(Collectors.toList());
    }
     
    protected abstract FileBlowingGameStruct mapFileLine(String line);

}
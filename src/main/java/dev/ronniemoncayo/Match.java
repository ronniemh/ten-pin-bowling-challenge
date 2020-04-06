package dev.ronniemoncayo;

import java.io.IOException;
import java.util.List;

public abstract class Match implements MatchPrintable{

    /* A match has games*/
    private List<BowlingGame> games;

    public List<BowlingGame> getGames() throws IOException{
        return games;
    }

    public void setGames(List<BowlingGame> games){
        this.games = games;
    }

    
}
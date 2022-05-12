package lld.chess.model;

import lld.chess.constants.GameType;

public class MatchModel {

    private GameType gameType;

    private long maxGameDurationInSec;

    public MatchModel(GameType gameType, long maxGameDurationInSec) {
        this.gameType = gameType;
        this.maxGameDurationInSec = maxGameDurationInSec;
    }

    public GameType getGameType() {
        return gameType;
    }

    public long getMaxGameDurationInSec() {
        return maxGameDurationInSec;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public void setMaxGameDurationInSec(long maxGameDurationInSec) {
        this.maxGameDurationInSec = maxGameDurationInSec;
    }
}

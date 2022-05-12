package lld.chess.piece;

import lld.chess.manager.IBoardManager;
import lld.chess.model.Cell;
import lld.chess.model.Move;

import java.util.List;

public abstract class Piece {

    protected IBoardManager boardManager;
    protected int id;
    protected int posX;
    protected int posY;
    protected int playerId;
    protected boolean isLive;

    public abstract boolean move(Move move);

    public abstract boolean validateMove(Move move);

    public abstract List<Cell> possibleMoves();

    public Piece(IBoardManager boardManager, int x, int y, int playerId) {

        this.boardManager = boardManager;
        this.posX = x;
        this.posY = y;
        this.playerId = playerId;
        this.isLive = true;
    }
}

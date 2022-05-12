package lld.chess.board;

import lld.chess.model.Cell;
import lld.chess.piece.Piece;

import java.util.List;

public abstract class IBoard {

    protected List<Piece> playerOne;
    protected List<Piece> playerTwo;

    protected Cell[][] cells;

    public abstract void createGame();

    public abstract void display();

    public abstract void startGame();

    public abstract void resetGame();

    public IBoard() {
        this.cells = new Cell[8][8];
    }

    public List<Piece> getPlayerOne() {
        return playerOne;
    }

    public List<Piece> getPlayerTwo() {
        return playerTwo;
    }
}

package lld.chess.manager;

import lld.chess.model.Move;

public interface IBoardManager {

    void initBoard();

    boolean updatePosition(Move m);

    boolean isValidMove(Move m);
}

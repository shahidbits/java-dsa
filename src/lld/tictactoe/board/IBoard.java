package lld.tictactoe.board;

import lld.tictactoe.model.Move;

public interface IBoard {

    void resetBoard();

    void displayBoard();

    boolean updateBoard(Move move);

    int getSize();

    boolean isCellAvailable(int x, int y);
}

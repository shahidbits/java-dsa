package lld.tictactoe.manager;

import lld.tictactoe.model.Move;

public interface IGameManager {

    void startGame();

    void resetGame();

    void displayGame();

    boolean playMove(Move move);
}

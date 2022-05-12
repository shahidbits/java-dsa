package lld.tictactoe.game;

import lld.tictactoe.model.Move;

public interface IGame {

    void startGame();

    void display();

    void resetGame();

    void playMove(Move move);
}

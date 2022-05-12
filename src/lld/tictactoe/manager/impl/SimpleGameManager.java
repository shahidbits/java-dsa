package lld.tictactoe.manager.impl;

import lld.tictactoe.board.IBoard;
import lld.tictactoe.manager.IGameManager;
import lld.tictactoe.model.Move;

public class SimpleGameManager implements IGameManager {

    IBoard board;

    public SimpleGameManager(IBoard board) {
        this.board = board;
    }

    @Override
    public void startGame() {
        this.board.resetBoard();
    }

    @Override
    public void resetGame() {
        this.board.resetBoard();
    }

    @Override
    public void displayGame() {
        this.board.displayBoard();
    }

    @Override
    public boolean playMove(Move move) {

        boolean isSuccess = this.board.updateBoard(move);

        System.out.println(String.format("Player %s puts %s on (%s,%s) : suc = %s",
                move.getPlayerId(), move.getLabel(), move.getPosX(), move.getPosY(), isSuccess ? "T" : "F"));

        if (isSuccess) {
            this.board.displayBoard();
        }

        return isSuccess;

    }
}

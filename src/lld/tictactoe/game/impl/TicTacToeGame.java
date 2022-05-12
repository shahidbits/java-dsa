package lld.tictactoe.game.impl;

import lld.tictactoe.board.IBoard;
import lld.tictactoe.board.impl.Board;
import lld.tictactoe.game.IGame;
import lld.tictactoe.manager.IGameManager;
import lld.tictactoe.manager.impl.SimpleGameManager;
import lld.tictactoe.model.Move;
import lld.tictactoe.model.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame implements IGame {

    PlayerModel[] players;

    List<Move> moves;

    IBoard board;

    IGameManager gameManager;

    PlayerModel currentPlayer;

    public TicTacToeGame(PlayerModel player1, PlayerModel player2, int boardSize) {

        // Players
        players = new PlayerModel[2];
        players[0] = player1;
        players[1] = player2;

        // Board
        this.board = new Board(boardSize);

        // Moves
        this.moves = new ArrayList<>();

        // Manager
        this.gameManager = new SimpleGameManager(this.board);

    }

    @Override
    public void startGame() {
        this.gameManager.startGame();

        this.currentPlayer = this.players[0];
    }

    @Override
    public void display() {
        this.gameManager.displayGame();
    }

    @Override
    public void resetGame() {
        this.gameManager.resetGame();
    }

    @Override
    public void playMove(Move move) {

        if (currentPlayer.getId() != move.getPlayerId()) {
            System.out.println(String.format("Wrong turn. Its Player %s turn", currentPlayer.getId()));
            return;
        }

        boolean isSuc = this.gameManager.playMove(move);

        if (isSuc) {
            this.moves.add(move);
            this.currentPlayer = this.players[0].getId() == move.getPlayerId() ? this.players[1] : this.players[0];
        }
    }
}

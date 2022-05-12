package lld.tictactoe;

import lld.tictactoe.game.IGame;
import lld.tictactoe.game.impl.TicTacToeGame;
import lld.tictactoe.model.Move;
import lld.tictactoe.model.PlayerModel;

public class TicTacToeDriver {

    public static void main(String[] args) {

        ////// Create a new Game
        // Game, Player, Move, GameManager

        PlayerModel player1 = new PlayerModel(1, "shahidbits", "Shahid");
        PlayerModel player2 = new PlayerModel(2, "ajay_007", "Ajay K");

        IGame game1 = new TicTacToeGame(player1, player2, 3);
        game1.startGame();

        game1.playMove(new Move(1, 'X', 0, 0));
        game1.playMove(new Move(2, 'O', 1, 0));
        game1.playMove(new Move(1, 'X', 1, 1));


        ////// Start the game

        ////// Declare the result
    }
}

package lld.chess;

import lld.chess.constants.GameType;
import lld.chess.game.ChessGame;
import lld.chess.model.MatchModel;
import lld.chess.model.Move;
import lld.chess.model.PlayerModel;

public class ChessDriver {

    public static void main(String[] args) {

        PlayerModel playerModel1 = new PlayerModel("abc1", "shahidbits", "Shahid");
        PlayerModel playerModel2 = new PlayerModel("xyz2", "ajay_bond007", "Ajay");

        MatchModel matchModel = new MatchModel(GameType.BLITZ, 600);

        ChessGame chessGame1 = new ChessGame(playerModel1, playerModel2, matchModel);
        chessGame1.init();

        // Game starts
        chessGame1.play(new Move(1, 101, 3, 4));
        chessGame1.play(new Move(2, 204, 2, 3));

    }
}

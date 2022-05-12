package lld.chess.game;

import lld.chess.board.IBoard;
import lld.chess.board.impl.Board;
import lld.chess.constants.GameStatus;
import lld.chess.manager.IBoardManager;
import lld.chess.manager.impl.BoardManager;
import lld.chess.model.MatchModel;
import lld.chess.model.Move;
import lld.chess.model.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {

    private IBoard board;
    private IBoardManager boardManager;

    private PlayerModel[] players;

    private MatchModel matchModel;

    private List<Move> moves;

    private GameStatus gameStatus;

    public ChessGame(PlayerModel playerOne, PlayerModel playerTwo, MatchModel matchModel) {

        // Players
        this.players = new PlayerModel[2];
        this.players[0] = playerOne;
        this.players[1] = playerTwo;

        // Match details
        this.matchModel = matchModel;

        // Board setup
        this.board = new Board();
        this.moves = new ArrayList<>();
        this.boardManager = new BoardManager(this.board);

        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void init() {
        this.boardManager.initBoard();
    }

    public void play(Move m) {

        boolean isMoveSuccessful = this.boardManager.updatePosition(m);

        System.out.println(String.format("Player %s moves %s to (%s,%s) : suc = %s",
                m.getPlayerId(), m.getPieceId(), m.getX(), m.getY(), isMoveSuccessful ? "T" : "F"));

        if (isMoveSuccessful) {

            // checkmate or stalemate -> this.gameStatus = GameStatus.OVER;

            // king check ->

            // stop timer for player, and start for other player ->
        }


    }

}

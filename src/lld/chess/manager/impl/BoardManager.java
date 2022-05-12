package lld.chess.manager.impl;

import lld.chess.board.IBoard;
import lld.chess.manager.IBoardManager;
import lld.chess.model.Move;
import lld.chess.piece.Piece;
import lld.chess.piece.impl.PawnPiece;

public class BoardManager implements IBoardManager {

    private IBoard board;

    public BoardManager(IBoard board) {
        this.board = board;
    }

    @Override
    public void initBoard() {

        initBoard(1);
        initBoard(2);
    }

    @Override
    public boolean updatePosition(Move m) {
        return false;
    }

    @Override
    public boolean isValidMove(Move m) {
        return false;
    }

    private void initBoard(int playerId) {

        // Pawns
        for (int i = 0; i < 8; i++) {

            int id = (playerId * 100) + i + 1; // 101, 102, 103, 104, ... , 108

            Piece pawn = new PawnPiece(this, playerId == 1 ? 1 : 6, i, playerId);

            if (playerId == 1) {
                board.getPlayerOne().add(pawn);
            } else {
                board.getPlayerTwo().add(pawn);
            }
        }

        // knights

        // rooks

        // bishops

        // queens

        // kings
    }
}

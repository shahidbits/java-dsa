package lld.chess.piece.impl;

import lld.chess.manager.IBoardManager;
import lld.chess.model.Cell;
import lld.chess.model.Move;
import lld.chess.piece.Piece;

import java.util.List;

public class PawnPiece extends Piece {

    public PawnPiece(IBoardManager boardManager, int x, int y, int playerId) {
        super(boardManager, x, y, playerId);
    }

    @Override
    public boolean move(Move move) {

        // 1. add the validations for player move.
        // 2. call board manager's move() method.

        return false;
    }

    @Override
    public boolean validateMove(Move move) {
        return false;
    }

    @Override
    public List<Cell> possibleMoves() {
        return null;
    }
}

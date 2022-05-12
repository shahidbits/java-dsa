package lld.chess.board.impl;

import lld.chess.board.IBoard;

import java.util.ArrayList;

public class Board extends IBoard {

    private static final String PLAYER_COLOR_WHITE = "White";
    private static final String PLAYER_COLOR_BLACK = "Black";

    public Board() {

        playerOne = new ArrayList<>();
        playerTwo = new ArrayList<>();

    }

    @Override
    public void createGame() {
//        initPlayerPiece(1);
//        initPlayerPiece(2);
    }

    @Override
    public void display() {

        // display the board along with the pieces for player 1 and 2

    }

    @Override
    public void startGame() {

        // start the timer

    }

    @Override
    public void resetGame() {

        // display the result

    }
}

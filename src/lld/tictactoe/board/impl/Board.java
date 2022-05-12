package lld.tictactoe.board.impl;

import lld.tictactoe.board.IBoard;
import lld.tictactoe.model.Cell;
import lld.tictactoe.model.Move;

public class Board implements IBoard {

    private Cell[][] cells;

    private int size;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];

        resetBoard();
    }

    @Override
    public void resetBoard() {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell('-', i, j);
            }
        }
    }

    @Override
    public void displayBoard() {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].getCh() + " ");
            }
            System.out.println(" ");
        }
    }

    @Override
    public boolean updateBoard(Move move) {

        // boundary check
        if (move.getPosX() < 0 || move.getPosX() >= this.getSize() ||
                move.getPosY() < 0 || move.getPosY() >= this.getSize()) {
            return false;
        }

        // availability check
        if (!this.isCellAvailable(move.getPosX(), move.getPosY())) {
            return false;
        }

        this.cells[move.getPosX()][move.getPosY()].setCh(move.getLabel());
        return true;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isCellAvailable(int x, int y) {
        return this.cells[x][y].getCh() == '-';
    }
}

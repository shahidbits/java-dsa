package lld.tictactoe.model;

public class Cell {

    private char ch;
    private int posX;
    private int posY;

    public Cell(char ch, int posX, int posY) {
        this.ch = ch;
        this.posX = posX;
        this.posY = posY;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}


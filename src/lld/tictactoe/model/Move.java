package lld.tictactoe.model;

public class Move {

    private int playerId;
    private char label;
    private int posX;
    private int posY;

    public Move(int playerId, char label, int posX, int posY) {
        this.playerId = playerId;
        this.label = label;
        this.posX = posX;
        this.posY = posY;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
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

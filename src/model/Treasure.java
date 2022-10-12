package model;

public class Treasure{
    private String nameTreasure;
    private String urlTreasure;
    private int scoreTreasure;
    private int positionXTreasure;
    private int positionYTreasure;

    public Treasure(String nameTreasure, String urlTreasure, int scoreTreasure){
        this.nameTreasure= nameTreasure;
        this.urlTreasure= urlTreasure;
        this.scoreTreasure= scoreTreasure;
        positionXTreasure=generateRandomPosisitonX();
        positionYTreasure=generateRandomPosisitonY();
    }
    
    public String getNameTreasure() {
        return nameTreasure;
    }
    
    public int getPositionXTreasure() {
        return positionXTreasure;
    }

    public int getPositionYTreasure() {
        return positionYTreasure;
    }

    public void setPositionXTreasure(int positionXTreasure) {
        this.positionXTreasure = positionXTreasure;
    }

    public void setPositionYTreasure(int positionYTreasure) {
        this.positionYTreasure = positionYTreasure;
    }
}

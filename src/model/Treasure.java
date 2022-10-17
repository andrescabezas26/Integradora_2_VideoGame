package model;
import java.lang.Math;

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

    public int getScoreTreasure() {
        return scoreTreasure;
    }

    public void setPositionXTreasure(int positionXTreasure) {
        this.positionXTreasure = positionXTreasure;
    }

    public void setPositionYTreasure(int positionYTreasure) {
        this.positionYTreasure = positionYTreasure;
    }
    /**generateRandomPosition= This method generates a random position from 0 to 1280
     * @return positionx: int = The posisition x on the level 
     */
    public int generateRandomPosisitonX(){
        int positionX=(int)(Math.random()*1280);
        return positionX;
    }
    /**generateRandomPosition= This method generates a random position from 0 to 720
     * @return positiony: int = The posisition y on the level 
     */
    public int generateRandomPosisitonY(){
        int positionY=(int)(Math.random()*720);
        return positionY;
    }

    public String toString(){
		return 
			"Nombre: " + this.nameTreasure ; 
	}
}

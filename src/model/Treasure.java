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

    public int generateRandomPosisitonX(){
        int positionX=(int)(Math.random()*1280+1);
        return positionX;
    }

    public int generateRandomPosisitonY(){
        int positionY=(int)(Math.random()*720+1);
        return positionY;
    }

    public String toString(){
		return 
			"Informacion del Tesoro: \n" + 
			"Nombre: " + this.nameTreasure + "\n" +
			"Posicion X: " + this.positionXTreasure + "\n" +
			"Posicion Y: " + this.positionYTreasure + "\n"; 
	}
}

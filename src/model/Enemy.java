package model;
import java.lang.Math;

public class Enemy {
    
    private String nameEnemy;
    private TypeEnemy typeEnemy;
    private int damageEnemy;
    private int scoreEnemy;
    private int positionXEnemy;
    private int positionYEnemy;

    public Enemy(String nameEnemy, int damageEnemy, int scoreEnemy, int optionEnemy){
        this.nameEnemy= nameEnemy;
        this.damageEnemy= damageEnemy;
        this.scoreEnemy=scoreEnemy;
        positionXEnemy=generateRandomPosisitonX();
        positionYEnemy=generateRandomPosisitonY();
        this.typeEnemy= TypeEnemy.values()[optionEnemy];
        
    }

    public void setDamageEnemy(int damageEnemy) {
        this.damageEnemy = damageEnemy;
    }

    public void setNameEnemy(String nameEnemy) {
        this.nameEnemy = nameEnemy;
    }

    public void setScoreEnemy(int scoreEnemy) {
        this.scoreEnemy = scoreEnemy;
    }

    public String getNameEnemy() {
        return nameEnemy;
    }

    public TypeEnemy getTypeEnemy() {
        return typeEnemy;
    }

    public int getPositionXEnemy() {
        return positionXEnemy;
    }

    public int getPositionYEnemy() {
        return positionYEnemy;
    }

    public void setPositionXEnemy(int positionXEnemy) {
        this.positionXEnemy = positionXEnemy;
    }

    public void setPositionYEnemy(int positionYEnemy) {
        this.positionYEnemy = positionYEnemy;
    }

    public int getScoreEnemy() {
        return scoreEnemy;
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
            "Nombre: " + this.nameEnemy + " Tipo: " + this.typeEnemy;
    }

}

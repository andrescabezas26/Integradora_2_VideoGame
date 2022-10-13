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
        this.scoreEnemy=damageEnemy;
        positionXEnemy=generateRandomPosisitonX();
        positionYEnemy=generateRandomPosisitonY();
        this.typeEnemy= TypeEnemy.values()[optionEnemy];
    }

    public TypeEnemy setTypeEnemy(int typeEnemy ){
        if(typeEnemy==1){
            this.typeEnemy=TypeEnemy.OGRO;
        }else if(typeEnemy==2){
            this.typeEnemy=TypeEnemy.ABSTRACTO;
        }else if(typeEnemy==3){
            this.typeEnemy=TypeEnemy.MAGICO;
        }else if(typeEnemy==4){
            this.typeEnemy=TypeEnemy.JEFE;
        }

        return this.typeEnemy;
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

    public String getTypeEnemy() {
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

    public int generateRandomPosisitonX(){
        int positionX=(int)(Math.random()*1280+1);
        return positionX;
    }

    public int generateRandomPosisitonY(){
        int positionY=(int)(Math.random()*720+1);
        return positionY;
    }

}

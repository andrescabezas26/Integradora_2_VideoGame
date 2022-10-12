package model;

public class Enemy {
    
    private String nameEnemy;
    private String typeEnemy;
    private int damageEnemy;
    private int scoreEnemy;
    private int positionXEnemy;
    private int positionYEnemy;

    public Enemy(String nameEnemy, int damageEnemy, int scoreEnemy, int typeEnemy){
        this.nameEnemy= nameEnemy;
        this.damageEnemy= damageEnemy;
        this.scoreEnemy=damageEnemy;
        positionXEnemy=generateRandomPosisitonX();
        positionYEnemy=generateRandomPosisitonY();
        this.typeEnemy= setTypeEnemy(typeEnemy);
    }

    public String setTypeEnemy(int typeEnemy ){
        if(typeEnemy==1){
            this.typeEnemy=TypeEnemy.OGRO;
        }else if(typeEnemy==2){
            this.typeEnemy=TypeEnemy.ABSTRACTO;
        }else if(typeEnemy==3){
            this.typeEnemy=TypeEnemy.MAGICO;
        }else if(typeEnemy==4){
            this.typeEnemy=TypeEnemy.JEFE;
        }
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

}

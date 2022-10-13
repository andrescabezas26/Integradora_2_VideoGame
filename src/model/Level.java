package model;

import javax.swing.text.Position;

public class Level {
    public static final int SIZE_OF_PLAYERS=30;
    public static final int SIZE_OF_TREASURES=60;
    public static final int SIZE_OF_ENEMIES=35;

    private int idNumberLevel;
    private int scoreRequired;
    private Difficult difficult;
    private Treasure treasures[];
    private Enemy enemies[];
    private Player players[];

    public Level(int idNumberLevel, int scoreRequired){
        this.idNumberLevel=idNumberLevel;
        this.scoreRequired=scoreRequired;
        difficult=calculateDifficult();
        treasures= new Treasure[SIZE_OF_TREASURES];
        enemies= new Enemy[SIZE_OF_ENEMIES];
        players=new Player[SIZE_OF_PLAYERS];
    }

    public int getIdNumberLevel() {
        return idNumberLevel;
    }

    public int getScoreRequired() {
        return scoreRequired;
    }

    public Difficult getDifficult() {
        return difficult;
    }

    public void setDifficult(Difficult difficult) {
        this.difficult = difficult;
    }

    public void setIdNumberLevel(int idNumberLevel) {
        this.idNumberLevel = idNumberLevel;
    }

    public void setScoreRequired(int scoreRequired) {
        this.scoreRequired = scoreRequired;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void addPersonWithObject(Player player){
		boolean isEmpty = false; 
		for(int i = 0; i <SIZE_OF_PLAYERS && !isEmpty; i++){
			if(players[i] == null){
				players[i] = player; 
				isEmpty = true; 
			}
		}
	}

    public boolean searchRepeatPosition(int positionX, int positionY){
        boolean isRepeated=false;
        for(int i=0;i<100 && !isRepeated;i++){
           int positionXEnemy = getEnemies()[i].getPositionXEnemy();
           int positionYEnemy = getEnemies()[i].getPositionYEnemy();
           int positionXTreasure = getTreasures()[i].getPositionXTreasure();
           int positionYTreasure = getTreasures()[i].getPositionYTreasure();
           if(positionX==positionXEnemy && positionY==positionYEnemy){
            isRepeated=true;
           }else if(positionX==positionXTreasure && positionY==positionYTreasure){
            isRepeated=true;
           }
        }
        return isRepeated;
    }

    public int hasEmptyPos(){
        int pos=-1;
        boolean isEmpty=false;
        for(int i=0;i<SIZE_OF_PLAYERS && !isEmpty;i++){
            if(players[i]==null){
                pos=i;
                isEmpty=true;
            }
        }
        return pos;
    }

    public Difficult calculateDifficult(){
        int scoreTreasures;
        int scoreEnemies;
        
        for(int i=0;i<SIZE_OF_TREASURES;+i++){
            scoreTreasures+=getTreasures()[i].getScoreTreasure();
        }
        
        for(int i=0;i<SIZE_OF_ENEMIES;i++){
            scoreEnemies+=getEnemies()[i].getScoreEnemy();
        }
        
        if(scoreTreasures>scoreEnemies){
            difficult=Difficult.BAJO;
        }else if(scoreTreasures==scoreEnemies){
            difficult=Difficult.MEDIO;
        }else if(scoreTreasures<scoreEnemies){
            difficult=Difficult.ALTO;
        }

        return difficult;
    }
}

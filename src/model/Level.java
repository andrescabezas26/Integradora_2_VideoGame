package model;



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
    private int scoreTreasures;
    private int scoreEnemies;

    public Level(int idNumberLevel, int scoreRequired){
        treasures= new Treasure[SIZE_OF_TREASURES];
        enemies= new Enemy[SIZE_OF_ENEMIES];
        players=new Player[SIZE_OF_PLAYERS];
        this.idNumberLevel=idNumberLevel;
        this.scoreRequired=scoreRequired;
        this.difficult=calculateDifficult();
        this.scoreTreasures=0;
        this.scoreEnemies=0;
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

    public void setScoreEnemies(int scoreEnemies) {
        this.scoreEnemies = scoreEnemies;
    }

    public void setScoreTreasures(int scoreTreasures) {
        this.scoreTreasures = scoreTreasures;
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

    public void addTreasureWithObject(Treasure treasure, int quantityOfTreasure){
        int treasuresAdded=0;
        for(int i=0;i<SIZE_OF_TREASURES && treasuresAdded<quantityOfTreasure;i++){
            if(treasures[i]==null){
                treasures[i]=treasure;
                treasuresAdded++;
            }
        }
    }

    public void addEnemyWithObject(Enemy enemy){
        boolean isAdded=false;
        for(int i=0;i<SIZE_OF_ENEMIES && !isAdded;i++){
            if(enemies[i]==null){
                enemies[i]=enemy;
                isAdded=true;
            }
        }
    }

    public void deletePerson(String nickName){
		int pos = searchPlayerByNickName(nickName); 
		if(pos != -1){
			players[pos] = null; 
		}
	} 
    

    public int searchEnemyByName(String enemyName){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_OF_ENEMIES && !isFound; i++){
			if(enemies[i]!=null){
				if(enemies[i].getNameEnemy().equals(enemyName)){
					pos = i; 
					isFound = true; 
				}
			}
		}

		return pos; 
	}

    public int searchPlayerByNickName(String playerNickName){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_OF_PLAYERS && !isFound; i++){
			if(players[i]!=null){
				if(players[i].getNickName().equals(playerNickName)){
					pos = i; 
					isFound = true; 
				}
			}
		}
		return pos; 
	}

    public int searchTreasureByName(String nameTreasure){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_OF_TREASURES && !isFound; i++){
			if(treasures[i]!=null){
				if(treasures[i].getNameTreasure().equals(nameTreasure)){
					pos = i; 
					isFound = true; 
				}
			}
		}
		return pos; 
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

    public int hasEmptyPosPlayer(){
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

    public int hasEmptyPosTreasure(){
        int freeSpaces=0;
        for(int i=0;i<SIZE_OF_TREASURES;i++){
            if(treasures[i]==null){
                freeSpaces++;
            }
        }
        return freeSpaces;
    }

    public int hasEmptyPosEnemy(){
        int pos=-1;
        boolean isEmpty=false;
        for(int i=0;i<SIZE_OF_ENEMIES && !isEmpty;i++){
            if(enemies[i]==null){
                pos=i;
                isEmpty=true;
            }
        }
        return pos;
    }

    public int countTreasures(String nameTreasure){
        int count=0;
        for(int i=0;i<SIZE_OF_TREASURES;i++){
            if(treasures[i]!=null){
                if(treasures[i].getNameTreasure().equals(nameTreasure)){
                    count++;
                }

            }
        }
        return count;
    }

    public String listEnemiesAndTreasures(){
        String msj="";
        for(int i=0;i<SIZE_OF_TREASURES;i++){
            if(treasures[i]!=null){
                msj += treasures[i].toString() + " , ";
            }
        }

        for(int i=0;i<SIZE_OF_ENEMIES;i++){
            if(enemies[i]!=null){
                if(i< (SIZE_OF_ENEMIES-1)){
                    msj += enemies[i].toString() + " , ";
                }else{
                    msj += enemies[i].toString();
                }
            }
        }
        return msj;
    }

    public Difficult calculateDifficult(){
        int scoreT=0;
        int scoreE=0;
        for(int i=0;i<SIZE_OF_TREASURES;i++){
            if(treasures[i]!=null){
                scoreT+=treasures[i].getScoreTreasure();
            }else{
                scoreT+=0;
            }
            setScoreTreasures(scoreT);
        }
        for(int i=0;i<SIZE_OF_ENEMIES;i++){
            if(enemies[i]!=null){
                scoreE+=enemies[i].getScoreEnemy();
            }else{
                scoreE+=0;
            }
            setScoreEnemies(scoreE);
        }
        
        if(this.scoreTreasures>this.scoreEnemies){
            difficult=Difficult.BAJO;
        }else if(this.scoreTreasures==this.scoreEnemies){
            difficult=Difficult.MEDIO;
        }else if(this.scoreTreasures<this.scoreEnemies){
            difficult=Difficult.ALTO;
        }

        return difficult;
    }

    public String listPlayers(){
        String msj=""+scoreRequired;
        for(int i=0;i<SIZE_OF_PLAYERS;i++){
            if(players[i]!=null){
                msj += players[i].toString() + " , " ;
            }
        }
        return msj;
    }
}

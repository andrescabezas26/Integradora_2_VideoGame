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
    /**addPersonWithObject= Add a player object to the level
     * @param player: Player = The player that will be added to the game
     */
    public void addPersonWithObject(Player player){
		boolean isEmpty = false; 
		for(int i = 0; i <SIZE_OF_PLAYERS && !isEmpty; i++){
			if(players[i] == null){
				players[i] = player; 
				isEmpty = true; 
			}
		}
	}
    /**addTreasureWithObject= Add a treasure object to the level depending on the quantity that the user input
     * @param treasure: Treasure = The treasure that will be added to the level
     * @param quantityOfTreasure: int = The quantity of treasures that will be added to the level
     */
    public void addTreasureWithObject(Treasure treasure, int quantityOfTreasure){
        int treasuresAdded=0;
        for(int i=0;i<SIZE_OF_TREASURES && treasuresAdded<quantityOfTreasure;i++){
            if(treasures[i]==null){
                treasures[i]=treasure;
                treasuresAdded++;
            }
        }
    }
    /**addEnemyWithObject=Add a enemy object to the level
     * @param enemy: Enemy = The enmy that will be added to the level
     */
    public void addEnemyWithObject(Enemy enemy){
        boolean isAdded=false;
        for(int i=0;i<SIZE_OF_ENEMIES && !isAdded;i++){
            if(enemies[i]==null){
                enemies[i]=enemy;
                isAdded=true;
            }
        }
    }
    /**deletePerson= Delete a player of the level by his nickName
     * @param nickName: String = The nickName of the player that will be deleted
     */
    public void deletePerson(String nickName){
		int pos = searchPlayerByNickName(nickName); 
		if(pos != -1){
			players[pos] = null; 
		}
	} 
    /**searchEnemyByName= Searchs a enemy in the level by his name
     * @param enemyName: String = The name of the enemy to search
     * @return pos: int = The position of the Enemy in the level or -1 if wasn´t found
     */
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
    /**searchPlayerByNickName= Searchs a player in the level by his nickName
     * @param playerNickName: String = The nickName of the player to search
     * @return pos: int = The position of the Player in the level or -1 if wasn´t found
     */
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
    /**searchTreasureByName= Searchs a treasure by his name in the level
     * @param nameTreasure: String = The name of the treasure to search
     * @return pos: int = The position of the treasure in the level or -1 if wasn´t found
     */
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
    /**hasEmptyPosPlayer=This method search an empty position in the array of players of the level
     * @return pos: int = The position empty of players in the level or -1 if was full
     */
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
    /**hasEmptyPosTreasure=This method search an empty position in the array of treasures of the level
     * @return pos: int=The position empty of treasures in the level or -1 if was full
     */
    public int hasEmptyPosTreasure(){
        int freeSpaces=0;
        for(int i=0;i<SIZE_OF_TREASURES;i++){
            if(treasures[i]==null){
                freeSpaces++;
            }
        }
        return freeSpaces;
    }
    /**hasEmptyPosEnemy=This method search an empty position in the array of enemies of the level
     * @return pos: int=The position empty of enemies in the level or -1 if was full
     */
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
    /**countTreasures= This method count an specific treasure in the level and his return is only the quantity
     * @param nameTreasure: String = The name of the treasure to count 
     * @return count = The quantity of treasures counted in the game
     */
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
    /**listEnemiesAndTreasures=This method shows a list of the enemies and treasures of the game separed by ","
     * @return msj: String = The lis of enemies and treasures of the level
     */
    public String listEnemiesAndTreasures(){
        String msj="";
        for(int i=0;i<SIZE_OF_TREASURES;i++){
            if(treasures[i]!=null){
                if(i<SIZE_OF_TREASURES-1){
                    if(treasures[i+1]==null){
                        msj += treasures[i].toString();
                    }else{
                        msj += treasures[i].toString() + " , " ;
                    }
                }else{
                    msj += treasures[i].toString() + " , ";
                }
            }
        }

        for(int i=0;i<SIZE_OF_ENEMIES;i++){
            if(enemies[i]!=null){
                if(i==SIZE_OF_ENEMIES-1){
                    msj += enemies[i].toString() + " , ";
                }else{
                    if(enemies[i+1]==null){
                        msj += enemies[i].toString();
                    }else if(i<SIZE_OF_ENEMIES){
                        msj += enemies[i].toString() + " , ";
                    }
                }
            }
        }
        return msj;
    }
    /**calculateDifficult= This method calculates the difficult of the level
     * @return difficult: Difficult = The difficult calculated by the score of enemies and treasures of the game
     */
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
}
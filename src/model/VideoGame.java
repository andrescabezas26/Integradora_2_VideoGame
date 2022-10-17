package model;
import java.lang.Math;

public class VideoGame{
    public static final int SIZE_OF_LEVELS= 10;
    public static final int SIZE_OF_PLAYERS_IN_LEVEL=30;
    public static final int SIZE_OF_TREASURES_IN_LEVEL=60;
    public static final int SIZE_OF_ENEMIES_IN_LEVEL=35;

    private Level[] levels;
    private String msj;
    
    public VideoGame(){
        levels= new Level[SIZE_OF_LEVELS];
        for(int i=1;i<SIZE_OF_LEVELS+1;i++){
            int score=(i*100);
            levels[i-1]= new Level(i, score);
        }
        intiGame();
    }

    public Level[] getLevels() {
        return levels;
    }
    /**intiGame=Initializate 10 levels, 20 players, 25 enemies and 50 treasures
     */
    public void intiGame(){
        for(int i=0; i<20; i++){
            addPlayer("Jugador"+ (i+1),"Pedro "+(i+1));
        }

        for(int i=0; i<25; i++){
            int damageEnemy=(int)(Math.random()*200);
            int scoreEnemy=(int)(Math.random()*30);
            int option=(int)(Math.random()*4);
            addEnemy("Enemigo" + (i+1), damageEnemy, scoreEnemy, option, 1);
        }

        for(int i=0; i<50;i++){
            int scoreTreasure=(int)(Math.random()*30);
            addTreasure("Tesoro" + (i+1), "url", scoreTreasure, 1, 1);
        }
    }
    /**addPlayer= Add a player to level 1
     * @param nickName: String = The nickname of the player
     * @param name: String = The name of the player
     * @return msj: String = A message that confirms if the player was added
     */
    public String addPlayer(String nickName, String name){
        msj="Capacidad Maxima Alcanzada";
        int nickNameRepeated= searchPlayerByNickName(nickName);
        boolean isEmpty= false;
        Player newPlayer= new Player(nickName, name);
        int levelIsEmpty=levels[0].hasEmptyPosPlayer();
        if(nickNameRepeated==-1 && levelIsEmpty!=-1){
            for(int i=0;i<SIZE_OF_PLAYERS_IN_LEVEL && !isEmpty;i++){
                if(levels[0].getPlayers()[i]==null){
                    isEmpty= true;
                    levels[0].addPersonWithObject(newPlayer);
                    msj="Jugador agregado correctamente al juego";
                }     
            }
        }else if(nickNameRepeated!=-1){
            msj="El nickname está repetido";
        }else if(levelIsEmpty==-1){
            msj="El nivel 1 esta lleno";
        }
		return msj;
    }
    /**addTreasure= Add a treasure to a level 
     * @param nameTreasure: String = Name of the treasure
     * @param url: String = The url of the treasure
     * @param scoreTreasure: int= The score that the treasure give
     * @param level: int= The level to add the treasure
     * @param quantityOfTreasure: int = The quantity of treasures to add to the level
     * @return msj: String = A mmessagge that confirms if the treasures were added
     */
    public String addTreasure(String nameTreasure, String url, int scoreTreasure, int level, int quantityOfTreasure){
        msj="Los tesoros exceden la capacidad maxima del nivel";
        level--;
        int freeSpaces= levels[level].hasEmptyPosTreasure();
        if(freeSpaces>=quantityOfTreasure){
            Treasure newTreasure= new Treasure(nameTreasure, url, scoreTreasure);
            int treasuresAdded=0;
            for(int i=0;i<SIZE_OF_TREASURES_IN_LEVEL && treasuresAdded<quantityOfTreasure;i++){
                if(levels[level].getTreasures()[i]==null){
                    levels[level].calculateDifficult();
                    levels[level].addTreasureWithObject(newTreasure, quantityOfTreasure);
                    treasuresAdded=quantityOfTreasure;
                    msj="Tesoro añadido correctamente al nivel: "+ (level+1);
                }
            }
        }
        return msj;
    }
    /**addEnemy= Add a enemy to a level with his info
     * @param nameEnemy: String = The name of the enemy
     * @param damageEnemy: int=The damage of the enemy
     * @param scoreEnemy: int = The score that the enemy gives
     * @param optionEnemy int= The type of enemy selected by the user
     * @param level: int = The level to add the enemy
     * @return msj: String = A message that confirms if the enmy was added to the level
     */
    public String addEnemy(String nameEnemy, int damageEnemy, int scoreEnemy, int optionEnemy ,int level){
        msj="Capacidad Maxima de enemigos alcanzada";
        level--;
        boolean isAdded=false;
        if(levels[level].hasEmptyPosEnemy()!=-1 && levels[level].searchEnemyByName(nameEnemy)==-1){
            Enemy newEnemy= new Enemy(nameEnemy, damageEnemy, scoreEnemy, optionEnemy);
            for(int i=0;i<SIZE_OF_ENEMIES_IN_LEVEL && !isAdded;i++){
                if(levels[level].getEnemies()[i]==null){
                    isAdded=true;
                    levels[level].addEnemyWithObject(newEnemy);
                    levels[level].calculateDifficult();
                    msj="Enemigo añadido correctamente en el nivel: "+ (level+1);
                }
            }
        }else if(levels[level].searchEnemyByName(nameEnemy)!=-1){
            msj="El enemigo ya se encuentra en el nivel";
        }
        return msj;
    }
    /**modifyPlayerScore= Modify the score of a player
     * @param nickName: String = The nickName of the player to mofidy his score
     * @param scorePlayer: int = The new score of the player 
     * @return msj: String= A message taht confirms if the score of the player was modified
     */
    public String modifyPlayerScore(String nickName, int scorePlayer){
        msj="No se encontró al jugador";
        boolean isFound= false;
        if(searchPlayerByNickName(nickName)!=-1){
            int posLevel;
            int posPlayer;
            for(int i=0;i<SIZE_OF_LEVELS && !isFound;i++){
                posPlayer=levels[i].searchPlayerByNickName(nickName);
                if(posPlayer!=-1){
                    isFound=true;
                    posLevel=i;
                    levels[posLevel].getPlayers()[posPlayer].setScorePlayer(scorePlayer);
                    msj="Puntaje del juagador modificado correctamente a " + scorePlayer;
                };
            }
        }
        return msj;
    }
    /**increasePlayerLevel= Increase a player to a level that the user input
     * @param nickName: String= The nickName of the player to increase of level
     * @param level: int = The level to change the player
     * @return msj: String = A message that confirms if the player increased of level or how many points left to level up
     */
    public String increasePlayerLevel(String nickName, int level){
        msj="No se encontro al jugador";
        level=level-2;
        int newPosPlayer=levels[level+1].hasEmptyPosPlayer();
        if(newPosPlayer!=-1){
            int posLevel=searchPlayerByNickName(nickName);
            if(posLevel!=-1){
                String namePlayer="";
                int actualPosPlayer=levels[posLevel].searchPlayerByNickName(nickName);
                if(levels[posLevel].getPlayers()[actualPosPlayer].getScorePlayer()>=levels[level].getScoreRequired()){
                    namePlayer=levels[posLevel].getPlayers()[actualPosPlayer].getName();
                    int scorePlayer=levels[posLevel].getPlayers()[actualPosPlayer].getScorePlayer();
                    levels[level+1].addPersonWithObject(new Player(nickName, namePlayer));
                    levels[posLevel].deletePerson(nickName);
                    levels[level+1].getPlayers()[newPosPlayer].setScorePlayer(scorePlayer);
                    msj="Jugador incrementado al nivel " + (level+2);
                }else{
                    msj="El jugador necesita " + (levels[level].getScoreRequired()-levels[posLevel].getPlayers()[actualPosPlayer].getScorePlayer())+ " puntos para pasar al nivel " + (level+2);
                }
            }
        }else{
            msj="No hay espacio para el jugador en el nivel " + (level+2);
        }
        return msj;
    }
    /**countAtreasure= This method count how many of an specific treasure are in the game
     * @param nameTreasure: String = The name of the treasure to count
     * @return msj: String = A message that shows how many treasures are or if the treasure doesn´t exist
     */
    public String countATreasure(String nameTreasure){
        msj="EL tesoro no fue encontrado";
        int count=0;
        if(searchTreasureByName(nameTreasure)!=-1){
            for(int i=0;i<SIZE_OF_LEVELS;i++){
                for(int j=0;j<SIZE_OF_TREASURES_IN_LEVEL;j++){
                    if(levels[i].getTreasures()[j]!=null){
                        if(levels[i].getTreasures()[j].getNameTreasure().equals(nameTreasure)){
                            count++;
                        }
                    }
                }
            }
            msj=nameTreasure + " fue encontrado " + count + " veces";
        }
        return msj;
    }
    /**countATypeEnemy= This method count how many enemies have an specific type of enemy in the game
     * @param optionEnemy: int= The type of enemy selected by the user
     * @return msj: String= A message that shows how many enemies have an specific type of enemy
     */
    public String countATypeEnemy(int optionEnemy){
        msj="Ningun tipo de enemigo no fue encontrado";
        int count=0;
        TypeEnemy typeEnemy= TypeEnemy.values()[optionEnemy];
        for(int i=0;i<SIZE_OF_LEVELS;i++){
            for(int j=0;j <SIZE_OF_ENEMIES_IN_LEVEL;j++){
                if(levels[i].getEnemies()[j]!=null){
                    if(levels[i].getEnemies()[j].getTypeEnemy().equals(typeEnemy)){
                    count++;
                    }
                }
            }
            
        }
        msj= typeEnemy + " fue encontrado " + count + " veces";
        return msj;
    }
    /**countTreasures= This method count an specific treasures too, but his return is only the quantity
     * @param nameTreasure: String = The name of the treasure to count 
     * @return count = The quantity of treasures counted in the game
     */
    public int countTreasures(String nameTreasure){
        int count=0;
        for(int i=0;i<SIZE_OF_LEVELS;i++){
            for(int j=0;j<SIZE_OF_TREASURES_IN_LEVEL;j++){
                if(levels[i].getTreasures()[j]!=null){
                    if(levels[i].getTreasures()[j].getNameTreasure().equals(nameTreasure)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    /** showMostRepeatedTreasure= This method searchs and shows the most repeated treasure in the game
     * @return msj: String= A message that shows the most repeated treasure of the game
     */
    public String showMostRepeatedTreasure(){
        for(int i=0;i<SIZE_OF_LEVELS;i++){
            for(int j=0;j<SIZE_OF_TREASURES_IN_LEVEL;j++){    
                int max=0;
                if(levels[i].getTreasures()[j]!=null){
                    int counted= countTreasures(levels[i].getTreasures()[j].getNameTreasure());
                    if(counted>max){
                        max=counted;
                        msj="El tesoro más repetido es: " + levels[i].getTreasures()[j].toString() + " con "+ counted + " unidades"; 
                    }
                }
            }
        }
        return msj;
    }
    /**showHigerScoreEnemy=This method shows the Enemy with the highest score and shows where it is
     * @return msj: String = A message that shows the Enemy with the highest score and shows where it is
     */
    public String showHigerScoreEnemy(){
        msj="";
        for(int i=0;i<SIZE_OF_LEVELS;i++){
            int max=0;
            for(int j=0;j<SIZE_OF_ENEMIES_IN_LEVEL;j++){
                if(levels[i].getEnemies()[j]!=null){
                    int score=levels[i].getEnemies()[j].getScoreEnemy();
                    if(score>max){
                        max=score;
                        msj="El enemigo con mayor puntaje es: " + levels[i].getEnemies()[j].toString() + " y se encuentra en el nivel " + (i+1); 
                    }
                }
            }
        }
        return msj;
    }
    /**showEnemiesConsonants= This method count the consonants in the name of the enmies in the game
     * @return msj: String = A message that shows how many consonants where counted in the name of the enemies
     */
    public String showEnemiesConsonants(){
        String nameEnemy="";
        int count=0;
        char[] consonants= {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','y','z'};
        for(int i=0;i<SIZE_OF_LEVELS;i++){
            for(int j=0;j<SIZE_OF_ENEMIES_IN_LEVEL;j++){
                if(levels[i].getEnemies()[j]!=null){
                    nameEnemy=levels[i].getEnemies()[j].getNameEnemy();
                    nameEnemy=nameEnemy.toLowerCase();
                    char[] letters= nameEnemy.toCharArray();
                    for(int c=0;c<letters.length;c++){
                        for(int d=0;d<consonants.length;d++){
                            if(letters[c]==consonants[d]){
                                count++;
                            }
                        }
                    }
                }
            }
            msj="Consonantes encontradas: "+ count;
        }
        return msj;
    }
    /**showTop5Players= This method shows the 5 players with the highest score in the game
     * @return msj: String = A message that shows the 5 players with the highest score in the game
     */
    public String showTop5Players(){
        msj="";
        Player[] top5Player;
        top5Player= new Player[5];
        top5Player[0]= new Player("1","");
        top5Player[1]= new Player("2","");
        top5Player[2]= new Player("3","");
        top5Player[3]= new Player("4","");
        top5Player[4]= new Player("5","");
        for(int k=0;k<5;k++){
            for(int i=0;i<SIZE_OF_LEVELS;i++){
                for(int j=0;j<SIZE_OF_PLAYERS_IN_LEVEL;j++){
                    if(levels[i].getPlayers()[j]!=null){
                        if(k>=1){
                            if(levels[i].getPlayers()[j].getScorePlayer()>top5Player[k].getScorePlayer() && top5Player[k-1].getScorePlayer()>levels[i].getPlayers()[j].getScorePlayer()){
                                top5Player[k]=levels[i].getPlayers()[j];
                            }
                        }else{
                            if(levels[i].getPlayers()[j].getScorePlayer()>top5Player[k].getScorePlayer()){
                                top5Player[k]=levels[i].getPlayers()[j];
                            }
                        }
                    }  
                }  
            }
            msj+=top5Player[k].toString();
        }
        return msj;
    }
    /**searchPlayerByNickName= This method search a Player by his NickName
     * @param playerNickName: String = The name of the player to search;
     * @return pos: int = The position of the level where the player was found or -1 if wasn´t found
     */
    public int searchPlayerByNickName(String playerNickName){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_OF_LEVELS && !isFound; i++){
            if(levels[i].searchPlayerByNickName(playerNickName)!=-1){
                pos=i;
                isFound=true;
            }
		}
		return pos; 
	}
    /**searchTreasureByName= This method search a Treasure by his Name
     * @param nameTreasure: String = The name of the treasure to search
     * @return pos: int = The position of the treasure in the level where the treasure was found or -1 if wasn´t found
     */
    public int searchTreasureByName(String nameTreasure){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_OF_LEVELS && !isFound; i++){
			for(int j=0; j< SIZE_OF_TREASURES_IN_LEVEL;j++){
                if(levels[i].getTreasures()[j]!=null){
                    if(levels[i].getTreasures()[j].getNameTreasure().equals(nameTreasure)){
                        pos = i; 
                        isFound = true; 
                    }
                }
            }
		}
		return pos; 
	}
    /**showTypeEnemyList= Shows a list of the typeEnemy enmueration
     * @return msj: String= The list of the typeEnemy enumeration
     */
    public String showTypeEnemyList(){
        TypeEnemy typeEnemies[]= TypeEnemy.values();
        msj= "Tipo de enemigos: ";
        for(int i=0;i< typeEnemies.length;i++){
            msj += "\n" + (i+1) + " " + typeEnemies[i];
        }
        return msj;
    }
}
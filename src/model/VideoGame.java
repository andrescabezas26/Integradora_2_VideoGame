package model;
import java.lang.Math;

public class VideoGame{
    public static final int SIZE_OF_LEVELS= 10;
    public static final int SIZE_OF_PLAYERS=300;
    public static final int SIZE_OF_TREASURES=600;
    public static final int SIZE_OF_ENEMIES=350;

    private Level[] levels;
    private Player[] players;
    private Treasure[] treasures;
    private Enemy[] enemies;
    private String msj;
    
    public VideoGame(){
        levels= new Level[SIZE_OF_LEVELS];
        treasures= new Treasure[SIZE_OF_TREASURES];
        enemies= new Enemy[SIZE_OF_ENEMIES];
        players=new Player[SIZE_OF_PLAYERS];
        for(int i=1;i<SIZE_OF_LEVELS+1;i++){
            int score=i*100;
            levels[i-1]= new Level(i, score);
        }
        intiGame();
    }

    public Level[] getLevels() {
        return levels;
    }

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

    public String addPlayer(String nickName, String name){
        msj="Capacidad Maxima Alcanzada";
        int nickNameRepeated= searchPlayerByNickName(nickName);
        boolean isEmpty= false;
        Player newPlayer= new Player(nickName, name);
        int levelIsEmpty=levels[0].hasEmptyPosPlayer();
        if(nickNameRepeated==-1 && levelIsEmpty!=-1){
            for(int i=0;i<SIZE_OF_PLAYERS && !isEmpty;i++){
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

    public String addTreasure(String nameTreasure, String url, int scoreTreasure, int level, int quantityOfTreasure){
        msj="Los tesoros exceden la capacidad maxima del nivel";
        level--;
        int freeSpaces= levels[level].hasEmptyPosTreasure();
        if(freeSpaces>=quantityOfTreasure){
            Treasure newTreasure= new Treasure(nameTreasure, url, scoreTreasure);
            int treasuresAdded=0;
            for(int i=0;i<SIZE_OF_TREASURES && treasuresAdded<quantityOfTreasure;i++){
                if(treasures[i]==null){
                    treasuresAdded++;
                    treasures[i]=newTreasure;
                    levels[level].addTreasureWithObject(newTreasure, quantityOfTreasure);
                    msj="Tesoro añadido correctamente al nivel: "+ (level+1);
                }
            }
        }
        return msj;
    }

    public String addEnemy(String nameEnemy, int damageEnemy, int scoreEnemy, int optionEnemy ,int level){
        msj="Capacidad Maxima de enemigos alcanzada";
        level--;
        boolean isAdded=false;
        if(levels[level].hasEmptyPosEnemy()!=-1 && levels[level].searchEnemyByName(nameEnemy)==-1){
            Enemy newEnemy= new Enemy(nameEnemy, damageEnemy, scoreEnemy, optionEnemy);
            for(int i=0;i<SIZE_OF_ENEMIES && !isAdded;i++){
                if(levels[level].getEnemies()[i]==null){
                    isAdded=true;
                    levels[level].addEnemyWithObject(newEnemy);
                    msj="Enemigo añadido correctamente en el nivel: "+ (level+1);
                }
            }
        }else if(levels[level].searchEnemyByName(nameEnemy)!=-1){
            msj="El enemigo ya se encuentra en el nivel";
        }
        return msj;
    }

    public String modifyPlayerScore(String nickName, int scorePlayer){
        msj="No se encontró al jugador";
        boolean isFound= false;
        if(searchPlayerByNickName(nickName)!=-1){
            int posLevel;
            int posPlayer;
            for(int i=0;i<SIZE_OF_LEVELS && !isFound;i++){
                for(int j=0;j<30 && !isFound;j++){
                    if(levels[i].searchPlayerByNickName(nickName)!=-1){
                        isFound=true;
                        posLevel=i;
                        posPlayer=j;
                        levels[posLevel].getPlayers()[posPlayer].setScorePlayer(scorePlayer);
                        increasePlayerLevel(nickName);
                        msj="Puntaje del juagador modificado correctamente a " + scorePlayer;
                    };

                }
            }
        }
        return msj;
    }

    public String increasePlayerLevel(String nickName){
        msj="No se encontró al jugador";
        boolean isFound= false;
        int pos=searchPlayerByNickName(nickName);
        if(pos!=-1){
            int posLevel;
            int posPlayer;
            for(int i=0;i<SIZE_OF_LEVELS && !isFound;i++){
                for(int j=0;j<30 && !isFound;j++){
                    if(levels[i].searchPlayerByNickName(nickName)!=-1){
                        isFound=true;
                        posLevel=i;
                        posPlayer=j;
                        if(levels[posLevel].getPlayers()[posPlayer].getScorePlayer()>levels[posLevel].getScoreRequired()){
                            String namePlayer=levels[posLevel].getPlayers()[posPlayer].getName();
                            int scorePlayer=levels[posLevel].getPlayers()[posPlayer].getScorePlayer();
                            int lifes=levels[posLevel].getPlayers()[posPlayer].getLifes();
                            levels[posLevel+1].getPlayers()[levels[posLevel+1].hasEmptyPosPlayer()]= new Player(nickName, namePlayer);
                            levels[posLevel+1].getPlayers()[levels[posLevel+1].searchPlayerByNickName(nickName)].setScorePlayer(scorePlayer);
                            levels[posLevel+1].getPlayers()[levels[posLevel+1].searchPlayerByNickName(nickName)].setLifes(lifes);
                            levels[posLevel].deletePerson(nickName);
                            msj="Jugador incrementado al nivel " + posLevel+2;
                        }else{
                            msj="El jugador necesita " + (levels[posLevel].getScoreRequired()-levels[posLevel].getPlayers()[posPlayer].getScorePlayer())+ " puntos para pasar al nivel " + (posLevel+2);
                        }
                    }
                }
            }
        }
        return msj;
    }

    public String countATreasure(String nameTreasure){
        msj="EL tesoro no fue encontrado";
        int count=0;
        if(searchTreasureByName(nameTreasure)!=-1){
            for(int i=0;i<SIZE_OF_TREASURES;i++){
                if(treasures[i]!=null){
                    if(treasures[i].getNameTreasure().equals(nameTreasure)){
                        count++;
                    }
                }
            }
            msj=nameTreasure + " fue encontrado " + count + " veces";
        }
        
        return msj;
    }

    public String countATypeEnemy(int optionEnemy){
        msj="Ningun tipo de enemigo no fue encontrado";
        int count=0;
        TypeEnemy typeEnemy= TypeEnemy.values()[optionEnemy];
        for(int i=0;i<SIZE_OF_LEVELS;i++){
            for(int j=0;j <35;j++){
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

    public String showMostRepeatedTreasure(){
        for(int i=0;i<SIZE_OF_TREASURES;i++){
            int max=0;
            if(treasures[i]!=null){
                int counted= countTreasures(treasures[i].getNameTreasure());
                if(counted>max){
                    max=counted;
                    msj="El tesoro más repetido es: " + treasures[i].toString() + " con "+ counted + " unidades"; 
                }
            }
        }
        return msj;
    }

    public String showHigerScoreEnemy(){
        msj="";
        for(int i=0;i<SIZE_OF_LEVELS;i++){
            int max=0;
            for(int j=0;j<35;j++){
                if(levels[i].getEnemies()[j]!=null){
                    int score=levels[i].getEnemies()[j].getScoreEnemy();
                    if(score>max){
                        max=score;
                        msj="El enemigo con mayor puntaje es: " + levels[i].getEnemies()[j].toString() + " y se encuentra en el nivel " + i+1; 
                    }
                }
            }
        }
        return msj;
    }


    public int searchPlayerByNickName(String playerNickName){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_OF_LEVELS && !isFound; i++){
			for(int j=0; j< 30;j++){
                if(levels[i].getPlayers()[j]!=null){
                    if(levels[i].getPlayers()[j].getNickName().equals(playerNickName)){
                        pos = i; 
                        isFound = true; 
                    }
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
}

package model;
import java.lang.Math;

public class VideoGame{
    public static final int SIZE_OF_LEVELS= 10;
    public static final int SIZE_OF_PLAYERS=30;
    public static final int SIZE_OF_TREASURES=60;
    public static final int SIZE_OF_ENEMIES=35;

    private Level[] levels;
    private Player[] players;
    private Treasure[] treasures;
    private Enemy[] enemies;
    
    public VideoGame(){
        levels= new Level[SIZE_OF_LEVELS];
    }

    public void initVideoGame(){
        for(int i=0;i<SIZE_OF_LEVELS;i++){
            int score=100;
            levels[i].setIdNumberLevel(i+1);
            levels[i].setScoreRequired(score);
            levels[i].setDifficult(Difficult.BAJO);
            score+=100;
        }
        
        for(int i=0; i<20; i++){
            Player newPlayer= new Player("Jugador" + i,"Pedro" + i);
        }

        for(int i=0; i<25; i++){
            int damageEnemy=(int)(Math.random()*201);;
            int scoreEnemy=(int)(Math.random()*31);
            int option=(int)(Math.random()*5);
            Enemy newEnemy= new Enemy ("Enemigo" + i, damageEnemy, scoreEnemy,typeEnemy);
        }

        for(int i=0; i<50;i++){
            int scoreTreasure=(int)(Math.random()*31);
            Treasure newTreasure= new Treasure("Tesoro" + i, "url" ,scoreTreasure );
            
        }
    }

    public String addPlayer(String nickName, String name){
        String msj="Capacidad Maxima Alcanzada";
        int nickNameRepeated= searchPlayerByNickName(nickName);
        boolean isEmpty= false;
        Player newPlayer= new Player(nickName, name);
        int levelIsEmpty=levels[0].hasEmptyPos();
        if(nickNameRepeated!=-1 && levelIsEmpty!=-1){
            for(int i=0;i<SIZE_OF_PLAYERS && !isEmpty;i++){
                if(players[i]==null){
                    players[i] = newPlayer;
                    isEmpty= true;
                    levels[0].addPersonWithObject(newPlayer);
                    msj="Jugador agregado correctamente al juego";
                }     
            }
        }else if(nickNameRepeated==-1){
            msj="El nickname está repetido";
        }else if(levelIsEmpty==-1){
            msj="El nivel 1 esta lleno";
        }
		return msj;
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

    public String addTreasure(String nameTreasure, String url, int scoreTreasure){
        String msj="Capacidad Maxima Alcanzada";
        boolean isEmpty=false;
        for(int i=0;i<SIZE_OF_TREASURES;i++){
            if(treasures[i]!=null){
                
            }
        }
        return msj;
    }

}

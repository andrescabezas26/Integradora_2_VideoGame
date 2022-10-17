package model; 


public class Player{
	
	private String nickName; 
	private String name; 
	private int scorePlayer;
	private int lifes; 

	public Player(String nickName, String name){
		this.name = name; 
		this.nickName= nickName;
        scorePlayer= 10;
        lifes=5;
	}

    public int getScorePlayer() {
        return scorePlayer;
    }

    public String getNickName() {
        return nickName;
    }

    public String getName() {
        return name;
    }

    public int getLifes() {
        return lifes;
    }
    
    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public void setScorePlayer(int scorePlayer) {
        this.scorePlayer = scorePlayer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String toString(){
        return 
            "Informacion del jugador: \n"+
            "NickName : " + this.nickName + "\n" +
            "Puntaje : " + this.scorePlayer + "\n";
    }

}

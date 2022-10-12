package model;

public class Level {
    public static final int SIZE_OF_PLAYERS=20;
    public static final int SIZE_OF_TREASURES=50;
    public static final int SIZE_OF_ENEMIES=25;

    private int idNumberLevel;
    private int scoreRequired;
    private String difficult;
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

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
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
}

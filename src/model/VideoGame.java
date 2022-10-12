package model;

public class VideoGame{
    public static final int SIZE_OF_LEVELS= 10;

    private Level[] levels;
    
    public VideoGame(){
        levels= new level[SIZE_OF_LEVELS];
    }

    public void initLevels(){
        for(int i=0;i<SIZE_OF_LEVELS;i++){
            int score=11;
            levels[i].setIdNumberLevel(i+1);
            levels[i].setScoreRequired(score);
            levels[i].setDifficult("bajo");
            score+=10;
        }
    }
}

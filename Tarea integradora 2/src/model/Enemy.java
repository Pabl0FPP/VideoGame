package model;

public class Enemy {
    private String enemyName;
    private double scoreToRemove;
    private double scoreToGive;
    private String enemyLocation;
    private EnemyType enemiesType;
    private String nameEnemyType;

    public Enemy(String enemyName, double scoreToRemove, double scoreToGive, String enemyLocation, int enemiesType, String nameEnemyType){
        this.enemyName=enemyName;
        this.scoreToRemove=scoreToRemove;
        this.scoreToGive=scoreToGive;
        this.enemyLocation=enemyLocation;
        this.enemiesType=EnemyType.values()[enemiesType];
        this.nameEnemyType=nameEnemyType;

    }

    public String getEnemyName(){
        return enemyName;

    }

    public void setEnemyName(String enemyName){
        this.enemyName=enemyName;

    }

    public double getScoreToRemove(){
        return scoreToRemove;

    }

    public void setScoreToRemove(double scoreToRemove){
        this.scoreToRemove=scoreToRemove;

    }

    public double getScoreToGive(){
        return scoreToGive;

    }

    public void setScoreToGive(double scoreToGive){
        this.scoreToGive=scoreToGive;

    }

    public String getEnemyLocation(){
        return enemyLocation;

    }

    public void setEnemyLocation(String enemyLocation){
        this.enemyLocation=enemyLocation;

    }

    public String getNameEnemyType(){
        return nameEnemyType;

    }

    public void setNameEnemyType(String nameEnemyType){
        this.nameEnemyType=nameEnemyType;

    }


    public String toString(){
        return "\nEnemy:\n"+
        "Enemy name: "+enemyName
        +"Score that remove: "+scoreToRemove
        +"Score that Give: "+scoreToGive
        +"Enemy type: "+enemiesType;

    }
    
}

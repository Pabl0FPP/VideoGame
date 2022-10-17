package model;

public class Player{
    private String nickName;
    private String name;
    private double score;
    private int lives;

    public Player(String nickName, String name, double score, int lives){

        this.nickName=nickName;
        this.name=name;
        this.score=score;
        this.lives=lives;

    }

    public String getNickName(){
        return nickName;

    }

    public void setNickName(String nickName){
        this.nickName=nickName;

    }

    public String getname(){
        return name;

    }

    public void setname(String name){
        this.name=name;

    }

    public double getScore(){
        return score;
    }

    public void setScore(double score){
        this.score=score;

    }

    public int getLives(){
        return lives;

    }

    public void setLives(int lives){
        this.lives=lives;

    }

    public String toString (){
        return "\nPlayer\n"+
        "Nickname: "+nickName
        +"name: "+name
        +"score: "+score
        +"lives: "+lives;
    }
}
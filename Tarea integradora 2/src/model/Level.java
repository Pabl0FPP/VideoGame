package model;

public class Level {

    private int numberLevel;
    private double pointsNextLevel;
    private String difficulty;
    private Enemy[] enemies;
    private Treasure[] treasures;
    
    public Level(int numberLevel, double pointsNextLevel, String difficulty){
        this.numberLevel=numberLevel;
        this.pointsNextLevel=pointsNextLevel;
        this.difficulty=difficulty;
        this.enemies= new Enemy[25];
        this.treasures=new Treasure[50];

    }

    public int getNumberLevel(){
        return numberLevel;

    }

    public void setNumberLevel(int numberLevel){
        this.numberLevel=numberLevel;

    }

    public double getPointsNextLevel(){
        return pointsNextLevel;

    }

    public void setPointsNextLevel(double pointsNextLevel){
        this.pointsNextLevel=pointsNextLevel;

    }

    public String getDifficulty(){
        return difficulty;

    }

    public void setDifficulty(String difficulty){
        this.difficulty=difficulty;

    }

    public Treasure[] getTreasures(){
        return treasures;
    }

    public void setTreasures(Treasure[] treasures){
        this.treasures=treasures;
    }

    public Enemy[] getEnemies(){
        return enemies;
    }

    public void setEnemies(Enemy[] enemies){
        this.enemies=enemies;
    }

  //  public String difficultyLevel(){

//		if((treasures[i].getScoreToGive())>(enemies[i].getScoreToGive())){
//			String difficulty="bajo";

	//	}else if((treasures[i].getScoreToGive())=(enemies[i].getScoreToGive())){
	//		String difficulty="medio";

	//	}else if((treasures[i].getScoreToGive())<(enemies[i].getScoreToGive())){
	//		String difficulty="alto";
      //  }

	//}

    public boolean addTreasure (String nameTreasure, String urlImage, double scoreToGive, String locationTreasures, int numberTreasures, int treasureType){
		Treasure newTreasure= new Treasure(nameTreasure, urlImage, scoreToGive, locationTreasures, numberTreasures, treasureType);
        for(int i=0;i<treasures.length;i++){

            if(treasures[i]==null){
                treasures[i]=newTreasure;
                return true;
            }
        }
        return false;
    }




    public boolean addEnemy(String enemyName, double scoreToRemove, double scoreToGive, String enemyLocation, int enemiesType, String nameEnemyType){
        Enemy newEnemy= new Enemy(enemyName, scoreToRemove, scoreToGive, enemyLocation, enemiesType, nameEnemyType);

        for(int i=0;i<enemies.length;i++){

            if(enemies[i]==null){
                enemies[i]=newEnemy;
                return true;
            }
        }
        return false;
    }





    public String toString(){
        String msg= "";

        msg+="Level info:\numberLevel: "+numberLevel+"\npointsNextLevel:"+pointsNextLevel+"\ndifficulty: "+difficulty+"\n";

        for(int i=0;i<enemies.length;i++){

            if (enemies[i]!=null){

                msg+= "\n" + enemies[i].toString();
            }
        }

        for(int i=0;i<treasures.length;i++){
            if(treasures!=null){
                msg+= "\n"+treasures[i].toString();
            }
        }

        return msg;
    }

    public String showTreasuresAndEnemiesInALevel(){

		String msg1="";
		String msg2="";

		for(int i=0;i<treasures.length;i++){
			if(treasures[i]!=null){
				msg1+=", "+treasures[i].getNameTreasure();
			}
		}


		for(int i=0;i<enemies.length;i++){
			if(enemies[i]!=null){
				msg2+=", "+enemies[i].getEnemyName();
			}
		}

		return "Treasures: "+msg1+"\nEnemies: "+msg2;
	}






}

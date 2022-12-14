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

    /**
     * difficultyLevel
     * @param i refers to the level
     * @return difficulty refers the difficulty of the number Level
     */
    public String difficultyLevel(int i){
        String difficulty="";
        

	    if((treasures[i].getScoreToGive())>(enemies[i].getScoreToGive())){
		    difficulty="bajo";

	    }else if((treasures[i].getScoreToGive())==(enemies[i].getScoreToGive())){
	      difficulty="medio";

	    }else if((treasures[i].getScoreToGive())<(enemies[i].getScoreToGive())){
	    	difficulty="alto";
        }
        return difficulty;

	}

    /**
     * addTreasure add a treasure to the treasure array
     * @param nameTreasure refers to the name of the treasure
     * @param urlImage refers to the treasure image url
     * @param scoreToGive refers to the score given by the treasure
     * @param locationTreasures refers to the location of the treasure
     * @param numberTreasures refers to the number of times you will add a treasure in a level
     * @param treasureType refers to the type of treasure
     * @return true or false depending on whether it satisfies the condition
     */

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



/**
 * addEnemy
 * @param enemyName refers to the name of the enemy
 * @param scoreToRemove refers to the score that the enemy removes, if he defeats you
 * @param scoreToGive refers to the score that the enemy gives if you defeat him
 * @param enemyLocation refers to the location of the enemy
 * @param enemiesType refers to the type of Enemy
 * @param nameEnemyType It is a variable that is used to later compare the amount of an enemy type that is in the game
 * @return true or false depending on whether it satisfies the condition
 */
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

    /**
     * showTreasuresAndEnemiesInALevel shows the total number of treasures and enemies in a level
     * @return msg 1 refers to the treasures found therel, msg 1 refers to the enemies found therel
     */
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

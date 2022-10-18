package model;

public class VideoGameController {
	private Enemy[] enemies;
	private Treasure[] treasures;
	private Level[] levels;
	private Player[] players;

	public VideoGameController() {
		enemies = new Enemy[25];
		this.treasures = new Treasure[50];
		this.levels = new Level[10];
		this.players = new Player[20];
	}

	/**
	 * registerEnemy register an enemy to a level and to the arrangement of enemies
	 * @param numberLevel refers to the level to which the enemy is to be added
	 * @param enemyName refers to the name of the enemy
	 * @param scoreToRemove refers to the score that the enemy removes if he defeats you
	 * @param scoreToGive refers to the score that the enemy gives if you defeat him
	 * @param enemyLocation refers to the location of the enemy
	 * @param enemiesType refers to the type of Enemy
	 * @param nameEnemyType It is a variable that is used to later compare the amount of an enemy type that is in the game
	 * @returntrue true or false depending on whether it satisfies the condition
	 */
	public boolean registerEnemy(int numberLevel, String enemyName, double scoreToRemove, double scoreToGive,
			String enemyLocation, int enemiesType, String nameEnemyType) {

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] == null) {
				if ((i + 1) == (numberLevel)) {
					Enemy newEnemy = new Enemy(enemyName, scoreToRemove, scoreToGive, enemyLocation, enemiesType, nameEnemyType);
					enemies[i] = newEnemy;
					levels[i].addEnemy(enemyName, scoreToRemove, scoreToGive, enemyLocation, enemiesType, nameEnemyType);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * registerTreasure register a treasure to a level and to the arrangement of treasures
	 * @param numberLevel refers to the level to which the treasure is to be added
	 * @param nameTreasure refers to the name of the treasure
	 * @param urlImage refers to the treasure image url
	 * @param scoreToGive refers to the score given by the treasure
	 * @param locationTreasures refers to the location of the treasure
	 * @param numberTreasures refers to the number of times you will add a treasure in a level
	 * @param treasureType refers to the type of treasure
	 * @return true or false depending on whether it satisfies the condition
	 */
	public boolean registerTreasure(int numberLevel, String nameTreasure, String urlImage, double scoreToGive,
			String locationTreasures, int numberTreasures, int treasureType) {

		for (int i = 0; i < treasures.length; i++) {
			if (treasures[i] == null) {
				if ((i + 1) == numberLevel) {
					Treasure newTreasure = new Treasure(nameTreasure, urlImage, scoreToGive, locationTreasures,
							numberTreasures, treasureType);
					treasures[i] = newTreasure;
					levels[i].addTreasure(nameTreasure, urlImage, scoreToGive, locationTreasures, numberTreasures,
							treasureType);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * registerPlayer register a Player in the video game
	 * @param nickname refers to the player id
	 * @param name refers to the player's name
	 * @param scorere refers to the player's score (initially it is 10)
	 * @param lives refers to the lives the player has(initally are 5)
	 * @return true or false depending on whether it satisfies the condition
	 */
	public boolean registerPlayer(String nickname, String name, double score, int lives) {
		Player newPlayer = new Player(nickname, name, score, lives);
		for (int i = 0; i < players.length; i++) {
			if (players[i] == null) {
				players[i] = newPlayer;
				return true;
			}
		}
		return false;
	}


	/**
	 * registerLevel register a level in the Video game
	 * @param numberLevel refers to the level id
	 * @param pointsNextLevel refers to the points needed to move to the next level
	 * @param difficulty refers to the difficulty of the level
	 * @return true or false depending on whether it satisfies the condition
	 */
	public boolean registerLevel(int numberLevel, double pointsNextLevel, String difficulty) {

		Level newLevel = new Level(numberLevel, pointsNextLevel, difficulty);

		for (int i = 0; i < levels.length; i++) {
			if (levels[i] == null) {
				levels[i] = newLevel;
				return true;

			}
		}
		return false;
	}

	/**
	 * showLevelsList
	 * @return msg shows the levels that are registered in the game
	 */
	public String showLevelsList() {
		String msg = "";
		for (int i = 0; i < levels.length; i++) {
			if (levels[i] != null) {
				msg += ", " + levels[i].getNumberLevel();
			}
		}
		return msg;
	}

	/**
	 * showPlayersList
	 * @return msg shows the players that are registered in the game
	 */
	public String showPlayersList() {
		String msg = "";
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				msg += ", " + players[i].getNickName();
			}

		}
		return msg;
	}

	/**
	 * showEnemiesList
	 * @return msg shows the players that are registered in the game
	 */
	public String showEnemiesList(){
		String msg="";
		for(int i=0;i<enemies.length;i++){
			if (players[i]!=null){
				msg=", "+enemies[i].getEnemyName();
			}
		}
		return msg;
	}

	/**
	 * positionEnemyMaxScoreToGive shown what is the position in the array, of the enemy that max Score to Give have
	 * @return positionMaxScore represents the position of the enemy with max score to Give
	 */
	public int positionEnemyMaxScoreToGive() {
		double maxScore = 0;
		double scoree = 0;
		int positionMaxScore = 0;

		for (int i = 0; i < enemies.length; i++) {
			if(enemies[i]!=null) {

				scoree = enemies[i].getScoreToGive();

				if (scoree > maxScore) {
					maxScore = scoree;
					positionMaxScore = i;
				}

			} 
		}
		return positionMaxScore;
	}

	/**
	 * enemyMaxScoreToGive
	 * @return msg shows which is the enemy with score to give max, its name and score to give are shown
	 */
	public String enemyMaxScoreToGive() {
		int positionMaxScore = positionEnemyMaxScoreToGive();
		String msg = "The enemy with the Score to Give max is " + enemies[positionMaxScore].getEnemyName() + " with "
				+ enemies[positionMaxScore].getScoreToGive() + " Score to give";
		return msg;
	}

	/**
	 * treasuresAndEnemiesInALevel shows the enemies and treasures that are in a level entered by the user
	 * @param numberLevel refers to the number of the level at which it is going to be consulted
	 * @return msg shows the names of the treasures and enemies that are in the level
	 */
	public String treasuresAndEnemiesInALevel(int numberLevel) {
		return levels[numberLevel].showTreasuresAndEnemiesInALevel();
	}



	/**
	 * editPlayerScore
	 * @param nickName represents the identifier of the player whose score is to be changed
	 * @param playerScore represents the new score of the chosen player
	 * @return true or false depending on whether it satisfies the condition
	 */
	public boolean editPlayerScore(String nickName, double playerScore) {
		String msg = "";
		for (int i = 0; i < players.length; i++) {
			if (nickName.equals(players[i].getNickName())) {
				players[i].setScore(playerScore);
				msg = "This is the new score of the " + players[i].getNickName() + " : " + players[i].getScore();
				System.out.println(msg);
				return true;
			}

		}
		return false;

	}

	/**
	 * treasureMostRepeated show the treasure that most repeated in all game
	 * @return msg represents the message that shown what is the treaure most repeated in all game
	 */
	public String treasureMostRepeated() {

		String msg = "";
		int diamonds = 0;
		int rubys = 0;
		int smeralds = 0;

		for (int i = 0; i < treasures.length; i++) {
			if(treasures[i] == null){
				break;
			}

			if (treasures[i].getNameTreasure().equals("DIAMOND")) {
				diamonds++;
			} else if (treasures[i].getNameTreasure().equals("RUBY")) {
				rubys++;
			} else if (treasures[i].getNameTreasure().equals("SMERALD")) {
				smeralds++;
			}
		}

		if (diamonds > rubys && diamonds > smeralds) {
			msg = "DIAMOND";

		} else if (rubys > diamonds && rubys > smeralds) {
			msg = "RUBY";
		} else if (smeralds > rubys && smeralds > diamonds) {
			msg = "SMERALD";
		}

		return msg;

	}

	/**
	 * quantityEnemyTypeInAllLevels shows the number of times there is an enemy type in the game
	 * @param nameEnemyType refers to the type of enemy that is going to be searched for to count the times it is found
	 * @return msg displays the number of times a user-entered enemy type appears, in the entire game
	 */

	public String quantityEnemyTypeInAllLevels(String nameEnemyType){

		String msg = "";
		int ogres = 0;
		int abstracts = 0;
		int bosses = 0;
		int magics = 0;

		for (int i = 0; i < enemies.length; i++) {
			if(enemies[i] == null){
				break;
			}

			if (enemies[i].getNameEnemyType().equals("OGRE")) {
				ogres++;
			} else if (enemies[i].getNameEnemyType().equals("ABSTRACT")) {
				abstracts++;
			} else if (enemies[i].getNameEnemyType().equals("BOSS")) {
				bosses++;
			}else if(enemies[i].getNameEnemyType().equals("MAGIC")){
				magics++;
			}
		}

		if (nameEnemyType=="OGRE") {
			msg = "the number of ogres enemies in the game is: "+ogres;
		} else if (nameEnemyType=="ABSTRACT") {
			msg = "the number of abstract enemies in the game is: "+abstracts;
		} else if (nameEnemyType=="BOSS") {
			msg = "the number of boss enemies in the game is: "+bosses;
		} else if(nameEnemyType=="MAGIC"){
			msg= "the number of magic enemies in the game is: "+magics;
		}

		return msg;
	}

	/**
	 * quantityTreasureTypeInAllLevels shows the number of times there is an enemy type in the game
	 * @param typeTreasure refers to the type of treasure that is going to be searched for to count the times it is found
	 * @return msg displays the number of times a user-entered treasure type appears, in the entire game
	 */

	public String quantityTreasureTypeInAllLevels(int typeTreasure) {

		String msg = "";
		int diamonds = 0;
		int rubys = 0;
		int smeralds = 0;

		for (int i = 0; i < treasures.length; i++) {
			if(treasures[i] == null){
				break;
			}

			if (treasures[i].getNameTreasure().equals("DIAMOND")) {
				diamonds++;
			} else if (treasures[i].getNameTreasure().equals("RUBY")) {
				rubys++;
			} else if (treasures[i].getNameTreasure().equals("SMERALD")) {
				smeralds++;
			}
		}

		if (typeTreasure==1) {
			msg = "the number of diamonds in the game is: "+diamonds;

		} else if (typeTreasure==2) {
			msg = "the number of rubies in the game is: "+rubys;
		} else if (typeTreasure==3) {
			msg= "the number of smeralds in the game is: "+smeralds;
		}
		return msg;

	}

	/**
	 * countConsonants count the number of consonants in an enemy's name
	 * @param enemyName represents the name of the enemy to which the consonants are going to be counted
	 * @return displays the name of the enemy along with its number of consonants
	 */
	public String countConsonants(String enemyName){
		int consonant=0;

		for(int i=0;i<enemyName.length();i++){
			if((enemyName.charAt(i)=='b')||(enemyName.charAt(i)=='d')||(enemyName.charAt(i)=='d')||(enemyName.charAt(i)=='f')||
			(enemyName.charAt(i)=='g')||(enemyName.charAt(i)=='h')||(enemyName.charAt(i)=='k')||(enemyName.charAt(i)=='l')||
			(enemyName.charAt(i)=='m')||(enemyName.charAt(i)=='n')||(enemyName.charAt(i)=='p')||(enemyName.charAt(i)=='q')||
			(enemyName.charAt(i)=='r')||(enemyName.charAt(i)=='s')||(enemyName.charAt(i)=='t')||(enemyName.charAt(i)=='v')||
			(enemyName.charAt(i)=='w')||(enemyName.charAt(i)=='x')||(enemyName.charAt(i)=='y')||(enemyName.charAt(i)=='z')){
				consonant++;
			

			}


		}
		return "the number of consonants that "+enemyName+" has, is: "+consonant;

	}
	/**
	 * top5Players this method organizes a list of the 5 players with the highest score and displays it
	 * @return msg shows the top 5 players with the most points (their names and their score are shown)
	 */

	public String top5Players(){
		Player player;
		String msg="";
		for(int i=0;i<5;i++){
			if(players[i]!=null){
				for(int j=0;j<players.length;i++){
					if(players[j]!=null){
						if(players[i].getScore()>players[j].getScore()){
							player=players[i];
							players[i]=players[j];
							players[j]=player;

							msg+="\n"+(i+1)+". "+player.getNickName()+" --- Score: "+player.getScore();

						}
					}

				}
			}
			
		}
		return msg;
	}


}



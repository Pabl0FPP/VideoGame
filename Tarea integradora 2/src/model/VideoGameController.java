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

	// R4
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

	// R3.
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

	// R1
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

	// R2
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

	public String showLevelsList() {
		String msg = "";
		for (int i = 0; i < levels.length; i++) {
			if (levels[i] != null) {
				msg += ", " + levels[i].getNumberLevel();
			}
		}
		return msg;
	}

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
	 * positionEnemyMaxScoreToGive shown what is the position in the array, of the
	 * enemy that max Score to Give have
	 * 
	 * @return positionMaxScore represents the position of the enemy with max score
	 *         to Give
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
	 * 
	 * @return msg represents what is the enemy with score to Give mas, shown his
	 *         name and score to give
	 */
	public String enemyMaxScoreToGive() {
		int positionMaxScore = positionEnemyMaxScoreToGive();
		String msg = "The enemy with the Score to Give max is " + enemies[positionMaxScore].getEnemyName() + " with "
				+ enemies[positionMaxScore].getScoreToGive() + " Score to give";
		return msg;
	}

	/**
	 * treasuresAndEnemiesInALevel show the total of treasures
	 * 
	 * @param numberLevel
	 * @return
	 */
	public String treasuresAndEnemiesInALevel(int numberLevel) {
		return levels[numberLevel].showTreasuresAndEnemiesInALevel();
	}

	public String showTreasures() {
		String msg = "";

		for (int i = 0; i < treasures.length; i++) {
			if (treasures[i] != null) {
				msg += "," + treasures[i].getNameTreasure();
			}
		}

		return msg;
	}

	/**
	 * editPlayerScore
	 * @param nickName represents the identifier of the player whose score is to be changed
	 * @param playerScore represents the new score of the chosen player
	 * @return true or false
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
	 * 
	 * @return msg represents the message that shown what is the treaure most
	 *         repeated in all game
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

}

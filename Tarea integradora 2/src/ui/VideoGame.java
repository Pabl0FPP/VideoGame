package ui;
import model.VideoGameController;
import java.util.Scanner;

public class VideoGame {

    public static Scanner sc;
    public static VideoGameController controller;

    public static void main(String[] args){
        init();
        registerLevel();
        menu();
    }

    public static void init(){
        sc=new Scanner(System.in);
        controller= new VideoGameController();
    }

//    public static void registerLevel(){
  //      double pointsNextLevel;
    //    for(int i=1;i<=10;i++){
      //      System.out.println("Type the points for pass the level "+i);
        //    pointsNextLevel=sc.nextDouble();
          //  String difficulty="0";
            
            //controller.registerLevel(i, pointsNextLevel, difficulty);

        //}
    //}


    public static void menu(){
        System.out.println("Welcome!");

        boolean exit=false;

        while(!exit){
                System.out.println("Type an option\n1. Create player\n2. Register Enemy\n3. Register Treasure"
                +"\n4. Modify score of a player\n5. Increase level of a player"
                +"\n6.report the treasures and enemies of a level\n7. Report the quantity of a treasure in all levels"
                +"\n8. Report the quantity founded of a enemy type in all levels"
                +"\n9. Report the treasure most repeated in all levels"
                +"\n10. Report the enemy that gives most score and the level where it is"
                +"\n11. Report the consosnants quantity of an enemies name of the VideoGame"
                +"\n12. Report the top 5 players according to the score");
                int option=sc.nextInt();
                switch (option) {
                    case 1:
                        registerPlayer();
                    
                        break;
                
                    case 2:
                        registerEnemy();

                        break;

                    case 3:
                        registerTreasure();

                        break;

                    case 4:
                        editPlayerScore();


                        break;

                    case 5:
                        
                        break;

                    case 6:
                        showTreasuresAndEnemiesInALevel();
                        break;

                    case 7:
                        break;

                    case 8:
                        break;

                    case 9:
                        System.out.println(controller.treasureMostRepeated());
                        break;

                    case 10:
                        System.out.println(controller.enemyMaxScoreToGive());
                        break;
            
                    default:
                    
                        break;
            }
           
            
        }
    }

    private static void registerPlayer(){
        System.out.println("Type the new Player info: ");
        System.out.println("NickName: ");
        sc.nextLine();
        String nickname=sc.nextLine();
        System.out.println("Name: ");
        String name=sc.nextLine();
        int score=10;
        int lives=5;

        if (controller.registerPlayer(nickname, name, score, lives)){
            System.out.println("Player registered successfully");
        }else{
            System.out.println("player couldn't be registered");
        }
    }

    private static void registerTreasure(){

        String levelsList=controller.showLevelsList();
        System.out.println("These are the levels registered: "+levelsList);

        System.out.println("Type the number level you want to register a treasure");
        int numberLevel=sc.nextInt();

        System.out.println("Type the new treasure info: ");
        System.out.println("Treasure type: 1.DIAMOND, 2. RUBY, 3. SMERALD");
        int treasureType=sc.nextInt()-1;
    
        System.out.println("Url image: ");
        sc.nextLine();
        String urlImage=sc.nextLine();

        System.out.println("Score to Give: ");
        double scoreToGive=sc.nextDouble();
        String locationTreasures="a";

        System.out.println("number of treasures to register in this level: ");
        int numberTreasures=sc.nextInt();

        String nameTreasure="";

        if(treasureType==0){
            nameTreasure="DIAMOND";

        }else if(treasureType==1){
            nameTreasure="RUBY";
        }else if(treasureType==2){
            nameTreasure="SMERALD";
        }

        if(controller.registerTreasure(numberLevel, nameTreasure, urlImage, scoreToGive, locationTreasures, numberTreasures, treasureType)){
            System.out.println("Treasure registered successfully");

        }else{

            System.out.println("Treasure couldn't registered");

        }

    }

    private static void registerEnemy() {

        String levelsList= controller.showLevelsList();
        System.out.println("These are the levels registered: "+levelsList);

        
        System.out.println("Type the number level you want register a Enemy");
        int numberLevel=sc.nextInt();

        System.out.println("Type the new Enemy info: ");
        System.out.println("Name: ");
        sc.nextLine();
        String name=sc.nextLine();

        System.out.println("Score to remove: ");
        double scoreToRemove=sc.nextDouble();

        System.out.println("Score to Give: ");
        double scoreToGive=sc.nextDouble();

        System.out.println("Enemy type: 1.OGRE, 2. ABSTRACT, 3. BOSS, 4.MAGIC");
        int enemyType=sc.nextInt()-1;

        if(controller.registerEnemy(numberLevel, name, scoreToRemove, scoreToGive, name, enemyType)){
            
            System.out.println("Enemy registered successfully");

        }else{

            System.out.println("Enemy couldn't be registered");

        }

    }

    public static void editPlayerScore(){

        String playersList=controller.showPlayersList();
        System.out.println("These are the registered players: "+controller.showPlayersList());
        System.out.println("Type the nickname of the player whose score you want to edit");
        sc.nextLine();
        String nickName=sc.nextLine();

        System.out.println("Type de new Score of the player");
        double score=sc.nextDouble();

        if(controller.editPlayerScore(nickName, score)){

            System.out.println("score edit successfully");
        }else{
            System.out.println("the score couldn't edited");
        }

        
    }

    public static void  showTreasuresAndEnemiesInALevel(){
        System.out.println("Digite el numero del nivel al que le quiere ver los enemigos y tesoros");
		int numberLevel=sc.nextInt()-1;

        System.out.println(controller.treasuresAndEnemiesInALevel(numberLevel));

    }

   public static void registerLevel(){
        for(int i=0;i<10;i++){
            System.out.println("number level");
            int numberLevel=sc.nextInt();
            System.out.println("points for pass the level "+numberLevel);
            double pointsNextLevel=sc.nextDouble();

            String difficulty="0";

            if(controller.registerLevel(numberLevel, pointsNextLevel, difficulty)){

                System.out.println("si");

            }else{

                System.out.println("no");

            }
        }

    }

    
}

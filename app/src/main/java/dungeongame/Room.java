package dungeongame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Room {
    private MainCharacter player1;
    private Enemy enemy;
    private double enemyAppearance;

    //***********************************Image Files****************************
    private File goblinFile = new File("app/src/main/java/dungeongame/Goblin.txt");
    private File spiderFile = new File("app/src/main/java/dungeongame/Spider.txt");
    private File orgeFile = new File("app/src/main/java/dungeongame/Orge.txt");
    private File skeletonFile = new File("app/src/main/java/dungeongame/Skeleton.txt");

    public Room(){
        player1 = new MainCharacter();

        enemyAppearance = Math.random();
        if(enemyAppearance < .2){
            Skeleton skeleton1 = new Skeleton();
            enemy = skeleton1;
            try{
                printFile(skeletonFile);
            } catch (FileNotFoundException e) {
                System.out.println("***NO PIC FOUND***");
            }
        }
        else if(enemyAppearance < .5){
            Goblin goblin1 = new Goblin();
            enemy = goblin1;
            try{
                printFile(goblinFile);
            } catch (FileNotFoundException e) {
                System.out.println("***NO PIC FOUND***");
            }
        } else if(enemyAppearance < .8){
            Spider spider1 = new Spider();
            enemy = spider1;
            try{
                printFile(spiderFile);
            } catch (FileNotFoundException e) {
                System.out.println("***NO PIC FOUND***");
            }
        } else {
            Ogre ogre1 = new Ogre();
            enemy = ogre1;
            try{
                printFile(orgeFile);
            } catch (FileNotFoundException e) {
                System.out.println("***NO PIC FOUND***");
            }
        }
    }

    public Room(MainCharacter character){
        player1 = character;
        enemyAppearance = Math.random();
        if(enemyAppearance < .5){
            Goblin goblin1 = new Goblin();
            enemy = goblin1;
            try{
                printFile(goblinFile);
            } catch (FileNotFoundException e) {
                System.out.println("***NO PIC FOUND***");
            }
        } else if(enemyAppearance < .8){
            Spider spider1 = new Spider();
            enemy = spider1;
            try{
                printFile(spiderFile);
            } catch (FileNotFoundException e) {
                System.out.println("***NO PIC FOUND***");
            }
        } else {
            Ogre ogre1 = new Ogre();
            enemy = ogre1;
            try{
                printFile(orgeFile);
            } catch (FileNotFoundException e) {
                System.out.println("***NO PIC FOUND***");
            }
        }
    }
    public Room(MainCharacter character, Enemy enemy1){
        player1 = character;
        enemy = enemy1;
        try {
            if (enemy1 instanceof Goblin) {
                printFile(goblinFile);
            } else if(enemy1 instanceof Spider){
                printFile(spiderFile);
            } else if (enemy instanceof Skeleton) {
                printFile(skeletonFile);
            } else {
                printFile(orgeFile);
            }
        }catch (FileNotFoundException ex){
            System.out.println("***NO PIC FOUND***");
        }
    }

    public void battle(){
        Scanner input = new Scanner(System.in);
        System.out.println("A " + enemy.getName() + " HAS APPEARED!");
        String enemyAction;
        do {
            double enemyRoll = Math.random();

            if (enemyRoll > .5) {
                enemyAction = "ATTACK";
            } else if (enemyRoll > .2) {
                enemyAction = "BLOCK";
            } else {
                enemyAction = "EVADE";
            }


            System.out.println("Would you like to:\n1-BLOCK\t2-ATTACK\n3-EVADE\t4-REST\n");
            String action = input.next();
            System.out.println();

            Actions.checkAction(action, enemyAction, (MainCharacter) player1, (Enemy) enemy);
        } while (enemy.getHealthPoints() > 0 && player1.getHealthPoints() > 0);
        if (enemy.getHealthPoints() <= 0) {
            System.out.println("The " + enemy.getName() + " died\n");
            input.nextLine();
            if(player1.getHealthPoints() < 100) {
                System.out.println("You've regained some health");
                if (player1.getHealthPoints() <= 80) {
                    player1.setHealthPoints(player1.getHealthPoints() + 20);
                } else {
                    player1.setHealthPoints(100);
                }
            }
            System.out.println("Current health: " + player1.getHealthPoints());
            System.out.println("\n");
        } else {
            player1.die();
            System.out.println("You have died...");
        }
        input.close();
    }

    public static void printFile(File picFile) throws FileNotFoundException {
        Scanner in = new Scanner(picFile);
        while(in.hasNextLine()){
            System.out.println(in.nextLine());
        }
        in.close();
    }
}

package DungeonGame.src.main;

import java.util.Scanner;
import java.util.ArrayList;
public class GameTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Character> charactersOnScreen = new ArrayList<>();
        String continueQueue = "Y";

        System.out.println("What is your character's name?");
        String name = input.next();
        MainCharacter mc1 = new MainCharacter(name, 100, 100, 20, true);
        Goblin goblin1 = new Goblin();
        Ogre ogre1 = new Ogre();
        Spider spider1 = new Spider();

        charactersOnScreen.add(mc1);
        charactersOnScreen.add(goblin1);
        charactersOnScreen.add(ogre1);
        charactersOnScreen.add(spider1);
        System.out.println("A " + charactersOnScreen.get(2).getName() + " HAS APPEARED!");
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


            System.out.println("Would you like to:\nBLOCK\tATTACK\nEVADE\tREST\n");
            String action = input.next();
            System.out.println();

            Actions.checkAction(action, enemyAction, (MainCharacter) charactersOnScreen.get(0), (Enemy) charactersOnScreen.get(2));

            String mainInfo = mc1.toString();
            String goblinInfo = goblin1.toString();
            String orgeInfo = ogre1.toString();
            String spiderInfo = spider1.toString();

            System.out.printf("\n%s \n %s\n\n", mainInfo, charactersOnScreen.get(2).toString());
        } while (charactersOnScreen.get(2).getHealthPoints() > 0 && mc1.getHealthPoints() > 0);
        if (charactersOnScreen.get(2).getHealthPoints() <= 0) {
            goblin1.die();
            System.out.println("The " + charactersOnScreen.get(2) + " died");
        } else {
            mc1.die();
            System.out.println("You have died...");
            System.out.println("\n\n\tG A M E  O V E R");
        }
    }
}



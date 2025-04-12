package DungeonGame.src.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NeverEndingDungeon {
    public static void main(String[] args) {

        //************************************Background procedures***********************
        Scanner input = new Scanner(System.in);
        ArrayList<Room> roomsDone = new ArrayList<>();
        String[] dialogue = new String[]
        {"As you walk through the first room, that uneasy feeling you felt before grows stronger \nthen suddenly...  ",
         "You make your way into the next room, it seems quiet...too quiet",
         "You make your way into the next room, you are not alone...",
         "You make your way into the next room, you hoped for a chance to rest\nyou are not so lucky...",
         "You make your way into the next room, you must be halfway there...",
         "You make your way into the next room, your resolve is shining\n your fight continues...",
         "You make your way into the next room, few would've made it this far\n you are not safe yet...",
         "You make your way into the next room, you can hear the winds racing \noutside of the dungeon. You are not done yet",
         "You make your way into the next room, you can see the light coming from the exit",
         };

        //***********************************Image Files****************************

        File MCFile = new File("DungeonGame/src/main/MainCharacter.txt");
        File deadFile = new File("DungeonGame/src/main/DEATH.txt");

        //********************************Instructions and Game choice**************
        System.out.println("Press space and the enter key to continue during the dialogue");
        System.out.println("Enter the number next to the action to perform that action");
        System.out.println("\n\t1-Story\n\t2-Gauntlet");
        String gameSelect = input.next();

        //**********************************Prologue Story****************************
        if (gameSelect.equals("1")) {
            System.out.println("You begun your journey into the unassuming dungeon with no clue of the dangers \nthat were hidden within.");
            input.nextLine();
            System.out.println("As you ventured deeper and deeper into the dungeon an uneasy feeling fell upon you...");
            input.nextLine();
            System.out.println("You");
            input.nextLine();
            System.out.println("were not");
            input.nextLine();
            System.out.println("alone.");
            input.nextLine();
            System.out.println("You must fight your way out of the dungeon");
            input.nextLine();
            System.out.println("Your only objective is to escape, and for that you must survive\n\n...but who are you?");


            //**********************************Character Creation******************
            try {
                printFile(MCFile);
            } catch (FileNotFoundException ex) {
                System.out.println("***NO PIC FOUND***");
            }

            System.out.println("Name: ");
            String name = input.next();
            MainCharacter mc1 = new MainCharacter(name, 100, 100, 20, true);
            System.out.println("\n");
            System.out.println(name + "'s escape, begins now...\n");
            System.out.println("You begin making your way out of the dungeon, re-entering the very same rooms \nyou explored through earlier on in your adventure.");
            input.nextLine();
            System.out.println("\n");

            //**********************************The Game****************************
            do {
                Room newRoom = null;
                if (roomsDone.size() < 1){ // First Room so spawn Spider
                    System.out.println(dialogue[roomsDone.size()]);
                    newRoom = new Room(mc1, new Spider());
                    newRoom.battle();
                } else if(roomsDone.size() < 2){ // Second Room so spawn Goblin
                    System.out.println(dialogue[roomsDone.size()]);
                    newRoom = new Room(mc1, new Goblin());
                    newRoom.battle();
                } else if(roomsDone.size() == 9){ // Last Room so spawn Orge
                    System.out.println("You make your way into the last room, the exit is right in front of you...\ncan you reach it...");
                    input.nextLine();
                    System.out.println();
                    System.out.println("The light pearing through the door is now blocked by an overwhelming figure\n");
                    input.nextLine();
                    System.out.println();
                    System.out.println("One");
                    System.out.println("More");
                    System.out.println("Fight...");
                    input.nextLine();

                    newRoom = new Room(mc1, new Ogre());
                    newRoom.battle();
                } else {
                    System.out.println(dialogue[roomsDone.size()]);
                    newRoom = new Room(mc1);
                    newRoom.battle();
                }
                // Run after Every room to check if player died
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(newRoom);
                }

            } while (mc1.getHealthPoints() > 0 && roomsDone.size() < 10);
            
            if (mc1.getHealthPoints() <= 0) {
                System.out.println("\n\n\tG A M E  O V E R");
                System.out.println("\tYou cleared " + roomsDone.size() + " rooms.");
            } else {
                System.out.println("You escaped the dungeon!!");
            }
        }
        else if(gameSelect.equals("2")){
            System.out.println("The gauntlet is a test of resiliance to see how many rooms you can clear\nwithout healing.");
            System.out.println("This gauntlet does not end until you inevitably  D I E");
            System.out.print("Let us begin, what is your name: ");
            String name = input.next();
            System.out.println("\n\n\t" + name + "\n\t\thas\n\t\tentered\n\t\t\tthe\n\t\t\t\tGAUNTLET");
            MainCharacter mc1 = new MainCharacter(name, 100, 100, 20, true);
            int roomsCleared = 0;
            while (mc1.getHealthPoints() > 0){
                Room repeatRoom = new Room(mc1);
                repeatRoom.battle();
                if(mc1.getHealthPoints() > 0) {
                    roomsCleared++;
                }
            }
            System.out.println("\n\n\tG A M E  O V E R");
            System.out.println("\tYou cleared " + roomsCleared + " rooms.");
            input.close();
        }
        else {
            System.out.println("Invalid selection");
        }
    }

    public static void printFile(File picFile) throws FileNotFoundException {
        Scanner in = new Scanner(picFile);
        while(in.hasNextLine()){
            System.out.println(in.nextLine());
        }
        in.close();
    }
}

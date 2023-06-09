package DungeonGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NeverEndingDungeon {
    public static void main(String[] args) {

        //************************************Background procedures***********************
        Scanner input = new Scanner(System.in);
        ArrayList<Room> roomsDone = new ArrayList<>();

        //***********************************Image Files****************************

        File MCFile = new File("MainCharacter.txt");
        File deadFile = new File("DEATH.txt");

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

            //**********************************The Game****************************
            do {
                System.out.println(name + "'s escape, begins now...\n");
                System.out.println("You begin making your way out of the dungeon, re-entering the very same rooms \nyou explored through earlier on in your adventure.");
                input.nextLine();
                System.out.println("\n");

                //*****************************Room 1*******************************
                System.out.println("As you walk through the first room, that uneasy feeling you felt before grows stronger \nthen suddenly...  ");

                Room room1 = new Room(mc1, new Spider());
                room1.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room1);
                }

                //*****************************Room 2*******************************
                System.out.println("You make your way into the next room, it seems quiet...too quiet");
                input.nextLine();


                Room room2 = new Room(mc1, new Goblin());
                room2.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room2);
                    System.out.print("Your attack power has increased!");//increase attack power
                    mc1.setAttackPower(mc1.getAttackPower() + 5);
                }
                //*****************************Room 3*******************************
                System.out.println("You make your way into the next room, you are not alone...");
                input.nextLine();


                Room room3 = new Room(mc1);
                room3.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room3);
                }

                //*****************************Room 4*******************************
                System.out.println("You make your way into the next room, you hoped for a chance to rest\nyou are not so lucky...");
                input.nextLine();


                Room room4 = new Room(mc1);
                room4.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room4);
                    System.out.print("Your attack power has increased!");//increase attack power
                    mc1.setAttackPower(mc1.getAttackPower() + 5);
                }
                //*****************************Room 5*******************************
                System.out.println("You make your way into the next room, you must be halfway there...");
                input.nextLine();


                Room room5 = new Room(mc1);
                room5.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room5);
                    System.out.print("Your attack power has increased!");//increase attack power
                    mc1.setAttackPower(mc1.getAttackPower() + 5);
                }
                //*****************************Room 6*******************************
                System.out.println("You make your way into the next room, your resolve is shining\n your fight continues...");
                input.nextLine();


                Room room6 = new Room(mc1);
                room6.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room6);
                }
                //*****************************Room 7*******************************
                System.out.println("You make your way into the next room, few would've made it this far\n you are not safe yet...");
                input.nextLine();


                Room room7 = new Room(mc1);
                room7.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room7);
                }
                //*****************************Room 8*******************************
                System.out.println("You make your way into the next room, you can hear the winds racing \noutside of the dungeon. You are not done yet");
                input.nextLine();


                Room room8 = new Room(mc1);
                room8.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room8);
                    System.out.print("Your attack power has increased!");//increase attack power
                    mc1.setAttackPower(mc1.getAttackPower() + 5);
                }
                //*****************************Room 9*******************************
                System.out.println("You make your way into the next room, you can see the light coming from the exit");
                input.nextLine();


                Room room9 = new Room(mc1);
                room9.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room1);
                }
                //*****************************Room 10*******************************
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


                Room room10 = new Room(mc1, new Ogre());
                room10.battle();
                if (mc1.getHealthPoints() <= 0) {
                    try {
                        printFile(deadFile);
                    } catch (FileNotFoundException ex) {
                        System.out.println("***NO PIC FOUND***");
                    }
                    break;
                } else {
                    roomsDone.add(room10);
                    break;
                }


            } while (mc1.getHealthPoints() > 0 && roomsDone.size() <= 10);
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
            System.out.println("\n\n\t" + name + "\n\t\thas\n\t\t\tthe\n\t\t\t\tGAUNTLET");
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
    }
}

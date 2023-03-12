package DungeonGame;

public class Actions {
    public static void checkAction(String playerAction, String enemyAction, MainCharacter player,  Enemy enemy)  {
        /****************************************************************************************************
         * Checking User input
         *****************************************************************************************************/



        //**************************************************Player Attacks**********************************************************
        if (playerAction.equals("2") || playerAction.equals("two")) { // If the player wants to attack
            if (enemyAction.equals("ATTACK")) { // enemy wants to attack
                player.attack(enemy);
                if(enemy.getHealthPoints() > 0) {
                    System.out.println("The " + enemy.getName() + "'s health is now at " + enemy.getHealthPoints());
                    if(enemy.getStaminaPoints() >= 10) {
                        enemy.attack(player);
                        System.out.println("The " + enemy.getName() + " struck you dealing full damage!");
                        System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());
                    }
                }
                //**************************************************DungeonGame.Enemy Blocks**********************************************************
            } else if(enemyAction.equals("BLOCK")) { // DungeonGame.Enemy wants to block
                enemy.block(player);
                if (enemy.getIsBlocking()) {

                    if(player.getStaminaPoints() >=10) {
                        player.setAttackPower(player.getAttackPower() / 2);
                        player.attack(enemy);
                        enemy.setBlocking(false);
                        player.setAttackPower(player.getAttackPower() * 2);
                        System.out.println("The " + enemy.getName() + " blocked, halving the damage dealt");
                        System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());
                    } else {
                        player.attack(enemy);
                    }

                } else {
                    System.out.println("The " + enemy.getName() + "'s block failed!");
                    player.attack(enemy);
                    System.out.println("The " + enemy.getName() + "'s health is now at " + enemy.getHealthPoints());
                    System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());
                }

                //**************************************************DungeonGame.Enemy evades**********************************************************
            } else if(enemyAction.equals("EVADE")) { // DungeonGame.Enemy wants to evade
                enemy.evade(player);
                if (enemy.isEvadeSuccessful()) {
                    System.out.println("The " +  enemy.getName() + " evaded your attack");
                } else {
                    System.out.println("The " +  enemy.getName() + " failed to evade your attack");
                    player.attack(enemy);
                    System.out.println("The " + enemy.getName() + "'s health is now at " + enemy.getHealthPoints());
                    System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());

                }
                //**************************************************DungeonGame.Enemy Rests**********************************************************
            } else {
                enemy.rest();
                System.out.println("The " +  enemy.getName() + " had to rest");
                player.attack(enemy);
                System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());

            }

            //**************************************************Player Blocks**********************************************************
        } else if (playerAction.equals("1") || playerAction.equals("one")) { // If the player wants to block
            if (enemyAction.equals("ATTACK")) {
                player.block(enemy);
                System.out.println("You brace yourself for the incoming attack...");
                if(player.getIsBlocking() && enemy.getStaminaPoints() >= 10) {
                    enemy.setAttackPower(enemy.getAttackPower() / 2);
                    enemy.attack(player);
                    player.setBlocking(false);
                    enemy.setAttackPower(enemy.getAttackPower() * 2);
                    System.out.println("The " + enemy.getName() + " struck you!");
                    System.out.println("Your block halved the incoming damage");
                    System.out.println("Current Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());
                } else if(!player.getIsBlocking() && enemy.getStaminaPoints() >= 10) {
                    enemy.attack(player);
                    System.out.println("Your block failed!");
                    System.out.println("The " + enemy.getName() +" struck you dealing full damage!");
                    System.out.println("Current Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());
                } else {
                    enemy.attack(player);
                }
                //**************************************************DungeonGame.Enemy does not attack**********************************************************
            } else {
                enemy.setBlocking(false);
                enemy.setEvadeSuccessful(false);
                System.out.println("There was no attack to block");
                System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());

            }

            //**************************************************Player Evades**********************************************************
        } else if (playerAction.equals("3") || playerAction.equals("three")) { // If the player wants to evade
            if(enemyAction.equals("ATTACK")) {
                player.evade(enemy);
                System.out.println("You try to evade the incoming attack...");
                if (player.isEvadeSuccessful()) {
                    System.out.println("You successfully evaded the attack!");
                    player.setEvadesuccessful(false);
                    System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());

                } else if(!player.isEvadeSuccessful() && enemy.getStaminaPoints() >= 10){
                    System.out.println("You failed to evade the incoming attack!");
                    enemy.attack(player);
                    System.out.println("The " + enemy.getName() +" struck you dealing full damage!");
                    System.out.println("Current Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());
                } else {
                    enemy.attack(player);
                    System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());
                }
            } else {
                enemy.setBlocking(false);
                enemy.setEvadeSuccessful(false);
                System.out.println("There was no attack to evade");
                System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());

            }

            //**************************************************Player Rests**********************************************************
        } else if (playerAction.equals("4") || playerAction.equals("four")) { // If the player wants to rest
            if (enemyAction.equals("ATTACK")) { // enemy wants to attack
                System.out.println("You decide to rest to build your stamina");
                player.rest();
                if (enemy.getStaminaPoints() >= 10) {
                    enemy.attack(player);
                    System.out.println("The " + enemy.getName() +" struck you dealing full damage!");
                    System.out.println("Current Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());
                } else {
                    enemy.attack(player);
                }
            } else {
                player.rest();
                System.out.println("The " + enemy.getName() + " did not attack.");
                enemy.setBlocking(false);
                enemy.setEvadeSuccessful(false);
                System.out.println("\n\nCurrent Health: " + player.getHealthPoints() + " Stamina: " + player.getStaminaPoints());
            }
        } else {
            System.out.println("\n***Invalid action***");
        }



    }
}

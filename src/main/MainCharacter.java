package DungeonGame.src.main;

import DungeonGame.src.main.Character;

public class MainCharacter extends Character{
    private String name = "";
    private int attackPower;
    private int healthPoints;
    private int staminaPoints;
    private boolean isOnScreen;
    private boolean isBlocking = false;
    private boolean evadeSuccessful = false;

    public MainCharacter(){
        this.healthPoints = 100;
        this.staminaPoints = 100;
        this.isOnScreen = true;
        this.attackPower = 20;
        }

    public MainCharacter(String name, int healthPoints, int staminaPoints, int attackPower, boolean isOnScreen){
        super(healthPoints, staminaPoints, attackPower, isOnScreen);
        this.name = name;
        this.healthPoints = super.getHealthPoints();
        this.staminaPoints = super.getStaminaPoints();
        this.isOnScreen = super.getIsOnScreen();
        this.attackPower =super.getAttackPower();
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public int getStaminaPoints() {
        return this.staminaPoints;
    }

    public boolean getIsOnScreen(){
        return this.isOnScreen;
    }

    public boolean getIsBlocking(){
        return isBlocking;
    }

    @Override
    public int getAttackPower() {
        return this.attackPower;
    }

    public boolean isEvadeSuccessful() {
        return evadeSuccessful;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setStaminaPoints(int staminaPoints) {
        this.staminaPoints = staminaPoints;
    }

    public void setIsOnScreen(boolean isOnScreen) {
        this.isOnScreen = isOnScreen;
    }

    public void setBlocking(boolean blocking) {
        isBlocking = blocking;
    }

    public void setEvadesuccessful(boolean evadeSuccessful){
        this.evadeSuccessful = evadeSuccessful;
    }

    @Override
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setEvadeSuccessful(boolean evadeSuccessful) {
        this.evadeSuccessful = evadeSuccessful;
    }
    public void die(){
        if(this.healthPoints <= 0){
            this.isOnScreen = false;
        }
    }

    @Override
    public String toString() {
        return "DungeonGame.Character{" + "name=" + name +
                ", healthPoints=" + healthPoints +
                ", staminaPoints=" + staminaPoints +
                ", attackPower=" + attackPower +
                ", isOnScreen=" + isOnScreen +
                '}';
    }
    public void attack(Character character){
        if(this.staminaPoints >= 10) {
            int currentHealth = character.getHealthPoints();
            int afterAttackHealth = currentHealth - this.attackPower;
            this.staminaPoints -= 10;
            character.setHealthPoints(afterAttackHealth);
            System.out.println("You attacked the " + character.getName() + "!");
            System.out.println("Stamina has decreased by 10");
        } else {
            System.out.println("You do not have enough stamina to attack.");
            rest();
        }
    }
    public void block(Character character){
        if(this.staminaPoints >= 5) {
            double blockChance = Math.random();
            this.staminaPoints -= 5;
            if (blockChance > .3) {
                this.isBlocking = true;
            } else {
                this.isBlocking = false;
            }
        } else {
            System.out.println("You do not have enough stamina to block.");
            rest();
        }
    }
    public void evade(Character character){
        if(this.staminaPoints >= 10) {
            double evadeChance = Math.random();
            this.staminaPoints -= 10;
            if (evadeChance > .7) {
                this.evadeSuccessful = true;
            } else {
                this.evadeSuccessful = false;
            }
        } else {
            System.out.println("You do not have enough stamina to evade.");
            rest();
        }
    }
    public void rest() {
        if (this.staminaPoints >= 100){
            System.out.println("You do not need to rest");
        } else if(this.staminaPoints <= 80) {
            System.out.println("You decide to rest up and restore your stamina.");
            this.staminaPoints += 20;
        } else {
            System.out.println("You decide to rest up and restore your stamina.");
            this.staminaPoints += 5;
        }

    }


}

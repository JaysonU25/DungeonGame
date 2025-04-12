package DungeonGame.src.main;

public class Goblin extends Enemy{
    private String name = "Goblin";
    private int attackPower;
    private int healthPoints;
    private int staminaPoints;
    private boolean isOnScreen;
    private boolean isBlocking = false;
    private boolean evadeSuccessful = false;

    public Goblin(){
        this.healthPoints = 100;
        this.staminaPoints = 60;
        this.attackPower = 20;
        this.isOnScreen = true;
    }

    public Goblin(int healthPoints, int staminaPoints, int attackPower, boolean isOnScreen){
        super(healthPoints, staminaPoints, attackPower, isOnScreen);
        this.healthPoints = super.getHealthPoints();
        this.staminaPoints = super.getStaminaPoints();
        this.isOnScreen = super.getIsOnScreen();
        this.attackPower = super.getAttackPower();
    }

    public String getName() {
        return this.name;
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

    @Override
    public int getAttackPower() {
        return this.attackPower;
    }

    public boolean getIsBlocking(){
        return isBlocking;
    }


    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setStaminaPoints(int staminaPoints) {
        this.staminaPoints = staminaPoints;
    }

    public void setEvadeSuccessful(boolean evadeSuccessful) {
        this.evadeSuccessful = evadeSuccessful;
    }

    public void setBlocking(boolean blocking) {
        isBlocking = blocking;
    }


    public boolean isOnScreen() {
        return isOnScreen;
    }
    public void die(){
        if(this.healthPoints <= 0){
            this.isOnScreen = false;
        }
    }

    @Override
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void attack(Character character){
        if(this.staminaPoints >= 10) {
            int currentHealth = character.getHealthPoints();
            int afterAttackHealth = currentHealth - this.attackPower;
            this.staminaPoints -= 10;
            character.setHealthPoints(afterAttackHealth);
        } else {
            System.out.println("The " + this.name + " did not have enough stamina to attack.");
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
            System.out.println("The " + this.name + " did not have enough stamina to block.");
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
            System.out.println("The " + this.name + " did not have enough stamina to evade.");
            rest();
        }
    }
    public void rest() {
        if (this.staminaPoints >= 60){
            System.out.println(this.name + "tried, but did not need to rest");
        } else if(this.staminaPoints <= 40) {
            System.out.println("The " + this.name + " decided to rest up and restore it's stamina.");
            this.staminaPoints += 20;
        } else {
            System.out.println("The " + this.name + " decided to rest up and restore it's stamina.");
            this.staminaPoints += 5;
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



}


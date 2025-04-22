package dungeongame;

public class Spider extends Enemy{
    private String name = "Spider";
    private int attackPower;
    private int healthPoints;
    private int staminaPoints;
    private boolean isOnScreen;
    private boolean isBlocking = false;
    private boolean evadeSuccessful = false;

    public Spider(){
        this.healthPoints = 75;
        this.staminaPoints = 100;
        this.attackPower = 10;
        this.isOnScreen = true;
    }

    public Spider(int healthPoints, int staminaPoints, int attackPower, boolean isOnScreen){
        super(healthPoints, staminaPoints, attackPower, isOnScreen);
        this.healthPoints = super.getHealthPoints();
        this.staminaPoints = super.getStaminaPoints();
        this.isOnScreen = super.getIsOnScreen();
        this.attackPower = super.getAttackPower();
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

    public boolean isEvadeSuccessful() {
        return evadeSuccessful;
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
        if(this.getHealthPoints() <= 0){
            this.isOnScreen = false;
        }
    }

    @Override
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void attack(Character character){
        if(this.getStaminaPoints() >= 10) {
            int currentHealth = character.getHealthPoints();
            int afterAttackHealth = currentHealth - this.attackPower;
            this.setStaminaPoints(this.getStaminaPoints() - 10);;
            character.setHealthPoints(afterAttackHealth);
        } else {
            System.out.println("The " + this.name + " did not have enough stamina to attack.");
            rest();
        }
    }
    public double roll(){
        return Math.random();
    }
    public void block(Character character){
        if(this.getStaminaPoints() >= 5) {
            double blockChance = roll();
            this.setStaminaPoints(this.getStaminaPoints() - 5);
            if (blockChance > .5) {
                this.setBlocking(true);
            } else {
                this.setBlocking(false);
            }
        } else {
            System.out.println("The " + this.name + " did not have enough stamina to block.");
            rest();
        }
    }
    public void evade(Character character){
        if(this.getStaminaPoints() >= 10) {
            double evadeChance = roll();
            this.setStaminaPoints(this.getStaminaPoints() - 10);
            if (evadeChance > .5) {
                this.setEvadeSuccessful(true);
            } else {
                this.setEvadeSuccessful(false);
            }
        } else {
            System.out.println("The " + this.name + " did not have enough stamina to evade.");
            rest();
        }
    }
    public void rest() {
        if (this.getStaminaPoints() >= 60){
            System.out.println(this.name + "tried, but did not need to rest");
        } else if(this.getStaminaPoints() <= 40) {
            System.out.println("The " + this.name + " decided to rest up and restore it's stamina.");
            this.setStaminaPoints(this.getStaminaPoints() + 20);
        } else {
            System.out.println("The " + this.name + " decided to rest up and restore it's stamina.");
            this.setStaminaPoints(this.getStaminaPoints() + 5);
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


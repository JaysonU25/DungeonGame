package dungeongame;


public abstract class Enemy extends Character{
    private String name;
    private int attackPower;
    private int healthPoints;
    private int staminaPoints;
    private boolean isOnScreen;
    private boolean isBlocking = false;
    private boolean evadeSuccessful = false;

    public Enemy(){
        this.healthPoints = 100;
        this.staminaPoints = 100;
        this.attackPower = 20;
        this.isOnScreen = true;
    }

    public Enemy(int healthPoints, int staminaPoints, int attackPower, boolean isOnScreen){
        super(healthPoints, staminaPoints, attackPower, isOnScreen);
        this.healthPoints = super.getHealthPoints();
        this.staminaPoints = super.getStaminaPoints();
        this.isOnScreen = super.getIsOnScreen();
        this.attackPower = super.getAttackPower();
    }

    public String getName() {
        return name;
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

    public void attack(Character character){
        int currentHealth = character.getHealthPoints();
        int afterAttackHealth = currentHealth - 20;
        this.staminaPoints -= 10;
        character.setHealthPoints(afterAttackHealth);
    }
    public void block(Character character){
        double blockChance = Math.random();
        if(blockChance > .3) {
            this.isBlocking = true;
            this.staminaPoints -= 5;

        } else {
            this.isBlocking = false;
        }
    }
    public void evade(Character character){
        double evadeChance = Math.random();
        if(evadeChance > .7){
            this.evadeSuccessful = true;
        } else {
            this.evadeSuccessful = false;
        }
    }

    public void rest() {
        if (this.staminaPoints >= 50){
            System.out.println(this.name + "tried, but did not need to rest");
        } else if(this.staminaPoints <= 40) {
            System.out.println("The " + this.name + " decided to rest up and restore it's stamina.");
            this.staminaPoints += 10;
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

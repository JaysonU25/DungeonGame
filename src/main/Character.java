package DungeonGame.src.main;

public abstract class Character {
    private String name;
    private int attackPower;
    private int healthPoints;
    private int staminaPoints;
    private boolean isOnScreen;

    public Character(){
        this.healthPoints = 100;
        this.staminaPoints = 100;
        this.attackPower = 20;
        this.isOnScreen = true;
    }
    public Character(int healthPoints, int staminaPoints, int attackPower,boolean isOnScreen){
        this.healthPoints = healthPoints;
        this.staminaPoints = staminaPoints;
        this.attackPower = attackPower;
        this.isOnScreen = isOnScreen;
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

    public int getAttackPower() {
        return this.attackPower;
    }

    public boolean getIsOnScreen(){
        return this.isOnScreen;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setStaminaPoints(int staminaPoints) {
        this.staminaPoints = staminaPoints;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setIsOnScreen(boolean isOnScreen) {
         this.isOnScreen = isOnScreen;
    }

    @Override
    public String toString() {
        return "DungeonGame.Character{" +
                "healthPoints=" + healthPoints +
                ", staminaPoints=" + staminaPoints +
                ", isOnScreen=" + isOnScreen +
                '}';
    }
}

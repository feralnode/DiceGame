public class Player {
    private String name;
    private byte point = 0;
    private Die die;

    public Player(String name) {
        this.name = name;
    }

    // The rollDice method should use the roll() method.

    public byte getDieValue() {
        return die.getCurrentDieValue();
    }

    public void increaseScore() {
        setPoint((byte) 1);
    }

    public void addDie(byte numberOfSides) {
        die = new Die(numberOfSides);
    }

    public void rollDice() {
        die.roll();
    }
    
    public String getName() {
    return name;
    }

    public byte getScore() {
    return point;
    }

    public void setPoint(byte point) {
    this.point += point;
    }
    
}
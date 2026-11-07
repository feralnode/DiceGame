public class Player {
    private String name;
    private byte point = 0;
    private Die die;

    // Creates a player with a name.
    public Player(String name) {
        this.name = name;
    }

    // Returns the current die value.
    public byte getDieValue() {
        return die.getCurrentDieValue();
    }

    // Increases the player's score by one.
    public void increaseScore() {
        setPoint((byte) 1);
    }

    // Creates a die with the specified number of sides.
    public void addDie(byte numberOfSides) {
        die = new Die(numberOfSides);
    }

    // Rolls the player's die.
    public void rollDice() {
        die.roll();
    }

    // Returns the player's name.
    public String getName() {
        return name;
    }

    // Returns the player's score.
    public byte getScore() {
        return point;
    }

    // Adds points to the player's current score.
    public void setPoint(byte point) {
        this.point += point;
    }
}
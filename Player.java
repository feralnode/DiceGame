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
        //Should use setPoint() method to increase the score
    }

    public void addDie(byte numberOfSides) {
        die = new Die(numberOfSides);
    }
}
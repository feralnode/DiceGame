public class Player {
    private String name;
    private byte point = 0;
    Die die;

    public Player(String name) {
        this.name = name;
    }

    public int getDieValue() {
        return die.getDie();
    }

    public void increaseScore() {
        //Should use setPoint() method to increase the score
    }

    public void addDie(byte numberOfSides) {
        die = new Die(numberOfSides);
    }
}
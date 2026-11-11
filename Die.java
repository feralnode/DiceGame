import java.util.Random;

public class Die {
    private byte currentValueOfDie;
    private byte diceSides;

    private Random random = new Random();
    
    public Die(byte diceSides) {
        this.diceSides = diceSides; 
    }

    public byte getCurrentDieValue() {
        return currentValueOfDie;
    }

    // Method to roll the die and get a random value between 1 and the number of sides and add it to the currentValueOfDie
    public void roll() {
        currentValueOfDie = (byte) (random.nextInt(diceSides) + 1);
        System.out.println("Du rullade tärningen och fick " + currentValueOfDie);
    }

}

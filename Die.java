import java.util.Random;

public class Die {

    byte currentValueOfDie;

    byte diceSides;
    
    public Die(byte diceSides) {
        this.diceSides = diceSides; 
    }

    private Random random = new Random();

    public int getDie() {
        return currentValueOfDie;
    }

    public void roll() {
        currentValueOfDie = (byte) (random.nextInt(diceSides) + 1);
        System.out.println("You rolled a " + currentValueOfDie);
    }

}

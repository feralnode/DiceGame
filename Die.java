import java.util.Random;

public class Die {

    byte currentValueofDie;

    byte diceSides;
    
    public Die(byte diceSides) {
        this.diceSides = diceSides; 
    }

    private Random random = new Random();

    public int getDie() {
        return currentValueofDie;
    }

    public void roll() {
        currentValueofDie = (byte) (random.nextInt(diceSides) + 1);
        System.out.println("You rolled a " + currentValueofDie);
    }

}

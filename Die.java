import java.util.Random;

public class Die {

    byte minSize = 1;

    byte diceSides;
    
    public Die(byte diceSides) {
        this.diceSides = diceSides; 
    }

    private Random random = new Random();

    public int getDie() {
        return diceSides;
    }

    public void roll() {
        int roll = random.nextInt(diceSides) + minSize;
        System.out.println("You rolled a " + roll);

    }

}

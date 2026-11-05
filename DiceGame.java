import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("""
            Hej och välkommen till tärningsspelet!
            Min första fråga är, vad heter du?
            """);
        
        String playerName = input.next();

        Player player = new Player(playerName);

        // Change this to player.getName()
        System.out.println("Hej " + playerName + "! Hur många rundor vill du spela?");

        byte numberOfRounds = input.nextByte();

        System.out.println("Du vill spela " + numberOfRounds + " rundor. Hur många sidor vill du att tärningen ska ha?");

        byte numberOfSides = input.nextByte();
        player.addDie(numberOfSides);

        System.out.println("Du har nu en tärning med " + player.die.diceSides + " sidor. Låt oss börja spela!");

        // We need to be able to handle what the player guess for number the die will roll.
        /*for (byte i = 0; i <= numberOfRounds; i++) {
            System.out.println("Runda " + (i + 1) + ":");
            player.die.roll();
            player.increaseScore();
            System.console().readLine(); // Wait for user input to continue to the next round
        }*/
    }
}

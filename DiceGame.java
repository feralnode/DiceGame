import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("""
            Hej och välkommen till Dice Game of Doom!

            Regler: \n

            Du får gissa vilket nummer tärningen landar på. Gissa rätt = poäng. Gissa fel = du får se vad som händer. \n

            Spelet fortsätter i ett antal rundor som du väljer. \n

            Vad heter du?
            """);
        
        String playerName = input.next();

        Player player = new Player(playerName);

        // Change this to player.getName()
        System.out.println("Hej " + playerName + "! Hur många rundor vill du spela?");

        byte numberOfRounds = input.nextByte();

        System.out.println("Du vill spela " + numberOfRounds + " rundor. Hur många sidor vill du att tärningen ska ha?");

        byte numberOfSides = input.nextByte();
        player.addDie(numberOfSides);

        System.out.println("Du har nu en tärning med " + numberOfSides + " sidor. Låt oss börja spela!");

        numberOfRoundsToPlay(numberOfRounds, player, numberOfSides);

        input.close();
    }

    static void numberOfRoundsToPlay(byte numberOfRounds, Player player, byte numberOfSides) {

        Scanner input = new Scanner(System.in);

        for (byte i = 1; i <= numberOfRounds; i++) {
            System.out.println("Runda " + i + ": Gissa vilket nummer tärningen kommer att visa (1-" + numberOfSides + "):");
            byte playerGuess = input.nextByte();
            // Roll the die by using players rollDice method.

            if (playerGuess == player.getDieValue()) {
                System.out.println("Grattis! Du gissade rätt! Du får extra kosmiska krafter som skyddar dig från felande kod och buggar i framtiden.");
                player.increaseScore();
            } else {
                System.out.println("Tyvärr, du gissade fel. Tärningen visade " + player.getDieValue() + ". Get good, noob.");
            }

            System.out.println("Tryck på Enter för att fortsätta till nästa runda.");
            System.console().readLine(); // Wait for user input to continue to the next round
        }
        
        input.close();
    }
}

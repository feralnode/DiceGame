import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("""
            Hej och välkommen till tärningsspelet!
            Spelreglerna är enkla: Du kommer att gissa vilket nummer tärningen kommer att visa när den kastas. Om du gissar rätt, får du poäng. Om du gissar fel, får du inga poäng. Spelet fortsätter i ett antal rundor som du väljer.
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
                System.out.println("Grattis! Du gissade rätt!");
                player.increaseScore();
            } else {
                System.out.println("Tyvärr, du gissade fel. Tärningen visade " + player.getDieValue() + ".");
            }

            System.out.println("Tryck på Enter för att fortsätta till nästa runda.");
            System.console().readLine(); // Wait for user input to continue to the next round
        }
        
        input.close();
    }
}

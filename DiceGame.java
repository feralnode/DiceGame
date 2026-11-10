
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("""
            Hej och välkommen till Dice Game of Doom!

            Regler:
            Du får gissa vilket nummer tärningen landar på. Gissa rätt = poäng. Gissa fel = du får se vad som händer.
            Spelet fortsätter i ett antal rundor som du väljer.

            Vad heter du?
            """);

        String playerName = input.next();

        Player player = new Player(playerName);

        // Change this to player.getName()
        System.out.println("Hej " + player.getName() + "! Hur många rundor vill du spela?");

        // Make sure no negative numbers are allowed for the number of rounds and number of sides.
        byte numberOfRounds;

        while (true) {
            if (input.hasNextByte()) {
                numberOfRounds = input.nextByte();

                if (numberOfRounds > 0) {
                    break;
                }

                System.out.println("Antalet rundor måste vara större än 0.");
            } else {
                System.out.println("Du måste ange ett heltal.");
                input.next(); // Discard invalid input
            }
        }

        // Should have a check to make sure the number of rounds is greater than 0 and it is not a string
        System.out.println("Du vill spela " + numberOfRounds + " rundor. Hur många sidor vill du att tärningen ska ha?");

        // Should have a check to make sure the number of sides is greater than 0 and it is not a string
        byte numberOfSides;

        while (true) {
            if (input.hasNextByte()) {
                numberOfSides = input.nextByte();

                if (numberOfSides > 0) {
                    break;
                }

                System.out.println("Antalet rundor måste vara större än 0.");
            } else {
                System.out.println("Du måste ange ett heltal.");
                input.next(); // Discard invalid input
            }
        }

        player.addDie(numberOfSides);

        System.out.println("Du har nu en tärning med " + numberOfSides + " sidor. Låt oss börja spela!");

        numberOfRoundsToPlay(numberOfRounds, player, numberOfSides, input);

        System.out.println("Spelet är slut! Du fick " + player.getScore() + " poäng. Tack för att du spelade!");

        input.close();
    }

    static void numberOfRoundsToPlay(byte numberOfRounds, Player player, byte numberOfSides, Scanner input) {

        for (int i = 1; i <= numberOfRounds; i++) {
            System.out.println("Runda " + i + ": Gissa vilket nummer tärningen kommer att visa (1-" + numberOfSides + "):");

            byte playerGuess;

            while (true) {
                if (input.hasNextByte()) {
                    playerGuess = input.nextByte();

                    if (playerGuess >= 1 && playerGuess <= numberOfSides) {
                        break;
                    }

                    System.out.println("Gissningen måste vara mellan 1 och " + numberOfSides + ". Försök igen.");
                } else {
                    System.out.println("Du måste ange ett giltigt heltal.");
                    input.next(); // Discard invalid input
                }
            }

            // Roll the die by using players rollDice method.
            player.rollDice();

            if (playerGuess == player.getDieValue()) {
                player.increaseScore();
                System.out.println("Grattis! Du gissade rätt! Du får extra kosmiska krafter som skyddar dig från felande kod och buggar i framtiden. Du har nu " + player.getScore() + " poäng.");
            } else {
                System.out.println("Tyvärr, du gissade fel. Tärningen visade " + player.getDieValue() + ". Get good, noob.");
            }

            if (i < numberOfRounds) {
                System.out.println("Tryck på Enter för att fortsätta till nästa runda.");
                input.nextLine(); // Consume leftover newline
                input.nextLine(); // Wait for user input to continue
            }
        }
    }
}

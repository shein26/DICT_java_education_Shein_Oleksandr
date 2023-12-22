import java.util.Random;
import java.util.Scanner;

public class Hangman {

    private static final String[] WORDS = {"python", "java", "javascript", "kotlin"};
    private static final int MAX_TRIES = 8;

    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in);

        while (true) {
            System.out.println("HANGMAN");
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: ");

            String choice = mainScanner.nextLine();

            if (choice.equals("exit")) {
                System.out.println("Goodbye, have a nice day!");
                break;
            } else if (choice.equals("play")) {
                playHangmanGame();
            } else {
                System.out.println("Invalid choice. Please enter \"play\" or \"exit\".");
            }
        }

        mainScanner.close();
    }

    private static void playHangmanGame() {
        Random random = new Random();
        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        boolean[] lettersGuessed = new boolean[26];
        int triesLeft = MAX_TRIES;

        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '-';
        }

        while (triesLeft > 0) {
            System.out.println("Word: " + new String(guessedWord));
            System.out.println("Tries left: " + triesLeft);
            System.out.print("Input a letter: ");

            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting the game...");
                return;
            }

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);

            if (lettersGuessed[guess - 'a']) {
                System.out.println("You've already guessed this letter.");
                continue;
            }

            lettersGuessed[guess - 'a'] = true;

            boolean letterFound = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    letterFound = true;
                }
            }

            if (!letterFound) {
                System.out.println("That letter doesn't appear in the word");
                triesLeft--;
            }

            if (wordGuessed(guessedWord)) {
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                break;
            }
        }

        if (triesLeft == 0) {
            System.out.println("You lost! The correct word was: " + wordToGuess);
        }
    }

    private static boolean wordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }
}

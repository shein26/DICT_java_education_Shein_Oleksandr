package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        // Етап 5: Гравець вгадує літери
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];  // Випадковий вибір слова

        // Створення підказки
        StringBuilder hint = new StringBuilder(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            hint.append("-");
        }

        // Змінні для кількості залишених спроб та введених букв
        int remainingAttempts = 8;
        StringBuilder guessedLetters = new StringBuilder();

        // Гравець вгадує літери
        while (remainingAttempts > 0) {
            System.out.println("Word: " + hint);
            System.out.println("Attempts left: " + remainingAttempts);
            System.out.print("Input a letter: ");
            Scanner scanner = new Scanner(System.in);
            char guessedLetter = scanner.nextLine().charAt(0);

            // Перевірка, чи буква вже вводилася
            if (guessedLetters.indexOf(String.valueOf(guessedLetter)) != -1) {
                System.out.println("You've already guessed this letter. Try another one.");
                continue;
            }

            guessedLetters.append(guessedLetter);

            // Перевірка, чи буква зустрічається в слові
            if (secretWord.indexOf(guessedLetter) != -1) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guessedLetter) {
                        hint.setCharAt(i, guessedLetter);
                    }
                }

                // Перевірка, чи слово повністю вгадане
                if (hint.toString().equals(secretWord)) {
                    System.out.println("Word: " + hint);
                    System.out.println("You survived!");
                    break;
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                remainingAttempts--;
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("Thanks for playing!");
            System.out.println("We'll see how well you did in the next stage");
        }
    }
}

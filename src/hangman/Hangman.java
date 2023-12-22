package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        // Етап 7: Перевірка на різні типи помилок та виправлення кількості спроб
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        StringBuilder hint = new StringBuilder(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            hint.append("-");
        }

        int remainingAttempts = 8;
        StringBuilder guessedLetters = new StringBuilder();

        while (remainingAttempts > 0) {
            System.out.println("Word: " + hint);
            System.out.println("Attempts left: " + remainingAttempts);
            System.out.print("Input a letter: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            // Перевірка, чи введена одна буква
            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char guessedLetter = input.charAt(0);

            // Перевірка, чи введено малу англійську букву
            if (!Character.isLowerCase(guessedLetter)) {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            // Перевірка, чи буква вже була введена
            if (guessedLetters.indexOf(String.valueOf(guessedLetter)) != -1) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            guessedLetters.append(guessedLetter);

            // Перевірка, чи буква зустрічається в слові
            if (secretWord.indexOf(guessedLetter) != -1) {
                boolean improvement = false;
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guessedLetter && hint.charAt(i) == '-') {
                        hint.setCharAt(i, guessedLetter);
                        improvement = true;
                    }
                }

                if (hint.toString().equals(secretWord)) {
                    System.out.println("Word: " + hint);
                    System.out.println("You guessed the word!");
                    System.out.println("You survived!");
                    break;
                }

                if (improvement) {
                    System.out.println("No improvements");
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                remainingAttempts--;
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("You lost!");
        }
    }
}

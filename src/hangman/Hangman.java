package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        // Етап 6: Кількість спроб обмежується кількістю помилок
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
                boolean improvement = false;
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guessedLetter && hint.charAt(i) == '-') {
                        hint.setCharAt(i, guessedLetter);
                        improvement = true;
                    }
                }

                // Перевірка, чи слово повністю вгадане
                if (hint.toString().equals(secretWord)) {
                    System.out.println("Word: " + hint);
                    System.out.println("You guessed the word!");
                    System.out.println("You survived!");
                    break;
                }

                // Вивід повідомлення про поліпшення, якщо буква відкрита
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

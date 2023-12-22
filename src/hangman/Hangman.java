package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        // Етап 4: Підказка для гравця (перші дві літери)
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];  // Випадковий вибір слова

        // Створення підказки
        StringBuilder hint = new StringBuilder(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            if (i < 2) {
                hint.append(secretWord.charAt(i));
            } else {
                hint.append("-");
            }
        }

        // Гравець вгадує слово з підказкою
        System.out.println("Guess the word " + hint + ": ");
        Scanner scanner = new Scanner(System.in);
        String guessedWord = scanner.nextLine();

        // Перевірка вгаданого слова
        if (guessedWord.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}

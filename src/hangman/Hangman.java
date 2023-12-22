package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        // Етап 3: Випадковий вибір слова зі списку
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];  // Випадковий вибір слова

        // Гравець вгадує слово
        System.out.println("Guess the word: ");
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

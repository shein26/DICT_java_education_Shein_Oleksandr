package Hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        // Етап 2: Вгадування слова
        System.out.println("Guess the word: ");
        Scanner scanner = new Scanner(System.in);
        String secretWord = "java";  // Загадане слово (можна змінити)

        // Введення гравцем слова
        String guessedWord = scanner.nextLine();

        // Перевірка вгаданого слова
        if (guessedWord.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}

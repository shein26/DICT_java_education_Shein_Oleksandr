import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        // Етап 1: Привітання та виведення інформації про бота
        String botName = "Chatty";  // Ваш вибір імені бота
        int birthYear = 2023;  // Поточний рік, може змінюватися в майбутньому

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");

        // Етап 2: Представлення та привітання користувача за ім'ям
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine();

        System.out.println("What a great name you have, " + userName + "!");

        // Зробіть коміт для позначення виконання другого етапу: "ChatBot 2-nd stage"
    }
}

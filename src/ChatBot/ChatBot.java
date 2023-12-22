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

        // Етап 3: Вгадування віку користувача
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5, and 7.");

        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        int userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");

        // Зробіть коміт для позначення виконання третього етапу: "ChatBot 3-rd stage"
    }
}

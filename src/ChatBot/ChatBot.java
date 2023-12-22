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

        // Етап 4: Підрахунок від 0 до введеного числа користувачем
        System.out.println("Now I will prove to you that I can count to any number you want!");
        int userInp = scanner.nextInt();

        for (int i = 1; i <= userInp; i++) {
            System.out.println(i + "!");
        }

        // Етап 5: Тест
        System.out.println("Let's test your programming knowledge.");
        System.out.println("What is the capital of France?");
        System.out.println("1. Madrid");
        System.out.println("2. Berlin");
        System.out.println("3. Paris");
        System.out.println("4. Rome");

        int correctAnswer = 3;

        while (true) {
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Congratulations! That's correct.");
                break;
            } else {
                System.out.println("Sorry, that's incorrect. Try again.");
            }
        }

        // Зробіть коміт для позначення виконання п'ятого етапу: "ChatBot 5-th stage"
        System.out.println("Goodbye, have a nice day!");
    }
}

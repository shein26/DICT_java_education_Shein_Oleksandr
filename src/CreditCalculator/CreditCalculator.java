package CreditCalculator;

import CalculatorLogic.CalculatorLogic;

import java.util.Scanner;

public class CreditCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читаємо параметри з командного рядка
        String type = System.getProperty("type");
        String principal = System.getProperty("principal");
        String periods = System.getProperty("periods");
        String interest = System.getProperty("interest");
        String payment = System.getProperty("payment");

        // Перевірка наявності всіх обов'язкових параметрів
        if (type == null || principal == null || periods == null || interest == null) {
            System.out.println("Incorrect parameters");
            return;
        }

        // Ініціалізуємо об'єкт калькулятора
        CalculatorLogic calculator = new CalculatorLogic();

        // Визначаємо, який тип розрахунку користувач обрав
        switch (type) {
            case "diff":
                calculator.calculateDifferentiatedPayments(Double.parseDouble(principal),
                        Integer.parseInt(periods),
                        Double.parseDouble(interest));
                break;
            case "annuity":
                // Перевірка наявності обов'язкового параметра
                if (payment == null) {
                    System.out.println("Incorrect parameters");
                    return;
                }
                calculator.calculateAnnuityPayment(Double.parseDouble(principal),
                        Integer.parseInt(periods),
                        Double.parseDouble(interest),
                        Double.parseDouble(payment));
                break;
            default:
                System.out.println("Incorrect parameters");
        }
    }
}

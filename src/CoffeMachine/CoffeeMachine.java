import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        makeCoffee();
    }

    public static void makeCoffee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int water = cups * 200;     // 200 ml of water per cup
        int milk = cups * 50;       // 50 ml of milk per cup
        int coffeeBeans = cups * 15; // 15 g of coffee beans per cup

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");

        scanner.close();
    }
}

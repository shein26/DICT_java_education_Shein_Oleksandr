import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");

            if (scanner.hasNext()) {
                String action = scanner.next();

                switch (action) {
                    case "buy":
                        buyCoffee(scanner);
                        break;
                    case "fill":
                        fillMachine(scanner);
                        break;
                    case "take":
                        takeMoney();
                        break;
                    case "remaining":
                        printRemaining();
                        break;
                    case "exit":
                        return; // Вихід з програми
                    default:
                        System.out.println("Invalid action. Try again.");
                        break;
                }
            }
        }
    }

    private static void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    makeCoffee(250, 0, 16, 4);
                    break;
                case 2:
                    makeCoffee(350, 75, 20, 7);
                    break;
                case 3:
                    makeCoffee(200, 100, 12, 6);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } else {
            System.out.println("Invalid choice. Try again.");
            scanner.next(); // Очистка буфера вводу
        }
    }

    private static void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= beansNeeded && disposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= beansNeeded;
            disposableCups--;
            money += cost;
        } else {
            System.out.println("Sorry, not enough resources to make coffee!");
        }
    }

    private static void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += scanner.nextInt();
    }

    private static void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    private static void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}

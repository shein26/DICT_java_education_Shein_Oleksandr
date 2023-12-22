import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        checkIngredients();
    }

    public static void checkIngredients() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int availableWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int availableCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        int waterForOneCup = 200;
        int milkForOneCup = 50;
        int coffeeBeansForOneCup = 15;

        int maxCupsWater = availableWater / waterForOneCup;
        int maxCupsMilk = availableMilk / milkForOneCup;
        int maxCupsCoffeeBeans = availableCoffeeBeans / coffeeBeansForOneCup;

        int maxCupsPossible = Math.min(Math.min(maxCupsWater, maxCupsMilk), maxCupsCoffeeBeans);

        if (maxCupsPossible >= cupsNeeded) {
            if (maxCupsPossible == cupsNeeded) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                int additionalCups = maxCupsPossible - cupsNeeded;
                System.out.println("Yes, I can make that amount of coffee (and even " + additionalCups + " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + maxCupsPossible + " cups of coffee");
        }

        scanner.close();
    }
}

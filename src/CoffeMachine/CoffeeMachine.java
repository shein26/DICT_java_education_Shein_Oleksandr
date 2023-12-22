import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private MachineState currentState;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
        this.currentState = MachineState.CHOOSING_ACTION;
    }

    public void processInput(String input) {
        switch (currentState) {
            case CHOOSING_ACTION:
                handleAction(input);
                break;
            case CHOOSING_COFFEE_TYPE:
                handleCoffeeType(input);
                break;
            case FILLING_WATER:
                fillWater(input);
                break;
            case FILLING_MILK:
                fillMilk(input);
                break;
            case FILLING_COFFEE_BEANS:
                fillCoffeeBeans(input);
                break;
            case FILLING_CUPS:
                fillCups(input);
                break;
        }
    }

    private void handleAction(String action) {
        switch (action) {
            case "buy":
                currentState = MachineState.CHOOSING_COFFEE_TYPE;
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                break;
            case "fill":
                currentState = MachineState.FILLING_WATER;
                System.out.println("Write how many ml of water you want to add:");
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printRemaining();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid action. Try again.");
                break;
        }
    }

    private void handleCoffeeType(String choice) {
        switch (choice) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                currentState = MachineState.CHOOSING_ACTION;
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }

    private void fillWater(String input) {
        water += Integer.parseInt(input);
        currentState = MachineState.FILLING_MILK;
        System.out.println("Write how many ml of milk you want to add:");
    }

    private void fillMilk(String input) {
        milk += Integer.parseInt(input);
        currentState = MachineState.FILLING_COFFEE_BEANS;
        System.out.println("Write how many grams of coffee beans you want to add:");
    }

    private void fillCoffeeBeans(String input) {
        coffeeBeans += Integer.parseInt(input);
        currentState = MachineState.FILLING_CUPS;
        System.out.println("Write how many disposable cups of coffee you want to add:");
    }

    private void fillCups(String input) {
        disposableCups += Integer.parseInt(input);
        currentState = MachineState.CHOOSING_ACTION;
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= beansNeeded && disposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= beansNeeded;
            disposableCups--;
            money += cost;
            currentState = MachineState.CHOOSING_ACTION;
        } else {
            System.out.println("Sorry, not enough resources to make coffee!");
            currentState = MachineState.CHOOSING_ACTION;
        }
    }

    private void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    private void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public enum MachineState {
        CHOOSING_ACTION,
        CHOOSING_COFFEE_TYPE,
        FILLING_WATER,
        FILLING_MILK,
        FILLING_COFFEE_BEANS,
        FILLING_CUPS
    }
}

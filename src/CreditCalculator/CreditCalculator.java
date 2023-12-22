import java.util.Scanner;

public class CreditCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the loan principal: ");
        double loanPrincipal = scanner.nextDouble();

        System.out.print("What do you want to calculate?\n" +
                "type \"m\" - for number of monthly payments,\n" +
                "type \"p\" - for the monthly payment:\n> ");
        char calculationType = scanner.next().charAt(0);

        if (calculationType == 'm') {
            System.out.print("Enter the monthly payment:\n> ");
            double monthlyPayment = scanner.nextDouble();
            calculateNumberOfMonths(loanPrincipal, monthlyPayment);
        } else if (calculationType == 'p') {
            System.out.print("Enter the number of months:\n> ");
            int numberOfMonths = scanner.nextInt();
            calculateMonthlyPayment(loanPrincipal, numberOfMonths);
        }
    }

    public static void calculateNumberOfMonths(double loanPrincipal, double monthlyPayment) {
        int numberOfMonths = (int) Math.ceil(loanPrincipal / monthlyPayment);
        System.out.println("It will take " + numberOfMonths + " months to repay the loan");
    }

    public static void calculateMonthlyPayment(double loanPrincipal, int numberOfMonths) {
        double monthlyPayment = loanPrincipal / numberOfMonths;
        int lastPayment = (int) (loanPrincipal - (numberOfMonths - 1) * monthlyPayment);

        System.out.println("Your monthly payment = " + monthlyPayment);
        System.out.println("The last payment = " + lastPayment);
    }
}

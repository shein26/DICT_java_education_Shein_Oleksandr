import java.util.Scanner;

public class CreditCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What do you want to calculate?\n" +
                "type \"n\" for number of monthly payments,\n" +
                "type \"a\" for annuity monthly payment amount,\n" +
                "type \"p\" for loan principal:\n> ");
        char calculationType = scanner.next().charAt(0);

        if (calculationType == 'n') {
            calculateNumberOfPayments();
        } else if (calculationType == 'a') {
            calculateAnnuityPayment();
        } else if (calculationType == 'p') {
            calculateLoanPrincipal();
        }
    }

    public static void calculateNumberOfPayments() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the loan principal:\n> ");
        double loanPrincipal = scanner.nextDouble();

        System.out.print("Enter the monthly payment:\n> ");
        double monthlyPayment = scanner.nextDouble();

        System.out.print("Enter the loan interest:\n> ");
        double interestRate = scanner.nextDouble();

        double nominalRate = interestRate / (12 * 100); // місячна процентна ставка
        double months = Math.ceil(Math.log(monthlyPayment / (monthlyPayment - nominalRate * loanPrincipal)) / Math.log(1 + nominalRate));
        int years = (int) months / 12;
        int remainingMonths = (int) months % 12;

        String result = (remainingMonths > 0)
                ? "It will take " + years + " years and " + remainingMonths + " months to repay this loan!"
                : "It will take " + years + " years to repay this loan!";
        System.out.println(result);
    }

    public static void calculateAnnuityPayment() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the loan principal:\n> ");
        double loanPrincipal = scanner.nextDouble();

        System.out.print("Enter the number of periods:\n> ");
        int numberOfPeriods = scanner.nextInt();

        System.out.print("Enter the loan interest:\n> ");
        double interestRate = scanner.nextDouble();

        double nominalRate = interestRate / (12 * 100); // місячна процентна ставка
        double annuityPayment = loanPrincipal * (nominalRate * Math.pow(1 + nominalRate, numberOfPeriods)) / (Math.pow(1 + nominalRate, numberOfPeriods) - 1);

        System.out.println("Your monthly payment = " + Math.ceil(annuityPayment) + "!");
    }

    public static void calculateLoanPrincipal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the annuity payment:\n> ");
        double annuityPayment = scanner.nextDouble();

        System.out.print("Enter the number of periods:\n> ");
        int numberOfPeriods = scanner.nextInt();

        System.out.print("Enter the loan interest:\n> ");
        double interestRate = scanner.nextDouble();

        double nominalRate = interestRate / (12 * 100); // місячна процентна ставка
        double loanPrincipal = annuityPayment / ((nominalRate * Math.pow(1 + nominalRate, numberOfPeriods)) / (Math.pow(1 + nominalRate, numberOfPeriods) - 1));

        System.out.println("Your loan principal = " + Math.ceil(loanPrincipal) + "!");
    }
}

package CalculatorLogic;

public class CalculatorLogic {

    public void calculateDifferentiatedPayments(double principal, int periods, double interest) {
        double totalPayments = 0;
        for (int i = 1; i <= periods; i++) {
            double interestPayment = (principal * interest * i) / 12 / 100;
            double monthlyPayment = principal / periods + interestPayment;

            System.out.println("Month " + i + ": payment is " + Math.round(monthlyPayment));
            totalPayments += monthlyPayment;
        }
        double overpayment = totalPayments - principal;
        System.out.println("Overpayment = " + Math.round(overpayment));
    }

    public void calculateAnnuityPayment(double principal, int periods, double interest, double payment) {
        double nominalInterestRate = interest / 12 / 100;
        double annuityPayment = principal * (nominalInterestRate * Math.pow(1 + nominalInterestRate, periods))
                / (Math.pow(1 + nominalInterestRate, periods) - 1);

        System.out.println("Your annuity payment = " + Math.round(annuityPayment));
    }
}

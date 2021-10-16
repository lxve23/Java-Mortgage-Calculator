import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        int principal;
        double annualInterestRate;
        double monthlyInterestRate;
        byte years;
        int totalPayments;

        while (true) {
            System.out.print("Principal (1,000 - $1,000,000): ");
            principal = input.nextInt();
            if (principal < 1_000 || principal > 1_000_000) {
                System.out.println("Invalid input");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Annual Interest Rate (1 - 30%): ");
            annualInterestRate = input.nextDouble();
            if (annualInterestRate < 1 || annualInterestRate > 30) {
                System.out.println("Invalid input");
                continue;
            }
            monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
            break;
        }

        while (true) {
            System.out.print("Years (1 - 30): ");
            years = input.nextByte();
            if (years < 1 || years > 30) {
                System.out.println("Invalid input");
                continue;
            }
            totalPayments = years * MONTHS_IN_YEAR;
            break;
        }

        double mortgage = principal
                        * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalPayments)
                        / (Math.pow(1 + monthlyInterestRate, totalPayments) - 1));

        System.out.println("Your mortgage is " + NumberFormat.getCurrencyInstance().format(mortgage) + " per month");
        input.close();
    }
}
import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        int principal;
        float annualInterestRate;
        float monthlyInterestRate;
        byte years;
        short totalPayments;

        while (true) {
            try {
                System.out.print("Principal (1,000 - $1,000,000): ");
                principal = Integer.parseInt(input.nextLine().replaceAll("[$,]", ""));
                if (principal < 1_000 || principal > 1_000_000) {
                    System.out.println("Principal must be between $1,000 and $1,000,000");
                    continue;
                }
                break;
            }
            catch (NumberFormatException e) {
                System.err.println("Did not input an integer");
            }
        }

        while (true) {
            try {
                System.out.print("Annual Interest Rate (1 - 30%): ");
                annualInterestRate = Float.parseFloat(input.nextLine().replaceAll("[%]", ""));
                if (annualInterestRate < 1 || annualInterestRate > 30) {
                    System.out.println("Interest Rate must be between 1.00% and 30.00%");
                    continue;
                }
                monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            catch (NumberFormatException e) {
                System.err.println("Did not input a number");
            }
        }

        while (true) {
            try {
                System.out.print("Years (1 - 30): ");
                years = Byte.parseByte(input.nextLine());
                if (years < 1 || years > 30) {
                    System.out.println("Years must be between 1 and 30 years");
                    continue;
                }
                totalPayments = (short) (years * MONTHS_IN_YEAR);
                break;
            }
            catch (NumberFormatException e) {
                System.err.println("Did not input an integer");
            }
  break;
nthlyInterestRate, totalPayments)
                        / (Math.pow(1 + monthlyInterestRate, totalPayments) - 1));

        System.out.println("Your mortgage is " + NumberFormat.getCurrencyInstance().format(mortgage) + " per month");
        input.close();
    }
}
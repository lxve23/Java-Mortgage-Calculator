import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        int principal;
        double annualInterestRate;
        double monthlyInterestRate;
        byte years;
        int totalPayments;

        System.out.print("Principal $1,000 - $1,000,000: ");
        principal = input.nextInt();

        System.out.print("Annual Interest Rate: ");
        annualInterestRate = input.nextDouble();
        monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Years: ");
        years = input.nextByte();
        totalPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                        * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalPayments)
                        / (Math.pow(1 + monthlyInterestRate, totalPayments) - 1));

        System.out.println("Your mortgage is " + NumberFormat.getCurrencyInstance().format(mortgage));
        input.close();
    }
}
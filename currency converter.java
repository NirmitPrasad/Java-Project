import java.util.Scanner;

public class CurrencyConverter {

    // Sample exchange rates (for demonstration purposes)
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.72;
    private static final double EUR_TO_USD = 1.18;
    private static final double GBP_TO_USD = 1.39;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");
        System.out.println("Available currencies: USD, EUR, GBP");

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (e.g., USD): ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        double result = convertCurrency(amount, sourceCurrency, targetCurrency);
        if (result != -1) {
            System.out.printf("%.2f %s = %.2f %s\n", amount, sourceCurrency, result, targetCurrency);
        } else {
            System.out.println("Invalid currency pair or amount.");
        }

        scanner.close();
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        double result = -1;

        // Perform currency conversion based on exchange rates
        switch (sourceCurrency) {
            case "USD":
                switch (targetCurrency) {
                    case "EUR":
                        result = amount * USD_TO_EUR;
                        break;
                    case "GBP":
                        result = amount * USD_TO_GBP;
                        break;
                }
                break;
            case "EUR":
                switch (targetCurrency) {
                    case "USD":
                        result = amount * EUR_TO_USD;
                        break;
                }
                break;
            case "GBP":
                switch (targetCurrency) {
                    case "USD":
                        result = amount * GBP_TO_USD;
                        break;
                }
                break;
        }

        return result;
    }
}

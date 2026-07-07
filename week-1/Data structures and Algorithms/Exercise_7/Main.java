public class Main {
    public static void main(String[] args) {
        double startingCapital = 1000.0; // $1,000 Present Value
        double annualRate = 0.05;        // 5% growth rate
        int yearsToForecast = 10;        // Forecast for 10 years

        System.out.println("--- Financial Forecasting Tool ---");
        System.out.printf("Initial Investment: $%.2f%n", startingCapital);
        System.out.printf("Assumed Growth Rate: %.1f%%%n", (annualRate * 100));
        System.out.println("Forecasting Period: " + yearsToForecast + " years\n");

        // Execute prediction
        double futureValue = FinancialForecasting.calculateFutureValue(startingCapital, annualRate, yearsToForecast);

        System.out.printf("Predicted Future Value: $%.2f%n", futureValue);
    }
}
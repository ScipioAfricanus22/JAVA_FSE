public class FinancialForecasting {

    /**
     * Calculates future value using a direct recursive approach.
     * @param presentValue The starting capital (PV)
     * @param growthRate The constant growth rate (e.g., 0.05 for 5%)
     * @param periods The number of years/periods to forecast (n)
     * @return The predicted future value
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // 1. Base Case: If no time has passed, value remains the same.
        if (periods <= 0) {
            return presentValue;
        }

        // 2. Recursive Case: FV = FV(periods - 1) * (1 + growthRate)
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }
}
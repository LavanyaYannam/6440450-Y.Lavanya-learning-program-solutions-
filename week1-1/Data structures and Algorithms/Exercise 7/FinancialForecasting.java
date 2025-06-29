public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double futureValue(double presentValue, double rate, int years) {
        // Base case: 0 years means value stays the same
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: calculate for one less year
        return (1 + rate) * futureValue(presentValue, rate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 10000;  // ₹10,000 initial investment
        double annualGrowthRate = 0.08;  // 8% growth
        int years = 5;

        double forecastedValue = futureValue(presentValue, annualGrowthRate, years);
        System.out.printf("Future value after %d years: ₹%.2f%n", years, forecastedValue);
    }
}

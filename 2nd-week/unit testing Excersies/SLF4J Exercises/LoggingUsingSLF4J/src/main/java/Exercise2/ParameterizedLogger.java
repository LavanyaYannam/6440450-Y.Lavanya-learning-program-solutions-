package Exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogger {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogger.class);

    public static void main(String[] args) {
        String username = "Lavanya";
        int items = 5;
        double price = 249.75;

        logger.info("User {} purchased {} items for ${}", username, items, price);
        logger.warn("Stock for {} is running low", items);
        logger.error("Payment failed for user {}", username);
    }
}


package HandsOn3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingDemo.class);

    public void displayDate() {
        LOGGER.info("START");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LOGGER.debug("This is a debug log test");

        try {
            Date date = sdf.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Date parsing failed", e);
        }

        LOGGER.info("END");
    }

    public static void main(String[] args) {
        LoggingDemo obj = new LoggingDemo();
        obj.displayDate();
    }
}

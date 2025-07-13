package HandsOn5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringScopeDemoApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringScopeDemoApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            Country country1 = context.getBean("country", Country.class);
            Country country2 = context.getBean("country", Country.class);

            LOGGER.debug("country1 hashcode: {}", country1.hashCode());
            LOGGER.debug("country2 hashcode: {}", country2.hashCode());
            LOGGER.debug("country1 == country2: {}", (country1 == country2));
        }
        LOGGER.info("END");
    }
}

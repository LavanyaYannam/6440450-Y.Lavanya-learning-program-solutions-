package HandsOn67;
import HandsOn67.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START getCountryIndia");
        ApplicationContext context = new ClassPathXmlApplicationContext("country1.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.info("END getCountryIndia");
        return country;
    }
}

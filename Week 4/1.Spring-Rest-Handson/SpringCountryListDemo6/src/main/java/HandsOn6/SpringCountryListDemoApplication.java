package HandsOn6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringCountryListDemoApplication {

    public static void main(String[] args) {
        System.out.println("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
        List<Country> countries = (List<Country>) context.getBean("countryList");

        for (Country c : countries) {
            System.out.println(c);
        }

        System.out.println("END");
        
    }
}

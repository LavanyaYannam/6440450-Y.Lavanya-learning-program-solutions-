package HandsOn2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDateFormatLoader {

    public static void displayDate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

        // Get SimpleDateFormat bean
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        
        try {
            // Parse and display the date
            Date parsedDate = format.parse("31/12/2018");
            System.out.println("Parsed Date: " + parsedDate);
        } catch (Exception e) {
            System.out.println("Date parsing failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        displayDate();
    }
}

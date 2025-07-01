
package Exercise1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Exercise1.BookService;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the bookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Call service method
        bookService.addBook("Spring Framework Essentials");

        ((ClassPathXmlApplicationContext) context).close();
    }
}

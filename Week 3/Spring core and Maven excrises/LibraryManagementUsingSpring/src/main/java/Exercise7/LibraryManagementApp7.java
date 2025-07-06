package Exercise7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp7 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext7.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook("Constructor and Setter Injection in Spring");

        ((ClassPathXmlApplicationContext) context).close();
    }
}

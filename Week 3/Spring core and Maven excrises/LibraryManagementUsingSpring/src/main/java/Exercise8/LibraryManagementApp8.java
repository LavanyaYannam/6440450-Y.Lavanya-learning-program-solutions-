package Exercise8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp8 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext8.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        bookService.addBook("Spring AOP Simplified");

        ((ClassPathXmlApplicationContext) context).close();
    }
}

package exercise3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        bookService.addBook("Spring AOP in Action");

        ((ClassPathXmlApplicationContext) context).close();
    }
}

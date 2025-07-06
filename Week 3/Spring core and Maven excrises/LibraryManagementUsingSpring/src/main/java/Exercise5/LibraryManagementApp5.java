package Exercise5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp5 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext5.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        bookService.addBook("Java in Depth");

        ((ClassPathXmlApplicationContext) context).close();
    }
}

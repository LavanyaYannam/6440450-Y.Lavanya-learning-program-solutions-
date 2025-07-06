package exercise2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        bookService.addBook("Digital Nuture JavaFSE");

        ((ClassPathXmlApplicationContext) context).close();
    }
}

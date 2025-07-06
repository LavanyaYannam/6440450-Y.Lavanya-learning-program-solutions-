package Exercise6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp6 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext6.xml");

        BookService bookService = context.getBean(BookService.class);
        bookService.addBook("Spring with Annotations");

        ((ClassPathXmlApplicationContext) context).close();
    }
}

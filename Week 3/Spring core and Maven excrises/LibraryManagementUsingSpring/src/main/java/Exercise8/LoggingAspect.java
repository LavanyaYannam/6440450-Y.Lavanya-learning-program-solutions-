package Exercise8;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect
public class LoggingAspect {

    @Before("execution(* Exercise8.BookService.addBook(..))")
    public void beforeAddBook() {
        System.out.println("[AOP] Before addBook() method...");
    }

    @After("execution(* Exercise8.BookService.addBook(..))")
    public void afterAddBook() {
        System.out.println("[AOP] After addBook() method...");
    }
}

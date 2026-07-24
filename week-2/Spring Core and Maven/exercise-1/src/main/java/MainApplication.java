

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        // 1. Load the Spring XML configuration file from the classpath
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Retrieve the configured BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // 3. Call the method to test if dependency injection succeeded
        bookService.saveBook();
    }
}
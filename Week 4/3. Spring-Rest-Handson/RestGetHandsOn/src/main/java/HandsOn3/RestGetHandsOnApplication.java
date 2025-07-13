package HandsOn3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:employee2.xml")
public class RestGetHandsOnApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestGetHandsOnApplication.class, args);
    }
}

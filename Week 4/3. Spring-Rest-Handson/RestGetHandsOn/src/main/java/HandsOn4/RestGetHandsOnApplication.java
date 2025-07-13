package HandsOn4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:department.xml"}) // Add here
public class RestGetHandsOnApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestGetHandsOnApplication.class, args);
    }
}

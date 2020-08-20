package graphql.error;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ErrorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErrorApplication.class, args);
    }

}

package be.avidoo.application;

import be.avidoo.rest.InputAdapterConfiguration;
import be.avidoo.usecase.UseCaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        InputAdapterConfiguration.class,
        UseCaseConfiguration.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

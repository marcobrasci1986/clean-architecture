package be.avidoo.application;

import be.avidoo.jpa.JpaOutputAdapterConfiguration;
import be.avidoo.rest.RestInputAdapterConfiguration;
import be.avidoo.usecase.UseCaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        UseCaseConfiguration.class,
        // Input Adapters
        RestInputAdapterConfiguration.class,
        // Output Adapters
        JpaOutputAdapterConfiguration.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

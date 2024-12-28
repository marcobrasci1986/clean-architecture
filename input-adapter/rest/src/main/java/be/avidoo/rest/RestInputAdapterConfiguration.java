package be.avidoo.rest;

import be.avidoo.usecase.UseCaseConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import({UseCaseConfiguration.class})
public class RestInputAdapterConfiguration {
}

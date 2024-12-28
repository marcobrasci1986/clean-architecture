package be.avidoo.usecase;

import be.avidoo.core.common.CommonConfiguration;
import be.avidoo.core.common.command.CommandBus;
import be.avidoo.core.common.command.CommandHandlerRegistry;
import be.avidoo.core.common.command.DefaultCommandBus;
import be.avidoo.core.common.domainevents.DefaultDomainEventBus;
import be.avidoo.core.common.domainevents.DomainEventBus;
import be.avidoo.core.common.domainevents.DomainEventHandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({CommonConfiguration.class})
public class UseCaseConfiguration {

    /**
     * TODO Add Tx TransactionProvider transactionProvider,
     *
     * @param commandHandlerRegistry
     * @return
     */
    @Bean
    public CommandBus commandBus(
            CommandHandlerRegistry commandHandlerRegistry
    ) {
        return new DefaultCommandBus(commandHandlerRegistry);
    }

    @Bean
    public DomainEventBus domainEventBus(
            DomainEventHandlerRegistry domainEventHandlerRegistry
    ) {
        return new DefaultDomainEventBus(domainEventHandlerRegistry);
    }
}

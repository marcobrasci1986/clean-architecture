package be.avidoo.usecase;

import be.avidoo.core.common.CommonConfiguration;
import be.avidoo.core.common.command.CommandBus;
import be.avidoo.core.common.command.CommandHandlerRegistry;
import be.avidoo.core.common.command.DefaultCommandBus;
import be.avidoo.core.common.command.TransactionalCommandBus;
import be.avidoo.core.common.domainevents.DefaultDomainEventBus;
import be.avidoo.core.common.domainevents.DomainEventBus;
import be.avidoo.core.common.domainevents.DomainEventHandlerRegistry;
import be.avidoo.core.common.domainevents.TransactionalDomainEventBus;
import be.avidoo.core.common.transactoin.TransactionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({CommonConfiguration.class})
public class UseCaseConfiguration {

    @Bean
    public CommandBus commandBus(
            CommandHandlerRegistry commandHandlerRegistry,
            TransactionProvider transactionProvider
    ) {
        DefaultCommandBus commandBus = new DefaultCommandBus(commandHandlerRegistry);
        return new TransactionalCommandBus(transactionProvider, commandBus);
    }

    @Bean
    public DomainEventBus domainEventBus(
            DomainEventHandlerRegistry domainEventHandlerRegistry,
            TransactionProvider transactionProvider
    ) {
        DefaultDomainEventBus domainEventBus = new DefaultDomainEventBus(domainEventHandlerRegistry);
        return new TransactionalDomainEventBus(domainEventBus, transactionProvider);
    }
}

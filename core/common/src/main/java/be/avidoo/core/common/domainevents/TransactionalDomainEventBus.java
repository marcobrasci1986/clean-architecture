package be.avidoo.core.common.domainevents;

import be.avidoo.core.common.transactoin.TransactionProvider;

public class TransactionalDomainEventBus implements DomainEventBus {
    private final DomainEventBus delegate;
    private final TransactionProvider transactionProvider;

    public TransactionalDomainEventBus(DomainEventBus delegate, TransactionProvider transactionProvider) {
        this.delegate = delegate;
        this.transactionProvider = transactionProvider;
    }

    @Override
    public void send(DomainEventMessage domainEventMessage) {
        transactionProvider.runInTransaction(() -> delegate.send(domainEventMessage));
    }
}

package be.avidoo.core.common.command;

import be.avidoo.core.common.transactoin.TransactionProvider;

public class TransactionalCommandBus implements CommandBus {
    private final TransactionProvider transactionProvider;
    private final CommandBus delegate;

    public TransactionalCommandBus(TransactionProvider transactionProvider, CommandBus delegate) {
        this.transactionProvider = transactionProvider;
        this.delegate = delegate;
    }

    @Override
    public <C extends Command<T>, T> T execute(CommandMessage<C> commandMessage) {
        return transactionProvider.runInTransaction(() -> delegate.execute(commandMessage));
    }
}

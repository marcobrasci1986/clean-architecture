package be.avidoo.core.common.query;

import be.avidoo.core.common.transactoin.TransactionProvider;

public class TransactionalQueryBus implements QueryBus {
    private final QueryBus delegate;
    private final TransactionProvider transactionProvider;

    public TransactionalQueryBus(QueryBus delegate, TransactionProvider transactionProvider) {
        this.delegate = delegate;
        this.transactionProvider = transactionProvider;
    }

    @Override
    public <Q extends Query<T>, T> T query(QueryMessage<Q> queryMessage) {
        return transactionProvider.runInTransaction(() -> delegate.query(queryMessage));
    }
}

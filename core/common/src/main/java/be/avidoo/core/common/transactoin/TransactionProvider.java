package be.avidoo.core.common.transactoin;

import java.util.function.Supplier;

/**
 * Port for transactions handling of commands and queries
 */
public interface TransactionProvider {
    <T> T runInTransaction(Supplier<T> supplier);

    void runInTransaction(Runnable runnable);

    void runInNewTransaction(Runnable runnable);
}

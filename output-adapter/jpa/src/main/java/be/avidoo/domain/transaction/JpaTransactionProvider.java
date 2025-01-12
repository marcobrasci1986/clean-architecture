
package be.avidoo.domain.transaction;

import be.avidoo.core.common.transactoin.TransactionProvider;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Component
public class JpaTransactionProvider implements TransactionProvider {

    @Override
    @Transactional
    public <T> T runInTransaction(Supplier<T> supplier) {
        return supplier.get();
    }

    @Override
    @Transactional
    public void runInTransaction(Runnable runnable) {
        runnable.run();
    }

    @Override
    @Transactional(propagation = REQUIRES_NEW)
    public void runInNewTransaction(Runnable runnable) {
        runnable.run();
    }
}

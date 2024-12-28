
package be.avidoo.core.common.query;

public interface QueryHandler<Q extends Query<T>, T> {

    default T handle(QueryMessage<Q> queryMessage) {
        return handle(queryMessage.getQuery());
    }

    default T handle(Q query) {
        return null;
    }

    Class<Q> getQueryClass();
}

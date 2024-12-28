package be.avidoo.core.common.query;

import static be.avidoo.core.common.query.QueryMessage.queryMessage;

public interface QueryBus {

    default <T> T query(Query<T> query) {
        return query(queryMessage(query));
    }

    <Q extends Query<T>, T> T query(QueryMessage<Q> queryMessage);

}

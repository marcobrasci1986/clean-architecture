package be.avidoo.core.common.query;

public class DefaultQueryBus implements QueryBus {
    private final QueryHandlerRegistry queryHandlerRegistry;

    public DefaultQueryBus(QueryHandlerRegistry queryHandlerRegistry) {
        this.queryHandlerRegistry = queryHandlerRegistry;
    }

    @Override
    public <Q extends Query<T>, T> T query(QueryMessage<Q> queryMessage) {
        Query<T> query = queryMessage.getQuery();
        return queryHandlerRegistry.findByQuery(query).handle((QueryMessage<Query<T>>) queryMessage);
    }
}

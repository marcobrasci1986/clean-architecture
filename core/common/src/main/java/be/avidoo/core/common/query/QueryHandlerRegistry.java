package be.avidoo.core.common.query;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Component
public class QueryHandlerRegistry {

    @SafeVarargs
    public static QueryHandlerRegistry of(QueryHandler<? extends Query<?>, ?>... queryHandlers) {
        return new QueryHandlerRegistry(List.of(queryHandlers));
    }

    private final Map<Class<? extends Query<?>>, QueryHandler<? extends Query<?>, ?>> queryHandlerByQueryClass;

    private QueryHandlerRegistry(List<QueryHandler<? extends Query<?>, ?>> queryHandlers) {
        this.queryHandlerByQueryClass = queryHandlers.stream()
                .collect(toMap(QueryHandler::getQueryClass, identity()));
    }

    @SuppressWarnings("unchecked")
    public <T> QueryHandler<Query<T>, T> findByQuery(Query<T> query) {
        return queryHandlerByQueryClass.entrySet()
                .stream()
                .filter(entry -> entry.getKey().isAssignableFrom(query.getClass()))
                .map(entry -> (QueryHandler<Query<T>, T>) entry.getValue())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No query handler of type " + query));
    }

}

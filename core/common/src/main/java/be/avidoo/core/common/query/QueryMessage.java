
package be.avidoo.core.common.query;

import java.time.LocalDateTime;
import java.util.Optional;

public class QueryMessage<Q extends Query<?>> {

    private final Q query;
    private final LocalDateTime tijdstip;
    private final Object response;

    public QueryMessage(Q query, LocalDateTime tijdstip, Object response) {
        this.query = query;
        this.tijdstip = Optional.ofNullable(tijdstip).orElse(LocalDateTime.now());
        this.response = response;
    }

    public static <Q extends Query<T>, T> QueryMessage<Q> queryMessage(Q query) {
        return new QueryMessageBuilder<Q>().withQuery(query).build();
    }

    public static <Q extends Query<?>> QueryMessageBuilder<Q> builder() {
        return new QueryMessageBuilder<>();
    }

    public Q getQuery() {
        return query;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public Object getResponse() {
        return response;
    }

    public static final class QueryMessageBuilder<Q extends Query<?>> {
        private Q query;
        private LocalDateTime tijdstip;
        private Object response;

        private QueryMessageBuilder() {
        }

        public QueryMessageBuilder<Q> withQuery(Q query) {
            this.query = query;
            return this;
        }

        public QueryMessageBuilder<Q> withTijdstip(LocalDateTime tijdstip) {
            this.tijdstip = tijdstip;
            return this;
        }

        public QueryMessageBuilder<Q> withResponse(Object response) {
            this.response = response;
            return this;
        }

        public QueryMessage<Q> build() {
            return new QueryMessage<>(query, tijdstip, response);
        }
    }
}

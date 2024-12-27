/*-
 * #%L
 * IFG Dossierbeheersysteem
 * %%
 * Copyright (C) 2023 Vlaamse Overheid
 * %%
 * Licensed under the EUPL, Version 1.2 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * #L%
 */

package be.avidoo.core.common.domainevents;

import be.avidoo.core.common.domainevents.model.DomainEvent;

import java.time.LocalDateTime;

public class DomainEventMessage {

    private final DomainEvent domainEvent;
    private final LocalDateTime tijdstip;

    public DomainEventMessage(DomainEvent domainEvent, LocalDateTime tijdstip
    ) {
        this.domainEvent = domainEvent;
        this.tijdstip = tijdstip == null ? LocalDateTime.now() : tijdstip;
    }

    public static DomainEventMessage domainEventMessage(DomainEvent domainEvent) {
        return DomainEventMessage.builder()
                .withDomainEvent(domainEvent)
                .withTijdstip(domainEvent.getTijdstip())
                .build();
    }

    public static DomainEventMessageBuilder builder() {
        return new DomainEventMessage.DomainEventMessageBuilder();
    }

    public DomainEvent getDomainEvent() {
        return domainEvent;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public static final class DomainEventMessageBuilder {
        private DomainEvent domainEvent;
        private LocalDateTime tijdstip;

        private DomainEventMessageBuilder() {
        }

        public DomainEventMessageBuilder withDomainEvent(DomainEvent domainEvent) {
            this.domainEvent = domainEvent;
            return this;
        }

        public DomainEventMessageBuilder withTijdstip(LocalDateTime tijdstip) {
            this.tijdstip = tijdstip;
            return this;
        }

        public DomainEventMessage build() {
            return new DomainEventMessage(domainEvent, tijdstip);
        }
    }
}

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

package be.avidoo.core.common.command;

import be.avidoo.core.common.aggregate.AggregateRoot;
import be.avidoo.core.common.domainevents.DomainEventBus;
import be.avidoo.core.common.entity.EntityId;

/**
 * Every command handler should use this as the base class. It provides a method to publish the events registered in the Aggregate Root.
 *
 * @param <A> Aggregate Root
 * @param <C> Command Object
 * @param <T> Return Value
 */
public abstract class BaseCommandHandler<A extends AggregateRoot<? extends EntityId>, C extends Command<T>, T> implements CommandHandler<C, T> {

    protected final DomainEventBus domainEventBus;

    protected BaseCommandHandler(DomainEventBus domainEventBus) {
        this.domainEventBus = domainEventBus;
    }

    protected void handleEvents(A aggregateRoot) {
        aggregateRoot.getEvents().forEach(domainEventBus::send);
        aggregateRoot.clearEvents();
    }
}

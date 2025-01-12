package be.avidoo.domain.dossier;

import java.util.Optional;
import java.util.UUID;

public interface DossierRepository {

    UUID save(DossierAggregate dossier);

    Optional<DossierAggregate> findByDossierId(UUID dossierId);
}

package be.avidoo.outputport;

import be.avidoo.domain.aggregate.dossier.Dossier;
import be.avidoo.domain.aggregate.dossier.DossierId;

import java.util.Optional;

public interface DossierRepository {

    DossierId save(Dossier dossier);

    Optional<Dossier> findByDossierId(DossierId dossierId);
}

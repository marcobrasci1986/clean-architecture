package be.avidoo.outputport;

import be.avidoo.core.dossier.Dossier;
import be.avidoo.core.dossier.DossierId;

import java.util.Optional;

public interface DossierRepository {
    void save(Dossier dossier);

    Optional<Dossier> findByDossierId(DossierId dossierId);
}

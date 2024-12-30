package be.avidoo.outputport;

import be.avidoo.domain.aggregate.dossier.Dossier;
import be.avidoo.domain.aggregate.dossier.DossierId;
import be.avidoo.domain.aggregate.dossier.PolitiezoneId;

import java.util.Optional;

public interface DossierRepository {

    DossierId save(Dossier dossier);

    void updatePolitiezone(Dossier dossier, PolitiezoneId politiezoneId);

    Optional<Dossier> findByDossierId(DossierId dossierId);
}

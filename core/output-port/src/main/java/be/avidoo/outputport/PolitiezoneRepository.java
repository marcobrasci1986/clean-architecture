package be.avidoo.outputport;

import be.avidoo.domain.aggregate.dossier.Politiezone;
import be.avidoo.domain.aggregate.dossier.PolitiezoneId;

import java.util.List;
import java.util.Optional;

public interface PolitiezoneRepository {

    Optional<Politiezone> findByPolitiezoneId(PolitiezoneId dossierId);

    List<Politiezone> findByPolitiezones();
}

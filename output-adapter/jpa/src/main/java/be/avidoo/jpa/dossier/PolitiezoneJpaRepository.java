package be.avidoo.jpa.dossier;

import be.avidoo.domain.aggregate.dossier.Politiezone;
import be.avidoo.domain.aggregate.dossier.PolitiezoneId;
import be.avidoo.outputport.PolitiezoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PolitiezoneJpaRepository implements PolitiezoneRepository {

    private final PolitiezoneSpringRepository repository;

    @Override
    public Optional<Politiezone> findByPolitiezoneId(PolitiezoneId politiezoneId) {
        return repository.findById(politiezoneId.getValue()).map(this::mapToPolitiezone);
    }

    @Override
    public List<Politiezone> findByPolitiezones() {
        return repository.findAll().stream().map(this::mapToPolitiezone).toList();
    }

    private Politiezone mapToPolitiezone(PolitiezoneJpaEntity jpaEntity) {
        return Politiezone.PolitiezoneBuilder.aPolitiezone()
                .withPolitiezoneId(PolitiezoneId.politiezoneId(jpaEntity.getId()))
                .withZone(jpaEntity.getZone())
                .build();
    }
}

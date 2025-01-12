package be.avidoo.domain.dossier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DossierJpaRepository implements DossierRepository {

    private final DossierSpringRepository repository;

    @Override
    public UUID save(DossierAggregate dossier) {
        DossierJpaEntity dossierJpaEntity = DossierJpaEntity.builder()
                .id(dossier.getId())
                .dossiernummer(dossier.getDossiernummer())
                .datumCreatie(LocalDateTime.now())
                .datumLaatsteWijziging(LocalDateTime.now())
                .status("DOSSIEROPBOUW")
                .build();

        DossierJpaEntity savedDossierEntity = repository.save(dossierJpaEntity);
        return savedDossierEntity.getId();
    }

    @Override
    public Optional<DossierAggregate> findByDossierId(UUID dossierId) {
        return repository.findById(dossierId)
                .map(this::mapToDossier);
    }

    private DossierAggregate mapToDossier(DossierJpaEntity dossierJpaEntity) {
        return DossierAggregate.builder()
                .withId(dossierJpaEntity.getId())
                .withStatus(dossierJpaEntity.getStatus())
                .withDossiernummer(dossierJpaEntity.getDossiernummer())
                .withDatumCreatie(dossierJpaEntity.getDatumCreatie())
                .withDatumLaatsteWijziging(dossierJpaEntity.getDatumLaatsteWijziging())
                .build();
    }


}

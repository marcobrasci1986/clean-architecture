package be.avidoo.jpa.dossier;

import be.avidoo.domain.aggregate.dossier.Dossier;
import be.avidoo.domain.aggregate.dossier.DossierId;
import be.avidoo.domain.aggregate.dossier.DossierStatus;
import be.avidoo.domain.aggregate.dossier.Dossiernummer;
import be.avidoo.outputport.DossierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DossierJpaRepository implements DossierRepository {

    private final DossierSpringRepository repository;

    @Override
    public DossierId save(Dossier dossier) {
        DossierJpaEntity dossierJpaEntity = DossierJpaEntity.builder()
                .id(dossier.getId().getValue())
                .dossiernummer(dossier.getDossiernummer().getValue())
                .datumCreatie(LocalDateTime.now())
                .datumLaatsteWijziging(LocalDateTime.now())
                .status(DossierStatus.DOSSIEROPBOUW)
                .build();

        DossierJpaEntity savedDossierEntity = repository.save(dossierJpaEntity);
        return DossierId.dossierId(savedDossierEntity.getId());
    }

    @Override
    public Optional<Dossier> findByDossierId(DossierId dossierId) {
        return repository.findById(dossierId.getValue())
                .map(this::mapToDossier);
    }

    private Dossier mapToDossier(DossierJpaEntity dossierJpaEntity) {
        return Dossier.builder()
                .withId(DossierId.dossierId(dossierJpaEntity.getId()))
                .withStatus(dossierJpaEntity.getStatus())
                .withDossiernummer(Dossiernummer.dossiernummer(dossierJpaEntity.getDossiernummer()))
                .withDatumCreatie(dossierJpaEntity.getDatumCreatie())
                .withDatumLaatsteWijziging(dossierJpaEntity.getDatumLaatsteWijziging())
                .build();
    }

}
